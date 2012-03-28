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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.konakart.client.app.GWT_Address;

/**
 * Window to choose an address from a list
 */
public class ChooseAddrBody extends KKBaseWin
{
    private List<RadioButton> radioList;

    private GWT_Address[] addrArray;

    private HTML newAddrLink;

    /*
     * Labels
     */
    private String one_page_checkout_choose_shipping_address = "one.page.checkout.choose.shipping.address";

    private String one_page_checkout_choose_billing_address = "one.page.checkout.choose.billing.address";

    private String change_delivery_address_body_selectaddr = "change.delivery.address.body.selectaddr";

    private String change_payment_address_body_selectaddr = "change.payment.address.body.selectaddr";

    private String change_payment_address_body_pleaseselect = "change.payment.address.body.pleaseselect";

    private String one_page_checkout_insert_address = "one.page.checkout.insert.address";

    /**
     * Constructor
     * 
     * @param kk
     */
    public ChooseAddrBody(Konakart kk)
    {
        setKK(kk);

        // Get the parameters from the JSP
        getParameters("kkLabelForm4");

        initWidgets();
    }

    /**
     * Initialise widgets to ensure that they are there for when the data arrives
     */
    protected void initWidgets()
    {
        super.initWidgets();
        newAddrLink = new HTML(one_page_checkout_insert_address);
        initLink(newAddrLink);
    }

