package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetReview - Generated by CreateKKCustomEng
 */
public class GetReview
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetReview(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public ReviewIf getReview(int reviewId) throws KKException
     {
         return kkEng.getReview(reviewId);
     }
}
