package com.laivi.sic.model.po.common;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.CategoryType;

@SuppressWarnings("serial")
@Table("sic_userrecomm")
public class UserRecomm extends AUserEntity {

	private String objIds;
	
	private CategoryType type;
	
	private String recommDegrees;

	public String getObjIds() {
		return objIds;
	}

	public void setObjIds(String objIds) {
		this.objIds = objIds;
	}

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}

	public String getRecommDegrees() {
		return recommDegrees;
	}

	public void setRecommDegrees(String recommDegrees) {
		this.recommDegrees = recommDegrees;
	}
}
