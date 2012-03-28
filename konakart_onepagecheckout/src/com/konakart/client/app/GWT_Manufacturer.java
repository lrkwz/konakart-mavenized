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
public class GWT_Manufacturer implements IsSerializable
{
/** */
public int id;

/** */
public String image;

/** */
public String name;

/** */
public String url;

/** */
public int urlClicked;

/** */
public Date lastClick;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public String custom4;

/** */
public String custom5;

/** */
public GWT_Address[] addresses;

/** */
public int numberOfProducts;

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

/** @return url */
public String getUrl()
{
   return url;
}

/** @param url */
public void setUrl(String url)
{
   this.url = url;
}

/** @return urlClicked */
public int getUrlClicked()
{
   return urlClicked;
}

/** @param urlClicked */
public void setUrlClicked(int urlClicked)
{
   this.urlClicked = urlClicked;
}

/** @return lastClick */
public Date getLastClick()
{
   return lastClick;
}

/** @param lastClick */
public void setLastClick(Date lastClick)
{
   this.lastClick = lastClick;
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

/** @return custom4 */
public String getCustom4()
{
   return custom4;
}

/** @param custom4 */
public void setCustom4(String custom4)
{
   this.custom4 = custom4;
}

/** @return custom5 */
public String getCustom5()
{
   return custom5;
}

/** @param custom5 */
public void setCustom5(String custom5)
{
   this.custom5 = custom5;
}

/** @return addresses */
public GWT_Address[] getAddresses()
{
   return addresses;
}

/** @param addresses */
public void setAddresses(GWT_Address[] addresses)
{
   this.addresses = addresses;
}

/** @return numberOfProducts */
public int getNumberOfProducts()
{
   return numberOfProducts;
}

/** @param numberOfProducts */
public void setNumberOfProducts(int numberOfProducts)
{
   this.numberOfProducts = numberOfProducts;
}

}
