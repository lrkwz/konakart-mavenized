package com.konakart.app;

/**
 *  The KonaKart Custom Engine - SendTemplateEmailToCustomer - Generated by CreateKKCustomEng
 */
public class SendTemplateEmailToCustomer
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public SendTemplateEmailToCustomer(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public void sendTemplateEmailToCustomer(int customerId, String templateName, String message, String countryCode) throws KKException
     {
         kkEng.sendTemplateEmailToCustomer(customerId, templateName, message, countryCode);
     }
}
