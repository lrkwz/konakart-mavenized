package com.konakart.bl.modules.payment.gestpay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownServiceException;

/**
 * Crypt-Decrypt Request Object. // Author: Sellanet. // Version 3.0
 */
public class GestPayCrypt {

	private String	ShopLogin			= "";
	private String	Currency			= "";
	private String	Amount				= "";
	private String	ShopTransactionID	= "";
	private String	BuyerName			= "";
	private String	BuyerEmail			= "";
	private String	Language			= "";
	private String	CustomInfo			= "";
	private String	AuthorizationCode	= "";
	private String	ErrorCode			= "";
	private String	ErrorDescription	= "";
	private String	BankTransactionID	= "";
	private String	AlertCode			= "";
	private String	AlertDescription	= "";
	private String	EncryptedString		= "";
	private String	ToBeEncript			= "";
	private String	Decripted			= "";
	private String	TransactionResult	= "";
	private String	ProtocolAuthServer	= "";
	private String	DomainName			= "";
	private String	separator			= "";
	private String	errDescription		= "";
	private String	errNumber			= "";
	private String	Version				= "";
	private String	Min					= "";
	private String	CVV					= "";
	private String	country				= "";
	private String	vbvrisp				= "";
	private String	vbv					= "";
	private String	trans;
	private String	ThreeDLevel			= "";

	/**
	 *init value
	 **/

	public GestPayCrypt() {
		ShopLogin = "";
		Currency = "";
		Amount = "";
		ShopTransactionID = "";
		BuyerName = "";
		BuyerEmail = "";
		Language = "";
		CustomInfo = "";
		AuthorizationCode = "";
		ErrorCode = "";
		ErrorDescription = "";
		BankTransactionID = "";
		AlertCode = "";
		AlertDescription = "";
		EncryptedString = "";
		ToBeEncript = "";
		Decripted = "";
		//ProtocolAuthServer= "http://";
		//DomainName = "ecomm.sella.it/CryptHTTP";
		ProtocolAuthServer = "http://";
		DomainName = "";
		separator = "*P1*";
		errDescription = "";
		errNumber = "0";
		Version = "3.0"; // giugno '07
		Min = "";
		CVV = "";
		country = "";
		vbvrisp = "";
		vbv = "";
		trans = ""; // comparazione di stringhe
	}

	// *********** SET ***************

	public void setShopLogin(String xstr) {
		ShopLogin = xstr;
	}

	public void setCurrency(String xstr) {
		Currency = xstr;
	}

	public void setAmount(String xstr) {
		Amount = xstr;
	}

	public void setShopTransactionID(String xstr) {
		ShopTransactionID = URLEncoder.encode(xstr.trim());
	}

	public void setMIN(String xstr) {
		Min = xstr;
	}

	public void setCVV(String xstr) {
		CVV = xstr;
	}

	public void setBuyerName(String xstr) {
		BuyerName = URLEncoder.encode(xstr.trim());
	}

	public void setBuyerEmail(String xstr) {
		BuyerEmail = xstr.trim();
	}

	public void setLanguage(String xstr) {
		Language = xstr.trim();
	}

	public void setCustomInfo(String xstr) {
		CustomInfo = URLEncoder.encode(xstr.trim());
	}

	public void setEncryptedString(String xstr) {
		EncryptedString = xstr;
	}

	// giugno '07
	public void setProtocolServer(String xstr) {
		ProtocolAuthServer = xstr;
	}

	// giugno '07
	public void setDomainName(String xstr) {
		DomainName = xstr;
	}

	// *********** GET ***************

	public String getShopLogin() {
		return ShopLogin;
	}

	public String getCurrency() {
		return Currency;
	}

	public String getAmount() {
		return Amount;
	}

	public String getCountry() {
		return country;
	}

	public String getVBV() {
		return vbv;
	}

	public String getVBVrisp() {
		return vbvrisp;
	}

	public String getShopTransactionID() {
		String app = "";
		try {
			app = URLDecode(ShopTransactionID);
		} catch (Exception ex) {
		}
		return app;
	}

	public String getBuyerName() {
		String appBuyername = "";
		try {
			appBuyername = URLDecode(BuyerName);
		} catch (Exception ex) {
			appBuyername = "errore";
		}
		return appBuyername;
	}

	public String getBuyerEmail() {
		return BuyerEmail;
	}

