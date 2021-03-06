package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - InsertTagGroupToTags - Generated by CreateKKAdminCustomEng
 */
public class InsertTagGroupToTags
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public InsertTagGroupToTags(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void insertTagGroupToTags(String sessionId, AdminTagGroupToTag tagGroupToTag) throws KKAdminException
     {
         kkAdminEng.insertTagGroupToTags(sessionId, tagGroupToTag);
     }
}
