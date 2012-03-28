package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteBooking - Generated by CreateKKAdminCustomEng
 */
public class DeleteBooking
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteBooking(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deleteBooking(String sessionId, int bookingId, AdminBookableProductOptions options) throws KKAdminException
     {
         kkAdminEng.deleteBooking(sessionId, bookingId, options);
     }
}
