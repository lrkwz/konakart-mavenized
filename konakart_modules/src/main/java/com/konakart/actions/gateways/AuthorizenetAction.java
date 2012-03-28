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

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

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
 * This class is an Action class for sending credit card details to Authorize.net and receiving
 * confirmation 
 */
public class AuthorizenetAction extends BaseGatewayAction
{
    /**
     * The <code>Log</code> instance for this application.
     */
    protected Log log = LogFactory.getLog(AuthorizenetAction.class);

    // Module name must be the same as the class name although it can be all in lowercase in order
    // to remain compatible with osCommerce.
    private static String code = "authorizenet";

    // Authorize.net constants for request

    private static final String x_card_num = "x_card_num";

    private static final String x_exp_date = "x_exp_date";

    private static final String x_card_code = "x_card_code";

    // Authorize.net constants for response
    private static final int respCodePosition = 1;

    private static final int respTextPosition = 4;

    private static final int txnIdPosition = 7;

    private static final String approved = "1";

    private static final String declined = "2";

    private static final String error = "3";

    // Return codes and descriptions
    private static final int RET0 = 0;

    private static final String RET0_DESC = "Transaction OK";

    private static final int RET1 = -1;

    private static final String RET1_DESC = "There was an unexpected Gateway Response. Response = ";

    private static final int RET4 = -4;

    private static final String RET4_DESC = "There was an unexpected exception. Exception message = ";

    // Order history comments. These comments are associated with the order.
    private static final String ORDER_HISTORY_COMMENT_OK = "Authorize.net payment successful. Authorize.net TransactionId = ";

    private static final String ORDER_HISTORY_COMMENT_KO = "Authorize.net payment not successful. Authorize.net Reply = ";

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

        // Create these outside of try / catch since they are needed in the case of a general
        // exception
        IpnHistoryIf ipnHistory = new IpnHistory();
        ipnHistory.setModuleCode(code);
        KKAppEng kkAppEng = null;

