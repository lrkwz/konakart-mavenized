package it.more.konakart.actions;

import it.more.konakart.util.InvoiceUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.velocity.VelocityContext;

import com.konakart.actions.BaseAction;
import com.konakart.al.KKAppEng;
import com.konakart.appif.CountryIf;
import com.konakart.appif.LanguageIf;
import com.konakart.appif.OrderIf;
import com.konakart.util.FileUtils;
import com.konakart.util.KKConstants;

/**
 * Action called just before downloading the invoice
 */
public class DownloadInvoiceAction extends BaseAction {

	protected static final int DEFAULT_BUFFER_SIZE = 4096;

	/**
	 * 
	 * @param mapping
	 *            The ActionMapping used to select this instance
	 * @param form
	 *            The optional ActionForm bean for this request (if any)
	 * @param request
	 *            The HTTP request we are processing
	 * @param response
	 *            The HTTP response we are creating
	 * 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		boolean downloaded = false;

		try {
			int custId;

			KKAppEng kkAppEng = this.getKKAppEng(request, response);

			String orderIdStr = request.getParameter("orderId");

			if (orderIdStr == null) {
				return mapping.findForward("MyAccount");
			}

			int orderId;
			try {
				orderId = Integer.parseInt(orderIdStr);
			} catch (RuntimeException e) {
				return mapping.findForward("MyAccount");
			}

			// Check to see whether the user is logged in
			custId = this.loggedIn(request, response, kkAppEng, "MyAccount");
			if (custId < 0) {
				return mapping.findForward(loginForward);
			}

			// Ensure we are using the correct protocol. Redirect if not.
			ActionForward redirForward = checkSSL(kkAppEng, request, custId, /* forceSSL */
					false);
			if (redirForward != null) {
				return redirForward;
			}

			// Get the order
			OrderIf order = kkAppEng.getEng().getOrder(kkAppEng.getSessionId(),
					orderId, kkAppEng.getLangId());

			// Determine whether a pdf document exists on the file system.
			// Otherwise we create it on
			// the fly.
			String fullFileName = order.getInvoiceFilename();
			if (order.getInvoiceFilename() == null
					|| order.getInvoiceFilename().length() == 0
					|| !(new File(order.getInvoiceFilename()).exists())) {
				fullFileName = createInvoice(kkAppEng, order);
			}

			File file = new File(fullFileName);
			if (file.canRead() == false) {
				throw new Exception("The file " + fullFileName
						+ " cannot be opened");
			}

			// set the content type
			response.setContentType("application/pdf");

			// Comment out the following line if you want the invoice to
			// open up in the browser
			// window
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ order.getInvoiceFilename() + "\"");

			// Define input and output streams
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ServletOutputStream os = response.getOutputStream();

			/*
			 * Set the downloaded flag as soon as we get the output stream from
			 * the response. Once we have got the output stream we must return
			 * null from this method otherwise we get an exception if we try to
			 * do a mapping.findForward() because it also calls
			 * response.getOutputStream
			 */
			downloaded = true;

			// Copy from input to output
			try {
				byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
				int count = 0;
				int n = 0;

				/*
				 * In the case of IE it stops here until the user decides to
				 * download or cancel out. Therefore if the operation is
				 * cancelled we do not update the download count. In the case of
				 * Firefox, this method is run completely before the download
				 * dialogue box is displayed. This means that the download count
				 * is updated even if the user decides to cancel the operation.
				 */
				while ((n = bis.read(buffer)) > -1) {
					os.write(buffer, 0, n);
					count += n;
				}
			} finally {
				bis.close();
				if (os != null) {
					os.flush();
					os.close();
				}
			}
			if (downloaded) {
				return null;
			}

			return mapping.findForward("MyAccount");

		} catch (Exception e) {
			if (downloaded) {
				return null;
			}
			return mapping.findForward(super.handleException(request, e));
		}
	}

	/**
	 * Creates the PDF invoice. If the invoice already exists in the file system
	 * then this copy of the invoice is used, otherwise it is created
	 * temporarily.
	 * 
	 * @param order
	 * @throws Exception
	 */
	private String createInvoice(KKAppEng kkAppEng, OrderIf order)
			throws Exception {
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("order", order);
		velocityContext.put("storeOwner", kkAppEng.getConfig("STORE_OWNER"));
		velocityContext.put("storeName", kkAppEng.getConfig("STORE_NAME"));
		velocityContext.put("storeOwnerEmailAddr",
				kkAppEng.getConfig("STORE_OWNER_EMAIL_ADDRESS"));
		velocityContext.put("kk_base_url", kkAppEng.getConfig("KK_BASE_URL"));
		velocityContext.put("img_base_url", kkAppEng.getConfig("IMG_BASE_URL"));
		CountryIf country = kkAppEng.getEng().getCountryPerName(
				order.getBillingCountry());
		LanguageIf lang = kkAppEng.getEng().getLanguagePerCode(
				country.getIsoCode2());
		String locale = (lang != null ? lang.getLocale() : kkAppEng.getLocale());

		velocityContext.put("locale", new Locale(locale));

		InvoiceUtils invoiceUtils = new InvoiceUtils(kkAppEng.getEng());
		invoiceUtils
				.setBaseDir(kkAppEng
						.getConfig(KKConstants.CONF_KEY_PDF_BASE_DIRECTORY)
						+ FileUtils.FILE_SEPARATOR
						+ KKAppEng.getEngConf().getStoreId());
		invoiceUtils.setConversionCommand(kkAppEng
				.getConfig(InvoiceUtils.ORDER_PDF_COMMAND));
		invoiceUtils.setTemplateBaseDirectory(kkAppEng
				.getConfig(InvoiceUtils.TEMPLATE_BASE_DIRECTORY));

		order.setInvoiceFilename(invoiceUtils.createInvoice(order.getId(),
				velocityContext, locale));
		return invoiceUtils.getBaseDir() + FileUtils.FILE_SEPARATOR
				+ order.getInvoiceFilename();
	}

}
