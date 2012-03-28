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

package com.konakart.server;


import com.konakart.client.util.KKGWTException;
import com.konakart.appif.AddressIf;
import com.konakart.app.Address;
import com.konakart.client.app.GWT_Address;
import com.konakart.appif.AddToBasketOptionsIf;
import com.konakart.app.AddToBasketOptions;
import com.konakart.client.app.GWT_AddToBasketOptions;
import com.konakart.appif.AddToWishListOptionsIf;
import com.konakart.app.AddToWishListOptions;
import com.konakart.client.app.GWT_AddToWishListOptions;
import com.konakart.appif.BasketIf;
import com.konakart.app.Basket;
import com.konakart.client.app.GWT_Basket;
import com.konakart.appif.BookableProductIf;
import com.konakart.app.BookableProduct;
import com.konakart.client.app.GWT_BookableProduct;
import com.konakart.appif.BookableProductOptionsIf;
import com.konakart.app.BookableProductOptions;
import com.konakart.client.app.GWT_BookableProductOptions;
import com.konakart.appif.BookingIf;
import com.konakart.app.Booking;
import com.konakart.client.app.GWT_Booking;
import com.konakart.appif.BookingsIf;
import com.konakart.app.Bookings;
import com.konakart.client.app.GWT_Bookings;
import com.konakart.appif.CategoryIf;
import com.konakart.app.Category;
import com.konakart.client.app.GWT_Category;
import com.konakart.appif.CountryIf;
import com.konakart.app.Country;
import com.konakart.client.app.GWT_Country;
import com.konakart.appif.CouponIf;
import com.konakart.app.Coupon;
import com.konakart.client.app.GWT_Coupon;
import com.konakart.appif.CreateOrderOptionsIf;
import com.konakart.app.CreateOrderOptions;
import com.konakart.client.app.GWT_CreateOrderOptions;
import com.konakart.appif.CreditCardIf;
import com.konakart.app.CreditCard;
import com.konakart.client.app.GWT_CreditCard;
import com.konakart.appif.CurrencyIf;
import com.konakart.app.Currency;
import com.konakart.client.app.GWT_Currency;
import com.konakart.appif.CustomerEventIf;
import com.konakart.app.CustomerEvent;
import com.konakart.client.app.GWT_CustomerEvent;
import com.konakart.appif.CustomerGroupIf;
import com.konakart.app.CustomerGroup;
import com.konakart.client.app.GWT_CustomerGroup;
import com.konakart.appif.CustomerIf;
import com.konakart.app.Customer;
import com.konakart.client.app.GWT_Customer;
import com.konakart.appif.CustomerRegistrationIf;
import com.konakart.app.CustomerRegistration;
import com.konakart.client.app.GWT_CustomerRegistration;
import com.konakart.appif.CustomerSearchIf;
import com.konakart.app.CustomerSearch;
import com.konakart.client.app.GWT_CustomerSearch;
import com.konakart.appif.CustomerTagIf;
import com.konakart.app.CustomerTag;
import com.konakart.client.app.GWT_CustomerTag;
import com.konakart.appif.DataDescriptorIf;
import com.konakart.app.DataDescriptor;
import com.konakart.client.app.GWT_DataDescriptor;
import com.konakart.appif.DigitalDownloadIf;
import com.konakart.app.DigitalDownload;
import com.konakart.client.app.GWT_DigitalDownload;
import com.konakart.appif.EmailIf;
import com.konakart.app.Email;
import com.konakart.client.app.GWT_Email;
import com.konakart.appif.EmailOptionsIf;
import com.konakart.app.EmailOptions;
import com.konakart.client.app.GWT_EmailOptions;
import com.konakart.appif.EngineConfigIf;
import com.konakart.app.EngineConfig;
import com.konakart.client.app.GWT_EngineConfig;
import com.konakart.appif.ExportOrderOptionsIf;
import com.konakart.app.ExportOrderOptions;
import com.konakart.client.app.GWT_ExportOrderOptions;
import com.konakart.appif.ExportOrderResponseIf;
import com.konakart.app.ExportOrderResponse;
import com.konakart.client.app.GWT_ExportOrderResponse;
import com.konakart.appif.ExpressionIf;
import com.konakart.app.Expression;
import com.konakart.client.app.GWT_Expression;
import com.konakart.appif.ExpressionVariableIf;
import com.konakart.app.ExpressionVariable;
import com.konakart.client.app.GWT_ExpressionVariable;
import com.konakart.appif.FetchProductOptionsIf;
import com.konakart.app.FetchProductOptions;
import com.konakart.client.app.GWT_FetchProductOptions;
import com.konakart.appif.GeoZoneIf;
import com.konakart.app.GeoZone;
import com.konakart.client.app.GWT_GeoZone;
import com.konakart.appif.IpnHistoryIf;
import com.konakart.app.IpnHistory;
import com.konakart.client.app.GWT_IpnHistory;
import com.konakart.appif.KKConfigurationIf;
import com.konakart.app.KKConfiguration;
import com.konakart.client.app.GWT_KKConfiguration;
import com.konakart.appif.KKCookieIf;
import com.konakart.app.KKCookie;
import com.konakart.client.app.GWT_KKCookie;
import com.konakart.appif.KKFacetIf;
import com.konakart.app.KKFacet;
import com.konakart.client.app.GWT_KKFacet;
import com.konakart.appif.KkMsgIf;
import com.konakart.app.KkMsg;
import com.konakart.client.app.GWT_KkMsg;
import com.konakart.appif.LanguageIf;
import com.konakart.app.Language;
import com.konakart.client.app.GWT_Language;
import com.konakart.appif.ManufacturerIf;
import com.konakart.app.Manufacturer;
import com.konakart.client.app.GWT_Manufacturer;
import com.konakart.appif.MiscItemIf;
import com.konakart.app.MiscItem;
import com.konakart.client.app.GWT_MiscItem;
import com.konakart.appif.MqOptionsIf;
import com.konakart.app.MqOptions;
import com.konakart.client.app.GWT_MqOptions;
import com.konakart.appif.MqResponseIf;
import com.konakart.app.MqResponse;
import com.konakart.client.app.GWT_MqResponse;
import com.konakart.appif.NameNumberIf;
import com.konakart.app.NameNumber;
import com.konakart.client.app.GWT_NameNumber;
import com.konakart.appif.NameValueIf;
import com.konakart.app.NameValue;
import com.konakart.client.app.GWT_NameValue;
import com.konakart.appif.OptionIf;
import com.konakart.app.Option;
import com.konakart.client.app.GWT_Option;
import com.konakart.appif.OrderIf;
import com.konakart.app.Order;
import com.konakart.client.app.GWT_Order;
import com.konakart.appif.OrderProductIf;
import com.konakart.app.OrderProduct;
import com.konakart.client.app.GWT_OrderProduct;
import com.konakart.appif.OrderSearchIf;
import com.konakart.app.OrderSearch;
import com.konakart.client.app.GWT_OrderSearch;
import com.konakart.appif.OrdersIf;
import com.konakart.app.Orders;
import com.konakart.client.app.GWT_Orders;
import com.konakart.appif.OrderStatusHistoryIf;
import com.konakart.app.OrderStatusHistory;
import com.konakart.client.app.GWT_OrderStatusHistory;
import com.konakart.appif.OrderStatusIf;
import com.konakart.app.OrderStatus;
import com.konakart.client.app.GWT_OrderStatus;
import com.konakart.appif.OrderTotalIf;
import com.konakart.app.OrderTotal;
import com.konakart.client.app.GWT_OrderTotal;
import com.konakart.appif.PaymentDetailsIf;
import com.konakart.app.PaymentDetails;
import com.konakart.client.app.GWT_PaymentDetails;
import com.konakart.appif.PaymentScheduleIf;
import com.konakart.app.PaymentSchedule;
import com.konakart.client.app.GWT_PaymentSchedule;
import com.konakart.appif.PdfOptionsIf;
import com.konakart.app.PdfOptions;
import com.konakart.client.app.GWT_PdfOptions;
import com.konakart.appif.PdfResultIf;
import com.konakart.app.PdfResult;
import com.konakart.client.app.GWT_PdfResult;
import com.konakart.appif.ProdCustAttrIf;
import com.konakart.app.ProdCustAttr;
import com.konakart.client.app.GWT_ProdCustAttr;
import com.konakart.appif.ProductIf;
import com.konakart.app.Product;
import com.konakart.client.app.GWT_Product;
import com.konakart.appif.ProductQuantityIf;
import com.konakart.app.ProductQuantity;
import com.konakart.client.app.GWT_ProductQuantity;
import com.konakart.appif.ProductSearchIf;
import com.konakart.app.ProductSearch;
import com.konakart.client.app.GWT_ProductSearch;
import com.konakart.appif.ProductsIf;
import com.konakart.app.Products;
import com.konakart.client.app.GWT_Products;
import com.konakart.appif.PromotionIf;
import com.konakart.app.Promotion;
import com.konakart.client.app.GWT_Promotion;
import com.konakart.appif.PromotionOptionsIf;
import com.konakart.app.PromotionOptions;
import com.konakart.client.app.GWT_PromotionOptions;
import com.konakart.appif.PromotionProductIf;
import com.konakart.app.PromotionProduct;
import com.konakart.client.app.GWT_PromotionProduct;
import com.konakart.appif.PromotionResultIf;
import com.konakart.app.PromotionResult;
import com.konakart.client.app.GWT_PromotionResult;
import com.konakart.appif.ReviewIf;
import com.konakart.app.Review;
import com.konakart.client.app.GWT_Review;
import com.konakart.appif.ReviewsIf;
import com.konakart.app.Reviews;
import com.konakart.client.app.GWT_Reviews;
import com.konakart.appif.RewardPointIf;
import com.konakart.app.RewardPoint;
import com.konakart.client.app.GWT_RewardPoint;
import com.konakart.appif.RewardPointsIf;
import com.konakart.app.RewardPoints;
import com.konakart.client.app.GWT_RewardPoints;
import com.konakart.appif.ShippingQuoteIf;
import com.konakart.app.ShippingQuote;
import com.konakart.client.app.GWT_ShippingQuote;
import com.konakart.appif.SnippetOptionsIf;
import com.konakart.app.SnippetOptions;
import com.konakart.client.app.GWT_SnippetOptions;
import com.konakart.appif.SSOTokenIf;
import com.konakart.app.SSOToken;
import com.konakart.client.app.GWT_SSOToken;
import com.konakart.appif.StoreIf;
import com.konakart.app.Store;
import com.konakart.client.app.GWT_Store;
import com.konakart.appif.SubscriptionIf;
import com.konakart.app.Subscription;
import com.konakart.client.app.GWT_Subscription;
import com.konakart.appif.SuggestedSearchItemIf;
import com.konakart.app.SuggestedSearchItem;
import com.konakart.client.app.GWT_SuggestedSearchItem;
import com.konakart.appif.SuggestedSearchOptionsIf;
import com.konakart.app.SuggestedSearchOptions;
import com.konakart.client.app.GWT_SuggestedSearchOptions;
import com.konakart.appif.TagGroupIf;
import com.konakart.app.TagGroup;
import com.konakart.client.app.GWT_TagGroup;
import com.konakart.appif.TagIf;
import com.konakart.app.Tag;
import com.konakart.client.app.GWT_Tag;
import com.konakart.appif.TaxClassIf;
import com.konakart.app.TaxClass;
import com.konakart.client.app.GWT_TaxClass;
import com.konakart.appif.TaxRateIf;
import com.konakart.app.TaxRate;
import com.konakart.client.app.GWT_TaxRate;
import com.konakart.appif.TierPriceIf;
import com.konakart.app.TierPrice;
import com.konakart.client.app.GWT_TierPrice;
import com.konakart.appif.WishListIf;
import com.konakart.app.WishList;
import com.konakart.client.app.GWT_WishList;
import com.konakart.appif.WishListItemIf;
import com.konakart.app.WishListItem;
import com.konakart.client.app.GWT_WishListItem;
import com.konakart.appif.WishListItemsIf;
import com.konakart.app.WishListItems;
import com.konakart.client.app.GWT_WishListItems;
import com.konakart.appif.WishListsIf;
import com.konakart.app.WishLists;
import com.konakart.client.app.GWT_WishLists;
import com.konakart.appif.ZoneIf;
import com.konakart.app.Zone;
import com.konakart.client.app.GWT_Zone;
import com.konakart.appif.ZoneSearchIf;
import com.konakart.app.ZoneSearch;
import com.konakart.client.app.GWT_ZoneSearch;


