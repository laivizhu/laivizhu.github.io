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
@Table(name = "srm_material_order")
public class Order implements BaseEntity {
	private long id;

	private Date startDate; // 有效起时日

	private Date endDate; // 有效结束日

	private String purcharOrg; // 采购组织

	private String orderUnit; // 订单单位

	private String planPro; // 计划协议

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPurcharOrg() {
		return purcharOrg;
	}

	public void setPurcharOrg(String purcharOrg) {
		this.purcharOrg = purcharOrg;
	}

	public String getOrderUnit() {
		return orderUnit;
	}

	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}

	public String getPlanPro() {
		return planPro;
	}

	public void setPlanPro(String planPro) {
		this.planPro = planPro;
	}

}
