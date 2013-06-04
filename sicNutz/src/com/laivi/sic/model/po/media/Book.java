package com.laivi.sic.model.po.media;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_book")
public class Book extends AUserEntity {
	
	@Validations(required=true,errorMsg="书名不能为空")
	@ColDefine(type=ColType.VARCHAR, width=500)
	private String name;
	
	private int price;
	
	//@Validations(required=true,errorMsg="书描述不能为空")
	@ColDefine(type=ColType.TEXT)
	private String description;
	
	private long tagId;
	
	private boolean createIs;
	
	private String path;

	public Book() {
	}

	public Book(String name, String path) {
		this.name = name;
		this.path = path;
	}

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
