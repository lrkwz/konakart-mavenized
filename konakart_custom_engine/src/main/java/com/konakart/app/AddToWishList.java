package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - AddToWishList - Generated by CreateKKCustomEng
 */
public class AddToWishList
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public AddToWishList(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public int addToWishList(String sessionId, WishListItemIf wishListItem) throws KKException
     {
         return kkEng.addToWishList(sessionId, wishListItem);
     }
}
