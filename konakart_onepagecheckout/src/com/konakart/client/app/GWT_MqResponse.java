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
public class GWT_MqResponse implements IsSerializable
{
/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public String msgText;

/** */
public boolean timedout;

/** */
public String jMSCorrelationId;

/** */
public String jMSMessageId;

/** */
public int customInt1;

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

/** @return msgText */
public String getMsgText()
{
   return msgText;
}

/** @param msgText */
public void setMsgText(String msgText)
{
   this.msgText = msgText;
}

/** @return timedout */
public boolean isTimedout()
{
   return timedout;
}

/** @param timedout */
public void setTimedout(boolean timedout)
{
   this.timedout = timedout;
}

/** @return jMSCorrelationId */
public String getJMSCorrelationId()
{
   return jMSCorrelationId;
}

/** @param jMSCorrelationId */
public void setJMSCorrelationId(String jMSCorrelationId)
{
   this.jMSCorrelationId = jMSCorrelationId;
}

/** @return jMSMessageId */
public String getJMSMessageId()
{
   return jMSMessageId;
}

/** @param jMSMessageId */
public void setJMSMessageId(String jMSMessageId)
{
   this.jMSMessageId = jMSMessageId;
}

/** @return customInt1 */
public int getCustomInt1()
{
   return customInt1;
}

/** @param customInt1 */
public void setCustomInt1(int customInt1)
{
   this.customInt1 = customInt1;
}

}
