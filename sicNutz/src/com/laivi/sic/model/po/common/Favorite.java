package com.laivi.sic.model.po.common;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.CategoryType;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_favorite")
public class Favorite extends AUserEntity {
	
	@Validations(required=true,errorMsg="收藏内容不能为空")
	@ColDefine(type=ColType.VARCHAR, width=255)
	private String title;
	
	@Validations(required=true,errorMsg="收藏路径不能为空")
	@ColDefine(type=ColType.VARCHAR, width=255)
	private String url;
	
	@Validations(required=true,errorMsg="收藏类型不能为空")
	private CategoryType type;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}
}
