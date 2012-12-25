package com.envisioncn.srm.material.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.basic.model.json.JsonEntity;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */

@Entity
@Table(name = "SRM_MATERIAL_SAPCODE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MaterialCode implements BaseEntity, JsonEntity {
	private long id;

	private String code; // 物料号

	private String name; // 物料描述

	private String purchaseGroup; // 采购组

	private String materialSAPGroup; // 物料组

	private String basicUnit; // 基本单位

	private String norm; // 规格

	private String drawNo; // 图号

	private String supplierAccountNo; // 供应商账号

	private MaterialCategory materialCategory;

	private Date inDate; // 导入日期

	private Date modifyDate; // 修改日期

	private String materialSupplierIds; // 供应商信息记录Ids

	private String quotaIds; // 供应商配额信息记录Ids

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "materialCategoryId")
	public MaterialCategory getMaterialCategory() {
		return materialCategory;
	}

	public void setMaterialCategory(MaterialCategory materialCategory) {
		this.materialCategory = materialCategory;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String toJson() {
		return null;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getMaterialSAPGroup() {
		return materialSAPGroup;
	}

	public void setMaterialSAPGroup(String materialSAPGroup) {
		this.materialSAPGroup = materialSAPGroup;
	}

	public String getPurchaseGroup() {
		return purchaseGroup;
	}

	public void setPurchaseGroup(String purchaseGroup) {
		this.purchaseGroup = purchaseGroup;
	}

	public String getBasicUnit() {
		return basicUnit;
	}

	public void setBasicUnit(String basicUnit) {
		this.basicUnit = basicUnit;
	}

	public String getNorm() {
		return norm;
	}

	public void setNorm(String norm) {
		this.norm = norm;
	}

	public String getDrawNo() {
		return drawNo;
	}

	public void setDrawNo(String drawNo) {
		this.drawNo = drawNo;
	}

	public String getSupplierAccountNo() {
		return supplierAccountNo;
	}

	public void setSupplierAccountNo(String supplierAccountNo) {
		this.supplierAccountNo = supplierAccountNo;
	}

	public String getMaterialSupplierIds() {
		return materialSupplierIds;
	}

	public void setMaterialSupplierIds(String materialSupplierIds) {
		this.materialSupplierIds = materialSupplierIds;
	}

	public String getQuotaIds() {
		return quotaIds;
	}

	public void setQuotaIds(String quotaIds) {
		this.quotaIds = quotaIds;
	}
}
