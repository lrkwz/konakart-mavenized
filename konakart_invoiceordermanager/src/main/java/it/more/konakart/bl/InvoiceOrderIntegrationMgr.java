/**
 * 
 */
package it.more.konakart.bl;

import it.more.konakart.util.InvoiceUtils;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.velocity.VelocityContext;

import com.konakart.al.KKAppEng;
import com.konakart.app.KKException;
import com.konakart.app.Order;
import com.konakart.appif.CountryIf;
import com.konakart.appif.KKEngIf;
import com.konakart.appif.LanguageIf;
import com.konakart.appif.OrderIf;
import com.konakart.bl.KKCriteria;
import com.konakart.bl.LanguageMgr;
import com.konakart.bl.OrderIntegrationMgr;
import com.konakart.bl.OrderMgr;
import com.konakart.om.BaseOrdersPeer;
import com.konakart.util.FileUtils;
import com.konakart.util.KKConstants;

/**
 * @author lrkwz
 */
public class InvoiceOrderIntegrationMgr extends OrderIntegrationMgr {
	protected static Log log = LogFactory
			.getLog(InvoiceOrderIntegrationMgr.class);

	/**
	 * @param eng
	 * @throws Exception
	 */
	public InvoiceOrderIntegrationMgr(KKEngIf eng) throws Exception {
		super(eng);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.konakart.bl.OrderIntegrationMgr#changeOrderStatus(int, int, int)
	 */
	@Override
	public void changeOrderStatus(int orderId, int currentStatus, int newStatus) {
		super.changeOrderStatus(orderId, currentStatus, newStatus);

		if (newStatus == OrderMgr.PAYMENT_RECEIVED_STATUS) {
			try {

				// Get the order
				Order order = getOrderMgr().getOrderForOrderId(orderId,
						LanguageMgr.DEFAULT_LANG);
				if (order == null)
					throw new KKException("Cannot find order for Id = "
							+ orderId);
				log.info("Order: " + order.getOrderNumber() + " (" + orderId
						+ ") new status is " + newStatus + " printing invoice");

				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("order", order);
				velocityContext.put("currencyMgr", getCurrMgr());
				velocityContext.put("storeOwner", getConfigMgr()
						.getConfiguration("STORE_OWNER").getValue());
				velocityContext.put("storeName", getConfigMgr()
						.getConfiguration("STORE_NAME").getValue());
				velocityContext.put("storeOwnerEmailAddr", getConfigMgr()
						.getConfiguration("STORE_OWNER_EMAIL_ADDRESS")
						.getBooleanValue());
				velocityContext.put("kk_base_url", getConfigMgr()
						.getConfiguration("KK_BASE_URL").getValue());
				velocityContext.put("img_base_url", getConfigMgr()
						.getConfiguration("IMG_BASE_URL").getValue());
				CountryIf country = getEng().getCountryPerName(
						order.getBillingCountry());
				LanguageIf lang = getEng().getLanguagePerCode(
						country.getIsoCode2());
				// TODO lang can be null!
				String locale = lang.getLocale();
				velocityContext.put("locale", new Locale(locale));
				InvoiceUtils invoiceUtils = new InvoiceUtils(getEng());
				invoiceUtils.setBaseDir(getConfigMgr());
				invoiceUtils.setConversionCommand(getConfigMgr());
				invoiceUtils.setTemplateBaseDirectory(getConfigMgr());

				order.setDeliveryFormattedAddress(order.removeCData(order
						.getDeliveryFormattedAddress()));
				order.setBillingFormattedAddress(order.removeCData(order
						.getBillingFormattedAddress()));
				order.setCustomerFormattedAddress(order.removeCData(order
						.getCustomerFormattedAddress()));

				order.setInvoiceFilename(invoiceUtils.createInvoice(orderId,
						velocityContext, locale));

				saveFileNameInOrder(order);

			} catch (KKException e) {
				String msg = "KKError changing status for order id: " + orderId
						+ " (" + e + ")";
				if (log.isDebugEnabled()) {
					log.debug(msg, e);
				} else {
					log.error(msg);
				}
			} catch (Exception e) {
				String msg = "Error changing status for order id: " + orderId
						+ " (" + e + ")";
				if (log.isDebugEnabled()) {
					log.debug(msg, e);
				} else {
					log.error(msg);
				}
			}
		}
	}

	private void saveFileNameInOrder(Order order) throws TorqueException {
		// Update the invoice filename on the order
		KKCriteria updateC = getNewCriteria();
		KKCriteria selectC = getNewCriteria();
		updateC.addForInsert(BaseOrdersPeer.INVOICE_FILENAME,
				order.getInvoiceFilename());
		selectC.add(BaseOrdersPeer.ORDERS_ID, order.getId());
		BasePeer.doUpdate(selectC, updateC);
		if (log.isDebugEnabled()) {
			log.debug("Updated invoice filename (" + order.getInvoiceFilename()
					+ ") on order " + order.getId());
		}
	}

	@Override
	public void saveOrder(OrderIf order) {
		super.saveOrder(order);
		log.debug("Order " + order.getId() + " has been updated. " + order.toString());
	}
}
