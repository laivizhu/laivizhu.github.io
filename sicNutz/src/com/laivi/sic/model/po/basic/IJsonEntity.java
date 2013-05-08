package com.laivi.sic.model.po.basic;

import com.laivi.sic.model.json.FormData;
import com.laivi.sic.model.json.JsonItem;


public interface IJsonEntity extends IBasicEntity{
	String toObjJson();
	
	FormData toFormJson();
	
	JsonItem toJsonItem(boolean fold);
}
