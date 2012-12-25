package com.envisioncn.srm.supplier_basic.service;

import java.util.Map;

import com.envisioncn.srm.basic.service.IBasicService;
import com.envisioncn.srm.supplier_basic.bean.SupplierBasic;
import com.envisioncn.srm.supplier_basic.bean.SupplierInfo;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
public interface ISupplierBasicService extends IBasicService<SupplierBasic> {

	Map<String, String> getConfirmMailInfo(SupplierBasic supplier);

	Map<String, String> getRejectMainInfo(SupplierBasic supplier, String reason);

	void saveSupplierInfo(long supplierId, SupplierInfo info) throws Exception;
	
	void saveSupplierBasic(long supplierId,SupplierBasic supplierBasic,long subCategoryId)throws Exception;

}
