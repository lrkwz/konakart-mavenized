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

package com.konakart.bl.modules.payment.chronopay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.konakart.app.KKConfiguration;
import com.konakart.app.KKException;
import com.konakart.app.NameValue;
import com.konakart.app.Order;
import com.konakart.app.OrderTotal;
import com.konakart.app.PaymentDetails;
import com.konakart.appif.CountryIf;
import com.konakart.appif.KKEngIf;
import com.konakart.bl.modules.BaseModule;
import com.konakart.bl.modules.ordertotal.OrderTotalMgr;
import com.konakart.bl.modules.payment.BasePaymentModule;
import com.konakart.bl.modules.payment.PaymentInfo;
import com.konakart.bl.modules.payment.PaymentInterface;

/**
 * Chronopay IPN module
 * 
 */
public class Chronopay extends BasePaymentModule implements PaymentInterface
{

    // Module name must be the same as the class name although it can be all in lowercase
    private static String code = "chronopay";

    private static String bundleName = BaseModule.basePackage + ".payment.chronopay.Chronopay";

    private static HashMap<Locale, ResourceBundle> resourceBundleMap = new HashMap<Locale, ResourceBundle>();

    /** Hash Map that contains the static data */
    private static Map<String, StaticData> staticDataHM = Collections
            .synchronizedMap(new HashMap<String, StaticData>());

    private static String mutex = "chronopayMutex";

    private static final String hostPortSubstitute = "host:port";

    // Configuration Keys

    /**
     * Used to put the gateway online / offline
     */
    private final static String MODULE_PAYMENT_CHRONOPAY_STATUS = "MODULE_PAYMENT_CHRONOPAY_STATUS";

    /**
     * The ChronoPayZone zone, if greater than zero, should reference a GeoZone. If the
     * DeliveryAddress of the order isn't within that GeoZone, then we throw an exception
     */
    private final static String MODULE_PAYMENT_CHRONOPAY_ZONE = "MODULE_PAYMENT_CHRONOPAY_ZONE";

    private final static String MODULE_PAYMENT_CHRONOPAY_ORDER_STATUS_ID = "MODULE_PAYMENT_CHRONOPAY_ORDER_STATUS_ID";

    /**
     * The order for displaying this payment gateway on the UI
     */
    private final static String MODULE_PAYMENT_CHRONOPAY_SORT_ORDER = "MODULE_PAYMENT_CHRONOPAY_SORT_ORDER";

    /**
     * The product Id that identifies the store (format:NNNNNN-NNNN-NNNN)
     */
    private final static String MODULE_PAYMENT_CHRONOPAY_PRODUCT_ID = "MODULE_PAYMENT_CHRONOPAY_PRODUCT_ID";

    /**
     * The ChronoPay Url used to POST the payment request.
     * "https://secure.chronopay.com/index_shop.cgi"
     */
    private final static String MODULE_PAYMENT_CHRONOPAY_REQUEST_URL = "MODULE_PAYMENT_CHRONOPAY_REQUEST_URL";

    /**
     * This URL is used by the ChronoPay IPN functionality to call back into the application with
     * the results of the payment transaction. It must be a URL that is visible from the internet.
     */
    private final static String MODULE_PAYMENT_CHRONOPAY_CALLBACK_URL = "MODULE_PAYMENT_CHRONOPAY_CALLBACK_URL";

    /**
     * This URL is used by ChronoPay to redirect the user's browser when returning from the payment
     * gateway after declining the payment. If it is in the form
     * http://host:port/konakart/CatalogCheckoutExternalPaymentErrorPage.do, then the string
     * host:port is substituted automatically with the correct value. URL for redirecting in case of
     * successful payment is set as product parameter (access url) on the ChronoPay web site..
     */
    private final static String MODULE_PAYMENT_CHRONOPAY_DECLINE_URL = "MODULE_PAYMENT_CHRONOPAY_DECLINE_URL";

    // Message Catalogue Keys
    private final static String MODULE_PAYMENT_CHRONOPAY_TEXT_TITLE = "module.payment.chronopay.text.title";

