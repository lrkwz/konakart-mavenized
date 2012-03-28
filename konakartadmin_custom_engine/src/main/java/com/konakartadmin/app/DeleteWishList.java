package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteWishList - Generated by CreateKKAdminCustomEng
 */
public class DeleteWishList
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteWishList(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deleteWishList(String sessionId, int wishListId) throws KKAdminException
     {
         kkAdminEng.deleteWishList(sessionId, wishListId);
     }
}
