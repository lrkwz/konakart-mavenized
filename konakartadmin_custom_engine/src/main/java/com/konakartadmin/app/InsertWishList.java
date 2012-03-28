package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - InsertWishList - Generated by CreateKKAdminCustomEng
 */
public class InsertWishList
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public InsertWishList(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int insertWishList(String sessionId, AdminWishList wishList) throws KKAdminException
     {
         return kkAdminEng.insertWishList(sessionId, wishList);
     }
}
