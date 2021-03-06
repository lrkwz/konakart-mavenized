package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetAllGeoZones - Generated by CreateKKAdminCustomEng
 */
public class GetAllGeoZones
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetAllGeoZones(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminGeoZone[] getAllGeoZones() throws KKAdminException
     {
         return kkAdminEng.getAllGeoZones();
     }
}
