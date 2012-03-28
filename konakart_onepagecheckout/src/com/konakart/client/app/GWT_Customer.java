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
import java.util.Date;
/** */
public class GWT_Customer implements IsSerializable
{
/** */
public GWT_Address defaultAddr;

/** */
public String emailAddr;

/** */
public String faxNumber;

/** */
public String firstName;

/** */
public String gender;

/** */
public int id;

/** */
public String lastName;

/** */
public String newsletter;

/** */
public int numberOfLogons;

/** */
public String password;

/** */
public String telephoneNumber;

/** */
public String telephoneNumber1;

/** */
public Date accountCreated;

/** */
public Date accountLastModified;

/** */
public Date birthDate;

/** */
public Date lastLogon;

/** */
public GWT_Basket[] basketItems;

/** */
public int defaultAddrId;

/** */
public GWT_Address[] addresses;

/** */
public int globalProdNotifier;

/** */
public GWT_Product[] productNotifications;

/** */
public GWT_Order[] orders;

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
public int type;

/** */
public int groupId;

/** */
public GWT_CustomerGroup customerGroup;

/** */
public GWT_WishList[] wishLists;

/** */
public String locale;

/** */
public byte invisible;

/** @return defaultAddr */
public GWT_Address getDefaultAddr()
{
   return defaultAddr;
}

/** @param defaultAddr */
public void setDefaultAddr(GWT_Address defaultAddr)
{
   this.defaultAddr = defaultAddr;
}

/** @return emailAddr */
public String getEmailAddr()
{
   return emailAddr;
}

/** @param emailAddr */
public void setEmailAddr(String emailAddr)
{
   this.emailAddr = emailAddr;
}

/** @return faxNumber */
public String getFaxNumber()
{
   return faxNumber;
}

/** @param faxNumber */
public void setFaxNumber(String faxNumber)
{
   this.faxNumber = faxNumber;
}

/** @return firstName */
public String getFirstName()
{
   return firstName;
}

/** @param firstName */
public void setFirstName(String firstName)
{
   this.firstName = firstName;
}

/** @return gender */
public String getGender()
{
   return gender;
}

/** @param gender */
public void setGender(String gender)
{
   this.gender = gender;
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

/** @return lastName */
public String getLastName()
{
   return lastName;
}

/** @param lastName */
public void setLastName(String lastName)
{
   this.lastName = lastName;
}

/** @return newsletter */
public String getNewsletter()
{
   return newsletter;
}

/** @param newsletter */
public void setNewsletter(String newsletter)
{
   this.newsletter = newsletter;
}

/** @return numberOfLogons */
public int getNumberOfLogons()
{
   return numberOfLogons;
}

/** @param numberOfLogons */
public void setNumberOfLogons(int numberOfLogons)
{
   this.numberOfLogons = numberOfLogons;
}

/** @return password */
public String getPassword()
{
   return password;
}

/** @param password */
public void setPassword(String password)
{
   this.password = password;
}

/** @return telephoneNumber */
public String getTelephoneNumber()
{
   return telephoneNumber;
}

/** @param telephoneNumber */
public void setTelephoneNumber(String telephoneNumber)
{
   this.telephoneNumber = telephoneNumber;
}

/** @return telephoneNumber1 */
public String getTelephoneNumber1()
{
   return telephoneNumber1;
}

/** @param telephoneNumber1 */
public void setTelephoneNumber1(String telephoneNumber1)
{
   this.telephoneNumber1 = telephoneNumber1;
}

/** @return accountCreated */
public Date getAccountCreated()
{
   return accountCreated;
}

/** @param accountCreated */
public void setAccountCreated(Date accountCreated)
{
   this.accountCreated = accountCreated;
}

/** @return accountLastModified */
public Date getAccountLastModified()
{
   return accountLastModified;
}

/** @param accountLastModified */
public void setAccountLastModified(Date accountLastModified)
{
   this.accountLastModified = accountLastModified;
}

/** @return birthDate */
public Date getBirthDate()
{
   return birthDate;
}

/** @param birthDate */
public void setBirthDate(Date birthDate)
{
   this.birthDate = birthDate;
}

/** @return lastLogon */
public Date getLastLogon()
{
   return lastLogon;
}

/** @param lastLogon */
public void setLastLogon(Date lastLogon)
{
   this.lastLogon = lastLogon;
}

/** @return basketItems */
public GWT_Basket[] getBasketItems()
{
   return basketItems;
}

/** @param basketItems */
public void setBasketItems(GWT_Basket[] basketItems)
{
   this.basketItems = basketItems;
}

/** @return defaultAddrId */
public int getDefaultAddrId()
{
   return defaultAddrId;
}

/** @param defaultAddrId */
public void setDefaultAddrId(int defaultAddrId)
{
   this.defaultAddrId = defaultAddrId;
}

/** @return addresses */
public GWT_Address[] getAddresses()
{
   return addresses;
}

/** @param addresses */
public void setAddresses(GWT_Address[] addresses)
{
   this.addresses = addresses;
}

/** @return globalProdNotifier */
public int getGlobalProdNotifier()
{
   return globalProdNotifier;
}

/** @param globalProdNotifier */
public void setGlobalProdNotifier(int globalProdNotifier)
{
   this.globalProdNotifier = globalProdNotifier;
}

/** @return productNotifications */
public GWT_Product[] getProductNotifications()
{
   return productNotifications;
}

/** @param productNotifications */
public void setProductNotifications(GWT_Product[] productNotifications)
{
   this.productNotifications = productNotifications;
}

/** @return orders */
public GWT_Order[] getOrders()
{
   return orders;
}

/** @param orders */
public void setOrders(GWT_Order[] orders)
{
   this.orders = orders;
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

/** @return type */
public int getType()
{
   return type;
}

/** @param type */
public void setType(int type)
{
   this.type = type;
}

/** @return groupId */
public int getGroupId()
{
   return groupId;
}

/** @param groupId */
public void setGroupId(int groupId)
{
   this.groupId = groupId;
}

/** @return customerGroup */
public GWT_CustomerGroup getCustomerGroup()
{
   return customerGroup;
}

/** @param customerGroup */
public void setCustomerGroup(GWT_CustomerGroup customerGroup)
{
   this.customerGroup = customerGroup;
}

/** @return wishLists */
public GWT_WishList[] getWishLists()
{
   return wishLists;
}

/** @param wishLists */
public void setWishLists(GWT_WishList[] wishLists)
{
   this.wishLists = wishLists;
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

/** @return invisible */
public byte getInvisible()
{
   return invisible;
}

/** @param invisible */
public void setInvisible(byte invisible)
{
   this.invisible = invisible;
}

}
