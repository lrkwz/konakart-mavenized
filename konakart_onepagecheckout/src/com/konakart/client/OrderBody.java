//
// (c) 2006 DS Data Systems UK Ltd, All rights reserved.
//
// DS Data Systems and KonaKart and their respective logos, are 
// trademarks of DS Data Systems UK Ltd. All rights reserved.
//
// The information in this document is free software; you can redistribute 
// it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This software is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
package com.konakart.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.konakart.client.app.GWT_Customer;
import com.konakart.client.app.GWT_Option;
import com.konakart.client.app.GWT_Order;
import com.konakart.client.app.GWT_OrderProduct;
import com.konakart.client.app.GWT_OrderStatusHistory;
import com.konakart.client.app.GWT_OrderTotal;
import com.konakart.client.app.GWT_PaymentDetails;
import com.konakart.client.app.GWT_ShippingQuote;
import com.konakart.client.util.GWT_Validation;
import com.konakart.client.util.KKGWTException;

/**
 * Window for viewing order details and confirming the order.
 */
public class OrderBody extends KKBaseWin
{
    /*
     * Objects
     */

    // Customer determined by the sessionId
    private GWT_Customer customer = null;

    // Current Order
    private GWT_Order order = null;

    // Payment details
    private GWT_PaymentDetails[] paymentDetails;

    // Payment details
    private GWT_ShippingQuote[] shippingQuotes;

    /*
     * Control
     */
    private boolean createOrder;

    // Control passed in from JSP for the repeat order functionality
    private boolean useCheckoutOrder = false;

    // Reward points available
    private int rewardPoints = 0;

    /*
     * Widgets
     */
    private ListBox shippingLB;

    private ListBox paymentLB;

    private TextBox couponTB;

    private TextBox giftCertTB;

    private TextBox pointsTB;

    private TextArea commentTA;

    private HTML updateCouponCssButton;

    private HTML updateGiftCertCssButton;

    private HTML updatePointsCssButton;

    private HTML editCartLink;

    private HTML editDeliveryLink;

    private HTML editBillingLink;

    // Table that contains Order Totals
    private FlexTable ft132;

    // Animated gif for confirm button while waiting for order totals
    private Image confirmWait;

    /*
     * Labels
     */
    private String checkout_confirmation_orderconfirmation = "checkout.confirmation.orderconfirmation";

    private String show_order_details_body_deliveryaddress = "show.order.details.body.deliveryaddress";

    private String show_order_details_body_shippingmethod = "show.order.details.body.shippingmethod";

    private String show_order_details_body_products = "show.order.details.body.products";

    private String show_order_details_body_tax = "show.order.details.body.tax";

    private String show_order_details_body_total = "show.order.details.body.total";

    private String show_order_details_body_billinginformation = "show.order.details.body.billinginformation";

    private String show_order_details_body_billingaddress = "show.order.details.body.billingaddress";

    private String show_order_details_body_paymentmethod = "show.order.details.body.paymentmethod";

    private String checkout_common_couponcode = "checkout.common.couponcode";

    private String checkout_common_giftcertcode = "checkout.common.giftcertcode";

    private String checkout_common_reward_points = "checkout.common.reward_points";

    private String checkout_confirmation_ordercomments = "checkout.confirmation.ordercomments";

    private String one_page_checkout_update_coupon = "one.page.checkout.update.coupon";

    private String one_page_checkout_update_giftcert = "one.page.checkout.update.giftcert";

    private String one_page_checkout_update_points = "one.page.checkout.update.points";

    private String common_edit = "common.edit";

    private String one_page_checkout_no_payment_methods = "one.page.checkout.no.payment.methods";

    private String one_page_checkout_no_shipping_methods = "one.page.checkout.no.shipping.methods";

    private String one_page_checkout_no_shipping_methods_selected = "one.page.checkout.no.shipping.methods.selected";

    private String one_page_checkout_no_payment_methods_selected = "one.page.checkout.no.payment.methods.selected";

