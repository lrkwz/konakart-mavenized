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

package com.konakart.server;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.konakart.al.KKAppEng;
import com.konakart.al.KKAppException;
import com.konakart.app.EngineConfig;
import com.konakart.app.KKException;
import com.konakart.appif.AddressIf;
import com.konakart.appif.CountryIf;
import com.konakart.appif.CustomerIf;
import com.konakart.appif.CustomerRegistrationIf;
import com.konakart.appif.EngineConfigIf;
import com.konakart.appif.OrderIf;
import com.konakart.appif.OrderProductIf;
import com.konakart.appif.OrderTotalIf;
import com.konakart.appif.PaymentDetailsIf;
import com.konakart.appif.ShippingQuoteIf;
import com.konakart.appif.SuggestedSearchItemIf;
import com.konakart.appif.ZoneIf;
import com.konakart.client.KKGWTServiceIf;
import com.konakart.client.app.GWT_Address;
import com.konakart.client.app.GWT_Country;
import com.konakart.client.app.GWT_Customer;
import com.konakart.client.app.GWT_CustomerRegistration;
import com.konakart.client.app.GWT_Order;
import com.konakart.client.app.GWT_OrderProduct;
import com.konakart.client.app.GWT_OrderTotal;
import com.konakart.client.app.GWT_PaymentDetails;
import com.konakart.client.app.GWT_ShippingQuote;
import com.konakart.client.app.GWT_SuggestedSearchItem;
import com.konakart.client.app.GWT_SuggestedSearchOptions;
import com.konakart.client.app.GWT_Zone;
import com.konakart.client.util.KKGWTException;
import com.konakart.client.util.KKGWTInvalidSessionException;
import com.konakart.util.PropertyFileFinder;

/**
 * The GWT service implementation
 */
public class KKGWTServiceImpl extends RemoteServiceServlet implements KKGWTServiceIf
{
    protected Log log = LogFactory.getLog(KKGWTServiceImpl.class);

    // Contains an instance of the class used to gain access to server side
    // engine for the application. It is only used if debugging.
    private KKAppEng debugAppEng = null;

    /**
     * Used to read the properties from the properties file
     */
    public static Configuration kkConfig = null;

    private static final long serialVersionUID = 1L;

    private static String mutex = "KKGWTServiceImpl";

    private static final String propertiesFileName = "konakart_gwt.properties";

    private static final String konakart_app_propertiesFileName = "konakart_app.properties";

    private static final String konakart_eng_propertiesFileName = "konakart.properties";

    private KKBeanCopier helper = new KKBeanCopier();

    /**
     * This is defined as an init-param in the web.xml definition of the servlet. IN normal
     * operation this will be defined to be false in the web.xml and no engines will be created. In
     * jUnit test mode, or executing from Eclipse, the init-param will not be present and hence the
     * default action will be to create its own engines.
     */
    private static boolean startOwnEngines = true;

    /**
     * Constructor
     */
    public KKGWTServiceImpl()
    {
        if (log.isInfoEnabled())
        {
            log.info("KKGWTServiceImpl() starting...");
        }

        // beware... you cannot access the ServletConfig in this constructor - see init() below
    }

