package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteRole - Generated by CreateKKAdminCustomEng
 */
public class DeleteRole
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteRole(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deleteRole(String sessionId, int roleId) throws KKAdminException
     {
         kkAdminEng.deleteRole(sessionId, roleId);
     }
}
