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
public class GWT_TierPrice implements IsSerializable
{
/** */
public int id;

/** */
public int productId;

/** */
public int quantity;

/** */
public Double priceExTax;

/** */
public Double price0;

/** */
public Double price1;

/** */
public Double price2;

/** */
public Double price3;

/** */
public boolean usePercentageDiscount;

/** */
public String custom1;

/** */
public Date lastModified;

/** */
public Date dateAdded;

/** */
public Double priceIncTax;

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

/** @return productId */
public int getProductId()
{
   return productId;
}

/** @param productId */
public void setProductId(int productId)
{
   this.productId = productId;
}

/** @return quantity */
public int getQuantity()
{
   return quantity;
}

/** @param quantity */
public void setQuantity(int quantity)
{
   this.quantity = quantity;
}

/** @return priceExTax */
public Double getPriceExTax()
{
   return priceExTax;
}

/** @param priceExTax */
public void setPriceExTax(Double priceExTax)
{
   this.priceExTax = priceExTax;
}

/** @return price0 */
public Double getPrice0()
{
   return price0;
}

/** @param price0 */
public void setPrice0(Double price0)
{
   this.price0 = price0;
}

/** @return price1 */
public Double getPrice1()
{
   return price1;
}

/** @param price1 */
public void setPrice1(Double price1)
{
   this.price1 = price1;
}

/** @return price2 */
public Double getPrice2()
{
   return price2;
}

/** @param price2 */
public void setPrice2(Double price2)
{
   this.price2 = price2;
}

/** @return price3 */
public Double getPrice3()
{
   return price3;
}

/** @param price3 */
public void setPrice3(Double price3)
{
   this.price3 = price3;
}

/** @return usePercentageDiscount */
public boolean isUsePercentageDiscount()
{
   return usePercentageDiscount;
}

/** @param usePercentageDiscount */
public void setUsePercentageDiscount(boolean usePercentageDiscount)
{
   this.usePercentageDiscount = usePercentageDiscount;
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

/** @return priceIncTax */
public Double getPriceIncTax()
{
   return priceIncTax;
}

/** @param priceIncTax */
public void setPriceIncTax(Double priceIncTax)
{
   this.priceIncTax = priceIncTax;
}

}
