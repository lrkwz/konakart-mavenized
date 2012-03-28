package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - AddApiCallsToRole - Generated by CreateKKAdminCustomEng
 */
public class AddApiCallsToRole
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public AddApiCallsToRole(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void addApiCallsToRole(String sessionId, AdminApiCall[] apiCalls, int roleId) throws KKAdminException
     {
         kkAdminEng.addApiCallsToRole(sessionId, apiCalls, roleId);
     }
}
