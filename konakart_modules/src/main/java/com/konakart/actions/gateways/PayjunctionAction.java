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

package com.konakart.actions.gateways;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.konakart.al.KKAppEng;
import com.konakart.app.IpnHistory;
import com.konakart.app.KKException;
import com.konakart.app.NameValue;
import com.konakart.appif.IpnHistoryIf;
import com.konakart.appif.NameValueIf;
import com.konakart.appif.OrderIf;
import com.konakart.appif.PaymentDetailsIf;
import com.konakart.bl.ConfigConstants;

/**
 * This class is an Action class for sending credit card details to PayJunction and receiving
 * confirmation
 */
public class PayjunctionAction extends BaseGatewayAction
{
    /**
     * The <code>Log</code> instance for this application.
     */
    protected Log log = LogFactory.getLog(PayjunctionAction.class);

    // Module name must be the same as the class name although it can be all in lower case in order
    // to remain compatible with osCommerce.
    private static String code = "payjunction";

    // Order history comments. These comments are associated with the order.
    private static final String ORDER_HISTORY_COMMENT_OK = "Payment successful. PayJunction Ref Number = ";

    private static final String ORDER_HISTORY_COMMENT_KO = "Payment not successful. PayJunction Reply = ";

    // IPN History Result IDs
    private static final int RESULT_APPROVED = 1;

    private static final String RESULT_APPROVED_DESC = "Approved";

    private static final int RESULT_DECLINED = 2;

    private static final String RESULT_DECLINED_DESC = "Transaction Declined";

    private static final int RESULT_UNKNOWN_GATEWAY_ERROR = -3;

    private static final String RESULT_UNKNOWN_GATEWAY_ERROR_DESC = "There was an unexpected Gateway Response.";

    private static final int RESULT_UNKNOWN_EXCEPTION = -4;

    private static final String RESULT_UNKNOWN_EXCEPTION_DESC = "There was an unexpected exception. Exception message = ";

    private final static String MODULE_PAYMENT_PAYJUNCTION_DEBUG_MODE = "MODULE_PAYMENT_PAYJUNCTION_DEBUG_MODE";

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
     * 
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        String errorDesc = null;
        String gatewayResult = null;
        String transactionId = null;

        if (log.isDebugEnabled())
        {
            log.debug("PayJunctionAction: code = " + code);
        }

        // Create these outside of try / catch since they are needed in the case of a general
        // exception
        IpnHistoryIf ipnHistory = new IpnHistory();
        ipnHistory.setModuleCode(code);
        KKAppEng kkAppEng = null;

