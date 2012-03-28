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
public class GWT_ExportOrderOptions implements IsSerializable
{
/** */
public int code;

/** */
public String[] params;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public int orderId;

/** @return code */
public int getCode()
{
   return code;
}

/** @param code */
public void setCode(int code)
{
   this.code = code;
}

/** @return params */
public String[] getParams()
{
   return params;
}

/** @param params */
public void setParams(String[] params)
{
   this.params = params;
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

}
