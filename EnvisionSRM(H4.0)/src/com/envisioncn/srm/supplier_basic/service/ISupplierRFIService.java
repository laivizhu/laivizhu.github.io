package com.envisioncn.srm.supplier_basic.service;

import java.io.File;

import com.envisioncn.srm.basic.model.SRMException;
import com.envisioncn.srm.basic.service.IBasicService;
import com.envisioncn.srm.supplier_basic.bean.SupplierRFI;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-30
 */
public interface ISupplierRFIService extends IBasicService<SupplierRFI> {

	SupplierRFI extractSupplierInfoFromExcel(File excelFile) throws SRMException;
}
