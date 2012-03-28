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

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.konakart.client.util.GWT_Validation;

/**
 * Login window
 */
public class LoginBody extends KKBaseWin
{

    /*
     * Objects
     */

    /*
     * Widgets
     */
    private TextBox userTB;

    private PasswordTextBox passwordTB;

    private HTML forgotPasswordLink;

    /*
     * Labels
     */
    private String login_body_email = "login.body.email";

    private String login_body_password = "login.body.password";

    private String login_body_forgotten_password = "login.body.forgotten.password";

    private String login_body_login_error = "login.body.login.error";

    private String login_body_invalid_email = "login.body.invalid.email";

    private String forgotten_password_body_explanation1 = "forgotten.password.body.explanation1";

    private String forgotten_password_body_sentpw = "forgotten.password.body.sentpw";

    private String login_body_welcome_email = "login.body.welcome.email";

    private String login_body_welcome = "login.body.welcome";

    private String forgotten_password_body_forgotten = "forgotten.password.body.forgotten";

    private String one_page_checkout_enter_email = "one.page.checkout.enter.email";

    private String one_page_checkout_enter_password_login = "one.page.checkout.enter.password.login";

    private String email_welcome_subject = "email.welcome.subject";

    /*
     * Validation
     */

    // Mins
    private int ENTRY_EMAIL_ADDRESS_MIN_LENGTH = 1;

    // Max
    private int ENTRY_EMAIL_ADDRESS_MAX_LENGTH = 96;

    /**
     * Constructor
     * 
     * @param kk
     */
    public LoginBody(Konakart kk)
    {
        setKK(kk);

        // Get the parameters from the JSP
        getParameters("kkLabelForm2");

        // Initialise the widgets
        initWidgets();

    }

    /*
     * ----- Callbacks
     */

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

    /*
     * ----- End of Callbacks
     */

