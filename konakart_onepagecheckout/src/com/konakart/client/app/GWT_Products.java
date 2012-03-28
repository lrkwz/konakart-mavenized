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
public class GWT_Products implements IsSerializable
{
/** */
public GWT_Product[] productArray;

/** */
public int totalNumProducts;

/** */
public GWT_Manufacturer[] manufacturerFacets;

/** */
public GWT_Category[] categoryFacets;

/** */
public GWT_KKFacet[] customFacets;

/** @return productArray */
public GWT_Product[] getProductArray()
{
   return productArray;
}

/** @param productArray */
public void setProductArray(GWT_Product[] productArray)
{
   this.productArray = productArray;
}

/** @return totalNumProducts */
public int getTotalNumProducts()
{
   return totalNumProducts;
}

/** @param totalNumProducts */
public void setTotalNumProducts(int totalNumProducts)
{
   this.totalNumProducts = totalNumProducts;
}

/** @return manufacturerFacets */
public GWT_Manufacturer[] getManufacturerFacets()
{
   return manufacturerFacets;
}

/** @param manufacturerFacets */
public void setManufacturerFacets(GWT_Manufacturer[] manufacturerFacets)
{
   this.manufacturerFacets = manufacturerFacets;
}

/** @return categoryFacets */
public GWT_Category[] getCategoryFacets()
{
   return categoryFacets;
}

/** @param categoryFacets */
public void setCategoryFacets(GWT_Category[] categoryFacets)
{
   this.categoryFacets = categoryFacets;
}

/** @return customFacets */
public GWT_KKFacet[] getCustomFacets()
{
   return customFacets;
}

/** @param customFacets */
public void setCustomFacets(GWT_KKFacet[] customFacets)
{
   this.customFacets = customFacets;
}

}
