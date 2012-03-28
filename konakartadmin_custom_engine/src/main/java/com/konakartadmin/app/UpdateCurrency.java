package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - UpdateCurrency - Generated by CreateKKAdminCustomEng
 */
public class UpdateCurrency
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public UpdateCurrency(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int updateCurrency(String sessionId, AdminCurrency curr) throws KKAdminException
     {
         return kkAdminEng.updateCurrency(sessionId, curr);
     }
}