    public void init(ServletConfig config) throws ServletException
    {
        // very important to call super.init() here
        super.init(config);

        if (config != null)
        {
            String startOwnEnginesParam = config.getInitParameter("startOwnEngines");
            if (log.isDebugEnabled())
            {
                log.debug("startOwnEngines parameter = " + startOwnEnginesParam);
            }

            if (startOwnEnginesParam != null && startOwnEnginesParam.equalsIgnoreCase("FALSE"))
            {
                setStartOwnEngines(false);
            }
        } else
        {
            if (log.isInfoEnabled())
            {
                log.info("Servlet config was null");
            }
        }

        if (isStartOwnEngines() == false)
        {
            if (log.isDebugEnabled())
            {
                log.debug("No engines created in KKGWTServiceImpl()");
            }
            return;
        }

        if (log.isInfoEnabled())
        {
            log.info("startOwnEngines undefined so we now create some engines...");
        }

        /*
         * This should only be used when debugging from Eclipse. Otherwise we use the instance of
         * the engine which is attached to the session.
         */
        synchronized (mutex)
        {
            if (kkConfig == null)
            {
                try
                {
                    URL configFileURL;
                    /*
                     * Find the properties file which is guaranteed to return the URL of
                     * the properties file or throw an exception. It can't send out an error message
                     * since Log4j hasn't been initialised yet. In this case the properties file
                     * should be called konakart_gwt.properties
                     */
                    configFileURL = PropertyFileFinder.findPropertiesURL(propertiesFileName);
                    Configuration conf = new PropertiesConfiguration(configFileURL);
                    if (conf.isEmpty())
                    {
                        log.error("KKGWTServiceImpl() " + propertiesFileName + " contains no keys");
                        throw new KKException("The configuration file: " + propertiesFileName
                                + " contains no keys");
                    }

                    // Look for properties that are in the "konakart.app" namespace.
                    Configuration subConf = conf.subset("konakart.gwt");
                    if (subConf == null || subConf.isEmpty())
                    {
                        log.error("The konakart.gwt section in the properties file is missing. "
                                + "You must add at least one property to resolve this problem. "
                                + "e.g. konakart.gwt.engineclass=com.konakart.app.KKEng");
                        return;
                    }
                    kkConfig = subConf;
                } catch (Exception e)
                {
                    log.warn("KonakartGWTServer() an error has occured");
                    // e.printStackTrace();
                    throw new ServletException(getExceptionMessage(e));
                }
            } else
            {
                if (log.isDebugEnabled())
                {
                    log.debug("kkConfig not null");
                }
            }

            // Instantiate the engine
            try
            {
                if (kkConfig == null)
                {
                    throw new KKException("No properties have been found for the application. "
                            + "Please ensure that the properties file " + propertiesFileName
                            + " exists");
                }
                String engineClassName = kkConfig.getString("engineclass");
                System.out.println("KonakartGWTServer() Engine to be used by application is "
                        + engineClassName);

                EngineConfigIf engConf = new EngineConfig();
                engConf.setStoreId("store1");
                engConf.setAppPropertiesFileName(konakart_app_propertiesFileName);
                engConf.setPropertiesFileName(konakart_eng_propertiesFileName);
                engConf.setMode(EngineConfig.MODE_SINGLE_STORE);

                if (log.isInfoEnabled())
                {
                    log.info("Kick off an engine as if by Struts");
                }
                getAppEngByName(engineClassName, engConf);

                debugAppEng = getAppEngByName(engineClassName);

                // while (debugAppEng.getOrderMgr().isMgrReady() == false)
                // {
                // if (log.isInfoEnabled())
                // {
                // log.info("Mgr is not ready");
                // }
                // Thread.sleep(1000);
                // }

                debugAppEng.getOrderMgr().setHostAndPort("localhost:8080");

                // debugAppEng.getCustomerMgr().login("root@localhost", "password");
                if (log.isInfoEnabled())
                {
                    log.info("KonakartGWTServer() Engine created successfully");
                }

            } catch (Exception e)
            {
                // e.printStackTrace();
                throw new ServletException(getExceptionMessage(e));
            }
        }
    }

