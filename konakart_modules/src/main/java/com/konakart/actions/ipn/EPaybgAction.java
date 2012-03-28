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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.encoding.Base64;
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
 * from ePay Bulgaria.
 * 
 */

public class EPaybgAction extends BaseGatewayAction
{
    /**
     * The <code>Log</code> instance for this application.
     */
    protected Log log = LogFactory.getLog(EPaybgAction.class);

    // Module name must be the same as the class name although it can be all in lowercase in order
    // to remain compatible with osCommerce.
    private static String code = "epaybg";

    // ePay constants
    private static final String encoded = "encoded";

    private static final String checksum = "checksum";

    // Configuration constants for ePay
    private static final String MODULE_PAYMENT_EPAYBG_CALLBACK_USERNAME = "MODULE_PAYMENT_EPAYBG_CALLBACK_USERNAME";

    private static final String MODULE_PAYMENT_EPAYBG_CALLBACK_PASSWORD = "MODULE_PAYMENT_EPAYBG_CALLBACK_PASSWORD";

    private final static String MODULE_PAYMENT_EPAYBG_SECRET = "MODULE_PAYMENT_EPAYBG_SECRET";

    // Return codes and descriptions
    private static final int RET0 = 0;

    private static final String RET0_DESC = "Transaction OK";

    private static final int RET2 = -2;

    private static final String RET2_DESC = "The encoded data and/or the checksum are missing";

    private static final int RET3 = -3;

    private static final String RET3_DESC = "The checksum sent by ePay does not match the calculated checksum";

    private static final int RET4 = -4;

    private static final String RET4_DESC = "The encoded data sent by ePay could not be decoded. The data is : ";

    private static final int RET5 = -5;

    private static final String RET5_DESC = "The invoice number sent by ePay is not a number. It is : ";

    private static final int RET6 = -6;

    private static final String RET6_DESC = "There has been an unexpected exception. Please look at the log.";

    // Order history comments. These comments are associated with the order.
    private static final String ORDER_HISTORY_COMMENT_OK = "ePay payment successful. ePay status = ";

