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
// Original version contributed by Chris Derham (Atomus Ltd)
//

package com.konakart.actions.ipn;

import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.konakart.actions.gateways.BaseGatewayAction;
import com.konakart.app.EngineConfig;
import com.konakart.app.IpnHistory;
import com.konakart.app.KKEng;
import com.konakart.app.KKException;
import com.konakart.appif.EngineConfigIf;
import com.konakart.appif.IpnHistoryIf;
import com.konakart.appif.KKEngIf;
import com.konakart.bl.ConfigConstants;
import com.konakart.bl.modules.payment.barclaycardsmartpayhosted.BarclaycardSmartPayHosted;

/**
 * This class is an Action class for what to do when a payment notification callback is received
 * from Barclaycard SmartPay Hosted.
 */
public class BarclaycardSmartPayHostedNotificationAction extends BaseGatewayAction
{
    /**
     * The <code>Log</code> instance for this application.
     */
    protected Log log = LogFactory.getLog(BarclaycardSmartPayHostedNotificationAction.class);

    // Configuration constants for BarclaycardSmartPayHosted
    private static final String MODULE_PAYMENT_BC_SPAY_HOSTED_CALLBACK_USERNAME = "MODULE_PAYMENT_BC_SPAY_HOSTED_CALLBACK_USERNAME";

    private static final String MODULE_PAYMENT_BC_SPAY_HOSTED_CALLBACK_PASSWORD = "MODULE_PAYMENT_BC_SPAY_HOSTED_CALLBACK_PASSWORD";

    private static final String MODULE_PAYMENT_BC_SPAY_HOSTED_HTTP_AUTH = "MODULE_PAYMENT_BC_SPAY_HOSTED_HTTP_AUTH";

    private static final String MODULE_PAYMENT_BC_SPAY_HOSTED_HTTP_USERNAME = "MODULE_PAYMENT_BC_SPAY_HOSTED_HTTP_USERNAME";

    private static final String MODULE_PAYMENT_BC_SPAY_HOSTED_HTTP_PASSWORD = "MODULE_PAYMENT_BC_SPAY_HOSTED_HTTP_PASSWORD";

    private static final String MODULE_PAYMENT_BC_SPAY_HOSTED_HMAC_KEY = "MODULE_PAYMENT_BC_SPAY_HOSTED_HMAC_KEY";

    private static final String MODULE_PAYMENT_BC_SPAY_HOSTED_STATUS = "MODULE_PAYMENT_BC_SPAY_HOSTED_STATUS";

    // Return codes and descriptions
    private static final int RET0 = 0;

    private static final String RET0_DESC = "Transaction OK";

    private static final int RET2 = -2;

    private static final String RET2_DESC = "HTTP Authentication Failed";

    private static final int RET3 = -3;

    private static final String RET3_DESC = "Unable to obtain order number";

    private static final int RET4 = -4;

    private static final String RET4_DESC = "There has been an unexpected exception. Please look at the log.";

    // Order history comments. These comments are associated with the order.
    private static final String ORDER_HISTORY_COMMENT_OK = "Barclaycard SmartPay Hosted payment successful. Reference: ";

    private static final String ORDER_HISTORY_COMMENT_KO = "Barclaycard SmartPay Hosted payment not successful. Reason: ";

