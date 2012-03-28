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
public class GWT_WishListItems implements IsSerializable
{
/** */
public int totalNumItems;

/** */
public GWT_WishListItem[] itemArray;

/** @return totalNumItems */
public int getTotalNumItems()
{
   return totalNumItems;
}

/** @param totalNumItems */
public void setTotalNumItems(int totalNumItems)
{
   this.totalNumItems = totalNumItems;
}

/** @return itemArray */
public GWT_WishListItem[] getItemArray()
{
   return itemArray;
}

/** @param itemArray */
public void setItemArray(GWT_WishListItem[] itemArray)
{
   this.itemArray = itemArray;
}

}