	public String getCustomInfo() {
		String appCustom = "";
		try {
			appCustom = URLDecode(CustomInfo);
		} catch (Exception ex) {
		}
		return appCustom;
	}

	public String getAuthorizationCode() {
		return AuthorizationCode;
	}

	public String getErrorCode() {
		return ErrorCode;
	}

	public String getErrorDescription() {
		return ErrorDescription;
	}

	public String getBankTransactionID() {
		return BankTransactionID;
	}

	public String getTransactionResult() {
		return TransactionResult;
	}

	public String getAlertCode() {
		return AlertCode;
	}

	public String getAlertDescription() {
		return AlertDescription;
	}

	public String getEncryptedString() {
		return EncryptedString;
	}

	// giungo '07
	public String getProtocolServer() {
		return ProtocolAuthServer;
	}

	// giungo '07
	public String getDomainName() {
		return DomainName;
	}

	public String get3DLevel() {
		return ThreeDLevel;
	}

	/**
	 ** metodo Enrypt()
	 */

	public boolean Encrypt() {
		String sErr = "";
		ErrorCode = "0";
		ErrorDescription = "";

		try {//contact Encryption Server
			if (ShopLogin.length() <= 0) {
				ErrorCode = "546";
				ErrorDescription = "IDshop not valid";
				return false;
			}

			// Giugno 2007
			// se il protocollo e il dominio non sono stati modificati dall'esercente questi puntano di default a
			// https://testecomm.sella.it--> per i codici di test oppure a
			// https://ecomms2s.sella.it --> per i codici di produzione

			if (controlValues(ProtocolAuthServer)) {
				ProtocolAuthServer = "http://";
			}

			trans = ShopLogin.substring(0, 6);
			trans = trans.toLowerCase();
			if (controlValues(DomainName)) {
				if (trans.equals("gespay")) {
					DomainName = "testecomm.sella.it/CryptHTTP"; // codici di test
				} else {
					DomainName = "ecomms2s.sella.it/CryptHTTP"; // codici di produzione
				}
			}
			// ************

			if (Currency.length() <= 0) {
				ErrorCode = "552";
				ErrorDescription = "Currency not valid";
				return false;
			}
			if (Amount.length() <= 0) {
				ErrorCode = "553";
				ErrorDescription = "Amount not valid";
				return false;
			}
			if (ShopTransactionID.length() <= 0) {
				ErrorCode = "551";
				ErrorDescription = "Shop Transaction ID not valid";
				return false;
			}
			ToBeEncript = "";

			if (CVV.length() > 0) {
				ToBeEncript = ToBeEncript + separator + "PAY1_CVV=" + CVV;
			}
			if (Min.length() > 0) {
				ToBeEncript = ToBeEncript + separator + "PAY1_MIN=" + Min;
			}
			if (Currency.length() > 0) {
				ToBeEncript = ToBeEncript + separator + "PAY1_UICCODE=" + Currency;
			}
			if (Amount.length() > 0) {
				ToBeEncript = ToBeEncript + separator + "PAY1_AMOUNT=" + Amount;
			}
			if (ShopTransactionID.length() > 0) {
				ToBeEncript = ToBeEncript + separator + "PAY1_SHOPTRANSACTIONID=" + ShopTransactionID;
			}
			if (BuyerName.length() > 0) {
				ToBeEncript = ToBeEncript + separator + "PAY1_CHNAME=" + BuyerName;
			}
			if (BuyerEmail.length() > 0) {
				ToBeEncript = ToBeEncript + separator + "PAY1_CHEMAIL=" + BuyerEmail;
			}
			if (Language.length() > 0) {
				ToBeEncript = ToBeEncript + separator + "PAY1_IDLANGUAGE=" + Language;
			}
			if (CustomInfo.length() > 0) {
				ToBeEncript = ToBeEncript + separator + CustomInfo;
			}

			String urlString = ProtocolAuthServer + DomainName + "/Encrypt.asp?a=" + ShopLogin + "&b="
					+ ToBeEncript.substring(4, ToBeEncript.length()) + "&c=" + Version;
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();

			//connection.setAllowUserInteraction(true);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			int nStart = 0;
			int nEnd = 0;
			String line = "";

			while (line != null) {
				line = in.readLine();
				if (line != null) {
					nStart = line.indexOf("#cryptstring#");
					nEnd = line.lastIndexOf("#/cryptstring#");
					if (nStart != -1 & nEnd > nStart + 14) {
						EncryptedString = line.substring(nStart + 13, nEnd);
					}

					nStart = line.indexOf("#error#");
					nEnd = line.lastIndexOf("#/error#");
					if (nStart != -1 & nEnd > nStart + 8) {
						sErr = line.substring(nStart + 7, nEnd);
						int intsep = sErr.indexOf("-");
						ErrorCode = sErr.substring(0, intsep);
						ErrorDescription = sErr.substring(intsep + 1, sErr.length());
						return false;
					}
				}
			}
			in.close();
			return true;

		} catch (MalformedURLException ex) {
			ErrorCode = "9999";
			ErrorDescription = "Bad URL: " + ex;
			return false;
		} catch (UnknownServiceException ex) {
			ErrorCode = "9999";
			ErrorDescription = "ServiceException occurred:" + ex;
			return false;
		} catch (IOException ex) {
			ErrorCode = "9999";
			ErrorDescription = "Bad URL Request:" + ex;
			return false;
		}
	}

