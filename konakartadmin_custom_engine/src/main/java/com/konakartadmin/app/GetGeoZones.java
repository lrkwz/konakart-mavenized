package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetGeoZones - Generated by CreateKKAdminCustomEng
 */
public class GetGeoZones
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetGeoZones(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminGeoZoneSearchResult getGeoZones(AdminGeoZoneSearch search, int offset, int size) throws KKAdminException
     {
         return kkAdminEng.getGeoZones(search, offset, size);
     }
}
