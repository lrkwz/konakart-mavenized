package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - RemoveProdAttrDescsFromTemplate - Generated by CreateKKAdminCustomEng
 */
public class RemoveProdAttrDescsFromTemplate
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public RemoveProdAttrDescsFromTemplate(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public void removeProdAttrDescsFromTemplate(String sessionId, AdminProdAttrDesc[] attrDescs, int templateId) throws KKAdminException
     {
         kkAdminEng.removeProdAttrDescsFromTemplate(sessionId, attrDescs, templateId);
     }
}
