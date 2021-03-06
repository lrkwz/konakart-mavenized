package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetMiscItemTypes - Generated by CreateKKAdminCustomEng
 */
public class GetMiscItemTypes
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetMiscItemTypes(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminMiscItemType[] getMiscItemTypes(String sessionId, AdminSearch search, int offset, int size) throws KKAdminException
     {
         return kkAdminEng.getMiscItemTypes(sessionId, search, offset, size);
     }
}
