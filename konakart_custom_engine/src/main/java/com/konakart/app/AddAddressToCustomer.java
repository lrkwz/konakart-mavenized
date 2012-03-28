package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - AddAddressToCustomer - Generated by CreateKKCustomEng
 */
public class AddAddressToCustomer
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public AddAddressToCustomer(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public int addAddressToCustomer(String sessionId, AddressIf addr) throws KKException
     {
         return kkEng.addAddressToCustomer(sessionId, addr);
     }
}
