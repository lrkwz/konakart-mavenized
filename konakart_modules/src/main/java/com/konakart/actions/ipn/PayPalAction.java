//
// (c) 2006 DS Data Systems UK Ltd, All rights reserved.
//
// DS Data Systems and KonaKart and their respective logos, are 
// trademarks of DS Data Systems UK Ltd. All rights reserved.
//
// The information in this document is free software; you can redistribute 
// it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This software is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//

package com.konakart.actions.ipn;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.konakart.actions.gateways.BaseGatewayAction;
import com.konakart.al.KKAppEng;
import com.konakart.app.IpnHistory;
import com.konakart.app.KKException;
import com.konakart.appif.IpnHistoryIf;
import com.konakart.bl.ConfigConstants;

/**
 * This class is an Action class for what to do when a payment notification callback is received
 * from PayPal.
 */
public class PayPalAction extends BaseGatewayAction
{
    /**
     * The <code>Log</code> instance for this application.
     */
    protected Log log = LogFactory.getLog(PayPalAction.class);

    // Module name must be the same as the class name although it can be all in lowercase in order
    // to remain compatible with osCommerce.
    private static String code = "paypal";

    // PayPal constants
    private static final String custom = "custom";

    private static final String payment_status = "payment_status";

    private static final String txn_id = "txn_id";

    private static final String completed = "Completed";

    // Configuaration constants for PayPal
    private static final String MODULE_PAYMENT_PAYPAL_CALLBACK_USERNAME = "MODULE_PAYMENT_PAYPAL_CALLBACK_USERNAME";

    private static final String MODULE_PAYMENT_PAYPAL_CALLBACK_PASSWORD = "MODULE_PAYMENT_PAYPAL_CALLBACK_PASSWORD";

    // Return codes and descriptions
    private static final int RET0 = 0;

    private static final String RET0_DESC = "Transaction OK";

    private static final int RET2 = -2;

    private static final String RET2_DESC = "We were not sent the secret key";

    private static final int RET3 = -3;

    private static final String RET3_DESC = "We could not retrieve the order id from the secret key";

    private static final int RET4 = -4;

    private static final String RET4_DESC = "There has been an unexpected exception. Please look at the log.";

    // Order history comments. These comments are associated with the order.
    private static final String ORDER_HISTORY_COMMENT_OK = "PayPal payment successful. PayPal TransactionId = ";

    private static final String ORDER_HISTORY_COMMENT_KO = "PayPal payment not successful. PayPal Payment Status = ";

