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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootPanel;
import com.konakart.client.app.GWT_Address;
import com.konakart.client.app.GWT_Customer;
import com.konakart.client.app.GWT_CustomerRegistration;
import com.konakart.client.util.KKExceptionDialog;

/**
 * This is the KonaKart One page Checkout application. It all starts here!
 */
public class Konakart extends KKBaseWin implements EntryPoint, ResizeHandler
{
    // service endpoint name
    private static final String GWT_SERVICE_ENDPOINT_NAME = "konakart";

    // This is the proxy to the konakart server for Async calls
    private KKGWTServiceIfAsync myKKGWTService;

    // Whether or not we are in hosted mode
    private boolean isHostedMode;

    // Url for redirecting to Struts actions
    private String redirectUrl;

    /*
     * Objects
     */
    private GWT_Customer currentCustomer;

    /*
     * Parameters
     */
    // Image height and width from Struts app
    private int headingImageWidth = 90, headingImageHeight = 90;

    // Language directory (set a default here)
    private String languageDir = "en_GB";

    // Locale
    private String locale;

    // Display prices with or without tax
    private boolean dispPriceWithTax = true;

    // Display coupon
    private boolean dispCoupon = true;

    // Display gift certificate
    private boolean dispGiftCert = true;

    // Display reward points
    private boolean dispRewardPoints = true;

    // Allow checkout without registration
    private boolean allowNoRegister = false;

    // Used to store a random password
    private String randomPassword = null;

    /*
     * Controller state
     */
    private static int START_STATE = 1;

    private static int EMAIL_STATE = 2;

    private static int PASSWORD_STATE = 3;

    private static int REGISTER_STATE = 4;

    private static int CHECKOUT_STATE = 5;

    private static int FORGOT_PASSWORD_STATE = 6;

    private static int EDIT_DELIVERY_STATE = 7;

    private static int EDIT_BILLING_STATE = 8;

    private static int CHOOSE_BILLING_STATE = 9;

    private static int CHOOSE_DELIVERY_STATE = 10;

    /*
     * Controller action
     */
    protected static int NONE = 0;

    protected static int BACK = 1;

    protected static int CONTINUE = 2;

    protected static int CUST_FOUND = 3;

    protected static int CUST_NOT_FOUND = 4;

    protected static int FORGOT_PASSWORD = 5;

    protected static int LOGIN_OK = 6;

    protected static int LOGIN_KO = 7;

    protected static int LOGGED_IN = 8;

    protected static int NOT_LOGGED_IN = 9;

    protected static int REGISTER_OK = 10;

    protected static int EMAIL_VALID = 11;

    protected static int EMAIL_NOT_VALID = 12;

    protected static int PASSWORD_SENT = 13;

    protected static int EDIT_BILLING_ADDR = 14;

    protected static int EDIT_DELIVERY_ADDR = 15;

    protected static int EDIT_CART = 16;

    protected static int GOT_ADDR_ID = 17;

    protected static int NEW_ADDR = 18;

    protected static int REGISTER_KO = 19;

    /*
     * Control
     */
    private int currentState = START_STATE;

    private int currentAction;

    /*
     * Windows
     */
    private LoginBody loginBody;

    private RegisterBody registerBody;

    private OrderBody orderBody;

    private EditAddrBody editAddrBody;

    private ChooseAddrBody chooseAddrBody;

    /*
     * Labels
     */
    private String one_page_checkout_register_error1 = "one.page.checkout.register.error1";

    private String one_page_checkout_register_error2 = "one.page.checkout.register.error2";

    /**
     * This method constructs the application user interface by instantiating controls and hooking
     * up event listeners.
     */
    public void onModuleLoad()
    {
        if (RootPanel.get("nowloading") != null)
        {
            RootPanel.get("nowloading").setVisible(false);
        }

        setKK(this);

        // Get the parameters from the JSP
        boolean isOnePageCheckout = getParameters("kkLabelForm0");

        // Determine whether we are in hosted mode or not
        isHostedMode = hostedMode();

        // Get rid of scrollbars, and clear out the window's built-in margin,
        // because we want to take advantage of the entire client area.
        // Window.enableScrolling(false);
        Window.setMargin("0px");

        // Add the window resize event, so that we can adjust the UI.
        Window.addResizeHandler(this);

        // Call the window resized handler to get the initial sizes setup.
        onWindowResized(Window.getClientWidth(), Window.getClientHeight());

        // Set redirect URL
        setRedirectUrl();

        // Suggested search widget
        Element parmForm = DOM.getElementById(SearchBody.FORM_ID);
        if (parmForm != null)
        {
            new SearchBody(this).renderSearch();
        }

        // One page checkout
        if (isOnePageCheckout)
        {
            // Get the ball rolling by figuring out whether the customer is logged in
            getMyKKGWTService().isLoggedIn(isLoggedInCallback);
        }
        
    }

