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
/** */
public class GWT_Currency implements IsSerializable
{
/** */
public String code;

/** */
public String decimalPlaces;

/** */
public String decimalPoint;

/** */
public int id;

/** */
public String symbolLeft;

/** */
public String symbolRight;

/** */
public String thousandsPoint;

/** */
public String title;

/** */
public Double value;

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

/** @return decimalPlaces */
public String getDecimalPlaces()
{
   return decimalPlaces;
}

/** @param decimalPlaces */
public void setDecimalPlaces(String decimalPlaces)
{
   this.decimalPlaces = decimalPlaces;
}

/** @return decimalPoint */
public String getDecimalPoint()
{
   return decimalPoint;
}

/** @param decimalPoint */
public void setDecimalPoint(String decimalPoint)
{
   this.decimalPoint = decimalPoint;
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

/** @return symbolLeft */
public String getSymbolLeft()
{
   return symbolLeft;
}

/** @param symbolLeft */
public void setSymbolLeft(String symbolLeft)
{
   this.symbolLeft = symbolLeft;
}

/** @return symbolRight */
public String getSymbolRight()
{
   return symbolRight;
}

/** @param symbolRight */
public void setSymbolRight(String symbolRight)
{
   this.symbolRight = symbolRight;
}

/** @return thousandsPoint */
public String getThousandsPoint()
{
   return thousandsPoint;
}

/** @param thousandsPoint */
public void setThousandsPoint(String thousandsPoint)
{
   this.thousandsPoint = thousandsPoint;
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

/** @return value */
public Double getValue()
{
   return value;
}

/** @param value */
public void setValue(Double value)
{
   this.value = value;
}

}
