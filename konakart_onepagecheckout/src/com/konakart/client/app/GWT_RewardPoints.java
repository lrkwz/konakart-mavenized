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
public class GWT_RewardPoints implements IsSerializable
{
/** */
public int totalNumRecords;

/** */
public GWT_RewardPoint[] rewardPointArray;

/** @return totalNumRecords */
public int getTotalNumRecords()
{
   return totalNumRecords;
}

/** @param totalNumRecords */
public void setTotalNumRecords(int totalNumRecords)
{
   this.totalNumRecords = totalNumRecords;
}

/** @return rewardPointArray */
public GWT_RewardPoint[] getRewardPointArray()
{
   return rewardPointArray;
}

/** @param rewardPointArray */
public void setRewardPointArray(GWT_RewardPoint[] rewardPointArray)
{
   this.rewardPointArray = rewardPointArray;
}

}
