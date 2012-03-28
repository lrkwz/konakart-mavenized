package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - AddCategoriesToTagGroups - Generated by CreateKKAdminCustomEng
 */
public class AddCategoriesToTagGroups
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public AddCategoriesToTagGroups(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void addCategoriesToTagGroups(String sessionId, int tagGroupId, int[] categories) throws KKAdminException
     {
         kkAdminEng.addCategoriesToTagGroups(sessionId, tagGroupId, categories);
     }
}
