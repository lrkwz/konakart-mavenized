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
public class GWT_OrderTotal implements IsSerializable
{
/** */
public String className;

/** */
public int id;

/** */
public int orderId;

/** */
public int sortOrder;

/** */
public String text;

/** */
public String title;

/** */
public Double value;

/** */
public GWT_Promotion[] promotions;

/** */
public GWT_OrderTotal[] orderTotals;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public String formattedValue;

/** @return className */
public String getClassName()
{
   return className;
}

/** @param className */
public void setClassName(String className)
{
   this.className = className;
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

/** @return sortOrder */
public int getSortOrder()
{
   return sortOrder;
}

/** @param sortOrder */
public void setSortOrder(int sortOrder)
{
   this.sortOrder = sortOrder;
}

/** @return text */
public String getText()
{
   return text;
}

/** @param text */
public void setText(String text)
{
   this.text = text;
}

/** @return title */
public String getTitle()
{
   return title;
}

/** @param title */
public void setTitle(String title)
{
   this.title = title;
}

/** @return value */
public Double getValue()
{
   return value;
}

/** @param value */
public void setValue(Double value)
{
   this.value = value;
}

/** @return promotions */
public GWT_Promotion[] getPromotions()
{
   return promotions;
}

/** @param promotions */
public void setPromotions(GWT_Promotion[] promotions)
{
   this.promotions = promotions;
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

/** @return formattedValue */
public String getFormattedValue()
{
   return formattedValue;
}

/** @param formattedValue */
public void setFormattedValue(String formattedValue)
{
   this.formattedValue = formattedValue;
}

}
