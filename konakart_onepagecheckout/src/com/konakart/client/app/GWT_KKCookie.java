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
public class GWT_KKCookie implements IsSerializable
{
/** */
public String customerUuid;

/** */
public String attributeId;

/** */
public String attributeValue;

/** */
public Date dateAdded;

/** */
public Date lastModified;

/** @return customerUuid */
public String getCustomerUuid()
{
   return customerUuid;
}

/** @param customerUuid */
public void setCustomerUuid(String customerUuid)
{
   this.customerUuid = customerUuid;
}

/** @return attributeId */
public String getAttributeId()
{
   return attributeId;
}

/** @param attributeId */
public void setAttributeId(String attributeId)
{
   this.attributeId = attributeId;
}

/** @return attributeValue */
public String getAttributeValue()
{
   return attributeValue;
}

/** @param attributeValue */
public void setAttributeValue(String attributeValue)
{
   this.attributeValue = attributeValue;
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

/** @return lastModified */
public Date getLastModified()
{
   return lastModified;
}

/** @param lastModified */
public void setLastModified(Date lastModified)
{
   this.lastModified = lastModified;
}

}
