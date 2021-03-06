package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetCatalogById - Generated by CreateKKAdminCustomEng
 */
public class GetCatalogById
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetCatalogById(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminCatalog getCatalogById(String sessionId, int catalogId) throws KKAdminException
     {
         return kkAdminEng.getCatalogById(sessionId, catalogId);
     }
}
