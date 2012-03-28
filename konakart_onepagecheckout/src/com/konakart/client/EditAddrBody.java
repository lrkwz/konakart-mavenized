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

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.konakart.client.app.GWT_Address;

/**
 * Window to edit a billing or shipping address
 */
public class EditAddrBody extends RegisterAndAddrBase
{

    /*
     * Labels
     */
    private String one_page_checkout_enter_your_address_details = "one.page.checkout.enter.your.address.details";

    /**
     * Constructor
     * 
     * @param kk
     */
    public EditAddrBody(Konakart kk)
    {
        setKK(kk);

        // Get the parameters from the JSP
        getParameters("kkLabelForm5");

        init();
    }

    /**
     * Initialisation
     */
    protected void init()
    {
        super.init();
    }

    /**
     * Creates the table to edit an addr. It is populated with the address passed in, and the title
     * is changed depending on whether we are editing the shipping or billing address
     * 
     * @param shipping
     */
    protected void renderAddr(boolean shipping)
    {
        // Remove the current panel
        removeFromDom();

        clearWidgets();

        // Get the container panel
        HTMLPanel containerPanel = getContainerPanel(1);

        // Get the header
        Widget header;
        if (shipping)
        {
            header = renderHeader(one_page_checkout_shipping_address,
                    "table_background_delivery.gif", one_page_checkout_shipping_address);

        } else
        {
            header = renderHeader(one_page_checkout_billing_address,
                    "table_background_delivery.gif", one_page_checkout_billing_address);
        }

        // Add the header to the container panel
        containerPanel.add(header, HEADER_ID);

        ft111 = getTable(0, "100%", 0, 2, "body-content-tab");

        int row = 0;
        int colspan = 3;

        ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
        ft111.setWidget(row++, 0, getVSpacer());

        ft111.getFlexCellFormatter().setColSpan(row, 0, 2);
        formatCell(ft111, row, 0, "main", null, "top", null);
        ft111.setHTML(row, 0, one_page_checkout_enter_your_address_details);
        formatCell(ft111, row, 1, "inputRequirement", null, "top", null);
        ft111.setHTML(row++, 1, " * " + register_customer_body_required_info);

        ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
        ft111.setWidget(row++, 0, getVSpacer());

        row = getAddrTable(ft111, row, colspan, /* register */false, /* Show eMail */false);

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
     * Clears the widgets
     * 
     */
    private void clearWidgets()
    {

        cityTB.setText("");
        compNameTB.setText("");
        firstNameTB.setText("");
        lastNameTB.setText("");
        postCodeTB.setText("");
        streetAddrTB.setText("");
        streetAddr1TB.setText("");
        suburbTB.setText("");
        stateTB.setText("");
        telTB.setText("");
        tel1TB.setText("");
        emailTB.setText("");
    }

    /**
     * @return Returns an address object
     */
    public GWT_Address getAddr()
    {

        GWT_Address addr = new GWT_Address();

        addr.setCity(cityTB.getText());
        addr.setCompany(compNameTB.getText());
        addr.setCountryId(new Integer(countryLB.getValue(countryLB.getSelectedIndex())).intValue());
        addr.setFirstName(firstNameTB.getText());
        addr.setLastName(lastNameTB.getText());
        addr.setPostcode(postCodeTB.getText());
        addr.setStreetAddress(streetAddrTB.getText());
        addr.setStreetAddress1(streetAddr1TB.getText());
        addr.setSuburb(suburbTB.getText());
        addr.setTelephoneNumber(telTB.getText());
        addr.setTelephoneNumber1(tel1TB.getText());
        addr.setEmailAddr(emailTB.getText());

        if (maleRB.getValue())
        {
            addr.setGender("m");
        } else
        {
            addr.setGender("f");
        }

        if (stateListDisplayed)
        {
            if (zoneListLB != null && zoneListLB.getItemCount() > 0)
            {
                String state = zoneListLB.getItemText(zoneListLB.getSelectedIndex());
                addr.setState(state);
            }
        } else
        {
            addr.setState(stateTB.getText());
        }

        addr.setIsPrimary(false);

        return addr;
    }

    /**
     * Set attributes from hidden parameters in JSP
     */
    protected void setAttr(String name, String value)
    {
        super.setAttr(name, value);

        if (name.equals("one.page.checkout.enter.your.address.details"))
        {
            one_page_checkout_enter_your_address_details = value;
        }
    }
}
