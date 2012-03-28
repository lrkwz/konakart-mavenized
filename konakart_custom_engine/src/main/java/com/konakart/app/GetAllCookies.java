package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetAllCookies - Generated by CreateKKCustomEng
 */
public class GetAllCookies
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetAllCookies(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public KKCookieIf[] getAllCookies(String customerUuid) throws KKException
     {
         return kkEng.getAllCookies(customerUuid);
     }
}