    private final static String MODULE_PAYMENT_CHRONOPAY_TEXT_DESCRIPTION = "module.payment.chronopay.text.description";

    /**
     * Constructor
     * 
     * @param eng
     * 
     * @throws KKException
     */
    public Chronopay(KKEngIf eng) throws KKException
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

        conf = getEng().getConfiguration(MODULE_PAYMENT_CHRONOPAY_CALLBACK_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_CHRONOPAY_CALLBACK must be set to the Callback Url for the"
                            + " IPN functionality (i.e. https://myhost/konacart/ChronoPayCallback.do).");
        }
        staticData.setChronoPayCallbackUrl(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_CHRONOPAY_DECLINE_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_CHRONOPAY_DECLINE_URL must be set to the return URL for"
                            + " when the request is declined. (i.e. http://{host:port}/konakart/CatalogCheckoutExternalPaymentErrorPage.do)");
        }
        staticData.setChronoPayDeclineUrl(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_CHRONOPAY_PRODUCT_ID);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_CHRONOPAY_PRODUCT_ID must be set to the product Id"
                            + " released by ChronoPay in the format NNNNNN-NNNN-NNNN");
        }
        staticData.setChronoPayProductId(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_CHRONOPAY_REQUEST_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_CHRONOPAY_REQUEST_URL must be set to the return URL for"
                            + " sending the request to ChronoPay. (i.e. https://secure.chronopay.com/index_shop.cgi)");
        }
        staticData.setChronoPayRequestUrl(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_CHRONOPAY_ZONE);
        if (conf == null)
        {
            staticData.setZone(0);
        } else
        {
            staticData.setZone(new Integer(conf.getValue()).intValue());
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_CHRONOPAY_SORT_ORDER);
        if (conf == null)
        {
            staticData.setSortOrder(0);
        } else
        {
            staticData.setSortOrder(new Integer(conf.getValue()).intValue());
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_CHRONOPAY_ORDER_STATUS_ID);
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
        pDetails.setDescription(rb.getString(MODULE_PAYMENT_CHRONOPAY_TEXT_DESCRIPTION));
        pDetails.setTitle(rb.getString(MODULE_PAYMENT_CHRONOPAY_TEXT_TITLE));

        // Return now if the full payment details aren't required. This happens when the manager
        // just wants a list of payment gateways to display in the UI.
        if (info.isReturnDetails() == false)
        {
            return pDetails;
        }

        pDetails.setPostOrGet("post");
        pDetails.setRequestUrl(sd.getChronoPayRequestUrl());

        List<NameValue> parmList = new ArrayList<NameValue>();
        parmList.add(new NameValue("product_id", sd.getChronoPayProductId()));
        parmList.add(new NameValue("product_name", "Order #" + order.getId() + " from "
                + info.getStoreName()));

        // Chronopay only requires details of the final price. No tax, subtotal etc.
        BigDecimal total = null;
        for (int i = 0; i < order.getOrderTotals().length; i++)
        {
            OrderTotal ot = (OrderTotal) order.getOrderTotals()[i];
            if (ot.getClassName().equals(OrderTotalMgr.ot_total))
            {
                total = ot.getValue().setScale(scale, BigDecimal.ROUND_HALF_UP);
            }
        }

        if (total == null)
        {
            throw new KKException("An Order Total was not found");
        }

        parmList.add(new NameValue("product_price", total.toString()));

        // Normal Callback
        sd.setChronoPayCallbackUrl(sd.getChronoPayCallbackUrl().replaceFirst(hostPortSubstitute,
                info.getHostAndPort()));
        parmList.add(new NameValue("cb_url", sd.getChronoPayCallbackUrl()));
        parmList.add(new NameValue("cb_type", "P"));

        // Call back if payment is declined
        sd.setChronoPayDeclineUrl(sd.getChronoPayDeclineUrl().replaceFirst(hostPortSubstitute,
                info.getHostAndPort()));
        parmList.add(new NameValue("decline_url", sd.getChronoPayDeclineUrl()));

        // Set one of the custom variables with the secret key
        parmList.add(new NameValue("cs1", getEng().getSecretKeyForOrderId(order.getId())));
        parmList.add(new NameValue("cs2", order.getId()));

        // Set the billing name. If the name field consists of more than two strings, we take the
        // last one as being the surname.
        String bName = order.getBillingName();
        if (bName != null)
        {
            String[] names = bName.split(" ");
            int len = names.length;
            if (len >= 2)
            {
                StringBuffer firstName = new StringBuffer();
                for (int i = 0; i < len - 1; i++)
                {
                    if (firstName.length() == 0)
                    {
                        firstName.append(names[i]);
                    } else
                    {
                        firstName.append(" ");
                        firstName.append(names[i]);
                    }
                }
                parmList.add(new NameValue("f_name", firstName.toString()));
                parmList.add(new NameValue("s_name", names[len - 1]));
            }
        }

        // Set the billing address
        parmList.add(new NameValue("street", order.getBillingStreetAddress()));
        parmList.add(new NameValue("city", order.getBillingCity()));
        parmList.add(new NameValue("state", order.getBillingState()));
        parmList.add(new NameValue("zip", order.getBillingPostcode()));
        parmList.add(new NameValue("phone", order.getCustomerTelephone()));
        parmList.add(new NameValue("email", order.getCustomerEmail()));

        // Country requires the three letter country code
        CountryIf country = getEng().getCountryPerName(order.getBillingCountry());
        if (country != null)
        {
            parmList.add(new NameValue("country", country.getIsoCode3()));
        }

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
     * Returns true or false
     * 
     * @throws KKException
     */
    public boolean isAvailable() throws KKException
    {
        return isAvailable(getEng(), MODULE_PAYMENT_CHRONOPAY_STATUS);
    }

    /**
     * Used to store the static data of this module
     */
    protected class StaticData
    {

        private int sortOrder = -1;

        // Callback called by Gateway after a transaction
        private String chronoPayCallbackUrl;

        // Redirect URL used by gateway when payment has been declined. Url for succesful payment is
        // set
        // as a product parameter in the setup section of the ChronoPay web site (access_url)
        private String chronoPayDeclineUrl;

        // The product Id that identifies the store (format:NNNNNN-NNNN-NNNN)
        private String chronoPayProductId;

        // The ChronoPay Url used to POST the payment request.
        // "https://secure.chronopay.com/index_shop.cgi"
        private String chronoPayRequestUrl;

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
         * @return the chronoPayCallbackUrl
         */
        public String getChronoPayCallbackUrl()
        {
            return chronoPayCallbackUrl;
        }

        /**
         * @param chronoPayCallbackUrl
         *            the chronoPayCallbackUrl to set
         */
        public void setChronoPayCallbackUrl(String chronoPayCallbackUrl)
        {
            this.chronoPayCallbackUrl = chronoPayCallbackUrl;
        }

        /**
         * @return the chronoPayDeclineUrl
         */
        public String getChronoPayDeclineUrl()
        {
            return chronoPayDeclineUrl;
        }

        /**
         * @param chronoPayDeclineUrl
         *            the chronoPayDeclineUrl to set
         */
        public void setChronoPayDeclineUrl(String chronoPayDeclineUrl)
        {
            this.chronoPayDeclineUrl = chronoPayDeclineUrl;
        }

        /**
         * @return the chronoPayProductId
         */
        public String getChronoPayProductId()
        {
            return chronoPayProductId;
        }

        /**
         * @param chronoPayProductId
         *            the chronoPayProductId to set
         */
        public void setChronoPayProductId(String chronoPayProductId)
        {
            this.chronoPayProductId = chronoPayProductId;
        }

        /**
         * @return the chronoPayRequestUrl
         */
        public String getChronoPayRequestUrl()
        {
            return chronoPayRequestUrl;
        }

        /**
         * @param chronoPayRequestUrl
         *            the chronoPayRequestUrl to set
         */
        public void setChronoPayRequestUrl(String chronoPayRequestUrl)
        {
            this.chronoPayRequestUrl = chronoPayRequestUrl;
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
