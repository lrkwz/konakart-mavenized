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
public class GWT_PromotionProduct implements IsSerializable
{
/** */
public int optionId;

/** */
public int optionValueId;

/** */
public int productId;

/** @return optionId */
public int getOptionId()
{
   return optionId;
}

/** @param optionId */
public void setOptionId(int optionId)
{
   this.optionId = optionId;
}

/** @return optionValueId */
public int getOptionValueId()
{
   return optionValueId;
}

/** @param optionValueId */
public void setOptionValueId(int optionValueId)
{
   this.optionValueId = optionValueId;
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

}
