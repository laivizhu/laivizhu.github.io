package com.envisioncn.srm.material.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "srm_Material_materialSupplier")
public class MaterialSupplier implements BaseEntity {
	private long id;

	private String name; // 供应商账号
	private String orderUnit; // 订单单位
	private String denoUnit; // 订单到基本单位分母
	private String moleUnit; // 订单到基本单位分子
	private String taxCode; // 税代码
	private String minOrderCount; // 最小订单数量
	private String standCount; // 标准数量
	private String exchangeTime; // 计划交换时间
	private String purchGroup; // 采购组
	private String confirmControl; // 确认控制
	private String materialCode; // 供应商物料编号

	private List<Price> prices = new ArrayList<Price>(); // 价格单位有效期记录
	private List<Order> orders = new ArrayList<Order>(); // 货源清单记录

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderUnit() {
		return orderUnit;
	}

	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}

	public String getDenoUnit() {
		return denoUnit;
	}

	public void setDenoUnit(String denoUnit) {
		this.denoUnit = denoUnit;
	}

	public String getMoleUnit() {
		return moleUnit;
	}

	public void setMoleUnit(String moleUnit) {
		this.moleUnit = moleUnit;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getMinOrderCount() {
		return minOrderCount;
	}

	public void setMinOrderCount(String minOrderCount) {
		this.minOrderCount = minOrderCount;
	}

	public String getStandCount() {
		return standCount;
	}

	public void setStandCount(String standCount) {
		this.standCount = standCount;
	}

	public String getExchangeTime() {
		return exchangeTime;
	}

	public void setExchangeTime(String exchangeTime) {
		this.exchangeTime = exchangeTime;
	}

	public String getPurchGroup() {
		return purchGroup;
	}

	public void setPurchGroup(String purchGroup) {
		this.purchGroup = purchGroup;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "materialSupplierId")
	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "materialSupplierId")
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getConfirmControl() {
		return confirmControl;
	}

	public void setConfirmControl(String confirmControl) {
		this.confirmControl = confirmControl;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

}
