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
public class GWT_EmailOptions implements IsSerializable
{
/** */
public String templateName;

/** */
public String countryCode;

/** */
public GWT_NameValue[] customAttrs;

/** */
public boolean attachInvoice;

/** */
public boolean createInvoice;

/** */
public String fullAttachmentFilename;

/** */
public String friendlyAttachmentName;

/** */
public boolean deleteAttachmentAfterSend;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public int customInt1;

/** */
public int customInt2;

/** @return templateName */
public String getTemplateName()
{
   return templateName;
}

/** @param templateName */
public void setTemplateName(String templateName)
{
   this.templateName = templateName;
}

/** @return countryCode */
public String getCountryCode()
{
   return countryCode;
}

/** @param countryCode */
public void setCountryCode(String countryCode)
{
   this.countryCode = countryCode;
}

/** @return customAttrs */
public GWT_NameValue[] getCustomAttrs()
{
   return customAttrs;
}

/** @param customAttrs */
public void setCustomAttrs(GWT_NameValue[] customAttrs)
{
   this.customAttrs = customAttrs;
}

/** @return attachInvoice */
public boolean isAttachInvoice()
{
   return attachInvoice;
}

/** @param attachInvoice */
public void setAttachInvoice(boolean attachInvoice)
{
   this.attachInvoice = attachInvoice;
}

/** @return createInvoice */
public boolean isCreateInvoice()
{
   return createInvoice;
}

/** @param createInvoice */
public void setCreateInvoice(boolean createInvoice)
{
   this.createInvoice = createInvoice;
}

/** @return fullAttachmentFilename */
public String getFullAttachmentFilename()
{
   return fullAttachmentFilename;
}

/** @param fullAttachmentFilename */
public void setFullAttachmentFilename(String fullAttachmentFilename)
{
   this.fullAttachmentFilename = fullAttachmentFilename;
}

/** @return friendlyAttachmentName */
public String getFriendlyAttachmentName()
{
   return friendlyAttachmentName;
}

/** @param friendlyAttachmentName */
public void setFriendlyAttachmentName(String friendlyAttachmentName)
{
   this.friendlyAttachmentName = friendlyAttachmentName;
}

/** @return deleteAttachmentAfterSend */
public boolean isDeleteAttachmentAfterSend()
{
   return deleteAttachmentAfterSend;
}

/** @param deleteAttachmentAfterSend */
public void setDeleteAttachmentAfterSend(boolean deleteAttachmentAfterSend)
{
   this.deleteAttachmentAfterSend = deleteAttachmentAfterSend;
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

/** @return customInt1 */
public int getCustomInt1()
{
   return customInt1;
}

/** @param customInt1 */
public void setCustomInt1(int customInt1)
{
   this.customInt1 = customInt1;
}

/** @return customInt2 */
public int getCustomInt2()
{
   return customInt2;
}

/** @param customInt2 */
public void setCustomInt2(int customInt2)
{
   this.customInt2 = customInt2;
}

}
