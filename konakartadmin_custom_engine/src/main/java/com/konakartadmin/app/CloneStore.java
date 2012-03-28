package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - CloneStore - Generated by CreateKKAdminCustomEng
 */
public class CloneStore
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public CloneStore(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void cloneStore(String sessionId, AdminNewStoreOptions options, String storeToCloneId, AdminStore newStore) throws KKAdminException
     {
         kkAdminEng.cloneStore(sessionId, options, storeToCloneId, newStore);
     }
}
