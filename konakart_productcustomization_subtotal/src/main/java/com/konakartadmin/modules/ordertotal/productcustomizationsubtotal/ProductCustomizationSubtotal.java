package com.konakartadmin.modules.ordertotal.productcustomizationsubtotal;

import java.util.Date;

import com.konakart.util.Utils;
import com.konakartadmin.app.KKConfiguration;
import com.konakartadmin.bl.KKAdminBase;
import com.konakartadmin.modules.OrderTotalModule;

public class ProductCustomizationSubtotal extends OrderTotalModule {
	/**
	 * @return the config key stub
	 */
	public String getConfigKeyStub() {
		if (configKeyStub == null) {
			setConfigKeyStub(super.getConfigKeyStub() + "_PRODUCTCUSTOMIZATIONSUBTOTAL");
		}
		return configKeyStub;
	}

	public String getModuleTitle() {
		return getMsgs().getString("MODULE_ORDER_TOTAL_PRODUCTCUSTOMIZATIONSUBTOTAL_TEXT_TITLE");
	}

	/**
	 * @return the implementation filename - for compatibility with osCommerce
	 *         we use the php name
	 */
	public String getImplementationFileName() {
		return "ProductCustomizationSubtotal.php";
	}

	/**
	 * @return the module code
	 */
	public String getModuleCode() {
		return "ProductCustomizationSubtotal";
	}

	/**
	 * @return an array of configuration values for this payment module
	 */
	public KKConfiguration[] getConfigs() {
		if (configs == null) {
			configs = new KKConfiguration[2];
		}

		if (configs[0] != null
				&& !Utils.isBlank(configs[0].getConfigurationKey())) {
			return configs;
		}

		Date now = KKAdminBase.getKonakartTimeStampDate();

		int i = 0;
		configs[i++] = new KKConfiguration("Display Sub-Total for customized products",
				"MODULE_ORDER_TOTAL_PRODUCTCUSTOMIZATIONSUBTOTAL_STATUS", "true",
				"Do you want to display the order sub-total cost for customized products?", 6, 1, "",
				"tep_cfg_select_option(array('true', 'false'), ", now);
		configs[i++] = new KKConfiguration("Sort Order",
				"MODULE_ORDER_TOTAL_PRODUCTCUSTOMIZATIONSUBTOTAL_SORT_ORDER", "90",
				"Sort order of display.", 6, 2, "", "", now);

		return configs;
	}
}
