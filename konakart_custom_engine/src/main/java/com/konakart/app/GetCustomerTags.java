package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetCustomerTags - Generated by CreateKKCustomEng
 */
public class GetCustomerTags
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetCustomerTags(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public CustomerTagIf[] getCustomerTags(String sessionId) throws KKException
     {
         return kkEng.getCustomerTags(sessionId);
     }
}
