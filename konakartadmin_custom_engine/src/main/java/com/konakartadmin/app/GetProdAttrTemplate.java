package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetProdAttrTemplate - Generated by CreateKKAdminCustomEng
 */
public class GetProdAttrTemplate
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetProdAttrTemplate(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminProdAttrTemplate getProdAttrTemplate(String sessionId, int id) throws KKAdminException
     {
         return kkAdminEng.getProdAttrTemplate(sessionId, id);
     }
}
