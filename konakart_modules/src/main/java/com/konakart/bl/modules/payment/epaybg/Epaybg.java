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

package com.konakart.bl.modules.payment.epaybg;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.axis.encoding.Base64;

import com.konakart.app.KKConfiguration;
import com.konakart.app.KKException;
import com.konakart.app.NameValue;
import com.konakart.app.Order;
import com.konakart.app.OrderTotal;
import com.konakart.app.PaymentDetails;
import com.konakart.appif.KKEngIf;
import com.konakart.bl.modules.BaseModule;
import com.konakart.bl.modules.ordertotal.OrderTotalMgr;
import com.konakart.bl.modules.payment.BasePaymentModule;
import com.konakart.bl.modules.payment.PaymentInfo;
import com.konakart.bl.modules.payment.PaymentInterface;

/**
 * Epaybg IPN module
 * 
 */
public class Epaybg extends BasePaymentModule implements PaymentInterface
{

    // Module name must be the same as the class name although it can be all in lowercase
    private static String code = "epaybg";

    private static String bundleName = BaseModule.basePackage + ".payment.epaybg.Epaybg";

    private static HashMap<Locale, ResourceBundle> resourceBundleMap = new HashMap<Locale, ResourceBundle>();

    /** Hash Map that contains the static data */
    private static Map<String, StaticData> staticDataHM = Collections
            .synchronizedMap(new HashMap<String, StaticData>());

    private static String mutex = "epayMutex";

    private static final String hostPortSubstitute = "host:port";

    // Configuration Keys

    /**
     * Used to put the gateway module online / offline
     */
    private final static String MODULE_PAYMENT_EPAYBG_STATUS = "MODULE_PAYMENT_EPAYBG_STATUS";

    /**
     * The ePayZone , if greater than zero, should reference a GeoZone. If the DeliveryAddress of
     * the order isn't within that GeoZone, then we throw an exception
     */
    private final static String MODULE_PAYMENT_EPAYBG_ZONE = "MODULE_PAYMENT_EPAYBG_ZONE";

    private final static String MODULE_PAYMENT_EPAYBG_ORDER_STATUS_ID = "MODULE_PAYMENT_EPAYBG_ORDER_STATUS_ID";

    /**
     * The order for displaying this payment gateway on the UI
     */
    private final static String MODULE_PAYMENT_EPAYBG_SORT_ORDER = "MODULE_PAYMENT_EPAYBG_SORT_ORDER";

    /**
     * The ePay Url used to POST the payment request. https://www.epay.bg/ or
     * https://devep2.datamax.bg/ep2/epay2_demo/
     */
    private final static String MODULE_PAYMENT_EPAYBG_REQUEST_URL = "MODULE_PAYMENT_EPAYBG_REQUEST_URL";

    /**
     * eMail sent to this address for each transaction
     */
    private final static String MODULE_PAYMENT_EPAYBG_ORDER_PAYMENT_EMAIL = "MODULE_PAYMENT_EPAYBG_ORDER_PAYMENT_EMAIL";

    /**
     * This URL is used by ePay to redirect the user's browser when returning from the payment
     * gateway after declining the payment. If it is in the form
     * http://host:port/konakart/CatalogCheckoutExternalPaymentErrorPage.do, then the string
     * host:port is substituted automatically with the correct value.
     */
    private final static String MODULE_PAYMENT_EPAYBG_DECLINE_URL = "MODULE_PAYMENT_EPAYBG_DECLINE_URL";

    /**
     * This URL is used by ePay to redirect the user's browser when returning from the payment
     * gateway after approving the payment. If it is in the form
     * http://host:port/konakart/CheckoutFinished.do, then the string host:port is substituted
     * automatically with the correct value.
     */
    private final static String MODULE_PAYMENT_EPAYBG_APPROVE_URL = "MODULE_PAYMENT_EPAYBG_APPROVE_URL";

    private final static String MODULE_PAYMENT_EPAYBG_MIN = "MODULE_PAYMENT_EPAYBG_MIN";