        try
        {
            int custId;

            kkAppEng = this.getKKAppEng(request, response);

            custId = this.loggedIn(request, response, kkAppEng, "NotLoggedIn");

            // Check to see whether the user is logged in
            if (custId < 0)
            {
                return mapping.findForward(loginForward);
            }

            // Ensure we are using the correct protocol. Redirect if not.
            ActionForward redirForward = checkSSL(kkAppEng, request, custId, /* forceSSL */false);
            if (redirForward != null)
            {
                return redirForward;
            }

            // Get the order
            OrderIf order = kkAppEng.getOrderMgr().getCheckoutOrder();
            validateOrder(order, code);

            // Set the order id for the ipnHistory object
            ipnHistory.setOrderId(order.getId());

            // Create a parameter list for the credit card details.
            PaymentDetailsIf pd = order.getPaymentDetails();

            List<NameValueIf> parmList = new ArrayList<NameValueIf>();
            parmList.add(new NameValue(x_card_num, pd.getCcNumber()));
            if (pd.isShowCVV())
            {
                parmList.add(new NameValue(x_card_code, pd.getCcCVV()));
            }
            parmList.add(new NameValue(x_exp_date, pd.getCcExpiryMonth() + pd.getCcExpiryYear()));

            // Do the post
            String gatewayResp = postData(pd, parmList);

            gatewayResp = URLDecoder.decode(gatewayResp, "UTF-8");
            if (log.isDebugEnabled())
            {
                log.debug("Unformatted GatewayResp = \n" + gatewayResp);
            }

            // Process the parameters sent in the callback
            StringBuffer sb = new StringBuffer();
            String[] parms = gatewayResp.split(",");
            if (parms != null)
            {
                for (int i = 0; i < parms.length; i++)
                {
                    String parm = parms[i];
                    sb.append(getRespDesc(i + 1));
                    sb.append("=");
                    sb.append(parm);
                    sb.append("\n");

                    if (i + 1 == respTextPosition)
                    {
                        errorDesc = parm;
                    } else if (i + 1 == respCodePosition)
                    {
                        gatewayResult = parm;
                        ipnHistory.setGatewayResult(parm);
                    } else if (i + 1 == txnIdPosition)
                    {
                        ipnHistory.setGatewayTransactionId(parm);
                        transactionId = parm;
                    }
                }
            }

            // Put the response in the ipnHistory record
            ipnHistory.setGatewayFullResponse(sb.toString());

            if (log.isDebugEnabled())
            {
                log.debug("Formatted Authorize.net response data:");
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
            if (gatewayResult != null && gatewayResult.equals(approved))
            {

                String comment = ORDER_HISTORY_COMMENT_OK + transactionId;
                kkAppEng.getEng().changeOrderStatus(kkAppEng.getSessionId(), order.getId(),
                        com.konakart.bl.OrderMgr.PAYMENT_RECEIVED_STATUS, /* customerNotified */
                        sendEmail, comment);

                // Update the inventory
                kkAppEng.getOrderMgr().updateInventory(order.getId());

                // Save the ipnHistory
                ipnHistory.setKonakartResultDescription(RET0_DESC);
                ipnHistory.setKonakartResultId(RET0);
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

            } else if (gatewayResult != null
                    && (gatewayResult.equals(declined) || gatewayResult.equals(error)))
            {
                String comment = ORDER_HISTORY_COMMENT_KO + errorDesc;
                kkAppEng.getEng().changeOrderStatus(kkAppEng.getSessionId(), order.getId(),
                        com.konakart.bl.OrderMgr.PAYMENT_DECLINED_STATUS, /* customerNotified */
                        sendEmail, comment);

                // Save the ipnHistory
                ipnHistory.setKonakartResultDescription(RET0_DESC);
                ipnHistory.setKonakartResultId(RET0);
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
                String comment = RET1_DESC + gatewayResult;
                kkAppEng.getEng().changeOrderStatus(kkAppEng.getSessionId(), order.getId(),
                        com.konakart.bl.OrderMgr.PAYMENT_DECLINED_STATUS, /* customerNotified */
                        sendEmail, comment);

                // Save the ipnHistory
                ipnHistory.setKonakartResultDescription(RET1_DESC + gatewayResult);
                ipnHistory.setKonakartResultId(RET1);
                ipnHistory.setCustomerId(kkAppEng.getCustomerMgr().getCurrentCustomer().getId());
                kkAppEng.getEng().saveIpnHistory(kkAppEng.getSessionId(), ipnHistory);

                if (sendEmail)
                {
                    sendOrderConfirmationMail(kkAppEng, order.getId(), /* success */false);
                }

                ActionMessages errors = new ActionMessages();
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "checkout.cc.gateway.error", RET1_DESC + gatewayResult));
                this.saveErrors(request, errors);

                // Redirect the user back to the credit card screen
                return mapping.findForward("TryAgain");
            }

        } catch (Exception e)
        {
            try
            {
                ipnHistory.setKonakartResultDescription(RET4_DESC + e.getMessage());
                ipnHistory.setKonakartResultId(RET4);
                if (kkAppEng != null)
                {
                    kkAppEng.getEng().saveIpnHistory(kkAppEng.getSessionId(), ipnHistory);
                }
            } catch (KKException e1)
            {
                return mapping.findForward(super.handleException(request, e1));
            }
            return mapping.findForward(super.handleException(request, e));
        }

    }

    /**
     * Authorize.net returns a response as delimiter separated variables. In order to make them
     * readable, we tag each one with a desscription before saving in the ipnHistory table.
     * 
     * @param position
     * @return Response Description
     */
    private String getRespDesc(int position)
    {
        String ret = "unknown";
        switch (position)
        {
        case 1:
            ret = "Response Code";
            break;
        case 2:
            ret = "Response Subcode";
            break;
        case 3:
            ret = "Response Reason Code";
            break;
        case 4:
            ret = "Response Reason Text";
            break;
        case 5:
            ret = "Approval Code";
            break;
        case 6:
            ret = "AVS Result Code";
            break;
        case 7:
            ret = "Transaction ID";
            break;
        case 8:
            ret = "Invoice Number";
            break;
        case 9:
            ret = "Description";
            break;
        case 10:
            ret = "Amount";
            break;
        case 11:
            ret = "Method";
            break;
        case 12:
            ret = "Transaction Type";
            break;
        case 13:
            ret = "Customer ID";
            break;
        case 14:
            ret = "Cardholder First Name";
            break;
        case 15:
            ret = "Cardholder Last Name";
            break;
        case 16:
            ret = "Company";
            break;
        case 17:
            ret = "Billing Address";
            break;
        case 18:
            ret = "City";
            break;
        case 19:
            ret = "State";
            break;
        case 20:
            ret = "Zip";
            break;
        case 21:
            ret = "Country";
            break;
        case 22:
            ret = "Phone";
            break;
        case 23:
            ret = "Fax";
            break;
        case 24:
            ret = "Email";
            break;
        case 25:
            ret = "Ship to First Name";
            break;
        case 26:
            ret = "Ship to Last Name";
            break;
        case 27:
            ret = "Ship to Company";
            break;
        case 28:
            ret = "Ship to Address";
            break;
        case 29:
            ret = "Ship to City";
            break;
        case 30:
            ret = "Ship to State";
            break;
        case 31:
            ret = "Ship to Zip";
            break;
        case 32:
            ret = "Ship to Country";
            break;
        case 33:
            ret = "Tax Amount";
            break;
        case 34:
            ret = "Duty Amount";
            break;
        case 35:
            ret = "Freight Amount";
            break;
        case 36:
            ret = "Tax Exempt Flag";
            break;
        case 37:
            ret = "PO Number";
            break;
        case 38:
            ret = "MD5 Hash";
            break;
        case 39:
            ret = "(CVV2/CVC2/CID)Response Code";
            break;
        case 40:
            ret = "(CAVV) Response Code";
            break;
        default:
            break;
        }

        return ret;
    }
}
