package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeletePanel - Generated by CreateKKAdminCustomEng
 */
public class DeletePanel
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeletePanel(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deletePanel(String sessionId, int panelId) throws KKAdminException
     {
         kkAdminEng.deletePanel(sessionId, panelId);
     }
}
