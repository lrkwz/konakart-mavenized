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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.konakart.client.util.KKExceptionDialog;

/**
 * Contains common functionality for all windows
 */
public class KKBaseWin
{
    /* CDATA control characters */
    private static final String cDataStart = "<![CDATA[";

    private static final String cDataEnd = "]]>";

    /* Ids of html elements */
    protected static final String HEADER_ID = "kk-header";

    protected static final String BODY_ID = "kk-body";

    protected static final String BUTTON_ID = "kk-button";

    /* Ids of div where we add our GWT code to the jsp */
    protected static final String ONE_PAGE_CHECKOUT = "kk-OnePageCheckout";

    /* Debug attributes */
    protected boolean debug = false;

    private static int debugRow = 0;

    private static FlexTable debugFT;

    /* Pointer to Konakart.java */
    private Konakart kk;

    // Dialog to show exceptions
    private KKExceptionDialog exceptionDialog;

    // Images
    private Image errorImg, successImg;

    // CSS Buttons
    private HTML continueCssButton, backCssButton;

    protected HTML confirmOrderCssButton;

    // Table to show errors
    protected FlexTable errorFT;

    // Row for error messages
    protected int errorRow;

    // Table to show success
    protected FlexTable successFT;

    /*
     * Labels
     */
    private static String common_back = "common.back";

    private static String common_continue = "common.continue";

    protected static String common_confirmorder = "common.confirmorder";

    private static String images_folder = "";

    /**
     * Constructor
     * 
     */
    public KKBaseWin()
    {
        // If debug is set to true, we show debug info in a table
        if (debug)
        {
            if (debugFT == null)
            {
                debugFT = new FlexTable();
            }
        }
    }

    /**
     * Add the widget to the DOM structure
     * 
     * @param panel
     */
    protected void addToDom(HTMLPanel panel)
    {
        RootPanel.get(ONE_PAGE_CHECKOUT).add(panel);
    }

    /**
     * Remove the current panel from the DOM structure
     * 
     */
    protected void removeFromDom()
    {
        if (RootPanel.get(ONE_PAGE_CHECKOUT) != null)
        {
            RootPanel.get(ONE_PAGE_CHECKOUT).clear();
        }
    }

    /**
     * Creates a panel containing the framework html
     * 
     * @param mode
     *            Determines which framework to generate
     * 
     * @return Return the panel
     */
    protected HTMLPanel getContainerPanel(int mode)
    {
        String framework = "";
        switch (mode)
        {
        case 1:
            // Add a msg-box div inside the body-content div
            framework = "<div class=\"body\">" + "<div id=\"" + HEADER_ID
                    + "\" class=\"body-header\">" + "</div>" + "<div class=\"body-content-div\">"
                    + "<div id=\"" + BODY_ID + "\" class=\"msg-box\">" + "</div>" + "</div>"
                    + "</div>" + "<div id=\"" + BUTTON_ID + "\" class=\"tile\"></div>";
            break;
        case 2:
            // Don't add a msg-box div
            framework = "<div class=\"body\">" + "<div id=\"" + HEADER_ID
                    + "\" class=\"body-header\">" + "</div>" + "<div id=\"" + BODY_ID
                    + "\" class=\"body-content-div\">" + "</div>" + "</div>" + "<div id=\""
                    + BUTTON_ID + "\" class=\"tile\"></div>";
            break;

        default:
            break;
        }
        HTMLPanel containerPanel = new HTMLPanel(framework);
        return containerPanel;
    }

    /**
     * Utility method to format a cell
     * 
     * @param ft
     * @param r
     * @param c
     * @param style
     * @param hAlign
     * @param vAlign
     * @param width
     */
    protected void formatCell(FlexTable ft, int r, int c, String style, String hAlign,
            String vAlign, String width)
    {

        if (style != null)
        {
            ft.getFlexCellFormatter().setStyleName(r, c, style);
        }

        if (hAlign != null)
        {
            if (hAlign.equalsIgnoreCase("right"))
            {
                ft.getFlexCellFormatter().setHorizontalAlignment(r, c,
                        HasHorizontalAlignment.ALIGN_RIGHT);

            } else if (hAlign.equalsIgnoreCase("left"))
            {
                ft.getFlexCellFormatter().setHorizontalAlignment(r, c,
                        HasHorizontalAlignment.ALIGN_LEFT);

            } else if (hAlign.equalsIgnoreCase("center"))
            {
                ft.getFlexCellFormatter().setHorizontalAlignment(r, c,
                        HasHorizontalAlignment.ALIGN_CENTER);
            }
        }
        if (vAlign != null)
        {
            if (vAlign.equalsIgnoreCase("top"))
            {
                ft.getFlexCellFormatter()
                        .setVerticalAlignment(r, c, HasVerticalAlignment.ALIGN_TOP);

            } else if (vAlign.equalsIgnoreCase("bottom"))
            {
                ft.getFlexCellFormatter().setVerticalAlignment(r, c,
                        HasVerticalAlignment.ALIGN_BOTTOM);

            } else if (vAlign.equalsIgnoreCase("middle"))
            {
                ft.getFlexCellFormatter().setVerticalAlignment(r, c,
                        HasVerticalAlignment.ALIGN_MIDDLE);
            }
        }

        if (width != null)
        {
            ft.getFlexCellFormatter().setWidth(r, c, width);
        }
    }

