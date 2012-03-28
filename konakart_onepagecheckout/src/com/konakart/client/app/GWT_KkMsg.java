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
public class GWT_KkMsg implements IsSerializable
{
/** */
public String msgKey;

/** */
public String msgLocale;

/** */
public int msgType;

/** */
public String msgValue;

/** @return msgKey */
public String getMsgKey()
{
   return msgKey;
}

/** @param msgKey */
public void setMsgKey(String msgKey)
{
   this.msgKey = msgKey;
}

/** @return msgLocale */
public String getMsgLocale()
{
   return msgLocale;
}

/** @param msgLocale */
public void setMsgLocale(String msgLocale)
{
   this.msgLocale = msgLocale;
}

/** @return msgType */
public int getMsgType()
{
   return msgType;
}

/** @param msgType */
public void setMsgType(int msgType)
{
   this.msgType = msgType;
}

/** @return msgValue */
public String getMsgValue()
{
   return msgValue;
}

/** @param msgValue */
public void setMsgValue(String msgValue)
{
   this.msgValue = msgValue;
}

}
