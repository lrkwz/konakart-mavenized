package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - InsertProductOption - Generated by CreateKKAdminCustomEng
 */
public class InsertProductOption
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public InsertProductOption(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void insertProductOption(String sessionId, AdminProductOption productOption) throws KKAdminException
     {
         kkAdminEng.insertProductOption(sessionId, productOption);
     }
}
