package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - SearchForIpnHistory - Generated by CreateKKAdminCustomEng
 */
public class SearchForIpnHistory
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public SearchForIpnHistory(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminIpnHistories searchForIpnHistory(String sessionId, AdminDataDescriptor dataDesc, AdminIpnSearch ipnSearch) throws KKAdminException
     {
         return kkAdminEng.searchForIpnHistory(sessionId, dataDesc, ipnSearch);
     }
}
