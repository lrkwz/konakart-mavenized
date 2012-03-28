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

import java.util.Date;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.konakart.client.app.GWT_Country;
import com.konakart.client.app.GWT_Zone;
import com.konakart.client.util.GWT_Date;
import com.konakart.client.util.GWT_Validation;

/**
 * 
 */
public class RegisterAndAddrBase extends KKBaseWin
{
    // Records whether or not the State drop list is currently displayed
    protected boolean stateListDisplayed = true;

    // Row at which state information is shown
    protected int stateRow;

    // Visible fields based on config variables
    protected boolean SHOW_GENDER = true;

    protected boolean SHOW_DOB = true;

    protected boolean SHOW_COMPANY = true;

    protected boolean SHOW_STREET_ADDR1 = true;

    protected boolean SHOW_SUBURB = true;

    protected boolean SHOW_STATE = true;

    /*
     * Widgets
     */

    protected String WIDTH1 = "45%";

    protected String WIDTH2 = "10%";

    protected String WIDTH3 = "45%";

    protected FlexTable ft111;

    private ListBox dobDayLB;

    private ListBox dobMonthLB;

    private ListBox dobYearLB;

    private static final String widgetLength = "20em";

    protected RadioButton maleRB;

    protected RadioButton femaleRB;

    protected TextBox firstNameTB;

    protected TextBox lastNameTB;

    protected TextBox compNameTB;

    protected TextBox streetAddrTB;

    protected TextBox streetAddr1TB;

    protected TextBox suburbTB;

    protected TextBox postCodeTB;

    protected TextBox cityTB;

    protected TextBox stateTB;

    protected TextBox telTB;

    protected TextBox tel1TB;

    protected TextBox faxTB;

    protected PasswordTextBox passwordTB;

    protected PasswordTextBox confirmPasswordTB;

    protected ListBox countryLB;

    protected ListBox zoneListLB;

    protected TextBox emailTB;

    /*
     * Labels
     */

    protected String register_customer_body_gender = "register.customer.body.gender";

    protected String register_customer_body_male = "register.customer.body.male";

    protected String register_customer_body_female = "register.customer.body.female";

    protected String register_customer_body_first_name = "register.customer.body.first.name";

    protected String register_customer_body_last_name = "register.customer.body.last.name";

    protected String register_customer_body_dob = "register.customer.body.dob";

    protected String register_customer_body_company_name = "register.customer.body.company.name";

    protected String register_customer_body_street_addr = "register.customer.body.street.addr";

    protected String register_customer_body_street_addr1 = "register.customer.body.street.addr1";

    protected String register_customer_body_suburb = "register.customer.body.suburb";

    protected String register_customer_body_postcode = "register.customer.body.postcode";

    protected String register_customer_body_city = "register.customer.body.city";

    protected String register_customer_body_state = "register.customer.body.state";

    protected String register_customer_body_country = "register.customer.body.country";

    protected String register_customer_body_tel_number = "register.customer.body.tel.number";

    protected String register_customer_body_tel_number1 = "register.customer.body.tel.number1";

    protected String register_customer_body_fax_number = "register.customer.body.fax.number";

    protected String register_customer_body_password = "register.customer.body.password";

    protected String register_customer_body_confirm_password = "register.customer.body.confirm.password";

    protected String register_customer_body_required_info = "register.customer.body.required.info";

    protected String register_customer_body_delivery_details = "register.customer.body.delivery.details";

    protected String register_customer_body_select = "register.customer.body.select";

    protected String one_page_checkout_shipping_address = "one.page.checkout.shipping.address";

    protected String one_page_checkout_billing_address = "one.page.checkout.billing.address";

    protected String login_body_email = "login.body.email";

    /*
     * Validation
     */

    // Mins
    protected int ENTRY_FIRST_NAME_MIN_LENGTH = 1;

    protected int ENTRY_LAST_NAME_MIN_LENGTH = 1;

    protected int ENTRY_STREET_ADDRESS_MIN_LENGTH = 1;

    protected int ENTRY_STREET_ADDRESS1_MIN_LENGTH = 1;

    protected int ENTRY_SUBURB_MIN_LENGTH = 1;

    protected int ENTRY_COMPANY_MIN_LENGTH = 1;

    protected int ENTRY_POSTCODE_MIN_LENGTH = 1;

