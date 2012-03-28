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

package com.konakart.bl.modules.payment.caledon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
 * Caledon module. This payment module allows for credit card credentials to be collected directly
 * from a KonaKart page. All communication to the Caledon server is done from the KonaKart server.
 * 
 */
public class Caledon extends BasePaymentModule implements PaymentInterface
{
    // Module name must be the same as the class name
    private static String code = "caledon";

    private static int sortOrder = -1;

    // The Caledon Url used to POST the payment request.
    // https://lt3a.caledoncard.com/
    private static String caledonRequestUrl;

    // Terminal ID
    //private static String caledonTerminalId;

    // Password
    //private static String caledonPassword;

    // Show the CVV entry field on the UI
    private static boolean showCVV = true;

    // zone where caledon will be made available
    private static int zone;

    private static String bundleName = BaseModule.basePackage + ".payment.caledon.Caledon";

    private static HashMap<Locale, ResourceBundle> resourceBundleMap = new HashMap<Locale, ResourceBundle>();

    private static String mutex = "caledonMutex";

    // Configuration Keys

    /**
     * Used to put the gateway online / offline
     */
    private final static String MODULE_PAYMENT_CALEDON_STATUS = "MODULE_PAYMENT_CALEDON_STATUS";

    /**
     * The Caledon zone, if greater than zero, should reference a GeoZone. If the DeliveryAddress of
     * the order isn't within that GeoZone, then we throw an exception
     */
    private final static String MODULE_PAYMENT_CALEDON_ZONE = "MODULE_PAYMENT_CALEDON_ZONE";

    /**
     * The order for displaying this payment gateway on the UI
     */
    private final static String MODULE_PAYMENT_CALEDON_SORT_ORDER = "MODULE_PAYMENT_CALEDON_SORT_ORDER";

    /**
     * The Caledon Url used to POST the payment request. https://lt3a.caledoncard.com/
     */
    private final static String MODULE_PAYMENT_CALEDON_REQUEST_URL = "MODULE_PAYMENT_CALEDON_REQUEST_URL";

    /**
     * The Terminal ID used for the Caledon service
     */
    //private final static String MODULE_PAYMENT_CALEDON_TERMINAL_ID = "MODULE_PAYMENT_CALEDON_TERMINAL_ID";

    /**
     * Password for this terminal ID
     */
    //private final static String MODULE_PAYMENT_CALEDON_PASSWORD = "MODULE_PAYMENT_CALEDON_PASSWORD";

    /**
     * To show CVV field
     */
    private final static String MODULE_PAYMENT_CALEDON_SHOW_CVV = "MODULE_PAYMENT_CALEDON_SHOW_CVV";

    // Message Catalogue Keys
    private final static String MODULE_PAYMENT_CALEDON_TEXT_TITLE = "module.payment.caledon.text.title";

    private final static String MODULE_PAYMENT_CALEDON_TEXT_DESCRIPTION = "module.payment.caledon.text.description";

