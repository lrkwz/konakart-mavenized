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
public class GWT_Store implements IsSerializable
{
/** */
public String storeId;

/** */
public String storeName;

/** */
public boolean deleted;

/** */
public Date lastUpdated;

/** */
public Date dateAdded;

/** */
public String storeDesc;

/** */
public String logoFileName;

/** */
public String cssFileName;

/** */
public boolean enabled;

/** */
public boolean underMaintenance;

/** */
public String adminEmail;

/** */
public boolean template;

/** */
public int maxProducts;

/** */
public String storeHome;

/** */
public String storeUrl;

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

/** @return storeName */
public String getStoreName()
{
   return storeName;
}

/** @param storeName */
public void setStoreName(String storeName)
{
   this.storeName = storeName;
}

/** @return deleted */
public boolean isDeleted()
{
   return deleted;
}

/** @param deleted */
public void setDeleted(boolean deleted)
{
   this.deleted = deleted;
}

/** @return lastUpdated */
public Date getLastUpdated()
{
   return lastUpdated;
}

/** @param lastUpdated */
public void setLastUpdated(Date lastUpdated)
{
   this.lastUpdated = lastUpdated;
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

/** @return storeDesc */
public String getStoreDesc()
{
   return storeDesc;
}

/** @param storeDesc */
public void setStoreDesc(String storeDesc)
{
   this.storeDesc = storeDesc;
}

/** @return logoFileName */
public String getLogoFileName()
{
   return logoFileName;
}

/** @param logoFileName */
public void setLogoFileName(String logoFileName)
{
   this.logoFileName = logoFileName;
}

/** @return cssFileName */
public String getCssFileName()
{
   return cssFileName;
}

/** @param cssFileName */
public void setCssFileName(String cssFileName)
{
   this.cssFileName = cssFileName;
}

/** @return enabled */
public boolean isEnabled()
{
   return enabled;
}

/** @param enabled */
public void setEnabled(boolean enabled)
{
   this.enabled = enabled;
}

/** @return underMaintenance */
public boolean isUnderMaintenance()
{
   return underMaintenance;
}

/** @param underMaintenance */
public void setUnderMaintenance(boolean underMaintenance)
{
   this.underMaintenance = underMaintenance;
}

/** @return adminEmail */
public String getAdminEmail()
{
   return adminEmail;
}

/** @param adminEmail */
public void setAdminEmail(String adminEmail)
{
   this.adminEmail = adminEmail;
}

/** @return template */
public boolean isTemplate()
{
   return template;
}

/** @param template */
public void setTemplate(boolean template)
{
   this.template = template;
}

/** @return maxProducts */
public int getMaxProducts()
{
   return maxProducts;
}

/** @param maxProducts */
public void setMaxProducts(int maxProducts)
{
   this.maxProducts = maxProducts;
}

/** @return storeHome */
public String getStoreHome()
{
   return storeHome;
}

/** @param storeHome */
public void setStoreHome(String storeHome)
{
   this.storeHome = storeHome;
}

/** @return storeUrl */
public String getStoreUrl()
{
   return storeUrl;
}

/** @param storeUrl */
public void setStoreUrl(String storeUrl)
{
   this.storeUrl = storeUrl;
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
