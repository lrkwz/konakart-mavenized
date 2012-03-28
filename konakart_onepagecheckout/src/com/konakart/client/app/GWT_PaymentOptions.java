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
public class GWT_PaymentOptions implements IsSerializable
{
/** */
public int orderId;

/** */
public GWT_NameValue[] parameters;

/** */
public GWT_CreditCard creditCard;

/** */
public int action;

/** */
public int subscriptionId;

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

/** @return parameters */
public GWT_NameValue[] getParameters()
{
   return parameters;
}

/** @param parameters */
public void setParameters(GWT_NameValue[] parameters)
{
   this.parameters = parameters;
}

/** @return creditCard */
public GWT_CreditCard getCreditCard()
{
   return creditCard;
}

/** @param creditCard */
public void setCreditCard(GWT_CreditCard creditCard)
{
   this.creditCard = creditCard;
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

}
