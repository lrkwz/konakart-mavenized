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

package com.konakart.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.konakart.client.util.KKExceptionDialog;
import com.konakart.client.util.KKGWTInvalidSessionException;

/**
 * KK Callback parent
 */
public class KKCallback implements AsyncCallback<Object>
{
    private static final long serialVersionUID = 1L;

    private KKExceptionDialog exceptionDialog;

    private KKBaseWin kkBase;

    /**
     * Constructor
     * 
     * @param kkBase
     * 
     */
    public KKCallback(KKBaseWin kkBase)
    {
        super(); // got to have this one for GWT
        this.kkBase = kkBase;
    }

    public void onFailure(Throwable caught)
    {
        if (caught instanceof KKGWTInvalidSessionException)
        {
            kkBase.redirect("Welcome.do");
        } else
        {
            showException(caught, null);
        }
    }

    public void onSuccess(Object result)
    {
        // User has to override this one
    }

    /**
     * Display the exception in a dialog box
     * 
     * @param title
     * @param caught
     */
    public void showException(Throwable caught, String title)
    {
        if (exceptionDialog == null)
        {
            exceptionDialog = new KKExceptionDialog();
        }
        exceptionDialog.show(caught, title);
    }
}