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
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.konakart.client.app.GWT_CustomerRegistration;
import com.konakart.client.util.GWT_Validation;

/**
 * Customer registration window
 */
public class RegisterBody extends RegisterAndAddrBase
{
    /*
     * Labels
     */
    private String one_page_checkout_enter_shipping_address = "one.page.checkout.enter.shipping.address";

    private String one_page_checkout_enter_password = "one.page.checkout.enter.password";

    private String register_customer_body_passwords_no_match = "register.customer.body.passwords.no.match";

    /**
     * Constructor
     * 
     * @param kk
     */
    public RegisterBody(Konakart kk)
    {
        setKK(kk);

        // Get the parameters from the JSP
        getParameters("kkLabelForm6");

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
     * Creates the panel to register
     */
    protected void renderRegister(boolean allowNoRegister)
    {
        // Remove the current panel
        removeFromDom();

        // Clear the password fields
        passwordTB.setText("");
        confirmPasswordTB.setText("");

        // Get the container panel
        HTMLPanel containerPanel = getContainerPanel(1);

        // Get the header
        Widget header = renderHeader(register_customer_body_delivery_details,
                "table_background_account.gif", register_customer_body_delivery_details);

        // Add the header to the container panel
        containerPanel.add(header, HEADER_ID);

        ft111 = getTable(0, "100%", 0, 2, "body-content-tab");

        int row = 0;
        int colspan = 3;

        ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
        ft111.setWidget(row++, 0, getVSpacer());

        ft111.getFlexCellFormatter().setColSpan(row, 0, 2);
        formatCell(ft111, row, 0, null, null, "top", null);
        ft111.setHTML(row, 0, "<b>" + one_page_checkout_enter_shipping_address + ":</b>");
        formatCell(ft111, row, 1, "inputRequirement", null, "top", null);
        ft111.setHTML(row++, 1, " * " + register_customer_body_required_info);

        ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
        ft111.setWidget(row++, 0, getVSpacer());

        if (!allowNoRegister)
        {
            /*
             * If we need to register then we don't show the email entry field but we do show the
             * password fields
             */
            row = getAddrTable(ft111, row, colspan, /* register */true, /* Show eMail */false);

            ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
            ft111.setWidget(row++, 0, getVSpacer());

            ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
            formatCell(ft111, row, 0, null, null, "top", null);
            ft111.setHTML(row++, 0, "<b>" + one_page_checkout_enter_password + ":</b>");

            ft111.getFlexCellFormatter().setColSpan(row, 0, colspan);
            ft111.setWidget(row++, 0, getVSpacer());

            formatCell(ft111, row, 0, null, "left", null, WIDTH1);
            formatCell(ft111, row, 1, null, "left", null, WIDTH2);
            formatCell(ft111, row, 2, "inputRequirement", "left", null, WIDTH3);
            ft111.setHTML(row, 0, register_customer_body_password + ":");
            ft111.setWidget(row, 1, passwordTB);
            ft111.setHTML(row++, 2, " *");

            formatCell(ft111, row, 0, null, "left", null, WIDTH1);
            formatCell(ft111, row, 1, null, "left", null, WIDTH2);
            formatCell(ft111, row, 2, "inputRequirement", "left", null, WIDTH3);
            ft111.setHTML(row, 0, register_customer_body_confirm_password + ":");
            ft111.setWidget(row, 1, confirmPasswordTB);
            ft111.setHTML(row++, 2, " *");
        } else
        {
            /*
             * If we don't need to register we don't show the password fields but we do show the
             * eMail field
             */
            row = getAddrTable(ft111, row, colspan, /* register */true, /* Show eMail */true);
        }

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
     * Validation logic
     * 
     * @param sender
     * @param allowNoRegister 
     * 
     * @return true if it all validates
     */
    public boolean validate(Widget sender, boolean allowNoRegister)
    {
        boolean ret = super.validate(sender);

        if (sender == null || sender == telTB)
        {
            ret = ret
                    & GWT_Validation.validateText(telTB, new Integer(ENTRY_TELEPHONE_MIN_LENGTH),
                            new Integer(ENTRY_TELEPHONE_MAX_LENGTH),
                            register_customer_body_tel_number);
        }
        
        if (!allowNoRegister)
        {
            if (sender == null || sender == passwordTB)
            {
                ret = ret
                        & GWT_Validation.validatePasswordText(passwordTB, new Integer(
                                ENTRY_PASSWORD_MIN_LENGTH), new Integer(ENTRY_PASSWORD_MAX_LENGTH),
                                register_customer_body_password);
            }

            if (sender == null || sender == confirmPasswordTB)
            {
                ret = ret
                        & GWT_Validation.validatePasswordText(confirmPasswordTB, new Integer(
                                ENTRY_PASSWORD_MIN_LENGTH), new Integer(ENTRY_PASSWORD_MAX_LENGTH),
                                register_customer_body_confirm_password);
            }

            if (sender == null)
            {
                if (confirmPasswordTB.getText() != null && passwordTB.getText() != null)
                {
                    if (!confirmPasswordTB.getText().equals(passwordTB.getText()))
                    {
                        setErrorMsg(register_customer_body_passwords_no_match);
                        ret = false;
                    }
                }
            }

        } else
        {
            if (sender == null || sender == emailTB)
            {
                ret = ret
                        & GWT_Validation.validateText(emailTB, new Integer(
                                ENTRY_EMAIL_ADDRESS_MIN_LENGTH), new Integer(
                                ENTRY_EMAIL_ADDRESS_MAX_LENGTH), login_body_email);
            }
        }
        return ret;
    }

    /**
     * @return Returns a customer registration object
     */
    public GWT_CustomerRegistration getCustReg()
    {

        GWT_CustomerRegistration custReg = new GWT_CustomerRegistration();

        custReg.setCity(cityTB.getText());
        custReg.setCompany(compNameTB.getText());
        custReg.setFaxNumber(faxTB.getText());
        custReg.setFirstName(firstNameTB.getText());
        custReg.setLastName(lastNameTB.getText());
        custReg.setPassword(passwordTB.getText());
        custReg.setPostcode(postCodeTB.getText());
        custReg.setStreetAddress(streetAddrTB.getText());
        custReg.setStreetAddress1(streetAddr1TB.getText());
        custReg.setSuburb(suburbTB.getText());
        custReg.setTelephoneNumber(telTB.getText());
        custReg.setTelephoneNumber1(tel1TB.getText());
        custReg.setNewsletter("1");
        custReg.setBirthDate(getDOB());
        custReg.setEmailAddr(emailTB.getText());
        custReg.setEnabled(true);

        custReg.setCountryId(new Integer(countryLB.getValue(countryLB.getSelectedIndex()))
                .intValue());

        if (maleRB.getValue())
        {
            custReg.setGender("m");
        } else
        {
            custReg.setGender("f");
        }

        custReg.setZoneId(-1);
        if (stateListDisplayed)
        {
            if (zoneListLB != null && zoneListLB.getItemCount() > 0)
            {               
                String state = zoneListLB.getItemText(zoneListLB.getSelectedIndex());
                custReg.setState(state);
            }
        } else
        {
             custReg.setState(stateTB.getText());
        }

        return custReg;
    }

    /**
     * Set attributes from hidden parameters in JSP
     */
    protected void setAttr(String name, String value)
    {
        super.setAttr(name, value);

        if (name.equals("one.page.checkout.enter.shipping.address"))
        {
            one_page_checkout_enter_shipping_address = value;
        } else if (name.equals("one.page.checkout.enter.password"))
        {
            one_page_checkout_enter_password = value;
        } else if (name.equals("register.customer.body.passwords.no.match"))
        {
            register_customer_body_passwords_no_match = value;
        }
    }

    /**
     * Validate the user's email address *
     */
    protected void validateEmail()
    {
        getKK().getMyKKGWTService().isEmailValid(emailTB.getText(), isEmailValidCallback);
    }

    AsyncCallback<?> isEmailValidCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {

            Boolean isValid = (Boolean) result;

            if (isValid.booleanValue())
            {
                getKK().controller(Konakart.EMAIL_VALID);
            } else
            {
                getKK().controller(Konakart.EMAIL_NOT_VALID);
            }
        }
    };
}
