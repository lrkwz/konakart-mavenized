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
public class GWT_DigitalDownload implements IsSerializable
{
/** */
public int id;

/** */
public int customerId;

/** */
public Date dateAdded;

/** */
public Date expirationDate;

/** */
public Date lastModified;

/** */
public int maxDownloads;

/** */
public int productId;

/** */
public int timesDownloaded;

/** */
public GWT_Product product;

/** */
public String filePath;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

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

/** @return customerId */
public int getCustomerId()
{
   return customerId;
}

/** @param customerId */
public void setCustomerId(int customerId)
{
   this.customerId = customerId;
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

/** @return expirationDate */
public Date getExpirationDate()
{
   return expirationDate;
}

/** @param expirationDate */
public void setExpirationDate(Date expirationDate)
{
   this.expirationDate = expirationDate;
}

/** @return lastModified */
public Date getLastModified()
{
   return lastModified;
}

/** @param lastModified */
public void setLastModified(Date lastModified)
{
   this.lastModified = lastModified;
}

/** @return maxDownloads */
public int getMaxDownloads()
{
   return maxDownloads;
}

/** @param maxDownloads */
public void setMaxDownloads(int maxDownloads)
{
   this.maxDownloads = maxDownloads;
}

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

/** @return timesDownloaded */
public int getTimesDownloaded()
{
   return timesDownloaded;
}

/** @param timesDownloaded */
public void setTimesDownloaded(int timesDownloaded)
{
   this.timesDownloaded = timesDownloaded;
}

/** @return product */
public GWT_Product getProduct()
{
   return product;
}

/** @param product */
public void setProduct(GWT_Product product)
{
   this.product = product;
}

/** @return filePath */
public String getFilePath()
{
   return filePath;
}

/** @param filePath */
public void setFilePath(String filePath)
{
   this.filePath = filePath;
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
