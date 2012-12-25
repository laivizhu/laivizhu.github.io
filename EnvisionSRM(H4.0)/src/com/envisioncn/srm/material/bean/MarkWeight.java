/**
 * 
 */
package com.envisioncn.srm.material.bean;

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
 * @data 2012-12-4
 */
@Entity
@Table(name="srm_material_markWeight")
public class MarkWeight implements BaseEntity {

	private long id;
	private double weight;
	private long markLevelId;
	private long markTemplateId;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public long getMarkLevelId() {
		return markLevelId;
	}

	public void setMarkLevelId(long markLevelId) {
		this.markLevelId = markLevelId;
	}

	public long getMarkTemplateId() {
		return markTemplateId;
	}

	public void setMarkTemplateId(long markTemplateId) {
		this.markTemplateId = markTemplateId;
	}

	public void setId(long id) {
		this.id = id;
	}
}