    /**
     * 
     * @param mapping
     *            The ActionMapping used to select this instance
     * @param form
     *            The optional ActionForm bean for this request (if any)
     * @param request
     *            The HTTP request we are processing
     * @param response
     *            The HTTP response we are creating
     */
    @SuppressWarnings("unchecked")
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {

        String secretKey = null, paymentStatus = null, txnId = null, username = null, password = null;

        if (log.isDebugEnabled())
        {
            log.debug("*********** PayPal Callback");
        }

        // Create thes outside of try / catch since they are needed in the case of a general
        // exception
        IpnHistoryIf ipnHistory = new IpnHistory();
        ipnHistory.setOrderId(-1);
        ipnHistory.setModuleCode(code);

        String sessionId = null;

        KKAppEng kkAppEng = null;

        try
        {
            // Get an instance of the KonaKart engine
            kkAppEng = this.getKKAppEng(request, response);

            // We get from configurations, the username and password used to log into the engine in
            // order to save the changes of the IPN
            username = kkAppEng.getConfig(MODULE_PAYMENT_PAYPAL_CALLBACK_USERNAME);
            password = kkAppEng.getConfig(MODULE_PAYMENT_PAYPAL_CALLBACK_PASSWORD);

            if (username == null || password == null)
            {
                throw new Exception(
                        "The callback username and password must be defined for the PayPal module by"
                                + " setting the configuration variables MODULE_PAYMENT_PAYPAL_CALLBACK_USERNAME"
                                + " and MODULE_PAYMENT_PAYPAL_CALLBACK_PASSWORD");
            }

            // We log into the engine to get a session.
            sessionId = kkAppEng.getEng().login(username, password);
            kkAppEng.setSessionId(sessionId);

            if (sessionId == null)
            {
                if (log.isWarnEnabled())
                {
                    log.warn("Failed to login user: " + username);
                }
            }

            // See if we need to send an email, by looking at the configuration
            String sendEmailsConfig = kkAppEng.getConfig(ConfigConstants.SEND_EMAILS);
            boolean sendEmail = false;
            if (sendEmailsConfig != null && sendEmailsConfig.equalsIgnoreCase("true"))
            {
                sendEmail = true;
            }

            // Process the parameters sent in the callback
            StringBuffer sb = new StringBuffer();
            if (request != null)
            {
                Enumeration en = request.getParameterNames();
                while (en.hasMoreElements())
                {
                    String paramName = (String) en.nextElement();
                    String paramValue = request.getParameter(paramName);
                    if (sb.length() > 0)
                    {
                        sb.append("\n");
                    }
                    sb.append(paramName);
                    sb.append(" = ");
                    sb.append(paramValue);

                    // Capture important variables so that we can determine whether the transaction
                    // was successful or not
                    if (paramName != null)
                    {
                        if (paramName.equalsIgnoreCase(PayPalAction.custom))
                        {
                            secretKey = paramValue;
                        } else if (paramName.equalsIgnoreCase(PayPalAction.payment_status))
                        {
                            paymentStatus = paramValue;
                        } else if (paramName.equalsIgnoreCase(PayPalAction.txn_id))
                        {
                            txnId = paramValue;
                        }
                    }
                }

                if (log.isDebugEnabled())
                {
                    log.debug("PayPal CallBack data:");
                    log.debug(sb.toString());
                }

                // Fill more details of the IPN history class
                ipnHistory.setGatewayResult(paymentStatus);
                ipnHistory.setGatewayFullResponse(sb.toString());
                ipnHistory.setGatewayTransactionId(txnId);

                // We save all of this data in the database to keep a record of the
                // callback
                if (secretKey == null)
                {
                    ipnHistory.setKonakartResultDescription(RET2_DESC);
                    ipnHistory.setKonakartResultId(RET2);
                    kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
                    return null;
                }
                /*
                 * Get the order associated with the secret key. The secret key was sent to PayPal
                 * during the original post in the "custom" parameter. It is associated to an order
                 * and is a safe way of determining that the call back from PayPal is genuine as
                 * long as the callback is SSL.
                 */
                int orderId = kkAppEng.getEng().getOrderIdFromSecretKey(secretKey);
                if (orderId < 0)
                {
                    ipnHistory.setKonakartResultDescription(RET3_DESC);
                    ipnHistory.setKonakartResultId(RET3);
                    kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
                    return null;
                }
                ipnHistory.setOrderId(orderId);

                // If successful, we update the inventory as well as changing the state of the
                // order.
                String comment = null;
                if (paymentStatus != null && paymentStatus.equalsIgnoreCase(completed))
                {
                    comment = ORDER_HISTORY_COMMENT_OK + txnId;
                    kkAppEng.getEng().changeOrderStatus(sessionId, orderId,
                            com.konakart.bl.OrderMgr.PAYMENT_RECEIVED_STATUS, sendEmail, comment);
                    // If the order payment was approved we update the inventory
                    kkAppEng.getEng().updateInventory(sessionId, orderId);
                    // If we expect no more communication from PayPal for this order we can delete
                    // the SecretKey
                    kkAppEng.getEng().deleteOrderIdForSecretKey(secretKey);
                    if (sendEmail)
                    {
                        sendOrderConfirmationMail(kkAppEng, orderId, /* success */true);
                    }
                } else
                {
                    comment = ORDER_HISTORY_COMMENT_KO + paymentStatus;
                    kkAppEng.getEng().changeOrderStatus(sessionId, orderId,
                            com.konakart.bl.OrderMgr.PAYMENT_DECLINED_STATUS, sendEmail, comment);
                    if (sendEmail)
                    {
                        sendOrderConfirmationMail(kkAppEng, orderId, /* success */false);
                    }
                }

                ipnHistory.setKonakartResultDescription(RET0_DESC);
                ipnHistory.setKonakartResultId(RET0);
                kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
            }

            return null;

        } catch (Exception e)
        {
            try
            {
                if (sessionId != null)
                {
                    ipnHistory.setKonakartResultDescription(RET4_DESC);
                    ipnHistory.setKonakartResultId(RET4);
                    if (kkAppEng != null)
                    {
                        kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
                    }
                }
            } catch (KKException e1)
            {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return null;
        }
    }
}
