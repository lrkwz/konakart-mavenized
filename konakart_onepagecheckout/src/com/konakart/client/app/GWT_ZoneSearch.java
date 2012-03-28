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
public class GWT_ZoneSearch implements IsSerializable
{
/** */
public String searchString;

/** */
public int searchStringRule;

/** */
public int id;

/** */
public int countryId;

/** */
public String code;

/** */
public int codeRule;

/** */
public String name;

/** */
public int nameRule;

/** */
public Boolean invisible;

/** */
public String custom1;

/** */
public int custom1Rule;

/** */
public String custom2;

/** */
public int custom2Rule;

/** */
public String custom3;

/** */
public int custom3Rule;

/** @return searchString */
public String getSearchString()
{
   return searchString;
}

/** @param searchString */
public void setSearchString(String searchString)
{
   this.searchString = searchString;
}

/** @return searchStringRule */
public int getSearchStringRule()
{
   return searchStringRule;
}

/** @param searchStringRule */
public void setSearchStringRule(int searchStringRule)
{
   this.searchStringRule = searchStringRule;
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

/** @return countryId */
public int getCountryId()
{
   return countryId;
}

/** @param countryId */
public void setCountryId(int countryId)
{
   this.countryId = countryId;
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

/** @return codeRule */
public int getCodeRule()
{
   return codeRule;
}

/** @param codeRule */
public void setCodeRule(int codeRule)
{
   this.codeRule = codeRule;
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

/** @return nameRule */
public int getNameRule()
{
   return nameRule;
}

/** @param nameRule */
public void setNameRule(int nameRule)
{
   this.nameRule = nameRule;
}

/** @return invisible */
public Boolean getInvisible()
{
   return invisible;
}

/** @param invisible */
public void setInvisible(Boolean invisible)
{
   this.invisible = invisible;
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

/** @return custom1Rule */
public int getCustom1Rule()
{
   return custom1Rule;
}

/** @param custom1Rule */
public void setCustom1Rule(int custom1Rule)
{
   this.custom1Rule = custom1Rule;
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

/** @return custom2Rule */
public int getCustom2Rule()
{
   return custom2Rule;
}

/** @param custom2Rule */
public void setCustom2Rule(int custom2Rule)
{
   this.custom2Rule = custom2Rule;
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

/** @return custom3Rule */
public int getCustom3Rule()
{
   return custom3Rule;
}

/** @param custom3Rule */
public void setCustom3Rule(int custom3Rule)
{
   this.custom3Rule = custom3Rule;
}

}
