package com.konakart.app;

/**
 *  The KonaKart Custom Engine - DeleteOrderIdForSecretKey - Generated by CreateKKCustomEng
 */
public class DeleteOrderIdForSecretKey
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public DeleteOrderIdForSecretKey(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void deleteOrderIdForSecretKey(String secretKey) throws KKException
     {
         kkEng.deleteOrderIdForSecretKey(secretKey);
     }
}