/** */public class KKBeanCopier extends KKBeanCopierBase
{

protected GWT_Address getGWT_Address(AddressIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Address client = new GWT_Address();
client.setCity(server.getCity());
client.setCompany(server.getCompany());
client.setCountryId(server.getCountryId());
client.setCustomerId(server.getCustomerId());
client.setFirstName(server.getFirstName());
client.setGender(server.getGender());
client.setId(server.getId());
client.setLastName(server.getLastName());
client.setPostcode(server.getPostcode());
client.setState(server.getState());
client.setStreetAddress(server.getStreetAddress());
client.setStreetAddress1(server.getStreetAddress1());
client.setSuburb(server.getSuburb());
client.setZoneId(server.getZoneId());
client.setUseZoneId(server.isUseZoneId());
client.setAddressFormatTemplate(server.getAddressFormatTemplate());
client.setAddressSummaryTemplate(server.getAddressSummaryTemplate());
client.setFormattedAddress(server.getFormattedAddress());
client.setSummaryAddress(server.getSummaryAddress());
client.setCountryName(server.getCountryName());
client.setTelephoneNumber(server.getTelephoneNumber());
client.setTelephoneNumber1(server.getTelephoneNumber1());
client.setEmailAddr(server.getEmailAddr());
client.setIsPrimary(server.getIsPrimary());
client.setAddressFormatId(server.getAddressFormatId());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
return client;
}

protected AddressIf getAddressIf(GWT_Address client) throws KKGWTException
{
if (client == null)
{
    return null;
}

AddressIf server = new Address();
server.setCity(client.getCity());
server.setCompany(client.getCompany());
server.setCountryId(client.getCountryId());
server.setCustomerId(client.getCustomerId());
server.setFirstName(client.getFirstName());
server.setGender(client.getGender());
server.setId(client.getId());
server.setLastName(client.getLastName());
server.setPostcode(client.getPostcode());
server.setState(client.getState());
server.setStreetAddress(client.getStreetAddress());
server.setStreetAddress1(client.getStreetAddress1());
server.setSuburb(client.getSuburb());
server.setZoneId(client.getZoneId());
server.setUseZoneId(client.isUseZoneId());
server.setAddressFormatTemplate(client.getAddressFormatTemplate());
server.setAddressSummaryTemplate(client.getAddressSummaryTemplate());
server.setFormattedAddress(client.getFormattedAddress());
server.setSummaryAddress(client.getSummaryAddress());
server.setCountryName(client.getCountryName());
server.setTelephoneNumber(client.getTelephoneNumber());
server.setTelephoneNumber1(client.getTelephoneNumber1());
server.setEmailAddr(client.getEmailAddr());
server.setIsPrimary(client.isIsPrimary());
server.setAddressFormatId(client.getAddressFormatId());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
return server;
}

protected GWT_AddToBasketOptions getGWT_AddToBasketOptions(AddToBasketOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_AddToBasketOptions client = new GWT_AddToBasketOptions();
client.setAllowMultipleEntriesForSameProduct(server.isAllowMultipleEntriesForSameProduct());
client.setCatalogId(server.getCatalogId());
client.setPriceDate(getDateFromCalendar(server.getPriceDate()));
client.setUseExternalPrice(server.isUseExternalPrice());
client.setUseExternalQuantity(server.isUseExternalQuantity());
return client;
}

protected AddToBasketOptionsIf getAddToBasketOptionsIf(GWT_AddToBasketOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

AddToBasketOptionsIf server = new AddToBasketOptions();
server.setAllowMultipleEntriesForSameProduct(client.isAllowMultipleEntriesForSameProduct());
server.setCatalogId(client.getCatalogId());
server.setPriceDate(getCalendarFromDate(client.getPriceDate()));
server.setUseExternalPrice(client.isUseExternalPrice());
server.setUseExternalQuantity(client.isUseExternalQuantity());
return server;
}

protected GWT_AddToWishListOptions getGWT_AddToWishListOptions(AddToWishListOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_AddToWishListOptions client = new GWT_AddToWishListOptions();
client.setCatalogId(server.getCatalogId());
client.setPriceDate(getDateFromCalendar(server.getPriceDate()));
client.setOnlyShowAvailable(server.isOnlyShowAvailable());
client.setUseExternalPrice(server.isUseExternalPrice());
client.setCustomerId(server.getCustomerId());
return client;
}

protected AddToWishListOptionsIf getAddToWishListOptionsIf(GWT_AddToWishListOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

AddToWishListOptionsIf server = new AddToWishListOptions();
server.setCatalogId(client.getCatalogId());
server.setPriceDate(getCalendarFromDate(client.getPriceDate()));
server.setOnlyShowAvailable(client.isOnlyShowAvailable());
server.setUseExternalPrice(client.isUseExternalPrice());
server.setCustomerId(client.getCustomerId());
return server;
}

protected GWT_Basket getGWT_Basket(BasketIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Basket client = new GWT_Basket();
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setEncodedProduct(server.getEncodedProduct());
client.setId(server.getId());
if (server.getOpts() == null)
{
client.setOpts(null);
} else
{
GWT_Option[] clientArray = new GWT_Option[server.getOpts().length];
for (int i = 0; i < server.getOpts().length; i++)
{
clientArray[i] = getGWT_Option(server.getOpts()[i]);
}
client.setOpts(clientArray);
}
client.setProduct(getGWT_Product(server.getProduct()));
client.setProductId(server.getProductId());
client.setQuantity(server.getQuantity());
client.setFinalPriceExTax(getDoubleFromBigDecimal(server.getFinalPriceExTax()));
client.setFinalPriceIncTax(getDoubleFromBigDecimal(server.getFinalPriceIncTax()));
client.setQuantityInStock(server.getQuantityInStock());
client.setDateAvailable(getDateFromCalendar(server.getDateAvailable()));
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setSku(server.getSku());
client.setWishListId(server.getWishListId());
client.setWishListItemId(server.getWishListItemId());
client.setUseBasketPrice(server.isUseBasketPrice());
return client;
}

protected BasketIf getBasketIf(GWT_Basket client) throws KKGWTException
{
if (client == null)
{
    return null;
}

BasketIf server = new Basket();
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setEncodedProduct(client.getEncodedProduct());
server.setId(client.getId());
if (client.getOpts() == null)
{
server.setOpts(null);
} else
{
OptionIf[] serverArray = new OptionIf[client.getOpts().length];
for (int i = 0; i < client.getOpts().length; i++)
{
serverArray[i] = getOptionIf(client.getOpts()[i]);
}
server.setOpts(serverArray);
}
server.setProduct(getProductIf(client.getProduct()));
server.setProductId(client.getProductId());
server.setQuantity(client.getQuantity());
server.setFinalPriceExTax(getBigDecimalFromDouble(client.getFinalPriceExTax()));
server.setFinalPriceIncTax(getBigDecimalFromDouble(client.getFinalPriceIncTax()));
server.setQuantityInStock(client.getQuantityInStock());
server.setDateAvailable(getCalendarFromDate(client.getDateAvailable()));
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setSku(client.getSku());
server.setWishListId(client.getWishListId());
server.setWishListItemId(client.getWishListItemId());
server.setUseBasketPrice(client.isUseBasketPrice());
return server;
}

protected GWT_BookableProduct getGWT_BookableProduct(BookableProductIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_BookableProduct client = new GWT_BookableProduct();
client.setProductId(server.getProductId());
client.setMaxNumBookings(server.getMaxNumBookings());
client.setBookingsMade(server.getBookingsMade());
client.setStartDate(getDateFromCalendar(server.getStartDate()));
client.setEndDate(getDateFromCalendar(server.getEndDate()));
client.setMonday(server.getMonday());
client.setTuesday(server.getTuesday());
client.setWednesday(server.getWednesday());
client.setThursday(server.getThursday());
client.setFriday(server.getFriday());
client.setSaturday(server.getSaturday());
client.setSunday(server.getSunday());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
return client;
}

protected BookableProductIf getBookableProductIf(GWT_BookableProduct client) throws KKGWTException
{
if (client == null)
{
    return null;
}

BookableProductIf server = new BookableProduct();
server.setProductId(client.getProductId());
server.setMaxNumBookings(client.getMaxNumBookings());
server.setBookingsMade(client.getBookingsMade());
server.setStartDate(getCalendarFromDate(client.getStartDate()));
server.setEndDate(getCalendarFromDate(client.getEndDate()));
server.setMonday(client.getMonday());
server.setTuesday(client.getTuesday());
server.setWednesday(client.getWednesday());
server.setThursday(client.getThursday());
server.setFriday(client.getFriday());
server.setSaturday(client.getSaturday());
server.setSunday(client.getSunday());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
return server;
}

protected GWT_BookableProductOptions getGWT_BookableProductOptions(BookableProductOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_BookableProductOptions client = new GWT_BookableProductOptions();
client.setThrowExeptionForExceedingMaxBookings(server.isThrowExeptionForExceedingMaxBookings());
return client;
}

protected BookableProductOptionsIf getBookableProductOptionsIf(GWT_BookableProductOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

BookableProductOptionsIf server = new BookableProductOptions();
server.setThrowExeptionForExceedingMaxBookings(client.isThrowExeptionForExceedingMaxBookings());
return server;
}

protected GWT_Booking getGWT_Booking(BookingIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Booking client = new GWT_Booking();
client.setId(server.getId());
client.setQuantity(server.getQuantity());
client.setCustomerId(server.getCustomerId());
client.setOrderId(server.getOrderId());
client.setOrderProductId(server.getOrderProductId());
client.setFirstName(server.getFirstName());
client.setLastName(server.getLastName());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setProductId(server.getProductId());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
return client;
}

protected BookingIf getBookingIf(GWT_Booking client) throws KKGWTException
{
if (client == null)
{
    return null;
}

BookingIf server = new Booking();
server.setId(client.getId());
server.setQuantity(client.getQuantity());
server.setCustomerId(client.getCustomerId());
server.setOrderId(client.getOrderId());
server.setOrderProductId(client.getOrderProductId());
server.setFirstName(client.getFirstName());
server.setLastName(client.getLastName());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setProductId(client.getProductId());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
return server;
}

protected GWT_Bookings getGWT_Bookings(BookingsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Bookings client = new GWT_Bookings();
client.setTotalNumBookings(server.getTotalNumBookings());
if (server.getBookingsArray() == null)
{
client.setBookingsArray(null);
} else
{
GWT_Booking[] clientArray = new GWT_Booking[server.getBookingsArray().length];
for (int i = 0; i < server.getBookingsArray().length; i++)
{
clientArray[i] = getGWT_Booking(server.getBookingsArray()[i]);
}
client.setBookingsArray(clientArray);
}
return client;
}

protected BookingsIf getBookingsIf(GWT_Bookings client) throws KKGWTException
{
if (client == null)
{
    return null;
}

BookingsIf server = new Bookings();
server.setTotalNumBookings(client.getTotalNumBookings());
if (client.getBookingsArray() == null)
{
server.setBookingsArray(null);
} else
{
BookingIf[] serverArray = new BookingIf[client.getBookingsArray().length];
for (int i = 0; i < client.getBookingsArray().length; i++)
{
serverArray[i] = getBookingIf(client.getBookingsArray()[i]);
}
server.setBookingsArray(serverArray);
}
return server;
}

protected GWT_Category getGWT_Category(CategoryIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Category client = new GWT_Category();
if (server.getChildren() == null)
{
client.setChildren(null);
} else
{
GWT_Category[] clientArray = new GWT_Category[server.getChildren().length];
for (int i = 0; i < server.getChildren().length; i++)
{
clientArray[i] = getGWT_Category(server.getChildren()[i]);
}
client.setChildren(clientArray);
}
client.setId(server.getId());
client.setImage(server.getImage());
client.setName(server.getName());
client.setNumberOfProducts(server.getNumberOfProducts());
client.setParentId(server.getParentId());
client.setSortOrder(server.getSortOrder());
client.setParent(getGWT_Category(server.getParent()));
client.setSelected(server.isSelected());
client.setLevel(server.getLevel());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setInvisible(server.isInvisible());
client.setDescription(server.getDescription());
if (server.getMiscItems() == null)
{
client.setMiscItems(null);
} else
{
GWT_MiscItem[] clientArray = new GWT_MiscItem[server.getMiscItems().length];
for (int i = 0; i < server.getMiscItems().length; i++)
{
clientArray[i] = getGWT_MiscItem(server.getMiscItems()[i]);
}
client.setMiscItems(clientArray);
}
return client;
}

protected CategoryIf getCategoryIf(GWT_Category client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CategoryIf server = new Category();
if (client.getChildren() == null)
{
server.setChildren(null);
} else
{
CategoryIf[] serverArray = new CategoryIf[client.getChildren().length];
for (int i = 0; i < client.getChildren().length; i++)
{
serverArray[i] = getCategoryIf(client.getChildren()[i]);
}
server.setChildren(serverArray);
}
server.setId(client.getId());
server.setImage(client.getImage());
server.setName(client.getName());
server.setNumberOfProducts(client.getNumberOfProducts());
server.setParentId(client.getParentId());
server.setSortOrder(client.getSortOrder());
server.setParent(getCategoryIf(client.getParent()));
server.setSelected(client.isSelected());
server.setLevel(client.getLevel());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setInvisible(client.isInvisible());
server.setDescription(client.getDescription());
if (client.getMiscItems() == null)
{
server.setMiscItems(null);
} else
{
MiscItemIf[] serverArray = new MiscItemIf[client.getMiscItems().length];
for (int i = 0; i < client.getMiscItems().length; i++)
{
serverArray[i] = getMiscItemIf(client.getMiscItems()[i]);
}
server.setMiscItems(serverArray);
}
return server;
}

protected GWT_Country getGWT_Country(CountryIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Country client = new GWT_Country();
client.setAddressFormatId(server.getAddressFormatId());
client.setId(server.getId());
client.setIsoCode2(server.getIsoCode2());
client.setIsoCode3(server.getIsoCode3());
client.setName(server.getName());
client.setMsgCatKey(server.getMsgCatKey());
return client;
}

protected CountryIf getCountryIf(GWT_Country client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CountryIf server = new Country();
server.setAddressFormatId(client.getAddressFormatId());
server.setId(client.getId());
server.setIsoCode2(client.getIsoCode2());
server.setIsoCode3(client.getIsoCode3());
server.setName(client.getName());
server.setMsgCatKey(client.getMsgCatKey());
return server;
}

protected GWT_Coupon getGWT_Coupon(CouponIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Coupon client = new GWT_Coupon();
client.setCouponCode(server.getCouponCode());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setDescription(server.getDescription());
client.setId(server.getId());
client.setMaxUse(server.getMaxUse());
client.setName(server.getName());
client.setTimesUsed(server.getTimesUsed());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setLastModified(getDateFromCalendar(server.getLastModified()));
return client;
}

protected CouponIf getCouponIf(GWT_Coupon client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CouponIf server = new Coupon();
server.setCouponCode(client.getCouponCode());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setDescription(client.getDescription());
server.setId(client.getId());
server.setMaxUse(client.getMaxUse());
server.setName(client.getName());
server.setTimesUsed(client.getTimesUsed());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setLastModified(getCalendarFromDate(client.getLastModified()));
return server;
}

protected GWT_CreateOrderOptions getGWT_CreateOrderOptions(CreateOrderOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_CreateOrderOptions client = new GWT_CreateOrderOptions();
client.setCopyBasketCustomFields(server.isCopyBasketCustomFields());
client.setUseDefaultCustomer(server.isUseDefaultCustomer());
client.setCatalogId(server.getCatalogId());
client.setPriceDate(getDateFromCalendar(server.getPriceDate()));
client.setUseWishListShippingAddr(server.isUseWishListShippingAddr());
client.setUseExternalPrice(server.isUseExternalPrice());
client.setLocale(server.getLocale());
client.setUseExternalQuantity(server.isUseExternalQuantity());
client.setBillingAddrId(server.getBillingAddrId());
client.setCustomerAddrId(server.getCustomerAddrId());
client.setDeliveryAddrId(server.getDeliveryAddrId());
return client;
}

protected CreateOrderOptionsIf getCreateOrderOptionsIf(GWT_CreateOrderOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CreateOrderOptionsIf server = new CreateOrderOptions();
server.setCopyBasketCustomFields(client.isCopyBasketCustomFields());
server.setUseDefaultCustomer(client.isUseDefaultCustomer());
server.setCatalogId(client.getCatalogId());
server.setPriceDate(getCalendarFromDate(client.getPriceDate()));
server.setUseWishListShippingAddr(client.isUseWishListShippingAddr());
server.setUseExternalPrice(client.isUseExternalPrice());
server.setLocale(client.getLocale());
server.setUseExternalQuantity(client.isUseExternalQuantity());
server.setBillingAddrId(client.getBillingAddrId());
server.setCustomerAddrId(client.getCustomerAddrId());
server.setDeliveryAddrId(client.getDeliveryAddrId());
return server;
}

protected GWT_CreditCard getGWT_CreditCard(CreditCardIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_CreditCard client = new GWT_CreditCard();
client.setCcType(server.getCcType());
client.setCcOwner(server.getCcOwner());
client.setCcNumber(server.getCcNumber());
client.setCcExpires(server.getCcExpires());
client.setCcCVV(server.getCcCVV());
return client;
}

protected CreditCardIf getCreditCardIf(GWT_CreditCard client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CreditCardIf server = new CreditCard();
server.setCcType(client.getCcType());
server.setCcOwner(client.getCcOwner());
server.setCcNumber(client.getCcNumber());
server.setCcExpires(client.getCcExpires());
server.setCcCVV(client.getCcCVV());
return server;
}

protected GWT_Currency getGWT_Currency(CurrencyIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Currency client = new GWT_Currency();
client.setCode(server.getCode());
client.setDecimalPlaces(server.getDecimalPlaces());
client.setDecimalPoint(server.getDecimalPoint());
client.setId(server.getId());
client.setSymbolLeft(server.getSymbolLeft());
client.setSymbolRight(server.getSymbolRight());
client.setThousandsPoint(server.getThousandsPoint());
client.setTitle(server.getTitle());
client.setValue(getDoubleFromBigDecimal(server.getValue()));
return client;
}

protected CurrencyIf getCurrencyIf(GWT_Currency client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CurrencyIf server = new Currency();
server.setCode(client.getCode());
server.setDecimalPlaces(client.getDecimalPlaces());
server.setDecimalPoint(client.getDecimalPoint());
server.setId(client.getId());
server.setSymbolLeft(client.getSymbolLeft());
server.setSymbolRight(client.getSymbolRight());
server.setThousandsPoint(client.getThousandsPoint());
server.setTitle(client.getTitle());
server.setValue(getBigDecimalFromDouble(client.getValue()));
return server;
}

protected GWT_CustomerEvent getGWT_CustomerEvent(CustomerEventIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_CustomerEvent client = new GWT_CustomerEvent();
client.setId(server.getId());
client.setCustomerId(server.getCustomerId());
client.setAction(server.getAction());
client.setData1Str(server.getData1Str());
client.setData2Str(server.getData2Str());
client.setData1Int(server.getData1Int());
client.setData2Int(server.getData2Int());
client.setData1Dec(getDoubleFromBigDecimal(server.getData1Dec()));
client.setData2Dec(getDoubleFromBigDecimal(server.getData2Dec()));
client.setStoreId(server.getStoreId());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
return client;
}

protected CustomerEventIf getCustomerEventIf(GWT_CustomerEvent client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CustomerEventIf server = new CustomerEvent();
server.setId(client.getId());
server.setCustomerId(client.getCustomerId());
server.setAction(client.getAction());
server.setData1Str(client.getData1Str());
server.setData2Str(client.getData2Str());
server.setData1Int(client.getData1Int());
server.setData2Int(client.getData2Int());
server.setData1Dec(getBigDecimalFromDouble(client.getData1Dec()));
server.setData2Dec(getBigDecimalFromDouble(client.getData2Dec()));
server.setStoreId(client.getStoreId());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
return server;
}

protected GWT_CustomerGroup getGWT_CustomerGroup(CustomerGroupIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_CustomerGroup client = new GWT_CustomerGroup();
client.setId(server.getId());
client.setName(server.getName());
client.setDescription(server.getDescription());
client.setPriceId(server.getPriceId());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
return client;
}

protected CustomerGroupIf getCustomerGroupIf(GWT_CustomerGroup client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CustomerGroupIf server = new CustomerGroup();
server.setId(client.getId());
server.setName(client.getName());
server.setDescription(client.getDescription());
server.setPriceId(client.getPriceId());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
return server;
}

protected GWT_Customer getGWT_Customer(CustomerIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Customer client = new GWT_Customer();
client.setDefaultAddr(getGWT_Address(server.getDefaultAddr()));
client.setEmailAddr(server.getEmailAddr());
client.setFaxNumber(server.getFaxNumber());
client.setFirstName(server.getFirstName());
client.setGender(server.getGender());
client.setId(server.getId());
client.setLastName(server.getLastName());
client.setNewsletter(server.getNewsletter());
client.setNumberOfLogons(server.getNumberOfLogons());
client.setPassword(server.getPassword());
client.setTelephoneNumber(server.getTelephoneNumber());
client.setTelephoneNumber1(server.getTelephoneNumber1());
client.setAccountCreated(getDateFromCalendar(server.getAccountCreated()));
client.setAccountLastModified(getDateFromCalendar(server.getAccountLastModified()));
client.setBirthDate(getDateFromCalendar(server.getBirthDate()));
client.setLastLogon(getDateFromCalendar(server.getLastLogon()));
if (server.getBasketItems() == null)
{
client.setBasketItems(null);
} else
{
GWT_Basket[] clientArray = new GWT_Basket[server.getBasketItems().length];
for (int i = 0; i < server.getBasketItems().length; i++)
{
clientArray[i] = getGWT_Basket(server.getBasketItems()[i]);
}
client.setBasketItems(clientArray);
}
client.setDefaultAddrId(server.getDefaultAddrId());
if (server.getAddresses() == null)
{
client.setAddresses(null);
} else
{
GWT_Address[] clientArray = new GWT_Address[server.getAddresses().length];
for (int i = 0; i < server.getAddresses().length; i++)
{
clientArray[i] = getGWT_Address(server.getAddresses()[i]);
}
client.setAddresses(clientArray);
}
client.setGlobalProdNotifier(server.getGlobalProdNotifier());
if (server.getProductNotifications() == null)
{
client.setProductNotifications(null);
} else
{
GWT_Product[] clientArray = new GWT_Product[server.getProductNotifications().length];
for (int i = 0; i < server.getProductNotifications().length; i++)
{
clientArray[i] = getGWT_Product(server.getProductNotifications()[i]);
}
client.setProductNotifications(clientArray);
}
if (server.getOrders() == null)
{
client.setOrders(null);
} else
{
GWT_Order[] clientArray = new GWT_Order[server.getOrders().length];
for (int i = 0; i < server.getOrders().length; i++)
{
clientArray[i] = getGWT_Order(server.getOrders()[i]);
}
client.setOrders(clientArray);
}
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setType(server.getType());
client.setGroupId(server.getGroupId());
client.setCustomerGroup(getGWT_CustomerGroup(server.getCustomerGroup()));
if (server.getWishLists() == null)
{
client.setWishLists(null);
} else
{
GWT_WishList[] clientArray = new GWT_WishList[server.getWishLists().length];
for (int i = 0; i < server.getWishLists().length; i++)
{
clientArray[i] = getGWT_WishList(server.getWishLists()[i]);
}
client.setWishLists(clientArray);
}
client.setLocale(server.getLocale());
client.setInvisible(server.getInvisible());
return client;
}

protected CustomerIf getCustomerIf(GWT_Customer client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CustomerIf server = new Customer();
server.setDefaultAddr(getAddressIf(client.getDefaultAddr()));
server.setEmailAddr(client.getEmailAddr());
server.setFaxNumber(client.getFaxNumber());
server.setFirstName(client.getFirstName());
server.setGender(client.getGender());
server.setId(client.getId());
server.setLastName(client.getLastName());
server.setNewsletter(client.getNewsletter());
server.setNumberOfLogons(client.getNumberOfLogons());
server.setPassword(client.getPassword());
server.setTelephoneNumber(client.getTelephoneNumber());
server.setTelephoneNumber1(client.getTelephoneNumber1());
server.setAccountCreated(getCalendarFromDate(client.getAccountCreated()));
server.setAccountLastModified(getCalendarFromDate(client.getAccountLastModified()));
server.setBirthDate(getCalendarFromDate(client.getBirthDate()));
server.setLastLogon(getCalendarFromDate(client.getLastLogon()));
if (client.getBasketItems() == null)
{
server.setBasketItems(null);
} else
{
BasketIf[] serverArray = new BasketIf[client.getBasketItems().length];
for (int i = 0; i < client.getBasketItems().length; i++)
{
serverArray[i] = getBasketIf(client.getBasketItems()[i]);
}
server.setBasketItems(serverArray);
}
server.setDefaultAddrId(client.getDefaultAddrId());
if (client.getAddresses() == null)
{
server.setAddresses(null);
} else
{
AddressIf[] serverArray = new AddressIf[client.getAddresses().length];
for (int i = 0; i < client.getAddresses().length; i++)
{
serverArray[i] = getAddressIf(client.getAddresses()[i]);
}
server.setAddresses(serverArray);
}
server.setGlobalProdNotifier(client.getGlobalProdNotifier());
if (client.getProductNotifications() == null)
{
server.setProductNotifications(null);
} else
{
ProductIf[] serverArray = new ProductIf[client.getProductNotifications().length];
for (int i = 0; i < client.getProductNotifications().length; i++)
{
serverArray[i] = getProductIf(client.getProductNotifications()[i]);
}
server.setProductNotifications(serverArray);
}
if (client.getOrders() == null)
{
server.setOrders(null);
} else
{
OrderIf[] serverArray = new OrderIf[client.getOrders().length];
for (int i = 0; i < client.getOrders().length; i++)
{
serverArray[i] = getOrderIf(client.getOrders()[i]);
}
server.setOrders(serverArray);
}
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setType(client.getType());
server.setGroupId(client.getGroupId());
server.setCustomerGroup(getCustomerGroupIf(client.getCustomerGroup()));
if (client.getWishLists() == null)
{
server.setWishLists(null);
} else
{
WishListIf[] serverArray = new WishListIf[client.getWishLists().length];
for (int i = 0; i < client.getWishLists().length; i++)
{
serverArray[i] = getWishListIf(client.getWishLists()[i]);
}
server.setWishLists(serverArray);
}
server.setLocale(client.getLocale());
server.setInvisible(client.getInvisible());
return server;
}

protected GWT_CustomerRegistration getGWT_CustomerRegistration(CustomerRegistrationIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_CustomerRegistration client = new GWT_CustomerRegistration();
client.setCity(server.getCity());
client.setCompany(server.getCompany());
client.setCountryId(server.getCountryId());
client.setEmailAddr(server.getEmailAddr());
client.setFaxNumber(server.getFaxNumber());
client.setFirstName(server.getFirstName());
client.setGender(server.getGender());
client.setLastName(server.getLastName());
client.setNewsletter(server.getNewsletter());
client.setPassword(server.getPassword());
client.setPostcode(server.getPostcode());
client.setProductNotifications(server.getProductNotifications());
client.setState(server.getState());
client.setStreetAddress(server.getStreetAddress());
client.setStreetAddress1(server.getStreetAddress1());
client.setSuburb(server.getSuburb());
client.setTelephoneNumber(server.getTelephoneNumber());
client.setTelephoneNumber1(server.getTelephoneNumber1());
client.setBirthDate(getDateFromCalendar(server.getBirthDate()));
client.setAddressCustom1(server.getAddressCustom1());
client.setAddressCustom2(server.getAddressCustom2());
client.setAddressCustom3(server.getAddressCustom3());
client.setAddressCustom4(server.getAddressCustom4());
client.setAddressCustom5(server.getAddressCustom5());
client.setCustomerCustom1(server.getCustomerCustom1());
client.setCustomerCustom2(server.getCustomerCustom2());
client.setCustomerCustom3(server.getCustomerCustom3());
client.setCustomerCustom4(server.getCustomerCustom4());
client.setCustomerCustom5(server.getCustomerCustom5());
client.setGroupId(server.getGroupId());
client.setLocale(server.getLocale());
client.setZoneId(server.getZoneId());
client.setInvisible(server.isInvisible());
client.setEnabled(server.isEnabled());
return client;
}

protected CustomerRegistrationIf getCustomerRegistrationIf(GWT_CustomerRegistration client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CustomerRegistrationIf server = new CustomerRegistration();
server.setCity(client.getCity());
server.setCompany(client.getCompany());
server.setCountryId(client.getCountryId());
server.setEmailAddr(client.getEmailAddr());
server.setFaxNumber(client.getFaxNumber());
server.setFirstName(client.getFirstName());
server.setGender(client.getGender());
server.setLastName(client.getLastName());
server.setNewsletter(client.getNewsletter());
server.setPassword(client.getPassword());
server.setPostcode(client.getPostcode());
server.setProductNotifications(client.getProductNotifications());
server.setState(client.getState());
server.setStreetAddress(client.getStreetAddress());
server.setStreetAddress1(client.getStreetAddress1());
server.setSuburb(client.getSuburb());
server.setTelephoneNumber(client.getTelephoneNumber());
server.setTelephoneNumber1(client.getTelephoneNumber1());
server.setBirthDate(getCalendarFromDate(client.getBirthDate()));
server.setAddressCustom1(client.getAddressCustom1());
server.setAddressCustom2(client.getAddressCustom2());
server.setAddressCustom3(client.getAddressCustom3());
server.setAddressCustom4(client.getAddressCustom4());
server.setAddressCustom5(client.getAddressCustom5());
server.setCustomerCustom1(client.getCustomerCustom1());
server.setCustomerCustom2(client.getCustomerCustom2());
server.setCustomerCustom3(client.getCustomerCustom3());
server.setCustomerCustom4(client.getCustomerCustom4());
server.setCustomerCustom5(client.getCustomerCustom5());
server.setGroupId(client.getGroupId());
server.setLocale(client.getLocale());
server.setZoneId(client.getZoneId());
server.setInvisible(client.isInvisible());
server.setEnabled(client.isEnabled());
return server;
}

protected GWT_CustomerSearch getGWT_CustomerSearch(CustomerSearchIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_CustomerSearch client = new GWT_CustomerSearch();
client.setEmailAddr(server.getEmailAddr());
client.setFirstName(server.getFirstName());
client.setId(server.getId());
client.setLastName(server.getLastName());
client.setBirthDate(getDateFromCalendar(server.getBirthDate()));
client.setType(server.getType());
client.setCity(server.getCity());
client.setState(server.getState());
client.setCityOrState(server.getCityOrState());
client.setFirstName1(server.getFirstName1());
client.setLastName1(server.getLastName1());
client.setEventDate(getDateFromCalendar(server.getEventDate()));
client.setFirstNameRule(server.getFirstNameRule());
client.setLastNameRule(server.getLastNameRule());
client.setFirstName1Rule(server.getFirstName1Rule());
client.setLastName1Rule(server.getLastName1Rule());
client.setEmailAddrRule(server.getEmailAddrRule());
client.setCityRule(server.getCityRule());
client.setStateRule(server.getStateRule());
client.setTmpId(server.getTmpId());
return client;
}

protected CustomerSearchIf getCustomerSearchIf(GWT_CustomerSearch client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CustomerSearchIf server = new CustomerSearch();
server.setEmailAddr(client.getEmailAddr());
server.setFirstName(client.getFirstName());
server.setId(client.getId());
server.setLastName(client.getLastName());
server.setBirthDate(getCalendarFromDate(client.getBirthDate()));
server.setType(client.getType());
server.setCity(client.getCity());
server.setState(client.getState());
server.setCityOrState(client.getCityOrState());
server.setFirstName1(client.getFirstName1());
server.setLastName1(client.getLastName1());
server.setEventDate(getCalendarFromDate(client.getEventDate()));
server.setFirstNameRule(client.getFirstNameRule());
server.setLastNameRule(client.getLastNameRule());
server.setFirstName1Rule(client.getFirstName1Rule());
server.setLastName1Rule(client.getLastName1Rule());
server.setEmailAddrRule(client.getEmailAddrRule());
server.setCityRule(client.getCityRule());
server.setStateRule(client.getStateRule());
server.setTmpId(client.getTmpId());
return server;
}

protected GWT_CustomerTag getGWT_CustomerTag(CustomerTagIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_CustomerTag client = new GWT_CustomerTag();
client.setId(server.getId());
client.setName(server.getName());
client.setDescription(server.getDescription());
client.setValue(server.getValue());
client.setValidation(server.getValidation());
client.setType(server.getType());
client.setMaxInts(server.getMaxInts());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
return client;
}

protected CustomerTagIf getCustomerTagIf(GWT_CustomerTag client) throws KKGWTException
{
if (client == null)
{
    return null;
}

CustomerTagIf server = new CustomerTag();
server.setId(client.getId());
server.setName(client.getName());
server.setDescription(client.getDescription());
server.setValue(client.getValue());
server.setValidation(client.getValidation());
server.setType(client.getType());
server.setMaxInts(client.getMaxInts());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
return server;
}

protected GWT_DataDescriptor getGWT_DataDescriptor(DataDescriptorIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_DataDescriptor client = new GWT_DataDescriptor();
client.setLimit(server.getLimit());
client.setOffset(server.getOffset());
client.setOrderBy(server.getOrderBy());
client.setOrderBy_1(server.getOrderBy_1());
client.setShowInvisible(server.isShowInvisible());
client.setFillMiscItems(server.isFillMiscItems());
client.setFillDescription(server.isFillDescription());
client.setFillCustomAttrArray(server.isFillCustomAttrArray());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setCustom6(server.getCustom6());
client.setCustom7(server.getCustom7());
client.setCustom8(server.getCustom8());
client.setCustom9(server.getCustom9());
client.setCustom10(server.getCustom10());
client.setCustom1Int(server.getCustom1Int());
client.setCustom2Int(server.getCustom2Int());
client.setCustom1Dec(getDoubleFromBigDecimal(server.getCustom1Dec()));
client.setCustom2Dec(getDoubleFromBigDecimal(server.getCustom2Dec()));
client.setCustom1Rule(server.getCustom1Rule());
client.setCustom2Rule(server.getCustom2Rule());
client.setCustom3Rule(server.getCustom3Rule());
client.setCustom4Rule(server.getCustom4Rule());
client.setCustom5Rule(server.getCustom5Rule());
client.setCustom6Rule(server.getCustom6Rule());
client.setCustom7Rule(server.getCustom7Rule());
client.setCustom8Rule(server.getCustom8Rule());
client.setCustom9Rule(server.getCustom9Rule());
client.setCustom10Rule(server.getCustom10Rule());
client.setCustom1IntRule(server.getCustom1IntRule());
client.setCustom2IntRule(server.getCustom2IntRule());
client.setCustom1DecRule(server.getCustom1DecRule());
client.setCustom2DecRule(server.getCustom2DecRule());
return client;
}

protected DataDescriptorIf getDataDescriptorIf(GWT_DataDescriptor client) throws KKGWTException
{
if (client == null)
{
    return null;
}

DataDescriptorIf server = new DataDescriptor();
server.setLimit(client.getLimit());
server.setOffset(client.getOffset());
server.setOrderBy(client.getOrderBy());
server.setOrderBy_1(client.getOrderBy_1());
server.setShowInvisible(client.isShowInvisible());
server.setFillMiscItems(client.isFillMiscItems());
server.setFillDescription(client.isFillDescription());
server.setFillCustomAttrArray(client.isFillCustomAttrArray());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setCustom6(client.getCustom6());
server.setCustom7(client.getCustom7());
server.setCustom8(client.getCustom8());
server.setCustom9(client.getCustom9());
server.setCustom10(client.getCustom10());
server.setCustom1Int(client.getCustom1Int());
server.setCustom2Int(client.getCustom2Int());
server.setCustom1Dec(getBigDecimalFromDouble(client.getCustom1Dec()));
server.setCustom2Dec(getBigDecimalFromDouble(client.getCustom2Dec()));
server.setCustom1Rule(client.getCustom1Rule());
server.setCustom2Rule(client.getCustom2Rule());
server.setCustom3Rule(client.getCustom3Rule());
server.setCustom4Rule(client.getCustom4Rule());
server.setCustom5Rule(client.getCustom5Rule());
server.setCustom6Rule(client.getCustom6Rule());
server.setCustom7Rule(client.getCustom7Rule());
server.setCustom8Rule(client.getCustom8Rule());
server.setCustom9Rule(client.getCustom9Rule());
server.setCustom10Rule(client.getCustom10Rule());
server.setCustom1IntRule(client.getCustom1IntRule());
server.setCustom2IntRule(client.getCustom2IntRule());
server.setCustom1DecRule(client.getCustom1DecRule());
server.setCustom2DecRule(client.getCustom2DecRule());
return server;
}

protected GWT_DigitalDownload getGWT_DigitalDownload(DigitalDownloadIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_DigitalDownload client = new GWT_DigitalDownload();
client.setId(server.getId());
client.setCustomerId(server.getCustomerId());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setExpirationDate(getDateFromCalendar(server.getExpirationDate()));
client.setLastModified(getDateFromCalendar(server.getLastModified()));
client.setMaxDownloads(server.getMaxDownloads());
client.setProductId(server.getProductId());
client.setTimesDownloaded(server.getTimesDownloaded());
client.setProduct(getGWT_Product(server.getProduct()));
client.setFilePath(server.getFilePath());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
return client;
}

protected DigitalDownloadIf getDigitalDownloadIf(GWT_DigitalDownload client) throws KKGWTException
{
if (client == null)
{
    return null;
}

DigitalDownloadIf server = new DigitalDownload();
server.setId(client.getId());
server.setCustomerId(client.getCustomerId());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setExpirationDate(getCalendarFromDate(client.getExpirationDate()));
server.setLastModified(getCalendarFromDate(client.getLastModified()));
server.setMaxDownloads(client.getMaxDownloads());
server.setProductId(client.getProductId());
server.setTimesDownloaded(client.getTimesDownloaded());
server.setProduct(getProductIf(client.getProduct()));
server.setFilePath(client.getFilePath());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
return server;
}

protected GWT_Email getGWT_Email(EmailIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Email client = new GWT_Email();
client.setSubject(server.getSubject());
client.setBody(server.getBody());
client.setAddress(server.getAddress());
return client;
}

protected EmailIf getEmailIf(GWT_Email client) throws KKGWTException
{
if (client == null)
{
    return null;
}

EmailIf server = new Email();
server.setSubject(client.getSubject());
server.setBody(client.getBody());
server.setAddress(client.getAddress());
return server;
}

protected GWT_EmailOptions getGWT_EmailOptions(EmailOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_EmailOptions client = new GWT_EmailOptions();
client.setTemplateName(server.getTemplateName());
client.setCountryCode(server.getCountryCode());
if (server.getCustomAttrs() == null)
{
client.setCustomAttrs(null);
} else
{
GWT_NameValue[] clientArray = new GWT_NameValue[server.getCustomAttrs().length];
for (int i = 0; i < server.getCustomAttrs().length; i++)
{
clientArray[i] = getGWT_NameValue(server.getCustomAttrs()[i]);
}
client.setCustomAttrs(clientArray);
}
client.setAttachInvoice(server.isAttachInvoice());
client.setCreateInvoice(server.isCreateInvoice());
client.setFullAttachmentFilename(server.getFullAttachmentFilename());
client.setFriendlyAttachmentName(server.getFriendlyAttachmentName());
client.setDeleteAttachmentAfterSend(server.isDeleteAttachmentAfterSend());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustomInt1(server.getCustomInt1());
client.setCustomInt2(server.getCustomInt2());
return client;
}

protected EmailOptionsIf getEmailOptionsIf(GWT_EmailOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

EmailOptionsIf server = new EmailOptions();
server.setTemplateName(client.getTemplateName());
server.setCountryCode(client.getCountryCode());
if (client.getCustomAttrs() == null)
{
server.setCustomAttrs(null);
} else
{
NameValueIf[] serverArray = new NameValueIf[client.getCustomAttrs().length];
for (int i = 0; i < client.getCustomAttrs().length; i++)
{
serverArray[i] = getNameValueIf(client.getCustomAttrs()[i]);
}
server.setCustomAttrs(serverArray);
}
server.setAttachInvoice(client.isAttachInvoice());
server.setCreateInvoice(client.isCreateInvoice());
server.setFullAttachmentFilename(client.getFullAttachmentFilename());
server.setFriendlyAttachmentName(client.getFriendlyAttachmentName());
server.setDeleteAttachmentAfterSend(client.isDeleteAttachmentAfterSend());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustomInt1(client.getCustomInt1());
server.setCustomInt2(client.getCustomInt2());
return server;
}

protected GWT_EngineConfig getGWT_EngineConfig(EngineConfigIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_EngineConfig client = new GWT_EngineConfig();
client.setStoreId(server.getStoreId());
client.setMode(server.getMode());
client.setPropertiesFileName(server.getPropertiesFileName());
client.setAppPropertiesFileName(server.getAppPropertiesFileName());
client.setCustomersShared(server.isCustomersShared());
client.setProductsShared(server.isProductsShared());
client.setEngineId(server.getEngineId());
return client;
}

protected EngineConfigIf getEngineConfigIf(GWT_EngineConfig client) throws KKGWTException
{
if (client == null)
{
    return null;
}

EngineConfigIf server = new EngineConfig();
server.setStoreId(client.getStoreId());
server.setMode(client.getMode());
server.setPropertiesFileName(client.getPropertiesFileName());
server.setAppPropertiesFileName(client.getAppPropertiesFileName());
server.setCustomersShared(client.isCustomersShared());
server.setProductsShared(client.isProductsShared());
server.setEngineId(client.getEngineId());
return server;
}

protected GWT_ExportOrderOptions getGWT_ExportOrderOptions(ExportOrderOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_ExportOrderOptions client = new GWT_ExportOrderOptions();
client.setCode(server.getCode());
client.setParams(server.getParams());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setOrderId(server.getOrderId());
return client;
}

protected ExportOrderOptionsIf getExportOrderOptionsIf(GWT_ExportOrderOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ExportOrderOptionsIf server = new ExportOrderOptions();
server.setCode(client.getCode());
server.setParams(client.getParams());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setOrderId(client.getOrderId());
return server;
}

protected GWT_ExportOrderResponse getGWT_ExportOrderResponse(ExportOrderResponseIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_ExportOrderResponse client = new GWT_ExportOrderResponse();
client.setCode(server.getCode());
client.setParams(server.getParams());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setConfirmationText(server.getConfirmationText());
client.setOrderId(server.getOrderId());
client.setOrderAsXml(server.getOrderAsXml());
return client;
}

protected ExportOrderResponseIf getExportOrderResponseIf(GWT_ExportOrderResponse client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ExportOrderResponseIf server = new ExportOrderResponse();
server.setCode(client.getCode());
server.setParams(client.getParams());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setConfirmationText(client.getConfirmationText());
server.setOrderId(client.getOrderId());
server.setOrderAsXml(client.getOrderAsXml());
return server;
}

protected GWT_Expression getGWT_Expression(ExpressionIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Expression client = new GWT_Expression();
client.setId(server.getId());
client.setName(server.getName());
client.setDescription(server.getDescription());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setNumVariables(server.getNumVariables());
return client;
}

protected ExpressionIf getExpressionIf(GWT_Expression client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ExpressionIf server = new Expression();
server.setId(client.getId());
server.setName(client.getName());
server.setDescription(client.getDescription());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setNumVariables(client.getNumVariables());
return server;
}

protected GWT_ExpressionVariable getGWT_ExpressionVariable(ExpressionVariableIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_ExpressionVariable client = new GWT_ExpressionVariable();
client.setId(server.getId());
client.setCustomerTagId(server.getCustomerTagId());
client.setExpressionId(server.getExpressionId());
client.setType(server.getType());
client.setOperator(server.getOperator());
client.setValue(server.getValue());
client.setCustomerValue(server.getCustomerValue());
client.setOrder(server.getOrder());
client.setAndOr(server.getAndOr());
client.setGroupOrder(server.getGroupOrder());
client.setGroupAndOr(server.getGroupAndOr());
return client;
}

protected ExpressionVariableIf getExpressionVariableIf(GWT_ExpressionVariable client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ExpressionVariableIf server = new ExpressionVariable();
server.setId(client.getId());
server.setCustomerTagId(client.getCustomerTagId());
server.setExpressionId(client.getExpressionId());
server.setType(client.getType());
server.setOperator(client.getOperator());
server.setValue(client.getValue());
server.setCustomerValue(client.getCustomerValue());
server.setOrder(client.getOrder());
server.setAndOr(client.getAndOr());
server.setGroupOrder(client.getGroupOrder());
server.setGroupAndOr(client.getGroupAndOr());
return server;
}

protected GWT_FetchProductOptions getGWT_FetchProductOptions(FetchProductOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_FetchProductOptions client = new GWT_FetchProductOptions();
client.setCatalogId(server.getCatalogId());
client.setPriceDate(getDateFromCalendar(server.getPriceDate()));
client.setUseExternalPrice(server.isUseExternalPrice());
client.setGetTierPrices(server.isGetTierPrices());
client.setUseExternalQuantity(server.isUseExternalQuantity());
client.setInvertRelatedProductDirection(server.isInvertRelatedProductDirection());
return client;
}

protected FetchProductOptionsIf getFetchProductOptionsIf(GWT_FetchProductOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

FetchProductOptionsIf server = new FetchProductOptions();
server.setCatalogId(client.getCatalogId());
server.setPriceDate(getCalendarFromDate(client.getPriceDate()));
server.setUseExternalPrice(client.isUseExternalPrice());
server.setGetTierPrices(client.isGetTierPrices());
server.setUseExternalQuantity(client.isUseExternalQuantity());
server.setInvertRelatedProductDirection(client.isInvertRelatedProductDirection());
return server;
}

protected GWT_GeoZone getGWT_GeoZone(GeoZoneIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_GeoZone client = new GWT_GeoZone();
client.setGeoZoneDescription(server.getGeoZoneDescription());
client.setGeoZoneId(server.getGeoZoneId());
client.setGeoZoneName(server.getGeoZoneName());
return client;
}

protected GeoZoneIf getGeoZoneIf(GWT_GeoZone client) throws KKGWTException
{
if (client == null)
{
    return null;
}

GeoZoneIf server = new GeoZone();
server.setGeoZoneDescription(client.getGeoZoneDescription());
server.setGeoZoneId(client.getGeoZoneId());
server.setGeoZoneName(client.getGeoZoneName());
return server;
}

protected GWT_IpnHistory getGWT_IpnHistory(IpnHistoryIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_IpnHistory client = new GWT_IpnHistory();
client.setGatewayFullResponse(server.getGatewayFullResponse());
client.setGatewayResult(server.getGatewayResult());
client.setGatewayTransactionId(server.getGatewayTransactionId());
client.setId(server.getId());
client.setKonakartResultDescription(server.getKonakartResultDescription());
client.setKonakartResultId(server.getKonakartResultId());
client.setModuleCode(server.getModuleCode());
client.setOrderId(server.getOrderId());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setCustomerId(server.getCustomerId());
client.setSubscriptionId(server.getSubscriptionId());
client.setTxAmount(getDoubleFromBigDecimal(server.getTxAmount()));
client.setTxType(server.getTxType());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom1Dec(getDoubleFromBigDecimal(server.getCustom1Dec()));
client.setCustom2Dec(getDoubleFromBigDecimal(server.getCustom2Dec()));
return client;
}

protected IpnHistoryIf getIpnHistoryIf(GWT_IpnHistory client) throws KKGWTException
{
if (client == null)
{
    return null;
}

IpnHistoryIf server = new IpnHistory();
server.setGatewayFullResponse(client.getGatewayFullResponse());
server.setGatewayResult(client.getGatewayResult());
server.setGatewayTransactionId(client.getGatewayTransactionId());
server.setId(client.getId());
server.setKonakartResultDescription(client.getKonakartResultDescription());
server.setKonakartResultId(client.getKonakartResultId());
server.setModuleCode(client.getModuleCode());
server.setOrderId(client.getOrderId());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setCustomerId(client.getCustomerId());
server.setSubscriptionId(client.getSubscriptionId());
server.setTxAmount(getBigDecimalFromDouble(client.getTxAmount()));
server.setTxType(client.getTxType());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom1Dec(getBigDecimalFromDouble(client.getCustom1Dec()));
server.setCustom2Dec(getBigDecimalFromDouble(client.getCustom2Dec()));
return server;
}

protected GWT_KKConfiguration getGWT_KKConfiguration(KKConfigurationIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_KKConfiguration client = new GWT_KKConfiguration();
client.setId(server.getId());
client.setKey(server.getKey());
client.setValue(server.getValue());
client.setLastModified(getDateFromCalendar(server.getLastModified()));
client.setStoreId(server.getStoreId());
return client;
}

protected KKConfigurationIf getKKConfigurationIf(GWT_KKConfiguration client) throws KKGWTException
{
if (client == null)
{
    return null;
}

KKConfigurationIf server = new KKConfiguration();
server.setId(client.getId());
server.setKey(client.getKey());
server.setValue(client.getValue());
server.setLastModified(getCalendarFromDate(client.getLastModified()));
server.setStoreId(client.getStoreId());
return server;
}

protected GWT_KKCookie getGWT_KKCookie(KKCookieIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_KKCookie client = new GWT_KKCookie();
client.setCustomerUuid(server.getCustomerUuid());
client.setAttributeId(server.getAttributeId());
client.setAttributeValue(server.getAttributeValue());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setLastModified(getDateFromCalendar(server.getLastModified()));
return client;
}

protected KKCookieIf getKKCookieIf(GWT_KKCookie client) throws KKGWTException
{
if (client == null)
{
    return null;
}

KKCookieIf server = new KKCookie();
server.setCustomerUuid(client.getCustomerUuid());
server.setAttributeId(client.getAttributeId());
server.setAttributeValue(client.getAttributeValue());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setLastModified(getCalendarFromDate(client.getLastModified()));
return server;
}

protected GWT_KKFacet getGWT_KKFacet(KKFacetIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_KKFacet client = new GWT_KKFacet();
client.setName(server.getName());
client.setNumber(server.getNumber());
if (server.getValues() == null)
{
client.setValues(null);
} else
{
GWT_NameNumber[] clientArray = new GWT_NameNumber[server.getValues().length];
for (int i = 0; i < server.getValues().length; i++)
{
clientArray[i] = getGWT_NameNumber(server.getValues()[i]);
}
client.setValues(clientArray);
}
return client;
}

protected KKFacetIf getKKFacetIf(GWT_KKFacet client) throws KKGWTException
{
if (client == null)
{
    return null;
}

KKFacetIf server = new KKFacet();
server.setName(client.getName());
server.setNumber(client.getNumber());
if (client.getValues() == null)
{
server.setValues(null);
} else
{
NameNumberIf[] serverArray = new NameNumberIf[client.getValues().length];
for (int i = 0; i < client.getValues().length; i++)
{
serverArray[i] = getNameNumberIf(client.getValues()[i]);
}
server.setValues(serverArray);
}
return server;
}

protected GWT_KkMsg getGWT_KkMsg(KkMsgIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_KkMsg client = new GWT_KkMsg();
client.setMsgKey(server.getMsgKey());
client.setMsgLocale(server.getMsgLocale());
client.setMsgType(server.getMsgType());
client.setMsgValue(server.getMsgValue());
return client;
}

protected KkMsgIf getKkMsgIf(GWT_KkMsg client) throws KKGWTException
{
if (client == null)
{
    return null;
}

KkMsgIf server = new KkMsg();
server.setMsgKey(client.getMsgKey());
server.setMsgLocale(client.getMsgLocale());
server.setMsgType(client.getMsgType());
server.setMsgValue(client.getMsgValue());
return server;
}

protected GWT_Language getGWT_Language(LanguageIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Language client = new GWT_Language();
client.setCode(server.getCode());
client.setDirectory(server.getDirectory());
client.setLocale(server.getLocale());
client.setId(server.getId());
client.setImage(server.getImage());
client.setName(server.getName());
client.setSortOrder(server.getSortOrder());
return client;
}

protected LanguageIf getLanguageIf(GWT_Language client) throws KKGWTException
{
if (client == null)
{
    return null;
}

LanguageIf server = new Language();
server.setCode(client.getCode());
server.setDirectory(client.getDirectory());
server.setLocale(client.getLocale());
server.setId(client.getId());
server.setImage(client.getImage());
server.setName(client.getName());
server.setSortOrder(client.getSortOrder());
return server;
}

protected GWT_Manufacturer getGWT_Manufacturer(ManufacturerIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Manufacturer client = new GWT_Manufacturer();
client.setId(server.getId());
client.setImage(server.getImage());
client.setName(server.getName());
client.setUrl(server.getUrl());
client.setUrlClicked(server.getUrlClicked());
client.setLastClick(getDateFromCalendar(server.getLastClick()));
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
if (server.getAddresses() == null)
{
client.setAddresses(null);
} else
{
GWT_Address[] clientArray = new GWT_Address[server.getAddresses().length];
for (int i = 0; i < server.getAddresses().length; i++)
{
clientArray[i] = getGWT_Address(server.getAddresses()[i]);
}
client.setAddresses(clientArray);
}
client.setNumberOfProducts(server.getNumberOfProducts());
return client;
}

protected ManufacturerIf getManufacturerIf(GWT_Manufacturer client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ManufacturerIf server = new Manufacturer();
server.setId(client.getId());
server.setImage(client.getImage());
server.setName(client.getName());
server.setUrl(client.getUrl());
server.setUrlClicked(client.getUrlClicked());
server.setLastClick(getCalendarFromDate(client.getLastClick()));
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
if (client.getAddresses() == null)
{
server.setAddresses(null);
} else
{
AddressIf[] serverArray = new AddressIf[client.getAddresses().length];
for (int i = 0; i < client.getAddresses().length; i++)
{
serverArray[i] = getAddressIf(client.getAddresses()[i]);
}
server.setAddresses(serverArray);
}
server.setNumberOfProducts(client.getNumberOfProducts());
return server;
}

protected GWT_MiscItem getGWT_MiscItem(MiscItemIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_MiscItem client = new GWT_MiscItem();
client.setId(server.getId());
client.setTypeId(server.getTypeId());
client.setObjId(server.getObjId());
client.setItemValue(server.getItemValue());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setType(server.getType());
client.setTypeDescription(server.getTypeDescription());
return client;
}

protected MiscItemIf getMiscItemIf(GWT_MiscItem client) throws KKGWTException
{
if (client == null)
{
    return null;
}

MiscItemIf server = new MiscItem();
server.setId(client.getId());
server.setTypeId(client.getTypeId());
server.setObjId(client.getObjId());
server.setItemValue(client.getItemValue());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setType(client.getType());
server.setTypeDescription(client.getTypeDescription());
return server;
}

protected GWT_MqOptions getGWT_MqOptions(MqOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_MqOptions client = new GWT_MqOptions();
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setMsgText(server.getMsgText());
client.setQueueName(server.getQueueName());
client.setUsername(server.getUsername());
client.setPassword(server.getPassword());
client.setBrokerUrl(server.getBrokerUrl());
client.setTimeoutMS(server.getTimeoutMS());
client.setCustomInt1(server.getCustomInt1());
return client;
}

protected MqOptionsIf getMqOptionsIf(GWT_MqOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

MqOptionsIf server = new MqOptions();
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setMsgText(client.getMsgText());
server.setQueueName(client.getQueueName());
server.setUsername(client.getUsername());
server.setPassword(client.getPassword());
server.setBrokerUrl(client.getBrokerUrl());
server.setTimeoutMS(client.getTimeoutMS());
server.setCustomInt1(client.getCustomInt1());
return server;
}

protected GWT_MqResponse getGWT_MqResponse(MqResponseIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_MqResponse client = new GWT_MqResponse();
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setMsgText(server.getMsgText());
client.setTimedout(server.isTimedout());
client.setJMSCorrelationId(server.getJMSCorrelationId());
client.setJMSMessageId(server.getJMSMessageId());
client.setCustomInt1(server.getCustomInt1());
return client;
}

protected MqResponseIf getMqResponseIf(GWT_MqResponse client) throws KKGWTException
{
if (client == null)
{
    return null;
}

MqResponseIf server = new MqResponse();
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setMsgText(client.getMsgText());
server.setTimedout(client.isTimedout());
server.setJMSCorrelationId(client.getJMSCorrelationId());
server.setJMSMessageId(client.getJMSMessageId());
server.setCustomInt1(client.getCustomInt1());
return server;
}

protected GWT_NameNumber getGWT_NameNumber(NameNumberIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_NameNumber client = new GWT_NameNumber();
client.setName(server.getName());
client.setNumber(server.getNumber());
return client;
}

protected NameNumberIf getNameNumberIf(GWT_NameNumber client) throws KKGWTException
{
if (client == null)
{
    return null;
}

NameNumberIf server = new NameNumber();
server.setName(client.getName());
server.setNumber(client.getNumber());
return server;
}

protected GWT_NameValue getGWT_NameValue(NameValueIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_NameValue client = new GWT_NameValue();
client.setName(server.getName());
client.setValue(server.getValue());
return client;
}

protected NameValueIf getNameValueIf(GWT_NameValue client) throws KKGWTException
{
if (client == null)
{
    return null;
}

NameValueIf server = new NameValue();
server.setName(client.getName());
server.setValue(client.getValue());
return server;
}

protected GWT_Option getGWT_Option(OptionIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Option client = new GWT_Option();
client.setName(server.getName());
client.setValue(server.getValue());
client.setValueId(server.getValueId());
client.setId(server.getId());
client.setAttrId(server.getAttrId());
client.setPriceExTax(getDoubleFromBigDecimal(server.getPriceExTax()));
client.setPriceIncTax(getDoubleFromBigDecimal(server.getPriceIncTax()));
client.setPrice0(getDoubleFromBigDecimal(server.getPrice0()));
client.setPrice1(getDoubleFromBigDecimal(server.getPrice1()));
client.setPrice2(getDoubleFromBigDecimal(server.getPrice2()));
client.setPrice3(getDoubleFromBigDecimal(server.getPrice3()));
client.setAttrCustom1(server.getAttrCustom1());
client.setAttrCustom2(server.getAttrCustom2());
client.setOptionCustom1(server.getOptionCustom1());
client.setOptionCustom2(server.getOptionCustom2());
client.setOptionValCustom1(server.getOptionValCustom1());
client.setOptionValCustom2(server.getOptionValCustom2());
client.setType(server.getType());
client.setQuantity(server.getQuantity());
return client;
}

protected OptionIf getOptionIf(GWT_Option client) throws KKGWTException
{
if (client == null)
{
    return null;
}

OptionIf server = new Option();
server.setName(client.getName());
server.setValue(client.getValue());
server.setValueId(client.getValueId());
server.setId(client.getId());
server.setAttrId(client.getAttrId());
server.setPriceExTax(getBigDecimalFromDouble(client.getPriceExTax()));
server.setPriceIncTax(getBigDecimalFromDouble(client.getPriceIncTax()));
server.setPrice0(getBigDecimalFromDouble(client.getPrice0()));
server.setPrice1(getBigDecimalFromDouble(client.getPrice1()));
server.setPrice2(getBigDecimalFromDouble(client.getPrice2()));
server.setPrice3(getBigDecimalFromDouble(client.getPrice3()));
server.setAttrCustom1(client.getAttrCustom1());
server.setAttrCustom2(client.getAttrCustom2());
server.setOptionCustom1(client.getOptionCustom1());
server.setOptionCustom2(client.getOptionCustom2());
server.setOptionValCustom1(client.getOptionValCustom1());
server.setOptionValCustom2(client.getOptionValCustom2());
server.setType(client.getType());
server.setQuantity(client.getQuantity());
return server;
}

protected GWT_Order getGWT_Order(OrderIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Order client = new GWT_Order();
client.setBillingCity(server.getBillingCity());
client.setBillingCompany(server.getBillingCompany());
client.setBillingCountry(server.getBillingCountry());
client.setBillingName(server.getBillingName());
client.setBillingPostcode(server.getBillingPostcode());
client.setBillingState(server.getBillingState());
client.setBillingStreetAddress(server.getBillingStreetAddress());
client.setBillingStreetAddress1(server.getBillingStreetAddress1());
client.setBillingSuburb(server.getBillingSuburb());
client.setCcExpires(server.getCcExpires());
client.setCcNumber(server.getCcNumber());
client.setCcOwner(server.getCcOwner());
client.setCcType(server.getCcType());
client.setCurrencyValue(getDoubleFromBigDecimal(server.getCurrencyValue()));
client.setCustomerCity(server.getCustomerCity());
client.setCustomerCompany(server.getCustomerCompany());
client.setCustomerCountry(server.getCustomerCountry());
client.setCustomerEmail(server.getCustomerEmail());
client.setCustomerName(server.getCustomerName());
client.setCustomerPostcode(server.getCustomerPostcode());
client.setCustomerState(server.getCustomerState());
client.setCustomerStreetAddress(server.getCustomerStreetAddress());
client.setCustomerStreetAddress1(server.getCustomerStreetAddress1());
client.setCustomerSuburb(server.getCustomerSuburb());
client.setCustomerTelephone(server.getCustomerTelephone());
client.setDateFinished(getDateFromCalendar(server.getDateFinished()));
client.setDatePurchased(getDateFromCalendar(server.getDatePurchased()));
client.setDeliveryCity(server.getDeliveryCity());
client.setDeliveryCompany(server.getDeliveryCompany());
client.setDeliveryCountry(server.getDeliveryCountry());
client.setDeliveryName(server.getDeliveryName());
client.setDeliveryPostcode(server.getDeliveryPostcode());
client.setDeliveryState(server.getDeliveryState());
client.setDeliveryStreetAddress(server.getDeliveryStreetAddress());
client.setDeliveryStreetAddress1(server.getDeliveryStreetAddress1());
client.setDeliverySuburb(server.getDeliverySuburb());
client.setId(server.getId());
client.setLastModified(getDateFromCalendar(server.getLastModified()));
client.setPaymentMethod(server.getPaymentMethod());
client.setShippingMethod(server.getShippingMethod());
client.setStatus(server.getStatus());
client.setCustomerId(server.getCustomerId());
client.setBillingAddrFormatId(server.getBillingAddrFormatId());
client.setCustomerAddrFormatId(server.getCustomerAddrFormatId());
client.setDeliveryAddrFormatId(server.getDeliveryAddrFormatId());
if (server.getOrderProducts() == null)
{
client.setOrderProducts(null);
} else
{
GWT_OrderProduct[] clientArray = new GWT_OrderProduct[server.getOrderProducts().length];
for (int i = 0; i < server.getOrderProducts().length; i++)
{
clientArray[i] = getGWT_OrderProduct(server.getOrderProducts()[i]);
}
client.setOrderProducts(clientArray);
}
client.setBillingFormattedAddress(server.getBillingFormattedAddress());
client.setCustomerFormattedAddress(server.getCustomerFormattedAddress());
client.setDeliveryFormattedAddress(server.getDeliveryFormattedAddress());
client.setStatusText(server.getStatusText());
client.setTax(getDoubleFromBigDecimal(server.getTax()));
client.setNumProducts(server.getNumProducts());
client.setBillingAddrFormatTemplate(server.getBillingAddrFormatTemplate());
client.setCustomerAddrFormatTemplate(server.getCustomerAddrFormatTemplate());
client.setDeliveryAddrFormatTemplate(server.getDeliveryAddrFormatTemplate());
if (server.getOrderTotals() == null)
{
client.setOrderTotals(null);
} else
{
GWT_OrderTotal[] clientArray = new GWT_OrderTotal[server.getOrderTotals().length];
for (int i = 0; i < server.getOrderTotals().length; i++)
{
clientArray[i] = getGWT_OrderTotal(server.getOrderTotals()[i]);
}
client.setOrderTotals(clientArray);
}
if (server.getStatusTrail() == null)
{
client.setStatusTrail(null);
} else
{
GWT_OrderStatusHistory[] clientArray = new GWT_OrderStatusHistory[server.getStatusTrail().length];
for (int i = 0; i < server.getStatusTrail().length; i++)
{
clientArray[i] = getGWT_OrderStatusHistory(server.getStatusTrail()[i]);
}
client.setStatusTrail(clientArray);
}
client.setBillingAddrId(server.getBillingAddrId());
client.setCustomerAddrId(server.getCustomerAddrId());
client.setDeliveryAddrId(server.getDeliveryAddrId());
client.setDeliveryCountryObject(getGWT_Country(server.getDeliveryCountryObject()));
client.setDeliveryZoneObject(getGWT_Zone(server.getDeliveryZoneObject()));
client.setTotalExTax(getDoubleFromBigDecimal(server.getTotalExTax()));
client.setTotalIncTax(getDoubleFromBigDecimal(server.getTotalIncTax()));
client.setShippingQuote(getGWT_ShippingQuote(server.getShippingQuote()));
client.setCurrencyCode(server.getCurrencyCode());
client.setCurrency(getGWT_Currency(server.getCurrency()));
if (server.getTaxRateObjectArray() == null)
{
client.setTaxRateObjectArray(null);
} else
{
GWT_TaxRate[] clientArray = new GWT_TaxRate[server.getTaxRateObjectArray().length];
for (int i = 0; i < server.getTaxRateObjectArray().length; i++)
{
clientArray[i] = getGWT_TaxRate(server.getTaxRateObjectArray()[i]);
}
client.setTaxRateObjectArray(clientArray);
}
client.setPaymentDetails(getGWT_PaymentDetails(server.getPaymentDetails()));
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setCouponCode(server.getCouponCode());
client.setSubTotalExTax(getDoubleFromBigDecimal(server.getSubTotalExTax()));
client.setSubTotalIncTax(getDoubleFromBigDecimal(server.getSubTotalIncTax()));
client.setCouponIds(server.getCouponIds());
client.setPromotionIds(server.getPromotionIds());
client.setPaymentModuleCode(server.getPaymentModuleCode());
client.setShippingModuleCode(server.getShippingModuleCode());
client.setOrderNumber(server.getOrderNumber());
client.setLifecycleId(server.getLifecycleId());
client.setTrackingNumber(server.getTrackingNumber());
client.setPointsRedeemed(server.getPointsRedeemed());
client.setPointsAwarded(server.getPointsAwarded());
client.setPointsReservationId(server.getPointsReservationId());
client.setLocale(server.getLocale());
client.setGiftCertCode(server.getGiftCertCode());
client.setInvoiceFilename(server.getInvoiceFilename());
client.setCcCVV(server.getCcCVV());
client.setCustomerTelephone1(server.getCustomerTelephone1());
client.setDeliveryTelephone(server.getDeliveryTelephone());
client.setDeliveryTelephone1(server.getDeliveryTelephone1());
client.setDeliveryEmail(server.getDeliveryEmail());
client.setBillingTelephone(server.getBillingTelephone());
client.setBillingTelephone1(server.getBillingTelephone1());
client.setBillingEmail(server.getBillingEmail());
client.setShippingServiceCode(server.getShippingServiceCode());
client.setCreator(server.getCreator());
return client;
}

protected OrderIf getOrderIf(GWT_Order client) throws KKGWTException
{
if (client == null)
{
    return null;
}

OrderIf server = new Order();
server.setBillingCity(client.getBillingCity());
server.setBillingCompany(client.getBillingCompany());
server.setBillingCountry(client.getBillingCountry());
server.setBillingName(client.getBillingName());
server.setBillingPostcode(client.getBillingPostcode());
server.setBillingState(client.getBillingState());
server.setBillingStreetAddress(client.getBillingStreetAddress());
server.setBillingStreetAddress1(client.getBillingStreetAddress1());
server.setBillingSuburb(client.getBillingSuburb());
server.setCcExpires(client.getCcExpires());
server.setCcNumber(client.getCcNumber());
server.setCcOwner(client.getCcOwner());
server.setCcType(client.getCcType());
server.setCurrencyValue(getBigDecimalFromDouble(client.getCurrencyValue()));
server.setCustomerCity(client.getCustomerCity());
server.setCustomerCompany(client.getCustomerCompany());
server.setCustomerCountry(client.getCustomerCountry());
server.setCustomerEmail(client.getCustomerEmail());
server.setCustomerName(client.getCustomerName());
server.setCustomerPostcode(client.getCustomerPostcode());
server.setCustomerState(client.getCustomerState());
server.setCustomerStreetAddress(client.getCustomerStreetAddress());
server.setCustomerStreetAddress1(client.getCustomerStreetAddress1());
server.setCustomerSuburb(client.getCustomerSuburb());
server.setCustomerTelephone(client.getCustomerTelephone());
server.setDateFinished(getCalendarFromDate(client.getDateFinished()));
server.setDatePurchased(getCalendarFromDate(client.getDatePurchased()));
server.setDeliveryCity(client.getDeliveryCity());
server.setDeliveryCompany(client.getDeliveryCompany());
server.setDeliveryCountry(client.getDeliveryCountry());
server.setDeliveryName(client.getDeliveryName());
server.setDeliveryPostcode(client.getDeliveryPostcode());
server.setDeliveryState(client.getDeliveryState());
server.setDeliveryStreetAddress(client.getDeliveryStreetAddress());
server.setDeliveryStreetAddress1(client.getDeliveryStreetAddress1());
server.setDeliverySuburb(client.getDeliverySuburb());
server.setId(client.getId());
server.setLastModified(getCalendarFromDate(client.getLastModified()));
server.setPaymentMethod(client.getPaymentMethod());
server.setShippingMethod(client.getShippingMethod());
server.setStatus(client.getStatus());
server.setCustomerId(client.getCustomerId());
server.setBillingAddrFormatId(client.getBillingAddrFormatId());
server.setCustomerAddrFormatId(client.getCustomerAddrFormatId());
server.setDeliveryAddrFormatId(client.getDeliveryAddrFormatId());
if (client.getOrderProducts() == null)
{
server.setOrderProducts(null);
} else
{
OrderProductIf[] serverArray = new OrderProductIf[client.getOrderProducts().length];
for (int i = 0; i < client.getOrderProducts().length; i++)
{
serverArray[i] = getOrderProductIf(client.getOrderProducts()[i]);
}
server.setOrderProducts(serverArray);
}
server.setBillingFormattedAddress(client.getBillingFormattedAddress());
server.setCustomerFormattedAddress(client.getCustomerFormattedAddress());
server.setDeliveryFormattedAddress(client.getDeliveryFormattedAddress());
server.setStatusText(client.getStatusText());
server.setTax(getBigDecimalFromDouble(client.getTax()));
server.setNumProducts(client.getNumProducts());
server.setBillingAddrFormatTemplate(client.getBillingAddrFormatTemplate());
server.setCustomerAddrFormatTemplate(client.getCustomerAddrFormatTemplate());
server.setDeliveryAddrFormatTemplate(client.getDeliveryAddrFormatTemplate());
if (client.getOrderTotals() == null)
{
server.setOrderTotals(null);
} else
{
OrderTotalIf[] serverArray = new OrderTotalIf[client.getOrderTotals().length];
for (int i = 0; i < client.getOrderTotals().length; i++)
{
serverArray[i] = getOrderTotalIf(client.getOrderTotals()[i]);
}
server.setOrderTotals(serverArray);
}
if (client.getStatusTrail() == null)
{
server.setStatusTrail(null);
} else
{
OrderStatusHistoryIf[] serverArray = new OrderStatusHistoryIf[client.getStatusTrail().length];
for (int i = 0; i < client.getStatusTrail().length; i++)
{
serverArray[i] = getOrderStatusHistoryIf(client.getStatusTrail()[i]);
}
server.setStatusTrail(serverArray);
}
server.setBillingAddrId(client.getBillingAddrId());
server.setCustomerAddrId(client.getCustomerAddrId());
server.setDeliveryAddrId(client.getDeliveryAddrId());
server.setDeliveryCountryObject(getCountryIf(client.getDeliveryCountryObject()));
server.setDeliveryZoneObject(getZoneIf(client.getDeliveryZoneObject()));
server.setTotalExTax(getBigDecimalFromDouble(client.getTotalExTax()));
server.setTotalIncTax(getBigDecimalFromDouble(client.getTotalIncTax()));
server.setShippingQuote(getShippingQuoteIf(client.getShippingQuote()));
server.setCurrencyCode(client.getCurrencyCode());
server.setCurrency(getCurrencyIf(client.getCurrency()));
if (client.getTaxRateObjectArray() == null)
{
server.setTaxRateObjectArray(null);
} else
{
TaxRateIf[] serverArray = new TaxRateIf[client.getTaxRateObjectArray().length];
for (int i = 0; i < client.getTaxRateObjectArray().length; i++)
{
serverArray[i] = getTaxRateIf(client.getTaxRateObjectArray()[i]);
}
server.setTaxRateObjectArray(serverArray);
}
server.setPaymentDetails(getPaymentDetailsIf(client.getPaymentDetails()));
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setCouponCode(client.getCouponCode());
server.setSubTotalExTax(getBigDecimalFromDouble(client.getSubTotalExTax()));
server.setSubTotalIncTax(getBigDecimalFromDouble(client.getSubTotalIncTax()));
server.setCouponIds(client.getCouponIds());
server.setPromotionIds(client.getPromotionIds());
server.setPaymentModuleCode(client.getPaymentModuleCode());
server.setShippingModuleCode(client.getShippingModuleCode());
server.setOrderNumber(client.getOrderNumber());
server.setLifecycleId(client.getLifecycleId());
server.setTrackingNumber(client.getTrackingNumber());
server.setPointsRedeemed(client.getPointsRedeemed());
server.setPointsAwarded(client.getPointsAwarded());
server.setPointsReservationId(client.getPointsReservationId());
server.setLocale(client.getLocale());
server.setGiftCertCode(client.getGiftCertCode());
server.setInvoiceFilename(client.getInvoiceFilename());
server.setCcCVV(client.getCcCVV());
server.setCustomerTelephone1(client.getCustomerTelephone1());
server.setDeliveryTelephone(client.getDeliveryTelephone());
server.setDeliveryTelephone1(client.getDeliveryTelephone1());
server.setDeliveryEmail(client.getDeliveryEmail());
server.setBillingTelephone(client.getBillingTelephone());
server.setBillingTelephone1(client.getBillingTelephone1());
server.setBillingEmail(client.getBillingEmail());
server.setShippingServiceCode(client.getShippingServiceCode());
server.setCreator(client.getCreator());
return server;
}

protected GWT_OrderProduct getGWT_OrderProduct(OrderProductIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_OrderProduct client = new GWT_OrderProduct();
client.setId(server.getId());
client.setModel(server.getModel());
client.setName(server.getName());
if (server.getOpts() == null)
{
client.setOpts(null);
} else
{
GWT_Option[] clientArray = new GWT_Option[server.getOpts().length];
for (int i = 0; i < server.getOpts().length; i++)
{
clientArray[i] = getGWT_Option(server.getOpts()[i]);
}
client.setOpts(clientArray);
}
client.setOrderId(server.getOrderId());
client.setPrice(getDoubleFromBigDecimal(server.getPrice()));
client.setProduct(getGWT_Product(server.getProduct()));
client.setProductId(server.getProductId());
client.setQuantity(server.getQuantity());
client.setFinalPriceExTax(getDoubleFromBigDecimal(server.getFinalPriceExTax()));
client.setFinalPriceIncTax(getDoubleFromBigDecimal(server.getFinalPriceIncTax()));
client.setTaxRate(getDoubleFromBigDecimal(server.getTaxRate()));
client.setTax(getDoubleFromBigDecimal(server.getTax()));
client.setType(server.getType());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setPrice0(getDoubleFromBigDecimal(server.getPrice0()));
client.setPrice1(getDoubleFromBigDecimal(server.getPrice1()));
client.setPrice2(getDoubleFromBigDecimal(server.getPrice2()));
client.setPrice3(getDoubleFromBigDecimal(server.getPrice3()));
client.setSku(server.getSku());
client.setState(server.getState());
client.setWishListId(server.getWishListId());
client.setWishListItemId(server.getWishListItemId());
client.setDiscountPercent(getDoubleFromBigDecimal(server.getDiscountPercent()));
client.setWeight(getDoubleFromBigDecimal(server.getWeight()));
client.setTaxCode(server.getTaxCode());
return client;
}

protected OrderProductIf getOrderProductIf(GWT_OrderProduct client) throws KKGWTException
{
if (client == null)
{
    return null;
}

OrderProductIf server = new OrderProduct();
server.setId(client.getId());
server.setModel(client.getModel());
server.setName(client.getName());
if (client.getOpts() == null)
{
server.setOpts(null);
} else
{
OptionIf[] serverArray = new OptionIf[client.getOpts().length];
for (int i = 0; i < client.getOpts().length; i++)
{
serverArray[i] = getOptionIf(client.getOpts()[i]);
}
server.setOpts(serverArray);
}
server.setOrderId(client.getOrderId());
server.setPrice(getBigDecimalFromDouble(client.getPrice()));
server.setProduct(getProductIf(client.getProduct()));
server.setProductId(client.getProductId());
server.setQuantity(client.getQuantity());
server.setFinalPriceExTax(getBigDecimalFromDouble(client.getFinalPriceExTax()));
server.setFinalPriceIncTax(getBigDecimalFromDouble(client.getFinalPriceIncTax()));
server.setTaxRate(getBigDecimalFromDouble(client.getTaxRate()));
server.setTax(getBigDecimalFromDouble(client.getTax()));
server.setType(client.getType());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setPrice0(getBigDecimalFromDouble(client.getPrice0()));
server.setPrice1(getBigDecimalFromDouble(client.getPrice1()));
server.setPrice2(getBigDecimalFromDouble(client.getPrice2()));
server.setPrice3(getBigDecimalFromDouble(client.getPrice3()));
server.setSku(client.getSku());
server.setState(client.getState());
server.setWishListId(client.getWishListId());
server.setWishListItemId(client.getWishListItemId());
server.setDiscountPercent(getBigDecimalFromDouble(client.getDiscountPercent()));
server.setWeight(getBigDecimalFromDouble(client.getWeight()));
server.setTaxCode(client.getTaxCode());
return server;
}

protected GWT_OrderSearch getGWT_OrderSearch(OrderSearchIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_OrderSearch client = new GWT_OrderSearch();
client.setDateAddedFrom(getDateFromCalendar(server.getDateAddedFrom()));
client.setDateAddedTo(getDateFromCalendar(server.getDateAddedTo()));
client.setIncludeStatusIds(server.getIncludeStatusIds());
client.setCreator(server.getCreator());
client.setCreatorRule(server.getCreatorRule());
return client;
}

protected OrderSearchIf getOrderSearchIf(GWT_OrderSearch client) throws KKGWTException
{
if (client == null)
{
    return null;
}

OrderSearchIf server = new OrderSearch();
server.setDateAddedFrom(getCalendarFromDate(client.getDateAddedFrom()));
server.setDateAddedTo(getCalendarFromDate(client.getDateAddedTo()));
server.setIncludeStatusIds(client.getIncludeStatusIds());
server.setCreator(client.getCreator());
server.setCreatorRule(client.getCreatorRule());
return server;
}

protected GWT_Orders getGWT_Orders(OrdersIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Orders client = new GWT_Orders();
if (server.getOrderArray() == null)
{
client.setOrderArray(null);
} else
{
GWT_Order[] clientArray = new GWT_Order[server.getOrderArray().length];
for (int i = 0; i < server.getOrderArray().length; i++)
{
clientArray[i] = getGWT_Order(server.getOrderArray()[i]);
}
client.setOrderArray(clientArray);
}
client.setTotalNumOrders(server.getTotalNumOrders());
return client;
}

protected OrdersIf getOrdersIf(GWT_Orders client) throws KKGWTException
{
if (client == null)
{
    return null;
}

OrdersIf server = new Orders();
if (client.getOrderArray() == null)
{
server.setOrderArray(null);
} else
{
OrderIf[] serverArray = new OrderIf[client.getOrderArray().length];
for (int i = 0; i < client.getOrderArray().length; i++)
{
serverArray[i] = getOrderIf(client.getOrderArray()[i]);
}
server.setOrderArray(serverArray);
}
server.setTotalNumOrders(client.getTotalNumOrders());
return server;
}

protected GWT_OrderStatusHistory getGWT_OrderStatusHistory(OrderStatusHistoryIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_OrderStatusHistory client = new GWT_OrderStatusHistory();
client.setComments(server.getComments());
client.setCustomerNotified(server.isCustomerNotified());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setId(server.getId());
client.setOrderId(server.getOrderId());
client.setOrderStatus(server.getOrderStatus());
client.setOrderStatusId(server.getOrderStatusId());
return client;
}

protected OrderStatusHistoryIf getOrderStatusHistoryIf(GWT_OrderStatusHistory client) throws KKGWTException
{
if (client == null)
{
    return null;
}

OrderStatusHistoryIf server = new OrderStatusHistory();
server.setComments(client.getComments());
server.setCustomerNotified(client.isCustomerNotified());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setId(client.getId());
server.setOrderId(client.getOrderId());
server.setOrderStatus(client.getOrderStatus());
server.setOrderStatusId(client.getOrderStatusId());
return server;
}

protected GWT_OrderStatus getGWT_OrderStatus(OrderStatusIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_OrderStatus client = new GWT_OrderStatus();
client.setId(server.getId());
client.setName(server.getName());
client.setLanguageId(server.getLanguageId());
return client;
}

protected OrderStatusIf getOrderStatusIf(GWT_OrderStatus client) throws KKGWTException
{
if (client == null)
{
    return null;
}

OrderStatusIf server = new OrderStatus();
server.setId(client.getId());
server.setName(client.getName());
server.setLanguageId(client.getLanguageId());
return server;
}

protected GWT_OrderTotal getGWT_OrderTotal(OrderTotalIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_OrderTotal client = new GWT_OrderTotal();
client.setClassName(server.getClassName());
client.setId(server.getId());
client.setOrderId(server.getOrderId());
client.setSortOrder(server.getSortOrder());
client.setText(server.getText());
client.setTitle(server.getTitle());
client.setValue(getDoubleFromBigDecimal(server.getValue()));
if (server.getPromotions() == null)
{
client.setPromotions(null);
} else
{
GWT_Promotion[] clientArray = new GWT_Promotion[server.getPromotions().length];
for (int i = 0; i < server.getPromotions().length; i++)
{
clientArray[i] = getGWT_Promotion(server.getPromotions()[i]);
}
client.setPromotions(clientArray);
}
if (server.getOrderTotals() == null)
{
client.setOrderTotals(null);
} else
{
GWT_OrderTotal[] clientArray = new GWT_OrderTotal[server.getOrderTotals().length];
for (int i = 0; i < server.getOrderTotals().length; i++)
{
clientArray[i] = getGWT_OrderTotal(server.getOrderTotals()[i]);
}
client.setOrderTotals(clientArray);
}
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
return client;
}

protected OrderTotalIf getOrderTotalIf(GWT_OrderTotal client) throws KKGWTException
{
if (client == null)
{
    return null;
}

OrderTotalIf server = new OrderTotal();
server.setClassName(client.getClassName());
server.setId(client.getId());
server.setOrderId(client.getOrderId());
server.setSortOrder(client.getSortOrder());
server.setText(client.getText());
server.setTitle(client.getTitle());
server.setValue(getBigDecimalFromDouble(client.getValue()));
if (client.getPromotions() == null)
{
server.setPromotions(null);
} else
{
PromotionIf[] serverArray = new PromotionIf[client.getPromotions().length];
for (int i = 0; i < client.getPromotions().length; i++)
{
serverArray[i] = getPromotionIf(client.getPromotions()[i]);
}
server.setPromotions(serverArray);
}
if (client.getOrderTotals() == null)
{
server.setOrderTotals(null);
} else
{
OrderTotalIf[] serverArray = new OrderTotalIf[client.getOrderTotals().length];
for (int i = 0; i < client.getOrderTotals().length; i++)
{
serverArray[i] = getOrderTotalIf(client.getOrderTotals()[i]);
}
server.setOrderTotals(serverArray);
}
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
return server;
}

protected GWT_PaymentDetails getGWT_PaymentDetails(PaymentDetailsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_PaymentDetails client = new GWT_PaymentDetails();
if (server.getParameters() == null)
{
client.setParameters(null);
} else
{
GWT_NameValue[] clientArray = new GWT_NameValue[server.getParameters().length];
for (int i = 0; i < server.getParameters().length; i++)
{
clientArray[i] = getGWT_NameValue(server.getParameters()[i]);
}
client.setParameters(clientArray);
}
client.setReferrer(server.getReferrer());
client.setPostOrGet(server.getPostOrGet());
client.setRequestUrl(server.getRequestUrl());
client.setCode(server.getCode());
client.setDescription(server.getDescription());
client.setSortOrder(server.getSortOrder());
client.setTitle(server.getTitle());
client.setOrderStatusId(server.getOrderStatusId());
client.setPaymentType(server.getPaymentType());
client.setCcNumber(server.getCcNumber());
client.setCcPostcode(server.getCcPostcode());
client.setCcStreetAddress(server.getCcStreetAddress());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setCcCVV(server.getCcCVV());
client.setCcOwner(server.getCcOwner());
client.setCcType(server.getCcType());
client.setShowAddr(server.isShowAddr());
client.setShowCVV(server.isShowCVV());
client.setShowPostcode(server.isShowPostcode());
client.setShowType(server.isShowType());
client.setCcExpiryMonth(server.getCcExpiryMonth());
client.setCcExpiryYear(server.getCcExpiryYear());
client.setShowOwner(server.isShowOwner());
client.setPreProcessCode(server.getPreProcessCode());
return client;
}

protected PaymentDetailsIf getPaymentDetailsIf(GWT_PaymentDetails client) throws KKGWTException
{
if (client == null)
{
    return null;
}

PaymentDetailsIf server = new PaymentDetails();
if (client.getParameters() == null)
{
server.setParameters(null);
} else
{
NameValueIf[] serverArray = new NameValueIf[client.getParameters().length];
for (int i = 0; i < client.getParameters().length; i++)
{
serverArray[i] = getNameValueIf(client.getParameters()[i]);
}
server.setParameters(serverArray);
}
server.setReferrer(client.getReferrer());
server.setPostOrGet(client.getPostOrGet());
server.setRequestUrl(client.getRequestUrl());
server.setCode(client.getCode());
server.setDescription(client.getDescription());
server.setSortOrder(client.getSortOrder());
server.setTitle(client.getTitle());
server.setOrderStatusId(client.getOrderStatusId());
server.setPaymentType(client.getPaymentType());
server.setCcNumber(client.getCcNumber());
server.setCcPostcode(client.getCcPostcode());
server.setCcStreetAddress(client.getCcStreetAddress());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setCcCVV(client.getCcCVV());
server.setCcOwner(client.getCcOwner());
server.setCcType(client.getCcType());
server.setShowAddr(client.isShowAddr());
server.setShowCVV(client.isShowCVV());
server.setShowPostcode(client.isShowPostcode());
server.setShowType(client.isShowType());
server.setCcExpiryMonth(client.getCcExpiryMonth());
server.setCcExpiryYear(client.getCcExpiryYear());
server.setShowOwner(client.isShowOwner());
server.setPreProcessCode(client.getPreProcessCode());
return server;
}

protected GWT_PaymentSchedule getGWT_PaymentSchedule(PaymentScheduleIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_PaymentSchedule client = new GWT_PaymentSchedule();
client.setId(server.getId());
client.setTimeUnit(server.getTimeUnit());
client.setTimeLength(server.getTimeLength());
client.setDayOfMonth(server.getDayOfMonth());
client.setNumPayments(server.getNumPayments());
client.setNumTrialPayments(server.getNumTrialPayments());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setName(server.getName());
client.setDescription(server.getDescription());
return client;
}

protected PaymentScheduleIf getPaymentScheduleIf(GWT_PaymentSchedule client) throws KKGWTException
{
if (client == null)
{
    return null;
}

PaymentScheduleIf server = new PaymentSchedule();
server.setId(client.getId());
server.setTimeUnit(client.getTimeUnit());
server.setTimeLength(client.getTimeLength());
server.setDayOfMonth(client.getDayOfMonth());
server.setNumPayments(client.getNumPayments());
server.setNumTrialPayments(client.getNumTrialPayments());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setName(client.getName());
server.setDescription(client.getDescription());
return server;
}

protected GWT_PdfOptions getGWT_PdfOptions(PdfOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_PdfOptions client = new GWT_PdfOptions();
client.setId(server.getId());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setLanguageId(server.getLanguageId());
client.setType(server.getType());
client.setReturnFileName(server.isReturnFileName());
client.setReturnBytes(server.isReturnBytes());
client.setCreateFile(server.isCreateFile());
client.setTargetFileName(server.getTargetFileName());
return client;
}

protected PdfOptionsIf getPdfOptionsIf(GWT_PdfOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

PdfOptionsIf server = new PdfOptions();
server.setId(client.getId());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setLanguageId(client.getLanguageId());
server.setType(client.getType());
server.setReturnFileName(client.isReturnFileName());
server.setReturnBytes(client.isReturnBytes());
server.setCreateFile(client.isCreateFile());
server.setTargetFileName(client.getTargetFileName());
return server;
}

protected GWT_PdfResult getGWT_PdfResult(PdfResultIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_PdfResult client = new GWT_PdfResult();
client.setFileName(server.getFileName());
client.setPdfBytes(server.getPdfBytes());
client.setResultCode(server.getResultCode());
client.setFileNameAfterBase(server.getFileNameAfterBase());
return client;
}

protected PdfResultIf getPdfResultIf(GWT_PdfResult client) throws KKGWTException
{
if (client == null)
{
    return null;
}

PdfResultIf server = new PdfResult();
server.setFileName(client.getFileName());
server.setPdfBytes(client.getPdfBytes());
server.setResultCode(client.getResultCode());
server.setFileNameAfterBase(client.getFileNameAfterBase());
return server;
}

protected GWT_ProdCustAttr getGWT_ProdCustAttr(ProdCustAttrIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_ProdCustAttr client = new GWT_ProdCustAttr();
client.setId(server.getId());
client.setName(server.getName());
client.setType(server.getType());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setValue(server.getValue());
client.setMsgCatKey(server.getMsgCatKey());
client.setTemplate(server.getTemplate());
client.setFacetNumber(server.getFacetNumber());
return client;
}

protected ProdCustAttrIf getProdCustAttrIf(GWT_ProdCustAttr client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ProdCustAttrIf server = new ProdCustAttr();
server.setId(client.getId());
server.setName(client.getName());
server.setType(client.getType());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setValue(client.getValue());
server.setMsgCatKey(client.getMsgCatKey());
server.setTemplate(client.getTemplate());
server.setFacetNumber(client.getFacetNumber());
return server;
}

protected GWT_Product getGWT_Product(ProductIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Product client = new GWT_Product();
client.setTaxClassId(server.getTaxClassId());
client.setManufacturerName(server.getManufacturerName());
client.setDescription(server.getDescription());
client.setId(server.getId());
client.setImage(server.getImage());
client.setModel(server.getModel());
client.setName(server.getName());
if (server.getOpts() == null)
{
client.setOpts(null);
} else
{
GWT_Option[] clientArray = new GWT_Option[server.getOpts().length];
for (int i = 0; i < server.getOpts().length; i++)
{
clientArray[i] = getGWT_Option(server.getOpts()[i]);
}
client.setOpts(clientArray);
}
client.setQuantity(server.getQuantity());
client.setStatus(server.getStatus());
client.setUrl(server.getUrl());
client.setViewedCount(server.getViewedCount());
client.setWeight(getDoubleFromBigDecimal(server.getWeight()));
client.setNumberReviews(server.getNumberReviews());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setDateAvailable(getDateFromCalendar(server.getDateAvailable()));
client.setManufacturer(getGWT_Manufacturer(server.getManufacturer()));
client.setManufacturerId(server.getManufacturerId());
client.setCategoryId(server.getCategoryId());
client.setOrdered(server.getOrdered());
client.setPriceExTax(getDoubleFromBigDecimal(server.getPriceExTax()));
client.setSpecialPriceExTax(getDoubleFromBigDecimal(server.getSpecialPriceExTax()));
client.setSpecialPriceIncTax(getDoubleFromBigDecimal(server.getSpecialPriceIncTax()));
client.setPriceIncTax(getDoubleFromBigDecimal(server.getPriceIncTax()));
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setCustom6(server.getCustom6());
client.setCustom7(server.getCustom7());
client.setCustom8(server.getCustom8());
client.setCustom9(server.getCustom9());
client.setCustom10(server.getCustom10());
client.setCustom1Int(server.getCustom1Int());
client.setCustom2Int(server.getCustom2Int());
client.setCustom1Dec(getDoubleFromBigDecimal(server.getCustom1Dec()));
client.setCustom2Dec(getDoubleFromBigDecimal(server.getCustom2Dec()));
client.setProdRelationTypeArray(server.getProdRelationTypeArray());
client.setInvisible(server.getInvisible());
client.setSku(server.getSku());
client.setContentType(server.getContentType());
client.setFilePath(server.getFilePath());
client.setType(server.getType());
client.setImage2(server.getImage2());
client.setImage3(server.getImage3());
client.setImage4(server.getImage4());
client.setComparison(server.getComparison());
client.setPrice0(getDoubleFromBigDecimal(server.getPrice0()));
client.setPrice1(getDoubleFromBigDecimal(server.getPrice1()));
client.setPrice2(getDoubleFromBigDecimal(server.getPrice2()));
client.setPrice3(getDoubleFromBigDecimal(server.getPrice3()));
client.setBundledProdQuantity(server.getBundledProdQuantity());
client.setEncodedOptionValues(server.getEncodedOptionValues());
if (server.getTags() == null)
{
client.setTags(null);
} else
{
GWT_Tag[] clientArray = new GWT_Tag[server.getTags().length];
for (int i = 0; i < server.getTags().length; i++)
{
clientArray[i] = getGWT_Tag(server.getTags()[i]);
}
client.setTags(clientArray);
}
client.setStoreId(server.getStoreId());
client.setMaxNumDownloads(server.getMaxNumDownloads());
client.setMaxDownloadDays(server.getMaxDownloadDays());
client.setStockReorderLevel(server.getStockReorderLevel());
client.setCanOrderWhenNotInStock(server.getCanOrderWhenNotInStock());
client.setIndexAttachment(server.isIndexAttachment());
client.setSnippets(server.getSnippets());
client.setRating(getDoubleFromBigDecimal(server.getRating()));
client.setExpiryDate(getDateFromCalendar(server.getExpiryDate()));
client.setPaymentScheduleId(server.getPaymentScheduleId());
client.setPaymentSchedule(getGWT_PaymentSchedule(server.getPaymentSchedule()));
if (server.getTierPrices() == null)
{
client.setTierPrices(null);
} else
{
GWT_TierPrice[] clientArray = new GWT_TierPrice[server.getTierPrices().length];
for (int i = 0; i < server.getTierPrices().length; i++)
{
clientArray[i] = getGWT_TierPrice(server.getTierPrices()[i]);
}
client.setTierPrices(clientArray);
}
client.setSpecialExpiryDate(getDateFromCalendar(server.getSpecialExpiryDate()));
client.setSpecialStartDate(getDateFromCalendar(server.getSpecialStartDate()));
client.setSpecialStatus(server.getSpecialStatus());
if (server.getProductQuantities() == null)
{
client.setProductQuantities(null);
} else
{
GWT_ProductQuantity[] clientArray = new GWT_ProductQuantity[server.getProductQuantities().length];
for (int i = 0; i < server.getProductQuantities().length; i++)
{
clientArray[i] = getGWT_ProductQuantity(server.getProductQuantities()[i]);
}
client.setProductQuantities(clientArray);
}
if (server.getAddresses() == null)
{
client.setAddresses(null);
} else
{
GWT_Address[] clientArray = new GWT_Address[server.getAddresses().length];
for (int i = 0; i < server.getAddresses().length; i++)
{
clientArray[i] = getGWT_Address(server.getAddresses()[i]);
}
client.setAddresses(clientArray);
}
client.setCustomAttrs(server.getCustomAttrs());
if (server.getCustomAttrArray() == null)
{
client.setCustomAttrArray(null);
} else
{
GWT_ProdCustAttr[] clientArray = new GWT_ProdCustAttr[server.getCustomAttrArray().length];
for (int i = 0; i < server.getCustomAttrArray().length; i++)
{
clientArray[i] = getGWT_ProdCustAttr(server.getCustomAttrArray()[i]);
}
client.setCustomAttrArray(clientArray);
}
client.setTaxCode(server.getTaxCode());
client.setStoreCustom1(server.getStoreCustom1());
client.setStoreCustom2(server.getStoreCustom2());
client.setStoreCustom3(server.getStoreCustom3());
client.setBookableProd(getGWT_BookableProduct(server.getBookableProd()));
if (server.getMiscItems() == null)
{
client.setMiscItems(null);
} else
{
GWT_MiscItem[] clientArray = new GWT_MiscItem[server.getMiscItems().length];
for (int i = 0; i < server.getMiscItems().length; i++)
{
clientArray[i] = getGWT_MiscItem(server.getMiscItems()[i]);
}
client.setMiscItems(clientArray);
}
if (server.getPromotionResults() == null)
{
client.setPromotionResults(null);
} else
{
GWT_PromotionResult[] clientArray = new GWT_PromotionResult[server.getPromotionResults().length];
for (int i = 0; i < server.getPromotionResults().length; i++)
{
clientArray[i] = getGWT_PromotionResult(server.getPromotionResults()[i]);
}
client.setPromotionResults(clientArray);
}
return client;
}

protected ProductIf getProductIf(GWT_Product client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ProductIf server = new Product();
server.setTaxClassId(client.getTaxClassId());
server.setManufacturerName(client.getManufacturerName());
server.setDescription(client.getDescription());
server.setId(client.getId());
server.setImage(client.getImage());
server.setModel(client.getModel());
server.setName(client.getName());
if (client.getOpts() == null)
{
server.setOpts(null);
} else
{
OptionIf[] serverArray = new OptionIf[client.getOpts().length];
for (int i = 0; i < client.getOpts().length; i++)
{
serverArray[i] = getOptionIf(client.getOpts()[i]);
}
server.setOpts(serverArray);
}
server.setQuantity(client.getQuantity());
server.setStatus(client.getStatus());
server.setUrl(client.getUrl());
server.setViewedCount(client.getViewedCount());
server.setWeight(getBigDecimalFromDouble(client.getWeight()));
server.setNumberReviews(client.getNumberReviews());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setDateAvailable(getCalendarFromDate(client.getDateAvailable()));
server.setManufacturer(getManufacturerIf(client.getManufacturer()));
server.setManufacturerId(client.getManufacturerId());
server.setCategoryId(client.getCategoryId());
server.setOrdered(client.getOrdered());
server.setPriceExTax(getBigDecimalFromDouble(client.getPriceExTax()));
server.setSpecialPriceExTax(getBigDecimalFromDouble(client.getSpecialPriceExTax()));
server.setSpecialPriceIncTax(getBigDecimalFromDouble(client.getSpecialPriceIncTax()));
server.setPriceIncTax(getBigDecimalFromDouble(client.getPriceIncTax()));
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setCustom6(client.getCustom6());
server.setCustom7(client.getCustom7());
server.setCustom8(client.getCustom8());
server.setCustom9(client.getCustom9());
server.setCustom10(client.getCustom10());
server.setCustom1Int(client.getCustom1Int());
server.setCustom2Int(client.getCustom2Int());
server.setCustom1Dec(getBigDecimalFromDouble(client.getCustom1Dec()));
server.setCustom2Dec(getBigDecimalFromDouble(client.getCustom2Dec()));
server.setProdRelationTypeArray(client.getProdRelationTypeArray());
server.setInvisible(client.getInvisible());
server.setSku(client.getSku());
server.setContentType(client.getContentType());
server.setFilePath(client.getFilePath());
server.setType(client.getType());
server.setImage2(client.getImage2());
server.setImage3(client.getImage3());
server.setImage4(client.getImage4());
server.setComparison(client.getComparison());
server.setPrice0(getBigDecimalFromDouble(client.getPrice0()));
server.setPrice1(getBigDecimalFromDouble(client.getPrice1()));
server.setPrice2(getBigDecimalFromDouble(client.getPrice2()));
server.setPrice3(getBigDecimalFromDouble(client.getPrice3()));
server.setBundledProdQuantity(client.getBundledProdQuantity());
server.setEncodedOptionValues(client.getEncodedOptionValues());
if (client.getTags() == null)
{
server.setTags(null);
} else
{
TagIf[] serverArray = new TagIf[client.getTags().length];
for (int i = 0; i < client.getTags().length; i++)
{
serverArray[i] = getTagIf(client.getTags()[i]);
}
server.setTags(serverArray);
}
server.setStoreId(client.getStoreId());
server.setMaxNumDownloads(client.getMaxNumDownloads());
server.setMaxDownloadDays(client.getMaxDownloadDays());
server.setStockReorderLevel(client.getStockReorderLevel());
server.setCanOrderWhenNotInStock(client.getCanOrderWhenNotInStock());
server.setIndexAttachment(client.isIndexAttachment());
server.setSnippets(client.getSnippets());
server.setRating(getBigDecimalFromDouble(client.getRating()));
server.setExpiryDate(getCalendarFromDate(client.getExpiryDate()));
server.setPaymentScheduleId(client.getPaymentScheduleId());
server.setPaymentSchedule(getPaymentScheduleIf(client.getPaymentSchedule()));
if (client.getTierPrices() == null)
{
server.setTierPrices(null);
} else
{
TierPriceIf[] serverArray = new TierPriceIf[client.getTierPrices().length];
for (int i = 0; i < client.getTierPrices().length; i++)
{
serverArray[i] = getTierPriceIf(client.getTierPrices()[i]);
}
server.setTierPrices(serverArray);
}
server.setSpecialExpiryDate(getCalendarFromDate(client.getSpecialExpiryDate()));
server.setSpecialStartDate(getCalendarFromDate(client.getSpecialStartDate()));
server.setSpecialStatus(client.getSpecialStatus());
if (client.getProductQuantities() == null)
{
server.setProductQuantities(null);
} else
{
ProductQuantityIf[] serverArray = new ProductQuantityIf[client.getProductQuantities().length];
for (int i = 0; i < client.getProductQuantities().length; i++)
{
serverArray[i] = getProductQuantityIf(client.getProductQuantities()[i]);
}
server.setProductQuantities(serverArray);
}
if (client.getAddresses() == null)
{
server.setAddresses(null);
} else
{
AddressIf[] serverArray = new AddressIf[client.getAddresses().length];
for (int i = 0; i < client.getAddresses().length; i++)
{
serverArray[i] = getAddressIf(client.getAddresses()[i]);
}
server.setAddresses(serverArray);
}
server.setCustomAttrs(client.getCustomAttrs());
if (client.getCustomAttrArray() == null)
{
server.setCustomAttrArray(null);
} else
{
ProdCustAttrIf[] serverArray = new ProdCustAttrIf[client.getCustomAttrArray().length];
for (int i = 0; i < client.getCustomAttrArray().length; i++)
{
serverArray[i] = getProdCustAttrIf(client.getCustomAttrArray()[i]);
}
server.setCustomAttrArray(serverArray);
}
server.setTaxCode(client.getTaxCode());
server.setStoreCustom1(client.getStoreCustom1());
server.setStoreCustom2(client.getStoreCustom2());
server.setStoreCustom3(client.getStoreCustom3());
server.setBookableProd(getBookableProductIf(client.getBookableProd()));
if (client.getMiscItems() == null)
{
server.setMiscItems(null);
} else
{
MiscItemIf[] serverArray = new MiscItemIf[client.getMiscItems().length];
for (int i = 0; i < client.getMiscItems().length; i++)
{
serverArray[i] = getMiscItemIf(client.getMiscItems()[i]);
}
server.setMiscItems(serverArray);
}
if (client.getPromotionResults() == null)
{
server.setPromotionResults(null);
} else
{
PromotionResultIf[] serverArray = new PromotionResultIf[client.getPromotionResults().length];
for (int i = 0; i < client.getPromotionResults().length; i++)
{
serverArray[i] = getPromotionResultIf(client.getPromotionResults()[i]);
}
server.setPromotionResults(serverArray);
}
return server;
}

protected GWT_ProductQuantity getGWT_ProductQuantity(ProductQuantityIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_ProductQuantity client = new GWT_ProductQuantity();
client.setEncodedOptionValues(server.getEncodedOptionValues());
client.setProductId(server.getProductId());
client.setQuantity(server.getQuantity());
client.setDateAvailable(getDateFromCalendar(server.getDateAvailable()));
client.setSku(server.getSku());
if (server.getOpts() == null)
{
client.setOpts(null);
} else
{
GWT_Option[] clientArray = new GWT_Option[server.getOpts().length];
for (int i = 0; i < server.getOpts().length; i++)
{
clientArray[i] = getGWT_Option(server.getOpts()[i]);
}
client.setOpts(clientArray);
}
if (server.getPromotionResults() == null)
{
client.setPromotionResults(null);
} else
{
GWT_PromotionResult[] clientArray = new GWT_PromotionResult[server.getPromotionResults().length];
for (int i = 0; i < server.getPromotionResults().length; i++)
{
clientArray[i] = getGWT_PromotionResult(server.getPromotionResults()[i]);
}
client.setPromotionResults(clientArray);
}
return client;
}

protected ProductQuantityIf getProductQuantityIf(GWT_ProductQuantity client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ProductQuantityIf server = new ProductQuantity();
server.setEncodedOptionValues(client.getEncodedOptionValues());
server.setProductId(client.getProductId());
server.setQuantity(client.getQuantity());
server.setDateAvailable(getCalendarFromDate(client.getDateAvailable()));
server.setSku(client.getSku());
if (client.getOpts() == null)
{
server.setOpts(null);
} else
{
OptionIf[] serverArray = new OptionIf[client.getOpts().length];
for (int i = 0; i < client.getOpts().length; i++)
{
serverArray[i] = getOptionIf(client.getOpts()[i]);
}
server.setOpts(serverArray);
}
if (client.getPromotionResults() == null)
{
server.setPromotionResults(null);
} else
{
PromotionResultIf[] serverArray = new PromotionResultIf[client.getPromotionResults().length];
for (int i = 0; i < client.getPromotionResults().length; i++)
{
serverArray[i] = getPromotionResultIf(client.getPromotionResults()[i]);
}
server.setPromotionResults(serverArray);
}
return server;
}

protected GWT_ProductSearch getGWT_ProductSearch(ProductSearchIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_ProductSearch client = new GWT_ProductSearch();
client.setCategoryId(server.getCategoryId());
client.setManufacturerId(server.getManufacturerId());
client.setPriceFrom(getDoubleFromBigDecimal(server.getPriceFrom()));
client.setPriceTo(getDoubleFromBigDecimal(server.getPriceTo()));
client.setSearchText(server.getSearchText());
client.setWhereToSearch(server.getWhereToSearch());
client.setDateAddedFrom(getDateFromCalendar(server.getDateAddedFrom()));
client.setDateAddedTo(getDateFromCalendar(server.getDateAddedTo()));
client.setSearchInSubCats(server.isSearchInSubCats());
if (server.getTagGroups() == null)
{
client.setTagGroups(null);
} else
{
GWT_TagGroup[] clientArray = new GWT_TagGroup[server.getTagGroups().length];
for (int i = 0; i < server.getTagGroups().length; i++)
{
clientArray[i] = getGWT_TagGroup(server.getTagGroups()[i]);
}
client.setTagGroups(clientArray);
}
client.setSearchAllStores(server.isSearchAllStores());
client.setStoresToSearch(server.getStoresToSearch());
client.setSnippetOptions(getGWT_SnippetOptions(server.getSnippetOptions()));
client.setRatingGreaterThan(getDoubleFromBigDecimal(server.getRatingGreaterThan()));
client.setRatingLessThan(getDoubleFromBigDecimal(server.getRatingLessThan()));
client.setRatingEqual(getDoubleFromBigDecimal(server.getRatingEqual()));
client.setDateAvailableTo(getDateFromCalendar(server.getDateAvailableTo()));
client.setDateAvailableFrom(getDateFromCalendar(server.getDateAvailableFrom()));
client.setExpiryDateTo(getDateFromCalendar(server.getExpiryDateTo()));
client.setExpiryDateFrom(getDateFromCalendar(server.getExpiryDateFrom()));
client.setFillDescription(server.isFillDescription());
client.setSearchTextRule(server.getSearchTextRule());
client.setQuantityGreaterThan(server.getQuantityGreaterThan());
client.setQuantityLessThan(server.getQuantityLessThan());
client.setQuantityEqual(server.getQuantityEqual());
client.setStartDateFrom(getDateFromCalendar(server.getStartDateFrom()));
client.setStartDateTo(getDateFromCalendar(server.getStartDateTo()));
client.setEndDateFrom(getDateFromCalendar(server.getEndDateFrom()));
client.setEndDateTo(getDateFromCalendar(server.getEndDateTo()));
client.setOverlapStartDate(getDateFromCalendar(server.getOverlapStartDate()));
client.setOverlapEndDate(getDateFromCalendar(server.getOverlapEndDate()));
client.setProductType(server.getProductType());
client.setReturnManufacturerFacets(server.isReturnManufacturerFacets());
client.setReturnCategoryFacets(server.isReturnCategoryFacets());
client.setManufacturerIds(server.getManufacturerIds());
client.setCategoryIds(server.getCategoryIds());
client.setOrderedGreaterThan(server.getOrderedGreaterThan());
client.setOrderedLessThan(server.getOrderedLessThan());
client.setOrderedEqual(server.getOrderedEqual());
client.setReturnCustomFacets(server.isReturnCustomFacets());
return client;
}

protected ProductSearchIf getProductSearchIf(GWT_ProductSearch client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ProductSearchIf server = new ProductSearch();
server.setCategoryId(client.getCategoryId());
server.setManufacturerId(client.getManufacturerId());
server.setPriceFrom(getBigDecimalFromDouble(client.getPriceFrom()));
server.setPriceTo(getBigDecimalFromDouble(client.getPriceTo()));
server.setSearchText(client.getSearchText());
server.setWhereToSearch(client.getWhereToSearch());
server.setDateAddedFrom(getCalendarFromDate(client.getDateAddedFrom()));
server.setDateAddedTo(getCalendarFromDate(client.getDateAddedTo()));
server.setSearchInSubCats(client.isSearchInSubCats());
if (client.getTagGroups() == null)
{
server.setTagGroups(null);
} else
{
TagGroupIf[] serverArray = new TagGroupIf[client.getTagGroups().length];
for (int i = 0; i < client.getTagGroups().length; i++)
{
serverArray[i] = getTagGroupIf(client.getTagGroups()[i]);
}
server.setTagGroups(serverArray);
}
server.setSearchAllStores(client.isSearchAllStores());
server.setStoresToSearch(client.getStoresToSearch());
server.setSnippetOptions(getSnippetOptionsIf(client.getSnippetOptions()));
server.setRatingGreaterThan(getBigDecimalFromDouble(client.getRatingGreaterThan()));
server.setRatingLessThan(getBigDecimalFromDouble(client.getRatingLessThan()));
server.setRatingEqual(getBigDecimalFromDouble(client.getRatingEqual()));
server.setDateAvailableTo(getCalendarFromDate(client.getDateAvailableTo()));
server.setDateAvailableFrom(getCalendarFromDate(client.getDateAvailableFrom()));
server.setExpiryDateTo(getCalendarFromDate(client.getExpiryDateTo()));
server.setExpiryDateFrom(getCalendarFromDate(client.getExpiryDateFrom()));
server.setFillDescription(client.isFillDescription());
server.setSearchTextRule(client.getSearchTextRule());
server.setQuantityGreaterThan(client.getQuantityGreaterThan());
server.setQuantityLessThan(client.getQuantityLessThan());
server.setQuantityEqual(client.getQuantityEqual());
server.setStartDateFrom(getCalendarFromDate(client.getStartDateFrom()));
server.setStartDateTo(getCalendarFromDate(client.getStartDateTo()));
server.setEndDateFrom(getCalendarFromDate(client.getEndDateFrom()));
server.setEndDateTo(getCalendarFromDate(client.getEndDateTo()));
server.setOverlapStartDate(getCalendarFromDate(client.getOverlapStartDate()));
server.setOverlapEndDate(getCalendarFromDate(client.getOverlapEndDate()));
server.setProductType(client.getProductType());
server.setReturnManufacturerFacets(client.isReturnManufacturerFacets());
server.setReturnCategoryFacets(client.isReturnCategoryFacets());
server.setManufacturerIds(client.getManufacturerIds());
server.setCategoryIds(client.getCategoryIds());
server.setOrderedGreaterThan(client.getOrderedGreaterThan());
server.setOrderedLessThan(client.getOrderedLessThan());
server.setOrderedEqual(client.getOrderedEqual());
server.setReturnCustomFacets(client.isReturnCustomFacets());
return server;
}

protected GWT_Products getGWT_Products(ProductsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Products client = new GWT_Products();
if (server.getProductArray() == null)
{
client.setProductArray(null);
} else
{
GWT_Product[] clientArray = new GWT_Product[server.getProductArray().length];
for (int i = 0; i < server.getProductArray().length; i++)
{
clientArray[i] = getGWT_Product(server.getProductArray()[i]);
}
client.setProductArray(clientArray);
}
client.setTotalNumProducts(server.getTotalNumProducts());
if (server.getManufacturerFacets() == null)
{
client.setManufacturerFacets(null);
} else
{
GWT_Manufacturer[] clientArray = new GWT_Manufacturer[server.getManufacturerFacets().length];
for (int i = 0; i < server.getManufacturerFacets().length; i++)
{
clientArray[i] = getGWT_Manufacturer(server.getManufacturerFacets()[i]);
}
client.setManufacturerFacets(clientArray);
}
if (server.getCategoryFacets() == null)
{
client.setCategoryFacets(null);
} else
{
GWT_Category[] clientArray = new GWT_Category[server.getCategoryFacets().length];
for (int i = 0; i < server.getCategoryFacets().length; i++)
{
clientArray[i] = getGWT_Category(server.getCategoryFacets()[i]);
}
client.setCategoryFacets(clientArray);
}
if (server.getCustomFacets() == null)
{
client.setCustomFacets(null);
} else
{
GWT_KKFacet[] clientArray = new GWT_KKFacet[server.getCustomFacets().length];
for (int i = 0; i < server.getCustomFacets().length; i++)
{
clientArray[i] = getGWT_KKFacet(server.getCustomFacets()[i]);
}
client.setCustomFacets(clientArray);
}
return client;
}

protected ProductsIf getProductsIf(GWT_Products client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ProductsIf server = new Products();
if (client.getProductArray() == null)
{
server.setProductArray(null);
} else
{
ProductIf[] serverArray = new ProductIf[client.getProductArray().length];
for (int i = 0; i < client.getProductArray().length; i++)
{
serverArray[i] = getProductIf(client.getProductArray()[i]);
}
server.setProductArray(serverArray);
}
server.setTotalNumProducts(client.getTotalNumProducts());
if (client.getManufacturerFacets() == null)
{
server.setManufacturerFacets(null);
} else
{
ManufacturerIf[] serverArray = new ManufacturerIf[client.getManufacturerFacets().length];
for (int i = 0; i < client.getManufacturerFacets().length; i++)
{
serverArray[i] = getManufacturerIf(client.getManufacturerFacets()[i]);
}
server.setManufacturerFacets(serverArray);
}
if (client.getCategoryFacets() == null)
{
server.setCategoryFacets(null);
} else
{
CategoryIf[] serverArray = new CategoryIf[client.getCategoryFacets().length];
for (int i = 0; i < client.getCategoryFacets().length; i++)
{
serverArray[i] = getCategoryIf(client.getCategoryFacets()[i]);
}
server.setCategoryFacets(serverArray);
}
if (client.getCustomFacets() == null)
{
server.setCustomFacets(null);
} else
{
KKFacetIf[] serverArray = new KKFacetIf[client.getCustomFacets().length];
for (int i = 0; i < client.getCustomFacets().length; i++)
{
serverArray[i] = getKKFacetIf(client.getCustomFacets()[i]);
}
server.setCustomFacets(serverArray);
}
return server;
}

protected GWT_Promotion getGWT_Promotion(PromotionIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Promotion client = new GWT_Promotion();
client.setActive(server.isActive());
client.setCumulative(server.isCumulative());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setCustom6(server.getCustom6());
client.setCustom7(server.getCustom7());
client.setCustom8(server.getCustom8());
client.setCustom9(server.getCustom9());
client.setCustom10(server.getCustom10());
client.setId(server.getId());
client.setOrderTotalCode(server.getOrderTotalCode());
client.setName(server.getName());
client.setDescription(server.getDescription());
client.setCategoryRule(server.getCategoryRule());
client.setCustomerRule(server.getCustomerRule());
client.setCustomerGroupRule(server.getCustomerGroupRule());
client.setManufacturerRule(server.getManufacturerRule());
client.setProductRule(server.getProductRule());
if (server.getApplicableProducts() == null)
{
client.setApplicableProducts(null);
} else
{
GWT_OrderProduct[] clientArray = new GWT_OrderProduct[server.getApplicableProducts().length];
for (int i = 0; i < server.getApplicableProducts().length; i++)
{
clientArray[i] = getGWT_OrderProduct(server.getApplicableProducts()[i]);
}
client.setApplicableProducts(clientArray);
}
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setEndDate(getDateFromCalendar(server.getEndDate()));
client.setLastModified(getDateFromCalendar(server.getLastModified()));
client.setStartDate(getDateFromCalendar(server.getStartDate()));
client.setCoupon(getGWT_Coupon(server.getCoupon()));
client.setMaxUse(server.getMaxUse());
client.setRequiresCoupon(server.isRequiresCoupon());
return client;
}

protected PromotionIf getPromotionIf(GWT_Promotion client) throws KKGWTException
{
if (client == null)
{
    return null;
}

PromotionIf server = new Promotion();
server.setActive(client.isActive());
server.setCumulative(client.isCumulative());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setCustom6(client.getCustom6());
server.setCustom7(client.getCustom7());
server.setCustom8(client.getCustom8());
server.setCustom9(client.getCustom9());
server.setCustom10(client.getCustom10());
server.setId(client.getId());
server.setOrderTotalCode(client.getOrderTotalCode());
server.setName(client.getName());
server.setDescription(client.getDescription());
server.setCategoryRule(client.getCategoryRule());
server.setCustomerRule(client.getCustomerRule());
server.setCustomerGroupRule(client.getCustomerGroupRule());
server.setManufacturerRule(client.getManufacturerRule());
server.setProductRule(client.getProductRule());
if (client.getApplicableProducts() == null)
{
server.setApplicableProducts(null);
} else
{
OrderProductIf[] serverArray = new OrderProductIf[client.getApplicableProducts().length];
for (int i = 0; i < client.getApplicableProducts().length; i++)
{
serverArray[i] = getOrderProductIf(client.getApplicableProducts()[i]);
}
server.setApplicableProducts(serverArray);
}
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setEndDate(getCalendarFromDate(client.getEndDate()));
server.setLastModified(getCalendarFromDate(client.getLastModified()));
server.setStartDate(getCalendarFromDate(client.getStartDate()));
server.setCoupon(getCouponIf(client.getCoupon()));
server.setMaxUse(client.getMaxUse());
server.setRequiresCoupon(client.isRequiresCoupon());
return server;
}

protected GWT_PromotionOptions getGWT_PromotionOptions(PromotionOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_PromotionOptions client = new GWT_PromotionOptions();
client.setPromotionRule(server.getPromotionRule());
client.setSubtractValueFromPriceExTax(server.isSubtractValueFromPriceExTax());
client.setSubtractValueFromPriceIncTax(server.isSubtractValueFromPriceIncTax());
return client;
}

protected PromotionOptionsIf getPromotionOptionsIf(GWT_PromotionOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

PromotionOptionsIf server = new PromotionOptions();
server.setPromotionRule(client.getPromotionRule());
server.setSubtractValueFromPriceExTax(client.isSubtractValueFromPriceExTax());
server.setSubtractValueFromPriceIncTax(client.isSubtractValueFromPriceIncTax());
return server;
}

protected GWT_PromotionProduct getGWT_PromotionProduct(PromotionProductIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_PromotionProduct client = new GWT_PromotionProduct();
client.setOptionId(server.getOptionId());
client.setOptionValueId(server.getOptionValueId());
client.setProductId(server.getProductId());
return client;
}

protected PromotionProductIf getPromotionProductIf(GWT_PromotionProduct client) throws KKGWTException
{
if (client == null)
{
    return null;
}

PromotionProductIf server = new PromotionProduct();
server.setOptionId(client.getOptionId());
server.setOptionValueId(client.getOptionValueId());
server.setProductId(client.getProductId());
return server;
}

protected GWT_PromotionResult getGWT_PromotionResult(PromotionResultIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_PromotionResult client = new GWT_PromotionResult();
client.setPromotionId(server.getPromotionId());
client.setOrderTotalCode(server.getOrderTotalCode());
client.setValue(getDoubleFromBigDecimal(server.getValue()));
client.setPercentageDiscount(server.isPercentageDiscount());
client.setApplyBeforeTax(server.isApplyBeforeTax());
return client;
}

protected PromotionResultIf getPromotionResultIf(GWT_PromotionResult client) throws KKGWTException
{
if (client == null)
{
    return null;
}

PromotionResultIf server = new PromotionResult();
server.setPromotionId(client.getPromotionId());
server.setOrderTotalCode(client.getOrderTotalCode());
server.setValue(getBigDecimalFromDouble(client.getValue()));
server.setPercentageDiscount(client.isPercentageDiscount());
server.setApplyBeforeTax(client.isApplyBeforeTax());
return server;
}

protected GWT_Review getGWT_Review(ReviewIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Review client = new GWT_Review();
client.setCustomerId(server.getCustomerId());
client.setCustomerName(server.getCustomerName());
client.setId(server.getId());
client.setLanguageId(server.getLanguageId());
client.setLanguageName(server.getLanguageName());
client.setProductId(server.getProductId());
client.setRating(server.getRating());
client.setAverageRating(getDoubleFromBigDecimal(server.getAverageRating()));
client.setReviewText(server.getReviewText());
client.setTimesRead(server.getTimesRead());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setProduct(getGWT_Product(server.getProduct()));
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
return client;
}

protected ReviewIf getReviewIf(GWT_Review client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ReviewIf server = new Review();
server.setCustomerId(client.getCustomerId());
server.setCustomerName(client.getCustomerName());
server.setId(client.getId());
server.setLanguageId(client.getLanguageId());
server.setLanguageName(client.getLanguageName());
server.setProductId(client.getProductId());
server.setRating(client.getRating());
server.setAverageRating(getBigDecimalFromDouble(client.getAverageRating()));
server.setReviewText(client.getReviewText());
server.setTimesRead(client.getTimesRead());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setProduct(getProductIf(client.getProduct()));
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
return server;
}

protected GWT_Reviews getGWT_Reviews(ReviewsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Reviews client = new GWT_Reviews();
if (server.getReviewArray() == null)
{
client.setReviewArray(null);
} else
{
GWT_Review[] clientArray = new GWT_Review[server.getReviewArray().length];
for (int i = 0; i < server.getReviewArray().length; i++)
{
clientArray[i] = getGWT_Review(server.getReviewArray()[i]);
}
client.setReviewArray(clientArray);
}
client.setTotalNumReviews(server.getTotalNumReviews());
return client;
}

protected ReviewsIf getReviewsIf(GWT_Reviews client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ReviewsIf server = new Reviews();
if (client.getReviewArray() == null)
{
server.setReviewArray(null);
} else
{
ReviewIf[] serverArray = new ReviewIf[client.getReviewArray().length];
for (int i = 0; i < client.getReviewArray().length; i++)
{
serverArray[i] = getReviewIf(client.getReviewArray()[i]);
}
server.setReviewArray(serverArray);
}
server.setTotalNumReviews(client.getTotalNumReviews());
return server;
}

protected GWT_RewardPoint getGWT_RewardPoint(RewardPointIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_RewardPoint client = new GWT_RewardPoint();
client.setId(server.getId());
client.setStoreId(server.getStoreId());
client.setCode(server.getCode());
client.setDescription(server.getDescription());
client.setCustomerId(server.getCustomerId());
client.setInitialPoints(server.getInitialPoints());
client.setRemainingPoints(server.getRemainingPoints());
client.setExpired(server.isExpired());
client.setTransactionType(server.getTransactionType());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
return client;
}

protected RewardPointIf getRewardPointIf(GWT_RewardPoint client) throws KKGWTException
{
if (client == null)
{
    return null;
}

RewardPointIf server = new RewardPoint();
server.setId(client.getId());
server.setStoreId(client.getStoreId());
server.setCode(client.getCode());
server.setDescription(client.getDescription());
server.setCustomerId(client.getCustomerId());
server.setInitialPoints(client.getInitialPoints());
server.setRemainingPoints(client.getRemainingPoints());
server.setExpired(client.isExpired());
server.setTransactionType(client.getTransactionType());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
return server;
}

protected GWT_RewardPoints getGWT_RewardPoints(RewardPointsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_RewardPoints client = new GWT_RewardPoints();
client.setTotalNumRecords(server.getTotalNumRecords());
if (server.getRewardPointArray() == null)
{
client.setRewardPointArray(null);
} else
{
GWT_RewardPoint[] clientArray = new GWT_RewardPoint[server.getRewardPointArray().length];
for (int i = 0; i < server.getRewardPointArray().length; i++)
{
clientArray[i] = getGWT_RewardPoint(server.getRewardPointArray()[i]);
}
client.setRewardPointArray(clientArray);
}
return client;
}

protected RewardPointsIf getRewardPointsIf(GWT_RewardPoints client) throws KKGWTException
{
if (client == null)
{
    return null;
}

RewardPointsIf server = new RewardPoints();
server.setTotalNumRecords(client.getTotalNumRecords());
if (client.getRewardPointArray() == null)
{
server.setRewardPointArray(null);
} else
{
RewardPointIf[] serverArray = new RewardPointIf[client.getRewardPointArray().length];
for (int i = 0; i < client.getRewardPointArray().length; i++)
{
serverArray[i] = getRewardPointIf(client.getRewardPointArray()[i]);
}
server.setRewardPointArray(serverArray);
}
return server;
}

protected GWT_ShippingQuote getGWT_ShippingQuote(ShippingQuoteIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_ShippingQuote client = new GWT_ShippingQuote();
client.setCode(server.getCode());
client.setModuleCode(server.getModuleCode());
client.setDescription(server.getDescription());
client.setIcon(server.getIcon());
client.setSortOrder(server.getSortOrder());
client.setTitle(server.getTitle());
client.setHandlingCost(getDoubleFromBigDecimal(server.getHandlingCost()));
client.setTax(getDoubleFromBigDecimal(server.getTax()));
client.setResponseText(server.getResponseText());
client.setCost(getDoubleFromBigDecimal(server.getCost()));
client.setFree(server.isFree());
client.setFreeShippingOver(getDoubleFromBigDecimal(server.getFreeShippingOver()));
client.setTaxClass(server.getTaxClass());
client.setTotalExTax(getDoubleFromBigDecimal(server.getTotalExTax()));
client.setTotalIncTax(getDoubleFromBigDecimal(server.getTotalIncTax()));
if (server.getQuotes() == null)
{
client.setQuotes(null);
} else
{
GWT_ShippingQuote[] clientArray = new GWT_ShippingQuote[server.getQuotes().length];
for (int i = 0; i < server.getQuotes().length; i++)
{
clientArray[i] = getGWT_ShippingQuote(server.getQuotes()[i]);
}
client.setQuotes(clientArray);
}
client.setShippingServiceCode(server.getShippingServiceCode());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
return client;
}

protected ShippingQuoteIf getShippingQuoteIf(GWT_ShippingQuote client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ShippingQuoteIf server = new ShippingQuote();
server.setCode(client.getCode());
server.setModuleCode(client.getModuleCode());
server.setDescription(client.getDescription());
server.setIcon(client.getIcon());
server.setSortOrder(client.getSortOrder());
server.setTitle(client.getTitle());
server.setHandlingCost(getBigDecimalFromDouble(client.getHandlingCost()));
server.setTax(getBigDecimalFromDouble(client.getTax()));
server.setResponseText(client.getResponseText());
server.setCost(getBigDecimalFromDouble(client.getCost()));
server.setFree(client.isFree());
server.setFreeShippingOver(getBigDecimalFromDouble(client.getFreeShippingOver()));
server.setTaxClass(client.getTaxClass());
server.setTotalExTax(getBigDecimalFromDouble(client.getTotalExTax()));
server.setTotalIncTax(getBigDecimalFromDouble(client.getTotalIncTax()));
if (client.getQuotes() == null)
{
server.setQuotes(null);
} else
{
ShippingQuoteIf[] serverArray = new ShippingQuoteIf[client.getQuotes().length];
for (int i = 0; i < client.getQuotes().length; i++)
{
serverArray[i] = getShippingQuoteIf(client.getQuotes()[i]);
}
server.setQuotes(serverArray);
}
server.setShippingServiceCode(client.getShippingServiceCode());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
return server;
}

protected GWT_SnippetOptions getGWT_SnippetOptions(SnippetOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_SnippetOptions client = new GWT_SnippetOptions();
client.setEnableSnippets(server.isEnableSnippets());
client.setNumberOfSnippets(server.getNumberOfSnippets());
client.setSnippetSizeInChars(server.getSnippetSizeInChars());
client.setPreKeywordHighlight(server.getPreKeywordHighlight());
client.setPostKeywordHighlight(server.getPostKeywordHighlight());
client.setEscapeHTML(server.isEscapeHTML());
return client;
}

protected SnippetOptionsIf getSnippetOptionsIf(GWT_SnippetOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

SnippetOptionsIf server = new SnippetOptions();
server.setEnableSnippets(client.isEnableSnippets());
server.setNumberOfSnippets(client.getNumberOfSnippets());
server.setSnippetSizeInChars(client.getSnippetSizeInChars());
server.setPreKeywordHighlight(client.getPreKeywordHighlight());
server.setPostKeywordHighlight(client.getPostKeywordHighlight());
server.setEscapeHTML(client.isEscapeHTML());
return server;
}

protected GWT_SSOToken getGWT_SSOToken(SSOTokenIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_SSOToken client = new GWT_SSOToken();
client.setId(server.getId());
client.setCustomerId(server.getCustomerId());
client.setSecretKey(server.getSecretKey());
client.setSessionId(server.getSessionId());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
return client;
}

protected SSOTokenIf getSSOTokenIf(GWT_SSOToken client) throws KKGWTException
{
if (client == null)
{
    return null;
}

SSOTokenIf server = new SSOToken();
server.setId(client.getId());
server.setCustomerId(client.getCustomerId());
server.setSecretKey(client.getSecretKey());
server.setSessionId(client.getSessionId());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
return server;
}

protected GWT_Store getGWT_Store(StoreIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Store client = new GWT_Store();
client.setStoreId(server.getStoreId());
client.setStoreName(server.getStoreName());
client.setDeleted(server.isDeleted());
client.setLastUpdated(getDateFromCalendar(server.getLastUpdated()));
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setStoreDesc(server.getStoreDesc());
client.setLogoFileName(server.getLogoFileName());
client.setCssFileName(server.getCssFileName());
client.setEnabled(server.isEnabled());
client.setUnderMaintenance(server.isUnderMaintenance());
client.setAdminEmail(server.getAdminEmail());
client.setTemplate(server.isTemplate());
client.setMaxProducts(server.getMaxProducts());
client.setStoreHome(server.getStoreHome());
client.setStoreUrl(server.getStoreUrl());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
return client;
}

protected StoreIf getStoreIf(GWT_Store client) throws KKGWTException
{
if (client == null)
{
    return null;
}

StoreIf server = new Store();
server.setStoreId(client.getStoreId());
server.setStoreName(client.getStoreName());
server.setDeleted(client.isDeleted());
server.setLastUpdated(getCalendarFromDate(client.getLastUpdated()));
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setStoreDesc(client.getStoreDesc());
server.setLogoFileName(client.getLogoFileName());
server.setCssFileName(client.getCssFileName());
server.setEnabled(client.isEnabled());
server.setUnderMaintenance(client.isUnderMaintenance());
server.setAdminEmail(client.getAdminEmail());
server.setTemplate(client.isTemplate());
server.setMaxProducts(client.getMaxProducts());
server.setStoreHome(client.getStoreHome());
server.setStoreUrl(client.getStoreUrl());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
return server;
}

protected GWT_Subscription getGWT_Subscription(SubscriptionIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Subscription client = new GWT_Subscription();
client.setId(server.getId());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setLastModified(getDateFromCalendar(server.getLastModified()));
client.setOrderId(server.getOrderId());
client.setProductId(server.getProductId());
client.setSubscriptionCode(server.getSubscriptionCode());
client.setStartDate(getDateFromCalendar(server.getStartDate()));
client.setAmount(getDoubleFromBigDecimal(server.getAmount()));
client.setTrialAmount(getDoubleFromBigDecimal(server.getTrialAmount()));
client.setActive(server.isActive());
client.setProblem(server.isProblem());
client.setProblemDesc(server.getProblemDesc());
client.setLastBillingDate(getDateFromCalendar(server.getLastBillingDate()));
client.setNextBillingDate(getDateFromCalendar(server.getNextBillingDate()));
client.setPaymentSchedule(getGWT_PaymentSchedule(server.getPaymentSchedule()));
client.setPaymentScheduleId(server.getPaymentScheduleId());
client.setOrderNumber(server.getOrderNumber());
client.setProductSku(server.getProductSku());
client.setCustomerId(server.getCustomerId());
return client;
}

protected SubscriptionIf getSubscriptionIf(GWT_Subscription client) throws KKGWTException
{
if (client == null)
{
    return null;
}

SubscriptionIf server = new Subscription();
server.setId(client.getId());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setLastModified(getCalendarFromDate(client.getLastModified()));
server.setOrderId(client.getOrderId());
server.setProductId(client.getProductId());
server.setSubscriptionCode(client.getSubscriptionCode());
server.setStartDate(getCalendarFromDate(client.getStartDate()));
server.setAmount(getBigDecimalFromDouble(client.getAmount()));
server.setTrialAmount(getBigDecimalFromDouble(client.getTrialAmount()));
server.setActive(client.isActive());
server.setProblem(client.isProblem());
server.setProblemDesc(client.getProblemDesc());
server.setLastBillingDate(getCalendarFromDate(client.getLastBillingDate()));
server.setNextBillingDate(getCalendarFromDate(client.getNextBillingDate()));
server.setPaymentSchedule(getPaymentScheduleIf(client.getPaymentSchedule()));
server.setPaymentScheduleId(client.getPaymentScheduleId());
server.setOrderNumber(client.getOrderNumber());
server.setProductSku(client.getProductSku());
server.setCustomerId(client.getCustomerId());
return server;
}

protected GWT_SuggestedSearchItem getGWT_SuggestedSearchItem(SuggestedSearchItemIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_SuggestedSearchItem client = new GWT_SuggestedSearchItem();
client.setRawText(server.getRawText());
client.setRichText(server.getRichText());
client.setProductId(server.getProductId());
client.setCategoryId(server.getCategoryId());
client.setManufacturerId(server.getManufacturerId());
client.setId(server.getId());
return client;
}

protected SuggestedSearchItemIf getSuggestedSearchItemIf(GWT_SuggestedSearchItem client) throws KKGWTException
{
if (client == null)
{
    return null;
}

SuggestedSearchItemIf server = new SuggestedSearchItem();
server.setRawText(client.getRawText());
server.setRichText(client.getRichText());
server.setProductId(client.getProductId());
server.setCategoryId(client.getCategoryId());
server.setManufacturerId(client.getManufacturerId());
server.setId(client.getId());
return server;
}

protected GWT_SuggestedSearchOptions getGWT_SuggestedSearchOptions(SuggestedSearchOptionsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_SuggestedSearchOptions client = new GWT_SuggestedSearchOptions();
client.setLimit(server.getLimit());
client.setSearchText(server.getSearchText());
client.setReturnRichText(server.isReturnRichText());
client.setReturnRawText(server.isReturnRawText());
client.setStartTag(server.getStartTag());
client.setEndTag(server.getEndTag());
client.setLanguageCode(server.getLanguageCode());
client.setLanguageId(server.getLanguageId());
return client;
}

protected SuggestedSearchOptionsIf getSuggestedSearchOptionsIf(GWT_SuggestedSearchOptions client) throws KKGWTException
{
if (client == null)
{
    return null;
}

SuggestedSearchOptionsIf server = new SuggestedSearchOptions();
server.setLimit(client.getLimit());
server.setSearchText(client.getSearchText());
server.setReturnRichText(client.isReturnRichText());
server.setReturnRawText(client.isReturnRawText());
server.setStartTag(client.getStartTag());
server.setEndTag(client.getEndTag());
server.setLanguageCode(client.getLanguageCode());
server.setLanguageId(client.getLanguageId());
return server;
}

protected GWT_TagGroup getGWT_TagGroup(TagGroupIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_TagGroup client = new GWT_TagGroup();
client.setId(server.getId());
client.setDescription(server.getDescription());
client.setLanguageId(server.getLanguageId());
client.setName(server.getName());
if (server.getTags() == null)
{
client.setTags(null);
} else
{
GWT_Tag[] clientArray = new GWT_Tag[server.getTags().length];
for (int i = 0; i < server.getTags().length; i++)
{
clientArray[i] = getGWT_Tag(server.getTags()[i]);
}
client.setTags(clientArray);
}
client.setFacetNumber(server.getFacetNumber());
client.setFacetConstraint(server.getFacetConstraint());
return client;
}

protected TagGroupIf getTagGroupIf(GWT_TagGroup client) throws KKGWTException
{
if (client == null)
{
    return null;
}

TagGroupIf server = new TagGroup();
server.setId(client.getId());
server.setDescription(client.getDescription());
server.setLanguageId(client.getLanguageId());
server.setName(client.getName());
if (client.getTags() == null)
{
server.setTags(null);
} else
{
TagIf[] serverArray = new TagIf[client.getTags().length];
for (int i = 0; i < client.getTags().length; i++)
{
serverArray[i] = getTagIf(client.getTags()[i]);
}
server.setTags(serverArray);
}
server.setFacetNumber(client.getFacetNumber());
server.setFacetConstraint(client.getFacetConstraint());
return server;
}

protected GWT_Tag getGWT_Tag(TagIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Tag client = new GWT_Tag();
client.setId(server.getId());
client.setLanguageId(server.getLanguageId());
client.setName(server.getName());
client.setSortOrder(server.getSortOrder());
client.setSelected(server.isSelected());
client.setNumProducts(server.getNumProducts());
return client;
}

protected TagIf getTagIf(GWT_Tag client) throws KKGWTException
{
if (client == null)
{
    return null;
}

TagIf server = new Tag();
server.setId(client.getId());
server.setLanguageId(client.getLanguageId());
server.setName(client.getName());
server.setSortOrder(client.getSortOrder());
server.setSelected(client.isSelected());
server.setNumProducts(client.getNumProducts());
return server;
}

protected GWT_TaxClass getGWT_TaxClass(TaxClassIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_TaxClass client = new GWT_TaxClass();
client.setDateAdded(getDateFromDate(server.getDateAdded()));
client.setLastModified(getDateFromDate(server.getLastModified()));
client.setTaxClassDescription(server.getTaxClassDescription());
client.setTaxClassId(server.getTaxClassId());
client.setTaxClassTitle(server.getTaxClassTitle());
client.setTaxCode(server.getTaxCode());
return client;
}

protected TaxClassIf getTaxClassIf(GWT_TaxClass client) throws KKGWTException
{
if (client == null)
{
    return null;
}

TaxClassIf server = new TaxClass();
server.setDateAdded(client.getDateAdded());
server.setLastModified(client.getLastModified());
server.setTaxClassDescription(client.getTaxClassDescription());
server.setTaxClassId(client.getTaxClassId());
server.setTaxClassTitle(client.getTaxClassTitle());
server.setTaxCode(client.getTaxCode());
return server;
}

protected GWT_TaxRate getGWT_TaxRate(TaxRateIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_TaxRate client = new GWT_TaxRate();
client.setDescription(server.getDescription());
client.setId(server.getId());
client.setPriority(server.getPriority());
client.setRate(getDoubleFromBigDecimal(server.getRate()));
return client;
}

protected TaxRateIf getTaxRateIf(GWT_TaxRate client) throws KKGWTException
{
if (client == null)
{
    return null;
}

TaxRateIf server = new TaxRate();
server.setDescription(client.getDescription());
server.setId(client.getId());
server.setPriority(client.getPriority());
server.setRate(getBigDecimalFromDouble(client.getRate()));
return server;
}

protected GWT_TierPrice getGWT_TierPrice(TierPriceIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_TierPrice client = new GWT_TierPrice();
client.setId(server.getId());
client.setProductId(server.getProductId());
client.setQuantity(server.getQuantity());
client.setPriceExTax(getDoubleFromBigDecimal(server.getPriceExTax()));
client.setPrice0(getDoubleFromBigDecimal(server.getPrice0()));
client.setPrice1(getDoubleFromBigDecimal(server.getPrice1()));
client.setPrice2(getDoubleFromBigDecimal(server.getPrice2()));
client.setPrice3(getDoubleFromBigDecimal(server.getPrice3()));
client.setUsePercentageDiscount(server.isUsePercentageDiscount());
client.setCustom1(server.getCustom1());
client.setLastModified(getDateFromCalendar(server.getLastModified()));
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setPriceIncTax(getDoubleFromBigDecimal(server.getPriceIncTax()));
return client;
}

protected TierPriceIf getTierPriceIf(GWT_TierPrice client) throws KKGWTException
{
if (client == null)
{
    return null;
}

TierPriceIf server = new TierPrice();
server.setId(client.getId());
server.setProductId(client.getProductId());
server.setQuantity(client.getQuantity());
server.setPriceExTax(getBigDecimalFromDouble(client.getPriceExTax()));
server.setPrice0(getBigDecimalFromDouble(client.getPrice0()));
server.setPrice1(getBigDecimalFromDouble(client.getPrice1()));
server.setPrice2(getBigDecimalFromDouble(client.getPrice2()));
server.setPrice3(getBigDecimalFromDouble(client.getPrice3()));
server.setUsePercentageDiscount(client.isUsePercentageDiscount());
server.setCustom1(client.getCustom1());
server.setLastModified(getCalendarFromDate(client.getLastModified()));
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setPriceIncTax(getBigDecimalFromDouble(client.getPriceIncTax()));
return server;
}

protected GWT_WishList getGWT_WishList(WishListIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_WishList client = new GWT_WishList();
client.setId(server.getId());
if (server.getWishListItems() == null)
{
client.setWishListItems(null);
} else
{
GWT_WishListItem[] clientArray = new GWT_WishListItem[server.getWishListItems().length];
for (int i = 0; i < server.getWishListItems().length; i++)
{
clientArray[i] = getGWT_WishListItem(server.getWishListItems()[i]);
}
client.setWishListItems(clientArray);
}
client.setName(server.getName());
client.setDescription(server.getDescription());
client.setPublicWishList(server.isPublicWishList());
client.setFinalPriceIncTax(getDoubleFromBigDecimal(server.getFinalPriceIncTax()));
client.setFinalPriceExTax(getDoubleFromBigDecimal(server.getFinalPriceExTax()));
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setCustomerFirstName(server.getCustomerFirstName());
client.setCustomerLastName(server.getCustomerLastName());
client.setCustomerCity(server.getCustomerCity());
client.setCustomerBirthDate(getDateFromCalendar(server.getCustomerBirthDate()));
client.setCustomerState(server.getCustomerState());
client.setCustomerId(server.getCustomerId());
client.setCustomer1FirstName(server.getCustomer1FirstName());
client.setCustomer1LastName(server.getCustomer1LastName());
client.setLinkUrl(server.getLinkUrl());
client.setListType(server.getListType());
client.setAddressId(server.getAddressId());
client.setAddress(getGWT_Address(server.getAddress()));
client.setEventDate(getDateFromCalendar(server.getEventDate()));
return client;
}

protected WishListIf getWishListIf(GWT_WishList client) throws KKGWTException
{
if (client == null)
{
    return null;
}

WishListIf server = new WishList();
server.setId(client.getId());
if (client.getWishListItems() == null)
{
server.setWishListItems(null);
} else
{
WishListItemIf[] serverArray = new WishListItemIf[client.getWishListItems().length];
for (int i = 0; i < client.getWishListItems().length; i++)
{
serverArray[i] = getWishListItemIf(client.getWishListItems()[i]);
}
server.setWishListItems(serverArray);
}
server.setName(client.getName());
server.setDescription(client.getDescription());
server.setPublicWishList(client.isPublicWishList());
server.setFinalPriceIncTax(getBigDecimalFromDouble(client.getFinalPriceIncTax()));
server.setFinalPriceExTax(getBigDecimalFromDouble(client.getFinalPriceExTax()));
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setCustomerFirstName(client.getCustomerFirstName());
server.setCustomerLastName(client.getCustomerLastName());
server.setCustomerCity(client.getCustomerCity());
server.setCustomerBirthDate(getCalendarFromDate(client.getCustomerBirthDate()));
server.setCustomerState(client.getCustomerState());
server.setCustomerId(client.getCustomerId());
server.setCustomer1FirstName(client.getCustomer1FirstName());
server.setCustomer1LastName(client.getCustomer1LastName());
server.setLinkUrl(client.getLinkUrl());
server.setListType(client.getListType());
server.setAddressId(client.getAddressId());
server.setAddress(getAddressIf(client.getAddress()));
server.setEventDate(getCalendarFromDate(client.getEventDate()));
return server;
}

protected GWT_WishListItem getGWT_WishListItem(WishListItemIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_WishListItem client = new GWT_WishListItem();
client.setDateAdded(getDateFromCalendar(server.getDateAdded()));
client.setEncodedProduct(server.getEncodedProduct());
client.setId(server.getId());
client.setWishListId(server.getWishListId());
if (server.getOpts() == null)
{
client.setOpts(null);
} else
{
GWT_Option[] clientArray = new GWT_Option[server.getOpts().length];
for (int i = 0; i < server.getOpts().length; i++)
{
clientArray[i] = getGWT_Option(server.getOpts()[i]);
}
client.setOpts(clientArray);
}
client.setProduct(getGWT_Product(server.getProduct()));
client.setProductId(server.getProductId());
client.setFinalPriceExTax(getDoubleFromBigDecimal(server.getFinalPriceExTax()));
client.setFinalPriceIncTax(getDoubleFromBigDecimal(server.getFinalPriceIncTax()));
client.setQuantityInStock(server.getQuantityInStock());
client.setPriority(server.getPriority());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
client.setCustom4(server.getCustom4());
client.setCustom5(server.getCustom5());
client.setQuantityDesired(server.getQuantityDesired());
client.setQuantityReceived(server.getQuantityReceived());
client.setComments(server.getComments());
return client;
}

protected WishListItemIf getWishListItemIf(GWT_WishListItem client) throws KKGWTException
{
if (client == null)
{
    return null;
}

WishListItemIf server = new WishListItem();
server.setDateAdded(getCalendarFromDate(client.getDateAdded()));
server.setEncodedProduct(client.getEncodedProduct());
server.setId(client.getId());
server.setWishListId(client.getWishListId());
if (client.getOpts() == null)
{
server.setOpts(null);
} else
{
OptionIf[] serverArray = new OptionIf[client.getOpts().length];
for (int i = 0; i < client.getOpts().length; i++)
{
serverArray[i] = getOptionIf(client.getOpts()[i]);
}
server.setOpts(serverArray);
}
server.setProduct(getProductIf(client.getProduct()));
server.setProductId(client.getProductId());
server.setFinalPriceExTax(getBigDecimalFromDouble(client.getFinalPriceExTax()));
server.setFinalPriceIncTax(getBigDecimalFromDouble(client.getFinalPriceIncTax()));
server.setQuantityInStock(client.getQuantityInStock());
server.setPriority(client.getPriority());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
server.setCustom4(client.getCustom4());
server.setCustom5(client.getCustom5());
server.setQuantityDesired(client.getQuantityDesired());
server.setQuantityReceived(client.getQuantityReceived());
server.setComments(client.getComments());
return server;
}

protected GWT_WishListItems getGWT_WishListItems(WishListItemsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_WishListItems client = new GWT_WishListItems();
client.setTotalNumItems(server.getTotalNumItems());
if (server.getItemArray() == null)
{
client.setItemArray(null);
} else
{
GWT_WishListItem[] clientArray = new GWT_WishListItem[server.getItemArray().length];
for (int i = 0; i < server.getItemArray().length; i++)
{
clientArray[i] = getGWT_WishListItem(server.getItemArray()[i]);
}
client.setItemArray(clientArray);
}
return client;
}

protected WishListItemsIf getWishListItemsIf(GWT_WishListItems client) throws KKGWTException
{
if (client == null)
{
    return null;
}

WishListItemsIf server = new WishListItems();
server.setTotalNumItems(client.getTotalNumItems());
if (client.getItemArray() == null)
{
server.setItemArray(null);
} else
{
WishListItemIf[] serverArray = new WishListItemIf[client.getItemArray().length];
for (int i = 0; i < client.getItemArray().length; i++)
{
serverArray[i] = getWishListItemIf(client.getItemArray()[i]);
}
server.setItemArray(serverArray);
}
return server;
}

protected GWT_WishLists getGWT_WishLists(WishListsIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_WishLists client = new GWT_WishLists();
client.setTotalNumWishLists(server.getTotalNumWishLists());
if (server.getWishListArray() == null)
{
client.setWishListArray(null);
} else
{
GWT_WishList[] clientArray = new GWT_WishList[server.getWishListArray().length];
for (int i = 0; i < server.getWishListArray().length; i++)
{
clientArray[i] = getGWT_WishList(server.getWishListArray()[i]);
}
client.setWishListArray(clientArray);
}
return client;
}

protected WishListsIf getWishListsIf(GWT_WishLists client) throws KKGWTException
{
if (client == null)
{
    return null;
}

WishListsIf server = new WishLists();
server.setTotalNumWishLists(client.getTotalNumWishLists());
if (client.getWishListArray() == null)
{
server.setWishListArray(null);
} else
{
WishListIf[] serverArray = new WishListIf[client.getWishListArray().length];
for (int i = 0; i < client.getWishListArray().length; i++)
{
serverArray[i] = getWishListIf(client.getWishListArray()[i]);
}
server.setWishListArray(serverArray);
}
return server;
}

protected GWT_Zone getGWT_Zone(ZoneIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_Zone client = new GWT_Zone();
client.setZoneId(server.getZoneId());
client.setZoneCountryId(server.getZoneCountryId());
client.setZoneCode(server.getZoneCode());
client.setZoneName(server.getZoneName());
client.setZoneInvisible(server.isZoneInvisible());
client.setZoneSearch(server.getZoneSearch());
client.setCustom1(server.getCustom1());
client.setCustom2(server.getCustom2());
client.setCustom3(server.getCustom3());
return client;
}

protected ZoneIf getZoneIf(GWT_Zone client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ZoneIf server = new Zone();
server.setZoneId(client.getZoneId());
server.setZoneCountryId(client.getZoneCountryId());
server.setZoneCode(client.getZoneCode());
server.setZoneName(client.getZoneName());
server.setZoneInvisible(client.isZoneInvisible());
server.setZoneSearch(client.getZoneSearch());
server.setCustom1(client.getCustom1());
server.setCustom2(client.getCustom2());
server.setCustom3(client.getCustom3());
return server;
}

protected GWT_ZoneSearch getGWT_ZoneSearch(ZoneSearchIf server) throws KKGWTException
{
if (server == null)
{
    return null;
}

GWT_ZoneSearch client = new GWT_ZoneSearch();
client.setSearchString(server.getSearchString());
client.setSearchStringRule(server.getSearchStringRule());
client.setId(server.getId());
client.setCountryId(server.getCountryId());
client.setCode(server.getCode());
client.setCodeRule(server.getCodeRule());
client.setName(server.getName());
client.setNameRule(server.getNameRule());
client.setInvisible(server.getInvisible());
client.setCustom1(server.getCustom1());
client.setCustom1Rule(server.getCustom1Rule());
client.setCustom2(server.getCustom2());
client.setCustom2Rule(server.getCustom2Rule());
client.setCustom3(server.getCustom3());
client.setCustom3Rule(server.getCustom3Rule());
return client;
}

protected ZoneSearchIf getZoneSearchIf(GWT_ZoneSearch client) throws KKGWTException
{
if (client == null)
{
    return null;
}

ZoneSearchIf server = new ZoneSearch();
server.setSearchString(client.getSearchString());
server.setSearchStringRule(client.getSearchStringRule());
server.setId(client.getId());
server.setCountryId(client.getCountryId());
server.setCode(client.getCode());
server.setCodeRule(client.getCodeRule());
server.setName(client.getName());
server.setNameRule(client.getNameRule());
server.setInvisible(client.getInvisible());
server.setCustom1(client.getCustom1());
server.setCustom1Rule(client.getCustom1Rule());
server.setCustom2(client.getCustom2());
server.setCustom2Rule(client.getCustom2Rule());
server.setCustom3(client.getCustom3());
server.setCustom3Rule(client.getCustom3Rule());
return server;
}

}