    /**
     * @param mapping
     *            The ActionMapping used to select this instance
     * @param form
     *            The optional ActionForm bean for this request (if any)
     * @param request
     *            The HTTP request we are processing
     * @param response
     *            The HTTP response we are creating
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
    {
        String username;
        String password;
        String httpAuthStr = null;
        String httpUsername;
        String httpPassword;
        String pspReference = null;
        String merchantReference = null;
        String merchantAccountCode = null;
        String eventDate = null;
        String successString = null;
        boolean success = false;
        String paymentMethod = null;
        String hmacKey = null;
        String value = null;
        String currency = null;
        String reason = null;

        String eventCode = null;
        // String mbCurrency = null;
        String status = null;
        // String md5sig = null;
        // String orderIdString = null;

        String sessionId = null;
        KKEngIf kkEngine = null;

        if (log.isDebugEnabled())
        {
            log.debug(BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE
                    + " Notification Action");
        }

        // Create these outside of try / catch since they are needed in the case of a general
        // exception
        IpnHistoryIf ipnHistory = new IpnHistory();
        ipnHistory.setOrderId(-1);
        ipnHistory.setModuleCode(BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE);

        try
        {
            // Process the parameters sent in the callback
            StringBuffer sb = new StringBuffer();
            if (request != null)
            {
                @SuppressWarnings("unchecked")
                Enumeration<String> en = request.getParameterNames();
                while (en.hasMoreElements())
                {
                    String paramName = en.nextElement();
                    String paramValue = request.getParameter(paramName);
                    if (sb.length() > 0)
                    {
                        sb.append("\n");
                    }
                    sb.append(paramName);
                    sb.append(" = ");
                    sb.append(paramValue);

                    // Capture important variables so that we can determine whether the transaction
                    // was successful
                    if (paramName != null)
                    {
                        if (paramName.equalsIgnoreCase("eventCode"))
                        {
                            eventCode = paramValue;
                        } else if (paramName.equalsIgnoreCase("pspReference"))
                        {
                            pspReference = paramValue;
                        } else if (paramName.equalsIgnoreCase("merchantReference"))
                        {
                            merchantReference = paramValue;
                        } else if (paramName.equalsIgnoreCase("merchantAccountCode"))
                        {
                            merchantAccountCode = paramValue;
                        } else if (paramName.equalsIgnoreCase("eventDate"))
                        {
                            eventDate = paramValue;
                        } else if (paramName.equalsIgnoreCase("success"))
                        {
                            successString = paramValue;
                            success = Boolean.valueOf(successString);
                        } else if (paramName.equalsIgnoreCase("paymentMethod"))
                        {
                            paymentMethod = paramValue;
                        } else if (paramName.equalsIgnoreCase("value"))
                        {
                            value = paramValue;
                        } else if (paramName.equalsIgnoreCase("currency"))
                        {
                            currency = paramValue;
                        } else if (paramName.equalsIgnoreCase("reason"))
                        {
                            reason = paramValue;
                        }
                    }
                }
            }

            if (log.isDebugEnabled())
            {
                log.debug(BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE
                        + " Raw Notification Data:\n" + sb.toString());
                log.debug("\n    merchantAccountCode       = " + merchantAccountCode + "\n"
                        + "    eventCode                 = " + eventCode + "\n"
                        + "    eventDate                 = " + eventDate + "\n"
                        + "    merchantReference         = " + merchantReference + "\n"
                        + "    pspReference              = " + pspReference + "\n"
                        + "    paymentMethod             = " + paymentMethod + "\n"
                        + "    amount                    = " + value + "\n"
                        + "    currency                  = " + currency + "\n"
                        + "    success                   = " + successString + "\n"
                        + "    reason                    = " + reason);
            }

            // If we didn't receive an eventCode, we log a warning and return
            if (eventCode == null)
            {
                log.warn("No eventCode returned by "
                        + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE);
                return null;
            }

            status = eventCode;
            if (eventCode.equals("AUTHORISATION"))
            {
                if (success)
                {
                    status += " successful";
                } else
                {
                    status += " unsuccessful";
                }
            }

            // Fill more details of the IPN history class
            ipnHistory.setGatewayResult(status);
            ipnHistory.setGatewayFullResponse(sb.toString());
            ipnHistory.setGatewayTransactionId(pspReference);

            // We save all of this data in the database to keep a record of the callback

            // Split the merchantReference into orderId, orderNumber and store information
            StringTokenizer st = new StringTokenizer(merchantReference, "~");
            int orderId = -1;
            String orderNumberStr = null;
            String storeId = null;
            int engineMode = -1;
            boolean customersShared = false;
            boolean productsShared = false;
            String countryCode = null;

            if (st.hasMoreTokens())
            {
                orderId = Integer.parseInt(st.nextToken());
            }
            if (st.hasMoreTokens())
            {
                orderNumberStr = st.nextToken();
            }
            if (st.hasMoreTokens())
            {
                storeId = st.nextToken();
            }
            if (st.hasMoreTokens())
            {
                engineMode = Integer.parseInt(st.nextToken());
            }
            if (st.hasMoreTokens())
            {
                customersShared = Boolean.getBoolean(st.nextToken());
            }
            if (st.hasMoreTokens())
            {
                productsShared = Boolean.getBoolean(st.nextToken());
            }
            if (st.hasMoreTokens())
            {
                countryCode = st.nextToken();
            }

            if (log.isDebugEnabled())
            {
                log.debug("Derived from merchantReference:         \n"
                        + "    OrderId                   = " + orderId + "\n"
                        + "    OrderNumber               = " + orderNumberStr + "\n"
                        + "    StoreId                   = " + storeId + "\n"
                        + "    EngineMode                = " + engineMode + "\n"
                        + "    CustomersShared           = " + customersShared + "\n"
                        + "    ProductsShared            = " + productsShared + "\n"
                        + "    CountryCode               = " + countryCode);
            }

            if (orderId == -1)
            {
                log.warn("OrderId not returned in the "
                        + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE + " response");
            }

            if (engineMode == -1)
            {
                log.warn("EngineMode not returned in the "
                        + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE + " response");
            }

            if (countryCode == null)
            {
                log.warn("CountryCode not returned in the "
                        + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE + " response");
            }

            ipnHistory.setOrderId(orderId);

            // Get a KonaKart engine

            EngineConfigIf engineConfig = new EngineConfig();
            engineConfig.setCustomersShared(customersShared);
            engineConfig.setProductsShared(productsShared);
            engineConfig.setMode(engineMode);
            engineConfig.setStoreId(storeId);
            kkEngine = new KKEng(engineConfig);

            boolean enabled = kkEngine.getConfigurationValueAsBool(
                    MODULE_PAYMENT_BC_SPAY_HOSTED_STATUS, false);
            if (!enabled)
            {
                throw new Exception("The " + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE
                        + " module isn't enabled but we just received a notification message");
            }

            // We get from configurations, the username and password used to log into the engine
            // in order to save the changes of the IPN
            username = kkEngine
                    .getConfigurationValue(MODULE_PAYMENT_BC_SPAY_HOSTED_CALLBACK_USERNAME);
            password = kkEngine
                    .getConfigurationValue(MODULE_PAYMENT_BC_SPAY_HOSTED_CALLBACK_PASSWORD);

            if (username == null || password == null)
            {
                throw new Exception(
                        "The callback username and password must be defined for the "
                                + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE
                                + " module by"
                                + " setting the configuration variables MODULE_PAYMENT_BC_SPAY_HOSTED_CALLBACK_USERNAME"
                                + " and MODULE_PAYMENT_BC_SPAY_HOSTED_CALLBACK_PASSWORD");
            }

            hmacKey = kkEngine.getConfigurationValue(MODULE_PAYMENT_BC_SPAY_HOSTED_HMAC_KEY);

            if (hmacKey == null)
            {
                throw new Exception(
                        "The HMAC key must be defined for the "
                                + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE
                                + " module by"
                                + " setting the configuration variable MODULE_PAYMENT_BC_SPAY_HOSTED_HMAC_KEY");
            }

            // We log into the engine to get a session.
            sessionId = kkEngine.login(username, password);

            if (sessionId == null)
            {
                if (log.isWarnEnabled())
                {
                    log.warn("Failed to login user: " + username);
                }
            }

            // See if we need to send an email, by looking at the configuration
            boolean sendEmail = kkEngine.getConfigurationValueAsBool(ConfigConstants.SEND_EMAILS,
                    false);

            // Do HTTP Authentication if required
            httpAuthStr = kkEngine.getConfigurationValue(MODULE_PAYMENT_BC_SPAY_HOSTED_HTTP_AUTH);
            if (httpAuthStr != null && Boolean.valueOf(httpAuthStr))
            {
                // Get Authorization header
                String auth = null;

                if (request != null)
                {
                    auth = request.getHeader("Authorization");
                }

                httpUsername = kkEngine
                        .getConfigurationValue(MODULE_PAYMENT_BC_SPAY_HOSTED_HTTP_USERNAME);
                httpPassword = kkEngine
                        .getConfigurationValue(MODULE_PAYMENT_BC_SPAY_HOSTED_HTTP_PASSWORD);

                // Do we allow that user?
                if (!allowUser(auth, httpUsername, httpPassword))
                {
                    // Not allowed, so return "unauthorized"
                    response.setContentType("text/plain");
                    response.setHeader("WWW-Authenticate", "BASIC realm=\"Protected Page\"");
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    log.warn("Notification from "
                            + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE
                            + " could not be Authenticated");

                    ipnHistory.setKonakartResultDescription(RET2_DESC);
                    ipnHistory.setKonakartResultId(RET2);
                    kkEngine.saveIpnHistory(sessionId, ipnHistory);
                    return null;
                }
            }

            if (log.isDebugEnabled())
            {
                log.debug("Accept Notification for "
                        + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE);
            }

            // We always accept the Notification if we get this far
            response.setContentType("text/plain");
            response.getWriter().print("[accepted]\n");

            if (orderId < 0)
            {
                ipnHistory.setKonakartResultDescription(RET3_DESC);
                ipnHistory.setKonakartResultId(RET3);
                kkEngine.saveIpnHistory(sessionId, ipnHistory);
                return null;
            }

            // If it's not an AUTHORISATION event, we just throw it away
            if (!eventCode.equals("AUTHORISATION"))
            {
                if (log.isInfoEnabled())
                {
                    log.info("'" + eventCode + "' notification sent from "
                            + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE + " discarded");
                }
                return null;
            }

            // If we're about to set the order status to the current value we'll assume this is a
            // duplicate Notification from Barclaycard and not do any updates

            int currentOrderStatus = kkEngine.getOrderStatus(sessionId, orderId);

            if (log.isDebugEnabled())
            {
                log.debug("currentOrderStatus for orderId "+ orderId + " = " + currentOrderStatus);
            }

            if ((success && currentOrderStatus == com.konakart.bl.OrderMgr.PAYMENT_RECEIVED_STATUS)
                    || (!success && currentOrderStatus == com.konakart.bl.OrderMgr.PAYMENT_DECLINED_STATUS))
            {
                if (log.isDebugEnabled())
                {
                    log.debug("Duplicate '" + eventCode + "' notification sent from "
                            + BarclaycardSmartPayHosted.BC_SPAY_HOSTED_GATEWAY_CODE + " discarded");
                }
                return null;
            }

            ipnHistory.setKonakartResultDescription(RET0_DESC);
            ipnHistory.setKonakartResultId(RET0);
            kkEngine.saveIpnHistory(sessionId, ipnHistory);

            if (success)
            {
                String comment = ORDER_HISTORY_COMMENT_OK + reason;
                kkEngine.changeOrderStatus(sessionId, orderId,
                        com.konakart.bl.OrderMgr.PAYMENT_RECEIVED_STATUS, sendEmail, comment);
                kkEngine.updateInventory(sessionId, orderId);
            } else
            {
                String comment = ORDER_HISTORY_COMMENT_KO;
                kkEngine.changeOrderStatus(sessionId, orderId,
                        com.konakart.bl.OrderMgr.PAYMENT_DECLINED_STATUS, sendEmail, comment);
            }

            if (sendEmail)
            {
                sendOrderConfirmationMail(kkEngine, sessionId, countryCode, orderId, success);
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
                    if (kkEngine != null)
                    {
                        kkEngine.saveIpnHistory(sessionId, ipnHistory);
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

    /**
     * Checks the user information sent in the Authorization header to see if the user is allowed
     * 
     * @param auth
     * @param username
     * @param password
     * @return true if the user is authenticated, otherwise false
     */
    protected boolean allowUser(String auth, String username, String password)
    {
        if (auth == null)
        {
            return false; // credentials are missing
        }

        if (!auth.toUpperCase().startsWith("BASIC "))
        {
            return false; // we only do BASIC
        }

        if (log.isDebugEnabled())
        {
            // log.debug("auth header = " + auth);
        }

        // Get encoded user and password, comes after "BASIC "
        String userpassEncoded = auth.substring(6);

        // Decode it
        String userpassDecoded = new String(Base64.decodeBase64(userpassEncoded.getBytes()));

        if (log.isDebugEnabled())
        {
            log.debug("auth credentials decoded = "
                    + userpassDecoded.substring(0, Math.min(userpassDecoded.length(), 4)) + "*****");
            log.debug("stored credentials       = "
                    + username.substring(0, Math.min(username.length(), 4)) + "*****");
        }

        // Check our stored username and password to see if this user and password are "allowed"
        if ((username + ":" + password).equals(userpassDecoded))
        {
            return true;
        }

        return false;
    }
}
