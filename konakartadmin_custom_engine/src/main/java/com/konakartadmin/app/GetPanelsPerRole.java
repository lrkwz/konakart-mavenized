package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetPanelsPerRole - Generated by CreateKKAdminCustomEng
 */
public class GetPanelsPerRole
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetPanelsPerRole(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminPanel[] getPanelsPerRole(String sessionId, int roleId) throws KKAdminException
     {
         return kkAdminEng.getPanelsPerRole(sessionId, roleId);
     }
}
