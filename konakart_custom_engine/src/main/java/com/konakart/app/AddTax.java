package com.konakart.app;

import java.math.BigDecimal;

/**
 *  The KonaKart Custom Engine - AddTax - Generated by CreateKKCustomEng
 */
public class AddTax
{
    KKEng kkEng = null;

    /**
     * Constructor
     */
     public AddTax(KKEng _kkEng)
     {
         kkEng = _kkEng;
     }

     public BigDecimal addTax(BigDecimal cost, int countryId, int zoneId, int taxClassId) throws KKException
     {
         return kkEng.addTax(cost, countryId, zoneId, taxClassId);
     }
}
