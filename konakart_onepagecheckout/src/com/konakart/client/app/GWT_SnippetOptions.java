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
public class GWT_SnippetOptions implements IsSerializable
{
/** */
public boolean enableSnippets;

/** */
public int numberOfSnippets;

/** */
public int snippetSizeInChars;

/** */
public String preKeywordHighlight;

/** */
public String postKeywordHighlight;

/** */
public boolean escapeHTML;

/** @return enableSnippets */
public boolean isEnableSnippets()
{
   return enableSnippets;
}

/** @param enableSnippets */
public void setEnableSnippets(boolean enableSnippets)
{
   this.enableSnippets = enableSnippets;
}

/** @return numberOfSnippets */
public int getNumberOfSnippets()
{
   return numberOfSnippets;
}

/** @param numberOfSnippets */
public void setNumberOfSnippets(int numberOfSnippets)
{
   this.numberOfSnippets = numberOfSnippets;
}

/** @return snippetSizeInChars */
public int getSnippetSizeInChars()
{
   return snippetSizeInChars;
}

/** @param snippetSizeInChars */
public void setSnippetSizeInChars(int snippetSizeInChars)
{
   this.snippetSizeInChars = snippetSizeInChars;
}

/** @return preKeywordHighlight */
public String getPreKeywordHighlight()
{
   return preKeywordHighlight;
}

/** @param preKeywordHighlight */
public void setPreKeywordHighlight(String preKeywordHighlight)
{
   this.preKeywordHighlight = preKeywordHighlight;
}

/** @return postKeywordHighlight */
public String getPostKeywordHighlight()
{
   return postKeywordHighlight;
}

/** @param postKeywordHighlight */
public void setPostKeywordHighlight(String postKeywordHighlight)
{
   this.postKeywordHighlight = postKeywordHighlight;
}

/** @return escapeHTML */
public boolean isEscapeHTML()
{
   return escapeHTML;
}

/** @param escapeHTML */
public void setEscapeHTML(boolean escapeHTML)
{
   this.escapeHTML = escapeHTML;
}

}