    /**
     * Entry point into controller when there are no parameters
     * 
     * @param action
     */
    protected void controller(int action)
    {
        controller(action, 0, null);
    }

    /**
     * Controller decides what to do next
     * 
     * @param state
     * @param action
     */
    protected void controller(int action, int intParm, String stringParm)
    {
        // debug("Controller action = "+action+ " State = "+currentState);

        currentAction = action;

        if (currentState == START_STATE)
        {
            if (action == LOGGED_IN)
            {
                currentState = CHECKOUT_STATE;
                getOrderBody().init(/* createOrder */true);
            } else if (action == NOT_LOGGED_IN)
            {
                if (allowNoRegister)
                {
                    currentState = REGISTER_STATE;
                    getRegisterBody().renderRegister(allowNoRegister);
                } else
                {
                    currentState = EMAIL_STATE;
                    getLoginBody().renderGetEmail();
                }
            }
        } else if (currentState == EMAIL_STATE)
        {
            if (action == BACK)
            {
                redirect("ShowCartItems.do");
            } else if (action == CONTINUE)
            {
                getLoginBody().validateEmail();
            } else if (action == EMAIL_VALID)
            {
                getKK().getMyKKGWTService().doesCustomerExistForEmail(getLoginBody().getUserName(),
                        doesCustomerExistForEmailCallback);
            } else if (action == EMAIL_NOT_VALID)
            {
                getLoginBody().renderGetEmail();
                getLoginBody().setErrorMsg(getLoginBody().getLogin_body_invalid_email());
            } else if (action == CUST_FOUND)
            {
                currentState = PASSWORD_STATE;
                getLoginBody().renderGetPassword();
            } else if (action == CUST_NOT_FOUND)
            {
                currentState = REGISTER_STATE;
                getRegisterBody().renderRegister(allowNoRegister);
            }
        } else if (currentState == PASSWORD_STATE)
        {
            if (action == BACK)
            {
                currentState = EMAIL_STATE;
                getLoginBody().renderGetEmail();
            } else if (action == CONTINUE)
            {
                // Login
                getKK().getMyKKGWTService().login(getLoginBody().getUserName(),
                        getLoginBody().getPassword(), loginCallback);

            } else if (action == FORGOT_PASSWORD)
            {
                currentState = FORGOT_PASSWORD_STATE;
                getLoginBody().renderForgotPassword();

            } else if (action == LOGIN_OK)
            {
                currentState = CHECKOUT_STATE;
                getOrderBody().init(/* createOrder */true);
            } else if (action == LOGIN_KO)
            {
                getLoginBody().setErrorMsg(getLoginBody().getLogin_body_login_error());
            }
        } else if (currentState == FORGOT_PASSWORD_STATE)
        {
            if (action == CONTINUE)
            {
                getKK().getMyKKGWTService().sendNewPassword(getLoginBody().getUserName(),
                        sendNewPasswordCallback);
            } else if (action == BACK)
            {
                currentState = PASSWORD_STATE;
                getLoginBody().renderGetPassword();
            } else if (action == PASSWORD_SENT)
            {
                currentState = PASSWORD_STATE;
                getLoginBody().renderGetPassword();
                getLoginBody().setSuccessMsg(getLoginBody().getForgotten_password_body_sentpw());
            }
        } else if (currentState == REGISTER_STATE)
        {
            if (action == BACK)
            {
                if (allowNoRegister)
                {
                    redirect("ShowCartItems.do");
                } else
                {
                    currentState = EMAIL_STATE;
                    getLoginBody().renderGetEmail();
                }
            } else if (action == EMAIL_VALID)
            {
                // Only get to here if allowNoRegister == true

                GWT_CustomerRegistration custReg = getRegisterBody().getCustReg();
                // Create a random password
                randomPassword = String.valueOf(System.currentTimeMillis());
                custReg.setPassword(randomPassword);

                // Set the locale
                custReg.setLocale(locale);

                // Register the customer
                getKK().getMyKKGWTService()
                        .forceRegisterCustomer(custReg, registerCustomerCallback);
            } else if (action == EMAIL_NOT_VALID)
            {
                getRegisterBody().renderRegister(allowNoRegister);
                getRegisterBody().setErrorMsg(getLoginBody().getLogin_body_invalid_email());

            } else if (action == CONTINUE)
            {
                if (getRegisterBody().validate(null, allowNoRegister))
                {
                    if (allowNoRegister)
                    {
                        getRegisterBody().validateEmail();
                    } else
                    {
                        GWT_CustomerRegistration custReg = getRegisterBody().getCustReg();
                        // Get the user name from the login screen
                        custReg.setEmailAddr(getLoginBody().getUserName());

                        // Set the locale
                        custReg.setLocale(locale);

                        // Register the customer
                        getKK().getMyKKGWTService().registerCustomer(custReg,
                                registerCustomerCallback);
                    }
                }
            } else if (action == REGISTER_OK)
            {
                // Log in the new customer
                GWT_CustomerRegistration custReg = getRegisterBody().getCustReg();
                if (allowNoRegister)
                {
                    // Set the password if it was generated rather than being entered by the
                    // customer and get the username from custReg
                    custReg.setPassword(randomPassword);
                    getKK().getMyKKGWTService().login(custReg.getEmailAddr(),
                            custReg.getPassword(), loginCallback);

                } else
                {
                    // If the user entered his email in the LoginBody screen then we must get it
                    // from there
                    getKK().getMyKKGWTService().login(getLoginBody().getUserName(),
                            custReg.getPassword(), loginCallback);

                }
            } else if (action == REGISTER_KO)
            {
                /*
                 * We should only get to here if allowNoRegister == true. We need to forward the
                 * user to the page where he can enter a password. We should be here because force
                 * registration went wrong since a registered user already exists for the eMail
                 * address.
                 */

                // Set the username from the one that the user just entered when attempting to
                // checkout
                GWT_CustomerRegistration custReg = getRegisterBody().getCustReg();
                getLoginBody().setUserName(custReg.getEmailAddr());

                currentState = PASSWORD_STATE;
                getLoginBody().renderGetPassword();
                getLoginBody().setErrorMsg(
                        one_page_checkout_register_error1 + " " + custReg.getEmailAddr() + " "
                                + one_page_checkout_register_error2);

            } else if (action == LOGIN_OK)
            {
                currentState = CHECKOUT_STATE;
                getOrderBody().init(/* createOrder */true);
            }
        } else if (currentState == CHECKOUT_STATE)
        {
            if (action == EDIT_BILLING_ADDR)
            {
                if (stringParm == null)
                {
                    // Called from checkout window. Get addresses.
                    getKK().getMyKKGWTService().populateCurrentCustomerAddresses(/* force */false,
                            populateCurrentCustomerAddressesCallback);

                } else
                {
                    // Called from callback after having got customer addresses
                    int numAddrs = intParm;
                    if (numAddrs > 1)
                    {
                        // If more than one addr, the user is directed to a window where he can
                        // choose the one he wants
                        currentState = CHOOSE_BILLING_STATE;
                        if (currentCustomer != null)
                        {
                            getChooseAddrBody().render(currentCustomer.getAddresses(), /* shipping */
                            false);
                        }
                    } else
                    {
                        // If only one addr, it is the one already being used so give the user the
                        // opportunity to enter a new one
                        currentState = EDIT_BILLING_STATE;
                        getEditAddrBody().renderAddr(/* shipping */false);
                    }
                }
            } else if (action == EDIT_DELIVERY_ADDR)
            {
                if (stringParm == null)
                {
                    // Called from checkout window. Get addresses.
                    getKK().getMyKKGWTService().populateCurrentCustomerAddresses(/* force */false,
                            populateCurrentCustomerAddressesCallback);

                } else
                {
                    // Called from callback after having got customer addresses
                    int numAddrs = intParm;
                    if (numAddrs > 1)
                    {
                        // If more than one addr, the user is directed to a window where he can
                        // choose the one he wants
                        currentState = CHOOSE_DELIVERY_STATE;
                        if (currentCustomer != null)
                        {
                            getChooseAddrBody().render(currentCustomer.getAddresses(), /* shipping */
                            true);
                        }

                    } else
                    {
                        // If only one addr, it is the one already being used so give the user the
                        // opportunity to enter a new one
                        currentState = EDIT_DELIVERY_STATE;
                        getEditAddrBody().renderAddr(/* shipping */true);
                    }
                }
            } else if (action == EDIT_CART)
            {
                redirect("ShowCartItems.do");
            }
        } else if (currentState == EDIT_BILLING_STATE)
        {
            if (action == BACK)
            {
                currentState = CHECKOUT_STATE;
                getOrderBody().init(/* createOrder */false);
            } else if (action == CONTINUE)
            {
                if (getEditAddrBody().validate(null))
                {
                    GWT_Address addr = getEditAddrBody().getAddr();
                    getKK().getMyKKGWTService().addAddressToCustomer(addr,
                            addAddressToCustomerCallback);
                }
            } else if (action == GOT_ADDR_ID)
            {
                getKK().getMyKKGWTService().setCheckoutOrderBillingAddress(intParm,
                        setCheckoutOrderAddressCallback);
            }
        } else if (currentState == EDIT_DELIVERY_STATE)
        {
            if (action == BACK)
            {
                currentState = CHECKOUT_STATE;
                getOrderBody().init(/* createOrder */false);
            } else if (action == CONTINUE)
            {
                if (getEditAddrBody().validate(null))
                {
                    GWT_Address addr = getEditAddrBody().getAddr();
                    getKK().getMyKKGWTService().addAddressToCustomer(addr,
                            addAddressToCustomerCallback);
                }
            } else if (action == GOT_ADDR_ID)
            {
                getKK().getMyKKGWTService().setCheckoutOrderShippingAddress(intParm,
                        setCheckoutOrderAddressCallback);
            }
        } else if (currentState == CHOOSE_BILLING_STATE)
        {
            if (action == BACK)
            {
                currentState = CHECKOUT_STATE;
                getOrderBody().init(/* createOrder */false);
            } else if (action == CONTINUE)
            {
                GWT_Address addr = getChooseAddrBody().getSelectedAddress();
                if (addr != null)
                {
                    getKK().getMyKKGWTService().setCheckoutOrderBillingAddress(addr.getId(),
                            setCheckoutOrderAddressCallback);
                }
            } else if (action == NEW_ADDR)
            {
                currentState = EDIT_BILLING_STATE;
                getEditAddrBody().renderAddr(/* shipping */false);
            }

        } else if (currentState == CHOOSE_DELIVERY_STATE)
        {
            if (action == BACK)
            {
                currentState = CHECKOUT_STATE;
                getOrderBody().init(/* createOrder */false);
            } else if (action == CONTINUE)
            {
                GWT_Address addr = getChooseAddrBody().getSelectedAddress();
                if (addr != null)
                {
                    getKK().getMyKKGWTService().setCheckoutOrderShippingAddress(addr.getId(),
                            setCheckoutOrderAddressCallback);
                }
            } else if (action == NEW_ADDR)
            {
                currentState = EDIT_DELIVERY_STATE;
                getEditAddrBody().renderAddr(/* shipping */true);
            }
        }
    }

