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
 * A safe StringBuffer for GWT - appending nulls gave errors before this
 */
public class GWT_StringBuffer
{
    private StringBuffer sb;

    /**
     * constructor
     */
    public GWT_StringBuffer()
    {
        sb = new StringBuffer();
    }

    /**
     * constructor
     * 
     * @param initialSize
     *            the initial size for the StringBuffer
     */
    public GWT_StringBuffer(int initialSize)
    {
        sb = new StringBuffer(initialSize);
    }

    /**
     * Append the specified String to our StringBuffer
     * 
     * @param str
     *            the string to append
     * @return returns this GWT_StringBuffer
     */
    public GWT_StringBuffer append(String str)
    {
        if (str == null)
        {
            sb.append("null");
        } else
        {
            sb.append(str);
        }
        return this;
    }

    /**
     * Append the specified String to our StringBuffer
     * 
     * @param dble
     *            the Double to append
     * @return returns this GWT_StringBuffer
     */
    public GWT_StringBuffer append(Double dble)
    {
        if (dble == null)
        {
            sb.append("null");
        } else
        {
            sb.append(dble);
        }
        return this;
    }

    /**
     * Append the specified Boolean to our StringBuffer
     * 
     * @param bool
     *            the Boolean to append
     * @return returns this GWT_StringBuffer
     */
    public GWT_StringBuffer append(Boolean bool)
    {
        if (bool == null)
        {
            sb.append("null");
        } else
        {
            sb.append(bool);
        }
        return this;
    }

    /**
     * Append the specified String to our StringBuffer
     * 
     * @param dble
     *            the double to append
     * @return returns this GWT_StringBuffer
     */
    public GWT_StringBuffer append(double dble)
    {
        sb.append(dble);
        return this;
    }

    /**
     * Append the specified String to our StringBuffer
     * 
     * @param longInt
     *            the long Int to append
     * @return returns this GWT_StringBuffer
     */
    public GWT_StringBuffer append(long longInt)
    {
        sb.append(longInt);
        return this;
    }

    /**
     * Append the specified String to our StringBuffer
     * 
     * @param b
     *            the boolean to append
     * @return returns this GWT_StringBuffer
     */
    public GWT_StringBuffer append(boolean b)
    {
        sb.append(b);
        return this;
    }

    /**
     * Append the specified String to our StringBuffer
     * 
     * @param i
     *            the int to append
     * @return returns this GWT_StringBuffer
     */
    public GWT_StringBuffer append(int i)
    {
        sb.append(i);
        return this;
    }

    /**
     * Append the specified String to our StringBuffer
     * 
     * @param date
     *            the Double to append
     * @return returns this GWT_StringBuffer
     */
    public GWT_StringBuffer append(Date date)
    {
        if (date == null)
        {
            sb.append("null");
        } else
        {
            sb.append(date.toString());
        }
        return this;
    }

    /**
     * Returns the StringBuffer as a String
     * 
     * @return the StringBuffer as a String
     */
    public String toString()
    {
        return sb.toString();
    }
}