package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetOrdersCount - Generated by CreateKKAdminCustomEng
 */
public class GetOrdersCount
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetOrdersCount(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int getOrdersCount(String sessionId, int orderStatus) throws KKAdminException
     {
         return kkAdminEng.getOrdersCount(sessionId, orderStatus);
     }
}
