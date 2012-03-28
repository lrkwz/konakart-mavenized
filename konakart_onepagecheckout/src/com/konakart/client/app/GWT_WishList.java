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
public class GWT_WishList implements IsSerializable
{
/** */
public int id;

/** */
public GWT_WishListItem[] wishListItems;

/** */
public String name;

/** */
public String description;

/** */
public boolean publicWishList;

/** */
public Double finalPriceIncTax;

/** */
public Double finalPriceExTax;

/** */
public Date dateAdded;

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
public String customerFirstName;

/** */
public String customerLastName;

/** */
public String customerCity;

/** */
public Date customerBirthDate;

/** */
public String customerState;

/** */
public int customerId;

/** */
public String customer1FirstName;

/** */
public String customer1LastName;

/** */
public String linkUrl;

/** */
public int listType;

/** */
public int addressId;

/** */
public GWT_Address address;

/** */
public Date eventDate;

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

/** @return wishListItems */
public GWT_WishListItem[] getWishListItems()
{
   return wishListItems;
}

/** @param wishListItems */
public void setWishListItems(GWT_WishListItem[] wishListItems)
{
   this.wishListItems = wishListItems;
}

/** @return name */
public String getName()
{
   return name;
}

/** @param name */
public void setName(String name)
{
   this.name = name;
}

/** @return description */
public String getDescription()
{
   return description;
}

/** @param description */
public void setDescription(String description)
{
   this.description = description;
}

/** @return publicWishList */
public boolean isPublicWishList()
{
   return publicWishList;
}

/** @param publicWishList */
public void setPublicWishList(boolean publicWishList)
{
   this.publicWishList = publicWishList;
}

/** @return finalPriceIncTax */
public Double getFinalPriceIncTax()
{
   return finalPriceIncTax;
}

/** @param finalPriceIncTax */
public void setFinalPriceIncTax(Double finalPriceIncTax)
{
   this.finalPriceIncTax = finalPriceIncTax;
}

/** @return finalPriceExTax */
public Double getFinalPriceExTax()
{
   return finalPriceExTax;
}

/** @param finalPriceExTax */
public void setFinalPriceExTax(Double finalPriceExTax)
{
   this.finalPriceExTax = finalPriceExTax;
}

/** @return dateAdded */
public Date getDateAdded()
{
   return dateAdded;
}

/** @param dateAdded */
public void setDateAdded(Date dateAdded)
{
   this.dateAdded = dateAdded;
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

/** @return customerFirstName */
public String getCustomerFirstName()
{
   return customerFirstName;
}

/** @param customerFirstName */
public void setCustomerFirstName(String customerFirstName)
{
   this.customerFirstName = customerFirstName;
}

/** @return customerLastName */
public String getCustomerLastName()
{
   return customerLastName;
}

/** @param customerLastName */
public void setCustomerLastName(String customerLastName)
{
   this.customerLastName = customerLastName;
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

/** @return customerBirthDate */
public Date getCustomerBirthDate()
{
   return customerBirthDate;
}

/** @param customerBirthDate */
public void setCustomerBirthDate(Date customerBirthDate)
{
   this.customerBirthDate = customerBirthDate;
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

/** @return customer1FirstName */
public String getCustomer1FirstName()
{
   return customer1FirstName;
}

/** @param customer1FirstName */
public void setCustomer1FirstName(String customer1FirstName)
{
   this.customer1FirstName = customer1FirstName;
}

/** @return customer1LastName */
public String getCustomer1LastName()
{
   return customer1LastName;
}

/** @param customer1LastName */
public void setCustomer1LastName(String customer1LastName)
{
   this.customer1LastName = customer1LastName;
}

/** @return linkUrl */
public String getLinkUrl()
{
   return linkUrl;
}

/** @param linkUrl */
public void setLinkUrl(String linkUrl)
{
   this.linkUrl = linkUrl;
}

/** @return listType */
public int getListType()
{
   return listType;
}

/** @param listType */
public void setListType(int listType)
{
   this.listType = listType;
}

/** @return addressId */
public int getAddressId()
{
   return addressId;
}

/** @param addressId */
public void setAddressId(int addressId)
{
   this.addressId = addressId;
}

/** @return address */
public GWT_Address getAddress()
{
   return address;
}

/** @param address */
public void setAddress(GWT_Address address)
{
   this.address = address;
}

/** @return eventDate */
public Date getEventDate()
{
   return eventDate;
}

/** @param eventDate */
public void setEventDate(Date eventDate)
{
   this.eventDate = eventDate;
}

}
