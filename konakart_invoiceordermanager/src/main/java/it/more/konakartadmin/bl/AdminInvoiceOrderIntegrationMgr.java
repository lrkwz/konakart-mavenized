package it.more.konakartadmin.bl;

import it.more.konakart.util.InvoiceUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.torque.util.BasePeer;
import org.apache.velocity.VelocityContext;

import com.konakart.bl.KKCriteria;
import com.konakart.bl.LanguageMgr;
import com.konakart.om.BaseOrdersPeer;
import com.konakartadmin.app.AdminOrder;
import com.konakartadmin.appif.KKAdminIf;
import com.konakartadmin.bl.AdminOrderIntegrationMgr;

/**
 * A default implementation of the AdminOrderIntegrationMgrInterface
 */
public class AdminInvoiceOrderIntegrationMgr extends AdminOrderIntegrationMgr {
	private static Log log = LogFactory.getLog(AdminOrderIntegrationMgr.class);

	/**
	 * Constructor
	 * 
	 * @param eng
	 *            KKAdmin engine
	 * @throws Exception
	 */
	public AdminInvoiceOrderIntegrationMgr(KKAdminIf eng) throws Exception {
		super(eng);

		if (log.isDebugEnabled()) {
			if (eng != null && eng.getEngConf() != null
					&& eng.getEngConf().getStoreId() != null) {
				log.debug("AdminOrderIntegrationMgr instantiated for store id = "
						+ eng.getEngConf().getStoreId());
			}
		}

	}

	public void changeOrderStatus(int orderId, int currentStatus, int newStatus) {
		super.changeOrderStatus(orderId, currentStatus, newStatus);

		AdminOrder order = null;
		try {
			order = getAdminOrderMgr().getOrderForOrderId(orderId,
					LanguageMgr.DEFAULT_LANG);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM");
			String folderName = sdf.format(new Date());

			VelocityContext velocityContext = new VelocityContext();
			velocityContext.put("order", order);
			velocityContext.put("currencyMgr", getAdminCurrMgr());
			velocityContext.put("storeOwner", getAdminConfigMgr()
					.getConfiguration("STORE_OWNER").getConfigurationValue());
			velocityContext.put("storeName", getAdminConfigMgr()
					.getConfiguration("STORE_NAME").getConfigurationValue());
			velocityContext.put("storeOwnerEmailAddr", getAdminConfigMgr()
					.getConfiguration("STORE_OWNER_EMAIL_ADDRESS")
					.getConfigurationValue());
			velocityContext.put("kk_base_url", getAdminConfigMgr()
					.getConfiguration("KK_BASE_URL").getConfigurationValue());
			velocityContext.put("img_base_url", getAdminConfigMgr()
					.getConfiguration("IMG_BASE_URL").getConfigurationValue());

			/*
			 * TODO calcolare il locale corrispondente all'ordine CountryIf
			 * country = getAdminEng().getCountryPerName(
			 * order.getBillingCountry()); LanguageIf lang =
			 * getAdminEng().getLanguagePerCode( country.getIsoCode2()); String
			 * locale = lang.getLocale();
			 */
			String locale = "it_IT";

			velocityContext.put("locale", new Locale(locale));

			InvoiceUtils invoiceUtils = new InvoiceUtils(getAdminEng());
			invoiceUtils.setBaseDir(getAdminConfigMgr());
			invoiceUtils.setConversionCommand(getAdminConfigMgr());
			invoiceUtils.setTemplateBaseDirectory(getAdminConfigMgr());

			order.setInvoiceFilename(invoiceUtils.createInvoice(orderId,
					velocityContext, locale));

			saveFileNameInOrder(order);

		} catch (Exception e) {
			log.error("Cannot print invoice "
					+ (order != null ? order.getId() : "") + ". " + e, e);
			if (log.isDebugEnabled()) {
				log.debug("Cannot print invoice " + e, e);
			}
		}
	}

	private void saveFileNameInOrder(AdminOrder order) throws TorqueException {
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

}
