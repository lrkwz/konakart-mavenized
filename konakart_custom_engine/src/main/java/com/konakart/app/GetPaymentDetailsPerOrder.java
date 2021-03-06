package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - GetPaymentDetailsPerOrder - Generated by CreateKKCustomEng
 */
public class GetPaymentDetailsPerOrder
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public GetPaymentDetailsPerOrder(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public PaymentDetailsIf getPaymentDetailsPerOrder(String sessionId, String moduleCode, OrderIf order, String hostAndPort, int languageId) throws KKException
     {
         return kkEng.getPaymentDetailsPerOrder(sessionId, moduleCode, order, hostAndPort, languageId);
     }
}
