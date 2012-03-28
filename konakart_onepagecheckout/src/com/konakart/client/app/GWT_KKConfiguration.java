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
public class GWT_KKConfiguration implements IsSerializable
{
/** */
public int id;

/** */
public String key;

/** */
public String value;

/** */
public Date lastModified;

/** */
public String storeId;

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

/** @return key */
public String getKey()
{
   return key;
}

/** @param key */
public void setKey(String key)
{
   this.key = key;
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

}
