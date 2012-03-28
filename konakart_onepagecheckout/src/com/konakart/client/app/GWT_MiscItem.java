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
public class GWT_MiscItem implements IsSerializable
{
/** */
public int id;

/** */
public int typeId;

/** */
public int objId;

/** */
public String itemValue;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public Date dateAdded;

/** */
public String type;

/** */
public String typeDescription;

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

/** @return typeId */
public int getTypeId()
{
   return typeId;
}

/** @param typeId */
public void setTypeId(int typeId)
{
   this.typeId = typeId;
}

/** @return objId */
public int getObjId()
{
   return objId;
}

/** @param objId */
public void setObjId(int objId)
{
   this.objId = objId;
}

/** @return itemValue */
public String getItemValue()
{
   return itemValue;
}

/** @param itemValue */
public void setItemValue(String itemValue)
{
   this.itemValue = itemValue;
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

/** @return type */
public String getType()
{
   return type;
}

/** @param type */
public void setType(String type)
{
   this.type = type;
}

/** @return typeDescription */
public String getTypeDescription()
{
   return typeDescription;
}

/** @param typeDescription */
public void setTypeDescription(String typeDescription)
{
   this.typeDescription = typeDescription;
}

}
