package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetProductCountPerProdAttrDesc - Generated by CreateKKAdminCustomEng
 */
public class GetProductCountPerProdAttrDesc
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetProductCountPerProdAttrDesc(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int getProductCountPerProdAttrDesc(String sessionId, int attrDescId) throws KKAdminException
     {
         return kkAdminEng.getProductCountPerProdAttrDesc(sessionId, attrDescId);
     }
}
