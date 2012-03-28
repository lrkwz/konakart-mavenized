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

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A serializable exception for GWT
 */
public class KKGWTException extends Exception implements IsSerializable
//public class KKGWTException extends SerializableException implements IsSerializable
{
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public KKGWTException()
    {
        super(); // got to have this one for GWT
    }

    /**
     * @param msg
     */
    public KKGWTException(String msg)
    {
        super(msg);
    }

    /**
     * Constructs a new <code>KKException</code> with specified nested <code>Throwable</code>.
     * 
     * @param nested
     *            the exception or error that caused this exception to be thrown.
     */
    public KKGWTException(Throwable nested)
    {
        // super(nested); - chains of exceptions not currently supported by GWT

        super(nested.getMessage());
    }

    /**
     * Constructs a new <code>KKAdminException</code> with specified detail message and nested
     * <code>Throwable</code>.
     * 
     * @param msg
     *            the error message.
     * @param nested
     *            the exception or error that caused this exception to be thrown.
     */
    public KKGWTException(String msg, Throwable nested)
    {
        super(msg + "\n" + nested.getMessage());
    }
}
