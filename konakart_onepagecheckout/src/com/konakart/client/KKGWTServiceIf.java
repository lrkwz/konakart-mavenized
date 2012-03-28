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

import com.konakart.client.app.GWT_Address;
import com.konakart.client.app.GWT_Country;
import com.konakart.client.app.GWT_Customer;
import com.konakart.client.app.GWT_CustomerRegistration;
import com.konakart.client.app.GWT_Order;
import com.konakart.client.app.GWT_PaymentDetails;
import com.konakart.client.app.GWT_ShippingQuote;
import com.konakart.client.app.GWT_SuggestedSearchItem;
import com.konakart.client.app.GWT_SuggestedSearchOptions;
import com.konakart.client.app.GWT_Zone;
import com.konakart.client.util.KKGWTException;
import com.konakart.client.util.KKGWTInvalidSessionException;

/** */
public interface KKGWTServiceIf extends com.google.gwt.user.client.rpc.RemoteService
{

    /**
     * @return GWT_Customer
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_Customer getCustomer() throws KKGWTException, KKGWTInvalidSessionException;

    /**
     * @return A GWT_Order
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_Order createOrder() throws KKGWTException, KKGWTInvalidSessionException;

    /**
     * @return A GWT_Order
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_Order getOrder() throws KKGWTException, KKGWTInvalidSessionException;

    /**
     * @param order
     * @return Returns a Shipping Quote
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_ShippingQuote[] getShippingQuotes(GWT_Order order) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param order
     * @return Returns a PaymentDetails object
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_PaymentDetails[] getPaymentGateways(GWT_Order order) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param order
     * @return Returns an order
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_Order getOrderTotals(GWT_Order order) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param order
     * @return Returns the order id of the new order
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public int saveOrder(GWT_Order order) throws KKGWTException, KKGWTInvalidSessionException;

    /**
     * @param emailAddr
     * @return Returns true if customer already exists
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public boolean doesCustomerExistForEmail(String emailAddr) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @return Returns true if the customer is currently logged in
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public boolean isLoggedIn() throws KKGWTException, KKGWTInvalidSessionException;

    /**
     * @param emailAddr
     * @param password
     * @return Returns the sessionId
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public String login(String emailAddr, String password) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @return Returns an array of supported countries
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_Country[] getAllCountries() throws KKGWTException, KKGWTInvalidSessionException;

    /**
     * @param countryId
     * @return Returns an array of zones
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_Zone[] getZonesPerCountry(int countryId) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param custReg
     * @return Returns the customer id
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public int registerCustomer(GWT_CustomerRegistration custReg) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param custReg
     * @return Returns the customer id
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public int forceRegisterCustomer(GWT_CustomerRegistration custReg) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param emailAddr
     * @return Returns true if the email address is valid
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public boolean isEmailValid(String emailAddr) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * 
     * @param emailAddr
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public void sendNewPassword(String emailAddr) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param addr
     * @return Returns id of address object
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public int addAddressToCustomer(GWT_Address addr) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param addrId
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public void setCheckoutOrderBillingAddress(int addrId) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param addrId
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public void setCheckoutOrderShippingAddress(int addrId) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * @param force
     * @return Returns a Customer object with populated addresses
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_Customer populateCurrentCustomerAddresses(boolean force) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * Sets the coupon code on the order manager
     * 
     * @param couponCode
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public void setCouponCode(String couponCode) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * Sets the giftCert code on the order manager
     * 
     * @param giftCertCode
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public void setGiftCertCode(String giftCertCode) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * Sets the reward points on the order manager
     * 
     * @param rewardPoints
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public void setRewardPoints(int rewardPoints) throws KKGWTException,
            KKGWTInvalidSessionException;

    /**
     * Used for dynamic suggested searching
     * 
     * @param options
     * @return Returns an array of SuggestedSearchItem objects
     * @throws KKGWTException
     * @throws KKGWTInvalidSessionException
     */
    public GWT_SuggestedSearchItem[] getSuggestedSearchItems(GWT_SuggestedSearchOptions options)
            throws KKGWTException, KKGWTInvalidSessionException;

}
