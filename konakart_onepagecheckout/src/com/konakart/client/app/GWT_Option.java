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
public class GWT_Option implements IsSerializable
{
/** */
public String name;

/** */
public String value;

/** */
public int valueId;

/** */
public int id;

/** */
public int attrId;

/** */
public Double priceExTax;

/** */
public Double priceIncTax;

/** */
public Double price0;

/** */
public Double price1;

/** */
public Double price2;

/** */
public Double price3;

/** */
public String attrCustom1;

/** */
public String attrCustom2;

/** */
public String optionCustom1;

/** */
public String optionCustom2;

/** */
public String optionValCustom1;

/** */
public String optionValCustom2;

/** */
public int type;

/** */
public int quantity;

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

/** @return value */
public String getValue()
{
   return value;
}

/** @param value */
public void setValue(String value)
{
   this.value = value;
}

/** @return valueId */
public int getValueId()
{
   return valueId;
}

/** @param valueId */
public void setValueId(int valueId)
{
   this.valueId = valueId;
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

/** @return attrId */
public int getAttrId()
{
   return attrId;
}

/** @param attrId */
public void setAttrId(int attrId)
{
   this.attrId = attrId;
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

/** @return attrCustom1 */
public String getAttrCustom1()
{
   return attrCustom1;
}

/** @param attrCustom1 */
public void setAttrCustom1(String attrCustom1)
{
   this.attrCustom1 = attrCustom1;
}

/** @return attrCustom2 */
public String getAttrCustom2()
{
   return attrCustom2;
}

/** @param attrCustom2 */
public void setAttrCustom2(String attrCustom2)
{
   this.attrCustom2 = attrCustom2;
}

/** @return optionCustom1 */
public String getOptionCustom1()
{
   return optionCustom1;
}

/** @param optionCustom1 */
public void setOptionCustom1(String optionCustom1)
{
   this.optionCustom1 = optionCustom1;
}

/** @return optionCustom2 */
public String getOptionCustom2()
{
   return optionCustom2;
}

/** @param optionCustom2 */
public void setOptionCustom2(String optionCustom2)
{
   this.optionCustom2 = optionCustom2;
}

/** @return optionValCustom1 */
public String getOptionValCustom1()
{
   return optionValCustom1;
}

/** @param optionValCustom1 */
public void setOptionValCustom1(String optionValCustom1)
{
   this.optionValCustom1 = optionValCustom1;
}

/** @return optionValCustom2 */
public String getOptionValCustom2()
{
   return optionValCustom2;
}

/** @param optionValCustom2 */
public void setOptionValCustom2(String optionValCustom2)
{
   this.optionValCustom2 = optionValCustom2;
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

}
