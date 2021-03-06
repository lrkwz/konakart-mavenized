package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeletePromotion - Generated by CreateKKAdminCustomEng
 */
public class DeletePromotion
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeletePromotion(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deletePromotion(String sessionId, int promotionId) throws KKAdminException
     {
         kkAdminEng.deletePromotion(sessionId, promotionId);
     }
}
