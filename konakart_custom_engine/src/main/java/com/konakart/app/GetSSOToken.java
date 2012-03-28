package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetSSOToken - Generated by CreateKKCustomEng
 */
public class GetSSOToken
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetSSOToken(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public SSOTokenIf getSSOToken(String secretKey, boolean deleteToken) throws KKException
     {
         return kkEng.getSSOToken(secretKey, deleteToken);
     }
}
