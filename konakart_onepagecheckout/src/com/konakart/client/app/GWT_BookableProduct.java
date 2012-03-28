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
public class GWT_BookableProduct implements IsSerializable
{
/** */
public int productId;

/** */
public int maxNumBookings;

/** */
public int bookingsMade;

/** */
public Date startDate;

/** */
public Date endDate;

/** */
public String monday;

/** */
public String tuesday;

/** */
public String wednesday;

/** */
public String thursday;

/** */
public String friday;

/** */
public String saturday;

/** */
public String sunday;

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

/** @return productId */
public int getProductId()
{
   return productId;
}

/** @param productId */
public void setProductId(int productId)
{
   this.productId = productId;
}

/** @return maxNumBookings */
public int getMaxNumBookings()
{
   return maxNumBookings;
}

/** @param maxNumBookings */
public void setMaxNumBookings(int maxNumBookings)
{
   this.maxNumBookings = maxNumBookings;
}

/** @return bookingsMade */
public int getBookingsMade()
{
   return bookingsMade;
}

/** @param bookingsMade */
public void setBookingsMade(int bookingsMade)
{
   this.bookingsMade = bookingsMade;
}

/** @return startDate */
public Date getStartDate()
{
   return startDate;
}

/** @param startDate */
public void setStartDate(Date startDate)
{
   this.startDate = startDate;
}

/** @return endDate */
public Date getEndDate()
{
   return endDate;
}

/** @param endDate */
public void setEndDate(Date endDate)
{
   this.endDate = endDate;
}

/** @return monday */
public String getMonday()
{
   return monday;
}

/** @param monday */
public void setMonday(String monday)
{
   this.monday = monday;
}

/** @return tuesday */
public String getTuesday()
{
   return tuesday;
}

/** @param tuesday */
public void setTuesday(String tuesday)
{
   this.tuesday = tuesday;
}

/** @return wednesday */
public String getWednesday()
{
   return wednesday;
}

/** @param wednesday */
public void setWednesday(String wednesday)
{
   this.wednesday = wednesday;
}

/** @return thursday */
public String getThursday()
{
   return thursday;
}

/** @param thursday */
public void setThursday(String thursday)
{
   this.thursday = thursday;
}

/** @return friday */
public String getFriday()
{
   return friday;
}

/** @param friday */
public void setFriday(String friday)
{
   this.friday = friday;
}

/** @return saturday */
public String getSaturday()
{
   return saturday;
}

/** @param saturday */
public void setSaturday(String saturday)
{
   this.saturday = saturday;
}

/** @return sunday */
public String getSunday()
{
   return sunday;
}

/** @param sunday */
public void setSunday(String sunday)
{
   this.sunday = sunday;
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

}
