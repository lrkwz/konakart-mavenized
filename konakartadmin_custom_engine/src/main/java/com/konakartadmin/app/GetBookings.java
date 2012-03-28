package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetBookings - Generated by CreateKKAdminCustomEng
 */
public class GetBookings
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetBookings(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminBookingSearchResult getBookings(String sessionId, AdminBookingSearch search, int offset, int size, AdminBookableProductOptions options) throws KKAdminException
     {
         return kkAdminEng.getBookings(sessionId, search, offset, size, options);
     }
}
