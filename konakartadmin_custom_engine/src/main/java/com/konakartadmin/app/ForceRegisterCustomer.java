package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - ForceRegisterCustomer - Generated by CreateKKAdminCustomEng
 */
public class ForceRegisterCustomer
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public ForceRegisterCustomer(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int forceRegisterCustomer(String sessionId, AdminCustomerRegistration custReg) throws KKAdminException
     {
         return kkAdminEng.forceRegisterCustomer(sessionId, custReg);
     }
}
