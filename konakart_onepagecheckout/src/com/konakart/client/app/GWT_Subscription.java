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
import java.lang.Double;
import java.util.Date;
/** */
public class GWT_Subscription implements IsSerializable
{
/** */
public int id;

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
public Date dateAdded;

/** */
public Date lastModified;

/** */
public int orderId;

/** */
public int productId;

/** */
public String subscriptionCode;

/** */
public Date startDate;

/** */
public Double amount;

/** */
public Double trialAmount;

/** */
public boolean active;

/** */
public boolean problem;

/** */
public String problemDesc;

/** */
public Date lastBillingDate;

/** */
public Date nextBillingDate;

/** */
public GWT_PaymentSchedule paymentSchedule;

/** */
public int paymentScheduleId;

/** */
public String orderNumber;

/** */
public String productSku;

/** */
public int customerId;

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

/** @return dateAdded */
public Date getDateAdded()
{
   return dateAdded;
}

/** @param dateAdded */
public void setDateAdded(Date dateAdded)
{
   this.dateAdded = dateAdded;
}

/** @return lastModified */
public Date getLastModified()
{
   return lastModified;
}

/** @param lastModified */
public void setLastModified(Date lastModified)
{
   this.lastModified = lastModified;
}

/** @return orderId */
public int getOrderId()
{
   return orderId;
}

/** @param orderId */
public void setOrderId(int orderId)
{
   this.orderId = orderId;
}

/** @return productId */
public int getProductId()
{
   return productId;
}

/** @param productId */
public void setProductId(int productId)
{
   this.productId = productId;
}

/** @return subscriptionCode */
public String getSubscriptionCode()
{
   return subscriptionCode;
}

/** @param subscriptionCode */
public void setSubscriptionCode(String subscriptionCode)
{
   this.subscriptionCode = subscriptionCode;
}

/** @return startDate */
public Date getStartDate()
{
   return startDate;
}

/** @param startDate */
public void setStartDate(Date startDate)
{
   this.startDate = startDate;
}

/** @return amount */
public Double getAmount()
{
   return amount;
}

/** @param amount */
public void setAmount(Double amount)
{
   this.amount = amount;
}

/** @return trialAmount */
public Double getTrialAmount()
{
   return trialAmount;
}

/** @param trialAmount */
public void setTrialAmount(Double trialAmount)
{
   this.trialAmount = trialAmount;
}

/** @return active */
public boolean isActive()
{
   return active;
}

/** @param active */
public void setActive(boolean active)
{
   this.active = active;
}

/** @return problem */
public boolean isProblem()
{
   return problem;
}

/** @param problem */
public void setProblem(boolean problem)
{
   this.problem = problem;
}

/** @return problemDesc */
public String getProblemDesc()
{
   return problemDesc;
}

/** @param problemDesc */
public void setProblemDesc(String problemDesc)
{
   this.problemDesc = problemDesc;
}

/** @return lastBillingDate */
public Date getLastBillingDate()
{
   return lastBillingDate;
}

/** @param lastBillingDate */
public void setLastBillingDate(Date lastBillingDate)
{
   this.lastBillingDate = lastBillingDate;
}

/** @return nextBillingDate */
public Date getNextBillingDate()
{
   return nextBillingDate;
}

/** @param nextBillingDate */
public void setNextBillingDate(Date nextBillingDate)
{
   this.nextBillingDate = nextBillingDate;
}

/** @return paymentSchedule */
public GWT_PaymentSchedule getPaymentSchedule()
{
   return paymentSchedule;
}

/** @param paymentSchedule */
public void setPaymentSchedule(GWT_PaymentSchedule paymentSchedule)
{
   this.paymentSchedule = paymentSchedule;
}

/** @return paymentScheduleId */
public int getPaymentScheduleId()
{
   return paymentScheduleId;
}

/** @param paymentScheduleId */
public void setPaymentScheduleId(int paymentScheduleId)
{
   this.paymentScheduleId = paymentScheduleId;
}

/** @return orderNumber */
public String getOrderNumber()
{
   return orderNumber;
}

/** @param orderNumber */
public void setOrderNumber(String orderNumber)
{
   this.orderNumber = orderNumber;
}

/** @return productSku */
public String getProductSku()
{
   return productSku;
}

/** @param productSku */
public void setProductSku(String productSku)
{
   this.productSku = productSku;
}

/** @return customerId */
public int getCustomerId()
{
   return customerId;
}

/** @param customerId */
public void setCustomerId(int customerId)
{
   this.customerId = customerId;
}

}
