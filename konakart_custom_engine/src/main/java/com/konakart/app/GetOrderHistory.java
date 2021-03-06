package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetOrderHistory - Generated by CreateKKCustomEng
 */
public class GetOrderHistory
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetOrderHistory(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public ProductIf[] getOrderHistory(DataDescriptorIf dataDesc, String sessionId, int languageId) throws KKException
     {
         return kkEng.getOrderHistory(dataDesc, sessionId, languageId);
     }
}
