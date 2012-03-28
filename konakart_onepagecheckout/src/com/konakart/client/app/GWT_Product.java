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
public class GWT_Product implements IsSerializable
{
/** */
public int taxClassId;

/** */
public String manufacturerName;

/** */
public String description;

/** */
public int id;

/** */
public String image;

/** */
public String model;

/** */
public String name;

/** */
public GWT_Option[] opts;

/** */
public int quantity;

/** */
public byte status;

/** */
public String url;

/** */
public int viewedCount;

/** */
public Double weight;

/** */
public int numberReviews;

/** */
public Date dateAdded;

/** */
public Date dateAvailable;

/** */
public GWT_Manufacturer manufacturer;

/** */
public int manufacturerId;

/** */
public int categoryId;

/** */
public int ordered;

/** */
public Double priceExTax;

/** */
public Double specialPriceExTax;

/** */
public Double specialPriceIncTax;

/** */
public Double priceIncTax;

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

/** */
public String custom6;

/** */
public String custom7;

/** */
public String custom8;

/** */
public String custom9;

/** */
public String custom10;

/** */
public int custom1Int;

/** */
public int custom2Int;

/** */
public Double custom1Dec;

/** */
public Double custom2Dec;

/** */
public int[] prodRelationTypeArray;

/** */
public byte invisible;

/** */
public String sku;

/** */
public String contentType;

/** */
public String filePath;

/** */
public int type;

/** */
public String image2;

/** */
public String image3;

/** */
public String image4;

/** */
public String comparison;

/** */
public Double price0;

/** */
public Double price1;

/** */
public Double price2;

/** */
public Double price3;

/** */
public int bundledProdQuantity;

/** */
public String encodedOptionValues;

/** */
public GWT_Tag[] tags;

/** */
public String storeId;

/** */
public int maxNumDownloads;

/** */
public int maxDownloadDays;

/** */
public int stockReorderLevel;

/** */
public Boolean canOrderWhenNotInStock;

/** */
public boolean indexAttachment;

/** */
public String[] snippets;

/** */
public Double rating;

/** */
public Date expiryDate;

/** */
public int paymentScheduleId;

/** */
public GWT_PaymentSchedule paymentSchedule;

/** */
public GWT_TierPrice[] tierPrices;

/** */
public Date specialExpiryDate;

/** */
public Date specialStartDate;

/** */
public byte specialStatus;

/** */
public GWT_ProductQuantity[] productQuantities;

/** */
public GWT_Address[] addresses;

/** */
public String customAttrs;

/** */
public GWT_ProdCustAttr[] customAttrArray;

/** */
public String taxCode;

/** */
public String storeCustom1;

/** */
public String storeCustom2;

/** */
public String storeCustom3;

/** */
public GWT_BookableProduct bookableProd;

/** */
public GWT_MiscItem[] miscItems;

/** */
public GWT_PromotionResult[] promotionResults;

/** @return taxClassId */
public int getTaxClassId()
{
   return taxClassId;
}

/** @param taxClassId */
public void setTaxClassId(int taxClassId)
{
   this.taxClassId = taxClassId;
}

/** @return manufacturerName */
public String getManufacturerName()
{
   return manufacturerName;
}

/** @param manufacturerName */
public void setManufacturerName(String manufacturerName)
{
   this.manufacturerName = manufacturerName;
}

/** @return description */
public String getDescription()
{
   return description;
}

/** @param description */
public void setDescription(String description)
{
   this.description = description;
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

/** @return image */
public String getImage()
{
   return image;
}

/** @param image */
public void setImage(String image)
{
   this.image = image;
}

/** @return model */
public String getModel()
{
   return model;
}

/** @param model */
public void setModel(String model)
{
   this.model = model;
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

/** @return opts */
public GWT_Option[] getOpts()
{
   return opts;
}

/** @param opts */
public void setOpts(GWT_Option[] opts)
{
   this.opts = opts;
}

/** @return quantity */
public int getQuantity()
{
   return quantity;
}

/** @param quantity */
public void setQuantity(int quantity)
{
   this.quantity = quantity;
}

/** @return status */
public byte getStatus()
{
   return status;
}

/** @param status */
public void setStatus(byte status)
{
   this.status = status;
}

/** @return url */
public String getUrl()
{
   return url;
}

/** @param url */
public void setUrl(String url)
{
   this.url = url;
}

/** @return viewedCount */
public int getViewedCount()
{
   return viewedCount;
}

/** @param viewedCount */
public void setViewedCount(int viewedCount)
{
   this.viewedCount = viewedCount;
}

/** @return weight */
public Double getWeight()
{
   return weight;
}

/** @param weight */
public void setWeight(Double weight)
{
   this.weight = weight;
}

/** @return numberReviews */
public int getNumberReviews()
{
   return numberReviews;
}

/** @param numberReviews */
public void setNumberReviews(int numberReviews)
{
   this.numberReviews = numberReviews;
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

/** @return dateAvailable */
public Date getDateAvailable()
{
   return dateAvailable;
}

/** @param dateAvailable */
public void setDateAvailable(Date dateAvailable)
{
   this.dateAvailable = dateAvailable;
}

/** @return manufacturer */
public GWT_Manufacturer getManufacturer()
{
   return manufacturer;
}

/** @param manufacturer */
public void setManufacturer(GWT_Manufacturer manufacturer)
{
   this.manufacturer = manufacturer;
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

/** @return ordered */
public int getOrdered()
{
   return ordered;
}

/** @param ordered */
public void setOrdered(int ordered)
{
   this.ordered = ordered;
}

/** @return priceExTax */
public Double getPriceExTax()
{
   return priceExTax;
}

/** @param priceExTax */
public void setPriceExTax(Double priceExTax)
{
   this.priceExTax = priceExTax;
}

/** @return specialPriceExTax */
public Double getSpecialPriceExTax()
{
   return specialPriceExTax;
}

/** @param specialPriceExTax */
public void setSpecialPriceExTax(Double specialPriceExTax)
{
   this.specialPriceExTax = specialPriceExTax;
}

/** @return specialPriceIncTax */
public Double getSpecialPriceIncTax()
{
   return specialPriceIncTax;
}

/** @param specialPriceIncTax */
public void setSpecialPriceIncTax(Double specialPriceIncTax)
{
   this.specialPriceIncTax = specialPriceIncTax;
}

/** @return priceIncTax */
public Double getPriceIncTax()
{
   return priceIncTax;
}

/** @param priceIncTax */
public void setPriceIncTax(Double priceIncTax)
{
   this.priceIncTax = priceIncTax;
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

/** @return custom6 */
public String getCustom6()
{
   return custom6;
}

/** @param custom6 */
public void setCustom6(String custom6)
{
   this.custom6 = custom6;
}

/** @return custom7 */
public String getCustom7()
{
   return custom7;
}

/** @param custom7 */
public void setCustom7(String custom7)
{
   this.custom7 = custom7;
}

/** @return custom8 */
public String getCustom8()
{
   return custom8;
}

/** @param custom8 */
public void setCustom8(String custom8)
{
   this.custom8 = custom8;
}

/** @return custom9 */
public String getCustom9()
{
   return custom9;
}

/** @param custom9 */
public void setCustom9(String custom9)
{
   this.custom9 = custom9;
}

/** @return custom10 */
public String getCustom10()
{
   return custom10;
}

/** @param custom10 */
public void setCustom10(String custom10)
{
   this.custom10 = custom10;
}

/** @return custom1Int */
public int getCustom1Int()
{
   return custom1Int;
}

/** @param custom1Int */
public void setCustom1Int(int custom1Int)
{
   this.custom1Int = custom1Int;
}

/** @return custom2Int */
public int getCustom2Int()
{
   return custom2Int;
}

/** @param custom2Int */
public void setCustom2Int(int custom2Int)
{
   this.custom2Int = custom2Int;
}

/** @return custom1Dec */
public Double getCustom1Dec()
{
   return custom1Dec;
}

/** @param custom1Dec */
public void setCustom1Dec(Double custom1Dec)
{
   this.custom1Dec = custom1Dec;
}

/** @return custom2Dec */
public Double getCustom2Dec()
{
   return custom2Dec;
}

/** @param custom2Dec */
public void setCustom2Dec(Double custom2Dec)
{
   this.custom2Dec = custom2Dec;
}

/** @return prodRelationTypeArray */
public int[] getProdRelationTypeArray()
{
   return prodRelationTypeArray;
}

/** @param prodRelationTypeArray */
public void setProdRelationTypeArray(int[] prodRelationTypeArray)
{
   this.prodRelationTypeArray = prodRelationTypeArray;
}

/** @return invisible */
public byte getInvisible()
{
   return invisible;
}

/** @param invisible */
public void setInvisible(byte invisible)
{
   this.invisible = invisible;
}

/** @return sku */
public String getSku()
{
   return sku;
}

/** @param sku */
public void setSku(String sku)
{
   this.sku = sku;
}

/** @return contentType */
public String getContentType()
{
   return contentType;
}

/** @param contentType */
public void setContentType(String contentType)
{
   this.contentType = contentType;
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

/** @return type */
public int getType()
{
   return type;
}

/** @param type */
public void setType(int type)
{
   this.type = type;
}

/** @return image2 */
public String getImage2()
{
   return image2;
}

/** @param image2 */
public void setImage2(String image2)
{
   this.image2 = image2;
}

/** @return image3 */
public String getImage3()
{
   return image3;
}

/** @param image3 */
public void setImage3(String image3)
{
   this.image3 = image3;
}

/** @return image4 */
public String getImage4()
{
   return image4;
}

/** @param image4 */
public void setImage4(String image4)
{
   this.image4 = image4;
}

/** @return comparison */
public String getComparison()
{
   return comparison;
}

/** @param comparison */
public void setComparison(String comparison)
{
   this.comparison = comparison;
}

/** @return price0 */
public Double getPrice0()
{
   return price0;
}

/** @param price0 */
public void setPrice0(Double price0)
{
   this.price0 = price0;
}

/** @return price1 */
public Double getPrice1()
{
   return price1;
}

/** @param price1 */
public void setPrice1(Double price1)
{
   this.price1 = price1;
}

/** @return price2 */
public Double getPrice2()
{
   return price2;
}

/** @param price2 */
public void setPrice2(Double price2)
{
   this.price2 = price2;
}

/** @return price3 */
public Double getPrice3()
{
   return price3;
}

/** @param price3 */
public void setPrice3(Double price3)
{
   this.price3 = price3;
}

/** @return bundledProdQuantity */
public int getBundledProdQuantity()
{
   return bundledProdQuantity;
}

/** @param bundledProdQuantity */
public void setBundledProdQuantity(int bundledProdQuantity)
{
   this.bundledProdQuantity = bundledProdQuantity;
}

/** @return encodedOptionValues */
public String getEncodedOptionValues()
{
   return encodedOptionValues;
}

/** @param encodedOptionValues */
public void setEncodedOptionValues(String encodedOptionValues)
{
   this.encodedOptionValues = encodedOptionValues;
}

/** @return tags */
public GWT_Tag[] getTags()
{
   return tags;
}

/** @param tags */
public void setTags(GWT_Tag[] tags)
{
   this.tags = tags;
}

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

/** @return maxNumDownloads */
public int getMaxNumDownloads()
{
   return maxNumDownloads;
}

/** @param maxNumDownloads */
public void setMaxNumDownloads(int maxNumDownloads)
{
   this.maxNumDownloads = maxNumDownloads;
}

/** @return maxDownloadDays */
public int getMaxDownloadDays()
{
   return maxDownloadDays;
}

/** @param maxDownloadDays */
public void setMaxDownloadDays(int maxDownloadDays)
{
   this.maxDownloadDays = maxDownloadDays;
}

/** @return stockReorderLevel */
public int getStockReorderLevel()
{
   return stockReorderLevel;
}

/** @param stockReorderLevel */
public void setStockReorderLevel(int stockReorderLevel)
{
   this.stockReorderLevel = stockReorderLevel;
}

/** @return canOrderWhenNotInStock */
public Boolean getCanOrderWhenNotInStock()
{
   return canOrderWhenNotInStock;
}

/** @param canOrderWhenNotInStock */
public void setCanOrderWhenNotInStock(Boolean canOrderWhenNotInStock)
{
   this.canOrderWhenNotInStock = canOrderWhenNotInStock;
}

/** @return indexAttachment */
public boolean isIndexAttachment()
{
   return indexAttachment;
}

/** @param indexAttachment */
public void setIndexAttachment(boolean indexAttachment)
{
   this.indexAttachment = indexAttachment;
}

/** @return snippets */
public String[] getSnippets()
{
   return snippets;
}

/** @param snippets */
public void setSnippets(String[] snippets)
{
   this.snippets = snippets;
}

/** @return rating */
public Double getRating()
{
   return rating;
}

/** @param rating */
public void setRating(Double rating)
{
   this.rating = rating;
}

/** @return expiryDate */
public Date getExpiryDate()
{
   return expiryDate;
}

/** @param expiryDate */
public void setExpiryDate(Date expiryDate)
{
   this.expiryDate = expiryDate;
}

/** @return paymentScheduleId */
public int getPaymentScheduleId()
{
   return paymentScheduleId;
}

/** @param paymentScheduleId */
public void setPaymentScheduleId(int paymentScheduleId)
{
   this.paymentScheduleId = paymentScheduleId;
}

/** @return paymentSchedule */
public GWT_PaymentSchedule getPaymentSchedule()
{
   return paymentSchedule;
}

/** @param paymentSchedule */
public void setPaymentSchedule(GWT_PaymentSchedule paymentSchedule)
{
   this.paymentSchedule = paymentSchedule;
}

/** @return tierPrices */
public GWT_TierPrice[] getTierPrices()
{
   return tierPrices;
}

/** @param tierPrices */
public void setTierPrices(GWT_TierPrice[] tierPrices)
{
   this.tierPrices = tierPrices;
}

/** @return specialExpiryDate */
public Date getSpecialExpiryDate()
{
   return specialExpiryDate;
}

/** @param specialExpiryDate */
public void setSpecialExpiryDate(Date specialExpiryDate)
{
   this.specialExpiryDate = specialExpiryDate;
}

/** @return specialStartDate */
public Date getSpecialStartDate()
{
   return specialStartDate;
}

/** @param specialStartDate */
public void setSpecialStartDate(Date specialStartDate)
{
   this.specialStartDate = specialStartDate;
}

/** @return specialStatus */
public byte getSpecialStatus()
{
   return specialStatus;
}

/** @param specialStatus */
public void setSpecialStatus(byte specialStatus)
{
   this.specialStatus = specialStatus;
}

/** @return productQuantities */
public GWT_ProductQuantity[] getProductQuantities()
{
   return productQuantities;
}

/** @param productQuantities */
public void setProductQuantities(GWT_ProductQuantity[] productQuantities)
{
   this.productQuantities = productQuantities;
}

/** @return addresses */
public GWT_Address[] getAddresses()
{
   return addresses;
}

/** @param addresses */
public void setAddresses(GWT_Address[] addresses)
{
   this.addresses = addresses;
}

/** @return customAttrs */
public String getCustomAttrs()
{
   return customAttrs;
}

/** @param customAttrs */
public void setCustomAttrs(String customAttrs)
{
   this.customAttrs = customAttrs;
}

/** @return customAttrArray */
public GWT_ProdCustAttr[] getCustomAttrArray()
{
   return customAttrArray;
}

/** @param customAttrArray */
public void setCustomAttrArray(GWT_ProdCustAttr[] customAttrArray)
{
   this.customAttrArray = customAttrArray;
}

/** @return taxCode */
public String getTaxCode()
{
   return taxCode;
}

/** @param taxCode */
public void setTaxCode(String taxCode)
{
   this.taxCode = taxCode;
}

/** @return storeCustom1 */
public String getStoreCustom1()
{
   return storeCustom1;
}

/** @param storeCustom1 */
public void setStoreCustom1(String storeCustom1)
{
   this.storeCustom1 = storeCustom1;
}

/** @return storeCustom2 */
public String getStoreCustom2()
{
   return storeCustom2;
}

/** @param storeCustom2 */
public void setStoreCustom2(String storeCustom2)
{
   this.storeCustom2 = storeCustom2;
}

/** @return storeCustom3 */
public String getStoreCustom3()
{
   return storeCustom3;
}

/** @param storeCustom3 */
public void setStoreCustom3(String storeCustom3)
{
   this.storeCustom3 = storeCustom3;
}

/** @return bookableProd */
public GWT_BookableProduct getBookableProd()
{
   return bookableProd;
}

/** @param bookableProd */
public void setBookableProd(GWT_BookableProduct bookableProd)
{
   this.bookableProd = bookableProd;
}

/** @return miscItems */
public GWT_MiscItem[] getMiscItems()
{
   return miscItems;
}

/** @param miscItems */
public void setMiscItems(GWT_MiscItem[] miscItems)
{
   this.miscItems = miscItems;
}

/** @return promotionResults */
public GWT_PromotionResult[] getPromotionResults()
{
   return promotionResults;
}

/** @param promotionResults */
public void setPromotionResults(GWT_PromotionResult[] promotionResults)
{
   this.promotionResults = promotionResults;
}

}
