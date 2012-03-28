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
public class GWT_Promotion implements IsSerializable
{
/** */
public boolean active;

/** */
public boolean cumulative;

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
public String custom6;

/** */
public String custom7;

/** */
public String custom8;

/** */
public String custom9;

/** */
public String custom10;

/** */
public int id;

/** */
public String orderTotalCode;

/** */
public String name;

/** */
public String description;

/** */
public int categoryRule;

/** */
public int customerRule;

/** */
public int customerGroupRule;

/** */
public int manufacturerRule;

/** */
public int productRule;

/** */
public GWT_OrderProduct[] applicableProducts;

/** */
public Date dateAdded;

/** */
public Date endDate;

/** */
public Date lastModified;

/** */
public Date startDate;

/** */
public GWT_Coupon coupon;

/** */
public int maxUse;

/** */
public boolean requiresCoupon;

/** @return active */
public boolean isActive()
{
   return active;
}

/** @param active */
public void setActive(boolean active)
{
   this.active = active;
}

/** @return cumulative */
public boolean isCumulative()
{
   return cumulative;
}

/** @param cumulative */
public void setCumulative(boolean cumulative)
{
   this.cumulative = cumulative;
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

/** @return custom6 */
public String getCustom6()
{
   return custom6;
}

/** @param custom6 */
public void setCustom6(String custom6)
{
   this.custom6 = custom6;
}

/** @return custom7 */
public String getCustom7()
{
   return custom7;
}

/** @param custom7 */
public void setCustom7(String custom7)
{
   this.custom7 = custom7;
}

/** @return custom8 */
public String getCustom8()
{
   return custom8;
}

/** @param custom8 */
public void setCustom8(String custom8)
{
   this.custom8 = custom8;
}

/** @return custom9 */
public String getCustom9()
{
   return custom9;
}

/** @param custom9 */
public void setCustom9(String custom9)
{
   this.custom9 = custom9;
}

/** @return custom10 */
public String getCustom10()
{
   return custom10;
}

/** @param custom10 */
public void setCustom10(String custom10)
{
   this.custom10 = custom10;
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

/** @return orderTotalCode */
public String getOrderTotalCode()
{
   return orderTotalCode;
}

/** @param orderTotalCode */
public void setOrderTotalCode(String orderTotalCode)
{
   this.orderTotalCode = orderTotalCode;
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

/** @return categoryRule */
public int getCategoryRule()
{
   return categoryRule;
}

/** @param categoryRule */
public void setCategoryRule(int categoryRule)
{
   this.categoryRule = categoryRule;
}

/** @return customerRule */
public int getCustomerRule()
{
   return customerRule;
}

/** @param customerRule */
public void setCustomerRule(int customerRule)
{
   this.customerRule = customerRule;
}

/** @return customerGroupRule */
public int getCustomerGroupRule()
{
   return customerGroupRule;
}

/** @param customerGroupRule */
public void setCustomerGroupRule(int customerGroupRule)
{
   this.customerGroupRule = customerGroupRule;
}

/** @return manufacturerRule */
public int getManufacturerRule()
{
   return manufacturerRule;
}

/** @param manufacturerRule */
public void setManufacturerRule(int manufacturerRule)
{
   this.manufacturerRule = manufacturerRule;
}

/** @return productRule */
public int getProductRule()
{
   return productRule;
}

/** @param productRule */
public void setProductRule(int productRule)
{
   this.productRule = productRule;
}

/** @return applicableProducts */
public GWT_OrderProduct[] getApplicableProducts()
{
   return applicableProducts;
}

/** @param applicableProducts */
public void setApplicableProducts(GWT_OrderProduct[] applicableProducts)
{
   this.applicableProducts = applicableProducts;
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

/** @return endDate */
public Date getEndDate()
{
   return endDate;
}

/** @param endDate */
public void setEndDate(Date endDate)
{
   this.endDate = endDate;
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

/** @return startDate */
public Date getStartDate()
{
   return startDate;
}

/** @param startDate */
public void setStartDate(Date startDate)
{
   this.startDate = startDate;
}

/** @return coupon */
public GWT_Coupon getCoupon()
{
   return coupon;
}

/** @param coupon */
public void setCoupon(GWT_Coupon coupon)
{
   this.coupon = coupon;
}

/** @return maxUse */
public int getMaxUse()
{
   return maxUse;
}

/** @param maxUse */
public void setMaxUse(int maxUse)
{
   this.maxUse = maxUse;
}

/** @return requiresCoupon */
public boolean isRequiresCoupon()
{
   return requiresCoupon;
}

/** @param requiresCoupon */
public void setRequiresCoupon(boolean requiresCoupon)
{
   this.requiresCoupon = requiresCoupon;
}

}
