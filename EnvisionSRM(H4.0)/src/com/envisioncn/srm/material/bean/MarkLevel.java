/**
 * 
 */
package com.envisioncn.srm.material.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="srm_Material_MarkLevel")
public class MarkLevel implements BaseEntity {

	private long id;
	private String name;
	private int levelType;
	private long parentId;
	private boolean important;												//是否是物料重要性级别
	private Set<MarkDepartment> departments=new HashSet<MarkDepartment>();
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

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLevelType() {
		return levelType;
	}

	public void setLevelType(int levelType) {
		this.levelType = levelType;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "srm_markLevel_department", joinColumns = { @JoinColumn(name = "markLevelId") }, inverseJoinColumns = { @JoinColumn(name = "departmentId") })
	public Set<MarkDepartment> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<MarkDepartment> departments) {
		this.departments = departments;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}
}
