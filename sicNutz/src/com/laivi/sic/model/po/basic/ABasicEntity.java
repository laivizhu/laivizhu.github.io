package com.laivi.sic.model.po.basic;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.json.Json;

import com.laivi.sic.model.json.FormData;
import com.laivi.sic.model.json.JsonItem;

@SuppressWarnings("serial")
public abstract class ABasicEntity implements IJsonEntity,IBasicDBEntity {

	@Id
	protected long id;
	
	@Override
	public FormData toFormJson() {
		return new FormData(true,this);
	}

	@Override
	public String toObjJson() {
		return Json.toJson(this);
	}
	
	@Override
	public JsonItem toJsonItem(boolean fold) {
		return null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