        try
        {
            int custId;

            kkAppEng = this.getKKAppEng(request, response);

            boolean payJunctionDebugMode = false;
            String conf = kkAppEng.getConfig(MODULE_PAYMENT_PAYJUNCTION_DEBUG_MODE);
            if (conf != null && conf.equalsIgnoreCase("true"))
            {
                payJunctionDebugMode = true;
            }

            // Check to see whether the user is logged in
            custId = this.loggedIn(request, response, kkAppEng, "NotLoggedIn");
            if (custId < 0)
            {
                if (log.isDebugEnabled())
                {
                    log.debug("PayJunctionAction: NotLoggedIn");
                }
                return mapping.findForward(loginForward);
            }

            // Ensure we are using the correct protocol. Redirect if not.
            ActionForward redirForward = checkSSL(kkAppEng, request, custId, /* forceSSL */false);
            if (redirForward != null)
            {
                if (log.isDebugEnabled())
                {
                    log.debug("PayJunctionAction: Redirect SSL");
                }
                return redirForward;
            }

            // Get the order
            OrderIf order = kkAppEng.getOrderMgr().getCheckoutOrder();
            validateOrder(order, code);

            if (log.isDebugEnabled())
            {
                log.debug("PayJunctionAction: Order " + order.getId() + " validated");
            }

            // Set the order id for the ipnHistory object
            ipnHistory.setOrderId(order.getId());

            // Get the parameter list for the payment that have been set up earlier
            PaymentDetailsIf pd = order.getPaymentDetails();

            // Now make a second parameter list containing parameters we don't save
            List<NameValueIf> parmList = new ArrayList<NameValueIf>();

            parmList.add(new NameValue("dc_name", encode(pd.getCcOwner())));
            parmList.add(new NameValue("dc_number", encode(pd.getCcNumber())));
            parmList.add(new NameValue("dc_expiration_month", encode(pd.getCcExpiryMonth())));
            parmList.add(new NameValue("dc_expiration_year", encode(pd.getCcExpiryYear())));
            if (pd.isShowCVV())
            {
                parmList.add(new NameValue("dc_verification_number", encode(pd.getCcCVV())));
            }
            parmList.add(new NameValue("dc_address", encode(pd.getCcStreetAddress())));
            parmList.add(new NameValue("dc_zipcode", encode(pd.getCcPostcode())));
            parmList.add(new NameValue("dc_notes", encode("KonaKart OrderId = " + order.getId())));

            if (log.isDebugEnabled())
            {
                log.debug("PayJunctionAction: Post the payment details to the gateway");
            }

            // Do the post
            String gatewayResp = postData(pd, parmList);

            gatewayResp = URLDecoder.decode(gatewayResp, "UTF-8");
            if (log.isDebugEnabled())
            {
                log.debug("Unformatted GatewayResp = \n" + gatewayResp);
            }

            if (payJunctionDebugMode)
            {
                // Write the response to a file which is handy for diagnosing problems

                try
                {
                    String outputFilename = getLogFileDirectory(kkAppEng) + "payjunction_resp_"
                            + order.getId() + ".txt";
                    File myOutFile = new File(outputFilename);
                    if (log.isDebugEnabled())
                    {
                        log.debug("Write gateway response to " + myOutFile.getAbsolutePath());
                    }
                    BufferedWriter bw = new BufferedWriter(new FileWriter(myOutFile));
                    bw.write(gatewayResp);
                    bw.close();
                } catch (Exception e)
                {
                    // dump the exception and continue
                    e.printStackTrace();
                }
            }

            StringBuffer sb = new StringBuffer();
            HashMap<String, String> response_hash = new HashMap<String, String>();
            StringTokenizer st1 = new StringTokenizer(gatewayResp.toString(), new Character(
                    (char) 0x1C).toString());

            // process results so they are in an easy-to-access format
            while (st1.hasMoreTokens())
            {
                String key = null, value = null;

                StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "=");
                key = st2.nextToken();

                if (st2.hasMoreElements())
                {
                    value = st2.nextToken();
                }
                response_hash.put(key, value);
                if (log.isDebugEnabled())
                {
                    log.debug("Add to hash: " + key + " = " + value);
                }

                sb.append(key + " = " + value + "\n");
            }

            gatewayResult = response_hash.get("dc_response_code");
            transactionId = response_hash.get("dc_transaction_id");
            errorDesc = response_hash.get("dc_response_message");

            // Put the response in the ipnHistory record
            ipnHistory.setGatewayFullResponse(sb.toString());
            ipnHistory.setGatewayTransactionId(transactionId);
            ipnHistory.setGatewayResult(gatewayResult);

            if (log.isDebugEnabled())
            {
                log.debug("Response data:");
                log.debug(sb.toString());
            }

            // See if we need to send an email, by looking at the configuration
            String sendEmailsConfig = kkAppEng.getConfig(ConfigConstants.SEND_EMAILS);
            boolean sendEmail = false;
            if (sendEmailsConfig != null && sendEmailsConfig.equalsIgnoreCase("true"))
            {
                sendEmail = true;
            }

