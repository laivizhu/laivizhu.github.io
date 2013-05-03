package com.laivi.sic.model.po.basic;


public interface IJsonEntity extends IBasicEntity{
	String toObjJson();
	
	String toFormJson(boolean success);
}
