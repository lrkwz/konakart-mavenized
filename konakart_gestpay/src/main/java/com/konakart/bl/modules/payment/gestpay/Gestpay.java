/**
 * 
 */
package com.konakart.bl.modules.payment.gestpay;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.konakart.app.KKConfiguration;
import com.konakart.app.KKException;
import com.konakart.app.NameValue;
import com.konakart.app.Order;
import com.konakart.app.PaymentDetails;
import com.konakart.appif.KKEngIf;
import com.konakart.bl.modules.BaseModule;
import com.konakart.bl.modules.payment.BasePaymentModule;
import com.konakart.bl.modules.payment.PaymentInfo;
import com.konakart.bl.modules.payment.PaymentInterface;

/**
 * @author lrkwz
 */
public class Gestpay extends BasePaymentModule implements PaymentInterface {
	protected static Log log = LogFactory.getLog(Gestpay.class);

	public static String transactionIdSeparator = "#";
	private static int sortOrder = -1;
	private static String mutex = "gestpayMutex";

	private static int zone;
	private static Boolean sendBuyerName;
	private static Boolean sendBuyerEmail;
	private static Boolean sendBuyerLanguage;
	private static Boolean sendCustomInfo;
	private static Boolean sendCurrency;
	private static Boolean useOrderNumber;

	private static String gestPayShopId;
	private static String gestPayRequestUrl;

	private static String bundleName = BaseModule.basePackage
			+ ".payment.gestpay.Messages";
	private static HashMap<Locale, ResourceBundle> resourceBundleMap = new HashMap<Locale, ResourceBundle>();

	public Gestpay(KKEngIf eng) throws KKException {
		super.init(eng);

		// Initialise the static variables
		if (sortOrder == -1) {
			synchronized (mutex) {
				if (sortOrder == -1) {
					setStaticVariables();
				}
			}
		}
	}

