package com.envisioncn.srm.webservice.supplier;

import javax.jws.WebService;

import com.envisioncn.srm.supplier_basic.bean.SupplierBasic;
@WebService
public interface Supplier {
	public SupplierBasic getSupplier(String id);
}