    /**
     * Utility method to create a table.
     * 
     * @param border
     * @param width
     * @param cellSpacing
     * @param cellPadding
     * @param style
     * 
     * @return Returns a new table
     */
    protected FlexTable getTable(int border, String width, int cellSpacing, int cellPadding,
            String style)
    {

        FlexTable t = new FlexTable();
        t.setBorderWidth(border);
        t.setWidth(width);
        t.setCellSpacing(cellSpacing);
        t.setCellPadding(cellPadding);
        if (style != null)
        {
            t.setStyleName(style);
        }

        return t;
    }

    /**
     * Utility method to create a vertical spacer image
     * 
     * @return Returns the spacer image
     */
    protected Image getVSpacer()
    {
        Image spacer = new Image(images_folder + "pixel_trans.gif");
        spacer.setWidth("100%");
        spacer.setHeight("10px");
        return spacer;
    }

    /**
     * Utility method to create a horizontal spacer image
     * 
     * @return Returns the spacer image
     */
    protected Image getHSpacer()
    {
        Image spacer = new Image(images_folder + "pixel_trans.gif");
        spacer.setWidth("10");
        spacer.setHeight("1");
        return spacer;
    }

    /**
     * Utility method to clear a flex table
     * 
     * @param ft
     */
    protected void clearTable(FlexTable ft)
    {
        if (ft != null)
        {
            int numRows = ft.getRowCount();

            for (int i = numRows - 1; i > -1; i--)
            {
                ft.removeRow(i);
            }
        }
    }

    /**
     * Initialise widgets to ensure that they are there for when the data arrives
     */
    protected void initWidgets()
    {
        continueCssButton = new HTML("<a style=\"float:right\" class=\"button\"><span>"
                + common_continue + "</span></a>");
        initHTML(continueCssButton);

        backCssButton = new HTML("<a class=\"button\"><span>" + common_back + "</span></a>");
        initHTML(backCssButton);

        errorImg = new Image(images_folder + "icons/error.gif");
        successImg = new Image(images_folder + "icons/success.gif");

        errorFT = new FlexTable();
        errorRow = 0;
        successFT = new FlexTable();

    }

