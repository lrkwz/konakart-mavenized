package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - InsertMiscItems - Generated by CreateKKAdminCustomEng
 */
public class InsertMiscItems
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public InsertMiscItems(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int insertMiscItems(String sessionId, AdminMiscItem[] miTypes) throws KKAdminException
     {
         return kkAdminEng.insertMiscItems(sessionId, miTypes);
     }
}
