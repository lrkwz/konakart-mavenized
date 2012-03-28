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
public class GWT_ShippingQuote implements IsSerializable
{
/** */
public String code;

/** */
public String moduleCode;

/** */
public String description;

/** */
public String icon;

/** */
public int sortOrder;

/** */
public String title;

/** */
public Double handlingCost;

/** */
public Double tax;

/** */
public String responseText;

/** */
public Double cost;

/** */
public boolean free;

/** */
public Double freeShippingOver;

/** */
public int taxClass;

/** */
public Double totalExTax;

/** */
public Double totalIncTax;

/** */
public GWT_ShippingQuote[] quotes;

/** */
public String shippingServiceCode;

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

/** @return code */
public String getCode()
{
   return code;
}

/** @param code */
public void setCode(String code)
{
   this.code = code;
}

/** @return moduleCode */
public String getModuleCode()
{
   return moduleCode;
}

/** @param moduleCode */
public void setModuleCode(String moduleCode)
{
   this.moduleCode = moduleCode;
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

/** @return icon */
public String getIcon()
{
   return icon;
}

/** @param icon */
public void setIcon(String icon)
{
   this.icon = icon;
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

/** @return handlingCost */
public Double getHandlingCost()
{
   return handlingCost;
}

/** @param handlingCost */
public void setHandlingCost(Double handlingCost)
{
   this.handlingCost = handlingCost;
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

/** @return responseText */
public String getResponseText()
{
   return responseText;
}

/** @param responseText */
public void setResponseText(String responseText)
{
   this.responseText = responseText;
}

/** @return cost */
public Double getCost()
{
   return cost;
}

/** @param cost */
public void setCost(Double cost)
{
   this.cost = cost;
}

/** @return free */
public boolean isFree()
{
   return free;
}

/** @param free */
public void setFree(boolean free)
{
   this.free = free;
}

/** @return freeShippingOver */
public Double getFreeShippingOver()
{
   return freeShippingOver;
}

/** @param freeShippingOver */
public void setFreeShippingOver(Double freeShippingOver)
{
   this.freeShippingOver = freeShippingOver;
}

/** @return taxClass */
public int getTaxClass()
{
   return taxClass;
}

/** @param taxClass */
public void setTaxClass(int taxClass)
{
   this.taxClass = taxClass;
}

/** @return totalExTax */
public Double getTotalExTax()
{
   return totalExTax;
}

/** @param totalExTax */
public void setTotalExTax(Double totalExTax)
{
   this.totalExTax = totalExTax;
}

/** @return totalIncTax */
public Double getTotalIncTax()
{
   return totalIncTax;
}

/** @param totalIncTax */
public void setTotalIncTax(Double totalIncTax)
{
   this.totalIncTax = totalIncTax;
}

/** @return quotes */
public GWT_ShippingQuote[] getQuotes()
{
   return quotes;
}

/** @param quotes */
public void setQuotes(GWT_ShippingQuote[] quotes)
{
   this.quotes = quotes;
}

/** @return shippingServiceCode */
public String getShippingServiceCode()
{
   return shippingServiceCode;
}

/** @param shippingServiceCode */
public void setShippingServiceCode(String shippingServiceCode)
{
   this.shippingServiceCode = shippingServiceCode;
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

}
