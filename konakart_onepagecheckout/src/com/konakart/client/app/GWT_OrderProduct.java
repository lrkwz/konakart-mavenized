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
/** */
public class GWT_OrderProduct implements IsSerializable
{
/** */
public int id;

/** */
public String model;

/** */
public String name;

/** */
public GWT_Option[] opts;

/** */
public GWT_Order order;

/** */
public int orderId;

/** */
public Double price;

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
public Double taxRate;

/** */
public Double tax;

/** */
public int type;

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
public Double price0;

/** */
public Double price1;

/** */
public Double price2;

/** */
public Double price3;

/** */
public String sku;

/** */
public int state;

/** */
public int wishListId;

/** */
public int wishListItemId;

/** */
public Double discountPercent;

/** */
public Double weight;

/** */
public String taxCode;

/** */
public String formattedFinalPriceIncTax;

/** */
public String formattedFinalPriceExTax;

/** */
public String formattedTaxRate;

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

/** @return model */
public String getModel()
{
   return model;
}

/** @param model */
public void setModel(String model)
{
   this.model = model;
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

/** @return order */
public GWT_Order getOrder()
{
   return order;
}

/** @param order */
public void setOrder(GWT_Order order)
{
   this.order = order;
}

/** @return orderId */
public int getOrderId()
{
   return orderId;
}

/** @param orderId */
public void setOrderId(int orderId)
{
   this.orderId = orderId;
}

/** @return price */
public Double getPrice()
{
   return price;
}

/** @param price */
public void setPrice(Double price)
{
   this.price = price;
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

/** @return taxRate */
public Double getTaxRate()
{
   return taxRate;
}

/** @param taxRate */
public void setTaxRate(Double taxRate)
{
   this.taxRate = taxRate;
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

/** @return state */
public int getState()
{
   return state;
}

/** @param state */
public void setState(int state)
{
   this.state = state;
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

/** @return discountPercent */
public Double getDiscountPercent()
{
   return discountPercent;
}

/** @param discountPercent */
public void setDiscountPercent(Double discountPercent)
{
   this.discountPercent = discountPercent;
}

/** @return weight */
public Double getWeight()
{
   return weight;
}

/** @param weight */
public void setWeight(Double weight)
{
   this.weight = weight;
}

/** @return taxCode */
public String getTaxCode()
{
   return taxCode;
}

/** @param taxCode */
public void setTaxCode(String taxCode)
{
   this.taxCode = taxCode;
}

/** @return formattedFinalPriceIncTax */
public String getFormattedFinalPriceIncTax()
{
   return formattedFinalPriceIncTax;
}

/** @param formattedFinalPriceIncTax */
public void setFormattedFinalPriceIncTax(String formattedFinalPriceIncTax)
{
   this.formattedFinalPriceIncTax = formattedFinalPriceIncTax;
}

/** @return formattedFinalPriceExTax */
public String getFormattedFinalPriceExTax()
{
   return formattedFinalPriceExTax;
}

/** @param formattedFinalPriceExTax */
public void setFormattedFinalPriceExTax(String formattedFinalPriceExTax)
{
   this.formattedFinalPriceExTax = formattedFinalPriceExTax;
}

/** @return formattedTaxRate */
public String getFormattedTaxRate()
{
   return formattedTaxRate;
}

/** @param formattedTaxRate */
public void setFormattedTaxRate(String formattedTaxRate)
{
   this.formattedTaxRate = formattedTaxRate;
}

}
