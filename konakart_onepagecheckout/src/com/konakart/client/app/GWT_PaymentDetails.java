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
public class GWT_PaymentDetails implements IsSerializable
{
/** */
public GWT_NameValue[] parameters;

/** */
public String referrer;

/** */
public String postOrGet;

/** */
public String requestUrl;

/** */
public String code;

/** */
public String description;

/** */
public int sortOrder;

/** */
public String title;

/** */
public int orderStatusId;

/** */
public int paymentType;

/** */
public String ccNumber;

/** */
public String ccPostcode;

/** */
public String ccStreetAddress;

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
public String ccCVV;

/** */
public String ccOwner;

/** */
public String ccType;

/** */
public boolean showAddr;

/** */
public boolean showCVV;

/** */
public boolean showPostcode;

/** */
public boolean showType;

/** */
public String ccExpiryMonth;

/** */
public String ccExpiryYear;

/** */
public boolean showOwner;

/** */
public String preProcessCode;

/** @return parameters */
public GWT_NameValue[] getParameters()
{
   return parameters;
}

/** @param parameters */
public void setParameters(GWT_NameValue[] parameters)
{
   this.parameters = parameters;
}

/** @return referrer */
public String getReferrer()
{
   return referrer;
}

/** @param referrer */
public void setReferrer(String referrer)
{
   this.referrer = referrer;
}

/** @return postOrGet */
public String getPostOrGet()
{
   return postOrGet;
}

/** @param postOrGet */
public void setPostOrGet(String postOrGet)
{
   this.postOrGet = postOrGet;
}

/** @return requestUrl */
public String getRequestUrl()
{
   return requestUrl;
}

/** @param requestUrl */
public void setRequestUrl(String requestUrl)
{
   this.requestUrl = requestUrl;
}

/** @return code */
public String getCode()
{
   return code;
}

/** @param code */
public void setCode(String code)
{
   this.code = code;
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

/** @return title */
public String getTitle()
{
   return title;
}

/** @param title */
public void setTitle(String title)
{
   this.title = title;
}

/** @return orderStatusId */
public int getOrderStatusId()
{
   return orderStatusId;
}

/** @param orderStatusId */
public void setOrderStatusId(int orderStatusId)
{
   this.orderStatusId = orderStatusId;
}

/** @return paymentType */
public int getPaymentType()
{
   return paymentType;
}

/** @param paymentType */
public void setPaymentType(int paymentType)
{
   this.paymentType = paymentType;
}

/** @return ccNumber */
public String getCcNumber()
{
   return ccNumber;
}

/** @param ccNumber */
public void setCcNumber(String ccNumber)
{
   this.ccNumber = ccNumber;
}

/** @return ccPostcode */
public String getCcPostcode()
{
   return ccPostcode;
}

/** @param ccPostcode */
public void setCcPostcode(String ccPostcode)
{
   this.ccPostcode = ccPostcode;
}

/** @return ccStreetAddress */
public String getCcStreetAddress()
{
   return ccStreetAddress;
}

/** @param ccStreetAddress */
public void setCcStreetAddress(String ccStreetAddress)
{
   this.ccStreetAddress = ccStreetAddress;
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

/** @return ccCVV */
public String getCcCVV()
{
   return ccCVV;
}

/** @param ccCVV */
public void setCcCVV(String ccCVV)
{
   this.ccCVV = ccCVV;
}

/** @return ccOwner */
public String getCcOwner()
{
   return ccOwner;
}

/** @param ccOwner */
public void setCcOwner(String ccOwner)
{
   this.ccOwner = ccOwner;
}

/** @return ccType */
public String getCcType()
{
   return ccType;
}

/** @param ccType */
public void setCcType(String ccType)
{
   this.ccType = ccType;
}

/** @return showAddr */
public boolean isShowAddr()
{
   return showAddr;
}

/** @param showAddr */
public void setShowAddr(boolean showAddr)
{
   this.showAddr = showAddr;
}

/** @return showCVV */
public boolean isShowCVV()
{
   return showCVV;
}

/** @param showCVV */
public void setShowCVV(boolean showCVV)
{
   this.showCVV = showCVV;
}

/** @return showPostcode */
public boolean isShowPostcode()
{
   return showPostcode;
}

/** @param showPostcode */
public void setShowPostcode(boolean showPostcode)
{
   this.showPostcode = showPostcode;
}

/** @return showType */
public boolean isShowType()
{
   return showType;
}

/** @param showType */
public void setShowType(boolean showType)
{
   this.showType = showType;
}

/** @return ccExpiryMonth */
public String getCcExpiryMonth()
{
   return ccExpiryMonth;
}

/** @param ccExpiryMonth */
public void setCcExpiryMonth(String ccExpiryMonth)
{
   this.ccExpiryMonth = ccExpiryMonth;
}

/** @return ccExpiryYear */
public String getCcExpiryYear()
{
   return ccExpiryYear;
}

/** @param ccExpiryYear */
public void setCcExpiryYear(String ccExpiryYear)
{
   this.ccExpiryYear = ccExpiryYear;
}

/** @return showOwner */
public boolean isShowOwner()
{
   return showOwner;
}

/** @param showOwner */
public void setShowOwner(boolean showOwner)
{
   this.showOwner = showOwner;
}

/** @return preProcessCode */
public String getPreProcessCode()
{
   return preProcessCode;
}

/** @param preProcessCode */
public void setPreProcessCode(String preProcessCode)
{
   this.preProcessCode = preProcessCode;
}

}
