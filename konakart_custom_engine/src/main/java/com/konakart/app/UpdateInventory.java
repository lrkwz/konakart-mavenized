package com.konakart.app;

/**
 *  The KonaKart Custom Engine - UpdateInventory - Generated by CreateKKCustomEng
 */
public class UpdateInventory
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public UpdateInventory(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void updateInventory(String sessionId, int orderId) throws KKException
     {
         kkEng.updateInventory(sessionId, orderId);
     }
}
