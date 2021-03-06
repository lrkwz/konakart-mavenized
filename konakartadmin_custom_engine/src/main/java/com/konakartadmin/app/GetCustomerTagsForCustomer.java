package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetCustomerTagsForCustomer - Generated by CreateKKAdminCustomEng
 */
public class GetCustomerTagsForCustomer
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetCustomerTagsForCustomer(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminCustomerTag[] getCustomerTagsForCustomer(String sessionId, int customerId) throws KKAdminException
     {
         return kkAdminEng.getCustomerTagsForCustomer(sessionId, customerId);
     }
}