	/**
	 ** metodo Decrypt()
	 */

	public boolean Decrypt() {

		String sErr;
		ErrorCode = "0";
		ErrorDescription = "";
		String strdaelim = "";
		if (ShopLogin.length() <= 0) {
			ErrorCode = "546";
			ErrorDescription = "IDshop not valid";
			return false;
		}

		// Giugno 2007
		// se il protocollo e il dominio non sono stati modificati dall'esercente questi puntano di default a
		// https://testecomm.sella.it--> per i codici di test oppure a
		// https://ecomms2s.sella.it --> per i codici di produzione

		if (controlValues(ProtocolAuthServer)) {
			ProtocolAuthServer = "http://";
		}

		trans = ShopLogin.substring(0, 6);
		trans = trans.toLowerCase();
		if (controlValues(DomainName)) {
			if (trans.equals("gespay")) {
				DomainName = "testecomm.sella.it/CryptHTTP"; // codici di test
			} else {
				DomainName = "ecomms2s.sella.it/CryptHTTP"; // codici di produzione
			}
		}
		// ************

		if (EncryptedString.length() <= 0) {
			ErrorCode = "1009";
			ErrorDescription = "String to Decrypt not valid";
			return false;
		}

		try {/*contact Decryption Server*/

			String urlString = ProtocolAuthServer + DomainName + "/Decrypt.asp?a=" + ShopLogin + "&b=" + EncryptedString + "&c="
					+ Version;

			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			//connection.setAllowUserInteraction(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			int nStart = 0;
			int nEnd = 0;
			String line = "";

			while (line != null) {
				line = in.readLine();
				if (line != null) {
					nStart = line.indexOf("#decryptstring#");
					nEnd = line.lastIndexOf("#/decryptstring#");
					if (nStart != -1 & nEnd > nStart + 16) {
						Decripted = line.substring(nStart + 15, nEnd);
					}
					nStart = line.indexOf("#error#");
					nEnd = line.lastIndexOf("#/error#");
					if (nStart != -1 & nEnd > nStart + 8) {
						sErr = line.substring(nStart + 7, nEnd);
						int intsep = sErr.indexOf("-");
						ErrorCode = sErr.substring(0, intsep);
						ErrorDescription = sErr.substring(intsep + 1, sErr.length());
						return false;
					}
				}
			}

			in.close();
			if (Decripted.trim() == "") {
				ErrorCode = "9999";
				ErrorDescription = "Void String";
				return false;
			}
			if (!Parsing(Decripted)) {
				return false;
			}
			return true;

		} catch (MalformedURLException ex) {
			ErrorCode = "9999";
			ErrorDescription = "Bad URL";
			return false;
		} catch (UnknownServiceException ex) {
			ErrorCode = "9999";
			ErrorDescription = "Service Exception occurred.";
			return false;
		} catch (IOException ex) {
			ErrorCode = "9999";
			ErrorDescription = "Bad URL Request";
			return false;
		}
	}

	/**
	 ** Parsing()
	 */

