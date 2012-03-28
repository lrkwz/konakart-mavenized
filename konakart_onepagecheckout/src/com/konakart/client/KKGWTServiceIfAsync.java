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
import com.konakart.client.app.GWT_Address;
import com.konakart.client.app.GWT_CustomerRegistration;
import com.konakart.client.app.GWT_Order;
import com.konakart.client.app.GWT_SuggestedSearchOptions;

/**
 * KKGWTServiceIfAsync
 */
public interface KKGWTServiceIfAsync
{
    /**
     * @param callback
     */
    public void getCustomer(AsyncCallback<?> callback);

    /**
     * @param callback
     */
    public void createOrder(AsyncCallback<?> callback);

    /**
     * @param callback
     */
    public void getOrder(AsyncCallback<?> callback);

    /**
     * @param order
     * @param callback
     */
    public void getShippingQuotes(GWT_Order order, AsyncCallback<?> callback);

    /**
     * @param order
     * @param callback
     */
    public void getPaymentGateways(GWT_Order order, AsyncCallback<?> callback);

    /**
     * @param order
     * @param callback
     */
    public void getOrderTotals(GWT_Order order, AsyncCallback<?> callback);

    /**
     * @param order
     * @param callback
     */
    public void saveOrder(GWT_Order order, AsyncCallback<?> callback);

    /**
     * @param emailAddr
     * @param callback
     */
    public void doesCustomerExistForEmail(String emailAddr, AsyncCallback<?> callback);

    /**
     * @param callback
     */
    public void isLoggedIn(AsyncCallback<?> callback);

    /**
     * @param emailAddr
     * @param password
     * @param callback
     */
    public void login(String emailAddr, String password, AsyncCallback<?> callback);

    /**
     * @param callback
     */
    public void getAllCountries(AsyncCallback<?> callback);

    /**
     * @param countryId
     * @param callback
     */
    public void getZonesPerCountry(int countryId, AsyncCallback<?> callback);

    /**
     * @param custReg
     * @param callback
     */
    public void registerCustomer(GWT_CustomerRegistration custReg, AsyncCallback<?> callback);
    
    /**
     * @param custReg
     * @param callback
     */
    public void forceRegisterCustomer(GWT_CustomerRegistration custReg, AsyncCallback<?> callback);

    /**
     * @param emailAddr
     * @param callback
     */
    public void isEmailValid(String emailAddr, AsyncCallback<?> callback);

    /**
     * @param emailAddr
     * @param callback
     */
    public void sendNewPassword(String emailAddr, AsyncCallback<?> callback);

    /**
     * @param addr
     * @param callback
     */
    public void addAddressToCustomer(GWT_Address addr, AsyncCallback<?> callback);

    /**
     * @param addrId
     * @param callback
     */
    public void setCheckoutOrderBillingAddress(int addrId, AsyncCallback<?> callback);

    /**
     * @param addrId
     * @param callback
     */
    public void setCheckoutOrderShippingAddress(int addrId, AsyncCallback<?> callback);
    
    /**
     * @param force
     * @param callback
     */
    public void populateCurrentCustomerAddresses(boolean force, AsyncCallback<?> callback);
    
    /**
     * 
     * @param couponCode
     * @param callback
     */
    public void setCouponCode(String couponCode, AsyncCallback<?> callback);
   
    /**
     * 
     * @param giftCertCode
     * @param callback
     */
    public void setGiftCertCode(String giftCertCode, AsyncCallback<?> callback);
    
    /**
     * 
     * @param rewardPoints
     * @param callback
     */
    public void setRewardPoints(int rewardPoints, AsyncCallback<?> callback);
       
    /**
     * @param options
     * @param callback
     */
    public void getSuggestedSearchItems(GWT_SuggestedSearchOptions options, AsyncCallback<?> callback);

}
