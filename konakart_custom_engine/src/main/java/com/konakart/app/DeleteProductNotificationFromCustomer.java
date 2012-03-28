package com.konakart.app;

/**
 *  The KonaKart Custom Engine - DeleteProductNotificationFromCustomer - Generated by CreateKKCustomEng
 */
public class DeleteProductNotificationFromCustomer
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public DeleteProductNotificationFromCustomer(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void deleteProductNotificationFromCustomer(String sessionId, int productId) throws KKException
     {
         kkEng.deleteProductNotificationFromCustomer(sessionId, productId);
     }
}
