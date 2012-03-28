package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - InsertAddressFormat - Generated by CreateKKAdminCustomEng
 */
public class InsertAddressFormat
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public InsertAddressFormat(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int insertAddressFormat(String sessionId, AdminAddressFormat insertObj) throws KKAdminException
     {
         return kkAdminEng.insertAddressFormat(sessionId, insertObj);
     }
}
