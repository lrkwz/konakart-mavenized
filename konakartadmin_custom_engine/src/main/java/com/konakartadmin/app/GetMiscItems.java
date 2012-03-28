package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetMiscItems - Generated by CreateKKAdminCustomEng
 */
public class GetMiscItems
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetMiscItems(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminMiscItemSearchResult getMiscItems(String sessionId, AdminSearch search, int offset, int size) throws KKAdminException
     {
         return kkAdminEng.getMiscItems(sessionId, search, offset, size);
     }
}
