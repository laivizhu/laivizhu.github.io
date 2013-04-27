package com.laivi.sic.model.po.basic;

import org.nutz.json.Json;

import com.laivi.sic.model.json.FormDataItem;

@SuppressWarnings("serial")
public abstract class ABasicEntity implements IJsonEntity,IBasicDBEntity {

	@Override
	public String toFormJson(boolean success) {
		return Json.toJson(new FormDataItem<IJsonEntity>(true,this));
	}

	@Override
	public String toObjJson() {
		return Json.toJson(this);
	}

}
