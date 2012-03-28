package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - AddAllProductsToSearchEngine - Generated by CreateKKAdminCustomEng
 */
public class AddAllProductsToSearchEngine
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public AddAllProductsToSearchEngine(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void addAllProductsToSearchEngine(String sessionId, boolean async) throws KKAdminException
     {
         kkAdminEng.addAllProductsToSearchEngine(sessionId, async);
     }
}
