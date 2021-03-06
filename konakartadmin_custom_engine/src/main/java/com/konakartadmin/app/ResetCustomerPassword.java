package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - ResetCustomerPassword - Generated by CreateKKAdminCustomEng
 */
public class ResetCustomerPassword
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public ResetCustomerPassword(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void resetCustomerPassword(String sessionId, int custId) throws KKAdminException
     {
         kkAdminEng.resetCustomerPassword(sessionId, custId);
     }
}
