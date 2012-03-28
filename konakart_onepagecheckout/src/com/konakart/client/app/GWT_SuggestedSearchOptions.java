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
public class GWT_SuggestedSearchOptions implements IsSerializable
{
/** */
public int limit;

/** */
public String searchText;

/** */
public boolean returnRichText;

/** */
public boolean returnRawText;

/** */
public String startTag;

/** */
public String endTag;

/** */
public String languageCode;

/** */
public int languageId;

/** @return limit */
public int getLimit()
{
   return limit;
}

/** @param limit */
public void setLimit(int limit)
{
   this.limit = limit;
}

/** @return searchText */
public String getSearchText()
{
   return searchText;
}

/** @param searchText */
public void setSearchText(String searchText)
{
   this.searchText = searchText;
}

/** @return returnRichText */
public boolean isReturnRichText()
{
   return returnRichText;
}

/** @param returnRichText */
public void setReturnRichText(boolean returnRichText)
{
   this.returnRichText = returnRichText;
}

/** @return returnRawText */
public boolean isReturnRawText()
{
   return returnRawText;
}

/** @param returnRawText */
public void setReturnRawText(boolean returnRawText)
{
   this.returnRawText = returnRawText;
}

/** @return startTag */
public String getStartTag()
{
   return startTag;
}

/** @param startTag */
public void setStartTag(String startTag)
{
   this.startTag = startTag;
}

/** @return endTag */
public String getEndTag()
{
   return endTag;
}

/** @param endTag */
public void setEndTag(String endTag)
{
   this.endTag = endTag;
}

/** @return languageCode */
public String getLanguageCode()
{
   return languageCode;
}

/** @param languageCode */
public void setLanguageCode(String languageCode)
{
   this.languageCode = languageCode;
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

}
