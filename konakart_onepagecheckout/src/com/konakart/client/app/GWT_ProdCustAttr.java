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
public class GWT_ProdCustAttr implements IsSerializable
{
/** */
public int id;

/** */
public String name;

/** */
public int type;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public String value;

/** */
public String msgCatKey;

/** */
public String template;

/** */
public int facetNumber;

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

/** @return name */
public String getName()
{
   return name;
}

/** @param name */
public void setName(String name)
{
   this.name = name;
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

/** @return msgCatKey */
public String getMsgCatKey()
{
   return msgCatKey;
}

/** @param msgCatKey */
public void setMsgCatKey(String msgCatKey)
{
   this.msgCatKey = msgCatKey;
}

/** @return template */
public String getTemplate()
{
   return template;
}

/** @param template */
public void setTemplate(String template)
{
   this.template = template;
}

/** @return facetNumber */
public int getFacetNumber()
{
   return facetNumber;
}

/** @param facetNumber */
public void setFacetNumber(int facetNumber)
{
   this.facetNumber = facetNumber;
}

}
