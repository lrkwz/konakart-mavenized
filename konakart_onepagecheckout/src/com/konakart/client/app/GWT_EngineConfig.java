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
public class GWT_EngineConfig implements IsSerializable
{
/** */
public String storeId;

/** */
public int mode;

/** */
public String propertiesFileName;

/** */
public String appPropertiesFileName;

/** */
public boolean customersShared;

/** */
public boolean productsShared;

/** */
public String engineId;

/** @return storeId */
public String getStoreId()
{
   return storeId;
}

/** @param storeId */
public void setStoreId(String storeId)
{
   this.storeId = storeId;
}

/** @return mode */
public int getMode()
{
   return mode;
}

/** @param mode */
public void setMode(int mode)
{
   this.mode = mode;
}

/** @return propertiesFileName */
public String getPropertiesFileName()
{
   return propertiesFileName;
}

/** @param propertiesFileName */
public void setPropertiesFileName(String propertiesFileName)
{
   this.propertiesFileName = propertiesFileName;
}

/** @return appPropertiesFileName */
public String getAppPropertiesFileName()
{
   return appPropertiesFileName;
}

/** @param appPropertiesFileName */
public void setAppPropertiesFileName(String appPropertiesFileName)
{
   this.appPropertiesFileName = appPropertiesFileName;
}

/** @return customersShared */
public boolean isCustomersShared()
{
   return customersShared;
}

/** @param customersShared */
public void setCustomersShared(boolean customersShared)
{
   this.customersShared = customersShared;
}

/** @return productsShared */
public boolean isProductsShared()
{
   return productsShared;
}

/** @param productsShared */
public void setProductsShared(boolean productsShared)
{
   this.productsShared = productsShared;
}

/** @return engineId */
public String getEngineId()
{
   return engineId;
}

/** @param engineId */
public void setEngineId(String engineId)
{
   this.engineId = engineId;
}

}
