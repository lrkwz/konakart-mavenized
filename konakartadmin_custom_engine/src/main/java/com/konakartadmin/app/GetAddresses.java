package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetAddresses - Generated by CreateKKAdminCustomEng
 */
public class GetAddresses
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetAddresses(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminAddressSearchResult getAddresses(String sessionId, AdminAddressSearch search, int offset, int size) throws KKAdminException
     {
         return kkAdminEng.getAddresses(sessionId, search, offset, size);
     }
}
