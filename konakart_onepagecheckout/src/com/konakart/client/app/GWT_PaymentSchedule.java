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
public class GWT_PaymentSchedule implements IsSerializable
{
/** */
public int id;

/** */
public int timeUnit;

/** */
public int timeLength;

/** */
public int dayOfMonth;

/** */
public int numPayments;

/** */
public int numTrialPayments;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public String custom4;

/** */
public String custom5;

/** */
public Date dateAdded;

/** */
public String name;

/** */
public String description;

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

/** @return timeUnit */
public int getTimeUnit()
{
   return timeUnit;
}

/** @param timeUnit */
public void setTimeUnit(int timeUnit)
{
   this.timeUnit = timeUnit;
}

/** @return timeLength */
public int getTimeLength()
{
   return timeLength;
}

/** @param timeLength */
public void setTimeLength(int timeLength)
{
   this.timeLength = timeLength;
}

/** @return dayOfMonth */
public int getDayOfMonth()
{
   return dayOfMonth;
}

/** @param dayOfMonth */
public void setDayOfMonth(int dayOfMonth)
{
   this.dayOfMonth = dayOfMonth;
}

/** @return numPayments */
public int getNumPayments()
{
   return numPayments;
}

/** @param numPayments */
public void setNumPayments(int numPayments)
{
   this.numPayments = numPayments;
}

/** @return numTrialPayments */
public int getNumTrialPayments()
{
   return numTrialPayments;
}

/** @param numTrialPayments */
public void setNumTrialPayments(int numTrialPayments)
{
   this.numTrialPayments = numTrialPayments;
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

/** @return custom4 */
public String getCustom4()
{
   return custom4;
}

/** @param custom4 */
public void setCustom4(String custom4)
{
   this.custom4 = custom4;
}

/** @return custom5 */
public String getCustom5()
{
   return custom5;
}

/** @param custom5 */
public void setCustom5(String custom5)
{
   this.custom5 = custom5;
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

}
