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
public class GWT_ProductQuantity implements IsSerializable
{
/** */
public String encodedOptionValues;

/** */
public int productId;

/** */
public int quantity;

/** */
public Date dateAvailable;

/** */
public String sku;

/** */
public GWT_Option[] opts;

/** */
public GWT_PromotionResult[] promotionResults;

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
