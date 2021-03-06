package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetAllProductOptionValues - Generated by CreateKKAdminCustomEng
 */
public class GetAllProductOptionValues
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetAllProductOptionValues(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminProductOptionValue[] getAllProductOptionValues(String sessionId, int languageId) throws KKAdminException
     {
         return kkAdminEng.getAllProductOptionValues(sessionId, languageId);
     }
}
