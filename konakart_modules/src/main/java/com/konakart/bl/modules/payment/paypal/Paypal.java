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

package com.konakart.bl.modules.payment.paypal;

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
import com.konakart.appif.KKEngIf;
import com.konakart.bl.modules.BaseModule;
import com.konakart.bl.modules.ordertotal.OrderTotalMgr;
import com.konakart.bl.modules.payment.BasePaymentModule;
import com.konakart.bl.modules.payment.PaymentInfo;
import com.konakart.bl.modules.payment.PaymentInterface;

/**
 * PayPal IPN module
 */
public class Paypal extends BasePaymentModule implements PaymentInterface
{
    // Module name must be the same as the class name although it can be all in lowercase
    private static String code = "paypal";

    private static String bundleName = BaseModule.basePackage + ".payment.paypal.Paypal";

    private static HashMap<Locale, ResourceBundle> resourceBundleMap = new HashMap<Locale, ResourceBundle>();

    /** Hash Map that contains the static data */
    private static Map<String, StaticData> staticDataHM = Collections
            .synchronizedMap(new HashMap<String, StaticData>());

    private static String mutex = "paypalMutex";

    private static final String hostPortSubstitute = "host:port";

    // Configuration Keys

    private final static String MODULE_PAYMENT_PAYPAL_STATUS = "MODULE_PAYMENT_PAYPAL_STATUS";

    private final static String MODULE_PAYMENT_PAYPAL_ID = "MODULE_PAYMENT_PAYPAL_ID";

    private final static String MODULE_PAYMENT_PAYPAL_ZONE = "MODULE_PAYMENT_PAYPAL_ZONE";

    private final static String MODULE_PAYMENT_PAYPAL_ORDER_STATUS_ID = "MODULE_PAYMENT_PAYPAL_ORDER_STATUS_ID";

    private final static String MODULE_PAYMENT_PAYPAL_SORT_ORDER = "MODULE_PAYMENT_PAYPAL_SORT_ORDER";

    /**
     * This URL is used by the PayPal IPN functionality to call back into the application with the
     * results of the payment transaction. It must be a URl that is visible from the internet.
     */
    private final static String MODULE_PAYMENT_PAYPAL_CALLBACK_URL = "MODULE_PAYMENT_PAYPAL_CALLBACK_URL";

    /**
     * This URL is used by PayPal to redirect the user's browser when returning from the payment
     * gateway. If it is in the form http://host:port/konakart/CheckoutFinished.do, then the string
     * host:port is substituted automatically with the correct value.
     */
    private final static String MODULE_PAYMENT_PAYPAL_RETURN_URL = "MODULE_PAYMENT_PAYPAL_RETURN_URL";

    /**
     * This URL is used by PayPal to redirect the user's browser when returning from the payment
     * gateway after cancelling out of the operation. If it is in the form
     * http://host:port/konakart/CatalogCheckoutExternalPaymentErrorPage.do, then the string
     * host:port is substituted automatically with the correct value.
     */
    private final static String MODULE_PAYMENT_PAYPAL_CANCEL_URL = "MODULE_PAYMENT_PAYPAL_CANCEL_URL";

    /**
     * If set to true, the module will use the PayPal sandbox. Otherwise the live URL will be used.
     */
    private final static String MODULE_PAYMENT_PAYPAL_TEST_MODE = "MODULE_PAYMENT_PAYPAL_TEST_MODE";

    // Message Catalogue Keys

    private final static String MODULE_PAYMENT_PAYPAL_TEXT_TITLE = "module.payment.paypal.text.title";

    private final static String MODULE_PAYMENT_PAYPAL_TEXT_DESCRIPTION = "module.payment.paypal.text.description";

    /**
     * Constructor
     * 
     * @param eng
     * 
     * @throws KKException
     */
    public Paypal(KKEngIf eng) throws KKException
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

