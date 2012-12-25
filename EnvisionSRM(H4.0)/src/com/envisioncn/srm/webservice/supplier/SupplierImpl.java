package com.envisioncn.srm.webservice.supplier;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.envisioncn.srm.supplier_basic.bean.SupplierBasic;
import com.envisioncn.srm.supplier_basic.service.ISupplierBasicService;
@WebService(endpointInterface = "com.envisioncn.srm.webservice.supplier.Supplier")
public class SupplierImpl {
	private ISupplierBasicService supplierBasicService;
	
	public SupplierBasic getSupplier(String id){
		List<SupplierBasic> list = supplierBasicService.getList(0, 1);
		return list.get(0);
	}
	@Resource(name="SupplierBasicService")
	public void setSupplierBasicService(ISupplierBasicService supplierBasicService) {
		this.supplierBasicService = supplierBasicService;
	}
	
	public static void main(String[] args){
		JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
        svr.setServiceClass(Supplier.class);
        svr.setAddress("http://localhost:8080/EnvisionSRM/webServices/supplier");
        Supplier supplier = (Supplier) svr.create();
        SupplierBasic basicInfo = supplier.getSupplier("0");
        System.out.println(basicInfo.getName());
	}
}
