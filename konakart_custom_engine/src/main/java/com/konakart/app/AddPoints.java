package com.konakart.app;

/**
 *  The KonaKart Custom Engine - AddPoints - Generated by CreateKKCustomEng
 */
public class AddPoints
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public AddPoints(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public int addPoints(String sessionId, int points, String code, String description) throws KKException
     {
         return kkEng.addPoints(sessionId, points, code, description);
     }
}
