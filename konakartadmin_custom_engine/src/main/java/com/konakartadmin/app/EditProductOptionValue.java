package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - EditProductOptionValue - Generated by CreateKKAdminCustomEng
 */
public class EditProductOptionValue
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public EditProductOptionValue(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void editProductOptionValue(String sessionId, AdminProductOptionValue productOptionValue) throws KKAdminException
     {
         kkAdminEng.editProductOptionValue(sessionId, productOptionValue);
     }
}
