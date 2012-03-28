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
import java.lang.Double;
import java.util.Date;
/** */
public class GWT_Review implements IsSerializable
{
/** */
public int customerId;

/** */
public String customerName;

/** */
public int id;

/** */
public int languageId;

/** */
public String languageName;

/** */
public int productId;

/** */
public int rating;

/** */
public Double averageRating;

/** */
public String reviewText;

/** */
public int timesRead;

/** */
public Date dateAdded;

/** */
public GWT_Product product;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

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

/** @return customerName */
public String getCustomerName()
{
   return customerName;
}

/** @param customerName */
public void setCustomerName(String customerName)
{
   this.customerName = customerName;
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

/** @return languageId */
public int getLanguageId()
{
   return languageId;
}

/** @param languageId */
public void setLanguageId(int languageId)
{
   this.languageId = languageId;
}

/** @return languageName */
public String getLanguageName()
{
   return languageName;
}

/** @param languageName */
public void setLanguageName(String languageName)
{
   this.languageName = languageName;
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

/** @return rating */
public int getRating()
{
   return rating;
}

/** @param rating */
public void setRating(int rating)
{
   this.rating = rating;
}

/** @return averageRating */
public Double getAverageRating()
{
   return averageRating;
}

/** @param averageRating */
public void setAverageRating(Double averageRating)
{
   this.averageRating = averageRating;
}

/** @return reviewText */
public String getReviewText()
{
   return reviewText;
}

/** @param reviewText */
public void setReviewText(String reviewText)
{
   this.reviewText = reviewText;
}

/** @return timesRead */
public int getTimesRead()
{
   return timesRead;
}

/** @param timesRead */
public void setTimesRead(int timesRead)
{
   this.timesRead = timesRead;
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
