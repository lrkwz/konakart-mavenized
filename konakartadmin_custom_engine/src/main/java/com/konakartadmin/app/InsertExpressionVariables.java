package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - InsertExpressionVariables - Generated by CreateKKAdminCustomEng
 */
public class InsertExpressionVariables
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public InsertExpressionVariables(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public int insertExpressionVariables(String sessionId, AdminExpressionVariable[] expVarArray) throws KKAdminException
     {
         return kkAdminEng.insertExpressionVariables(sessionId, expVarArray);
     }
}
