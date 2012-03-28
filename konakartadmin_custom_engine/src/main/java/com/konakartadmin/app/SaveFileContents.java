package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - SaveFileContents - Generated by CreateKKAdminCustomEng
 */
public class SaveFileContents
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public SaveFileContents(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void saveFileContents(String sessionId, String fileName, String fileContents) throws KKAdminException
     {
         kkAdminEng.saveFileContents(sessionId, fileName, fileContents);
     }
}
