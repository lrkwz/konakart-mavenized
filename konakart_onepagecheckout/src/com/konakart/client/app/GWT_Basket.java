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
public class GWT_Basket implements IsSerializable
{
/** */
public Date dateAdded;

/** */
public String encodedProduct;

/** */
public int id;

/** */
public GWT_Option[] opts;

/** */
public GWT_Product product;

/** */
public int productId;

/** */
public int quantity;

/** */
public Double finalPriceExTax;

/** */
public Double finalPriceIncTax;

/** */
public int quantityInStock;

/** */
public Date dateAvailable;

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
public String sku;

/** */
public int wishListId;

/** */
public int wishListItemId;

/** */
public boolean useBasketPrice;

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

/** @return dateAvailable */
public Date getDateAvailable()
{
   return dateAvailable;
}

/** @param dateAvailable */
public void setDateAvailable(Date dateAvailable)
{
   this.dateAvailable = dateAvailable;
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

/** @return sku */
public String getSku()
{
   return sku;
}

/** @param sku */
public void setSku(String sku)
{
   this.sku = sku;
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

/** @return wishListItemId */
public int getWishListItemId()
{
   return wishListItemId;
}

/** @param wishListItemId */
public void setWishListItemId(int wishListItemId)
{
   this.wishListItemId = wishListItemId;
}

/** @return useBasketPrice */
public boolean isUseBasketPrice()
{
   return useBasketPrice;
}

/** @param useBasketPrice */
public void setUseBasketPrice(boolean useBasketPrice)
{
   this.useBasketPrice = useBasketPrice;
}

}
