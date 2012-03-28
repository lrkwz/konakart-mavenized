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
public class GWT_CreditCard implements IsSerializable
{
/** */
public String ccType;

/** */
public String ccOwner;

/** */
public String ccNumber;

/** */
public String ccExpires;

/** */
public String ccCVV;

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

/** @return ccExpires */
public String getCcExpires()
{
   return ccExpires;
}

/** @param ccExpires */
public void setCcExpires(String ccExpires)
{
   this.ccExpires = ccExpires;
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

}
