package com.konakart.app;

/**
 *  The KonaKart Custom Engine - UpdateProductViewedCount - Generated by CreateKKCustomEng
 */
public class UpdateProductViewedCount
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public UpdateProductViewedCount(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void updateProductViewedCount(int productId, int languageId) throws KKException
     {
         kkEng.updateProductViewedCount(productId, languageId);
     }
}
