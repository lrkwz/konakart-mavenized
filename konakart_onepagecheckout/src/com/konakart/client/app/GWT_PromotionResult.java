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
public class GWT_PromotionResult implements IsSerializable
{
/** */
public int promotionId;

/** */
public String orderTotalCode;

/** */
public Double value;

/** */
public boolean percentageDiscount;

/** */
public boolean applyBeforeTax;

/** @return promotionId */
public int getPromotionId()
{
   return promotionId;
}

/** @param promotionId */
public void setPromotionId(int promotionId)
{
   this.promotionId = promotionId;
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

/** @return percentageDiscount */
public boolean isPercentageDiscount()
{
   return percentageDiscount;
}

/** @param percentageDiscount */
public void setPercentageDiscount(boolean percentageDiscount)
{
   this.percentageDiscount = percentageDiscount;
}

/** @return applyBeforeTax */
public boolean isApplyBeforeTax()
{
   return applyBeforeTax;
}

/** @param applyBeforeTax */
public void setApplyBeforeTax(boolean applyBeforeTax)
{
   this.applyBeforeTax = applyBeforeTax;
}

}
