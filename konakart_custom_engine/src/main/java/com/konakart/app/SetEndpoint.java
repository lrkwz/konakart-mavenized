package com.konakart.app;

/**
 *  The KonaKart Custom Engine - SetEndpoint - Generated by CreateKKCustomEng
 */
public class SetEndpoint
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public SetEndpoint(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void setEndpoint(String wsEndpoint) throws KKException
     {
         kkEng.setEndpoint(wsEndpoint);
     }
}