    /**
     * Initialises the link
     * 
     * @param link
     */
    private void initLink(HTML link)
    {
        link.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                Widget sender = (Widget) event.getSource();

                if (sender == newAddrLink)
                {
                    getKK().controller(Konakart.NEW_ADDR);
                }
            }
        });
    }

    /**
     * Creates the table to choose an addr. It is populated with the addresses passed in, and the
     * title is changed depending on whether we are choosing the shipping or billing addresses.
     * 
     * @param addrArray
     * @param shipping
     */
    protected void render(GWT_Address[] addrArray, boolean shipping)
    {
        // Remove the current panel
        removeFromDom();

        radioList = new ArrayList<RadioButton>();

        this.addrArray = addrArray;

        // Get the container panel
        HTMLPanel containerPanel = getContainerPanel(1);

        // Get the header
        Widget header;
        if (shipping)
        {
            header = renderHeader(one_page_checkout_choose_shipping_address,
                    "table_background_delivery.gif", one_page_checkout_choose_shipping_address);

        } else
        {
            header = renderHeader(one_page_checkout_choose_billing_address,
                    "table_background_delivery.gif", one_page_checkout_choose_billing_address);
        }

        // Add the header to the container panel
        containerPanel.add(header, HEADER_ID);

        int row = 0;
        int colspan = 4;
        FlexTable ft111 = getTable(0, "100%", 0, 2, "body-content-tab");

        ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
        ft111.setWidget(row++, 0, getVSpacer());

        ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
        formatCell(ft111, row, 0, null, "left", null, null);
        ft111.setWidget(row++, 0, newAddrLink);

        ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
        ft111.setWidget(row++, 0, getVSpacer());

        formatCell(ft111, row, 0, null, null, "top", null);
        formatCell(ft111, row, 1, null, null, "top", "50%");
        formatCell(ft111, row, 2, null, "right", "top", "50%");
        formatCell(ft111, row, 3, null, null, "top", null);

        // Col 0
        ft111.setWidget(row, 0, getHSpacer());

        // Col 1
        if (shipping)
        {
            ft111.setHTML(row, 1, change_delivery_address_body_selectaddr);
        } else
        {
            ft111.setHTML(row, 1, change_payment_address_body_selectaddr);
        }

        // Col2
        FlexTable t = getTable(0, "100%", 0, 0, "body-content-tab");
        formatCell(t, 0, 0, null, "right", "top", "50%");
        formatCell(t, 1, 0, null, "right", "top", "50%");
        t.setHTML(0, 0, change_payment_address_body_pleaseselect);
        t.setWidget(1, 0, new Image(getImages_folder() + "arrow_east_south.gif"));
        ft111.setWidget(row, 2, t);

        // Col 3
        ft111.setWidget(row++, 3, getHSpacer());

        // Loop through the addresses
        for (int i = 0; i < addrArray.length; i++)
        {
            GWT_Address addr = addrArray[i];

            // col 0 of ft111
            ft111.setWidget(row, 0, getHSpacer());

            // col 1 - 2 of ft111
            ft111.getFlexCellFormatter().setColSpan(row, 1, 2);
            FlexTable ft1111 = getTable(0, "100%", 0, 2, "body-content-tab");
            ft111.setWidget(row, 1, ft1111);
            /*
             * Row 0 of ft1111
             */
            ft1111.getFlexCellFormatter().setColSpan(0, 1, 2);
            formatCell(ft1111, 0, 0, null, null, "top", "10");
            formatCell(ft1111, 0, 2, null, "right", null, null);
            formatCell(ft1111, 0, 3, null, null, "top", "10");
            // Col 0
            ft1111.setWidget(0, 0, getHSpacer());
            // Col 1-2
            ft1111.setHTML(0, 1, "<b>" + addr.getFirstName() + "&nbsp;" + addr.getLastName()
                    + "</b>");
            RadioButton b = new RadioButton("selAddrGroup");
            if (i == 0)
            {
                b.setValue(true);
            }
            radioList.add(i, b); // Save the radio button in a list
            // Col 3
            ft1111.setWidget(0, 2, b);
            // Col 4
            ft1111.setWidget(0, 3, getHSpacer());
            /*
             * Row 1 of ft1111
             */
            ft1111.getFlexCellFormatter().setColSpan(0, 1, 3);
            formatCell(ft1111, 0, 0, null, null, "top", "10");
            formatCell(ft1111, 0, 2, null, null, "top", "10");

            // Col 0
            ft1111.setWidget(1, 0, getHSpacer());
            // Col 1-3
            FlexTable t1 = getTable(0, "100%", 0, 2, "body-content-tab");
            formatCell(t1, 0, 0, null, null, "top", "10");
            formatCell(t1, 0, 2, null, null, "top", "10");

            t1.setWidget(0, 0, getHSpacer());
            t1.setHTML(0, 1, removeCData(addr.getFormattedAddress()).replaceAll("<br>", ", "));
            t1.setWidget(0, 2, getHSpacer());

            ft1111.setWidget(1, 1, t1);
            // Col 4
            ft1111.setWidget(1, 2, getHSpacer());

            // Col 3 of ft111
            ft111.setWidget(row++, 2, getHSpacer());
        }

        ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
        ft111.setWidget(row++, 0, getVSpacer());

        // Add error table
        ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
        ft111.setWidget(row++, 0, errorFT);

        containerPanel.add(ft111, BODY_ID);
        containerPanel.add(getButtons(2), BUTTON_ID);

        // Finally, add the outer panel to the RootPanel, so that it will be
        // displayed.
        addToDom(containerPanel);

    }

    /**
     * Returns the address selected
     * 
     * @return Returns an address
     */
    protected GWT_Address getSelectedAddress()
    {
        if (addrArray != null && radioList != null)
        {
            for (int i = 0; i < radioList.size(); i++)
            {
                RadioButton rb = radioList.get(i);
                if (rb.getValue())
                {
                    if (addrArray.length >= i + 1)
                    {
                        return addrArray[i];
                    }
                }
            }
        }

        return null;
    }

    /**
     * Set attributes from hidden parameters in JSP
     */
    protected void setAttr(String name, String value)
    {
        if (name.equals("one.page.checkout.choose.shipping.address"))
        {
            one_page_checkout_choose_shipping_address = value;
        } else if (name.equals("one.page.checkout.choose.billing.address"))
        {
            one_page_checkout_choose_billing_address = value;
        } else if (name.equals("change.payment.address.body.selectaddr"))
        {
            change_payment_address_body_selectaddr = value;
        } else if (name.equals("change.payment.address.body.pleaseselect"))
        {
            change_payment_address_body_pleaseselect = value;
        } else if (name.equals("change.delivery.address.body.selectaddr"))
        {
            change_delivery_address_body_selectaddr = value;
        } else if (name.equals("one.page.checkout.insert.address"))
        {
            one_page_checkout_insert_address = value;
        }
    }

}
