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
public class GWT_AddToWishListOptions implements IsSerializable
{
/** */
public String catalogId;

/** */
public Date priceDate;

/** */
public boolean onlyShowAvailable;

/** */
public boolean useExternalPrice;

/** */
public int customerId;

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

/** @return onlyShowAvailable */
public boolean isOnlyShowAvailable()
{
   return onlyShowAvailable;
}

/** @param onlyShowAvailable */
public void setOnlyShowAvailable(boolean onlyShowAvailable)
{
   this.onlyShowAvailable = onlyShowAvailable;
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

}
