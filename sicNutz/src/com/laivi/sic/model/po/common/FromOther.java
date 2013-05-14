package com.laivi.sic.model.po.common;

import org.nutz.dao.entity.annotation.Table;

import com.laivi.sic.model.po.basic.AUserEntity;
import com.laivi.sic.model.type.CategoryType;

@SuppressWarnings("serial")
@Table("sic_fromother")
public class FromOther extends AUserEntity {
	private boolean selfIs;
	
	private boolean shareIs;
	
	private boolean fromOtherIs;
	
	private boolean favoriteIs;
	
	private CategoryType type;
	
	private long objId;

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}

	public long getObjId() {
		return objId;
	}

	public void setObjId(long objId) {
		this.objId = objId;
	}

	public boolean isShareIs() {
		return shareIs;
	}

	public void setShareIs(boolean shareIs) {
		this.shareIs = shareIs;
	}

	public boolean isFromOtherIs() {
		return fromOtherIs;
	}

	public void setFromOtherIs(boolean fromOtherIs) {
		this.fromOtherIs = fromOtherIs;
	}

	public boolean isFavoriteIs() {
		return favoriteIs;
	}

	public void setFavoriteIs(boolean favoriteIs) {
		this.favoriteIs = favoriteIs;
	}

	public boolean isSelfIs() {
		return selfIs;
	}

	public void setSelfIs(boolean selfIs) {
		this.selfIs = selfIs;
	}
}
