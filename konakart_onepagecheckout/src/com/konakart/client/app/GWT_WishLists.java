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
public class GWT_WishLists implements IsSerializable
{
/** */
public int totalNumWishLists;

/** */
public GWT_WishList[] wishListArray;

/** @return totalNumWishLists */
public int getTotalNumWishLists()
{
   return totalNumWishLists;
}

/** @param totalNumWishLists */
public void setTotalNumWishLists(int totalNumWishLists)
{
   this.totalNumWishLists = totalNumWishLists;
}

/** @return wishListArray */
public GWT_WishList[] getWishListArray()
{
   return wishListArray;
}

/** @param wishListArray */
public void setWishListArray(GWT_WishList[] wishListArray)
{
   this.wishListArray = wishListArray;
}

}
