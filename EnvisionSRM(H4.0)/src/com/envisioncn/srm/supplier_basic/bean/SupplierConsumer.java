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
@Table(name = "srm_supplier_consumer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SupplierConsumer implements BaseEntity {
	private long id;
	private String name; // 产品或服务
	private String mainConsumer; // 主要客户
	private String sales; // 最近12个月销售额
	private String rate; // 占比

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

	public String getMainConsumer() {
		return mainConsumer;
	}

	public void setMainConsumer(String mainConsumer) {
		this.mainConsumer = mainConsumer;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public void setId(long id) {
		this.id = id;
	}
}
