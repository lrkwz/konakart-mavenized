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
public class GWT_MqOptions implements IsSerializable
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
public String queueName;

/** */
public String username;

/** */
public String password;

/** */
public String brokerUrl;

/** */
public long timeoutMS;

/** */
public String customInt1;

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

/** @return queueName */
public String getQueueName()
{
   return queueName;
}

/** @param queueName */
public void setQueueName(String queueName)
{
   this.queueName = queueName;
}

/** @return username */
public String getUsername()
{
   return username;
}

/** @param username */
public void setUsername(String username)
{
   this.username = username;
}

/** @return password */
public String getPassword()
{
   return password;
}

/** @param password */
public void setPassword(String password)
{
   this.password = password;
}

/** @return brokerUrl */
public String getBrokerUrl()
{
   return brokerUrl;
}

/** @param brokerUrl */
public void setBrokerUrl(String brokerUrl)
{
   this.brokerUrl = brokerUrl;
}

/** @return timeoutMS */
public long getTimeoutMS()
{
   return timeoutMS;
}

/** @param timeoutMS */
public void setTimeoutMS(long timeoutMS)
{
   this.timeoutMS = timeoutMS;
}

/** @return customInt1 */
public String getCustomInt1()
{
   return customInt1;
}

/** @param customInt1 */
public void setCustomInt1(String customInt1)
{
   this.customInt1 = customInt1;
}

}