    private final static String MODULE_PAYMENT_EPAYBG_SECRET = "MODULE_PAYMENT_EPAYBG_SECRET";

    // Message Catalogue Keys
    private final static String MODULE_PAYMENT_EPAYBG_TEXT_TITLE = "module.payment.epaybg.text.title";

    private final static String MODULE_PAYMENT_EPAYBG_TEXT_DESCRIPTION = "module.payment.epaybg.text.description";

    /**
     * Constructor
     * 
     * @param eng
     * 
     * @throws KKException
     */
    public Epaybg(KKEngIf eng) throws KKException
    {
        super.init(eng);

        StaticData sd = staticDataHM.get(getStoreId());

        if (sd == null)
        {
            synchronized (mutex)
            {
                sd = staticDataHM.get(getStoreId());
                if (sd == null)
                {
                    setStaticVariables();
                }
            }
        }
    }

    /**
     * Sets some static variables during setup
     * 
     * @throws KKException
     * 
     */
    public void setStaticVariables() throws KKException
    {
        KKConfiguration conf;
        StaticData staticData = staticDataHM.get(getStoreId());
        if (staticData == null)
        {
            staticData = new StaticData();
            staticDataHM.put(getStoreId(), staticData);
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_EPAYBG_DECLINE_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_EPAYBG_DECLINE_URL must be set to the return URL for"
                            + " when the request is declined. (i.e. http://{host:port}/konakart/CatalogCheckoutExternalPaymentErrorPage.do)");
        }
        staticData.setEPayDeclineUrl(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_EPAYBG_APPROVE_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_EPAYBG_APPROVE_URL must be set to the return URL for"
                            + " when the request is approved. (i.e. http://host:port/konakart/CheckoutFinished.do')");
        }
        staticData.setEPayApproveUrl(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_EPAYBG_REQUEST_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_EPAYBG_REQUEST_URL must be set to the return URL for"
                            + " sending the request to ePay. (i.e. https://www.epay.bg/)");
        }
        staticData.setEPayRequestUrl(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_EPAYBG_SECRET);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_EPAYBG_SECRET must be set to the secret key"
                            + " shared between the merchant and ePay)");
        }
        staticData.setSecretKey(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_EPAYBG_MIN);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_EPAYBG_MIN must be set to the Merchant Identifier"
                            + " given to the merchant by ePay");
        }
        staticData.setMin(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_EPAYBG_ORDER_PAYMENT_EMAIL);
        staticData.setNotificationEmail(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_EPAYBG_ZONE);
        if (conf == null)
        {
            staticData.setZone(0);
        } else
        {
            staticData.setZone(new Integer(conf.getValue()).intValue());
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_EPAYBG_SORT_ORDER);
        if (conf == null)
        {
            staticData.setSortOrder(0);
        } else
        {
            staticData.setSortOrder(new Integer(conf.getValue()).intValue());
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_EPAYBG_ORDER_STATUS_ID);
        if (conf == null)
        {
            staticData.setOrderStatusId(0);
        } else
        {
            staticData.setOrderStatusId(new Integer(conf.getValue()).intValue());
        }
    }

    /**
     * Return a payment details object for ChronoPay IPN module
     * 
     * @param order
     * @param info
     * @return Returns information in a PaymentDetails object
     * @throws Exception
     */
    public PaymentDetails getPaymentDetails(Order order, PaymentInfo info) throws Exception
    {
        StaticData sd = staticDataHM.get(getStoreId());
        /*
         * The ChronoPayZone zone, if greater than zero, should reference a GeoZone. If the
         * DeliveryAddress of the order isn't within that GeoZone, then we throw an exception
         */
        if (sd.getZone() > 0)
        {
            checkZone(info, sd.getZone());
        }

        // Get the scale for currency calculations
        int scale = new Integer(order.getCurrency().getDecimalPlaces()).intValue();

        // Get the resource bundle
        ResourceBundle rb = getResourceBundle(mutex, bundleName, resourceBundleMap, info
                .getLocale());
        if (rb == null)
        {
            throw new KKException("A resource file cannot be found for the country "
                    + info.getLocale().getCountry());
        }

        PaymentDetails pDetails = new PaymentDetails();
        pDetails.setCode(code);
        pDetails.setSortOrder(sd.getSortOrder());
        pDetails.setOrderStatusId(sd.getOrderStatusId());
        pDetails.setPaymentType(PaymentDetails.BROWSER_PAYMENT_GATEWAY);
        pDetails.setDescription(rb.getString(MODULE_PAYMENT_EPAYBG_TEXT_DESCRIPTION));
        pDetails.setTitle(rb.getString(MODULE_PAYMENT_EPAYBG_TEXT_TITLE));

        // Return now if the full payment details aren't required. This happens when the manager
        // just wants a list of payment gateways to display in the UI.
        if (info.isReturnDetails() == false)
        {
            return pDetails;
        }

        pDetails.setPostOrGet("post");
        pDetails.setRequestUrl(sd.getEPayRequestUrl());

        // The ePay interface only has the following parameters:
        // <form action="https://www.epay.bg/" method=post>
        // <input type=hidden name=PAGE value="credit_paydirect">
        // <input type=hidden name=ENCODED value="[ENCODED]">
        // <input type=hidden name=CHECKSUM value="[CHECKSUM]">
        // <input type=hidden name=URL_OK value="http://...">
        // <input type=hidden name=URL_CANCEL value="http://...">
        // <input type=submit>
        // </form>

        // List of parameters
        List<NameValue> parmList = new ArrayList<NameValue>();

        // Call back if payment is declined
        sd.setEPayDeclineUrl(sd.getEPayDeclineUrl().replaceFirst(hostPortSubstitute,
                info.getHostAndPort()));
        parmList.add(new NameValue("URL_CANCEL", sd.getEPayDeclineUrl()));

        // Call back if payment is approved
        sd.setEPayApproveUrl(sd.getEPayApproveUrl().replaceFirst(hostPortSubstitute,
                info.getHostAndPort()));
        parmList.add(new NameValue("URL_OK", sd.getEPayApproveUrl()));

        // Page parameter
        parmList.add(new NameValue("PAGE", "paylogin"));

        // Calculate Encoded and Checksum

        // ePay only requires details of the final price. No tax, subtotal etc.
        BigDecimal total = null;
        for (int i = 0; i < order.getOrderTotals().length; i++)
        {
            OrderTotal ot = (OrderTotal) order.getOrderTotals()[i];
            if (ot.getClassName().equals(OrderTotalMgr.ot_total))
            {
                total = ot.getValue().setScale(scale, BigDecimal.ROUND_HALF_UP);
            }
        }

        StringBuffer sb = new StringBuffer();

        sb.append("MIN=");
        sb.append(sd.getMin());
        sb.append("\r\n");
        sb.append("INVOICE=");
        sb.append(order.getId());
        sb.append("\r\n");
        sb.append("AMOUNT=");
        sb.append(total);
        sb.append("\r\n");
        sb.append("EXP_TIME=");
        sb.append("01.08.2020");
        sb.append("\r\n");
        if (sd.getNotificationEmail() != null && sd.getNotificationEmail().length() > 0)
        {
            sb.append("EMAIL=");
            sb.append(sd.getNotificationEmail());
            sb.append("\r\n");
        }
        sb.append("DESCR=");
        String descr = "Payment for order #" + order.getId() + " from KonaKart";
        sb.append(descr);

        if (log.isDebugEnabled())
        {
            log.debug("MIN = " + sd.getMin());
            log.debug("INVOICE = " + order.getId());
            log.debug("AMOUNT = " + total);
            log.debug("EMAIL = " + sd.getNotificationEmail());
            log.debug("DESCR = " + descr);
        }

        // Base64 encode the string
        String encodedString = Base64.encode(sb.toString().getBytes()).trim();
        parmList.add(new NameValue("ENCODED", encodedString));

        // Create the checksum
        Mac sha = Mac.getInstance("HmacSHA1");
        sha.init(new SecretKeySpec(sd.getSecretKey().getBytes(), "HmacSHA1"));
        byte[] mac = new byte[20];
        mac = sha.doFinal(encodedString.getBytes());
        String checksum = bytesToHex(mac);
        parmList.add(new NameValue("CHECKSUM", checksum));

        // Put the parameters into an array
        NameValue[] nvArray = new NameValue[parmList.size()];
        parmList.toArray(nvArray);
        pDetails.setParameters(nvArray);

        if (log.isDebugEnabled())
        {
            log.debug(pDetails.toString());
        }

        return pDetails;
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

    /**
     * Returns true or false
     * 
     * @throws KKException
     */
    public boolean isAvailable() throws KKException
    {
        return isAvailable(getEng(), MODULE_PAYMENT_EPAYBG_STATUS);
    }

    /**
     * Used to store the static data of this module
     */
    protected class StaticData
    {

        private int sortOrder = -1;

        // Redirect URL used by gateway when payment has been declined.
        private String ePayDeclineUrl;

        // Redirect URL used by gateway when payment has been approved.
        private String ePayApproveUrl;

        // The ePay Url used to POST the payment request.
        // https://www.epay.bg/ or https://devep2.datamax.bg/ep2/epay2_demo/
        private String ePayRequestUrl;

        // eMail address where transaction notification is sent
        private String notificationEmail;

        // Merchant identifier
        private String min;

        // Secret key shared between merchant and ePay used to sign the data
        private String secretKey;

        private int zone;

        private int orderStatusId;

        /**
         * @return the sortOrder
         */
        public int getSortOrder()
        {
            return sortOrder;
        }

        /**
         * @param sortOrder
         *            the sortOrder to set
         */
        public void setSortOrder(int sortOrder)
        {
            this.sortOrder = sortOrder;
        }

        /**
         * @return the ePayDeclineUrl
         */
        public String getEPayDeclineUrl()
        {
            return ePayDeclineUrl;
        }

        /**
         * @param payDeclineUrl
         *            the ePayDeclineUrl to set
         */
        public void setEPayDeclineUrl(String payDeclineUrl)
        {
            ePayDeclineUrl = payDeclineUrl;
        }

        /**
         * @return the ePayApproveUrl
         */
        public String getEPayApproveUrl()
        {
            return ePayApproveUrl;
        }

        /**
         * @param payApproveUrl
         *            the ePayApproveUrl to set
         */
        public void setEPayApproveUrl(String payApproveUrl)
        {
            ePayApproveUrl = payApproveUrl;
        }

        /**
         * @return the ePayRequestUrl
         */
        public String getEPayRequestUrl()
        {
            return ePayRequestUrl;
        }

        /**
         * @param payRequestUrl
         *            the ePayRequestUrl to set
         */
        public void setEPayRequestUrl(String payRequestUrl)
        {
            ePayRequestUrl = payRequestUrl;
        }

        /**
         * @return the notificationEmail
         */
        public String getNotificationEmail()
        {
            return notificationEmail;
        }

        /**
         * @param notificationEmail
         *            the notificationEmail to set
         */
        public void setNotificationEmail(String notificationEmail)
        {
            this.notificationEmail = notificationEmail;
        }

        /**
         * @return the min
         */
        public String getMin()
        {
            return min;
        }

        /**
         * @param min
         *            the min to set
         */
        public void setMin(String min)
        {
            this.min = min;
        }

        /**
         * @return the secretKey
         */
        public String getSecretKey()
        {
            return secretKey;
        }

        /**
         * @param secretKey
         *            the secretKey to set
         */
        public void setSecretKey(String secretKey)
        {
            this.secretKey = secretKey;
        }

        /**
         * @return the zone
         */
        public int getZone()
        {
            return zone;
        }

        /**
         * @param zone
         *            the zone to set
         */
        public void setZone(int zone)
        {
            this.zone = zone;
        }

        /**
         * @return the orderStatusId
         */
        public int getOrderStatusId()
        {
            return orderStatusId;
        }

        /**
         * @param orderStatusId
         *            the orderStatusId to set
         */
        public void setOrderStatusId(int orderStatusId)
        {
            this.orderStatusId = orderStatusId;
        }
    }

}
