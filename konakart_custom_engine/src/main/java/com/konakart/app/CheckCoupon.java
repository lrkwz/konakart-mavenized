package com.konakart.app;

/**
 *  The KonaKart Custom Engine - CheckCoupon - Generated by CreateKKCustomEng
 */
public class CheckCoupon
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public CheckCoupon(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public int checkCoupon(String couponCode) throws KKException
     {
         return kkEng.checkCoupon(couponCode);
     }
}
