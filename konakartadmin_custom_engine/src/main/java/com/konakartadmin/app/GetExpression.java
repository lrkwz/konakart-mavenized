package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetExpression - Generated by CreateKKAdminCustomEng
 */
public class GetExpression
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetExpression(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminExpression getExpression(String sessionId, int id) throws KKAdminException
     {
         return kkAdminEng.getExpression(sessionId, id);
     }
}
