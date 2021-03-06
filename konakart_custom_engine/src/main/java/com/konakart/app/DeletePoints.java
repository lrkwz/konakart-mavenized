package com.konakart.app;

/**
 *  The KonaKart Custom Engine - DeletePoints - Generated by CreateKKCustomEng
 */
public class DeletePoints
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public DeletePoints(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public int deletePoints(String sessionId, int points, String code, String description) throws KKException
     {
         return kkEng.deletePoints(sessionId, points, code, description);
     }
}
