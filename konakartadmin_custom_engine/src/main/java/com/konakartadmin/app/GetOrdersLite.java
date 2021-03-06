package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetOrdersLite - Generated by CreateKKAdminCustomEng
 */
public class GetOrdersLite
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetOrdersLite(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminOrderSearchResult getOrdersLite(String sessionId, AdminOrderSearch search, int offset, int size, int languageId) throws KKAdminException
     {
         return kkAdminEng.getOrdersLite(sessionId, search, offset, size, languageId);
     }
}
