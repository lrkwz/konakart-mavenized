package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - RemoveProductFromSearchEngine - Generated by CreateKKAdminCustomEng
 */
public class RemoveProductFromSearchEngine
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public RemoveProductFromSearchEngine(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void removeProductFromSearchEngine(String sessionId, int productId) throws KKAdminException
     {
         kkAdminEng.removeProductFromSearchEngine(sessionId, productId);
     }
}
