package com.laivi.sic.model.po.media;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.AlbumType;
import com.laivi.validation.Validations;

@SuppressWarnings("serial")
@Table("sic_album")
public class Album extends AUserEntity {

	@Validations(required=true,errorMsg="专辑名不能为空")
	@ColDefine(type=ColType.VARCHAR, width=255)
	private String name;
	
	@Validations(required=true,errorMsg="专辑描述不能为空")
	@ColDefine(type=ColType.TEXT)
	private String description;
	
	private AlbumType type;
	
	private long tagId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AlbumType getType() {
		return type;
	}

	public void setType(AlbumType type) {
		this.type = type;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
}
