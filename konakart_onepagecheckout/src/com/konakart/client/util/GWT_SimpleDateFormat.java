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

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 
 */
/**
 * <dl>
 * <dt><b>Title: </b>
 * <dd>SimpleDateFormat</dd>
 * <p>
 * <dt><b>Description: </b>
 * <dd>GWT does not implement any of the java.text package, so this class tries to fill the void of
 * the missing java.text.SimpleDateFormat class. This version however only supports a subset of the
 * date and time patterns supported by its java.text counterpart. The pattern symbols supported by
 * this class are:
 * <dl>
 * <dt><b>E</b></dt>
 * <dd>Day in a week</dd>
 * <dt><b>d</b></dt>
 * <dd>Day of the month</dd>
 * <dt><b>y</b></dt>
 * <dd>Year</dd>
 * <dt><b>M</b></dt>
 * <dd>Month January, Jan, 01, 1</dd>
 * <dt><b>H</b></dt>
 * <dd>Hour in 24 hour format (0-23)</dd>
 * <dt><b>h</b></dt>
 * <dd>Hour in 12 hour format (1-12)</dd>
 * <dt><b>m</b></dt>
 * <dd>Minute of the hour</dd>
 * <dt><b>s</b></dt>
 * <dd>Seconds of the minute</dd>
 * <dt><b>a</b></dt>
 * <dd>am/pm</dd>
 * </dl>
 * All characters that are not recognised as a date format character are translated literally into
 * the output string. <br/>
 * </dd>
 * <p>
 * </dl>
 * 
 * @author <a href="mailto:jas...@greenrivercomputing.com">Jason Essington</a>
 * @version $Revision: 0.0 $
 */

public class GWT_SimpleDateFormat
{
    // private static final String DEFAULT_DATE_TEMPLATE = "dd/MM/yyyy";

    private static final String TOKEN_DAY_OF_WEEK = "E";

    private static final String TOKEN_DAY_OF_MONTH = "d";

    private static final String TOKEN_MONTH = "M";

    private static final String TOKEN_YEAR = "y";

    private static final String TOKEN_HOUR_12 = "h";

    private static final String TOKEN_HOUR_24 = "H";

    private static final String TOKEN_MINUTE = "m";

    private static final String TOKEN_SECOND = "s";

    private static final String TOKEN_AM_PM = "a";

    private static final String AM = "AM";

    private static final String PM = "PM";

    private static final List<String> SUPPORTED_DF_TOKENS = Arrays.asList(new String[]
    { TOKEN_DAY_OF_WEEK, TOKEN_DAY_OF_MONTH, TOKEN_MONTH, TOKEN_YEAR, TOKEN_HOUR_12, TOKEN_HOUR_24,
            TOKEN_MINUTE, TOKEN_SECOND, TOKEN_AM_PM });

    private static final String[] MONTH_LONG =
    { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };

    private static final String[] MONTH_SHORT =
    { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec" };

    private static final String[] WEEKDAY_LONG =
    { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

    private static final String[] WEEKDAY_SHORT =
    { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

    private String format;

    /**
     * @param pattern
     */
    public GWT_SimpleDateFormat(String pattern)
    {
        format = pattern;
    }

    /**
     * @param date
     * @return a formatted date
     */
    public String format(Date date)
    {
        if (date == null)
        {
            return "";
        }

        String f = "";
        if (format != null && format.length() > 0)
        {
            String lastTokenType = null;
            String currentToken = "";
            for (int i = 0; i < format.length(); i++)
            {
                String thisChar = format.substring(i, i + 1);
                String currentTokenType = SUPPORTED_DF_TOKENS.contains(thisChar) ? thisChar : "";

                if (currentTokenType.equals(lastTokenType) || i == 0)
                {
                    currentToken += thisChar;
                    lastTokenType = currentTokenType;
                } else
                {
                    if ("".equals(lastTokenType))
                        f += currentToken;
                    else
                        f += handleToken(currentToken, date);

                    currentToken = thisChar;
                    lastTokenType = currentTokenType;
                }
            }
            if ("".equals(lastTokenType))
                f += currentToken;
            else
                f += handleToken(currentToken, date);
        }

        return f;
    }

    /**
     * takes a date format string and returns the formatted portion of the date. For instance if the
     * token is MMMM then the full month name is returned.
     * 
     * @param token
     *            date format token
     * @param date
     *            date to format
     * @return formatted portion of the date
     */
    private String handleToken(String token, Date date)
    {
        String response = token;
        String tc = token.substring(0, 1);
        if (TOKEN_DAY_OF_WEEK.equals(tc))
        {
            if (token.length() > 3)
            {
                response = WEEKDAY_LONG[GWT_Date.getDayOfWeek(date)];
            }
            else
            {
                response = WEEKDAY_SHORT[GWT_Date.getDayOfWeek(date)];
            }
        } else if (TOKEN_DAY_OF_MONTH.equals(tc))
        {
            if (token.length() == 1)
                response = Integer.toString(GWT_Date.getDayOfMonth(date));
            else
                response = twoCharDateField(GWT_Date.getDayOfMonth(date));
        } else if (TOKEN_MONTH.equals(tc))
        {
            switch (token.length())
            {
            case 1:
                response = Integer.toString(GWT_Date.getMonth(date) + 1);
                break;
            case 2:
                response = twoCharDateField(GWT_Date.getMonth(date) + 1);
                break;
            case 3:
                response = MONTH_SHORT[GWT_Date.getMonth(date)];
                break;
            default:
                response = MONTH_LONG[GWT_Date.getMonth(date)];
                break;
            }
        } else if (TOKEN_YEAR.equals(tc))
        {
            if (token.length() > 2)
                response = Integer.toString(GWT_Date.getYear(date) + 1900);
            else
                response = twoCharDateField(GWT_Date.getYear(date));
        } else if (TOKEN_HOUR_12.equals(tc))
        {
            int h = GWT_Date.getHours(date);
            if (h == 0)
                h = 12;
            else if (h > 12)
                h -= 12;

            if (token.length() > 1)
                response = twoCharDateField(h);
            else
                response = Integer.toString(h);
        } else if (TOKEN_HOUR_24.equals(tc))
        {
            if (token.length() > 1)
                response = twoCharDateField(GWT_Date.getHours(date));
            else
                response = Integer.toString(GWT_Date.getHours(date));
        } else if (TOKEN_MINUTE.equals(tc))
        {
            if (token.length() > 1)
                response = twoCharDateField(GWT_Date.getMinutes(date));
            else
                response = Integer.toString(GWT_Date.getMinutes(date));
        } else if (TOKEN_SECOND.equals(tc))
        {
            if (token.length() > 1)
                response = twoCharDateField(GWT_Date.getSeconds(date));
            else
                response = Integer.toString(GWT_Date.getSeconds(date));
        } else if (TOKEN_AM_PM.equals(tc))
        {
            int hour = GWT_Date.getHours(date);
            if (hour > 11)
                response = PM;
            else
                response = AM;
        }

        return response;
    }

    /**
     * This is basically just a sneaky way to guarantee that our 1 or 2 digit numbers come out as a
     * 2 character string. we add an arbitrary number larger than 100, convert this new number to a
     * string, then take the right most 2 characters.
     * 
     * @param num
     * @return
     */
    private String twoCharDateField(int num)
    {
        String res = Integer.toString(num + 1900);
        res = res.substring(res.length() - 2);
        return res;
    }
}