package com.laivi.sic.model.po.basic;

import com.laivi.sic.model.json.FormData;


public interface IJsonEntity extends IBasicEntity{
	String toObjJson();
	
	FormData toFormJson();
	
}
