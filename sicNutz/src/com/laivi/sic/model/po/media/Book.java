package com.laivi.sic.model.po.media;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;

@SuppressWarnings("serial")
@Table("sic_book")
public class Book extends AUserEntity {
	
	private String name;
	
	private int price;
	
	private String description;
	
	private long tagId;
	
	private boolean createIs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public boolean isCreateIs() {
		return createIs;
	}

	public void setCreateIs(boolean createIs) {
		this.createIs = createIs;
	}
}
