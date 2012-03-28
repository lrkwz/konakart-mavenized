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

package com.konakartadmin.modules.payment.epaybg;

import java.util.Date;

import com.konakart.util.Utils;
import com.konakartadmin.app.KKConfiguration;
import com.konakartadmin.bl.KKAdminBase;
import com.konakartadmin.modules.PaymentModule;

/**
 * Epaybg payment module
 * 
 */
public class Epaybg extends PaymentModule
{
    /**
     * @return the config key stub
     */
    public String getConfigKeyStub()
    {
        if (configKeyStub == null)
        {
            setConfigKeyStub(super.getConfigKeyStub() + "_EPAYBG");
        }
        return configKeyStub;
    }

    public String getModuleTitle()
    {
        return getMsgs().getString("MODULE_PAYMENT_EPAYBG_TEXT_TITLE");
    }

    /**
     * @return the implementation filename
     */
    public String getImplementationFileName()
    {
        return "Epaybg";
    }

    /**
     * @return the module code
     */
    public String getModuleCode()
    {
        return "epaybg";
    }

    /**
     * @return an array of configuration values for this payment module
     */
    public KKConfiguration[] getConfigs()
    {
        if (configs == null)
        {
            configs = new KKConfiguration[11];
        }

        if (configs[0] != null && !Utils.isBlank(configs[0].getConfigurationKey()))
        {
            return configs;
        }

        Date now = KKAdminBase.getKonakartTimeStampDate();

        int i = 0;
        int groupId = 6;

        configs[i] = new KKConfiguration(
        /* title */"ePay.bg Status",
        /* key */"MODULE_PAYMENT_EPAYBG_STATUS",
        /* value */"true",
        /* description */"If set to false, the ePay.bg module will be unavailable",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"tep_cfg_select_option(array('true', 'false'), ",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"Sort order of display",
        /* key */"MODULE_PAYMENT_EPAYBG_SORT_ORDER",
        /* value */"0",
        /* description */"Sort Order of ePay.bg module on the UI. Lowest is displayed first.",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"ePay.bg Payment Zone",
        /* key */"MODULE_PAYMENT_EPAYBG_ZONE",
        /* value */"0",
        /* description */"Zone where ePay.bg module can be used. Otherwise it is disabled.",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"tep_get_zone_class_title",
        /* setFun */"tep_cfg_pull_down_zone_classes(",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"Callback username",
        /* key */"MODULE_PAYMENT_EPAYBG_CALLBACK_USERNAME",
        /* value */"myuser",
        /* description */"Valid username for KonaKart. Used by the callback"
                + " code to log into KonaKart in order to make an engine call",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"Callback Password",
        /* key */"MODULE_PAYMENT_EPAYBG_CALLBACK_PASSWORD",
        /* value */"mypassword",
        /* description */"Valid password for KonaKart. Used by the callback"
                + " code to log into KonaKart in order to make an engine call",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"password",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"Approved return URL",
        /* key */"MODULE_PAYMENT_EPAYBG_APPROVE_URL",
        /* value */"http://host:port/konakart/CheckoutFinished.do",
        /* description */"URL to return to when leaving ePay.bg web"
        + " site after a succesful transaction",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"Declined return URL",
        /* key */"MODULE_PAYMENT_EPAYBG_DECLINE_URL",
        /* value */"http://host:port/konakart/CatalogCheckoutExternalPaymentErrorPage.do",
        /* description */"URL to return to when leaving ePay.bg web"
        + " site after an unsuccesful transaction",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"tep_cfg_select_option(array('true', 'false'), ",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"Request URL",
        /* key */"MODULE_PAYMENT_EPAYBG_REQUEST_URL",
        /* value */"https://devep2.datamax.bg/ep2/epay2_demo/",
        /* description */"URL used by KonaKart to send the transaction details",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"Merchant eMail",
        /* key */"MODULE_PAYMENT_EPAYBG_ORDER_PAYMENT_EMAIL",
        /* value */"http://host:port/konakart/CatalogCheckoutExternalPaymentErrorPage.do",
        /* description */"eMail sent to this address for each transaction",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"ePay.bg MIN",
        /* key */"MODULE_PAYMENT_EPAYBG_MIN",
        /* value */"D123456789",
        /* description */"The merchant ePay.bg identification number",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"",
        /* dateAdd */now);

        configs[i] = new KKConfiguration(
        /* title */"Secret Key",
        /* key */"MODULE_PAYMENT_EPAYBG_SECRET",
        /* value */"BHAREQMLVDT2DFREANK1SNOFG6VNEJ5KJUCE2LPHANBDU68XLV3R6KOGWQVASYKZ",
        /* description */"Secret key supplied by ePay.bg",
        /* groupId */groupId,
        /* sortO */i++,
        /* useFun */"",
        /* setFun */"",
        /* dateAdd */now);

        return configs;
    }
}
