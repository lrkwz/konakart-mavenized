/**
 * 
 */
package com.konakart.actions.ipn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.konakart.actions.gateways.BaseGatewayAction;
import com.konakart.al.KKAppEng;
import com.konakart.app.IpnHistory;
import com.konakart.app.KKEng;
import com.konakart.app.KKException;
import com.konakart.appif.IpnHistoryIf;
import com.konakart.appif.OrderIf;
import com.konakart.bl.ConfigConstants;
import com.konakart.bl.modules.payment.gestpay.GestPayCrypt;
import com.konakart.bl.modules.payment.gestpay.Gestpay;
import com.konakart.bl.modules.payment.gestpay.GestpayConstants;

/**
 * @author lrkwz
 */
public class GestpayAction extends BaseGatewayAction {
	private Log log = LogFactory.getLog(GestpayAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		// GestPay Callback parameters
		String username = null, password = null;

		if (log.isDebugEnabled()) {
			log.debug("*********** GestPay Callback");
		}

		// Create the outside of try / catch since they are needed in the case
		// of a general
		// exception
		IpnHistoryIf ipnHistory = new IpnHistory();
		ipnHistory.setOrderId(-1);
		ipnHistory.setModuleCode(GestpayConstants.code);

		String sessionId = null;

		KKAppEng kkAppEng = null;

		try {
			// Get an instance of the KonaKart engine
			kkAppEng = this.getKKAppEng(request, response);

			// We get from configurations, the username and password used to log
			// into the engine
			// in order to save the changes of the IPN
			username = kkAppEng
					.getConfig(GestpayConstants.MODULE_PAYMENT_GESTPAY_CALLBACK_USERNAME);
			password = kkAppEng
					.getConfig(GestpayConstants.MODULE_PAYMENT_GESTPAY_CALLBACK_PASSWORD);

			if (username == null || password == null) {
				throw new Exception(
						"The callback username and password must be defined for the GestPay module by"
								+ " setting the configuration variables MODULE_PAYMENT_GESTPAY_CALLBACK_USERNAME"
								+ " and MODULE_PAYMENT_GESTPAY_CALLBACK_PASSWORD");
			}

			// We log into the engine to get a session.
			sessionId = kkAppEng.getEng().login(username, password);
			kkAppEng.setSessionId(sessionId);

			// See if we need to send an email, by looking at the configuration
			final boolean sendEmail = Boolean.parseBoolean(kkAppEng
					.getConfig(ConfigConstants.SEND_EMAILS));

			// Process the parameters sent in the callback
			if (request != null) {
				String shopLogin = request.getParameter("a");
				String cryptedString = request.getParameter("b");

				if (cryptedString == null) {
					log.warn("No crypted string in gestpay callback");
					ipnHistory
							.setKonakartResultDescription(GestpayConstants.RET9_DESC);
					ipnHistory.setKonakartResultId(GestpayConstants.RET9);
					kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
					return null;
				}

				if (shopLogin == null) {
					log.warn("No shop id in gestpay callback");
					ipnHistory
							.setKonakartResultDescription(GestpayConstants.RET7_DESC);
					ipnHistory.setKonakartResultId(GestpayConstants.RET7);
					kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
					return null;
				}
				log.debug("/GestPayCallback.do?a=" + shopLogin + "&b="
						+ cryptedString);
				ipnHistory
						.setGatewayFullResponse("Callback was\n/GestPayCallback.do?"
								+ request.getQueryString());

				GestPayCrypt gestpayCrypt = new GestPayCrypt();
				gestpayCrypt.setShopLogin(shopLogin);
				gestpayCrypt.setEncryptedString(cryptedString);
				boolean success = gestpayCrypt.Decrypt();

				if (log.isDebugEnabled()) {
					log.debug(gestpayCrypt.toString());
				}

				// Fill more details of the IPN history class
				ipnHistory
						.setGatewayResult(gestpayCrypt.getTransactionResult());
				ipnHistory.setGatewayTransactionId(gestpayCrypt
						.getAuthorizationCode());

				// We save all of this data in the database to keep a record of
				// the
				// callback
				if (success == false) {
					ipnHistory
							.setKonakartResultDescription(GestpayConstants.RET2_DESC
									+ " " + gestpayCrypt.getErrorDescription());
					ipnHistory.setKonakartResultId(GestpayConstants.RET2);
					kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
					return null;
				}

				appendToFullGatewayResponse(ipnHistory, gestpayCrypt.toString());

				/*
				 * Get the order associated with the secret key. The secret key
				 * was sent to GestPay during the original post in the "custom"
				 * parameter. It is associated to an order and is a safe way of
				 * determining that the call back from GestPay is genuine as
				 * long as the callback is SSL.
				 */
				String[] secretKey = gestpayCrypt.getShopTransactionID().split(
						Gestpay.transactionIdSeparator);
				int orderId = Integer.valueOf(secretKey[1]);
				if (orderId < 0) {
					log.error("Cannot find order id from 'shop transaction id' "
							+ gestpayCrypt.getShopTransactionID());
					ipnHistory
							.setKonakartResultDescription(GestpayConstants.RET3_DESC);
					ipnHistory.setKonakartResultId(GestpayConstants.RET3);
					kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
					return null;
				}
				log.debug("Order id for 'shop transaction id' "
						+ gestpayCrypt.getShopTransactionID() + " is "
						+ orderId);
				ipnHistory.setOrderId(orderId);

				/*
				 * Ritengo che sia inutile, l'order number è sempre nullo inolte
				 * cambiando tipo di engine (standard vs custom) la funzione di
				 * ricerca dell'ordine è usabile per i soli ordini dell'utente
				 * in sessione ed essendo una callback non ce ne è nessuno! 
				 * 
				 * appendOrderNumber2GatewayResponse(sessionId,
				 * ipnHistory, kkAppEng, gestpayCrypt, orderId);
				 */

				// If successful, we update the inventory as well as changing
				// the state of the order.
				String comment = null;
				if (GestpayConstants.SUCCESSFUL_TRANSACTION_VALUE
						.equalsIgnoreCase(gestpayCrypt.getTransactionResult())) {
					comment = GestpayConstants.ORDER_HISTORY_COMMENT_OK
							+ gestpayCrypt.getAuthorizationCode();
					kkAppEng.getEng().changeOrderStatus(sessionId, orderId,
							com.konakart.bl.OrderMgr.PAYMENT_RECEIVED_STATUS,
							sendEmail, comment);

					// If the order payment was approved we update the inventory
					kkAppEng.getEng().updateInventory(sessionId, orderId);

					if (sendEmail) {
						log.debug("Sending payment received mail for order id "
								+ orderId);
						sendOrderConfirmationMail(kkAppEng, orderId, /* success */
								true);
					} else {
						log.debug("*NOT* Sending payment received mail for order id "
								+ orderId);
					}
				} else {
					comment = GestpayConstants.ORDER_HISTORY_COMMENT_KO
							+ gestpayCrypt.getTransactionResult();
					kkAppEng.getEng().changeOrderStatus(sessionId, orderId,
							com.konakart.bl.OrderMgr.PAYMENT_DECLINED_STATUS,
							sendEmail, comment);
					if (sendEmail) {
						log.debug("Sending payment declined mail for order id "
								+ orderId);
						sendOrderConfirmationMail(kkAppEng, orderId, /* success */
								false);
					} else {
						log.debug("*NOT* Sending payment declined mail for order id "
								+ orderId);
					}
				}

				ipnHistory
						.setKonakartResultDescription(GestpayConstants.RET0_DESC
								+ " Auth code:"
								+ gestpayCrypt.getAuthorizationCode()
								+ " Bank trans id:"
								+ gestpayCrypt.getBankTransactionID());
				ipnHistory.setKonakartResultId(GestpayConstants.RET0);
				kkAppEng.getEng().saveIpnHistory(sessionId, ipnHistory);
			}

			return null;

		} catch (Exception e) {
			try {
				if (kkAppEng != null) {
					if (sessionId != null) {
						ipnHistory
								.setKonakartResultDescription(GestpayConstants.RET4_DESC);
						ipnHistory.setKonakartResultId(GestpayConstants.RET4);
						if (kkAppEng != null) {
							kkAppEng.getEng().saveIpnHistory(sessionId,
									ipnHistory);
						}
					}
				}
			} catch (KKException e1) {
				log.error("Error handling exception in gestpay callback", e1);
			}
			log.error("Error in gestpay callback " + e.getMessage());
			return null;
		}
	}

