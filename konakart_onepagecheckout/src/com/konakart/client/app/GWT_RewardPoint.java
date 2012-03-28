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
public class GWT_RewardPoint implements IsSerializable
{
/** */
public int id;

/** */
public String storeId;

/** */
public String code;

/** */
public String description;

/** */
public int customerId;

/** */
public int initialPoints;

/** */
public int remainingPoints;

/** */
public boolean expired;

/** */
public int transactionType;

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

/** @return code */
public String getCode()
{
   return code;
}

/** @param code */
public void setCode(String code)
{
   this.code = code;
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

/** @return initialPoints */
public int getInitialPoints()
{
   return initialPoints;
}

/** @param initialPoints */
public void setInitialPoints(int initialPoints)
{
   this.initialPoints = initialPoints;
}

/** @return remainingPoints */
public int getRemainingPoints()
{
   return remainingPoints;
}

/** @param remainingPoints */
public void setRemainingPoints(int remainingPoints)
{
   this.remainingPoints = remainingPoints;
}

/** @return expired */
public boolean isExpired()
{
   return expired;
}

/** @param expired */
public void setExpired(boolean expired)
{
   this.expired = expired;
}

/** @return transactionType */
public int getTransactionType()
{
   return transactionType;
}

/** @param transactionType */
public void setTransactionType(int transactionType)
{
   this.transactionType = transactionType;
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
