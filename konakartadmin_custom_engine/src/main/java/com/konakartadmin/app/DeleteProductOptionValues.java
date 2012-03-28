package com.konakartadmin.app;

import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - DeleteProductOptionValues - Generated by CreateKKAdminCustomEng
 */
public class DeleteProductOptionValues
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public DeleteProductOptionValues(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void deleteProductOptionValues(String sessionId, int productOptionValueId) throws KKAdminException
     {
         kkAdminEng.deleteProductOptionValues(sessionId, productOptionValueId);
     }
}
