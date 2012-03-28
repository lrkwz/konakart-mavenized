package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteCustomerGroup - Generated by CreateKKAdminCustomEng
 */
public class DeleteCustomerGroup
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteCustomerGroup(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int deleteCustomerGroup(String sessionId, int custGroupId) throws KKAdminException
     {
         return kkAdminEng.deleteCustomerGroup(sessionId, custGroupId);
     }
}
