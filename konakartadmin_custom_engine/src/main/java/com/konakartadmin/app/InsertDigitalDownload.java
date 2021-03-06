package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - InsertDigitalDownload - Generated by CreateKKAdminCustomEng
 */
public class InsertDigitalDownload
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public InsertDigitalDownload(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void insertDigitalDownload(String sessionId, int customerId, int productId) throws KKAdminException
     {
         kkAdminEng.insertDigitalDownload(sessionId, customerId, productId);
     }
}