    /**
     * Creates the panel to ask for the email
     */
    protected void renderGetEmail()
    {
        // Remove the current panel
        removeFromDom();

        // Get the container panel
        HTMLPanel containerPanel = getContainerPanel(1);

        // Get the header
        Widget header = renderHeader(login_body_welcome_email, "table_background_login.gif",
                login_body_welcome_email);

        // Add the header to the container panel
        containerPanel.add(header, HEADER_ID);

        // Create the body
        FlexTable ft0 = getTable(0, "100%", 0, 0, "body-content-tab");

        int row = 0;

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, getVSpacer());

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setHTML(row++, 0, "<b>" + one_page_checkout_enter_email + ":</b>");

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, getVSpacer());

        ft0.setHTML(row, 0, "<b>" + login_body_email + ":</b>");
        ft0.setWidget(row++, 1, userTB);

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, getVSpacer());

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, errorFT);

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, getVSpacer());

        containerPanel.add(ft0, BODY_ID);
        containerPanel.add(getButtons(2), BUTTON_ID);

        // Finally, add the outer panel to the RootPanel, so that it will be
        // displayed.
        addToDom(containerPanel);

    }

    /**
     * Creates the panel to ask for the password
     */
    protected void renderGetPassword()
    {
        // Remove the current panel
        removeFromDom();

        // Clear the password entry field
        passwordTB.setText("");

        // Get the container panel
        HTMLPanel containerPanel = getContainerPanel(1);

        // Get the header
        Widget header = renderHeader(login_body_welcome, "table_background_login.gif",
                login_body_welcome);

        // Add the header to the container panel
        containerPanel.add(header, HEADER_ID);

        // Create the body
        FlexTable ft0 = getTable(0, "100%", 0, 0, "body-content-tab");

        int row = 0;

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, getVSpacer());

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, successFT);

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setHTML(row++, 0, "<b>" + email_welcome_subject + " \"" + userTB.getText() + "\", "
                + one_page_checkout_enter_password_login + ":</b>");

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, getVSpacer());

        ft0.setHTML(row, 0, "<b>" + login_body_password + ":</b>");
        ft0.setWidget(row++, 1, passwordTB);

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, getVSpacer());

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, errorFT);

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        formatCell(ft0, row, 0, "smallText", null, "bottom", null);
        ft0.setWidget(row++, 0, forgotPasswordLink);

        containerPanel.add(ft0, BODY_ID);
        containerPanel.add(getButtons(2), BUTTON_ID);

        // Finally, add the outer panel to the RootPanel, so that it will be
        // displayed.
        addToDom(containerPanel);
    }

    /**
     * Creates the panel to ask to send the forgotten password
     */
    protected void renderForgotPassword()
    {
        // Remove the current panel
        removeFromDom();

        // Get the container panel
        HTMLPanel containerPanel = getContainerPanel(1);

        // Get the header
        Widget header = renderHeader(forgotten_password_body_forgotten,
                "table_background_password_forgotten.gif", forgotten_password_body_forgotten);

        // Add the header to the container panel
        containerPanel.add(header, HEADER_ID);

        // Create the body
        FlexTable ft0 = getTable(0, "100%", 0, 0, "body-content-tab");

        int row = 0;

        ft0.setWidget(row++, 0, getVSpacer());

        ft0.setHTML(row++, 0, forgotten_password_body_explanation1 + " <b>" + getUserName()
                + "</b>");

        ft0.getFlexCellFormatter().setColSpan(row, 0, 2);
        ft0.setWidget(row++, 0, getVSpacer());

        containerPanel.add(ft0, BODY_ID);
        containerPanel.add(getButtons(2), BUTTON_ID);

        // Finally, add the outer panel to the RootPanel, so that it will be
        // displayed.
        addToDom(containerPanel);
    }

    /**
     * Validate the user's email address *
     */
    protected void validateEmail()
    {

        String email = userTB.getText();

        if (email == null || email.length() == 0)
        {
            getKK().controller(Konakart.EMAIL_NOT_VALID);
            return;
        }

        if (GWT_Validation.validateText(userTB, new Integer(ENTRY_EMAIL_ADDRESS_MIN_LENGTH),
                new Integer(ENTRY_EMAIL_ADDRESS_MAX_LENGTH), login_body_email) == false)
        {
            getKK().controller(Konakart.EMAIL_NOT_VALID);
            return;
        }

        getKK().getMyKKGWTService().isEmailValid(email, isEmailValidCallback);

    }

    /**
     * Clears the success msg
     * 
     */
    protected void clearSuccessMsg()
    {
        clearTable(successFT);
    }

    /**
     * Initialise widgets to ensure that they are there for when the data arrives
     */
    protected void initWidgets()
    {

        super.initWidgets();

        userTB = new TextBox();
        initTextBox(userTB);

        passwordTB = new PasswordTextBox();
        initPasswordTextBox(passwordTB);

        forgotPasswordLink = new HTML("<a href='javascript:;'>" + login_body_forgotten_password
                + "</a>");
        forgotPasswordLink.setStyleName("smallText");
        initLink(forgotPasswordLink);
    }

    /**
     * Initialises the text box
     * 
     * @param textBox
     */
    private void initTextBox(TextBox textBox)
    {
        textBox.setTextAlignment(TextBoxBase.ALIGN_LEFT);
        textBox.setWidth("30em");
        textBox.addChangeHandler(new ChangeHandler()
        {
            public void onChange(ChangeEvent event)
            {
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
        textBox.setWidth("30em");
        textBox.addChangeHandler(new ChangeHandler()
        {
            public void onChange(ChangeEvent event)
            {
            }
        });
    }

    /**
     * Initialises the link
     * 
     * @param button
     */
    private void initLink(HTML link)
    {
        link.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                Widget sender = (Widget) event.getSource();
                
                if (sender == forgotPasswordLink)
                {
                    getKK().controller(Konakart.FORGOT_PASSWORD);
                }
            }
        });
    }

    /**
     * Set attributes from hidden parameters in JSP
     */
    protected void setAttr(String name, String value)
    {
        if (name.equals("login.body.email"))
        {
            login_body_email = value;
        } else if (name.equals("login.body.password"))
        {
            login_body_password = value;
        } else if (name.equals("login.body.forgotten.password"))
        {
            login_body_forgotten_password = value;
        } else if (name.equals("login.body.login.error"))
        {
            login_body_login_error = value;
        } else if (name.equals("login.body.invalid.email"))
        {
            login_body_invalid_email = value;
        } else if (name.equals("forgotten.password.body.explanation1"))
        {
            forgotten_password_body_explanation1 = value;
        } else if (name.equals("forgotten.password.body.sentpw"))
        {
            forgotten_password_body_sentpw = value;
        } else if (name.equals("login.body.welcome.email"))
        {
            login_body_welcome_email = value;
        } else if (name.equals("login.body.welcome"))
        {
            login_body_welcome = value;
        } else if (name.equals("forgotten.password.body.forgotten"))
        {
            forgotten_password_body_forgotten = value;
        } else if (name.equals("one.page.checkout.enter.email"))
        {
            one_page_checkout_enter_email = value;
        } else if (name.equals("one.page.checkout.enter.password.login"))
        {
            one_page_checkout_enter_password_login = value;
        } else if (name.equals("email.welcome.subject"))
        {
            email_welcome_subject = value;
        } else if (name.equals("ENTRY_EMAIL_ADDRESS_MIN_LENGTH"))
        {
            ENTRY_EMAIL_ADDRESS_MIN_LENGTH = new Integer(value).intValue();
        }
    }

    /**
     * @return Returns the username
     */
    public String getUserName()
    {
        return userTB.getText();
    }

    /**
     * Sets the username
     * @param userName 
     */
    public void setUserName(String userName)
    {
        userTB.setText(userName);
    }

    /**
     * @return Returns the password
     */
    public String getPassword()
    {
        return passwordTB.getText();
    }

    /**
     * @return Returns the login_body_login_error.
     */
    public String getLogin_body_login_error()
    {
        return login_body_login_error;
    }

    /**
     * @return Returns the login_body_invalid_email.
     */
    public String getLogin_body_invalid_email()
    {
        return login_body_invalid_email;
    }

    /**
     * @return Returns the forgotten_password_body_sentpw.
     */
    public String getForgotten_password_body_sentpw()
    {
        return forgotten_password_body_sentpw;
    }

}
