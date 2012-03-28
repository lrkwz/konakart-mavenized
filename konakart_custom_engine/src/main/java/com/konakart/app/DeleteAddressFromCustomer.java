package com.konakart.app;

/**
 *  The KonaKart Custom Engine - DeleteAddressFromCustomer - Generated by CreateKKCustomEng
 */
public class DeleteAddressFromCustomer
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public DeleteAddressFromCustomer(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void deleteAddressFromCustomer(String sessionId, int addressId) throws KKException
     {
         kkEng.deleteAddressFromCustomer(sessionId, addressId);
     }
}