	private boolean Parsing(String StringToBeParsed) {
		int nStart = 0;
		int nEnd = 0;
		ErrorCode = "";
		ErrorDescription = "";
		try {

			/* set attribute from crypt string*/
			nStart = StringToBeParsed.indexOf("PAY1_UICCODE");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					Currency = StringToBeParsed.substring(nStart + 13, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					Currency = StringToBeParsed.substring(nStart + 13, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_AMOUNT");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					Amount = StringToBeParsed.substring(nStart + 12, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					Amount = StringToBeParsed.substring(nStart + 12, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_SHOPTRANSACTIONID");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					ShopTransactionID = StringToBeParsed.substring(nStart + 23, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					ShopTransactionID = StringToBeParsed.substring(nStart + 23, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_CHNAME");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					BuyerName = StringToBeParsed.substring(nStart + 12, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					BuyerName = StringToBeParsed.substring(nStart + 12, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_CHEMAIL");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					BuyerEmail = StringToBeParsed.substring(nStart + 13, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					BuyerEmail = StringToBeParsed.substring(nStart + 13, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_AUTHORIZATIONCODE");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					AuthorizationCode = StringToBeParsed.substring(nStart + 23, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					AuthorizationCode = StringToBeParsed.substring(nStart + 23, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_ERRORCODE");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					ErrorCode = StringToBeParsed.substring(nStart + 15, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					ErrorCode = StringToBeParsed.substring(nStart + 15, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_ERRORDESCRIPTION");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					ErrorDescription = StringToBeParsed.substring(nStart + 22, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					ErrorDescription = StringToBeParsed.substring(nStart + 22, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_BANKTRANSACTIONID");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					BankTransactionID = StringToBeParsed.substring(nStart + 23, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					BankTransactionID = StringToBeParsed.substring(nStart + 23, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_ALERTCODE");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					AlertCode = StringToBeParsed.substring(nStart + 15, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					AlertCode = StringToBeParsed.substring(nStart + 15, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_ALERTDESCRIPTION");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					AlertDescription = StringToBeParsed.substring(nStart + 22, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					AlertDescription = StringToBeParsed.substring(nStart + 22, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			/*
			nStart = StringToBeParsed.indexOf("PAY1_CARDNUMBER");
			if (nStart != -1){
			  nEnd = StringToBeParsed.indexOf(separator,nStart);
			  if (nEnd==-1){
			    nEnd=StringToBeParsed.length();
			    CardNumber=StringToBeParsed.substring(nStart+16,nEnd);
			    if (nStart>=4){
			      StringToBeParsed = StringToBeParsed.substring(0,nStart-4);
			    }else{
			      StringToBeParsed = StringToBeParsed.substring(0,nStart);
			    }
			  }else{
			    CardNumber=StringToBeParsed.substring(nStart+16,nEnd);
			    StringToBeParsed = StringToBeParsed.substring(0,nStart)+StringToBeParsed.substring(nEnd+4,StringToBeParsed.length());
			  }
			}

			nStart = StringToBeParsed.indexOf("PAY1_EXPMONTH");
			if (nStart != -1){
			  nEnd = StringToBeParsed.indexOf(separator,nStart);
			  if (nEnd==-1){
			    nEnd=StringToBeParsed.length();
			    ExpMonth=StringToBeParsed.substring(nStart+14,nEnd);
			    if (nStart>=4){
			      StringToBeParsed = StringToBeParsed.substring(0,nStart-4);
			    }else{
			      StringToBeParsed = StringToBeParsed.substring(0,nStart);
			    }
			  }else{
			    ExpMonth=StringToBeParsed.substring(nStart+14,nEnd);
			    StringToBeParsed = StringToBeParsed.substring(0,nStart)+StringToBeParsed.substring(nEnd+4,StringToBeParsed.length());
			  }
			}

			nStart = StringToBeParsed.indexOf("PAY1_EXPYEAR");
			if (nStart != -1){
			  nEnd = StringToBeParsed.indexOf(separator,nStart);
			  if (nEnd==-1){
			    nEnd=StringToBeParsed.length();
			    ExpYear=StringToBeParsed.substring(nStart+13,nEnd);
			    if (nStart>=4){
			      StringToBeParsed = StringToBeParsed.substring(0,nStart-4);
			    }else{
			      StringToBeParsed = StringToBeParsed.substring(0,nStart);
			    }
			  }else{
			    ExpYear=StringToBeParsed.substring(nStart+13,nEnd);
			    StringToBeParsed = StringToBeParsed.substring(0,nStart)+StringToBeParsed.substring(nEnd+4,StringToBeParsed.length());
			  }
			}
			*/

			nStart = StringToBeParsed.indexOf("PAY1_COUNTRY");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					country = StringToBeParsed.substring(nStart + 13, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					country = StringToBeParsed.substring(nStart + 13, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_VBVRISP");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					vbvrisp = StringToBeParsed.substring(nStart + 13, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					vbvrisp = StringToBeParsed.substring(nStart + 13, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_VBV");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					vbv = StringToBeParsed.substring(nStart + 9, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					vbv = StringToBeParsed.substring(nStart + 9, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_IDLANGUAGE");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					Language = StringToBeParsed.substring(nStart + 16, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					Language = StringToBeParsed.substring(nStart + 16, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			nStart = StringToBeParsed.indexOf("PAY1_TRANSACTIONRESULT");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					TransactionResult = StringToBeParsed.substring(nStart + 23, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					TransactionResult = StringToBeParsed.substring(nStart + 23, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}
			nStart = StringToBeParsed.indexOf("PAY1_3DLEVEL");
			if (nStart != -1) {
				nEnd = StringToBeParsed.indexOf(separator, nStart);
				if (nEnd == -1) {
					nEnd = StringToBeParsed.length();
					ThreeDLevel = StringToBeParsed.substring(nStart + 13, nEnd);
					if (nStart >= 4) {
						StringToBeParsed = StringToBeParsed.substring(0, nStart - 4);
					} else {
						StringToBeParsed = StringToBeParsed.substring(0, nStart);
					}
				} else {
					ErrorDescription = StringToBeParsed.substring(nStart + 13, nEnd);
					StringToBeParsed = StringToBeParsed.substring(0, nStart)
							+ StringToBeParsed.substring(nEnd + 4, StringToBeParsed.length());
				}
			}

			CustomInfo = StringToBeParsed.trim();

		} catch (Exception e) {
			ErrorCode = "9999";
			ErrorDescription = "Error parsing String";
			return false;
		}
		return true;
	}

	/**
	 ** metodo URLDecode()
	 */

	public String URLDecode(String str) throws Exception {
		if (str == null) return null;

		char[] res = new char[str.length()];
		int didx = 0;

		for (int sidx = 0; sidx < str.length(); sidx++) {
			char ch = str.charAt(sidx);
			if (ch == '+') res[didx++] = ' ';
			else if (ch == '%') {
				try {
					res[didx++] = (char) Integer.parseInt(str.substring(sidx + 1, sidx + 3), 16);
					sidx += 2;
				} catch (NumberFormatException e) {
					//throw new Exception(str.substring(sidx,sidx+3) + " is an invalid code");
					didx--;
					res[didx++] = ch;
				}
			} else res[didx++] = ch;
		}

		return String.valueOf(res, 0, didx);
	}

	/*
	**
	* controlValues
	**/

	protected boolean controlValues(String str) {
		return ((str == null) || (str.length() == 0));
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ShopLogin = " + ShopLogin);
		sb.append("\nCurrency = " + Currency);
		sb.append("\nAmount = " + Amount);
		sb.append("\nShopTransactionID = " + ShopTransactionID);
		sb.append("\nBuyerName = " + BuyerName);
		sb.append("\nBuyerEmail = " + BuyerEmail);
		sb.append("\nLanguage = " + Language);
		sb.append("\nCustomInfo = " + CustomInfo);
		sb.append("\nAuthorizationCode = " + AuthorizationCode);
		sb.append("\nErrorCode = " + ErrorCode);
		sb.append("\nErrorDescription = " + ErrorDescription);
		sb.append("\nBankTransactionID = " + BankTransactionID);
		sb.append("\nAlertCode = " + AlertCode);
		sb.append("\nAlertDescription = " + AlertDescription);
		sb.append("\nEncryptedString = " + EncryptedString);
		sb.append("\nToBeEncript = " + ToBeEncript);
		sb.append("\nDecripted = " + Decripted);
		sb.append("\nProtocolAuthServer = " + ProtocolAuthServer);
		sb.append("\nDomainName = " + DomainName);
		sb.append("\nseparator = " + separator);
		sb.append("\nerrDescription = " + errDescription);
		sb.append("\nerrNumber = " + errNumber);
		sb.append("\nVersion = " + Version);
		sb.append("\nMin = " + Min);
		sb.append("\nCVV = " + CVV);
		sb.append("\ncountry = " + country);
		sb.append("\nvbvrisp = " + vbvrisp);
		sb.append("\nvbv = " + vbv);
		sb.append("\ntrans = " + trans);
		return sb.toString();
	}
} // **************************************** END CLASS *************************************************************
