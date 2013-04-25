/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.model.po.basic;

import org.nutz.json.Json;

import com.laivi.sic.model.json.FormDataItem;


/**
 * @author laivi
 * Desc:
 */
@SuppressWarnings("serial")
public abstract class ABasicJsonEntity implements IBasicJsonEntity,IBasicDBEntity {

	@Override
	public String toJson() {
		return Json.toJson(this);
	}

	@Override
	public String toFormJson(boolean success) {
		return new FormDataItem<ABasicJsonEntity>(success,this).toString();
	}

}
