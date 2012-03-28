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
public class GWT_TagGroup implements IsSerializable
{
/** */
public int id;

/** */
public String description;

/** */
public int languageId;

/** */
public String name;

/** */
public GWT_Tag[] tags;

/** */
public int facetNumber;

/** */
public String facetConstraint;

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

/** @return languageId */
public int getLanguageId()
{
   return languageId;
}

/** @param languageId */
public void setLanguageId(int languageId)
{
   this.languageId = languageId;
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

/** @return facetNumber */
public int getFacetNumber()
{
   return facetNumber;
}

/** @param facetNumber */
public void setFacetNumber(int facetNumber)
{
   this.facetNumber = facetNumber;
}

/** @return facetConstraint */
public String getFacetConstraint()
{
   return facetConstraint;
}

/** @param facetConstraint */
public void setFacetConstraint(String facetConstraint)
{
   this.facetConstraint = facetConstraint;
}

}
