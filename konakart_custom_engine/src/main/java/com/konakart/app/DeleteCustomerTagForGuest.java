package com.konakart.app;

/**
 *  The KonaKart Custom Engine - DeleteCustomerTagForGuest - Generated by CreateKKCustomEng
 */
public class DeleteCustomerTagForGuest
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public DeleteCustomerTagForGuest(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void deleteCustomerTagForGuest(int customerId, String tagName) throws KKException
     {
         kkEng.deleteCustomerTagForGuest(customerId, tagName);
     }
}
