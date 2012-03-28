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
public class GWT_Language implements IsSerializable
{
/** */
public String code;

/** */
public String directory;

/** */
public String locale;

/** */
public int id;

/** */
public String image;

/** */
public String name;

/** */
public int sortOrder;

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

/** @return directory */
public String getDirectory()
{
   return directory;
}

/** @param directory */
public void setDirectory(String directory)
{
   this.directory = directory;
}

/** @return locale */
public String getLocale()
{
   return locale;
}

/** @param locale */
public void setLocale(String locale)
{
   this.locale = locale;
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

}
