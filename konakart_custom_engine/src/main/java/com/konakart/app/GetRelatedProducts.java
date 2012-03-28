package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetRelatedProducts - Generated by CreateKKCustomEng
 */
public class GetRelatedProducts
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetRelatedProducts(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public ProductsIf getRelatedProducts(String sessionId, DataDescriptorIf dataDesc, int productId, int relationType, int languageId) throws KKException
     {
         return kkEng.getRelatedProducts(sessionId, dataDesc, productId, relationType, languageId);
     }
}
