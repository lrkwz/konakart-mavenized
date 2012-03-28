//
// (c) 2006 DS Data Systems UK Ltd, All rights reserved.
//
// DS Data Systems and KonaKart and their respective logos, are 
// trademarks of DS Data Systems UK Ltd. All rights reserved.
//
// The information in this document is the proprietary property of
// DS Data Systems UK Ltd. and is protected by English copyright law,
// the laws of foreign jurisdictions, and international treaties,
// as applicable. No part of this document may be reproduced,
// transmitted, transcribed, transferred, modified, published, or
// translated into any language, in any form or by any means, for
// any purpose other than expressly permitted by DS Data Systems UK Ltd.
// in writing.
//
package com.konakart.client.util;

import java.util.Date;

/**
 * A miscellaneous collection of static utilities for Dates
 */
public class GWT_Date
{
    /**
     * Private constructor - all static methods here
     */
    private GWT_Date()
    {
    }

    /**
     * Return a String showing the date for the locale
     * 
     * @param date
     *            the date to represent as a String
     * @return the date as a String for the locale or empty String if the date is null
     */
    public static String toStringForLocale(Date date)
    {
        // null or empty will be false
        if (date == null)
        {
            return "";
        }

        GWT_SimpleDateFormat dFormat = new GWT_SimpleDateFormat(null);
        
        return dFormat.format(date);
    }
    
    /**
     * Returns a date that is 30 years ago from now
     * @return a date 30 years ago
     */
    @SuppressWarnings("deprecation")
    public static Date getDate30YearsAgo()
    {
        Date now = new Date();
        Date date = new Date();
        
        // This might look weird but it's to work around a javascript Date problem

        date.setDate(1);
        date.setYear(now.getYear() - 30);
        date.setMonth(now.getMonth());
        date.setDate(now.getDate());
        
        return date;
    }
    
    
    /**
     * @param day day of month
     * @param month month number
     * @param year year number
     * @return a date defined by the day, month, year specified
     */
    @SuppressWarnings("deprecation")
    public static Date setDate(int day, int month, int year)
    {
        // This might look weird but it's to work around a javascript Date problem
        
        Date date = new Date();
        date.setDate(1);
        date.setYear(year);
        date.setMonth(month);
        date.setDate(day);
        
        return date;
    }
    
    /**
     * Return the Day of the Month
     * 
     * @param date
     *            the date 
     * @return the day of the month or 1 if the date is null
     */
    @SuppressWarnings("deprecation")
    public static int getDayOfMonth(Date date)
    {
        // null or empty will be false
        if (date == null)
        {
            return 1;
        }

        return date.getDate();
    }
 
    /**
     * Return the Day of the Week
     * 
     * @param date
     *            the date 
     * @return the day of the month or 1 if the date is null
     */
    @SuppressWarnings("deprecation")
    public static int getDayOfWeek(Date date)
    {
        // null or empty will be false
        if (date == null)
        {
            return 1;
        }

        return date.getDay();
    }
 
    /**
     * Return the Month from the specified date
     * 
     * @param date
     *            the date 
     * @return the month or 1 if the date is null
     */
    @SuppressWarnings("deprecation")
    public static int getMonth(Date date)
    {
        // null or empty will be false
        if (date == null)
        {
            return 1;
        }

        return date.getMonth();
    }
    
    /**
     * Return the Year from the specified date
     * 
     * @param date
     *            the date 
     * @return the year from the date or 1 if the date is null
     */
    @SuppressWarnings("deprecation")
    public static int getYear(Date date)
    {
        // null or empty will be false
        if (date == null)
        {
            return 1;
        }

        return date.getYear();
    }    
    
    /**
     * Return the Hour from the specified date
     * 
     * @param date
     *            the date 
     * @return the hour from the date or 1 if the date is null
     */
    @SuppressWarnings("deprecation")
    public static int getHours(Date date)
    {
        // null or empty will be false
        if (date == null)
        {
            return 1;
        }

        return date.getHours();
    }
    
    /**
     * Return the Minutes from the specified date
     * 
     * @param date
     *            the date 
     * @return the minutes from the date or 1 if the date is null
     */
    @SuppressWarnings("deprecation")
    public static int getMinutes(Date date)
    {
        // null or empty will be false
        if (date == null)
        {
            return 1;
        }

        return date.getMinutes();
    }
    
    /**
     * Return the Seconds from the specified date
     * 
     * @param date
     *            the date 
     * @return the seconds from the date or 1 if the date is null
     */
    @SuppressWarnings("deprecation")
    public static int getSeconds(Date date)
    {
        // null or empty will be false
        if (date == null)
        {
            return 1;
        }

        return date.getSeconds();
    }
}