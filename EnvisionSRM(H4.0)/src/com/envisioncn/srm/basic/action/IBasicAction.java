package com.envisioncn.srm.basic.action;

import java.io.InputStream;
import java.io.Serializable;

import com.envisioncn.srm.basic.model.json.JsonItem;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
public interface IBasicAction<T> extends Serializable {
	/**
	 * 
	 * description:add Model Object data 2012-11-12 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	String add() throws Exception;

	/**
	 * 
	 * description:Delete Model Object data 2012-11-12 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	String delete() throws Exception;

	/**
	 * 
	 * description:Update Model Object data 2012-11-12 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	String update() throws Exception;

	/**
	 * 
	 * description:List Model Object by Page data 2012-11-12 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	String list() throws Exception;

	/**
	 * 
	 * description:get Model Object By key data 2012-11-12 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	String get() throws Exception;

	/**
	 * 
	 * description: data 2012-12-1 user Janlu.Zhu
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	JsonItem getJsonItem(T object) throws Exception;

	/**
	 * 
	 * description: data 2012-12-1 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	String downLoad() throws Exception;

	/**
	 * description: data 2012-12-1 user Janlu.Zhu
	 * 
	 * @return
	 * @throws Exception
	 */
	InputStream getDownLoadInputStream() throws Exception;

}
