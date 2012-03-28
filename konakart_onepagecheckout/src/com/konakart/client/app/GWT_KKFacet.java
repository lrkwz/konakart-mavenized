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
public class GWT_KKFacet implements IsSerializable
{
/** */
public String name;

/** */
public int number;

/** */
public GWT_NameNumber[] values;

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

/** @return number */
public int getNumber()
{
   return number;
}

/** @param number */
public void setNumber(int number)
{
   this.number = number;
}

/** @return values */
public GWT_NameNumber[] getValues()
{
   return values;
}

/** @param values */
public void setValues(GWT_NameNumber[] values)
{
   this.values = values;
}

}
