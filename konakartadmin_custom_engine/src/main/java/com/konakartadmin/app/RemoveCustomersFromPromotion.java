package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - RemoveCustomersFromPromotion - Generated by CreateKKAdminCustomEng
 */
public class RemoveCustomersFromPromotion
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public RemoveCustomersFromPromotion(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void removeCustomersFromPromotion(String sessionId, AdminCustomer[] customers, int promotionId) throws KKAdminException
     {
         kkAdminEng.removeCustomersFromPromotion(sessionId, customers, promotionId);
     }
}
