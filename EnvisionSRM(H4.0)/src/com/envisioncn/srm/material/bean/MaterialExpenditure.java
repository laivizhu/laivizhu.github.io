/**
 * 
 */

package com.envisioncn.srm.material.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.envisioncn.srm.basic.model.BaseEntity;

/**
 * Copyright Envision
 *
 * @author cehn.chen
 * @version 1.0
 * @data 2012-11-26
 */
@Entity
@Table(name="SRM_MATERIAL_EXPENDITURE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MaterialExpenditure{
	private String code;						//物料号
	
	private String parentid1;					//物料小组
	
	private String parentid2;					//物料小类别
	
	private String parentid3;					//物料类别
	
	private String parentid4;					//物料分类
	
	private String supplierName;				//供应商的名称
	
	private String MTLSourceCity;				//物料提供城市
	
	private String MTLSourcePvc;				//物料提供省份
	
	private String MTLSourceCoun;				//物料提供国家
	
	private int qty;							//物料数量
	
	private double totalSpending;				//总花费
	
	private String unit;						//单位
	
	@Id
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getParentid1() {
		return parentid1;
	}

	public void setParentid1(String parentid1) {
		this.parentid1 = parentid1;
	}

	public String getParentid2() {
		return parentid2;
	}

	public void setParentid2(String parentid2) {
		this.parentid2 = parentid2;
	}

	public String getParentid3() {
		return parentid3;
	}

	public void setParentid3(String parentid3) {
		this.parentid3 = parentid3;
	}

	public String getParentid4() {
		return parentid4;
	}

	public void setParentid4(String parentid4) {
		this.parentid4 = parentid4;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getMTLSourceCity() {
		return MTLSourceCity;
	}

	public void setMTLSourceCity(String mTLSourceCity) {
		MTLSourceCity = mTLSourceCity;
	}

	public String getMTLSourcePvc() {
		return MTLSourcePvc;
	}

	public void setMTLSourcePvc(String mTLSourcePvc) {
		MTLSourcePvc = mTLSourcePvc;
	}

	public String getMTLSourceCoun() {
		return MTLSourceCoun;
	}

	public void setMTLSourceCoun(String mTLSourceCoun) {
		MTLSourceCoun = mTLSourceCoun;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotalSpending() {
		return totalSpending;
	}

	public void setTotalSpending(double totalSpending) {
		this.totalSpending = totalSpending;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
