package com.konakart.app;

/**
 *  The KonaKart Custom Engine - EditConfiguration - Generated by CreateKKCustomEng
 */
public class EditConfiguration
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public EditConfiguration(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void editConfiguration(String key, String value) throws KKException
     {
         kkEng.editConfiguration(key, value);
     }
}
