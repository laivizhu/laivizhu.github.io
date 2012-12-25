/**
 * 
 */
package com.envisioncn.srm.supplier_basic.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.envisioncn.srm.basic.model.BaseEntity;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-28
 */
@Entity
@Table(name = "srm_supplier_device")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SupplierDevice implements BaseEntity {
	private long id;
	private String name; // 生产设备名称
	private String brand; // 品牌
	private String format; // 规格
	private String yield; // 产能
	private String usedYear; // 已使用年限
	private String count; // 数量
	private boolean produceDevice; // 是否生产设备

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getYield() {
		return yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public String getUsedYear() {
		return usedYear;
	}

	public void setUsedYear(String usedYear) {
		this.usedYear = usedYear;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isProduceDevice() {
		return produceDevice;
	}

	public void setProduceDevice(boolean produceDevice) {
		this.produceDevice = produceDevice;
	}
}