    protected int ENTRY_CITY_MIN_LENGTH = 1;

    protected int ENTRY_STATE_MIN_LENGTH = 1;

    protected int ENTRY_TELEPHONE_MIN_LENGTH = 1;

    protected int ENTRY_PASSWORD_MIN_LENGTH = 1;

    protected int ENTRY_EMAIL_ADDRESS_MIN_LENGTH = 1;

    // Max
    protected int ENTRY_FIRST_NAME_MAX_LENGTH = 32;

    protected int ENTRY_LAST_NAME_MAX_LENGTH = 32;

    protected int ENTRY_STREET_ADDRESS_MAX_LENGTH = 64;

    protected int ENTRY_STREET_ADDRESS1_MAX_LENGTH = 64;

    protected int ENTRY_SUBURB_MAX_LENGTH = 32;

    protected int ENTRY_COMPANY_MAX_LENGTH = 32;

    protected int ENTRY_POSTCODE_MAX_LENGTH = 10;

    protected int ENTRY_CITY_MAX_LENGTH = 32;

    protected int ENTRY_STATE_MAX_LENGTH = 32;

    protected int ENTRY_TELEPHONE_MAX_LENGTH = 32;

    protected int ENTRY_PASSWORD_MAX_LENGTH = 30;

    protected int ENTRY_EMAIL_ADDRESS_MAX_LENGTH = 96;

    /*
     * Store country
     */
    protected int STORE_COUNTRY = -1;

    /**
     * Init method
     * 
     */
    protected void init()
    {
        // Get the parameters from the JSP
        getParameters("kkLabelForm3");

        // Initialise the widgets
        initWidgets();

        // Get countries
        getKK().getMyKKGWTService().getAllCountries(getAllCountriesCallback);
    }

    /*
     * ----- Callbacks
     */

