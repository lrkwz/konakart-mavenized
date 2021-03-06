package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetSearchRules - Generated by CreateKKAdminCustomEng
 */
public class GetSearchRules
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetSearchRules(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminSearchRule[] getSearchRules() throws KKAdminException
     {
         return kkAdminEng.getSearchRules();
     }
}
