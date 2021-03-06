package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetProduct - Generated by CreateKKCustomEng
 */
public class GetProduct
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetProduct(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public ProductIf getProduct(String sessionId, int productId, int languageId) throws KKException
     {
         return kkEng.getProduct(sessionId, productId, languageId);
     }
}