    /**
     * Constructor
     * 
     * @param kk
     */
    public OrderBody(Konakart kk)
    {
        setKK(kk);

        // Get the parameters from the JSP
        getParameters("kkLabelForm1");

        // init(/* createOrder */true);
    }

    /**
     * Initialise. If createOrder is set to true, we create a new order. Otherwise we use the
     * current one.
     * 
     * @param createOrder
     */
    public void init(boolean createOrder)
    {
        /*
         * For the functionality Repeat Order, the CheckoutOrder is created in the ActionClass and
         * through the JSP we are told to use the checkoutOrder. This will override the normal
         * process whereby we create a new order from the basket items.
         */
        if (useCheckoutOrder)
        {
            this.createOrder = false;
            useCheckoutOrder = false; // Reset
        } else
        {
            this.createOrder = createOrder;
        }

        // Initialise the widgets
        initWidgets();

        // Start the ball rolling by getting the customer
        getKK().getMyKKGWTService().getCustomer(getCustomerCallback);
    }

    /*
     * ----- Callbacks
     */

    /**
     * After getting the customer we create the order
     */
    AsyncCallback<?> getCustomerCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {

            customer = (GWT_Customer) result;

            if (customer != null && customer.getBasketItems() != null
                    && customer.getBasketItems().length > 0)
            {
                if (createOrder)
                {
                    // Create an order
                    getKK().getMyKKGWTService().createOrder(orderCallback);
                } else
                {
                    // Get an order that already exists
                    getKK().getMyKKGWTService().getOrder(orderCallback);
                }
            } else
            {
                redirect("ShowCartItems.do");
            }
        }
    };

    AsyncCallback<?> orderCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            order = (GWT_Order) result;

            if (order != null)
            {
                // Render the widgets
                render();

                // Get shipping quotes for the order
                getKK().getMyKKGWTService().getShippingQuotes(order, getShippingQuotesCallback);

                // Get payment gateways / types available for the order
                getKK().getMyKKGWTService().getPaymentGateways(order, getPaymentGatewaysCallback);

            } else
            {
                showException(new KKGWTException("Cannot create a new order."), null);
            }

        }
    };

    AsyncCallback<?> getPaymentGatewaysCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            paymentDetails = (GWT_PaymentDetails[]) result;

            paymentLB.clear();

            if (paymentDetails != null && paymentDetails.length > 0)
            {
                for (int i = 0; i < paymentDetails.length; i++)
                {
                    GWT_PaymentDetails details = paymentDetails[i];
                    paymentLB.addItem(details.getDescription(), Integer.toString(i));

                    if (!createOrder)
                    {
                        if (order.getPaymentDetails() != null
                                && order.getPaymentDetails().getCode().equals(details.getCode()))
                        {
                            order.setPaymentDetails(details);
                            paymentLB.setSelectedIndex(i);
                        }
                    }
                }

                if (order.getPaymentDetails() == null)
                {
                    order.setPaymentDetails(paymentDetails[0]);
                }

                // If shipping quotes is null, the call to order totals will be done by the
                // shipping quotes callback when the data arrives
                if (order.getShippingQuote() != null)
                {
                    getOrderTotals();
                }

            } else
            {
                paymentLB.addItem("-------------", one_page_checkout_no_payment_methods);
            }
        }
    };

    AsyncCallback<?> getShippingQuotesCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            shippingQuotes = (GWT_ShippingQuote[]) result;

            shippingLB.clear();

            if (shippingQuotes != null && shippingQuotes.length > 0)
            {
                for (int i = 0; i < shippingQuotes.length; i++)
                {
                    GWT_ShippingQuote quote = shippingQuotes[i];
                    shippingLB.addItem(quote.getDescription(), Integer.toString(i));
                    if (!createOrder)
                    {
                        if (order.getShippingQuote() != null
                                && order.getShippingQuote().getCode().equals(quote.getCode()))
                        {
                            order.setShippingQuote(quote);
                            shippingLB.setSelectedIndex(i);
                        }
                    }
                }

                if (order.getShippingQuote() == null)
                {
                    order.setShippingQuote(shippingQuotes[0]);
                }

                // If payment gateways is null, the call to order totals will be done by the
                // payment gateways callback when the data arrives
                if (order.getPaymentDetails() != null)
                {
                    getOrderTotals();
                }

            } else
            {
                shippingLB.addItem("-------------", one_page_checkout_no_shipping_methods);
            }
        }
    };

    AsyncCallback<?> getOrderTotalsCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            order = (GWT_Order) result;

            if (order != null)
            {
                updateOrderTotals();
            } else
            {
                showException(new KKGWTException("Null order from getOrderTotals."), null);
            }
            showConfirmButton();
        }
    };

    AsyncCallback<?> saveOrderCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {
            // Integer orderId = (Integer) result;
            // debug("Id of saved order = " + orderId);

            // Call the Struts action passing a parameter
            redirect("CheckoutConfirmationSubmit.do?onePage=true");
        }
    };

    AsyncCallback<?> setCouponCodeCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {

        }
    };

    AsyncCallback<?> setGiftCertCodeCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {

        }
    };

    AsyncCallback<?> setRewardPointsCallback = new KKCallback(this)
    {
        public void onSuccess(Object result)
        {

        }
    };

    /*
     * ----- End of Callbacks
     */

    /**
     * Creates the main checkout confirmation table
     */
    private void render()
    {
        int row = 0;

        // Remove the current panel
        removeFromDom();

        // Get the container panel
        HTMLPanel containerPanel = getContainerPanel(2);

        // Get the header
        Widget header = renderHeader(checkout_confirmation_orderconfirmation,
                "table_background_confirmation.gif", checkout_confirmation_orderconfirmation);

        // Add the header to the container panel
        containerPanel.add(header, HEADER_ID);

        // Container table
        FlexTable ft1 = getTable(0, "100%", 0, 0, "body-content-tab");

        // Add spacer
        ft1.setWidget(row++, 0, getVSpacer());

        // Add error table
        ft1.setWidget(row++, 0, errorFT);

        // ft12
        FlexTable ft12 = getTable(0, "100%", 1, 2, null);
        formatCell(ft12, 0, 0, "msg-box-no-pad", null, "top", "30%");
        formatCell(ft12, 0, 1, "msg-box-no-pad", null, "top", "70%");

        // ft121
        FlexTable ft121 = getTable(0, "100%", 0, 2, "body-content-tab");

        ft121.setWidget(0, 0, getEdit(editDeliveryLink, show_order_details_body_deliveryaddress));
        ft121.setHTML(1, 0, removeCData(order.getDeliveryFormattedAddress()));
        ft121.setHTML(2, 0, "<b>" + show_order_details_body_shippingmethod + "</b>");
        ft121.setWidget(3, 0, shippingLB);

        // ft122
        FlexTable ft122 = getTable(0, "100%", 0, 0, "body-content-tab");

        // ft1221
        FlexTable ft1221 = getTable(0, "100%", 0, 2, "body-content-tab");
        formatCell(ft1221, 0, 0, null, null, null, "70%");
        ft1221.getFlexCellFormatter().setColSpan(0, 0, 2);
        formatCell(ft1221, 0, 1, "smallText", "right", null, "1%");
        formatCell(ft1221, 0, 2, "smallText", "right", null, "29%");

        ft1221.setWidget(0, 0, getEdit(editCartLink, show_order_details_body_products));
        ft1221.setHTML(0, 1, "<b>" + show_order_details_body_tax + "</b>");
        ft1221.setHTML(0, 2, "<b>" + show_order_details_body_total + "</b>");

        if (order != null && order.getOrderProducts() != null)
        {
            for (int i = 0; i < order.getOrderProducts().length; i++)
            {
                GWT_OrderProduct op = order.getOrderProducts()[i];
                formatCell(ft1221, i + 1, 0, null, "right", "top", null);
                formatCell(ft1221, i + 1, 1, null, "left", "top", null);
                formatCell(ft1221, i + 1, 2, null, "right", "top", null);
                formatCell(ft1221, i + 1, 3, null, "right", "top", null);

                ft1221.setHTML(i + 1, 0, op.getQuantity() + "&nbsp;x");
                StringBuffer sb = new StringBuffer(op.getName());
                if (op.getOpts() != null)
                {
                    for (int j = 0; j < op.getOpts().length; j++)
                    {
                        GWT_Option opt = op.getOpts()[j];
                        if (opt != null)
                        {
                            if (opt.getType() == 1) // TYPE_VARIABLE_QUANTITY
                            {
                                sb.append("<br><nobr><small>&nbsp;<i> - " + opt.getName() + ": "
                                        + opt.getQuantity() + " " + opt.getValue()
                                        + "</i></small></nobr>");
                            } else
                            {
                                sb.append("<br><nobr><small>&nbsp;<i> - " + opt.getName() + ": "
                                        + opt.getValue() + "</i></small></nobr>");
                            }
                        }
                    }
                }
                ft1221.setHTML(i + 1, 1, sb.toString());

                ft1221.setHTML(i + 1, 2, op.getFormattedTaxRate() + "%");

                if (getKK().isDispPriceWithTax())
                {
                    ft1221.setHTML(i + 1, 3, op.getFormattedFinalPriceIncTax());
                } else
                {
                    ft1221.setHTML(i + 1, 3, op.getFormattedFinalPriceExTax());
                }
            }
        }

        // Attach tables
        ft122.setWidget(0, 0, ft1221);
        ft12.setWidget(0, 0, ft121);
        ft12.setWidget(0, 1, ft122);
        ft1.setWidget(row++, 0, ft12);

        // Add spacer
        ft1.setWidget(row++, 0, getVSpacer());

        ft1.setHTML(row++, 0, "<b>" + show_order_details_body_billinginformation + "</b>");

        // Add spacer
        // ft1.setWidget(row++, 0, getSpacer());

        // ft13
        FlexTable ft13 = getTable(0, "100%", 1, 2, null);
        formatCell(ft13, 0, 0, "msg-box-no-pad", null, "top", "30%");
        formatCell(ft13, 0, 1, "msg-box-no-pad", null, "top", "70%");

        // ft131
        FlexTable ft131 = getTable(0, "100%", 0, 2, "body-content-tab");

        ft131.setWidget(0, 0, getEdit(editBillingLink, show_order_details_body_billingaddress));
        ft131.setHTML(1, 0, removeCData(order.getBillingFormattedAddress()));
        ft131.setHTML(2, 0, "<b>" + show_order_details_body_paymentmethod + "</b>");
        ft131.setWidget(3, 0, paymentLB);

        // ft132 - global
        updateOrderTotals();

        // Attach tables
        ft13.setWidget(0, 0, ft131);
        ft13.setWidget(0, 1, ft132);
        ft1.setWidget(row++, 0, ft13);

        /*
         * Display coupon entry field
         */
        if (getKK().isDispCoupon())
        {
            // Fill in the coupon code
            if (order.getCouponCode() == null)
            {
                couponTB.setValue("");
            } else
            {
                couponTB.setValue(order.getCouponCode());
            }

            // Add spacer
            ft1.setWidget(row++, 0, getVSpacer());

            ft1.setHTML(row++, 0, "<b>" + checkout_common_couponcode + "</b>");

            // ft141
            FlexTable ft141 = getTable(0, "100%", 0, 2, "msg-box-no-pad");
            formatCell(ft141, 0, 0, null, null, "top", "1%");
            formatCell(ft141, 0, 1, "konakart-HandCursor", "left", "top", "99%");
            ft141.setWidget(0, 0, couponTB);
            ft141.setWidget(0, 1, updateCouponCssButton);

            // Attach tables
            ft1.setWidget(row++, 0, ft141);

            // Add spacer
            ft1.setWidget(row++, 0, getVSpacer());
        }

        /*
         * Display gift certificate entry field
         */
        if (getKK().isDispGiftCert())
        {
            // Fill in the giftCert code
            if (order.getGiftCertCode() == null)
            {
                giftCertTB.setValue("");
            } else
            {
                giftCertTB.setValue(order.getGiftCertCode());
            }

            // Add spacer
            ft1.setWidget(row++, 0, getVSpacer());

            ft1.setHTML(row++, 0, "<b>" + checkout_common_giftcertcode + "</b>");

            // ft141
            FlexTable ft141 = getTable(0, "100%", 0, 2, "msg-box-no-pad");
            formatCell(ft141, 0, 0, null, null, "top", "1%");
            formatCell(ft141, 0, 1, "konakart-HandCursor", "left", "top", "99%");
            ft141.setWidget(0, 0, giftCertTB);
            ft141.setWidget(0, 1, updateGiftCertCssButton);

            // Attach tables
            ft1.setWidget(row++, 0, ft141);

            // Add spacer
            ft1.setWidget(row++, 0, getVSpacer());
        }

        /*
         * Display reward points entry field
         */
        if (getKK().isDispRewardPoints() && rewardPoints > 0)
        {
            // Set points input field
            if (order.getPointsRedeemed() > 0)
            {
                pointsTB.setValue(Integer.toString(order.getPointsRedeemed()));
            }

            // Add spacer
            ft1.setWidget(row++, 0, getVSpacer());

            ft1.setHTML(row++, 0, "<b>" + checkout_common_reward_points + "</b>");

            // ft141
            FlexTable ft141 = getTable(0, "100%", 0, 2, "msg-box-no-pad");
            formatCell(ft141, 0, 0, null, null, "top", "1%");
            formatCell(ft141, 0, 1, "konakart-HandCursor", "left", "top", "99%");
            ft141.setWidget(0, 0, pointsTB);
            ft141.setWidget(0, 1, updatePointsCssButton);

            // Attach tables
            ft1.setWidget(row++, 0, ft141);

            // Add spacer
            ft1.setWidget(row++, 0, getVSpacer());
        }

        // Add spacer
        ft1.setWidget(row++, 0, getVSpacer());

        ft1.setHTML(row++, 0, "<b>" + checkout_confirmation_ordercomments + "</b>");

        // ft15
        FlexTable ft15 = getTable(0, "100%", 1, 2, "msg-box-no-pad");

        // ft151
        FlexTable ft151 = getTable(0, "100%", 0, 2, "body-content-tab");
        ft151.setWidget(0, 0, commentTA);

        // Attach tables
        ft15.setWidget(0, 0, ft151);
        ft1.setWidget(row++, 0, ft15);

        containerPanel.add(ft1, BODY_ID);
        containerPanel.add(getButtons(1), BUTTON_ID);
        hideConfirmButton();

        // Finally, add the outer panel to the RootPanel, so that it will be
        // displayed.
        addToDom(containerPanel);
    }

    /**
     * 
     * @return Returns the widget for edit links
     */
    FlexTable getEdit(HTML link, String text)
    {
        FlexTable t1 = new FlexTable();
        formatCell(t1, 0, 0, "body-content-tab", "left", null, "1%");
        formatCell(t1, 0, 1, "orderEdit", "left", null, "99%");
        HTML label = new HTML("<b>" + text + "</b>");
        label.setWordWrap(false);
        t1.setWidget(0, 0, label);
        t1.setWidget(0, 1, link);
        return t1;
    }

    /**
     * Set attributes from hidden parameters in JSP
     */
    protected void setAttr(String name, String value)
    {
        if (name.equals("checkout.confirmation.orderconfirmation"))
        {
            checkout_confirmation_orderconfirmation = value;
        } else if (name.equals("show.order.details.body.deliveryaddress"))
        {
            show_order_details_body_deliveryaddress = value;
        } else if (name.equals("show.order.details.body.shippingmethod"))
        {
            show_order_details_body_shippingmethod = value;
        } else if (name.equals("show.order.details.body.products"))
        {
            show_order_details_body_products = value;
        } else if (name.equals("show.order.details.body.tax"))
        {
            show_order_details_body_tax = value;
        } else if (name.equals("show.order.details.body.total"))
        {
            show_order_details_body_total = value;
        } else if (name.equals("show.order.details.body.billinginformation"))
        {
            show_order_details_body_billinginformation = value;
        } else if (name.equals("show.order.details.body.billingaddress"))
        {
            show_order_details_body_billingaddress = value;
        } else if (name.equals("show.order.details.body.paymentmethod"))
        {
            show_order_details_body_paymentmethod = value;
        } else if (name.equals("checkout.common.couponcode"))
        {
            checkout_common_couponcode = value;
        } else if (name.equals("checkout.common.giftcertcode"))
        {
            checkout_common_giftcertcode = value;
        } else if (name.equals("checkout.common.reward_points"))
        {
            checkout_common_reward_points = value;
        } else if (name.equals("reward.points.available"))
        {
            rewardPoints = Integer.parseInt(value);
        } else if (name.equals("checkout.confirmation.ordercomments"))
        {
            checkout_confirmation_ordercomments = value;
        } else if (name.equals("one.page.checkout.update.coupon"))
        {
            one_page_checkout_update_coupon = value;
        } else if (name.equals("one.page.checkout.update.giftcert"))
        {
            one_page_checkout_update_giftcert = value;
        } else if (name.equals("one.page.checkout.update.points"))
        {
            one_page_checkout_update_points = value;
        } else if (name.equals("common.edit"))
        {
            common_edit = value;
        } else if (name.equals("one.page.checkout.no.payment.methods"))
        {
            one_page_checkout_no_payment_methods = value;
        } else if (name.equals("one.page.checkout.no.shipping.methods"))
        {
            one_page_checkout_no_shipping_methods = value;
        } else if (name.equals("one.page.checkout.no.shipping.methods.selected"))
        {
            one_page_checkout_no_shipping_methods_selected = value;
        } else if (name.equals("one.page.checkout.no.payment.methods.selected"))
        {
            one_page_checkout_no_payment_methods_selected = value;
        } else if (name.equals("use.checkout.order"))
        {
            useCheckoutOrder = new Boolean(value).booleanValue();
        }
    }

    /**
     * Initialise widgets to ensure that they are there for when the data arrives
     */
    protected void initWidgets()
    {
        super.initWidgets();

        shippingLB = new ListBox();
        initListBox(shippingLB);

        paymentLB = new ListBox();
        initListBox(paymentLB);

        couponTB = new TextBox();
        initTextBox(couponTB);
        couponTB.setWidth("20em");

        giftCertTB = new TextBox();
        initTextBox(giftCertTB);
        giftCertTB.setWidth("20em");

        pointsTB = new TextBox();
        initTextBox(pointsTB);
        pointsTB.setWidth("20em");

        commentTA = new TextArea();
        initTextArea(commentTA);

        updateCouponCssButton = new HTML("<a class=\"button\"><span>"
                + one_page_checkout_update_coupon + "</span></a>");
        initHTML(updateCouponCssButton);

        updateGiftCertCssButton = new HTML("<a class=\"button\"><span>"
                + one_page_checkout_update_giftcert + "</span></a>");
        initHTML(updateGiftCertCssButton);

        updatePointsCssButton = new HTML("<a class=\"button\"><span>"
                + one_page_checkout_update_points + "</span></a>");
        initHTML(updatePointsCssButton);

        confirmOrderCssButton = new HTML("<a style=\"float:right\" class=\"button\"><span>"
                + common_confirmorder + "</span></a>");
        initHTML(confirmOrderCssButton);

        editBillingLink = new HTML("<a href='javascript:;'>" + "(" + common_edit + ")" + "</a>");
        editBillingLink.setStyleName("orderEdit");
        initLink(editBillingLink);

        editCartLink = new HTML("<a href='javascript:;'>" + "(" + common_edit + ")" + "</a>");
        editCartLink.setStyleName("orderEdit");
        initLink(editCartLink);

        editDeliveryLink = new HTML("<a href='javascript:;'>" + "(" + common_edit + ")" + "</a>");
        editDeliveryLink.setStyleName("orderEdit");
        initLink(editDeliveryLink);

        confirmWait = new Image(getImages_folder() + "confirm_wait.gif");

    }

    /**
     * Update the order totals when new data arrives
     * 
     */
    private void updateOrderTotals()
    {
        // ft132 - global
        if (ft132 == null)
        {
            ft132 = getTable(0, "100%", 0, 2, "body-content-tab");
        } else
        {
            int rowCount = ft132.getRowCount();
            if (rowCount > 0)
            {
                for (int i = rowCount - 1; i > -1; i--)
                {
                    ft132.removeRow(i);
                }
            }
        }

        if (order.getOrderTotals() != null)
        {
            for (int i = 0; i < order.getOrderTotals().length; i++)
            {
                GWT_OrderTotal ot = order.getOrderTotals()[i];
                formatCell(ft132, i, 0, null, "right", null, "100%");
                formatCell(ft132, i, 1, null, "right", null, null);

                if (ot.getClassName() != null && ot.getClassName().equals("ot_reward_points"))
                {
                    ft132.setHTML(i, 0, ot.getTitle());
                    if (ot.getValue() != null)
                    {
                        ft132.setHTML(i, 1, ot.getValue().toString());
                    } else
                    {
                        ft132.setHTML(i, 1, "0");
                    }
                } else if (ot.getClassName() != null && ot.getClassName().equals("ot_free_product"))
                {
                    ft132.getFlexCellFormatter().setWordWrap(i, 1, false);
                    ft132.setHTML(i, 0, ot.getTitle());
                    ft132.setHTML(i, 1, ot.getText());
                } else
                {
                    ft132.setHTML(i, 0, ot.getTitle());
                    ft132.setHTML(i, 1, ot.getFormattedValue());
                }
            }
        }
    }

    /**
     * Initialises the list box
     * 
     * @param listBox
     */
    private void initListBox(ListBox listBox)
    {
        listBox.setWidth("100%");

        listBox.addChangeHandler(new ChangeHandler()
        {
            public void onChange(ChangeEvent event)
            {
                Widget sender = (Widget) event.getSource();

                if (sender == shippingLB)
                {
                    int index = shippingLB.getSelectedIndex();
                    order.setShippingQuote(shippingQuotes[index]);

                    getOrderTotals();

                } else if (sender == paymentLB)
                {
                    int index = paymentLB.getSelectedIndex();
                    order.setPaymentDetails(paymentDetails[index]);

                    getOrderTotals();
                }
            }
        });
    }

    /**
     * Initialises the text box
     * 
     * @param textBox
     */
    private void initTextBox(TextBox textBox)
    {
        textBox.setTextAlignment(TextBoxBase.ALIGN_LEFT);
        textBox.addChangeHandler(new ChangeHandler()
        {
            public void onChange(ChangeEvent event)
            {

            }
        });

        if (textBox == pointsTB)
        {
            textBox.addKeyUpHandler(new KeyUpHandler()
            {
                public void onKeyUp(KeyUpEvent event)
                {

                    GWT_Validation.validateIntOptional(pointsTB, new Integer(0), new Integer(
                            rewardPoints), null);
                }
            });
        }
    }

    /**
     * Initialises the text area
     * 
     * @param textBox
     */
    private void initTextArea(TextArea textArea)
    {
        textArea.setTextAlignment(TextBoxBase.ALIGN_LEFT);
        textArea.setWidth("100%");
        textArea.setHeight("3em");
    }

    /**
     * Validate Order
     * 
     * @return Return true if order is valid
     */
    private boolean isOrderValid()
    {
        if (order == null)
        {
            return false;
        }

        clearErrorMsg();

        boolean ret = true;
        if (order.getPaymentDetails() == null)
        {
            setErrorMsg(one_page_checkout_no_payment_methods_selected);
            ret = false;
        }
        if (order.getShippingQuote() == null)
        {
            setErrorMsg(one_page_checkout_no_shipping_methods_selected);
            ret = false;
        }

        return ret;
    }

    /**
     * Initialises the html
     * 
     * @param html
     */
    private void initHTML(HTML html)
    {
        html.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                Widget sender = (Widget) event.getSource();

                if (sender == confirmOrderCssButton)
                {
                    if (isOrderValid())
                    {
                        // Set the comment before saving
                        GWT_OrderStatusHistory[] oshArray = new GWT_OrderStatusHistory[1];
                        GWT_OrderStatusHistory osh = new GWT_OrderStatusHistory();
                        String comment = "";
                        if (commentTA.getText() != null)
                        {
                            comment = commentTA.getText();
                        }
                        osh.setComments(comment);
                        oshArray[0] = osh;
                        order.setStatusTrail(oshArray);

                        // Save the order
                        getKK().getMyKKGWTService().saveOrder(order, saveOrderCallback);
                    }
                } else if (sender == updateCouponCssButton)
                {
                    order.setCouponCode(couponTB.getText());
                    getOrderTotals();
                    getKK().getMyKKGWTService().setCouponCode(couponTB.getText(),
                            setCouponCodeCallback);
                } else if (sender == updateGiftCertCssButton)
                {
                    order.setGiftCertCode(giftCertTB.getText());
                    getOrderTotals();
                    getKK().getMyKKGWTService().setGiftCertCode(giftCertTB.getText(),
                            setGiftCertCodeCallback);
                } else if (sender == updatePointsCssButton)
                {
                    boolean ret = GWT_Validation.validateIntOptional(pointsTB, new Integer(0),
                            new Integer(rewardPoints), null);
                    if (ret)
                    {
                        int points = Integer.parseInt(pointsTB.getText());
                        order.setPointsRedeemed(points);
                        getOrderTotals();
                        getKK().getMyKKGWTService()
                                .setRewardPoints(points, setRewardPointsCallback);
                    }
                }
            }
        });
    }

    /**
     * Initialises the link
     * 
     * @param link
     */
    private void initLink(HTML link)
    {
        link.addClickHandler(new ClickHandler()
        {
            public void onClick(ClickEvent event)
            {
                Widget sender = (Widget) event.getSource();

                if (sender == editBillingLink)
                {
                    getKK().controller(Konakart.EDIT_BILLING_ADDR);
                } else if (sender == editCartLink)
                {
                    getKK().controller(Konakart.EDIT_CART);
                } else if (sender == editDeliveryLink)
                {
                    getKK().controller(Konakart.EDIT_DELIVERY_ADDR);
                }
            }
        });
    }

    /**
     * Helper method
     */
    private void getOrderTotals()
    {
        getKK().getMyKKGWTService().getOrderTotals(order, getOrderTotalsCallback);
    }

    /**
     * Show the confirm button
     */
    private void showConfirmButton()
    {

        FlexTable ft = (FlexTable) confirmWait.getParent();
        if (ft == null)
        {
            ft = (FlexTable) confirmOrderCssButton.getParent();
        }
        ft.setWidget(0, 0, confirmOrderCssButton);
    }

    /**
     * Hide the confirm button
     */
    private void hideConfirmButton()
    {
        FlexTable ft = (FlexTable) confirmOrderCssButton.getParent();
        if (ft == null)
        {
            ft = (FlexTable) confirmWait.getParent();
        }
        ft.setWidget(0, 0, confirmWait);
    }

}