    /**
     * Create a new KKAppEng engine from a class of the specified name. We look at the constructors
     * in the specified class to find out if there are any constructors declared that will accept an
     * EngineConfig object. If there are, we use that constructor with the specified EngineConfig
     * object. If not, we use the default constructor.
     * 
     * @param kkEngineName
     *            the name of the class that implements KKAppEng
     * @param engConfig
     *            the engine configuration object
     * @return a newly-instantiated KKAppEng
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private KKAppEng getAppEngByName(String kkEngineName, EngineConfigIf engConfig)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException,
            IllegalArgumentException, InvocationTargetException
    {
        System.out.println("getAppEngByName(" + kkEngineName + ")");
        Class<?> engineClass = Class.forName(kkEngineName);
        KKAppEng kkAppEng = null;
        Constructor<?>[] constructors = engineClass.getConstructors();
        Constructor<?> engConstructor = null;
        if (constructors != null && constructors.length > 0)
        {
            for (int i = 0; i < constructors.length; i++)
            {
                Constructor<?> constructor = constructors[i];
                Class<?>[] parmTypes = constructor.getParameterTypes();
                if (parmTypes != null && parmTypes.length == 1)
                {
                    String parmName = parmTypes[0].getName();
                    if (parmName != null && parmName.equals("com.konakart.appif.EngineConfigIf"))
                    {
                        engConstructor = constructor;
                    }
                }
            }
        }

        if (engConstructor != null)
        {
            kkAppEng = (KKAppEng) engConstructor.newInstance(engConfig);
            if (true)
            {
                if (log.isInfoEnabled())
                {
                    log.info("Created " + kkEngineName
                            + " using EngineConfigIf constructor for store '"
                            + engConfig.getStoreId() + "'");
                }
            }
        } else
        {
            kkAppEng = (KKAppEng) engineClass.newInstance();
            if (true)
            {
                if (log.isInfoEnabled())
                {
                    log.info("Created " + kkEngineName + " using default constructor for store '"
                            + engConfig.getStoreId() + "'");
                }
            }
        }

        return kkAppEng;
    }

    /**
     * Create a new KKAppEng engine from a class of the specified name using the default
     * constructor.
     * 
     * @param kkEngineName
     *            the name of the class that implements KKAppEng
     * @return a newly-instantiated KKAppEng
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     */
    private KKAppEng getAppEngByName(String kkEngineName) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException, IllegalArgumentException
    {
        Class<?> engineClass = Class.forName(kkEngineName);
        KKAppEng kkAppEng = (KKAppEng) engineClass.newInstance();
        if (log.isInfoEnabled())
        {
            log.info("Created " + kkEngineName + " using default constructor");
        }

        return kkAppEng;
    }

    /**
     * If it can't find the engine from the session, it assumes that we are in debug mode and
     * returns the debug engine
     * 
     * @return Returns a KKAppEng instance
     * @throws KKGWTInvalidSessionException
     */
    private KKAppEng getAppEng() throws KKGWTInvalidSessionException
    {
        HttpServletRequest req = getThreadLocalRequest();
        if (req == null)
        {
            throw new KKGWTInvalidSessionException();
        }
        HttpSession session = req.getSession();
        if (session == null)
        {
            throw new KKGWTInvalidSessionException();
        }

        KKAppEng app = (KKAppEng) session.getAttribute(KKAppEng.KONAKART_KEY);
        if (app == null)
        {
            if (debugAppEng != null)
            {
                if (log.isInfoEnabled())
                {
                    log.info("Should only see this message in debug mode.");
                }
                return debugAppEng;
            }
            throw new KKGWTInvalidSessionException();
        }
        return app;
    }

    public GWT_Customer getCustomer() throws KKGWTException, KKGWTInvalidSessionException
    {
        KKAppEng appEng = getAppEng();
        checkSession(appEng);

        CustomerIf serverCust = appEng.getCustomerMgr().getCurrentCustomer();

        GWT_Customer clientCust = helper.getGWT_Customer(serverCust);

        return clientCust;

    }

    public GWT_Order createOrder() throws KKGWTException, KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            checkSession(appEng);

            OrderIf serverOrder = appEng.getOrderMgr().createCheckoutOrder();

            GWT_Order clientOrder = helper.getGWT_Order(serverOrder);

            // Format the prices
            formatOrder(serverOrder, clientOrder);

