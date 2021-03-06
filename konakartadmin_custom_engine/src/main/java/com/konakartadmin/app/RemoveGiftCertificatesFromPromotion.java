package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - RemoveGiftCertificatesFromPromotion - Generated by CreateKKAdminCustomEng
 */
public class RemoveGiftCertificatesFromPromotion
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public RemoveGiftCertificatesFromPromotion(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void removeGiftCertificatesFromPromotion(String sessionId, AdminProduct[] giftCertificates, int promotionId) throws KKAdminException
     {
         kkAdminEng.removeGiftCertificatesFromPromotion(sessionId, giftCertificates, promotionId);
     }
}