        conf = getEng().getConfiguration(MODULE_PAYMENT_PAYPAL_ID);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_PAYPAL_ID must be set to the PayPal Id of the merchant.");
        }
        staticData.setPayPalId(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_PAYPAL_CALLBACK_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_PAYPAL_CALLBACK must be set to the Callback Url for the"
                            + " IPN functionality (i.e. https://myhost/konakart/PayPalCallback.do).");
        }
        staticData.setPayPalCallbackUrl(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_PAYPAL_RETURN_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_PAYPAL_RETURN_URL must be set to the return URL for"
                            + " when the customer leaves the payment gateway. (i.e. http://{host:port}/konakart/CheckoutFinished.do)");
        }
        staticData.setPayPalReturnUrl(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_PAYPAL_CANCEL_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_PAYPAL_CANCEL_URL must be set to the return URL for"
                            + " when the customer leaves the payment gateway by cancelling the operation. (i.e. http://{host:port}/konakart/CatalogCheckoutExternalPaymentErrorPage.do)");
        }
        staticData.setPayPalCancelUrl(conf.getValue());

        conf = getEng().getConfiguration(MODULE_PAYMENT_PAYPAL_ZONE);
        if (conf == null)
        {
            staticData.setZone(0);
        } else
        {
            staticData.setZone(new Integer(conf.getValue()).intValue());
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_PAYPAL_SORT_ORDER);
        if (conf == null)
        {
            staticData.setSortOrder(0);
        } else
        {
            staticData.setSortOrder(new Integer(conf.getValue()).intValue());
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_PAYPAL_ORDER_STATUS_ID);
        if (conf == null)
        {
            staticData.setOrderStatusId(0);
        } else
        {
            staticData.setOrderStatusId(new Integer(conf.getValue()).intValue());
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_PAYPAL_TEST_MODE);
        if (conf == null)
        {
            staticData.setPayPalTestMode(true);
        } else
        {
            if (conf.getValue().equalsIgnoreCase("false"))
            {
                staticData.setPayPalTestMode(false);
            } else
            {
                staticData.setPayPalTestMode(true);
            }
        }
     }

    /**
     * Return a payment details object for PayPal IPN module
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
         * The payPalZone zone, if greater than zero, should reference a GeoZone. If the
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
        pDetails.setDescription(rb.getString(MODULE_PAYMENT_PAYPAL_TEXT_DESCRIPTION));
        pDetails.setTitle(rb.getString(MODULE_PAYMENT_PAYPAL_TEXT_TITLE));

        // Return now if the full payment details aren't required
        if (info.isReturnDetails() == false)
        {
            return pDetails;
        }

        pDetails.setPostOrGet("post");
        if (sd.isPayPalTestMode())
        {
            pDetails.setRequestUrl("https://www.sandbox.paypal.com/cgi-bin/webscr");
        } else
        {
            pDetails.setRequestUrl("https://www.paypal.com/cgi-bin/webscr");
        }

        List<NameValue> parmList = new ArrayList<NameValue>();
        parmList.add(new NameValue("cmd", "_xclick"));
        parmList.add(new NameValue("item_name", "Order #" + order.getId() + " from "
                + info.getStoreName()));

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
            throw new KKException(
                    "An Order Total was not found so the payment could not be processed through PayPal.");
        }

        parmList.add(new NameValue("amount", total.toString()));
        parmList.add(new NameValue("business", sd.getPayPalId()));
        parmList.add(new NameValue("currency_code", order.getCurrencyCode()));
        parmList.add(new NameValue("custom", getEng().getSecretKeyForOrderId(order.getId())));
        parmList.add(new NameValue("no_shipping", "1"));
        parmList.add(new NameValue("no_note", "1"));
        parmList.add(new NameValue("notify_url", sd.getPayPalCallbackUrl()));

        sd.setPayPalReturnUrl(sd.getPayPalReturnUrl().replaceFirst(hostPortSubstitute,
                info.getHostAndPort()));
        sd.setPayPalCancelUrl(sd.getPayPalCancelUrl().replaceFirst(hostPortSubstitute,
                info.getHostAndPort()));
        parmList.add(new NameValue("return", sd.getPayPalReturnUrl()));
        parmList.add(new NameValue("cancel_return", sd.getPayPalCancelUrl()));

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
        return isAvailable(getEng(), MODULE_PAYMENT_PAYPAL_STATUS);
    }

    /**
     * Used to store the static data of this module
     */
    protected class StaticData
    {
        private int sortOrder = -1;

        private String payPalId;

        private String payPalCallbackUrl;

        private String payPalReturnUrl;

        private String payPalCancelUrl;

        private boolean payPalTestMode;

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
         * @return the payPalId
         */
        public String getPayPalId()
        {
            return payPalId;
        }

        /**
         * @param payPalId
         *            the payPalId to set
         */
        public void setPayPalId(String payPalId)
        {
            this.payPalId = payPalId;
        }

        /**
         * @return the payPalCallbackUrl
         */
        public String getPayPalCallbackUrl()
        {
            return payPalCallbackUrl;
        }

        /**
         * @param payPalCallbackUrl
         *            the payPalCallbackUrl to set
         */
        public void setPayPalCallbackUrl(String payPalCallbackUrl)
        {
            this.payPalCallbackUrl = payPalCallbackUrl;
        }

        /**
         * @return the payPalReturnUrl
         */
        public String getPayPalReturnUrl()
        {
            return payPalReturnUrl;
        }

        /**
         * @param payPalReturnUrl
         *            the payPalReturnUrl to set
         */
        public void setPayPalReturnUrl(String payPalReturnUrl)
        {
            this.payPalReturnUrl = payPalReturnUrl;
        }

        /**
         * @return the payPalCancelUrl
         */
        public String getPayPalCancelUrl()
        {
            return payPalCancelUrl;
        }

        /**
         * @param payPalCancelUrl
         *            the payPalCancelUrl to set
         */
        public void setPayPalCancelUrl(String payPalCancelUrl)
        {
            this.payPalCancelUrl = payPalCancelUrl;
        }

        /**
         * @return the payPalTestMode
         */
        public boolean isPayPalTestMode()
        {
            return payPalTestMode;
        }

        /**
         * @param payPalTestMode
         *            the payPalTestMode to set
         */
        public void setPayPalTestMode(boolean payPalTestMode)
        {
            this.payPalTestMode = payPalTestMode;
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
