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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Displays an exception in a dialog box
 */
public class KKExceptionDialog extends DialogBox implements ClickHandler
{
    /*
     * Labels
     */
    private static String exception_short_message = "exception.short.message";

    private static String exception_show_details = "exception.show.details";

    private static String exception_hide_details = "exception.hide.details";

    private static String common_close = "common.close";

    private Button closeButton;

    private Button detailButton;

    private HTML detail;

    /**
     * Construct an Exception dialogue
     * 
     * @param exception
     *            the exception to display
     * @param title
     *            the title for the dialogue box
     */
    public KKExceptionDialog(Throwable exception, String title)
    {
        show(exception, title);
    }

    /**
     * Constructor
     */
    public KKExceptionDialog()
    {

    }

    /**
     * Show the dialog
     * 
     * @param exception
     * @param title
     */
    public void show(Throwable exception, String title)
    {
        if (title != null && title.length() > 0)
        {
            this.setText(title);
        } else
        {
            this.setHTML(exception_short_message);
        }

        String msg = null, msgDetail = null;
        if (exception != null)
        {
            msg = getExceptionMessage(exception);
            msgDetail = getExceptionStackTrace(exception);
        }

        HorizontalPanel buttonPanel = new HorizontalPanel();
        closeButton = new Button(common_close, this);
        detailButton = new Button(exception_show_details, this);

        buttonPanel.setSpacing(4);
        buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        buttonPanel.setWidth("80%");

        buttonPanel.add(detailButton);
        buttonPanel.add(closeButton);

        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setSpacing(4);
        vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        vPanel.setWidth("100%");

        HTML msgHtml = new HTML(msg);
        msgHtml.addStyleName("infoBoxContents");
        vPanel.add(msgHtml);

        detail = new HTML(msgDetail);
        detail.addStyleName("konakart-smallFont");
        detail.setVisible(false);
        vPanel.add(detail);

        closeButton.setVisible(true);
        closeButton.setEnabled(true);

        detailButton.setVisible(true);
        detailButton.setEnabled(true);

        FlexTable ft = new FlexTable();
        ft.setWidget(0, 0, vPanel);
        ft.setWidget(1, 0, buttonPanel);
        ft.setWidth(Window.getClientWidth() * 3 / 4 - 20 + "px");

        setWidget(ft);

        // GWT.log("left = " + getLeft() + " top = " + getTop(), null);

        //this.setPopupPosition(getLeft(), getTop());
        this.center();
        show();
    }

    /**
     * Returns a string containing the message of the exception
     * 
     * @param e
     * @return Returns a string containing the stack trace
     */
    private String getExceptionMessage(Throwable e)
    {
        String msgPlusTrace = e.getMessage();

        if (msgPlusTrace == null)
        {
            return ("The cause of the exception is not known");
        }

        if (msgPlusTrace.indexOf("<br>") == -1)
        {
            return msgPlusTrace;
        }

        String msg = msgPlusTrace.substring(0, msgPlusTrace.indexOf("<br>"));
        if (msg == null || msg.trim().equalsIgnoreCase("null"))
        {
            return ("The cause of the problem is not clear. Look at the details.");
        }

        return msg;
    }

    /**
     * Returns a string containing the stack trace of the exception and its cause
     * 
     * @param e
     * @return Returns a string containing the stack trace
     */
    private String getExceptionStackTrace(Throwable e)
    {
        String msgPlusTrace = e.getMessage();

        if (msgPlusTrace == null)
        {
            return ("The cause of the exception is not known");
        }

        if (msgPlusTrace.indexOf("<br>") == -1)
        {
            return msgPlusTrace;
        }

        String trace = msgPlusTrace.substring(msgPlusTrace.indexOf("<br>") + "<br>".length());
        if (trace == null || trace.length() == 0)
        {
            return ("The details are not available");
        }

        return trace;
    }

    /**
     * @return the X coordinate
     */
    public int getLeft()
    {
        return (Window.getClientWidth() / 4);
    }

    /**
     * @return the Y coordinate
     */
    public int getTop()
    {
        return (Window.getClientHeight() / 4);
    }

    /**
     * @param common_close
     *            The common_close to set.
     */
    public static void setCommon_close(String common_close)
    {
        KKExceptionDialog.common_close = common_close;
    }

    /**
     * @param exception_hide_details
     *            The exception_hide_details to set.
     */
    public static void setException_hide_details(String exception_hide_details)
    {
        KKExceptionDialog.exception_hide_details = exception_hide_details;
    }

    /**
     * @param exception_short_message
     *            The exception_short_message to set.
     */
    public static void setException_short_message(String exception_short_message)
    {
        KKExceptionDialog.exception_short_message = exception_short_message;
    }

    /**
     * @param exception_show_details
     *            The exception_show_details to set.
     */
    public static void setException_show_details(String exception_show_details)
    {
        KKExceptionDialog.exception_show_details = exception_show_details;
    }

    public void onClick(ClickEvent event)
    {
        Widget sender = (Widget) event.getSource();

        if (sender == closeButton)
        {
            hide();
        } else if (sender == detailButton)
        {
            if (detail.isVisible())
            {
                detail.setVisible(false);
                detailButton.setText(exception_show_details);
            } else
            {
                detail.setVisible(true);
                detailButton.setText(exception_hide_details);
            }
        } else
        {
            // GWT.log("Unknown button pressed", null);
        }
    }
}