    /**
     * Get the countries and fill in the list box
     */
    AsyncCallback<?> getAllCountriesCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            GWT_Country[] countries = (GWT_Country[]) result;
            if (countries != null)
            {
                for (int i = 0; i < countries.length; i++)
                {
                    GWT_Country country = countries[i];
                    if (country.getId() == STORE_COUNTRY)
                    {
                        countryLB.insertItem(country.getName(), Integer.toString(country.getId()),
                                0);
                        countryLB.setItemSelected(0, true);
                    } else
                    {
                        countryLB.addItem(country.getName(), Integer.toString(country.getId()));
                    }
                }
                if (countryLB.getItemText(0) != null)
                {
                    getKK().getMyKKGWTService().getZonesPerCountry(
                            Integer.parseInt(countryLB.getValue(0)), getZonesPerCountryCallback);
                }
            }

        }
    };

    AsyncCallback<?> getZonesPerCountryCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            GWT_Zone[] zones = ((GWT_Zone[]) result);
            zoneListLB.clear();
            if (zones != null && zones.length > 0)
            {
                String state = stateTB.getText();
                zoneListLB.addItem(register_customer_body_select, "-1");
                for (int zone = 0; zone < zones.length; zone++)
                {
                    zoneListLB.addItem(zones[zone].getZoneName(), Integer.toString(zones[zone]
                            .getZoneId()));
                    if (state != null
                            && (state.equalsIgnoreCase(zones[zone].getZoneName()) || state
                                    .equalsIgnoreCase(zones[zone].getZoneCode())))
                    {
                        zoneListLB.setSelectedIndex(zone+1);
                    }
                }

                stateTB.setText("");
                setStateOrZone(/* state */false);
            } else
            {
                // No zones for this country. Set zoneId to 0 and show state field
                setStateOrZone(/* state */true);
            }
        }
    };

    /*
     * ----- End of Callbacks
     */

    /**
     * Initialise widgets to ensure that they are there for when the data arrives
     */
    protected void initWidgets()
    {

        super.initWidgets();

        passwordTB = new PasswordTextBox();
        initPasswordTextBox(passwordTB);
        confirmPasswordTB = new PasswordTextBox();
        initPasswordTextBox(confirmPasswordTB);

        // Customer widgets
        firstNameTB = new TextBox();
        initTextBox(firstNameTB);
        lastNameTB = new TextBox();
        initTextBox(lastNameTB);
        compNameTB = new TextBox();
        initTextBox(compNameTB);
        streetAddrTB = new TextBox();
        initTextBox(streetAddrTB);
        streetAddr1TB = new TextBox();
        initTextBox(streetAddr1TB);
        suburbTB = new TextBox();
        initTextBox(suburbTB);
        postCodeTB = new TextBox();
        initTextBox(postCodeTB);
        cityTB = new TextBox();
        initTextBox(cityTB);
        stateTB = new TextBox();
        initTextBox(stateTB);
        telTB = new TextBox();
        initTextBox(telTB);
        tel1TB = new TextBox();
        initTextBox(tel1TB);
        faxTB = new TextBox();
        initTextBox(faxTB);
        emailTB = new TextBox();
        initTextBox(emailTB);

        maleRB = new RadioButton("genderGroup", register_customer_body_male);
        initRadio(maleRB);
        maleRB.setValue(true);
        femaleRB = new RadioButton("genderGroup", register_customer_body_female);
        initRadio(maleRB);

        countryLB = new ListBox();
        initListBox(countryLB);
        zoneListLB = new ListBox();
        initListBox(zoneListLB);

        dobYearLB = new ListBox();
        dobMonthLB = new ListBox();
        dobDayLB = new ListBox();
        Date dateNow = new Date();
        for (int d = 1900; d < GWT_Date.getYear(dateNow) + 1900 + 1; d++)
        {
            String year = Integer.toString(d);
            dobYearLB.addItem(year, year);
        }
        for (int d = 1; d < 13; d++)
        {
            String month = Integer.toString(d);
            dobMonthLB.addItem(month, month);
        }
        for (int d = 1; d < 32; d++)
        {
            String day = Integer.toString(d);
            dobDayLB.addItem(day, day);
        }
    }

    /**
     * Creates the table rows for showing the address fields and appends them to ft111. Only show
     * the date of birth and phone numbers if register is set to true
     * 
     * @param ft
     * @param row
     * @param colspan
     * @param register
     * @param showEmail
     * @return Returns the current row
     */
    protected int getAddrTable(FlexTable ft, int row, int colspan, boolean register,
            boolean showEmail)
    {
        // Customer attributes
        if (SHOW_GENDER)
        {
            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
            ft.setHTML(row, 0, register_customer_body_gender + ":");
            FlexTable genderFT = getTable(0, "100%", 0, 0, "body-content-tab");
            formatCell(genderFT, 0, 0, null, "left", null, "50%");
            formatCell(genderFT, 0, 1, null, "left", null, "50%");
            genderFT.setWidget(0, 0, maleRB);
            genderFT.setWidget(0, 1, femaleRB);
            ft.setWidget(row, 1, genderFT);
            ft.setHTML(row++, 2, " *");
        }

        formatCell(ft, row, 0, null, "left", null, WIDTH1);
        formatCell(ft, row, 1, null, "left", null, WIDTH2);
        formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
        ft.setHTML(row, 0, register_customer_body_first_name + ":");
        ft.setWidget(row, 1, firstNameTB);
        ft.setHTML(row++, 2, " *");

        formatCell(ft, row, 0, null, "left", null, WIDTH1);
        formatCell(ft, row, 1, null, "left", null, WIDTH2);
        formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
        ft.setHTML(row, 0, register_customer_body_last_name + ":");
        ft.setWidget(row, 1, lastNameTB);
        ft.setHTML(row++, 2, " *");

        if (showEmail && register)
        {
            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
            ft.setHTML(row, 0, login_body_email + ":");
            ft.setWidget(row, 1, emailTB);
            ft.setHTML(row++, 2, " *");
        }

        if (SHOW_DOB && register)
        {
            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
            ft.setHTML(row, 0, register_customer_body_dob + ":");
            ft.setWidget(row, 1, createDOBField());
            ft.setHTML(row++, 2, " *");
        }

        if (SHOW_COMPANY)
        {
            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            ft.setHTML(row, 0, register_customer_body_company_name + ":");
            ft.setWidget(row++, 1, compNameTB);
        } else
        {
            compNameTB.setText("");
        }

        formatCell(ft, row, 0, null, "left", null, WIDTH1);
        formatCell(ft, row, 1, null, "left", null, WIDTH2);
        formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
        ft.setHTML(row, 0, register_customer_body_street_addr + ":");
        ft.setWidget(row, 1, streetAddrTB);
        ft.setHTML(row++, 2, " *");

        if (SHOW_STREET_ADDR1)
        {
            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            ft.setHTML(row, 0, register_customer_body_street_addr1 + ":");
            ft.setWidget(row++, 1, streetAddr1TB);
        } else
        {
            streetAddr1TB.setText("");
        }

        if (SHOW_SUBURB)
        {
            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            ft.setHTML(row, 0, register_customer_body_suburb + ":");
            ft.setWidget(row++, 1, suburbTB);
        } else
        {
            suburbTB.setText("");
        }

        formatCell(ft, row, 0, null, "left", null, WIDTH1);
        formatCell(ft, row, 1, null, "left", null, WIDTH2);
        formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
        ft.setHTML(row, 0, register_customer_body_postcode + ":");
        ft.setWidget(row, 1, postCodeTB);
        ft.setHTML(row++, 2, " *");

        formatCell(ft, row, 0, null, "left", null, WIDTH1);
        formatCell(ft, row, 1, null, "left", null, WIDTH2);
        formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
        ft.setHTML(row, 0, register_customer_body_city + ":");
        ft.setWidget(row, 1, cityTB);
        ft.setHTML(row++, 2, " *");

        // Show a text box for state or a list box showing available states if they are defined in
        // the DB
        stateRow = row++;
        setStateOrZone(/* state */true);

        formatCell(ft, row, 0, null, "left", null, WIDTH1);
        formatCell(ft, row, 1, null, "left", null, WIDTH2);
        formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
        ft.setHTML(row, 0, register_customer_body_country + ":");
        ft.setWidget(row, 1, countryLB);
        ft.setHTML(row++, 2, " *");

        if (register)
        {
            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            formatCell(ft, row, 2, "inputRequirement", "left", null, WIDTH3);
            ft.setHTML(row, 0, register_customer_body_tel_number + ":");
            ft.setWidget(row, 1, telTB);
            ft.setHTML(row++, 2, " *");

            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            ft.setHTML(row, 0, register_customer_body_tel_number1 + ":");
            ft.setWidget(row++, 1, tel1TB);

            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            ft.setHTML(row, 0, register_customer_body_fax_number + ":");
            ft.setWidget(row++, 1, faxTB);
        }

        // Determines whether to show state text box or drop list
        if (countryLB.getItemCount() > 0)
        {
            int countryId = new Integer(countryLB.getValue(countryLB.getSelectedIndex()))
                    .intValue();
            getKK().getMyKKGWTService().getZonesPerCountry(countryId, getZonesPerCountryCallback);
        }

        if (!register)
        {
            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            ft.setHTML(row, 0, register_customer_body_tel_number + ":");
            ft.setWidget(row++, 1, telTB);

            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            ft.setHTML(row, 0, register_customer_body_tel_number1 + ":");
            ft.setWidget(row++, 1, tel1TB);

            formatCell(ft, row, 0, null, "left", null, WIDTH1);
            formatCell(ft, row, 1, null, "left", null, WIDTH2);
            ft.setHTML(row, 0, login_body_email + ":");
            ft.setWidget(row++, 1, emailTB);
        }

        return row;
    }

    /**
     * Initialises the text box
     * 
     * @param textBox
     */
    private void initTextBox(TextBox textBox)
    {
        textBox.setTextAlignment(TextBoxBase.ALIGN_LEFT);
        textBox.setWidth(widgetLength);
        textBox.addChangeHandler(new ChangeHandler()
        {
            public void onChange(ChangeEvent event)
            {
            }
        });
        textBox.addKeyUpHandler(new KeyUpHandler()
        {
            public void onKeyUp(KeyUpEvent event)
            {
                validate((Widget) event.getSource());
            }
        });
    }

    /**
     * Initialises the list box
     * 
     * @param textBox
     */
    private void initListBox(ListBox listBox)
    {
        listBox.setWidth(widgetLength);
        listBox.addChangeHandler(new ChangeHandler()
        {
            public void onChange(ChangeEvent event)
            {
                Widget sender = (Widget) event.getSource();

                if (sender == countryLB)
                {
                    int countryId = new Integer(countryLB.getValue(countryLB.getSelectedIndex()))
                            .intValue();
                    getKK().getMyKKGWTService().getZonesPerCountry(countryId,
                            getZonesPerCountryCallback);
                } else if (sender == zoneListLB)
                {
                    validate(sender);
                }
            }
        });
    }

    /**
     * Initialises the password text box
     * 
     * @param textBox
     */
    private void initPasswordTextBox(PasswordTextBox textBox)
    {
        textBox.setTextAlignment(TextBoxBase.ALIGN_LEFT);
        textBox.setWidth(widgetLength);
        textBox.addChangeHandler(new ChangeHandler()
        {
            public void onChange(ChangeEvent event)
            {
            }
        });

        textBox.addKeyUpHandler(new KeyUpHandler()
        {
            public void onKeyUp(KeyUpEvent event)
            {
                Widget sender = (Widget) event.getSource();
                validate(sender);
            }
        });
    }

    /**
     * Initialises the radio button
     * 
     * @param button
     */
    private void initRadio(RadioButton rb)
    {
        rb.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                Widget sender = (Widget) event.getSource();

                if (sender == maleRB)
                {
                } else if (sender == femaleRB)
                {
                }
            }
        });
    }

    protected Widget createDOBField()
    {
        HorizontalPanel p = new HorizontalPanel();
        // p.setSpacing(4);

        p.add(dobDayLB);
        p.add(dobMonthLB);
        p.add(dobYearLB);

        return p;
    }

    /**
     * If we have a list of zones in the DB for the country, then we show them. Otherwise we show an
     * entry field for the state.
     * 
     * @param state
     */
    protected void setStateOrZone(boolean state)
    {

        formatCell(ft111, stateRow, 0, null, "left", null, WIDTH1);
        formatCell(ft111, stateRow, 1, null, "left", null, WIDTH2);
        formatCell(ft111, stateRow, 2, "inputRequirement", "left", null, WIDTH3);

        if (state && SHOW_STATE)
        {
            stateListDisplayed = false;
            ft111.setHTML(stateRow, 0, register_customer_body_state + ":");
            ft111.setWidget(stateRow, 1, stateTB);
            ft111.setHTML(stateRow, 2, " *");
        } else if (state && !SHOW_STATE)
        {
            stateListDisplayed = false;
            stateTB.setText("");
            ft111.setHTML(stateRow, 0, "");
            ft111.remove(stateTB);
            ft111.remove(zoneListLB);
            ft111.setHTML(stateRow, 2, "");
        } else
        {
            stateListDisplayed = true;
            ft111.setHTML(stateRow, 0, register_customer_body_state + ":");
            ft111.setWidget(stateRow, 1, zoneListLB);
            ft111.setHTML(stateRow, 2, " *");
        }

    }

    /**
     * Validation logic
     * 
     * @param sender
     * 
     * @return true if it all validates
     */
    public boolean validate(Widget sender)
    {
        boolean ret = true;

        if (sender == null || sender == firstNameTB)
        {
            ret = ret
                    & GWT_Validation.validateText(firstNameTB, new Integer(
                            ENTRY_FIRST_NAME_MIN_LENGTH), new Integer(ENTRY_FIRST_NAME_MAX_LENGTH),
                            register_customer_body_first_name);
        }

        if (sender == null || sender == lastNameTB)
        {
            ret = ret
                    & GWT_Validation.validateText(lastNameTB, new Integer(
                            ENTRY_LAST_NAME_MIN_LENGTH), new Integer(ENTRY_LAST_NAME_MAX_LENGTH),
                            register_customer_body_last_name);
        }

        if (SHOW_COMPANY)
        {
            if (sender == null || sender == compNameTB)
            {
                ret = ret
                        & GWT_Validation.validateTextOptional(compNameTB, new Integer(
                                ENTRY_COMPANY_MIN_LENGTH), new Integer(ENTRY_COMPANY_MAX_LENGTH),
                                register_customer_body_company_name);
            }
        }

        if (sender == null || sender == streetAddrTB)
        {
            ret = ret
                    & GWT_Validation.validateText(streetAddrTB, new Integer(
                            ENTRY_STREET_ADDRESS_MIN_LENGTH), new Integer(
                            ENTRY_STREET_ADDRESS_MAX_LENGTH), register_customer_body_street_addr);
        }

        if (SHOW_STREET_ADDR1)
        {
            if (sender == null || sender == streetAddr1TB)
            {
                ret = ret
                        & GWT_Validation.validateText(streetAddr1TB, new Integer(
                                ENTRY_STREET_ADDRESS1_MIN_LENGTH), new Integer(
                                ENTRY_STREET_ADDRESS1_MAX_LENGTH),
                                register_customer_body_street_addr1);
            }
        }

        if (SHOW_SUBURB)
        {
            if (sender == null || sender == suburbTB)
            {
                ret = ret
                        & GWT_Validation.validateTextOptional(suburbTB, new Integer(
                                ENTRY_SUBURB_MIN_LENGTH), new Integer(ENTRY_SUBURB_MAX_LENGTH),
                                register_customer_body_suburb);
            }
        }
        if (sender == null || sender == postCodeTB)
        {
            ret = ret
                    & GWT_Validation.validateText(postCodeTB,
                            new Integer(ENTRY_POSTCODE_MIN_LENGTH), new Integer(
                                    ENTRY_POSTCODE_MAX_LENGTH), register_customer_body_postcode);
        }

        if (sender == null || sender == cityTB)
        {
            ret = ret
                    & GWT_Validation.validateText(cityTB, new Integer(ENTRY_CITY_MIN_LENGTH),
                            new Integer(ENTRY_CITY_MAX_LENGTH), register_customer_body_city);
        }
        if (SHOW_STATE && !stateListDisplayed)
        {
            if (sender == null || sender == stateTB)
            {
                ret = ret
                        & GWT_Validation.validateText(stateTB, new Integer(ENTRY_STATE_MIN_LENGTH),
                                new Integer(ENTRY_STATE_MAX_LENGTH), register_customer_body_state);
            }
        }

        if (stateListDisplayed && (sender == null || sender == zoneListLB))
        {
            ret = ret & GWT_Validation.validateListBox(zoneListLB, 1, null, null);
        }

        if (sender == null || sender == telTB)
        {
            ret = ret
                    & GWT_Validation.validateTextOptional(telTB, new Integer(
                            ENTRY_TELEPHONE_MIN_LENGTH), new Integer(ENTRY_TELEPHONE_MAX_LENGTH),
                            register_customer_body_tel_number);
        }

        if (sender == null || sender == tel1TB)
        {
            ret = ret
                    & GWT_Validation.validateTextOptional(tel1TB, new Integer(
                            ENTRY_TELEPHONE_MIN_LENGTH), new Integer(ENTRY_TELEPHONE_MAX_LENGTH),
                            register_customer_body_tel_number1);
        }

        if (sender == null || sender == emailTB)
        {
            ret = ret
                    & GWT_Validation.validateEmailOptional(emailTB, new Integer(
                            ENTRY_EMAIL_ADDRESS_MIN_LENGTH), new Integer(
                            ENTRY_EMAIL_ADDRESS_MAX_LENGTH), login_body_email);
        }

        if (sender == null || sender == faxTB)
        {
            ret = ret
                    & GWT_Validation.validateTextOptional(faxTB, new Integer(
                            ENTRY_TELEPHONE_MIN_LENGTH), new Integer(ENTRY_TELEPHONE_MAX_LENGTH),
                            register_customer_body_fax_number);
        }

        return ret;
    }

    /**
     * Get the date of birth from the widgets
     * 
     * @return Returns the date of birth
     */
    protected Date getDOB()
    {
        int day = new Integer(dobDayLB.getItemText(dobDayLB.getSelectedIndex())).intValue();
        int month = new Integer(dobMonthLB.getItemText(dobMonthLB.getSelectedIndex())).intValue() - 1;
        int year = new Integer(dobYearLB.getItemText(dobYearLB.getSelectedIndex())).intValue() - 1900;
        Date dob = GWT_Date.setDate(day, month, year);
        return dob;
    }

    /**
     * Set attributes from hidden parameters in JSP
     */
    protected void setAttr(String name, String value)
    {
        if (name.equals("ACCOUNT_GENDER"))
        {
            SHOW_GENDER = new Boolean(value).booleanValue();
        } else if (name.equals("ACCOUNT_DOB"))
        {
            SHOW_DOB = new Boolean(value).booleanValue();
        } else if (name.equals("ACCOUNT_COMPANY"))
        {
            SHOW_COMPANY = new Boolean(value).booleanValue();
        } else if (name.equals("ACCOUNT_SUBURB"))
        {
            SHOW_SUBURB = new Boolean(value).booleanValue();
        } else if (name.equals("ACCOUNT_STREET_ADDRESS_1"))
        {
            SHOW_STREET_ADDR1 = new Boolean(value).booleanValue();
        } else if (name.equals("ACCOUNT_STATE"))
        {
            SHOW_STATE = new Boolean(value).booleanValue();
        } else if (name.equals("ENTRY_FIRST_NAME_MIN_LENGTH"))
        {
            ENTRY_FIRST_NAME_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_LAST_NAME_MIN_LENGTH"))
        {
            ENTRY_LAST_NAME_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_STREET_ADDRESS_MIN_LENGTH"))
        {
            ENTRY_STREET_ADDRESS_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_STREET_ADDRESS1_MIN_LENGTH"))
        {
            ENTRY_STREET_ADDRESS1_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_COMPANY_MIN_LENGTH"))
        {
            ENTRY_COMPANY_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_POSTCODE_MIN_LENGTH"))
        {
            ENTRY_POSTCODE_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_CITY_MIN_LENGTH"))
        {
            ENTRY_CITY_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_STATE_MIN_LENGTH"))
        {
            ENTRY_STATE_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_TELEPHONE_MIN_LENGTH"))
        {
            ENTRY_TELEPHONE_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_PASSWORD_MIN_LENGTH"))
        {
            ENTRY_PASSWORD_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("ENTRY_EMAIL_ADDRESS_MIN_LENGTH"))
        {
            ENTRY_EMAIL_ADDRESS_MIN_LENGTH = new Integer(value).intValue();
        } else if (name.equals("STORE_COUNTRY"))
        {
            STORE_COUNTRY = new Integer(value).intValue();
        } else if (name.equals("register.customer.body.gender"))
        {
            register_customer_body_gender = value;
        } else if (name.equals("register.customer.body.male"))
        {
            register_customer_body_male = value;
        } else if (name.equals("register.customer.body.female"))
        {
            register_customer_body_female = value;
        } else if (name.equals("register.customer.body.first.name"))
        {
            register_customer_body_first_name = value;
        } else if (name.equals("register.customer.body.last.name"))
        {
            register_customer_body_last_name = value;
        } else if (name.equals("register.customer.body.dob"))
        {
            register_customer_body_dob = value;
        } else if (name.equals("register.customer.body.company.name"))
        {
            register_customer_body_company_name = value;
        } else if (name.equals("register.customer.body.street.addr"))
        {
            register_customer_body_street_addr = value;
        } else if (name.equals("register.customer.body.street.addr1"))
        {
            register_customer_body_street_addr1 = value;
        } else if (name.equals("register.customer.body.suburb"))
        {
            register_customer_body_suburb = value;
        } else if (name.equals("register.customer.body.postcode"))
        {
            register_customer_body_postcode = value;

        } else if (name.equals("register.customer.body.city"))
        {
            register_customer_body_city = value;

        } else if (name.equals("register.customer.body.state"))
        {
            register_customer_body_state = value;

        } else if (name.equals("register.customer.body.country"))
        {
            register_customer_body_country = value;

        } else if (name.equals("register.customer.body.tel.number"))
        {
            register_customer_body_tel_number = value;
        } else if (name.equals("register.customer.body.tel.number1"))
        {
            register_customer_body_tel_number1 = value;
        } else if (name.equals("register.customer.body.fax.number"))
        {
            register_customer_body_fax_number = value;
        } else if (name.equals("register.customer.body.password"))
        {
            register_customer_body_password = value;

        } else if (name.equals("register.customer.body.confirm.password"))
        {
            register_customer_body_confirm_password = value;
        } else if (name.equals("register.customer.body.delivery.details"))
        {
            register_customer_body_delivery_details = value;
        } else if (name.equals("register.customer.body.required.info"))
        {
            register_customer_body_required_info = value;
        } else if (name.equals("register.customer.body.select"))
        {
            register_customer_body_select = value;
        } else if (name.equals("one.page.checkout.billing.address"))
        {
            one_page_checkout_billing_address = value;
        } else if (name.equals("one.page.checkout.shipping.address"))
        {
            one_page_checkout_shipping_address = value;
        } else if (name.equals("login.body.email"))
        {
            login_body_email = value;
        }
    }
}