            return clientOrder;
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        } catch (KKAppException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public GWT_Order getOrder() throws KKGWTException, KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            checkSession(appEng);

            OrderIf serverOrder = appEng.getOrderMgr().getCheckoutOrder();

            GWT_Order clientOrder = helper.getGWT_Order(serverOrder);

            // Format the prices
            formatOrder(serverOrder, clientOrder);

            return clientOrder;
        } catch (Exception e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public GWT_ShippingQuote[] getShippingQuotes(GWT_Order order) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            checkSession(appEng);

            ShippingQuoteIf[] serverShippingQuotes = appEng.getEng().getShippingQuotes(
                    helper.getOrderIf(order), appEng.getLangId());

            GWT_ShippingQuote[] clientShippingQuotes = null;
            if (serverShippingQuotes != null)
            {
                clientShippingQuotes = new GWT_ShippingQuote[serverShippingQuotes.length];
                for (int i = 0; i < serverShippingQuotes.length; i++)
                {
                    ShippingQuoteIf serverSQ = serverShippingQuotes[i];
                    clientShippingQuotes[i] = helper.getGWT_ShippingQuote(serverSQ);
                }
            }

            return clientShippingQuotes;

        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public GWT_PaymentDetails[] getPaymentGateways(GWT_Order order) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            checkSession(appEng);

            PaymentDetailsIf[] serverPaymentGateways = appEng.getEng().getPaymentGateways(
                    helper.getOrderIf(order), appEng.getLangId());

            GWT_PaymentDetails[] clientPaymentGateways = null;
            if (serverPaymentGateways != null)
            {
                clientPaymentGateways = new GWT_PaymentDetails[serverPaymentGateways.length];
                for (int i = 0; i < serverPaymentGateways.length; i++)
                {
                    PaymentDetailsIf serverPD = serverPaymentGateways[i];
                    clientPaymentGateways[i] = helper.getGWT_PaymentDetails(serverPD);
                }
            }

            return clientPaymentGateways;

        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public GWT_Order getOrderTotals(GWT_Order clientOrder) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            checkSession(appEng);

            OrderIf serverOrder = appEng.getEng().getOrderTotals(helper.getOrderIf(clientOrder),
                    appEng.getLangId());

            GWT_Order clientRetOrder = helper.getGWT_Order(serverOrder);

            // Format the prices
            formatOrder(serverOrder, clientRetOrder);

            return clientRetOrder;

        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public int saveOrder(GWT_Order clientOrder) throws KKGWTException, KKGWTInvalidSessionException
    {
        KKAppEng appEng = getAppEng();
        checkSession(appEng);

        OrderIf serverOrder = helper.getOrderIf(clientOrder);
        appEng.getOrderMgr().setCheckoutOrder(serverOrder);

        return 0;
    }

    public boolean doesCustomerExistForEmail(String emailAddr) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();

            boolean ret = appEng.getEng().doesCustomerExistForEmail(emailAddr);

            return ret;

        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public boolean isLoggedIn() throws KKGWTException, KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();

            // To avoid null exceptions under unexpected circumstances...
            if (!isEnginePresent(appEng))
            {
                return false;
            }

            appEng.getEng().checkSession(appEng.getSessionId());
        } catch (KKException e)
        {
            return false;
        }
        return true;
    }

    private boolean isEnginePresent(KKAppEng appEng)
    {
        // Check that the appEng and the appEng.getEng() are not null

        if (appEng == null || appEng.getEng() == null)
        {
            if (log.isInfoEnabled())
            {
                if (appEng == null)
                {
                    log.info("Unexpected: appEng is null");
                } else if (appEng.getEng() == null)
                {
                    log.info("Unexpected: appEng.getEng() is null");
                }
            }
            return false;
        }

        return true;
    }

    public String login(String emailAddr, String password) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            String sessionId = appEng.getCustomerMgr().login(emailAddr, password);
            return sessionId;
        } catch (KKAppException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public GWT_Country[] getAllCountries() throws KKGWTException, KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            CountryIf[] serverCountries = appEng.getEng().getAllCountries();

            if (serverCountries == null)
            {
                return null;
            }

            GWT_Country[] clientCountries = new GWT_Country[serverCountries.length];
            for (int i = 0; i < serverCountries.length; i++)
            {
                CountryIf serverCountry = serverCountries[i];
                GWT_Country clientCountry = helper.getGWT_Country(serverCountry);
                clientCountries[i] = clientCountry;
            }

            return clientCountries;
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public GWT_Zone[] getZonesPerCountry(int countryId) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            ZoneIf[] serverZones = appEng.getEng().getZonesPerCountry(countryId);

            if (serverZones == null)
            {
                return null;
            }

            GWT_Zone[] clientZones = new GWT_Zone[serverZones.length];
            for (int i = 0; i < serverZones.length; i++)
            {
                ZoneIf serverZone = serverZones[i];
                GWT_Zone clientZone = helper.getGWT_Zone(serverZone);
                clientZones[i] = clientZone;
            }

            return clientZones;
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public int registerCustomer(GWT_CustomerRegistration clientCustReg) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();

            CustomerRegistrationIf serverCustReg = helper.getCustomerRegistrationIf(clientCustReg);

            int custId = appEng.getEng().registerCustomer(serverCustReg);

            return custId;
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public int forceRegisterCustomer(GWT_CustomerRegistration clientCustReg) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();

            CustomerRegistrationIf serverCustReg = helper.getCustomerRegistrationIf(clientCustReg);

            int custId = appEng.getEng().forceRegisterCustomer(serverCustReg);

            return custId;
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    /**
     * Returns a string containing the stack trace of the exception and its cause
     * 
     * @param e
     * @return Returns a string containing the stack trace
     */
    private String getExceptionMessage(Throwable e)
    {
        StringBuffer sb = new StringBuffer();

        if (e.getMessage() == null)
        {
            sb.append("null");
        } else
        {
            sb.append(e.getMessage());
        }
        sb.append("<br>");

        // Get the stack trace of the exception
        sb.append("Exception Stack Trace = ");
        StackTraceElement[] ste = e.getStackTrace();
        for (int i = 0; i < ste.length; i++)
        {
            sb.append("<br>   at ");
            sb.append(ste[i].toString());
        }

        // Get the stack trace of the exception cause
        Throwable eCause = e.getCause();
        if (eCause != null)
        {
            sb.append("<br><br>Exception Cause = ");
            StackTraceElement[] ste1 = eCause.getStackTrace();
            for (int i = 0; i < ste1.length; i++)
            {
                sb.append("<br>   at ");
                sb.append(ste1[i].toString());
            }
        }

        return sb.toString();
    }

    /**
     * Format the price in the OrderProducts
     * 
     * @param order
     * @throws KKGWTException
     * @throws KKAppException
     * @throws KKException
     */
    private void formatOrder(OrderIf serverOrder, GWT_Order clientOrder) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            if (serverOrder != null && serverOrder.getOrderProducts() != null)
            {
                for (int i = 0; i < serverOrder.getOrderProducts().length; i++)
                {
                    OrderProductIf serverOP = serverOrder.getOrderProducts()[i];
                    GWT_OrderProduct clientOP = clientOrder.getOrderProducts()[i];
                    clientOP.setFormattedTaxRate(serverOP.getTaxRate().setScale(2,
                            BigDecimal.ROUND_HALF_UP).toPlainString());
                    clientOP.setFormattedFinalPriceIncTax(getAppEng().formatPrice(
                            serverOP.getFinalPriceIncTax()));
                    clientOP.setFormattedFinalPriceExTax(getAppEng().formatPrice(
                            serverOP.getFinalPriceExTax()));
                }
            }
            if (serverOrder != null && serverOrder.getOrderTotals() != null)
            {
                for (int i = 0; i < serverOrder.getOrderTotals().length; i++)
                {
                    OrderTotalIf serverOT = serverOrder.getOrderTotals()[i];
                    GWT_OrderTotal clientOT = clientOrder.getOrderTotals()[i];
                    clientOT.setFormattedValue(getAppEng().formatPrice(serverOT.getValue()));
                }
            }

        } catch (KKAppException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    /**
     * If the session is invalid, we throw a KKGWTInvalidSessionException
     * 
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    private void checkSession(KKAppEng appEng) throws KKGWTException, KKGWTInvalidSessionException
    {
        if (appEng == null || appEng.getEng() == null)
        {
            throw new KKGWTInvalidSessionException();
        }

        try
        {
            appEng.getEng().checkSession(appEng.getSessionId());
        } catch (KKException e)
        {
            throw new KKGWTInvalidSessionException(e.getMessage());
        }
    }

    public boolean isEmailValid(String emailAddr) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            boolean ret = appEng.getEng().isEmailValid(emailAddr);
            return ret;
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public void sendNewPassword(String emailAddr) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            appEng.getCustomerMgr().sendNewPassword(emailAddr);
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public int addAddressToCustomer(GWT_Address clientAddr) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            checkSession(appEng);
            AddressIf serverAddr = helper.getAddressIf(clientAddr);
            return appEng.getCustomerMgr().addAddressToCustomer(serverAddr);
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        } catch (KKAppException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public void setCheckoutOrderBillingAddress(int addrId) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            checkSession(appEng);
            appEng.getOrderMgr().setCheckoutOrderBillingAddress(addrId);
        } catch (Exception e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public void setCheckoutOrderShippingAddress(int addrId) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            checkSession(appEng);
            appEng.getOrderMgr().setCheckoutOrderShippingAddress(addrId);
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public GWT_Customer populateCurrentCustomerAddresses(boolean force) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            checkSession(appEng);
            appEng.getCustomerMgr().populateCurrentCustomerAddresses(force);
            GWT_Customer clientCust = helper.getGWT_Customer(appEng.getCustomerMgr()
                    .getCurrentCustomer());
            return clientCust;
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        } catch (KKAppException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }

    public void setCouponCode(String couponCode) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        KKAppEng appEng = getAppEng();
        checkSession(appEng);
        appEng.getOrderMgr().setCouponCode(couponCode);
    }

    public void setGiftCertCode(String giftCertCode) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        KKAppEng appEng = getAppEng();
        checkSession(appEng);
        appEng.getOrderMgr().setGiftCertCode(giftCertCode);
    }

    public void setRewardPoints(int rewardPoints) throws KKGWTException,
            KKGWTInvalidSessionException
    {
        KKAppEng appEng = getAppEng();
        checkSession(appEng);
        appEng.getOrderMgr().setRewardPoints(rewardPoints);
    }

    /**
     * @return the startOwnEngines
     */
    protected static boolean isStartOwnEngines()
    {
        return startOwnEngines;
    }

    /**
     * @param startOwnEngines
     *            the startOwnEngines to set
     */
    protected static void setStartOwnEngines(boolean startOwnEngines)
    {
        KKGWTServiceImpl.startOwnEngines = startOwnEngines;
    }

    public GWT_SuggestedSearchItem[] getSuggestedSearchItems(GWT_SuggestedSearchOptions options)
            throws KKGWTException, KKGWTInvalidSessionException
    {
        try
        {
            KKAppEng appEng = getAppEng();
            SuggestedSearchItemIf[] serverSearchItems = appEng.getEng().getSuggestedSearchItems(
                    null, helper.getSuggestedSearchOptionsIf(options));

            GWT_SuggestedSearchItem[] clientSearchItems = new GWT_SuggestedSearchItem[serverSearchItems.length];
            for (int i = 0; i < serverSearchItems.length; i++)
            {
                SuggestedSearchItemIf serverSearchItem = serverSearchItems[i];
                GWT_SuggestedSearchItem clientSearchItem = helper
                        .getGWT_SuggestedSearchItem(serverSearchItem);
                clientSearchItems[i] = clientSearchItem;
            }

            return clientSearchItems;
        } catch (KKException e)
        {
            throw new KKGWTException(getExceptionMessage(e));
        }
    }
}
