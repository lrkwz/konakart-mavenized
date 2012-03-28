package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetCustomerTagsForGuest - Generated by CreateKKCustomEng
 */
public class GetCustomerTagsForGuest
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetCustomerTagsForGuest(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public CustomerTagIf[] getCustomerTagsForGuest(int customerId) throws KKException
     {
         return kkEng.getCustomerTagsForGuest(customerId);
     }
}
