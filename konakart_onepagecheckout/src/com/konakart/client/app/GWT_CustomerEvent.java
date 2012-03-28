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
public class GWT_CustomerEvent implements IsSerializable
{
/** */
public int id;

/** */
public int customerId;

/** */
public int action;

/** */
public String data1Str;

/** */
public String data2Str;

/** */
public int data1Int;

/** */
public int data2Int;

/** */
public Double data1Dec;

/** */
public Double data2Dec;

/** */
public String storeId;

/** */
public Date dateAdded;

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

/** @return customerId */
public int getCustomerId()
{
   return customerId;
}

/** @param customerId */
public void setCustomerId(int customerId)
{
   this.customerId = customerId;
}

/** @return action */
public int getAction()
{
   return action;
}

/** @param action */
public void setAction(int action)
{
   this.action = action;
}

/** @return data1Str */
public String getData1Str()
{
   return data1Str;
}

/** @param data1Str */
public void setData1Str(String data1Str)
{
   this.data1Str = data1Str;
}

/** @return data2Str */
public String getData2Str()
{
   return data2Str;
}

/** @param data2Str */
public void setData2Str(String data2Str)
{
   this.data2Str = data2Str;
}

/** @return data1Int */
public int getData1Int()
{
   return data1Int;
}

/** @param data1Int */
public void setData1Int(int data1Int)
{
   this.data1Int = data1Int;
}

/** @return data2Int */
public int getData2Int()
{
   return data2Int;
}

/** @param data2Int */
public void setData2Int(int data2Int)
{
   this.data2Int = data2Int;
}

/** @return data1Dec */
public Double getData1Dec()
{
   return data1Dec;
}

/** @param data1Dec */
public void setData1Dec(Double data1Dec)
{
   this.data1Dec = data1Dec;
}

/** @return data2Dec */
public Double getData2Dec()
{
   return data2Dec;
}

/** @param data2Dec */
public void setData2Dec(Double data2Dec)
{
   this.data2Dec = data2Dec;
}

/** @return storeId */
public String getStoreId()
{
   return storeId;
}

/** @param storeId */
public void setStoreId(String storeId)
{
   this.storeId = storeId;
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

}
