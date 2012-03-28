package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - GetMsgs - Generated by CreateKKAdminCustomEng
 */
public class GetMsgs
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public GetMsgs(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public AdminMessageSet getMsgs(String languageCode) throws KKAdminException
     {
         return kkAdminEng.getMsgs(languageCode);
     }
}
