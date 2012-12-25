package com.envisioncn.srm.supplier_basic.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.basic.util.DataUtil;
import com.envisioncn.srm.basic.util.HashUtil;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.dao.IMaterialCategoryDao;
import com.envisioncn.srm.supplier_basic.bean.SupplierBasic;
import com.envisioncn.srm.supplier_basic.bean.SupplierInfo;
import com.envisioncn.srm.supplier_basic.dao.ISupplierInfoDao;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
@Service("SupplierBasicService")
public class SupplierBasicService extends BasicService<SupplierBasic> implements ISupplierBasicService {
	private ISupplierInfoDao supplierInfoDao;
	private IMaterialCategoryDao materialCategoryDao;

	@Resource(name = "SupplierBasicDao")
	public void setBasicDao(IBasicDao<SupplierBasic> basicDao) {
		this.basicDao = basicDao;
	}

	@Resource(name = "SupplierInfoDao")
	public void setSupplierInfoDao(ISupplierInfoDao supplierInfoDao) {
		this.supplierInfoDao = supplierInfoDao;
	}
	
	@Resource(name = "MaterialCategoryDao")
	public void setMaterialCategoryDao(IMaterialCategoryDao materialCategoryDao) {
		this.materialCategoryDao = materialCategoryDao;
	}

	public Map<String, String> getConfirmMailInfo(SupplierBasic supplier) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("name", supplier.getName());
		info.put("userName", supplier.getPersonName());
		info.put("account", supplier.getAccount());
		info.put("password", supplier.getPassword());
		info.put("suffix", HashUtil.getMD5String(supplier.getName()));
		return info;
	}

	public Map<String, String> getRejectMainInfo(SupplierBasic supplier, String reason) {
		Map<String, String> info = new HashMap<String, String>();
		info.put("name", supplier.getName());
		info.put("userName", supplier.getPersonName());
		info.put("reason", reason);
		return info;
	}

	public void saveSupplierInfo(long supplierId, SupplierInfo info) throws Exception {
		SupplierBasic supplier = this.getObject(supplierId);
		long supplierInfoId = supplierInfoDao.add(info);
		supplier.setSupplierInfoId(supplierInfoId);
		this.modify(supplier);
	}

	public void saveSupplierBasic(long supplierId, SupplierBasic supplierBasic,long subCategoryId) throws Exception {
		SupplierBasic supplier = this.getObject(supplierId);
		if(DataUtil.notEmptyString(supplierBasic.getAddress())){
			supplier.setAddress(supplierBasic.getAddress());
		}
		if(DataUtil.notEmptyString(supplierBasic.getEmail())){
			supplier.setEmail(supplierBasic.getEmail());
		}
		if(DataUtil.notEmptyString(supplierBasic.getName())){
			supplier.setName(supplierBasic.getName());
		}
		if(DataUtil.notEmptyString(supplierBasic.getPersonName())){
			supplier.setPersonName(supplierBasic.getPersonName());
		}
		if(DataUtil.notEmptyString(supplierBasic.getPhone())){
			supplier.setPhone(supplierBasic.getPhone());
		}
		if(supplierBasic.getUserId()!=0){
			supplier.setUserId(supplierBasic.getUserId());
		}
		if(subCategoryId!=0){
			MaterialCategory category=materialCategoryDao.getObject(subCategoryId);
			supplier.getMaterialCategory().remove(0);
			supplier.getMaterialCategory().add(category);
		}
		this.basicDao.modify(supplier);
	}

}
