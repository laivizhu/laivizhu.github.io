/**
 * 
 */
package com.envisioncn.srm.basic.model;

import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.util.PropertiesUtil;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-25
 */
public class GlobalVal {
	private static long SupplierDefaultTemplate = Long.parseLong(PropertiesUtil.readData("template.supplierDefault"));

	public static long getSupplierDefaultTemplate() {
		return SupplierDefaultTemplate;
	}

	public static void setSupplierDefaultTemplate(long supplierDefaultTemplate) {
		SupplierDefaultTemplate = supplierDefaultTemplate;
		PropertiesUtil.writeData("template.supplierDefault", supplierDefaultTemplate + AppConstants.EMPTY);
	}

}
