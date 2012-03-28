package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetWishListWithItemsWithOptions - Generated by CreateKKCustomEng
 */
public class GetWishListWithItemsWithOptions
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetWishListWithItemsWithOptions(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public WishListIf getWishListWithItemsWithOptions(String sessionId, int wishListId, int languageId, AddToWishListOptionsIf options) throws KKException
     {
         return kkEng.getWishListWithItemsWithOptions(sessionId, wishListId, languageId, options);
     }
}
