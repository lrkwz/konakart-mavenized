package com.konakart.app;

/**
 *  The KonaKart Custom Engine - IsEmailValid - Generated by CreateKKCustomEng
 */
public class IsEmailValid
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public IsEmailValid(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public boolean isEmailValid(String emailAddr) throws KKException
     {
         return kkEng.isEmailValid(emailAddr);
     }
}
