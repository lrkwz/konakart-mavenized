//
// (c) 2006 DS Data Systems UK Ltd, All rights reserved.
//
// DS Data Systems and KonaKart and their respective logos, are 
// trademarks of DS Data Systems UK Ltd. All rights reserved.
//
// The information in this document is free software; you can redistribute 
// it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This software is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
package com.konakart.server;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Contains helper methods for copying objects from server side to client side and vice versa
 */
public class KKBeanCopierBase
{

    /**
     * Convert a double to a big decimal
     * 
     * @return Returns a BigDecimal object
     */
    protected BigDecimal getBigDecimalFromDouble(Double doubleIn)
    {
        if (doubleIn == null)
        {
            return null;
        }

        BigDecimal bigD = new BigDecimal(doubleIn);
        return bigD.setScale(5, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Convert a big decimal to a double
     * 
     * @return Returns a Double object
     */
    protected Double getDoubleFromBigDecimal(BigDecimal bdIn)
    {
        if (bdIn == null)
        {
            return null;
        }

        return bdIn.doubleValue(); 
    }

    /**
     * Convert a date to a date to please GWT !
     * 
     * @return Returns a Date object
     */
    protected Date getDateFromDate(Date date)
    {
        if (date == null)
        {
            return null;
        }

        Date newDate = new Date(date.getTime());

        return newDate;

    }

    /**
     * Convert a double to a double but making a new Double as part of the conversion
     * 
     * @return Returns a double
     */
    protected double getdoubleFromdouble(double dble)
    {
        BigDecimal bigD = new BigDecimal(dble);

        return bigD.setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Convert a date to a calendar
     * 
     * @return Returns a Calendar object
     */
    protected Calendar getCalendarFromDate(Date date)
    {
        if (date == null)
        {
            return null;
        }

        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(date.getTime());

        return cal;

    }
    
    /**
     * Convert a calendar to a date
     * 
     * @return Returns a Date object
     */
    protected Date getDateFromCalendar(Calendar cal)
    {
        if (cal == null)
        {
            return null;
        }

        return cal.getTime();

    }

}
