package com.konakart.app;

import com.konakart.appif.*;

/**
 *  The KonaKart Custom Engine - SendWelcomeEmail1 - Generated by CreateKKCustomEng
 */
public class SendWelcomeEmail1
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public SendWelcomeEmail1(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public EmailIf sendWelcomeEmail1(int customerId, EmailOptionsIf options) throws KKException
     {
         return kkEng.sendWelcomeEmail1(customerId, options);
     }
}
