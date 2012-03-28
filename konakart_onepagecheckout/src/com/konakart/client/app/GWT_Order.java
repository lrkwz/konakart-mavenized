//
// (c) 2006 DS Data Systems UK Ltd, All rights reserved.
//
// DS Data Systems and KonaKart and their respective logos, are
// trademarks of DS Data Systems UK Ltd. All rights reserved.
//
// The information in this document is free software;you can redistribute
// it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This software is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//

package com.konakart.client.app;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.lang.Double;
import java.util.Date;
/** */
public class GWT_Order implements IsSerializable
{
/** */
public String billingCity;

/** */
public String billingCompany;

/** */
public String billingCountry;

/** */
public String billingName;

/** */
public String billingPostcode;

/** */
public String billingState;

/** */
public String billingStreetAddress;

/** */
public String billingStreetAddress1;

/** */
public String billingSuburb;

/** */
public String ccExpires;

/** */
public String ccNumber;

/** */
public String ccOwner;

/** */
public String ccType;

/** */
public Double currencyValue;

/** */
public String customerCity;

/** */
public String customerCompany;

/** */
public String customerCountry;

/** */
public String customerEmail;

/** */
public String customerName;

/** */
public String customerPostcode;

/** */
public String customerState;

/** */
public String customerStreetAddress;

/** */
public String customerStreetAddress1;

/** */
public String customerSuburb;

/** */
public String customerTelephone;

/** */
public Date dateFinished;

/** */
public Date datePurchased;

/** */
public String deliveryCity;

/** */
public String deliveryCompany;

/** */
public String deliveryCountry;

/** */
public String deliveryName;

/** */
public String deliveryPostcode;

/** */
public String deliveryState;

/** */
public String deliveryStreetAddress;

/** */
public String deliveryStreetAddress1;

/** */
public String deliverySuburb;

/** */
public int id;

/** */
public Date lastModified;

/** */
public String paymentMethod;

/** */
public String shippingMethod;

/** */
public int status;

/** */
public int customerId;

/** */
public int billingAddrFormatId;

/** */
public int customerAddrFormatId;

/** */
public int deliveryAddrFormatId;

/** */
public GWT_OrderProduct[] orderProducts;

/** */
public String billingFormattedAddress;

/** */
public String customerFormattedAddress;

/** */
public String deliveryFormattedAddress;

/** */
public String statusText;

/** */
public Double tax;

/** */
public int numProducts;

/** */
public String billingAddrFormatTemplate;

/** */
public String customerAddrFormatTemplate;

/** */
public String deliveryAddrFormatTemplate;

/** */
public GWT_OrderTotal[] orderTotals;

/** */
public GWT_OrderStatusHistory[] statusTrail;

/** */
public int billingAddrId;

/** */
public int customerAddrId;

/** */
public int deliveryAddrId;

/** */
public GWT_Country deliveryCountryObject;

/** */
public GWT_Zone deliveryZoneObject;

/** */
public Double totalExTax;

/** */
public Double totalIncTax;

/** */
public GWT_ShippingQuote shippingQuote;

/** */
public String currencyCode;

/** */
public GWT_Currency currency;

/** */
public GWT_TaxRate[] taxRateObjectArray;

/** */
public GWT_PaymentDetails paymentDetails;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public String custom4;

/** */
public String custom5;

/** */
public String couponCode;

/** */
public Double subTotalExTax;

/** */
public Double subTotalIncTax;

/** */
public String couponIds;

/** */
public String promotionIds;

/** */
public String paymentModuleCode;

/** */
public String shippingModuleCode;

/** */
public String orderNumber;

/** */
public String lifecycleId;

/** */
public String trackingNumber;

/** */
public int pointsRedeemed;

/** */
public int pointsAwarded;

/** */
public int pointsReservationId;

/** */
public String locale;

/** */
public String giftCertCode;

/** */
public String invoiceFilename;

/** */
public String ccCVV;

/** */
public String customerTelephone1;

/** */
public String deliveryTelephone;

/** */
public String deliveryTelephone1;

/** */
public String deliveryEmail;

/** */
public String billingTelephone;

/** */
public String billingTelephone1;

/** */
public String billingEmail;

/** */
public String shippingServiceCode;

/** */
public String creator;

/** @return billingCity */
public String getBillingCity()
{
   return billingCity;
}

/** @param billingCity */
public void setBillingCity(String billingCity)
{
   this.billingCity = billingCity;
}

/** @return billingCompany */
public String getBillingCompany()
{
   return billingCompany;
}

/** @param billingCompany */
public void setBillingCompany(String billingCompany)
{
   this.billingCompany = billingCompany;
}

/** @return billingCountry */
public String getBillingCountry()
{
   return billingCountry;
}

/** @param billingCountry */
public void setBillingCountry(String billingCountry)
{
   this.billingCountry = billingCountry;
}

/** @return billingName */
public String getBillingName()
{
   return billingName;
}

/** @param billingName */
public void setBillingName(String billingName)
{
   this.billingName = billingName;
}

/** @return billingPostcode */
public String getBillingPostcode()
{
   return billingPostcode;
}

/** @param billingPostcode */
public void setBillingPostcode(String billingPostcode)
{
   this.billingPostcode = billingPostcode;
}

/** @return billingState */
public String getBillingState()
{
   return billingState;
}

/** @param billingState */
public void setBillingState(String billingState)
{
   this.billingState = billingState;
}

/** @return billingStreetAddress */
public String getBillingStreetAddress()
{
   return billingStreetAddress;
}

/** @param billingStreetAddress */
public void setBillingStreetAddress(String billingStreetAddress)
{
   this.billingStreetAddress = billingStreetAddress;
}

/** @return billingStreetAddress1 */
public String getBillingStreetAddress1()
{
   return billingStreetAddress1;
}

/** @param billingStreetAddress1 */
public void setBillingStreetAddress1(String billingStreetAddress1)
{
   this.billingStreetAddress1 = billingStreetAddress1;
}

/** @return billingSuburb */
public String getBillingSuburb()
{
   return billingSuburb;
}

/** @param billingSuburb */
public void setBillingSuburb(String billingSuburb)
{
   this.billingSuburb = billingSuburb;
}

/** @return ccExpires */
public String getCcExpires()
{
   return ccExpires;
}

/** @param ccExpires */
public void setCcExpires(String ccExpires)
{
   this.ccExpires = ccExpires;
}

/** @return ccNumber */
public String getCcNumber()
{
   return ccNumber;
}

/** @param ccNumber */
public void setCcNumber(String ccNumber)
{
   this.ccNumber = ccNumber;
}

/** @return ccOwner */
public String getCcOwner()
{
   return ccOwner;
}

/** @param ccOwner */
public void setCcOwner(String ccOwner)
{
   this.ccOwner = ccOwner;
}

/** @return ccType */
public String getCcType()
{
   return ccType;
}

/** @param ccType */
public void setCcType(String ccType)
{
   this.ccType = ccType;
}

/** @return currencyValue */
public Double getCurrencyValue()
{
   return currencyValue;
}

/** @param currencyValue */
public void setCurrencyValue(Double currencyValue)
{
   this.currencyValue = currencyValue;
}

/** @return customerCity */
public String getCustomerCity()
{
   return customerCity;
}

/** @param customerCity */
public void setCustomerCity(String customerCity)
{
   this.customerCity = customerCity;
}

/** @return customerCompany */
public String getCustomerCompany()
{
   return customerCompany;
}

/** @param customerCompany */
public void setCustomerCompany(String customerCompany)
{
   this.customerCompany = customerCompany;
}

/** @return customerCountry */
public String getCustomerCountry()
{
   return customerCountry;
}

/** @param customerCountry */
public void setCustomerCountry(String customerCountry)
{
   this.customerCountry = customerCountry;
}

/** @return customerEmail */
public String getCustomerEmail()
{
   return customerEmail;
}

/** @param customerEmail */
public void setCustomerEmail(String customerEmail)
{
   this.customerEmail = customerEmail;
}

/** @return customerName */
public String getCustomerName()
{
   return customerName;
}

/** @param customerName */
public void setCustomerName(String customerName)
{
   this.customerName = customerName;
}

/** @return customerPostcode */
public String getCustomerPostcode()
{
   return customerPostcode;
}

/** @param customerPostcode */
public void setCustomerPostcode(String customerPostcode)
{
   this.customerPostcode = customerPostcode;
}

/** @return customerState */
public String getCustomerState()
{
   return customerState;
}

/** @param customerState */
public void setCustomerState(String customerState)
{
   this.customerState = customerState;
}

/** @return customerStreetAddress */
public String getCustomerStreetAddress()
{
   return customerStreetAddress;
}

/** @param customerStreetAddress */
public void setCustomerStreetAddress(String customerStreetAddress)
{
   this.customerStreetAddress = customerStreetAddress;
}

/** @return customerStreetAddress1 */
public String getCustomerStreetAddress1()
{
   return customerStreetAddress1;
}

/** @param customerStreetAddress1 */
public void setCustomerStreetAddress1(String customerStreetAddress1)
{
   this.customerStreetAddress1 = customerStreetAddress1;
}

/** @return customerSuburb */
public String getCustomerSuburb()
{
   return customerSuburb;
}

/** @param customerSuburb */
public void setCustomerSuburb(String customerSuburb)
{
   this.customerSuburb = customerSuburb;
}

/** @return customerTelephone */
public String getCustomerTelephone()
{
   return customerTelephone;
}

/** @param customerTelephone */
public void setCustomerTelephone(String customerTelephone)
{
   this.customerTelephone = customerTelephone;
}

/** @return dateFinished */
public Date getDateFinished()
{
   return dateFinished;
}

/** @param dateFinished */
public void setDateFinished(Date dateFinished)
{
   this.dateFinished = dateFinished;
}

/** @return datePurchased */
public Date getDatePurchased()
{
   return datePurchased;
}

/** @param datePurchased */
public void setDatePurchased(Date datePurchased)
{
   this.datePurchased = datePurchased;
}

/** @return deliveryCity */
public String getDeliveryCity()
{
   return deliveryCity;
}

/** @param deliveryCity */
public void setDeliveryCity(String deliveryCity)
{
   this.deliveryCity = deliveryCity;
}

/** @return deliveryCompany */
public String getDeliveryCompany()
{
   return deliveryCompany;
}

/** @param deliveryCompany */
public void setDeliveryCompany(String deliveryCompany)
{
   this.deliveryCompany = deliveryCompany;
}

/** @return deliveryCountry */
public String getDeliveryCountry()
{
   return deliveryCountry;
}

/** @param deliveryCountry */
public void setDeliveryCountry(String deliveryCountry)
{
   this.deliveryCountry = deliveryCountry;
}

/** @return deliveryName */
public String getDeliveryName()
{
   return deliveryName;
}

/** @param deliveryName */
public void setDeliveryName(String deliveryName)
{
   this.deliveryName = deliveryName;
}

/** @return deliveryPostcode */
public String getDeliveryPostcode()
{
   return deliveryPostcode;
}

/** @param deliveryPostcode */
public void setDeliveryPostcode(String deliveryPostcode)
{
   this.deliveryPostcode = deliveryPostcode;
}

/** @return deliveryState */
public String getDeliveryState()
{
   return deliveryState;
}

/** @param deliveryState */
public void setDeliveryState(String deliveryState)
{
   this.deliveryState = deliveryState;
}

/** @return deliveryStreetAddress */
public String getDeliveryStreetAddress()
{
   return deliveryStreetAddress;
}

/** @param deliveryStreetAddress */
public void setDeliveryStreetAddress(String deliveryStreetAddress)
{
   this.deliveryStreetAddress = deliveryStreetAddress;
}

/** @return deliveryStreetAddress1 */
public String getDeliveryStreetAddress1()
{
   return deliveryStreetAddress1;
}

/** @param deliveryStreetAddress1 */
public void setDeliveryStreetAddress1(String deliveryStreetAddress1)
{
   this.deliveryStreetAddress1 = deliveryStreetAddress1;
}

/** @return deliverySuburb */
public String getDeliverySuburb()
{
   return deliverySuburb;
}

/** @param deliverySuburb */
public void setDeliverySuburb(String deliverySuburb)
{
   this.deliverySuburb = deliverySuburb;
}

/** @return id */
public int getId()
{
   return id;
}

/** @param id */
public void setId(int id)
{
   this.id = id;
}

/** @return lastModified */
public Date getLastModified()
{
   return lastModified;
}

/** @param lastModified */
public void setLastModified(Date lastModified)
{
   this.lastModified = lastModified;
}

/** @return paymentMethod */
public String getPaymentMethod()
{
   return paymentMethod;
}

/** @param paymentMethod */
public void setPaymentMethod(String paymentMethod)
{
   this.paymentMethod = paymentMethod;
}

/** @return shippingMethod */
public String getShippingMethod()
{
   return shippingMethod;
}

/** @param shippingMethod */
public void setShippingMethod(String shippingMethod)
{
   this.shippingMethod = shippingMethod;
}

/** @return status */
public int getStatus()
{
   return status;
}

/** @param status */
public void setStatus(int status)
{
   this.status = status;
}

/** @return customerId */
public int getCustomerId()
{
   return customerId;
}

/** @param customerId */
public void setCustomerId(int customerId)
{
   this.customerId = customerId;
}

/** @return billingAddrFormatId */
public int getBillingAddrFormatId()
{
   return billingAddrFormatId;
}

/** @param billingAddrFormatId */
public void setBillingAddrFormatId(int billingAddrFormatId)
{
   this.billingAddrFormatId = billingAddrFormatId;
}

/** @return customerAddrFormatId */
public int getCustomerAddrFormatId()
{
   return customerAddrFormatId;
}

/** @param customerAddrFormatId */
public void setCustomerAddrFormatId(int customerAddrFormatId)
{
   this.customerAddrFormatId = customerAddrFormatId;
}

/** @return deliveryAddrFormatId */
public int getDeliveryAddrFormatId()
{
   return deliveryAddrFormatId;
}

/** @param deliveryAddrFormatId */
public void setDeliveryAddrFormatId(int deliveryAddrFormatId)
{
   this.deliveryAddrFormatId = deliveryAddrFormatId;
}

/** @return orderProducts */
public GWT_OrderProduct[] getOrderProducts()
{
   return orderProducts;
}

/** @param orderProducts */
public void setOrderProducts(GWT_OrderProduct[] orderProducts)
{
   this.orderProducts = orderProducts;
}

/** @return billingFormattedAddress */
public String getBillingFormattedAddress()
{
   return billingFormattedAddress;
}

/** @param billingFormattedAddress */
public void setBillingFormattedAddress(String billingFormattedAddress)
{
   this.billingFormattedAddress = billingFormattedAddress;
}

/** @return customerFormattedAddress */
public String getCustomerFormattedAddress()
{
   return customerFormattedAddress;
}

/** @param customerFormattedAddress */
public void setCustomerFormattedAddress(String customerFormattedAddress)
{
   this.customerFormattedAddress = customerFormattedAddress;
}

/** @return deliveryFormattedAddress */
public String getDeliveryFormattedAddress()
{
   return deliveryFormattedAddress;
}

/** @param deliveryFormattedAddress */
public void setDeliveryFormattedAddress(String deliveryFormattedAddress)
{
   this.deliveryFormattedAddress = deliveryFormattedAddress;
}

/** @return statusText */
public String getStatusText()
{
   return statusText;
}

/** @param statusText */
public void setStatusText(String statusText)
{
   this.statusText = statusText;
}

/** @return tax */
public Double getTax()
{
   return tax;
}

/** @param tax */
public void setTax(Double tax)
{
   this.tax = tax;
}

/** @return numProducts */
public int getNumProducts()
{
   return numProducts;
}

/** @param numProducts */
public void setNumProducts(int numProducts)
{
   this.numProducts = numProducts;
}

/** @return billingAddrFormatTemplate */
public String getBillingAddrFormatTemplate()
{
   return billingAddrFormatTemplate;
}

/** @param billingAddrFormatTemplate */
public void setBillingAddrFormatTemplate(String billingAddrFormatTemplate)
{
   this.billingAddrFormatTemplate = billingAddrFormatTemplate;
}

/** @return customerAddrFormatTemplate */
public String getCustomerAddrFormatTemplate()
{
   return customerAddrFormatTemplate;
}

/** @param customerAddrFormatTemplate */
public void setCustomerAddrFormatTemplate(String customerAddrFormatTemplate)
{
   this.customerAddrFormatTemplate = customerAddrFormatTemplate;
}

/** @return deliveryAddrFormatTemplate */
public String getDeliveryAddrFormatTemplate()
{
   return deliveryAddrFormatTemplate;
}

/** @param deliveryAddrFormatTemplate */
public void setDeliveryAddrFormatTemplate(String deliveryAddrFormatTemplate)
{
   this.deliveryAddrFormatTemplate = deliveryAddrFormatTemplate;
}

/** @return orderTotals */
public GWT_OrderTotal[] getOrderTotals()
{
   return orderTotals;
}

/** @param orderTotals */
public void setOrderTotals(GWT_OrderTotal[] orderTotals)
{
   this.orderTotals = orderTotals;
}

/** @return statusTrail */
public GWT_OrderStatusHistory[] getStatusTrail()
{
   return statusTrail;
}

/** @param statusTrail */
public void setStatusTrail(GWT_OrderStatusHistory[] statusTrail)
{
   this.statusTrail = statusTrail;
}

/** @return billingAddrId */
public int getBillingAddrId()
{
   return billingAddrId;
}

/** @param billingAddrId */
public void setBillingAddrId(int billingAddrId)
{
   this.billingAddrId = billingAddrId;
}

/** @return customerAddrId */
public int getCustomerAddrId()
{
   return customerAddrId;
}

/** @param customerAddrId */
public void setCustomerAddrId(int customerAddrId)
{
   this.customerAddrId = customerAddrId;
}

/** @return deliveryAddrId */
public int getDeliveryAddrId()
{
   return deliveryAddrId;
}

/** @param deliveryAddrId */
public void setDeliveryAddrId(int deliveryAddrId)
{
   this.deliveryAddrId = deliveryAddrId;
}

/** @return deliveryCountryObject */
public GWT_Country getDeliveryCountryObject()
{
   return deliveryCountryObject;
}

/** @param deliveryCountryObject */
public void setDeliveryCountryObject(GWT_Country deliveryCountryObject)
{
   this.deliveryCountryObject = deliveryCountryObject;
}

/** @return deliveryZoneObject */
public GWT_Zone getDeliveryZoneObject()
{
   return deliveryZoneObject;
}

/** @param deliveryZoneObject */
public void setDeliveryZoneObject(GWT_Zone deliveryZoneObject)
{
   this.deliveryZoneObject = deliveryZoneObject;
}

/** @return totalExTax */
public Double getTotalExTax()
{
   return totalExTax;
}

/** @param totalExTax */
public void setTotalExTax(Double totalExTax)
{
   this.totalExTax = totalExTax;
}

/** @return totalIncTax */
public Double getTotalIncTax()
{
   return totalIncTax;
}

/** @param totalIncTax */
public void setTotalIncTax(Double totalIncTax)
{
   this.totalIncTax = totalIncTax;
}

/** @return shippingQuote */
public GWT_ShippingQuote getShippingQuote()
{
   return shippingQuote;
}

/** @param shippingQuote */
public void setShippingQuote(GWT_ShippingQuote shippingQuote)
{
   this.shippingQuote = shippingQuote;
}

/** @return currencyCode */
public String getCurrencyCode()
{
   return currencyCode;
}

/** @param currencyCode */
public void setCurrencyCode(String currencyCode)
{
   this.currencyCode = currencyCode;
}

/** @return currency */
public GWT_Currency getCurrency()
{
   return currency;
}

/** @param currency */
public void setCurrency(GWT_Currency currency)
{
   this.currency = currency;
}

/** @return taxRateObjectArray */
public GWT_TaxRate[] getTaxRateObjectArray()
{
   return taxRateObjectArray;
}

/** @param taxRateObjectArray */
public void setTaxRateObjectArray(GWT_TaxRate[] taxRateObjectArray)
{
   this.taxRateObjectArray = taxRateObjectArray;
}

/** @return paymentDetails */
public GWT_PaymentDetails getPaymentDetails()
{
   return paymentDetails;
}

/** @param paymentDetails */
public void setPaymentDetails(GWT_PaymentDetails paymentDetails)
{
   this.paymentDetails = paymentDetails;
}

/** @return custom1 */
public String getCustom1()
{
   return custom1;
}

/** @param custom1 */
public void setCustom1(String custom1)
{
   this.custom1 = custom1;
}

/** @return custom2 */
public String getCustom2()
{
   return custom2;
}

/** @param custom2 */
public void setCustom2(String custom2)
{
   this.custom2 = custom2;
}

/** @return custom3 */
public String getCustom3()
{
   return custom3;
}

/** @param custom3 */
public void setCustom3(String custom3)
{
   this.custom3 = custom3;
}

/** @return custom4 */
public String getCustom4()
{
   return custom4;
}

/** @param custom4 */
public void setCustom4(String custom4)
{
   this.custom4 = custom4;
}

/** @return custom5 */
public String getCustom5()
{
   return custom5;
}

/** @param custom5 */
public void setCustom5(String custom5)
{
   this.custom5 = custom5;
}

/** @return couponCode */
public String getCouponCode()
{
   return couponCode;
}

/** @param couponCode */
public void setCouponCode(String couponCode)
{
   this.couponCode = couponCode;
}

/** @return subTotalExTax */
public Double getSubTotalExTax()
{
   return subTotalExTax;
}

/** @param subTotalExTax */
public void setSubTotalExTax(Double subTotalExTax)
{
   this.subTotalExTax = subTotalExTax;
}

/** @return subTotalIncTax */
public Double getSubTotalIncTax()
{
   return subTotalIncTax;
}

/** @param subTotalIncTax */
public void setSubTotalIncTax(Double subTotalIncTax)
{
   this.subTotalIncTax = subTotalIncTax;
}

/** @return couponIds */
public String getCouponIds()
{
   return couponIds;
}

/** @param couponIds */
public void setCouponIds(String couponIds)
{
   this.couponIds = couponIds;
}

/** @return promotionIds */
public String getPromotionIds()
{
   return promotionIds;
}

/** @param promotionIds */
public void setPromotionIds(String promotionIds)
{
   this.promotionIds = promotionIds;
}

/** @return paymentModuleCode */
public String getPaymentModuleCode()
{
   return paymentModuleCode;
}

/** @param paymentModuleCode */
public void setPaymentModuleCode(String paymentModuleCode)
{
   this.paymentModuleCode = paymentModuleCode;
}

/** @return shippingModuleCode */
public String getShippingModuleCode()
{
   return shippingModuleCode;
}

/** @param shippingModuleCode */
public void setShippingModuleCode(String shippingModuleCode)
{
   this.shippingModuleCode = shippingModuleCode;
}

/** @return orderNumber */
public String getOrderNumber()
{
   return orderNumber;
}

/** @param orderNumber */
public void setOrderNumber(String orderNumber)
{
   this.orderNumber = orderNumber;
}

/** @return lifecycleId */
public String getLifecycleId()
{
   return lifecycleId;
}

/** @param lifecycleId */
public void setLifecycleId(String lifecycleId)
{
   this.lifecycleId = lifecycleId;
}

/** @return trackingNumber */
public String getTrackingNumber()
{
   return trackingNumber;
}

/** @param trackingNumber */
public void setTrackingNumber(String trackingNumber)
{
   this.trackingNumber = trackingNumber;
}

/** @return pointsRedeemed */
public int getPointsRedeemed()
{
   return pointsRedeemed;
}

/** @param pointsRedeemed */
public void setPointsRedeemed(int pointsRedeemed)
{
   this.pointsRedeemed = pointsRedeemed;
}

/** @return pointsAwarded */
public int getPointsAwarded()
{
   return pointsAwarded;
}

/** @param pointsAwarded */
public void setPointsAwarded(int pointsAwarded)
{
   this.pointsAwarded = pointsAwarded;
}

/** @return pointsReservationId */
public int getPointsReservationId()
{
   return pointsReservationId;
}

/** @param pointsReservationId */
public void setPointsReservationId(int pointsReservationId)
{
   this.pointsReservationId = pointsReservationId;
}

/** @return locale */
public String getLocale()
{
   return locale;
}

/** @param locale */
public void setLocale(String locale)
{
   this.locale = locale;
}

/** @return giftCertCode */
public String getGiftCertCode()
{
   return giftCertCode;
}

/** @param giftCertCode */
public void setGiftCertCode(String giftCertCode)
{
   this.giftCertCode = giftCertCode;
}

/** @return invoiceFilename */
public String getInvoiceFilename()
{
   return invoiceFilename;
}

/** @param invoiceFilename */
public void setInvoiceFilename(String invoiceFilename)
{
   this.invoiceFilename = invoiceFilename;
}

/** @return ccCVV */
public String getCcCVV()
{
   return ccCVV;
}

/** @param ccCVV */
public void setCcCVV(String ccCVV)
{
   this.ccCVV = ccCVV;
}

/** @return customerTelephone1 */
public String getCustomerTelephone1()
{
   return customerTelephone1;
}

/** @param customerTelephone1 */
public void setCustomerTelephone1(String customerTelephone1)
{
   this.customerTelephone1 = customerTelephone1;
}

/** @return deliveryTelephone */
public String getDeliveryTelephone()
{
   return deliveryTelephone;
}

/** @param deliveryTelephone */
public void setDeliveryTelephone(String deliveryTelephone)
{
   this.deliveryTelephone = deliveryTelephone;
}

/** @return deliveryTelephone1 */
public String getDeliveryTelephone1()
{
   return deliveryTelephone1;
}

/** @param deliveryTelephone1 */
public void setDeliveryTelephone1(String deliveryTelephone1)
{
   this.deliveryTelephone1 = deliveryTelephone1;
}

/** @return deliveryEmail */
public String getDeliveryEmail()
{
   return deliveryEmail;
}

/** @param deliveryEmail */
public void setDeliveryEmail(String deliveryEmail)
{
   this.deliveryEmail = deliveryEmail;
}

/** @return billingTelephone */
public String getBillingTelephone()
{
   return billingTelephone;
}

/** @param billingTelephone */
public void setBillingTelephone(String billingTelephone)
{
   this.billingTelephone = billingTelephone;
}

/** @return billingTelephone1 */
public String getBillingTelephone1()
{
   return billingTelephone1;
}

/** @param billingTelephone1 */
public void setBillingTelephone1(String billingTelephone1)
{
   this.billingTelephone1 = billingTelephone1;
}

/** @return billingEmail */
public String getBillingEmail()
{
   return billingEmail;
}

/** @param billingEmail */
public void setBillingEmail(String billingEmail)
{
   this.billingEmail = billingEmail;
}

/** @return shippingServiceCode */
public String getShippingServiceCode()
{
   return shippingServiceCode;
}

/** @param shippingServiceCode */
public void setShippingServiceCode(String shippingServiceCode)
{
   this.shippingServiceCode = shippingServiceCode;
}

/** @return creator */
public String getCreator()
{
   return creator;
}

/** @param creator */
public void setCreator(String creator)
{
   this.creator = creator;
}

}
