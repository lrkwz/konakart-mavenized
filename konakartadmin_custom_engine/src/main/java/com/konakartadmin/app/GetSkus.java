package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetSkus - Generated by CreateKKAdminCustomEng
 */
public class GetSkus
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetSkus(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public String[] getSkus(String sessionId, AdminOrderProduct[] orderProds) throws KKAdminException
     {
         return kkAdminEng.getSkus(sessionId, orderProds);
     }
}
