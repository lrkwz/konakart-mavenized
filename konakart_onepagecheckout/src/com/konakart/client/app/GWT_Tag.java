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
public class GWT_Tag implements IsSerializable
{
/** */
public int id;

/** */
public int languageId;

/** */
public String name;

/** */
public int sortOrder;

/** */
public boolean selected;

/** */
public int numProducts;

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

/** @return sortOrder */
public int getSortOrder()
{
   return sortOrder;
}

/** @param sortOrder */
public void setSortOrder(int sortOrder)
{
   this.sortOrder = sortOrder;
}

/** @return selected */
public boolean isSelected()
{
   return selected;
}

/** @param selected */
public void setSelected(boolean selected)
{
   this.selected = selected;
}

/** @return numProducts */
public int getNumProducts()
{
   return numProducts;
}

/** @param numProducts */
public void setNumProducts(int numProducts)
{
   this.numProducts = numProducts;
}

}
