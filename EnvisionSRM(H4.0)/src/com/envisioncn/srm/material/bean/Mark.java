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
@Table(name="srm_material_mark")
public class Mark implements BaseEntity {

	private long id;
	private int score;
	private long materialId;
	
	private long markLevelId;
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}
	public long getMarkLevelId() {
		return markLevelId;
	}
	public void setMarkLevelId(long markLevelId) {
		this.markLevelId = markLevelId;
	}
	public void setId(long id) {
		this.id = id;
	}
}