            // Determine whether the request was successful or not.If successful, we update the
            // inventory as well as changing the state of the order
            if (gatewayResult != null && (gatewayResult.equals("00") || gatewayResult.equals("85")))
            {
                String comment = ORDER_HISTORY_COMMENT_OK + transactionId;
                kkAppEng.getEng().changeOrderStatus(kkAppEng.getSessionId(), order.getId(),
                        com.konakart.bl.OrderMgr.PAYMENT_RECEIVED_STATUS, /* customerNotified */
                        sendEmail, comment);

                // Update the inventory
                kkAppEng.getOrderMgr().updateInventory(order.getId());

                // Save the ipnHistory
                ipnHistory.setKonakartResultDescription(RESULT_APPROVED_DESC + " (" + errorDesc
                        + ")");
                ipnHistory.setKonakartResultId(RESULT_APPROVED);
                ipnHistory.setOrderId(order.getId());
                ipnHistory.setCustomerId(kkAppEng.getCustomerMgr().getCurrentCustomer().getId());
                kkAppEng.getEng().saveIpnHistory(kkAppEng.getSessionId(), ipnHistory);

                // If we received no exceptions, delete the basket
                kkAppEng.getBasketMgr().emptyBasket();

                if (sendEmail)
                {
                    sendOrderConfirmationMail(kkAppEng, order.getId(), /* success */true);
                }

                return mapping.findForward("Approved");

            } else if (gatewayResult != null)
            {
                String comment = ORDER_HISTORY_COMMENT_KO + errorDesc;
                kkAppEng.getEng().changeOrderStatus(kkAppEng.getSessionId(), order.getId(),
                        com.konakart.bl.OrderMgr.PAYMENT_DECLINED_STATUS, /* customerNotified */
                        sendEmail, comment);

                // Save the ipnHistory
                ipnHistory.setKonakartResultDescription(RESULT_DECLINED_DESC + " (" + gatewayResult
                        + ") " + errorDesc);
                ipnHistory.setKonakartResultId(RESULT_DECLINED);
                ipnHistory.setCustomerId(kkAppEng.getCustomerMgr().getCurrentCustomer().getId());
                kkAppEng.getEng().saveIpnHistory(kkAppEng.getSessionId(), ipnHistory);

                if (sendEmail)
                {
                    sendOrderConfirmationMail(kkAppEng, order.getId(), /* success */false);
                }

                ActionMessages errors = new ActionMessages();
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "checkout.cc.gateway.error", errorDesc));
                this.saveErrors(request, errors);

                // Redirect the user back to the credit card screen
                return mapping.findForward("TryAgain");
            } else
            {
                /*
                 * We only get to here if there was an unknown response from the gateway
                 */
                String comment = RESULT_UNKNOWN_GATEWAY_ERROR_DESC;
                kkAppEng.getEng().changeOrderStatus(kkAppEng.getSessionId(), order.getId(),
                        com.konakart.bl.OrderMgr.PAYMENT_DECLINED_STATUS, /* customerNotified */
                        sendEmail, comment);

                // Save the ipnHistory
                ipnHistory.setKonakartResultDescription(RESULT_UNKNOWN_GATEWAY_ERROR_DESC);
                ipnHistory.setKonakartResultId(RESULT_UNKNOWN_GATEWAY_ERROR);
                ipnHistory.setCustomerId(kkAppEng.getCustomerMgr().getCurrentCustomer().getId());
                kkAppEng.getEng().saveIpnHistory(kkAppEng.getSessionId(), ipnHistory);

                if (sendEmail)
                {
                    sendOrderConfirmationMail(kkAppEng, order.getId(), /* success */false);
                }

                ActionMessages errors = new ActionMessages();
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "checkout.cc.gateway.error", "?"));
                this.saveErrors(request, errors);

                // Redirect the user back to the credit card screen
                return mapping.findForward("TryAgain");
            }
        } catch (Exception e)
        {
            try
            {
                if (kkAppEng != null)
                {
                    ipnHistory.setKonakartResultDescription(RESULT_UNKNOWN_EXCEPTION_DESC
                            + e.getMessage());
                    ipnHistory.setKonakartResultId(RESULT_UNKNOWN_EXCEPTION);
                    ipnHistory
                            .setCustomerId(kkAppEng.getCustomerMgr().getCurrentCustomer().getId());
                    ipnHistory.setGatewayResult(e.toString());
                    kkAppEng.getEng().saveIpnHistory(kkAppEng.getSessionId(), ipnHistory);
                }
                if (log.isWarnEnabled())
                {
                    log.warn("Exception communicating with PayJunction");
                    e.printStackTrace();
                }
            } catch (KKException e1)
            {
                return mapping.findForward(super.handleException(request, e1));
            }
            return mapping.findForward(super.handleException(request, e));
        }
    }

    /**
     * URL-Encodes a value
     * 
     * @param value
     *            Value to be URL-encoded
     * @return URL-encoded value
     */
    private String encode(String value)
    {
        try
        {
            // return URL encoded string
            if (value != null && value.length() > 1)
            {
                return URLEncoder.encode(value, "UTF-8");
            }
        } catch (Exception e)
        {
            log.warn("Error URL-encoding '" + value + "' : " + e);
        }
        return "";
    }
}
