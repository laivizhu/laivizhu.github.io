package com.envisioncn.srm.supplier_basic.service;

import com.envisioncn.srm.basic.model.SRMException;
import com.envisioncn.srm.basic.service.IBasicService;
import com.envisioncn.srm.supplier_basic.bean.SupplierInfo;
import com.envisioncn.srm.supplier_basic.model.SupplierInfoFile;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
public interface ISupplierInfoService extends IBasicService<SupplierInfo> {

	SupplierInfo saveUploadFile(SupplierInfoFile files, SupplierInfo info, String path) throws SRMException;

	void updateSupplierInfo(SupplierInfo info, long supplierInfoId) throws SRMException;

}
