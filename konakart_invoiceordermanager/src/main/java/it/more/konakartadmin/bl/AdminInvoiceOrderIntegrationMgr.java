package it.more.konakartadmin.bl;

import it.more.konakart.util.InvoiceUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.TorqueException;
import org.apache.velocity.VelocityContext;

import com.konakart.app.KKException;
import com.konakart.app.Order;
import com.konakart.bl.LanguageMgr;
import com.konakartadmin.app.AdminOrder;
import com.konakartadmin.app.KKAdminException;
import com.konakartadmin.appif.KKAdminIf;
import com.konakartadmin.bl.AdminOrderIntegrationMgr;
import com.workingdogs.village.DataSetException;

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

			invoiceUtils.createInvoice(orderId, velocityContext, locale);

		} catch (Exception e) {
			log.error("Cannot print invoice "
					+ (order != null ? order.getId() : "") + ". " + e, e);
			if (log.isDebugEnabled()) {
				log.debug("Cannot print invoice " + e, e);
			}
		}

	}
}
