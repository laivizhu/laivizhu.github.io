package com.laivi.sic.model.po.shopping;


import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicEntity;
import com.laivi.sic.model.type.CategoryLevel;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@SuppressWarnings("serial")
@Table("sic_category")
public class Category extends ABasicEntity {
	private String name;
	private CategoryLevel level;
	private int priority;
	private long parentId;
	

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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public CategoryLevel getLevel() {
		return level;
	}

	public void setLevel(CategoryLevel level) {
		this.level = level;
	}
}
