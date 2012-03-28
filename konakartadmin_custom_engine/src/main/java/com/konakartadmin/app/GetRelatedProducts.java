package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetRelatedProducts - Generated by CreateKKAdminCustomEng
 */
public class GetRelatedProducts
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetRelatedProducts(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminProducts getRelatedProducts(String sessionId, AdminDataDescriptor dataDesc, int productId, int relationType, int languageId) throws KKAdminException
     {
         return kkAdminEng.getRelatedProducts(sessionId, dataDesc, productId, relationType, languageId);
     }
}
