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
public class GWT_OrderStatusHistory implements IsSerializable
{
/** */
public String comments;

/** */
public boolean customerNotified;

/** */
public Date dateAdded;

/** */
public int id;

/** */
public int orderId;

/** */
public String orderStatus;

/** */
public int orderStatusId;

/** @return comments */
public String getComments()
{
   return comments;
}

/** @param comments */
public void setComments(String comments)
{
   this.comments = comments;
}

/** @return customerNotified */
public boolean isCustomerNotified()
{
   return customerNotified;
}

/** @param customerNotified */
public void setCustomerNotified(boolean customerNotified)
{
   this.customerNotified = customerNotified;
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

/** @return orderStatus */
public String getOrderStatus()
{
   return orderStatus;
}

/** @param orderStatus */
public void setOrderStatus(String orderStatus)
{
   this.orderStatus = orderStatus;
}

/** @return orderStatusId */
public int getOrderStatusId()
{
   return orderStatusId;
}

/** @param orderStatusId */
public void setOrderStatusId(int orderStatusId)
{
   this.orderStatusId = orderStatusId;
}

}
