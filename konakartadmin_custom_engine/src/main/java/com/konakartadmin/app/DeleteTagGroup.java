package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteTagGroup - Generated by CreateKKAdminCustomEng
 */
public class DeleteTagGroup
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteTagGroup(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deleteTagGroup(String sessionId, int id) throws KKAdminException
     {
         kkAdminEng.deleteTagGroup(sessionId, id);
     }
}