    /*
     * ----- Callbacks
     */

    AsyncCallback<?> populateCurrentCustomerAddressesCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            GWT_Customer cust = (GWT_Customer) result;
            currentCustomer = cust;
            if (cust != null && cust.getAddresses() != null)
            {
                controller(currentAction, cust.getAddresses().length, "");
            }
        }
    };

    AsyncCallback<?> setCheckoutOrderAddressCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            controller(BACK);
        }
    };

    AsyncCallback<?> addAddressToCustomerCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            Integer addrId = (Integer) result;
            controller(GOT_ADDR_ID, addrId.intValue(), null);
        }
    };

    /**
     * We decide what to do depending on whether the customer is logged in
     */
    AsyncCallback<?> isLoggedInCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {

            Boolean isLoggedIn = (Boolean) result;

            if (isLoggedIn.booleanValue())
            {
                controller(LOGGED_IN);
            } else
            {
                controller(NOT_LOGGED_IN);
            }

        }
    };

    AsyncCallback<?> sendNewPasswordCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            controller(PASSWORD_SENT);
        }
    };

    AsyncCallback<?> doesCustomerExistForEmailCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            Boolean exists = (Boolean) result;
            if (exists != null && exists.booleanValue() == true)
            {
                controller(CUST_FOUND);
            } else
            {
                controller(CUST_NOT_FOUND);
            }

        }
    };

    AsyncCallback<?> loginCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            if (result == null)
            {
                controller(LOGIN_KO);
            } else
            {
                controller(LOGIN_OK);
            }

        }
    };

    AsyncCallback<?> registerCustomerCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            controller(REGISTER_OK);
        }

        public void onFailure(Throwable caught)
        {
            if (!allowNoRegister)
            {
                showException(caught, null);
            } else
            {
                /*
                 * If we can't register, it probably means that a registered user already exists so
                 * we need to forward the customer onto the enter password page.
                 */
                controller(REGISTER_KO);
            }
        }
    };

    /*
     * ----- End of Callbacks
     */

    /**
     * Set attributes from hidden parameters in JSP
     */
    protected void setAttr(String name, String value)
    {
        if (name.equals("headingImageWidth"))
        {
            headingImageWidth = new Integer(value).intValue();
        } else if (name.equals("headingImageHeight"))
        {
            headingImageHeight = new Integer(value).intValue();
        } else if (name.equals("dispPriceWithTax"))
        {
            dispPriceWithTax = new Boolean(value).booleanValue();
        } else if (name.equals("dispCoupon"))
        {
            dispCoupon = new Boolean(value).booleanValue();
        } else if (name.equals("dispGiftCert"))
        {
            dispGiftCert = new Boolean(value).booleanValue();
        } else if (name.equals("dispRewardPoints"))
        {
            dispRewardPoints = new Boolean(value).booleanValue();
        } else if (name.equals("language.dir"))
        {
            languageDir = value;
        } else if (name.equals("locale"))
        {
            locale = value;
        } else if (name.equals("exception.short.message"))
        {
            KKExceptionDialog.setException_short_message(value);
        } else if (name.equals("exception.show.details"))
        {
            KKExceptionDialog.setException_show_details(value);
        } else if (name.equals("exception.hide.details"))
        {
            KKExceptionDialog.setException_hide_details(value);
        } else if (name.equals("common.close"))
        {
            KKExceptionDialog.setCommon_close(value);
        } else if (name.equals("common.back"))
        {
            KKBaseWin.setCommon_back(value);
        } else if (name.equals("common.continue"))
        {
            KKBaseWin.setCommon_continue(value);
        } else if (name.equals("images.folder"))
        {
            KKBaseWin.setImages_folder(value + "/");
        } else if (name.equals("common.confirmorder"))
        {
            KKBaseWin.setCommon_confirmorder(value);
        } else if (name.equals("one.page.checkout.register.error1"))
        {
            one_page_checkout_register_error1 = value;
        } else if (name.equals("one.page.checkout.register.error2"))
        {
            one_page_checkout_register_error2 = value;
        } else if (name.equals("allowNoRegister"))
        {
            allowNoRegister = new Boolean(value).booleanValue();
        }
    }

    /**
     * @return the myKKGWTService - creating it if it it's null
     */
    public KKGWTServiceIfAsync getMyKKGWTService()
    {
        if (myKKGWTService != null)
        {
            return myKKGWTService;
        }

        // Mutexes won't work here so we just have to make sure the first call
        // happens in serial

        // (1) Create the client proxy. Note that although you are creating the
        // service interface proper, you cast the result to the async version of
        // the interface. The cast is always safe because the generated proxy
        // implements the async interface automatically.

        myKKGWTService = (KKGWTServiceIfAsync) GWT.create(KKGWTServiceIf.class);

        // (2) Specify the URL at which our service implementation is running.
        // Note that the target URL must reside on the same domain and port from
        // which the host page was served.

        ServiceDefTarget endpoint = (ServiceDefTarget) myKKGWTService;

        // GWT.log("Module base = '" + GWT.getModuleBaseURL() + "'", null);
        // GWT.log("Module name = '" + GWT.getModuleName() + "'", null);
        // GWT.log("isScript? = " + GWT.isScript(), null);
        // GWT.log("isHosted? = " + isHostedMode, null);

        String entryPoint = null;
        if (isHostedMode)
        {
            entryPoint = GWT_SERVICE_ENDPOINT_NAME;
        } else
        {
            entryPoint = GWT.getModuleBaseURL() + GWT_SERVICE_ENDPOINT_NAME;
        }

        endpoint.setServiceEntryPoint(entryPoint);

        return myKKGWTService;
    }

    /**
     * Determine whether we are in hosted mode or not
     * 
     * @return boolean
     */
    private boolean hostedMode()
    {
        return !(GWT.getModuleBaseURL().startsWith("http://") || GWT.getModuleBaseURL().startsWith(
                "https://"));
    }

    /**
     * Url used to redirect to Struts actions.<br>
     * Development mode = http://localhost:8888/com.konakart.Konakart/ <br>
     * When integrated into struts = http://localhost:8780/konakart/
     * 
     */
    private void setRedirectUrl()
    {
        // debug("Base URL = " + GWT.getModuleBaseURL());
        redirectUrl = GWT.getModuleBaseURL();
    }

    /**
     * @return Returns the redirectUrl.
     */
    public String getRedirectUrl()
    {
        return redirectUrl;
    }

    /**
     * @return Returns the headingImageHeight.
     */
    public int getHeadingImageHeight()
    {
        return headingImageHeight;
    }

    /**
     * @return Returns the headingImageWidth.
     */
    public int getHeadingImageWidth()
    {
        return headingImageWidth;
    }

    /**
     * @return Returns the languageDir.
     */
    public String getLanguageDir()
    {
        return languageDir;
    }

    /**
     * @return Returns the dispCoupon.
     */
    public boolean isDispCoupon()
    {
        return dispCoupon;
    }

    /**
     * @return the dispRewardPoints
     */
    public boolean isDispRewardPoints()
    {
        return dispRewardPoints;
    }

    /**
     * @return Returns the dispPriceWithTax.
     */
    public boolean isDispPriceWithTax()
    {
        return dispPriceWithTax;
    }

    /**
     * @return Returns the loginBody.
     */
    public LoginBody getLoginBody()
    {
        if (loginBody == null)
        {
            loginBody = new LoginBody(this);
            return loginBody;
        }
        loginBody.clearErrorMsg();
        loginBody.clearSuccessMsg();
        return loginBody;
    }

    /**
     * @return Returns the registerBody.
     */
    public RegisterBody getRegisterBody()
    {
        if (registerBody == null)
        {
            registerBody = new RegisterBody(this);
            return registerBody;
        }

        registerBody.clearErrorMsg();
        if (loginBody != null)
        {
            loginBody.clearSuccessMsg();
        }
        return registerBody;
    }

    /**
     * @return Returns the orderBody.
     */
    public OrderBody getOrderBody()
    {
        if (orderBody == null)
        {
            orderBody = new OrderBody(this);
        }
        return orderBody;
    }

    /**
     * @return Returns the editAddrBody.
     */
    public EditAddrBody getEditAddrBody()
    {
        if (editAddrBody == null)
        {
            editAddrBody = new EditAddrBody(this);
        }

        return editAddrBody;
    }

    /**
     * @return Returns the chooseAddrBody.
     */
    public ChooseAddrBody getChooseAddrBody()
    {
        if (chooseAddrBody == null)
        {
            chooseAddrBody = new ChooseAddrBody(this);
        }

        return chooseAddrBody;
    }

    public void onResize(ResizeEvent event)
    {
        // when Window is Re-sized...
        onWindowResized(Window.getClientWidth(), Window.getClientHeight());
    }

    /**
     * @param width
     * @param height
     */
    public void onWindowResized(int width, int height)
    {
        // resize window tasks
    }

    /**
     * @return the dispGiftCert
     */
    public boolean isDispGiftCert()
    {
        return dispGiftCert;
    }
}
