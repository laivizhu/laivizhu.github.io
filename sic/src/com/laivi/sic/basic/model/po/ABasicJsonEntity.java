/**
 * Copyright Laivi 2013-4-10
 * Version 1.0 sic
 */
package com.laivi.sic.basic.model.po;

import com.laivi.sic.basic.model.json.FormDataItem;
import com.laivi.sic.basic.util.JsonUtil;

/**
 * @author laivi
 * Desc:
 */
@SuppressWarnings("serial")
public abstract class ABasicJsonEntity implements IBasicJsonEntity {

	@Override
	public String toJson() {
		return JsonUtil.parseObject(this);
	}

	@Override
	public String toFormJson(boolean success) {
		return new FormDataItem<ABasicJsonEntity>(success,this).toString();
	}

}
