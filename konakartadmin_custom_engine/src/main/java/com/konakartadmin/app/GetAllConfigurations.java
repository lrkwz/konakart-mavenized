package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetAllConfigurations - Generated by CreateKKAdminCustomEng
 */
public class GetAllConfigurations
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetAllConfigurations(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public KKConfiguration[] getAllConfigurations(String sessionId) throws KKAdminException
     {
         return kkAdminEng.getAllConfigurations(sessionId);
     }
}
