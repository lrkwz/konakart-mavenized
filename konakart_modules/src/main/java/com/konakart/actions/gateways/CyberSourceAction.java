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

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.konakart.al.KKAppEng;
import com.konakart.app.IpnHistory;
import com.konakart.app.NameValue;
import com.konakart.appif.IpnHistoryIf;
import com.konakart.appif.NameValueIf;
import com.konakart.appif.OrderIf;
import com.konakart.appif.PaymentDetailsIf;
import com.konakart.appif.StoreIf;
import com.konakart.bl.modules.payment.cybersource.CyberSource;
import com.konakart.bl.modules.payment.cybersource.CyberSourceHMACTools;
import com.konakart.util.Utils;

/**
 * This class is an Action class for sending credit card details to CyberSource
 */
public class CyberSourceAction extends BaseGatewayAction
{
    /**
     * The <code>Log</code> instance for this application.
     */
    protected Log log = LogFactory.getLog(CyberSourceAction.class);

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
        if (log.isDebugEnabled())
        {
            log.debug(CyberSource.CYBERSOURCE_GATEWAY_CODE + " payment module called");
        }

        // Create these outside of try / catch since they are needed in the case of a general
        // exception
        IpnHistoryIf ipnHistory = new IpnHistory();
        ipnHistory.setModuleCode(CyberSource.CYBERSOURCE_GATEWAY_CODE);
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
            validateOrder(order, CyberSource.CYBERSOURCE_GATEWAY_CODE);

            // Set the order id for the ipnHistory object
            ipnHistory.setOrderId(order.getId());

            PaymentDetailsIf pd = order.getPaymentDetails();

            String storeId = "?";
            StoreIf store = kkAppEng.getEng().getStore();
            if (store != null)
            {
                storeId = store.getStoreId();
            }

            int engineMode = kkAppEng.getEng().getEngConf().getMode();
            boolean customersShared = kkAppEng.getEng().getEngConf().isCustomersShared();
            boolean productsShared = kkAppEng.getEng().getEngConf().isProductsShared();
            String countryCode = order.getLocale().substring(0, 2);

            if (log.isDebugEnabled())
            {
                log.debug("Used to create merchantReference:          \n"
                        + "    OrderId              = " + order.getId() + "\n"
                        + "    OrderNumber          = " + order.getOrderNumber() + "\n"
                        + "    StoreId              = " + storeId + "\n"
                        + "    EngineMode           = " + engineMode + "\n"
                        + "    CustomersShared      = " + customersShared + "\n"
                        + "    ProductsShared       = " + productsShared + "\n"
                        + "    CountryCode          = " + countryCode);
            }

            String merchantReference = order.getId() + "~" + order.getOrderNumber() + "~" + storeId
                    + "~" + engineMode + "~" + customersShared + "~" + productsShared + "~"
                    + countryCode;

            // Create a parameter list for the credit card details.
            List<NameValueIf> parmList = new ArrayList<NameValueIf>();

            parmList.add(new NameValue(CyberSource.CYBERSOURCE_MERCHANT_REF, merchantReference));
            parmList.add(new NameValue(CyberSource.CYBERSOURCE_CARD_NUMBER, pd.getCcNumber()));
            if (pd.isShowCVV())
            {
                parmList.add(new NameValue(CyberSource.CYBERSOURCE_CARD_CCV, pd.getCcCVV()));
            }

            parmList.add(new NameValue(CyberSource.CYBERSOURCE_CARD_EXP_MONTH, pd
                    .getCcExpiryMonth()));
            parmList.add(new NameValue(CyberSource.CYBERSOURCE_CARD_EXP_YEAR, "20"
                    + pd.getCcExpiryYear()));
            parmList.add(new NameValue(CyberSource.CYBERSOURCE_CARD_OWNER, pd.getCcOwner()));
            parmList.add(new NameValue(CyberSource.CYBERSOURCE_CARD_TYPE, getCardType(pd
                    .getCcType())));

            parmList.add(new NameValue(CyberSource.CYBERSOURCE_TRAN_TYPE, "sale"));
            parmList.add(new NameValue(CyberSource.CYBERSOURCE_IGNORE_AVS, "true"));

            // Calculate the signature
            HashMap<String, String> hp = hashParameters(pd, parmList);

            String time = String.valueOf(System.currentTimeMillis());
            String data = hp.get(CyberSource.CYBERSOURCE_MERCHANT_ACCOUNT)
                    + hp.get(CyberSource.CYBERSOURCE_PAYMENT_AMOUNT)
                    + hp.get(CyberSource.CYBERSOURCE_CURRENCY) + time
                    + hp.get(CyberSource.CYBERSOURCE_TRAN_TYPE);

            parmList.add(new NameValue(CyberSource.CYBERSOURCE_TIMESTAMP, time));
            parmList.add(new NameValue(CyberSource.CYBERSOURCE_SIGNATURE, CyberSourceHMACTools
                    .getBase64EncodedSignature(pd.getCustom1(), data)));

