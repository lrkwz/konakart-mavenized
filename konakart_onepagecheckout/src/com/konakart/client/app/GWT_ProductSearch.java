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
public class GWT_ProductSearch implements IsSerializable
{
/** */
public int categoryId;

/** */
public int manufacturerId;

/** */
public Double priceFrom;

/** */
public Double priceTo;

/** */
public String searchText;

/** */
public int whereToSearch;

/** */
public Date dateAddedFrom;

/** */
public Date dateAddedTo;

/** */
public boolean searchInSubCats;

/** */
public GWT_TagGroup[] tagGroups;

/** */
public boolean searchAllStores;

/** */
public String[] storesToSearch;

/** */
public GWT_SnippetOptions snippetOptions;

/** */
public Double ratingGreaterThan;

/** */
public Double ratingLessThan;

/** */
public Double ratingEqual;

/** */
public Date dateAvailableTo;

/** */
public Date dateAvailableFrom;

/** */
public Date expiryDateTo;

/** */
public Date expiryDateFrom;

/** */
public boolean fillDescription;

/** */
public int searchTextRule;

/** */
public Integer quantityGreaterThan;

/** */
public Integer quantityLessThan;

/** */
public Integer quantityEqual;

/** */
public Date startDateFrom;

/** */
public Date startDateTo;

/** */
public Date endDateFrom;

/** */
public Date endDateTo;

/** */
public Date overlapStartDate;

/** */
public Date overlapEndDate;

/** */
public int productType;

/** */
public boolean returnManufacturerFacets;

/** */
public boolean returnCategoryFacets;

/** */
public int[] manufacturerIds;

/** */
public int[] categoryIds;

/** */
public Integer orderedGreaterThan;

/** */
public Integer orderedLessThan;

/** */
public Integer orderedEqual;

/** */
public boolean returnCustomFacets;

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

/** @return priceFrom */
public Double getPriceFrom()
{
   return priceFrom;
}

/** @param priceFrom */
public void setPriceFrom(Double priceFrom)
{
   this.priceFrom = priceFrom;
}

/** @return priceTo */
public Double getPriceTo()
{
   return priceTo;
}

/** @param priceTo */
public void setPriceTo(Double priceTo)
{
   this.priceTo = priceTo;
}

/** @return searchText */
public String getSearchText()
{
   return searchText;
}

/** @param searchText */
public void setSearchText(String searchText)
{
   this.searchText = searchText;
}

/** @return whereToSearch */
public int getWhereToSearch()
{
   return whereToSearch;
}

/** @param whereToSearch */
public void setWhereToSearch(int whereToSearch)
{
   this.whereToSearch = whereToSearch;
}

/** @return dateAddedFrom */
public Date getDateAddedFrom()
{
   return dateAddedFrom;
}

/** @param dateAddedFrom */
public void setDateAddedFrom(Date dateAddedFrom)
{
   this.dateAddedFrom = dateAddedFrom;
}

/** @return dateAddedTo */
public Date getDateAddedTo()
{
   return dateAddedTo;
}

/** @param dateAddedTo */
public void setDateAddedTo(Date dateAddedTo)
{
   this.dateAddedTo = dateAddedTo;
}

/** @return searchInSubCats */
public boolean isSearchInSubCats()
{
   return searchInSubCats;
}

/** @param searchInSubCats */
public void setSearchInSubCats(boolean searchInSubCats)
{
   this.searchInSubCats = searchInSubCats;
}

/** @return tagGroups */
public GWT_TagGroup[] getTagGroups()
{
   return tagGroups;
}

/** @param tagGroups */
public void setTagGroups(GWT_TagGroup[] tagGroups)
{
   this.tagGroups = tagGroups;
}

/** @return searchAllStores */
public boolean isSearchAllStores()
{
   return searchAllStores;
}

/** @param searchAllStores */
public void setSearchAllStores(boolean searchAllStores)
{
   this.searchAllStores = searchAllStores;
}

/** @return storesToSearch */
public String[] getStoresToSearch()
{
   return storesToSearch;
}

/** @param storesToSearch */
public void setStoresToSearch(String[] storesToSearch)
{
   this.storesToSearch = storesToSearch;
}

/** @return snippetOptions */
public GWT_SnippetOptions getSnippetOptions()
{
   return snippetOptions;
}

/** @param snippetOptions */
public void setSnippetOptions(GWT_SnippetOptions snippetOptions)
{
   this.snippetOptions = snippetOptions;
}

/** @return ratingGreaterThan */
public Double getRatingGreaterThan()
{
   return ratingGreaterThan;
}

/** @param ratingGreaterThan */
public void setRatingGreaterThan(Double ratingGreaterThan)
{
   this.ratingGreaterThan = ratingGreaterThan;
}

/** @return ratingLessThan */
public Double getRatingLessThan()
{
   return ratingLessThan;
}

/** @param ratingLessThan */
public void setRatingLessThan(Double ratingLessThan)
{
   this.ratingLessThan = ratingLessThan;
}

/** @return ratingEqual */
public Double getRatingEqual()
{
   return ratingEqual;
}

/** @param ratingEqual */
public void setRatingEqual(Double ratingEqual)
{
   this.ratingEqual = ratingEqual;
}

/** @return dateAvailableTo */
public Date getDateAvailableTo()
{
   return dateAvailableTo;
}

/** @param dateAvailableTo */
public void setDateAvailableTo(Date dateAvailableTo)
{
   this.dateAvailableTo = dateAvailableTo;
}

/** @return dateAvailableFrom */
public Date getDateAvailableFrom()
{
   return dateAvailableFrom;
}

/** @param dateAvailableFrom */
public void setDateAvailableFrom(Date dateAvailableFrom)
{
   this.dateAvailableFrom = dateAvailableFrom;
}

/** @return expiryDateTo */
public Date getExpiryDateTo()
{
   return expiryDateTo;
}

/** @param expiryDateTo */
public void setExpiryDateTo(Date expiryDateTo)
{
   this.expiryDateTo = expiryDateTo;
}

/** @return expiryDateFrom */
public Date getExpiryDateFrom()
{
   return expiryDateFrom;
}

/** @param expiryDateFrom */
public void setExpiryDateFrom(Date expiryDateFrom)
{
   this.expiryDateFrom = expiryDateFrom;
}

/** @return fillDescription */
public boolean isFillDescription()
{
   return fillDescription;
}

/** @param fillDescription */
public void setFillDescription(boolean fillDescription)
{
   this.fillDescription = fillDescription;
}

/** @return searchTextRule */
public int getSearchTextRule()
{
   return searchTextRule;
}

/** @param searchTextRule */
public void setSearchTextRule(int searchTextRule)
{
   this.searchTextRule = searchTextRule;
}

/** @return quantityGreaterThan */
public Integer getQuantityGreaterThan()
{
   return quantityGreaterThan;
}

/** @param quantityGreaterThan */
public void setQuantityGreaterThan(Integer quantityGreaterThan)
{
   this.quantityGreaterThan = quantityGreaterThan;
}

/** @return quantityLessThan */
public Integer getQuantityLessThan()
{
   return quantityLessThan;
}

/** @param quantityLessThan */
public void setQuantityLessThan(Integer quantityLessThan)
{
   this.quantityLessThan = quantityLessThan;
}

/** @return quantityEqual */
public Integer getQuantityEqual()
{
   return quantityEqual;
}

/** @param quantityEqual */
public void setQuantityEqual(Integer quantityEqual)
{
   this.quantityEqual = quantityEqual;
}

/** @return startDateFrom */
public Date getStartDateFrom()
{
   return startDateFrom;
}

/** @param startDateFrom */
public void setStartDateFrom(Date startDateFrom)
{
   this.startDateFrom = startDateFrom;
}

/** @return startDateTo */
public Date getStartDateTo()
{
   return startDateTo;
}

/** @param startDateTo */
public void setStartDateTo(Date startDateTo)
{
   this.startDateTo = startDateTo;
}

/** @return endDateFrom */
public Date getEndDateFrom()
{
   return endDateFrom;
}

/** @param endDateFrom */
public void setEndDateFrom(Date endDateFrom)
{
   this.endDateFrom = endDateFrom;
}

/** @return endDateTo */
public Date getEndDateTo()
{
   return endDateTo;
}

/** @param endDateTo */
public void setEndDateTo(Date endDateTo)
{
   this.endDateTo = endDateTo;
}

/** @return overlapStartDate */
public Date getOverlapStartDate()
{
   return overlapStartDate;
}

/** @param overlapStartDate */
public void setOverlapStartDate(Date overlapStartDate)
{
   this.overlapStartDate = overlapStartDate;
}

/** @return overlapEndDate */
public Date getOverlapEndDate()
{
   return overlapEndDate;
}

/** @param overlapEndDate */
public void setOverlapEndDate(Date overlapEndDate)
{
   this.overlapEndDate = overlapEndDate;
}

/** @return productType */
public int getProductType()
{
   return productType;
}

/** @param productType */
public void setProductType(int productType)
{
   this.productType = productType;
}

/** @return returnManufacturerFacets */
public boolean isReturnManufacturerFacets()
{
   return returnManufacturerFacets;
}

/** @param returnManufacturerFacets */
public void setReturnManufacturerFacets(boolean returnManufacturerFacets)
{
   this.returnManufacturerFacets = returnManufacturerFacets;
}

/** @return returnCategoryFacets */
public boolean isReturnCategoryFacets()
{
   return returnCategoryFacets;
}

/** @param returnCategoryFacets */
public void setReturnCategoryFacets(boolean returnCategoryFacets)
{
   this.returnCategoryFacets = returnCategoryFacets;
}

/** @return manufacturerIds */
public int[] getManufacturerIds()
{
   return manufacturerIds;
}

/** @param manufacturerIds */
public void setManufacturerIds(int[] manufacturerIds)
{
   this.manufacturerIds = manufacturerIds;
}

/** @return categoryIds */
public int[] getCategoryIds()
{
   return categoryIds;
}

/** @param categoryIds */
public void setCategoryIds(int[] categoryIds)
{
   this.categoryIds = categoryIds;
}

/** @return orderedGreaterThan */
public Integer getOrderedGreaterThan()
{
   return orderedGreaterThan;
}

/** @param orderedGreaterThan */
public void setOrderedGreaterThan(Integer orderedGreaterThan)
{
   this.orderedGreaterThan = orderedGreaterThan;
}

/** @return orderedLessThan */
public Integer getOrderedLessThan()
{
   return orderedLessThan;
}

/** @param orderedLessThan */
public void setOrderedLessThan(Integer orderedLessThan)
{
   this.orderedLessThan = orderedLessThan;
}

/** @return orderedEqual */
public Integer getOrderedEqual()
{
   return orderedEqual;
}

/** @param orderedEqual */
public void setOrderedEqual(Integer orderedEqual)
{
   this.orderedEqual = orderedEqual;
}

/** @return returnCustomFacets */
public boolean isReturnCustomFacets()
{
   return returnCustomFacets;
}

/** @param returnCustomFacets */
public void setReturnCustomFacets(boolean returnCustomFacets)
{
   this.returnCustomFacets = returnCustomFacets;
}

}
