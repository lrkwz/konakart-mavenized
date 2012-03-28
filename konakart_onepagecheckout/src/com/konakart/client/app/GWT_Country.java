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
public class GWT_Country implements IsSerializable
{
/** */
public int addressFormatId;

/** */
public int id;

/** */
public String isoCode2;

/** */
public String isoCode3;

/** */
public String name;

/** */
public String msgCatKey;

/** @return addressFormatId */
public int getAddressFormatId()
{
   return addressFormatId;
}

/** @param addressFormatId */
public void setAddressFormatId(int addressFormatId)
{
   this.addressFormatId = addressFormatId;
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

/** @return isoCode2 */
public String getIsoCode2()
{
   return isoCode2;
}

/** @param isoCode2 */
public void setIsoCode2(String isoCode2)
{
   this.isoCode2 = isoCode2;
}

/** @return isoCode3 */
public String getIsoCode3()
{
   return isoCode3;
}

/** @param isoCode3 */
public void setIsoCode3(String isoCode3)
{
   this.isoCode3 = isoCode3;
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

}
