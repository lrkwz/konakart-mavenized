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
public class GWT_Category implements IsSerializable
{
/** */
public GWT_Category[] children;

/** */
public int id;

/** */
public String image;

/** */
public String name;

/** */
public int numberOfProducts;

/** */
public int parentId;

/** */
public int sortOrder;

/** */
public GWT_Category parent;

/** */
public boolean selected;

/** */
public int level;

/** */
public String custom1;

/** */
public String custom2;

/** */
public String custom3;

/** */
public boolean invisible;

/** */
public String description;

/** */
public GWT_MiscItem[] miscItems;

/** @return children */
public GWT_Category[] getChildren()
{
   return children;
}

/** @param children */
public void setChildren(GWT_Category[] children)
{
   this.children = children;
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

/** @return parentId */
public int getParentId()
{
   return parentId;
}

/** @param parentId */
public void setParentId(int parentId)
{
   this.parentId = parentId;
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

/** @return parent */
public GWT_Category getParent()
{
   return parent;
}

/** @param parent */
public void setParent(GWT_Category parent)
{
   this.parent = parent;
}

/** @return selected */
public boolean isSelected()
{
   return selected;
}

/** @param selected */
public void setSelected(boolean selected)
{
   this.selected = selected;
}

/** @return level */
public int getLevel()
{
   return level;
}

/** @param level */
public void setLevel(int level)
{
   this.level = level;
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

/** @return invisible */
public boolean isInvisible()
{
   return invisible;
}

/** @param invisible */
public void setInvisible(boolean invisible)
{
   this.invisible = invisible;
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

/** @return miscItems */
public GWT_MiscItem[] getMiscItems()
{
   return miscItems;
}

/** @param miscItems */
public void setMiscItems(GWT_MiscItem[] miscItems)
{
   this.miscItems = miscItems;
}

}