    /**
     * Initialises the HTML
     * 
     * @param html
     */
    private void initHTML(HTML html)
    {
        html.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                Widget sender = (Widget) event.getSource();

                if (sender == backCssButton)
                {
                    getKK().controller(Konakart.BACK);
                } else if (sender == continueCssButton)
                {
                    getKK().controller(Konakart.CONTINUE);
                }
            }
        });
    }

    /**
     * Returns a panel with the buttons.
     * 
     * @param mode
     *            If mode == 1 it returns a panel with a confirmation button. If mode == 2 it
     *            returns a panel with a back and continue button.
     * @return Returns the panel
     */
    protected Widget getButtons(int mode)
    {
        String divs = "<div class=\"button-left\"><div class=\"button-right\"><div class=\"button-bottom\"><div class=\"button-bottom-left\"><div class=\"button-bottom-right\"><div class=\"button-top\"><div class=\"button-top-left\"><div class=\"button-top-right\">"
                + "<div id=\"kk-buttons\" class=\"button-tile\">"
                + "</div>"
                + "</div></div></div></div></div></div></div>";

        HTMLPanel panel = new HTMLPanel(divs);

        FlexTable buttonFT = getTable(0, "97%", 0, 0, null);
        if (mode == 1)
        {
            formatCell(buttonFT, 0, 0, null, "right", null, null);
            buttonFT.setWidget(0, 0, confirmOrderCssButton);
        } else if (mode == 2)
        {
            formatCell(buttonFT, 0, 0, null, "left", null, null);
            formatCell(buttonFT, 0, 1, null, "right", null, null);
            buttonFT.setWidget(0, 0, backCssButton);
            buttonFT.setWidget(0, 1, continueCssButton);
        }
        if (debug)
        {
            buttonFT.setWidget(1, 0, debugFT);
        }
        panel.add(buttonFT, "kk-buttons");

        return panel;
    }

    /**
     * Returns the string passed in as stringIn without the CData information. i.e. It removes
     * '<![CDATA[' from the start of the string and ']]>' from the end of the string
     * 
     * @param stringIn
     * @return stringIn without the CDATA info
     */
    public String removeCData(String stringIn)
    {
        if (stringIn == null || stringIn.length() < cDataStart.length() + cDataEnd.length())
        {
            return stringIn;
        }

        if (stringIn.substring(0, cDataStart.length()).equals(cDataStart))
        {
            stringIn = stringIn.substring(cDataStart.length());
        }

        if (stringIn.substring(stringIn.length() - cDataEnd.length(), stringIn.length()).equals(
                cDataEnd))
        {
            stringIn = stringIn.substring(0, stringIn.length() - cDataEnd.length());
        }
        return stringIn;
    }

    /**
     * Redirect to the struts action
     * 
     * @param action
     */
    public void redirect(String action)
    {
        String fullActionPath = getKK().getRedirectUrl() + action;
        redirectPrivate(fullActionPath);
    }

    /**
     * Get all parameters passed in as hidden inputs of a form from the JSP. This is a common method
     * which calls a method to process the attributes that has to be overridden by the superclass
     * 
     * @param formId
     * @return Returns true if label section was found
     * 
     */
    protected boolean getParameters(String formId)
    {
        Element parmForm = DOM.getElementById(formId);
        if (parmForm != null)
        {
            String name, value;

            int attrCount = DOM.getChildCount(parmForm);

            for (int i = 0; i < attrCount; i++)
            {
                name = DOM.getElementProperty(DOM.getChild(parmForm, i), "name");
                value = DOM.getElementProperty(DOM.getChild(parmForm, i), "value");
                if (name != null)
                {
                    setAttr(name, value);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Must be overidden by the superclass
     * 
     * @param name
     * @param value
     */
    protected void setAttr(String name, String value)
    {
        debug("Should never get here");
    }

    /**
     * Used to send debug information out to the screen
     * 
     * @param str
     */
    protected void debug(String str)
    {
        if (debug)
        {
            debugFT.setHTML(debugRow++, 0, str);
        }
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

    /**
     * Sets the error msg
     * 
     * @param msg
     */
    protected void setErrorMsg(String msg)
    {
        if (errorFT == null)
        {
            errorFT = new FlexTable();
        }
        formatCell(errorFT, errorRow, 0, null, "right", null, "1%");
        formatCell(errorFT, errorRow, 1, "messageStackError", "left", null, "99%");
        errorFT.setWidget(errorRow, 0, errorImg);
        errorFT.setHTML(errorRow, 1, msg);
        errorRow++;
    }

    /**
     * Clears the error msg
     * 
     */
    protected void clearErrorMsg()
    {
        clearTable(errorFT);
        errorRow = 0;
    }

    /**
     * Sets the success msg
     * 
     * @param msg
     */
    protected void setSuccessMsg(String msg)
    {
        if (successFT == null)
        {
            successFT = new FlexTable();
        }
        formatCell(successFT, 0, 0, null, "right", null, "1%");
        formatCell(successFT, 0, 1, "messageStackSuccess", "left", null, "99%");
        successFT.setWidget(0, 0, successImg);
        successFT.setHTML(0, 1, msg);
    }

    /**
     * Render the header part of a page
     * 
     * @param title
     * @param imgName
     * @param imgTitle
     * @return Returns the widget containing the header
     */
    protected Widget renderHeader(String title, String imgName, String imgTitle)
    {
        HorizontalPanel hp = new HorizontalPanel();
        hp.addStyleName("body-header");
        hp.setWidth("100%");
        hp.add(new HTML(title));

        Image img1 = new Image(images_folder + imgName);
        img1.setTitle(imgTitle);
        img1.setPixelSize(getKK().getHeadingImageWidth(), getKK().getHeadingImageHeight());
        hp.add(img1);
        return hp;
    }

    /**
     * JSNI function to redirect the browser to the given url
     * 
     * @param url
     */
    private native void redirectPrivate(String url)/*-{ 
                                                                                                                         $wnd.location = url; 

                                                                                                                         }-*/;

    /**
     * @return Returns the kk.
     */
    public Konakart getKK()
    {
        return kk;
    }

    /**
     * @param kk
     *            The kk to set.
     */
    public void setKK(Konakart kk)
    {
        this.kk = kk;
    }

    /**
     * @param common_back
     *            The common_back to set.
     */
    public static void setCommon_back(String common_back)
    {
        KKBaseWin.common_back = common_back;
    }

    /**
     * @param common_continue
     *            The common_continue to set.
     */
    public static void setCommon_continue(String common_continue)
    {
        KKBaseWin.common_continue = common_continue;
    }

    /**
     * @param images_folder
     *            The images_folder to set.
     */
    public static void setImages_folder(String images_folder)
    {
        KKBaseWin.images_folder = images_folder;
    }

    /**
     * @return Returns the images_folder.
     */
    public static String getImages_folder()
    {
        return images_folder;
    }

    /**
     * @param common_confirmorder
     *            The common_confirmorder to set.
     */
    public static void setCommon_confirmorder(String common_confirmorder)
    {
        KKBaseWin.common_confirmorder = common_confirmorder;
    }

}
