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
public class GWT_WishListItem implements IsSerializable
{
/** */
public Date dateAdded;

/** */
public String encodedProduct;

/** */
public int id;

/** */
public int wishListId;

/** */
public GWT_Option[] opts;

/** */
public GWT_Product product;

/** */
public int productId;

/** */
public Double finalPriceExTax;

/** */
public Double finalPriceIncTax;

/** */
public int quantityInStock;

/** */
public int priority;

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
public int quantityDesired;

/** */
public int quantityReceived;

/** */
public String comments;

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

/** @return encodedProduct */
public String getEncodedProduct()
{
   return encodedProduct;
}

/** @param encodedProduct */
public void setEncodedProduct(String encodedProduct)
{
   this.encodedProduct = encodedProduct;
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

/** @return wishListId */
public int getWishListId()
{
   return wishListId;
}

/** @param wishListId */
public void setWishListId(int wishListId)
{
   this.wishListId = wishListId;
}

/** @return opts */
public GWT_Option[] getOpts()
{
   return opts;
}

/** @param opts */
public void setOpts(GWT_Option[] opts)
{
   this.opts = opts;
}

/** @return product */
public GWT_Product getProduct()
{
   return product;
}

/** @param product */
public void setProduct(GWT_Product product)
{
   this.product = product;
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

/** @return quantityInStock */
public int getQuantityInStock()
{
   return quantityInStock;
}

/** @param quantityInStock */
public void setQuantityInStock(int quantityInStock)
{
   this.quantityInStock = quantityInStock;
}

/** @return priority */
public int getPriority()
{
   return priority;
}

/** @param priority */
public void setPriority(int priority)
{
   this.priority = priority;
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

/** @return quantityDesired */
public int getQuantityDesired()
{
   return quantityDesired;
}

/** @param quantityDesired */
public void setQuantityDesired(int quantityDesired)
{
   this.quantityDesired = quantityDesired;
}

/** @return quantityReceived */
public int getQuantityReceived()
{
   return quantityReceived;
}

/** @param quantityReceived */
public void setQuantityReceived(int quantityReceived)
{
   this.quantityReceived = quantityReceived;
}

/** @return comments */
public String getComments()
{
   return comments;
}

/** @param comments */
public void setComments(String comments)
{
   this.comments = comments;
}

}
