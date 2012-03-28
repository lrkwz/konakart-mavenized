package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DoesProductExist - Generated by CreateKKAdminCustomEng
 */
public class DoesProductExist
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DoesProductExist(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public boolean doesProductExist(String sessionId, int productId) throws KKAdminException
     {
         return kkAdminEng.doesProductExist(sessionId, productId);
     }
}