            addParameters(pd, parmList);

            // Remove shared secret for security
            // pd.setCustom1(null);

            if (log.isDebugEnabled())
            {
                // to show what we're about to post to CyberSource

                String postStr = "https://orderpagetest.ic3.com/hop/CheckOrderData.do?";

                for (int p = 0; p < pd.getParameters().length; p++)
                {
                    if (p > 0)
                    {
                        postStr += "&";
                    }

                    if (pd.getParameters()[p].getValue() == null)
                    {
                        if (pd.getParameters()[p].getName() != null)
                        {
                            log.debug("Value for " + pd.getParameters()[p].getName() + " is null");
                        }   
                    } else
                    {
                        postStr += pd.getParameters()[p].getName() + "="
                                + URLEncoder.encode(pd.getParameters()[p].getValue(), "UTF-8");
                    }
                }

                log.debug("\n" + postStr);
            }

            // Redirect to post the parameters to CyberSource
            return mapping.findForward("PostToGateway");
        } catch (Exception e)
        {
            if (log.isDebugEnabled())
            {
                log.debug(e.getMessage());
            }
            return mapping.findForward(super.handleException(request, e));
        }
    }

    /**
     * Create the request from the parameters
     * 
     * @param pd
     *            the PaymentDetails
     * @param ccParmList
     *            the credit card parameters
     */
    protected StringBuffer getGatewayRequest(PaymentDetailsIf pd, List<NameValueIf> ccParmList)
    {
        HashMap<String, String> hp = hashParameters(pd, ccParmList);

        StringBuffer msg = new StringBuffer("?" + insertSignature(hp)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_PAYMENT_AMOUNT)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_CURRENCY)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_VERSION_NUMBER)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_SERIAL_NUMBER)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_MERCHANT_ACCOUNT)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_COMP)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_FNAME)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_LNAME)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_STREET1)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_CITY)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_STATE)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_POSTCODE)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_COUNTRY)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_PHONE)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_BILLTO_EMAIL)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_SHIPTO_COMP)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_SHIPTO_FNAME)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_SHIPTO_LNAME)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_SHIPTO_STREET1)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_SHIPTO_CITY)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_SHIPTO_STATE)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_SHIPTO_POSTCODE)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_SHIPTO_COUNTRY)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_CARD_TYPE)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_CARD_EXP_MONTH)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_CARD_EXP_YEAR)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_CARD_NUMBER)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_CARD_CCV)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_TRAN_TYPE)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_DECLINE_URL)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_RECEIPT_URL)
                + addHiddenField(hp, CyberSource.CYBERSOURCE_IGNORE_AVS));

        if (log.isDebugEnabled())
        {
            log.debug("GatewayRequest =\nhttps://orderpagetest.ic3.com/hop/CheckOrderData.do"
                    + msg.toString());
        }

        return msg;
    }

    /**
     * @param hp
     *            a hash map containing all the variables required to make a signature
     * @return a String contaiing the signature
     */
    public String insertSignature(HashMap<String, String> hp)
    {
        String time = String.valueOf(System.currentTimeMillis());
        String data = hp.get(CyberSource.CYBERSOURCE_MERCHANT_ACCOUNT)
                + hp.get(CyberSource.CYBERSOURCE_PAYMENT_AMOUNT)
                + hp.get(CyberSource.CYBERSOURCE_CURRENCY) + time
                + hp.get(CyberSource.CYBERSOURCE_TRAN_TYPE);

        StringBuffer sb = new StringBuffer();
        sb.append("orderPage_timestamp=" + time);
        sb.append("&orderPage_signaturePublic="
                + CyberSourceHMACTools.getBase64EncodedSignature(hp
                        .get(CyberSource.CYBERSOURCE_SHARED_SECRET), data));

        return sb.toString();
    }

    private String addHiddenField(HashMap<String, String> hp, String field)
    {
        String value = hp.get(field);
        if (!Utils.isBlank(value))
        {
            return "&" + field + "=" + value;
        }

        return "";
    }

    private String getCardType(String cardType)
    {
        if (cardType.equalsIgnoreCase("Visa"))
        {
            return "001";
        }
        if (cardType.equalsIgnoreCase("Mastercard"))
        {
            return "002";
        }
        if (cardType.equalsIgnoreCase("American Express"))
        {
            return "003";
        }
        if (cardType.equalsIgnoreCase("Amex"))
        {
            return "003";
        }
        if (cardType.equalsIgnoreCase("Discover"))
        {
            return "004";
        }
        if (cardType.equalsIgnoreCase("Diners"))
        {
            return "005";
        }
        if (cardType.equalsIgnoreCase("JCB"))
        {
            return "006";
        }

        // Unknown Card type
        return "000";
    }
}
