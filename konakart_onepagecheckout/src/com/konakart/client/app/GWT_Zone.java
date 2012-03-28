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
public class GWT_Zone implements IsSerializable
{
/** */
public int zoneId;

/** */
public int zoneCountryId;

/** */
public String zoneCode;

/** */
public String zoneName;

/** */
public boolean zoneInvisible;

/** */
public String zoneSearch;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** @return zoneId */
public int getZoneId()
{
   return zoneId;
}

/** @param zoneId */
public void setZoneId(int zoneId)
{
   this.zoneId = zoneId;
}

/** @return zoneCountryId */
public int getZoneCountryId()
{
   return zoneCountryId;
}

/** @param zoneCountryId */
public void setZoneCountryId(int zoneCountryId)
{
   this.zoneCountryId = zoneCountryId;
}

/** @return zoneCode */
public String getZoneCode()
{
   return zoneCode;
}

/** @param zoneCode */
public void setZoneCode(String zoneCode)
{
   this.zoneCode = zoneCode;
}

/** @return zoneName */
public String getZoneName()
{
   return zoneName;
}

/** @param zoneName */
public void setZoneName(String zoneName)
{
   this.zoneName = zoneName;
}

/** @return zoneInvisible */
public boolean isZoneInvisible()
{
   return zoneInvisible;
}

/** @param zoneInvisible */
public void setZoneInvisible(boolean zoneInvisible)
{
   this.zoneInvisible = zoneInvisible;
}

/** @return zoneSearch */
public String getZoneSearch()
{
   return zoneSearch;
}

/** @param zoneSearch */
public void setZoneSearch(String zoneSearch)
{
   this.zoneSearch = zoneSearch;
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

}
