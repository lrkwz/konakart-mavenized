package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - InsertCustomerTag - Generated by CreateKKCustomEng
 */
public class InsertCustomerTag
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public InsertCustomerTag(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void insertCustomerTag(String sessionId, CustomerTagIf tag) throws KKException
     {
         kkEng.insertCustomerTag(sessionId, tag);
     }
}
