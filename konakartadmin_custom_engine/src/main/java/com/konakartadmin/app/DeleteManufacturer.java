package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteManufacturer - Generated by CreateKKAdminCustomEng
 */
public class DeleteManufacturer
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteManufacturer(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deleteManufacturer(String sessionId, int manufacturerId, boolean deleteProducts) throws KKAdminException
     {
         kkAdminEng.deleteManufacturer(sessionId, manufacturerId, deleteProducts);
     }
}
