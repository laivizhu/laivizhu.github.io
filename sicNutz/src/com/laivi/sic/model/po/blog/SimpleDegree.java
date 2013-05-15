package com.laivi.sic.model.po.blog;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.ABasicEntity;
import com.laivi.sic.model.type.CategoryType;

@SuppressWarnings("serial")
@Table("sic_simpleDegree")
public class SimpleDegree extends ABasicEntity {

	private long objId;
	
	private CategoryType type;
	
	@ColDefine(type=ColType.VARCHAR, width=255)
	private String simpleDegree;
	
	@ColDefine(type=ColType.VARCHAR, width=255)
	private String simpleIds;

	public long getObjId() {
		return objId;
	}

	public void setObjId(long objId) {
		this.objId = objId;
	}

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}

	public String getSimpleDegree() {
		return simpleDegree;
	}

	public void setSimpleDegree(String simpleDegree) {
		this.simpleDegree = simpleDegree;
	}

	public String getSimpleIds() {
		return simpleIds;
	}

	public void setSimpleIds(String simpleIds) {
		this.simpleIds = simpleIds;
	}
}
