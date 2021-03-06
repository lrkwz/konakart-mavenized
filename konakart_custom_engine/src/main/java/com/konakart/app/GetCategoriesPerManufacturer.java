package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetCategoriesPerManufacturer - Generated by CreateKKCustomEng
 */
public class GetCategoriesPerManufacturer
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetCategoriesPerManufacturer(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public CategoryIf[] getCategoriesPerManufacturer(int manufacturerId, int languageId) throws KKException
     {
         return kkEng.getCategoriesPerManufacturer(manufacturerId, languageId);
     }
}
