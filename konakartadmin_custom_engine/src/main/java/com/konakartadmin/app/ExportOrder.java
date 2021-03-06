package com.konakartadmin.app;

import com.konakartadmin.appif.*;
import com.konakart.app.*;
import com.konakartadmin.bl.KKAdmin;

/**
 *  The KonaKart Custom Engine - ExportOrder - Generated by CreateKKAdminCustomEng
 */
public class ExportOrder
{
    KKAdmin kkAdminEng = null;

    /**
     * Constructor
     */
     public ExportOrder(KKAdmin _kkAdminEng)
     {
         kkAdminEng = _kkAdminEng;
     }

     public ExportOrderResponse exportOrder(String sessionId, ExportOrderOptions options) throws KKAdminException
     {
         return kkAdminEng.exportOrder(sessionId, options);
     }
}
