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
public class GWT_ExpressionVariable implements IsSerializable
{
/** */
public int id;

/** */
public int customerTagId;

/** */
public int expressionId;

/** */
public int type;

/** */
public int operator;

/** */
public String value;

/** */
public String customerValue;

/** */
public int order;

/** */
public int andOr;

/** */
public int groupOrder;

/** */
public int groupAndOr;

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

/** @return customerTagId */
public int getCustomerTagId()
{
   return customerTagId;
}

/** @param customerTagId */
public void setCustomerTagId(int customerTagId)
{
   this.customerTagId = customerTagId;
}

/** @return expressionId */
public int getExpressionId()
{
   return expressionId;
}

/** @param expressionId */
public void setExpressionId(int expressionId)
{
   this.expressionId = expressionId;
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

/** @return operator */
public int getOperator()
{
   return operator;
}

/** @param operator */
public void setOperator(int operator)
{
   this.operator = operator;
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

/** @return customerValue */
public String getCustomerValue()
{
   return customerValue;
}

/** @param customerValue */
public void setCustomerValue(String customerValue)
{
   this.customerValue = customerValue;
}

/** @return order */
public int getOrder()
{
   return order;
}

/** @param order */
public void setOrder(int order)
{
   this.order = order;
}

/** @return andOr */
public int getAndOr()
{
   return andOr;
}

/** @param andOr */
public void setAndOr(int andOr)
{
   this.andOr = andOr;
}

/** @return groupOrder */
public int getGroupOrder()
{
   return groupOrder;
}

/** @param groupOrder */
public void setGroupOrder(int groupOrder)
{
   this.groupOrder = groupOrder;
}

/** @return groupAndOr */
public int getGroupAndOr()
{
   return groupAndOr;
}

/** @param groupAndOr */
public void setGroupAndOr(int groupAndOr)
{
   this.groupAndOr = groupAndOr;
}

}