	private void appendOrderNumber2GatewayResponse(String sessionId,
			IpnHistoryIf ipnHistory, KKAppEng kkAppEng,
			GestPayCrypt gestpayCrypt, int orderId) {
		try {
			OrderIf localOrder = null;
			if (kkAppEng.getEng() instanceof KKEng) {
				localOrder = ((KKEng) kkAppEng.getEng()).getMgrFactory()
						.getOrderMgr(false).getOrderForOrderId(orderId, -1);
			} else {
				localOrder = kkAppEng.getEng().getOrder(sessionId, orderId, -1);
			}

			if (localOrder != null) {
				log.debug("Order number for 'shop transaction id' "
						+ gestpayCrypt.getShopTransactionID() + " order id "
						+ orderId + " is " + localOrder.getOrderNumber());
				appendToFullGatewayResponse(ipnHistory, "\nOrder number is:"
						+ localOrder.getOrderNumber());
			} else {
				log.error("Cannot find order given order id " + orderId
						+ " in the current session.");
			}
		} catch (Exception e) {
			log.error("Cannot find order given order id " + orderId + " " + e);
		}
	}

	private void appendToFullGatewayResponse(IpnHistoryIf ipnHistory,
			String text) {
		StringBuffer str = new StringBuffer(ipnHistory.getGatewayFullResponse());
		str.append("\n");
		str.append(text);
		ipnHistory.setGatewayFullResponse(str.toString());
	}
}
