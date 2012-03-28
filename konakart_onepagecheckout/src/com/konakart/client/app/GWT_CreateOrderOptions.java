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
public class GWT_CreateOrderOptions implements IsSerializable
{
/** */
public boolean copyBasketCustomFields;

/** */
public boolean useDefaultCustomer;

/** */
public String catalogId;

/** */
public Date priceDate;

/** */
public boolean useWishListShippingAddr;

/** */
public boolean useExternalPrice;

/** */
public String locale;

/** */
public boolean useExternalQuantity;

/** */
public int billingAddrId;

/** */
public int customerAddrId;

/** */
public int deliveryAddrId;

/** @return copyBasketCustomFields */
public boolean isCopyBasketCustomFields()
{
   return copyBasketCustomFields;
}

/** @param copyBasketCustomFields */
public void setCopyBasketCustomFields(boolean copyBasketCustomFields)
{
   this.copyBasketCustomFields = copyBasketCustomFields;
}

/** @return useDefaultCustomer */
public boolean isUseDefaultCustomer()
{
   return useDefaultCustomer;
}

/** @param useDefaultCustomer */
public void setUseDefaultCustomer(boolean useDefaultCustomer)
{
   this.useDefaultCustomer = useDefaultCustomer;
}

/** @return catalogId */
public String getCatalogId()
{
   return catalogId;
}

/** @param catalogId */
public void setCatalogId(String catalogId)
{
   this.catalogId = catalogId;
}

/** @return priceDate */
public Date getPriceDate()
{
   return priceDate;
}

/** @param priceDate */
public void setPriceDate(Date priceDate)
{
   this.priceDate = priceDate;
}

/** @return useWishListShippingAddr */
public boolean isUseWishListShippingAddr()
{
   return useWishListShippingAddr;
}

/** @param useWishListShippingAddr */
public void setUseWishListShippingAddr(boolean useWishListShippingAddr)
{
   this.useWishListShippingAddr = useWishListShippingAddr;
}

/** @return useExternalPrice */
public boolean isUseExternalPrice()
{
   return useExternalPrice;
}

/** @param useExternalPrice */
public void setUseExternalPrice(boolean useExternalPrice)
{
   this.useExternalPrice = useExternalPrice;
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

/** @return useExternalQuantity */
public boolean isUseExternalQuantity()
{
   return useExternalQuantity;
}

/** @param useExternalQuantity */
public void setUseExternalQuantity(boolean useExternalQuantity)
{
   this.useExternalQuantity = useExternalQuantity;
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

}
