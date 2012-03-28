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
public class GWT_OrderSearch implements IsSerializable
{
/** */
public Date dateAddedFrom;

/** */
public Date dateAddedTo;

/** */
public int[] includeStatusIds;

/** */
public String creator;

/** */
public int creatorRule;

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

/** @return includeStatusIds */
public int[] getIncludeStatusIds()
{
   return includeStatusIds;
}

/** @param includeStatusIds */
public void setIncludeStatusIds(int[] includeStatusIds)
{
   this.includeStatusIds = includeStatusIds;
}

/** @return creator */
public String getCreator()
{
   return creator;
}

/** @param creator */
public void setCreator(String creator)
{
   this.creator = creator;
}

/** @return creatorRule */
public int getCreatorRule()
{
   return creatorRule;
}

/** @param creatorRule */
public void setCreatorRule(int creatorRule)
{
   this.creatorRule = creatorRule;
}

}
