package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetCustomerGroup - Generated by CreateKKCustomEng
 */
public class GetCustomerGroup
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetCustomerGroup(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public CustomerGroupIf getCustomerGroup(int customerGroupId, int languageId) throws KKException
     {
         return kkEng.getCustomerGroup(customerGroupId, languageId);
     }
}
