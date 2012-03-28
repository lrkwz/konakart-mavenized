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
public class GWT_SuggestedSearchItem implements IsSerializable
{
/** */
public String rawText;

/** */
public String richText;

/** */
public int productId;

/** */
public int categoryId;

/** */
public int manufacturerId;

/** */
public int id;

/** @return rawText */
public String getRawText()
{
   return rawText;
}

/** @param rawText */
public void setRawText(String rawText)
{
   this.rawText = rawText;
}

/** @return richText */
public String getRichText()
{
   return richText;
}

/** @param richText */
public void setRichText(String richText)
{
   this.richText = richText;
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

/** @return categoryId */
public int getCategoryId()
{
   return categoryId;
}

/** @param categoryId */
public void setCategoryId(int categoryId)
{
   this.categoryId = categoryId;
}

/** @return manufacturerId */
public int getManufacturerId()
{
   return manufacturerId;
}

/** @param manufacturerId */
public void setManufacturerId(int manufacturerId)
{
   this.manufacturerId = manufacturerId;
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

}
