/**
 * Copyright Laivi 2013-4-18
 * Version 1.0 sic
 */
package com.laivi.sic.basic.action;

import com.laivi.sic.basic.model.po.IBasicEntity;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author laivi Desc:
 */
@SuppressWarnings("serial")
public abstract class ABasicAction<T extends IBasicEntity> extends
		ActionSupport implements IBasicAction, IBasicDBAction<T> {

	protected int start; // 分页开始数
	protected int limit; // 分页页容量

	// ************************************************下载参数*******************************************
	protected String downLoadPath; // 下载文件目录
	protected String resultPath; // 下载文件跳转result名
	protected String fileName; // 下载服务端文件名
	protected String downLoadFileName; // 下载的文件名
	
	

}
