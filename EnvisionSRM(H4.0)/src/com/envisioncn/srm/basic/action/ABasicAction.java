package com.envisioncn.srm.basic.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.envisioncn.srm.basic.model.BaseEntity;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.basic.model.type.ResponseType;
import com.envisioncn.srm.basic.service.IBasicService;
import com.envisioncn.srm.basic.util.DataUtil;
import com.envisioncn.srm.basic.util.JsonUtil;
import com.envisioncn.srm.basic.util.ParamAssert;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
@SuppressWarnings("serial")
public abstract class ABasicAction<T extends BaseEntity> extends ActionSupport implements IBasicAction<T> {
	protected T baseEntity;
	protected IBasicService<T> basicService;

	protected final String FAILURE = "failure";

	protected long id; // 常用Id
	protected int start; // 分页开始数
	protected int limit; // 分页页容量

	protected String value; // 查询的内容
	protected String key; // 查询内容的类别

	protected String downLoadPath; // 下载文件目录
	protected String resultPath; // 下载文件跳转result名
	protected String fileName; // 下载服务端文件名
	protected String downLoadFileName; // 下载的文件名

	public String delete() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		basicService.remove(id);
		return response(true);
	}

	public String get() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		return response(JsonUtil.parseObject(this.basicService.getObject(id)));
	}

	public String list() throws Exception {
		JsonList jsonList = new JsonList();
		for (T o : basicService.getList(start, limit)) {
			jsonList.add(this.getJsonItem(o));
		}
		return response(jsonList);
	}

	public String update() throws Exception {
		return null;
	}

	public String add() throws Exception {
		return null;
	}

	public String downLoad() throws Exception {
		if (DataUtil.notEmptyString(resultPath)) {
			return resultPath;
		}
		return AppConstants.SUCCESS_DOWNLOAD_RESULT;
	}

	public InputStream getDownLoadInputStream() throws Exception {
		InputStream is = null;
		is = ServletActionContext.getServletContext().getResourceAsStream(downLoadPath + fileName);
		if (is == null) {
			this.addActionError(ErrorMessageConstants.Common.FILE_NOT_FOUND);
		}
		return is;
	}

	public String response(ResponseType responseType, String response) throws IOException {
		ServletActionContext.getResponse().setContentType(responseType.toText());
		ServletActionContext.getResponse().getWriter().write(response);
		return null;
	}

	public String response(ResponseType responseType, Object... objects) throws IOException {
		return response(responseType, append(objects));
	}

	public String response(Object... objects) throws IOException {
		return response(ResponseType.JSON, objects);
	}

	public String response(boolean success) throws IOException {
		return response(success, "");
	}

	public String response(boolean success, String msg) throws IOException {
		if (success) {
			return response("{\"success\":" + true + ",\"msg\":\"" + msg + "\"}");
		} else {
			return response("{\"success\":" + false + ",\"msg\":\"" + msg + "\"}");
		}
	}

	public String response(ResponseType responseType, boolean success, String msg) throws IOException {
		if (success) {
			return response(responseType, "{\"success\":" + true + ",\"msg\":\"" + msg + "\"}");
		} else {
			return response(responseType, "{\"success\":" + false + ",\"msg\":\"" + msg + "\"}");
		}
	}

	public static String append(Object... objects) {
		if (objects.length == 1) {
			return objects[0].toString();
		}
		StringBuilder sb = new StringBuilder();
		for (Object o : objects) {
			sb.append(o);
		}
		return sb.toString();
	}

	/**
	 * 
	 * 函数功能说明: 修改者名字Janlu 修改日期 2012-11-18 修改内容
	 * 
	 * @参数： @param path
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	public String getRealPath(String path) {
		return ServletActionContext.getRequest().getSession().getServletContext().getRealPath(path);
	}

	public String encodeString(String value) {
		try {
			return new String(value.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return AppConstants.EMPTY;
		}
	}

	public long getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public T getBaseEntity() {
		return baseEntity;
	}

	public void setBaseEntity(T baseEntity) {
		this.baseEntity = baseEntity;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownLoadFileName() {
		return downLoadFileName;
	}

	public void setDownLoadFileName(String downLoadFileName) {
		this.downLoadFileName = downLoadFileName;
	}
}