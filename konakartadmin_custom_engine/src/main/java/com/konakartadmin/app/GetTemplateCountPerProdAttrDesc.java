package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetTemplateCountPerProdAttrDesc - Generated by CreateKKAdminCustomEng
 */
public class GetTemplateCountPerProdAttrDesc
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetTemplateCountPerProdAttrDesc(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int getTemplateCountPerProdAttrDesc(String sessionId, int attrDescId) throws KKAdminException
     {
         return kkAdminEng.getTemplateCountPerProdAttrDesc(sessionId, attrDescId);
     }
}
