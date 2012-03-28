package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetTaxRates - Generated by CreateKKAdminCustomEng
 */
public class GetTaxRates
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetTaxRates(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminTaxRateSearchResult getTaxRates(AdminTaxRateSearch search, int offset, int size) throws KKAdminException
     {
         return kkAdminEng.getTaxRates(search, offset, size);
     }
}
