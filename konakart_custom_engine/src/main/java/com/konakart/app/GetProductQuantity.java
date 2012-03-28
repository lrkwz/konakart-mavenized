package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetProductQuantity - Generated by CreateKKCustomEng
 */
public class GetProductQuantity
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetProductQuantity(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public ProductQuantityIf getProductQuantity(String encodedProductId) throws KKException
     {
         return kkEng.getProductQuantity(encodedProductId);
     }
}
