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
public class GWT_PdfOptions implements IsSerializable
{
/** */
public int id;

/** */
public String custom1;

/** */
public String custom2;

/** */
public int languageId;

/** */
public int type;

/** */
public boolean returnFileName;

/** */
public boolean returnBytes;

/** */
public boolean createFile;

/** */
public String targetFileName;

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

/** @return type */
public int getType()
{
   return type;
}

/** @param type */
public void setType(int type)
{
   this.type = type;
}

/** @return returnFileName */
public boolean isReturnFileName()
{
   return returnFileName;
}

/** @param returnFileName */
public void setReturnFileName(boolean returnFileName)
{
   this.returnFileName = returnFileName;
}

/** @return returnBytes */
public boolean isReturnBytes()
{
   return returnBytes;
}

/** @param returnBytes */
public void setReturnBytes(boolean returnBytes)
{
   this.returnBytes = returnBytes;
}

/** @return createFile */
public boolean isCreateFile()
{
   return createFile;
}

/** @param createFile */
public void setCreateFile(boolean createFile)
{
   this.createFile = createFile;
}

/** @return targetFileName */
public String getTargetFileName()
{
   return targetFileName;
}

/** @param targetFileName */
public void setTargetFileName(String targetFileName)
{
   this.targetFileName = targetFileName;
}

}
