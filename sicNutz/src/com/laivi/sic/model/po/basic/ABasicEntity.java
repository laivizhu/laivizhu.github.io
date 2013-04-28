package com.laivi.sic.model.po.basic;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.json.Json;

import com.laivi.sic.model.json.FormDataItem;

@SuppressWarnings("serial")
public abstract class ABasicEntity implements IJsonEntity,IBasicDBEntity {

	@Id
	protected long id;
	
	@Override
	public String toFormJson(boolean success) {
		return Json.toJson(new FormDataItem<IJsonEntity>(true,this));
	}

	@Override
	public String toObjJson() {
		return Json.toJson(this);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