    /**
     * Constructor
     * 
     * @param eng
     * 
     * @throws KKException
     */
    public Caledon(KKEngIf eng) throws KKException
    {
        super.init(eng);

        // Initialise the static variables
        if (sortOrder == -1)
        {
            synchronized (mutex)
            {
                if (sortOrder == -1)
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
     */
    public void setStaticVariables() throws KKException
    {
        KKConfiguration conf;

        conf = getEng().getConfiguration(MODULE_PAYMENT_CALEDON_REQUEST_URL);
        if (conf == null)
        {
            throw new KKException(
                    "The Configuration MODULE_PAYMENT_CALEDON_REQUEST_URL must be set to the URL for"
                            + " sending the request to Caledon. (e.g. https://lt3a.caledoncard.com/)");
        }
        caledonRequestUrl = conf.getValue();

//        conf = getEng().getConfiguration(MODULE_PAYMENT_CALEDON_TERMINAL_ID);
//        if (conf == null)
//        {
//            throw new KKException(
//                    "The Configuration MODULE_PAYMENT_CALEDON_TERMINAL_ID must be set to the"
//                            + " Terminal ID for this installation");
//        }
//        caledonTerminalId = conf.getValue();
//
//        /*
//         * Password isn't always required if the ip address is fixed
//         */
//        conf = getEng().getConfiguration(MODULE_PAYMENT_CALEDON_PASSWORD);
//        caledonPassword = conf.getValue();

        conf = getEng().getConfiguration(MODULE_PAYMENT_CALEDON_ZONE);
        if (conf == null)
        {
            zone = 0;
        } else
        {
            zone = new Integer(conf.getValue()).intValue();
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_CALEDON_SORT_ORDER);
        if (conf == null)
        {
            sortOrder = 0;
        } else
        {
            sortOrder = new Integer(conf.getValue()).intValue();
        }

        conf = getEng().getConfiguration(MODULE_PAYMENT_CALEDON_SHOW_CVV);
        if (conf == null)
        {
            showCVV = true;
        } else
        {
            if (conf.getValue().trim().equalsIgnoreCase("false"))
            {
                showCVV = false;
            } else
            {
                showCVV = true;
            }
        }
    }

    /**
     * Return a payment details object for Caledon module
     * 
     * @param order
     * @param info
     * @return Returns information in a PaymentDetails object
     * @throws Exception
     */
    public PaymentDetails getPaymentDetails(Order order, PaymentInfo info) throws Exception
    {

        /*
         * The caledonZone zone, if greater than zero, should reference a GeoZone. If the
         * DeliveryAddress of the order isn't within that GeoZone, then we throw an exception
         */
        if (zone > 0)
        {
            checkZone(info, zone);
        }

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
        pDetails.setSortOrder(sortOrder);
        pDetails.setPaymentType(PaymentDetails.SERVER_PAYMENT_GATEWAY);
        pDetails.setDescription(rb.getString(MODULE_PAYMENT_CALEDON_TEXT_DESCRIPTION));
        pDetails.setTitle(rb.getString(MODULE_PAYMENT_CALEDON_TEXT_TITLE));

        // Return now if the full payment details aren't required. This happens when the manager
        // just wants a list of payment gateways to display in the UI.
        if (info.isReturnDetails() == false)
        {
            return pDetails;
        }

        pDetails.setPostOrGet("get");
        pDetails.setRequestUrl(caledonRequestUrl);

        List<NameValue> parmList = new ArrayList<NameValue>();

        /*
         * Terminal ID and password are added in CaledonAction since they can vary based on the
         * Credit Card used
         */
        // parmList.add(new NameValue("TERMID", caledonTerminalId));
        // if (caledonPassword != null && caledonPassword.length() > 0)
        // {
        // parmList.add(new NameValue("PASS", caledonPassword));
        // }
        parmList.add(new NameValue("TYPE", "S"));

        // caledon requires details of the final price in cents - inclusive of tax.
        int total = 0;
        for (int i = 0; i < order.getOrderTotals().length; i++)
        {
            OrderTotal ot = (OrderTotal) order.getOrderTotals()[i];
            if (ot.getClassName().equals(OrderTotalMgr.ot_total))
            {
                total = (ot.getValue().multiply(new BigDecimal(100))).intValue();
            }
        }

        parmList.add(new NameValue("AMT", String.valueOf(total)));
        parmList.add(new NameValue("REF", order.getId()));

        // Put the parameters into an array
        NameValue[] nvArray = new NameValue[parmList.size()];
        parmList.toArray(nvArray);
        pDetails.setParameters(nvArray);

        // Set the fields that should be visible in the UI when gathering Credit Card details
        pDetails.setShowAddr(false);
        pDetails.setShowCVV(showCVV);
        pDetails.setShowPostcode(false);
        pDetails.setShowType(false); // Caledon doesn't require the card type
        pDetails.setShowOwner(false);

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
        return isAvailable(getEng(), MODULE_PAYMENT_CALEDON_STATUS);
    }
}