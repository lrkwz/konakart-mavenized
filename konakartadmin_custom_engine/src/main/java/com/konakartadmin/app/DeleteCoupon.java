package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteCoupon - Generated by CreateKKAdminCustomEng
 */
public class DeleteCoupon
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteCoupon(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deleteCoupon(String sessionId, int couponId) throws KKAdminException
     {
         kkAdminEng.deleteCoupon(sessionId, couponId);
     }
}