	/**
	 * @see com.konakart.bl.modules.payment.PaymentInterface#getPaymentDetails(com.konakart.app.Order,
	 *      com.konakart.bl.modules.payment.PaymentInfo)
	 */
	public PaymentDetails getPaymentDetails(Order order, PaymentInfo info)
			throws Exception {

		log.debug("Processing payment for  order " + order.toStringBrief()
				+ " PaymentInfo locale is  " + info.getLocale());

		/*
		 * The GestpayZone zone, if greater than zero, should reference a
		 * GeoZone. If the DeliveryAddress of the order isn't within that
		 * GeoZone, then we throw an exception
		 */
		if (zone > 0) {
			checkZone(info, zone);
		}

		// Get the scale for currency calculations
		// int scale = new
		// Integer(order.getCurrency().getDecimalPlaces()).intValue();

		// Get the resource bundle
		ResourceBundle rb = getResourceBundle(mutex, bundleName,
				resourceBundleMap, info.getLocale());
		if (rb == null) {
			throw new KKException(
					"A resource file cannot be found for the country "
							+ info.getLocale().getCountry());
		}

		PaymentDetails pDetails = new PaymentDetails();
		pDetails.setCode(GestpayConstants.code);
		pDetails.setSortOrder(sortOrder);
		pDetails.setPaymentType(PaymentDetails.BROWSER_PAYMENT_GATEWAY);
		pDetails.setDescription(rb
				.getString(GestpayConstants.MODULE_PAYMENT_GESTPAY_TEXT_DESCRIPTION));
		pDetails.setTitle(rb
				.getString(GestpayConstants.MODULE_PAYMENT_GESTPAY_TEXT_TITLE));

		// Return now if the full payment details aren't required. This happens
		// when the manager
		// just wants a list of payment gateways to display in the UI.
		if (info.isReturnDetails() == false) {
			return pDetails;
		}

		pDetails.setPostOrGet("post");
		pDetails.setRequestUrl(gestPayRequestUrl);

		List<NameValue> parmList = new ArrayList<NameValue>();

		GestPayCrypt gestpayCrypt = new GestPayCrypt();

		gestpayCrypt.setShopLogin(gestPayShopId);

		// gestpayCrypt.setCurrency(rb.getString("GESTPAY_CURRENCY"));

		gestpayCrypt.setAmount(order.getTotalIncTax()
				.setScale(2, RoundingMode.HALF_EVEN).toPlainString());

		if (useOrderNumber) {
			gestpayCrypt.setShopTransactionID(order.getOrderNumber()
					+ transactionIdSeparator + Integer.toString(order.getId()));
		} else {
			gestpayCrypt.setShopTransactionID(Integer.toString(order.getId()));
		}

		if (sendBuyerName) {
			gestpayCrypt.setBuyerName(order.getCustomerName());
		}

		if (sendBuyerEmail) {
			gestpayCrypt.setBuyerEmail(order.getCustomerEmail());
		}

		if (sendBuyerLanguage) {
			gestpayCrypt.setLanguage(rb
					.getString(GestpayConstants.GESTPAY_LANGUAGE));
		}

		if (sendCustomInfo) {
			gestpayCrypt.setCustomInfo("billingCountry="
					+ order.getBillingCountry());
		}
		if (sendCurrency) {
			gestpayCrypt.setCurrency(GestpayConstants.currencyCode.get(order
					.getCurrencyCode()));
		} else {
			gestpayCrypt.setCurrency(GestpayConstants.EURO);
		}

		/*
		 * Obligatory parameters
		 */

		log.debug(gestpayCrypt.toString());

		if (gestpayCrypt.Encrypt()) {
			parmList.add(new NameValue("a", gestpayCrypt.getShopLogin()));
			parmList.add(new NameValue("b", gestpayCrypt.getEncryptedString()));
		} else {
			String errDescription = rb.getString("GESTPAY_ERROR-"
					+ gestpayCrypt.getErrorCode());
			log.error("Gestpay cannot encrypt key (err code "
					+ gestpayCrypt.getErrorCode() + ") "
					+ gestpayCrypt.getErrorDescription() + " data is:"
					+ gestpayCrypt);
			throw new KKException("Gestpay cannot encrypt key: "
					+ gestpayCrypt.getErrorCode() + " " + errDescription
					+ " for order id:" + order.getId());
		}
		/*
		 * parmList.add(new NameValue("instId", worldPayInstId));
		 * parmList.add(new NameValue("currency",
		 * order.getCurrency().getCode())); parmList.add(new NameValue("cartId",
		 * order.getId())); parmList.add(new NameValue("desc", "Order #" +
		 * order.getId() + " from " + info.getStoreName()));
		 * 
		 * parmList.add(new NameValue("amount", total.toString()));
		 */

		/*
		 * Optional parameters
		 */
		/*
		 * parmList.add(new NameValue("testMode", gestPayTestMode));
		 * 
		 * // Set one of the custom variables with the secret key
		 * parmList.add(new NameValue("M_cs1", info.getSecretKey()));
		 * parmList.add(new NameValue("M_cs2", order.getId()));
		 * 
		 * // Set the billing address parmList.add(new NameValue("name",
		 * order.getBillingName())); parmList.add(new NameValue("postcode",
		 * order.getBillingPostcode())); parmList.add(new NameValue("tel",
		 * order.getCustomerTelephone())); parmList.add(new NameValue("email",
		 * order.getCustomerEmail()));
		 * 
		 * StringBuffer addrSB = new StringBuffer();
		 * addrSB.append(order.getBillingStreetAddress());
		 * addrSB.append("&#10;"); if (order.getBillingSuburb() != null &&
		 * order.getBillingSuburb().length() > 0) {
		 * addrSB.append(order.getBillingSuburb()); addrSB.append("&#10;"); }
		 * addrSB.append(order.getBillingCity()); addrSB.append("&#10;"); if
		 * (order.getBillingState() != null && order.getBillingState().length()
		 * > 0) { addrSB.append(order.getBillingState());
		 * addrSB.append("&#10;"); } parmList.add(new NameValue("address",
		 * addrSB.toString()));
		 * 
		 * // Country requires the two letter country code CountryIf country =
		 * getEng().getCountryPerName(order.getBillingCountry()); if (country !=
		 * null) { parmList.add(new NameValue("country",
		 * country.getIsoCode2())); }
		 */

		// Put the parameters into an array
		NameValue[] nvArray = new NameValue[parmList.size()];
		parmList.toArray(nvArray);
		pDetails.setParameters(nvArray);

		if (log.isDebugEnabled()) {
			log.debug(pDetails.toString());
		}

		// If we expect no more communication from GestPay for this order we can
		// delete the SecretKey
		// TODO pulire la tabella delle sectret key
		// getEng().deleteOrderIdForSecretKey(info.getSecretKey());

		return pDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.konakart.bl.modules.payment.PaymentInterface#isAvailable()
	 */
	public boolean isAvailable() throws KKException {
		return isAvailable(getEng(),
				GestpayConstants.MODULE_PAYMENT_GESTPAY_STATUS);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.konakart.bl.modules.payment.PaymentInterface#setStaticVariables()
	 */
	public void setStaticVariables() throws KKException {
		KKConfiguration conf;

		conf = getEng().getConfiguration(
				GestpayConstants.MODULE_PAYMENT_GESTPAY_REQUEST_URL);
		if (conf == null) {
			throw new KKException(
					"The Configuration MODULE_PAYMENT_GESTPAY_REQUEST_URL must be set to the URL for"
							+ " sending the request to Gestpay. (i.e. https://ecomm.sella.it/gestpay/pagam.asp)");
		}
		gestPayRequestUrl = conf.getValue();

		conf = getEng().getConfiguration(
				GestpayConstants.MODULE_PAYMENT_GESTPAY_SHOP_ID);
		if (conf == null) {
			throw new KKException(
					"The Configuration MODULE_PAYMENT_GESTPAY_INST_ID must be set to the"
							+ " Gestpay ID for this installation");
		}
		gestPayShopId = conf.getValue();

		sendBuyerEmail = getBooleanValue(GestpayConstants.MODULE_PAYMENT_GESTPAY_SEND_BUYER_EMAIL);
		sendBuyerName = getBooleanValue(GestpayConstants.MODULE_PAYMENT_GESTPAY_SEND_BUYER_NAME);
		sendBuyerLanguage = getBooleanValue(GestpayConstants.MODULE_PAYMENT_GESTPAY_SEND_BUYER_LANGUAGE);
		sendCustomInfo = getBooleanValue(GestpayConstants.MODULE_PAYMENT_GESTPAY_SEND_CUSTOMINFO);
		sendCurrency = getBooleanValue(GestpayConstants.MODULE_PAYMENT_GESTPAY_SEND_CURRENCY);
		useOrderNumber = getBooleanValue(GestpayConstants.MODULE_PAYMENT_GESTPAY_USE_ORDERNUMBER);

		conf = getEng().getConfiguration(
				GestpayConstants.MODULE_PAYMENT_GESTPAY_ZONE);
		if (conf == null) {
			zone = 0;
		} else {
			zone = new Integer(conf.getValue()).intValue();
		}

		conf = getEng().getConfiguration(
				GestpayConstants.MODULE_PAYMENT_GESTPAY_SORT_ORDER);
		if (conf == null) {
			sortOrder = 0;
		} else {
			sortOrder = new Integer(conf.getValue()).intValue();
		}
	}

	private Boolean getBooleanValue(String paramName) throws KKException {
		KKConfiguration conf;
		conf = getEng().getConfiguration(paramName);
		if (conf == null) {
			throw new KKException(
					String.format(
							"The Configuration %s must be set to true/false",
							paramName));
		}
		return conf.getBooleanValue();
	}
}
