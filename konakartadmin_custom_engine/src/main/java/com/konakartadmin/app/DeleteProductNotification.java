package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteProductNotification - Generated by CreateKKAdminCustomEng
 */
public class DeleteProductNotification
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteProductNotification(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deleteProductNotification(String sessionId, AdminProductNotification apn) throws KKAdminException
     {
         kkAdminEng.deleteProductNotification(sessionId, apn);
     }
}
