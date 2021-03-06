package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - SetProductQuantityWithOptions - Generated by CreateKKAdminCustomEng
 */
public class SetProductQuantityWithOptions
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public SetProductQuantityWithOptions(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void setProductQuantityWithOptions(String sessionId, String sku, int id, int quantity, int operation, AdminProductMgrOptions mgrOptions) throws Exception
     {
         kkAdminEng.setProductQuantityWithOptions(sessionId, sku, id, quantity, operation, mgrOptions);
     }
}
