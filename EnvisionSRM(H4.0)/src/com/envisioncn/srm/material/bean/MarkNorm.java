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
@Table(name="srm_material_markNorm")
public class MarkNorm implements BaseEntity {
	private long id;
	private String content;
	private double score;
	private int normType;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getNormType() {
		return normType;
	}

	public void setNormType(int normType) {
		this.normType = normType;
	}

	public void setId(long id) {
		this.id = id;
	}
}
