package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteMiscItemType - Generated by CreateKKAdminCustomEng
 */
public class DeleteMiscItemType
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteMiscItemType(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deleteMiscItemType(String sessionId, int miTypeId, boolean deleteChildren) throws KKAdminException
     {
         kkAdminEng.deleteMiscItemType(sessionId, miTypeId, deleteChildren);
     }
}
