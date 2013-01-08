package com.laivi.knowledge.search.model.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.laivi.knowledge.basic.model.po.BaseEntity;
import com.laivi.knowledge.basic.model.po.BasicEntity;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2012-12-31
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_searchItem")
public class SearchItem extends BasicEntity implements BaseEntity {
	private long id;
	
	private String keyword;
	
	private int count;

	public SearchItem() {
		super();
	}

	public SearchItem(String keyword, int count) {
		super();
		this.keyword = keyword;
		this.count = count;
	}

	@Id
	@GeneratedValue
	@Override
	public long getId() {
		return id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setId(long id) {
		this.id = id;
	}
}
