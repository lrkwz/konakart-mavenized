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
public class GWT_IpnHistory implements IsSerializable
{
/** */
public String gatewayFullResponse;

/** */
public String gatewayResult;

/** */
public String gatewayTransactionId;

/** */
public int id;

/** */
public String konakartResultDescription;

/** */
public int konakartResultId;

/** */
public String moduleCode;

/** */
public int orderId;

/** */
public Date dateAdded;

/** */
public int customerId;

/** */
public int subscriptionId;

/** */
public Double txAmount;

/** */
public String txType;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public String custom4;

/** */
public Double custom1Dec;

/** */
public Double custom2Dec;

/** @return gatewayFullResponse */
public String getGatewayFullResponse()
{
   return gatewayFullResponse;
}

/** @param gatewayFullResponse */
public void setGatewayFullResponse(String gatewayFullResponse)
{
   this.gatewayFullResponse = gatewayFullResponse;
}

/** @return gatewayResult */
public String getGatewayResult()
{
   return gatewayResult;
}

/** @param gatewayResult */
public void setGatewayResult(String gatewayResult)
{
   this.gatewayResult = gatewayResult;
}

/** @return gatewayTransactionId */
public String getGatewayTransactionId()
{
   return gatewayTransactionId;
}

/** @param gatewayTransactionId */
public void setGatewayTransactionId(String gatewayTransactionId)
{
   this.gatewayTransactionId = gatewayTransactionId;
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

/** @return konakartResultDescription */
public String getKonakartResultDescription()
{
   return konakartResultDescription;
}

/** @param konakartResultDescription */
public void setKonakartResultDescription(String konakartResultDescription)
{
   this.konakartResultDescription = konakartResultDescription;
}

/** @return konakartResultId */
public int getKonakartResultId()
{
   return konakartResultId;
}

/** @param konakartResultId */
public void setKonakartResultId(int konakartResultId)
{
   this.konakartResultId = konakartResultId;
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

/** @return subscriptionId */
public int getSubscriptionId()
{
   return subscriptionId;
}

/** @param subscriptionId */
public void setSubscriptionId(int subscriptionId)
{
   this.subscriptionId = subscriptionId;
}

/** @return txAmount */
public Double getTxAmount()
{
   return txAmount;
}

/** @param txAmount */
public void setTxAmount(Double txAmount)
{
   this.txAmount = txAmount;
}

/** @return txType */
public String getTxType()
{
   return txType;
}

/** @param txType */
public void setTxType(String txType)
{
   this.txType = txType;
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

/** @return custom1Dec */
public Double getCustom1Dec()
{
   return custom1Dec;
}

/** @param custom1Dec */
public void setCustom1Dec(Double custom1Dec)
{
   this.custom1Dec = custom1Dec;
}

/** @return custom2Dec */
public Double getCustom2Dec()
{
   return custom2Dec;
}

/** @param custom2Dec */
public void setCustom2Dec(Double custom2Dec)
{
   this.custom2Dec = custom2Dec;
}

}
