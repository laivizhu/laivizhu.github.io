package com.envisioncn.srm.material.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.envisioncn.srm.basic.model.BaseEntity;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-26
 */
@Entity
@Table(name = "srm_material_quota")
public class Quota implements BaseEntity {
	private long id;

	private Date effectDate; // 有效期

	private String purchType; // 采购类型

	private String specialPurchType; // 特殊采购类型

	private String supplierAccount; // 供应商账户号

	private String supplierFactory; // 供应工厂

	private String quota; // 配额

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public String getPurchType() {
		return purchType;
	}

	public void setPurchType(String purchType) {
		this.purchType = purchType;
	}

	public String getSpecialPurchType() {
		return specialPurchType;
	}

	public void setSpecialPurchType(String specialPurchType) {
		this.specialPurchType = specialPurchType;
	}

	public String getSupplierAccount() {
		return supplierAccount;
	}

	public void setSupplierAccount(String supplierAccount) {
		this.supplierAccount = supplierAccount;
	}

	public String getSupplierFactory() {
		return supplierFactory;
	}

	public void setSupplierFactory(String supplierFactory) {
		this.supplierFactory = supplierFactory;
	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public void setId(long id) {
		this.id = id;
	}

}
