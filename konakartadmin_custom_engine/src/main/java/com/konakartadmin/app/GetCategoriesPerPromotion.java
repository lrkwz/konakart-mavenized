package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetCategoriesPerPromotion - Generated by CreateKKAdminCustomEng
 */
public class GetCategoriesPerPromotion
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetCategoriesPerPromotion(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminCategory[] getCategoriesPerPromotion(String sessionId, int promotionId, int languageId) throws KKAdminException
     {
         return kkAdminEng.getCategoriesPerPromotion(sessionId, promotionId, languageId);
     }
}
