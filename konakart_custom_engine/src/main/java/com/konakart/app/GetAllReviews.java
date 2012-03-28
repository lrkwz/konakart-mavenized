package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetAllReviews - Generated by CreateKKCustomEng
 */
public class GetAllReviews
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetAllReviews(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public ReviewsIf getAllReviews(DataDescriptorIf dataDesc) throws KKException
     {
         return kkEng.getAllReviews(dataDesc);
     }
}
