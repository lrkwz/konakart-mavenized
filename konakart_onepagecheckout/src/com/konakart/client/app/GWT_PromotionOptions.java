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
/** */
public class GWT_PromotionOptions implements IsSerializable
{
/** */
public int promotionRule;

/** */
public boolean subtractValueFromPriceExTax;

/** */
public boolean subtractValueFromPriceIncTax;

/** @return promotionRule */
public int getPromotionRule()
{
   return promotionRule;
}

/** @param promotionRule */
public void setPromotionRule(int promotionRule)
{
   this.promotionRule = promotionRule;
}

/** @return subtractValueFromPriceExTax */
public boolean isSubtractValueFromPriceExTax()
{
   return subtractValueFromPriceExTax;
}

/** @param subtractValueFromPriceExTax */
public void setSubtractValueFromPriceExTax(boolean subtractValueFromPriceExTax)
{
   this.subtractValueFromPriceExTax = subtractValueFromPriceExTax;
}

/** @return subtractValueFromPriceIncTax */
public boolean isSubtractValueFromPriceIncTax()
{
   return subtractValueFromPriceIncTax;
}

/** @param subtractValueFromPriceIncTax */
public void setSubtractValueFromPriceIncTax(boolean subtractValueFromPriceIncTax)
{
   this.subtractValueFromPriceIncTax = subtractValueFromPriceIncTax;
}

}
