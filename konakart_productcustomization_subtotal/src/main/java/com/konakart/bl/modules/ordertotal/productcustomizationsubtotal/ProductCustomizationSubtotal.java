package com.konakart.bl.modules.ordertotal.productcustomizationsubtotal;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.konakart.app.KKConfiguration;
import com.konakart.app.KKException;
import com.konakart.app.Order;
import com.konakart.app.OrderTotal;
import com.konakart.appif.KKEngIf;
import com.konakart.appif.OptionIf;
import com.konakart.appif.OrderProductIf;
import com.konakart.bl.modules.BaseModule;
import com.konakart.bl.modules.ordertotal.BaseOrderTotalModule;
import com.konakart.bl.modules.ordertotal.OrderTotalInterface;

public class ProductCustomizationSubtotal extends BaseOrderTotalModule
		implements OrderTotalInterface {
	protected static Log log = LogFactory
			.getLog(ProductCustomizationSubtotal.class);

	// Module name must be the same as the class name although it can be all in
	// lowercase
	private static String code = "productcustomizationsubtotal";

	/** Hash Map that contains the static data */
	private static Map<String, StaticData> staticDataHM = Collections
			.synchronizedMap(new HashMap<String, StaticData>());

	private static String bundleName = BaseModule.basePackage
			+ ".ordertotal.productcustomizationsubtotal.ProductCustomizationSubtotal";
	private static HashMap<Locale, ResourceBundle> resourceBundleMap = new HashMap<Locale, ResourceBundle>();

	private static final String MODULE_ORDER_TOTAL_PRODUCTCUSTOMIZATIONSUBTOTAL_STATUS = "MODULE_ORDER_TOTAL_PRODUCTCUSTOMIZATIONSUBTOTAL_STATUS";
	private static final String MODULE_ORDER_TOTAL_PRODUCTCUSTOMIZATIONSUBTOTAL_SORT_ORDER = "MODULE_ORDER_TOTAL_PRODUCTCUSTOMIZATIONSUBTOTAL_SORT_ORDER";
	private static String mutex = "otProductCustomizationSubtotalMutex";

	private final static String MODULE_ORDER_TOTAL_SUBTOTAL_TITLE = "module.order.total.productcustomizationsubtotal.title";

	public ProductCustomizationSubtotal(KKEngIf eng) throws KKException {
		super.init(eng);

		StaticData sd = staticDataHM.get(getStoreId());

		if (sd == null) {
			synchronized (mutex) {
				sd = staticDataHM.get(getStoreId());
				if (sd == null) {
					setStaticVariables();
				}
			}
		}
	}

	@Override
	public OrderTotal getOrderTotal(Order order, boolean dispPriceWithTax,
			Locale locale) throws Exception {
		OrderTotal ot;
		StaticData sd = staticDataHM.get(getStoreId());

		// Get the resource bundle
		ResourceBundle rb = getResourceBundle(mutex, bundleName,
				resourceBundleMap, locale);
		if (rb == null) {
			throw new KKException(
					"A resource file cannot be found for the country "
							+ locale.getCountry());
		}

		ot = new OrderTotal();
		ot.setClassName(code);
		ot.setSortOrder(sd.getSortOrder());
		BigDecimal subTotal = new BigDecimal(0);

		log.debug(order.toString());
		OrderProductIf[] products = order.getOrderProducts();
		if (products != null) {
			for (OrderProductIf product : products) {
				log.debug(product.toString());
				final BigDecimal price = product.getFinalPriceExTax();
				if (price.compareTo(product.getPrice()) != 0) {
					log.debug("Difference bewteen final price and price is:"
							+ price.subtract(product.getPrice()));
					subTotal = subTotal.add(price.subtract(product.getPrice()));
				}
				/**
				 * OptionIf[] options = product.getOpts(); if (options != null)
				 * { for (OptionIf option : options) {
				 * log.debug("option detailes are: " + option.toString()); if
				 * (dispPriceWithTax) { BigDecimal p = option.getPrice0();
				 * subTotal.add((option.getPriceIncTax() != null ? option
				 * .getPriceIncTax() : BigDecimal.ZERO)); } else {
				 * subTotal.add(option.getPriceExTax() != null ? option
				 * .getPriceExTax() : BigDecimal.ZERO); }
				 * 
				 * } }
				 */
			}
		}
		log.debug("Subtotal is " + subTotal.toString());

		ot.setTitle(rb.getString(MODULE_ORDER_TOTAL_SUBTOTAL_TITLE) + ":");
		ot.setText(getCurrMgr().formatPrice(subTotal, order.getCurrencyCode()));
		ot.setValue(subTotal);
		return ot;
	}

	@Override
	public boolean isAvailable() throws KKException {
		return isAvailable(getEng(),
				MODULE_ORDER_TOTAL_PRODUCTCUSTOMIZATIONSUBTOTAL_STATUS);
	}

	@Override
	public int getSortOrder() {
		StaticData sd;
		try {
			sd = staticDataHM.get(getStoreId());
			return sd.getSortOrder();
		} catch (KKException e) {
			log.error("Can't get the store id", e);
			return 0;
		}
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setStaticVariables() throws KKException {
		KKConfiguration conf;
		StaticData staticData = staticDataHM.get(getStoreId());
		if (staticData == null) {
			staticData = new StaticData();
			staticDataHM.put(getStoreId(), staticData);
		}

		conf = getEng().getConfiguration(
				MODULE_ORDER_TOTAL_PRODUCTCUSTOMIZATIONSUBTOTAL_SORT_ORDER);
		if (conf == null) {
			staticData.setSortOrder(0);
		} else {
			staticData.setSortOrder(new Integer(conf.getValue()).intValue());
		}
	}

	/**
	 * Used to store the static data of this module
	 */
	protected class StaticData {
		private int sortOrder = -1;

		/**
		 * @return the sortOrder
		 */
		public int getSortOrder() {
			return sortOrder;
		}

		/**
		 * @param sortOrder
		 *            the sortOrder to set
		 */
		public void setSortOrder(int sortOrder) {
			this.sortOrder = sortOrder;
		}
	}
}
