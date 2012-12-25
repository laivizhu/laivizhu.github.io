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
@Table(name = "srm_supplier_produces")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SupplierProduces implements BaseEntity {
	private long id;

	private String name;
	private String holdRate; // 占有率
	private String Patent; // 专利
	private String professionCertify; // 行业认证

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

	public String getHoldRate() {
		return holdRate;
	}

	public void setHoldRate(String holdRate) {
		this.holdRate = holdRate;
	}

	public String getPatent() {
		return Patent;
	}

	public void setPatent(String patent) {
		Patent = patent;
	}

	public String getProfessionCertify() {
		return professionCertify;
	}

	public void setProfessionCertify(String professionCertify) {
		this.professionCertify = professionCertify;
	}

	public void setId(long id) {
		this.id = id;
	}

}