    private static final String ORDER_HISTORY_COMMENT_KO = "ePay payment not successful. ePay Status = ";

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
    @SuppressWarnings("unchecked")
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {

        String encoded = null, checksum = null, username = null, password = null, secretKey = null;

        // The response print writer used to send a response back to ePay
        PrintWriter pw = null;

        if (log.isDebugEnabled())
        {
            log.debug("*********** ePay Callback");
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
            // Get the PrintWriter from the response
            try
            {
                pw = response.getWriter();
                if (pw == null)
                {
                    throw new Exception();
                }
            } catch (IOException e2)
            {
                e2.printStackTrace();
                throw new Exception("Could not get a PrintWriter for the response");
            }

            // Get an instance of the KonaKart engine
            kkAppEng = this.getKKAppEng(request, response);

            // We get from configurations, the username and password used to log into the engine
            // in order to save the changes of the IPN
            username = kkAppEng.getConfig(MODULE_PAYMENT_EPAYBG_CALLBACK_USERNAME);
            password = kkAppEng.getConfig(MODULE_PAYMENT_EPAYBG_CALLBACK_PASSWORD);

            if (username == null || password == null)
            {
                throw new Exception(
                        "The callback username and password must be defined for the epaybg module by"
                                + " setting the configuration variables MODULE_PAYMENT_EPAYBG_CALLBACK_USERNAME"
                                + " and MODULE_PAYMENT_EPAYBG_CALLBACK_PASSWORD");
            }

            // We log into the engine to get a session.
            sessionId = kkAppEng.getEng().login(username, password);
            kkAppEng.setSessionId(sessionId);
            if (sessionId == null)
            {
                throw new Exception(
                        "The callback username and password must be defined for the epaybg module by"
                                + " setting the configuration variables MODULE_PAYMENT_EPAYBG_CALLBACK_USERNAME"
                                + " and MODULE_PAYMENT_EPAYBG_CALLBACK_PASSWORD");
            }

            // Get the secret key
            secretKey = kkAppEng.getConfig(MODULE_PAYMENT_EPAYBG_SECRET);
            if (secretKey == null)
            {
                throw new Exception(
                        "The Configuration MODULE_PAYMENT_EPAYBG_SECRET must be set to the secret key"
                                + " shared between the merchant and ePay)");
            }

            // See if we need to send an email, by looking at the configuration
            String sendEmailsConfig = kkAppEng.getConfig(ConfigConstants.SEND_EMAILS);
            boolean sendEmail = false;
            if (sendEmailsConfig != null && sendEmailsConfig.equalsIgnoreCase("true"))
            {
                sendEmail = true;
            }

            // Process the parameters sent in the callback
            if (log.isDebugEnabled())
            {
                log.debug("Callback Data :");
            }

            StringBuffer sb = new StringBuffer();
            String invoice = null, status = null, payTime = null, stan = null, bcode = null;
            if (request != null)
            {
                Enumeration en = request.getParameterNames();
                while (en.hasMoreElements())
                {
                    String paramName = (String) en.nextElement();
                    String paramValue = request.getParameter(paramName);

                    if (log.isDebugEnabled())
                    {
                        log.debug("ParamName = " + paramName + " ParamValue = " + paramValue);
                    }

                    if (sb.length() > 0)
                    {
                        sb.append("\n");
                    }
                    sb.append(paramName);
                    sb.append(" = ");
                    sb.append(paramValue);

                    // Capture important variables so that we can determine whether the
                    // transaction was successful or not
                    if (paramName != null)
                    {
                        if (paramName.equalsIgnoreCase(EPaybgAction.checksum))
                        {
                            checksum = paramValue;
                        } else if (paramName.equalsIgnoreCase(EPaybgAction.encoded))
                        {
                            encoded = paramValue;
                        }
                    }
                }

                // Save the data to the IpnHistory class
                ipnHistory.setGatewayFullResponse(sb.toString());

                if (encoded == null || checksum == null)
                {
                    ipnHistory.setKonakartResultDescription(RET2_DESC);
                    ipnHistory.setKonakartResultId(RET2);
                    kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
                    pw.print("ERR=" + RET2_DESC + "\n");
                    return null;
                }

                // Get a checksum for the data
                Mac sha = Mac.getInstance("HmacSHA1");
                sha.init(new SecretKeySpec(secretKey.getBytes(), "HmacSHA1"));

                byte[] mac = new byte[20];
                mac = sha.doFinal(encoded.getBytes());
                String calculatedChecksum = bytesToHex(mac);

                if (log.isDebugEnabled())
                {
                    log.debug("Calculated Checksum = " + calculatedChecksum);
                }

                // Check the checksum
                if (calculatedChecksum == null || !calculatedChecksum.equalsIgnoreCase(checksum))
                {
                    ipnHistory.setKonakartResultDescription(RET3_DESC);
                    ipnHistory.setKonakartResultId(RET3);
                    kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
                    pw.print("ERR=" + RET3_DESC + "\n");
                    return null;
                }

                // Decode the data
                String decoded = null;
                try
                {
                    byte[] decodedByteArray = Base64.decode(encoded);
                    decoded = new String(decodedByteArray);

                    if (log.isDebugEnabled())
                    {
                        log.debug("Decoded Data = \n" + decoded);
                    }
                } catch (Exception e)
                {
                    ipnHistory.setKonakartResultDescription(RET4_DESC + decoded);
                    ipnHistory.setKonakartResultId(RET4);
                    kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
                    pw.print("ERR=" + RET4_DESC + decoded + "\n");
                    return null;
                }

                // At this point we have decode the data sent by ePay and now we have to get the
                // parameters
                String[] parmArray = decoded.split(":");
                for (int i = 0; i < parmArray.length; i++)
                {
                    if (parmArray[i] != null)
                    {
                        String[] innerArray = parmArray[i].split("=");
                        if (innerArray.length == 2)
                        {
                            if (innerArray[0] != null && innerArray[0].equals("INVOICE"))
                            {
                                invoice = innerArray[1].trim();
                                sb.append("&");
                                sb.append("INVOICE=");
                                sb.append(invoice);
                            } else if (innerArray[0] != null && innerArray[0].equals("STATUS"))
                            {
                                status = innerArray[1].trim();
                                sb.append("&");
                                sb.append("STATUS=");
                                sb.append(status);
                                ipnHistory.setGatewayResult(status);
                            } else if (innerArray[0] != null && innerArray[0].equals("PAY_TIME"))
                            {
                                payTime = innerArray[1].trim();
                                sb.append("&");
                                sb.append("PAY_TIME=");
                                sb.append(payTime);
                            } else if (innerArray[0] != null && innerArray[0].equals("STAN"))
                            {
                                stan = innerArray[1].trim();
                                sb.append("&");
                                sb.append("STAN=");
                                sb.append(stan);
                            } else if (innerArray[0] != null && innerArray[0].equals("BCODE"))
                            {
                                bcode = innerArray[1].trim();
                                sb.append("&");
                                sb.append("BCODE=");
                                sb.append(bcode);
                            }
                        }
                    }
                }

                // Update the full response
                ipnHistory.setGatewayFullResponse(sb.toString());

                // Since we've verified the data with the secret key, the order number should be
                // equal to invoice
                int orderId;
                try
                {
                    if (invoice == null)
                    {
                        throw new Exception();
                    }
                    orderId = new Integer(invoice).intValue();
                    ipnHistory.setOrderId(orderId);
                } catch (Exception e)
                {
                    ipnHistory.setKonakartResultDescription(RET5_DESC + invoice);
                    ipnHistory.setKonakartResultId(RET5);
                    kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
                    pw.print("ERR=" + RET5_DESC + invoice + "\n");
                    return null;
                }

                // If successful, we update the inventory as well as changing the state of the
                // order.
                String comment = null;
                if (status != null && status.equalsIgnoreCase("PAID"))
                {
                    comment = ORDER_HISTORY_COMMENT_OK + status;
                    kkAppEng.getEng().changeOrderStatus(sessionId, orderId,
                            com.konakart.bl.OrderMgr.PAYMENT_RECEIVED_STATUS, sendEmail, comment);
                    // If the order payment was approved we update the inventory
                    kkAppEng.getEng().updateInventory(sessionId, orderId);
                    if (sendEmail)
                    {
                        sendOrderConfirmationMail(kkAppEng, orderId, /* success */true);
                    }
                } else
                {
                    comment = ORDER_HISTORY_COMMENT_KO + status;
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

            pw.print("INVOICE=" + invoice + ":STATUS=OK\n");
            return null;

        } catch (Exception e)
        {
            try
            {
                if (sessionId != null)
                {
                    ipnHistory.setKonakartResultDescription(RET6_DESC);
                    ipnHistory.setKonakartResultId(RET6);
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
            if (pw != null)
            {
                pw.print("ERR=" + RET6_DESC + "\n");
            }
            return null;
        }

    }

    /**
     * Converts the byte array into a hexadecimal string
     * 
     * @param b
     * @return Return a Hex String
     */
    private static String bytesToHex(byte[] b)
    {
        char hexDigit[] =
        { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < b.length; j++)
        {
            buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
            buf.append(hexDigit[b[j] & 0x0f]);
        }
        return buf.toString();
    }
}
