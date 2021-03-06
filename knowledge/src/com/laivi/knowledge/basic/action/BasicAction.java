package com.laivi.knowledge.basic.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.model.constants.AppConstants;
import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.model.json.JsonItem;
import com.laivi.knowledge.basic.model.json.JsonList;
import com.laivi.knowledge.basic.model.po.BasicEntity;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.model.type.ResponseType;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.basic.util.DateUtil;
import com.laivi.knowledge.user.model.po.User;
import com.laivi.knowledge.user.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-12
 */
@SuppressWarnings("serial")
public abstract class BasicAction<T extends BasicEntity> extends ActionSupport implements IBasicAction<T> {
	protected IUserService userService;

	protected long id; // 常用Id
	protected String ids; //多Id拼接字符串，以，分割
	//************************************************分页参数*******************************************
	protected int start; // 分页开始数
	protected int limit; // 分页页容量
	//************************************************搜索参数*******************************************
	protected String value; // 查询的内容
	protected String key; // 查询内容的类别
	protected String startDate;//开始时间
	protected String endDate;//结束时间
	//************************************************下载参数*******************************************
	protected String downLoadPath; // 下载文件目录
	protected String resultPath; // 下载文件跳转result名
	protected String fileName; // 下载服务端文件名
	protected String downLoadFileName; // 下载的文件名
	
	protected boolean fold;				//是否截取内容
	protected boolean font;				//是否是前端请求
	
	protected CriterionList conditions;
	protected boolean notBreakPage;
	
	protected void getSearchConditions()throws Exception{
		Map<String,Object> paramterMap=ActionContext.getContext().getParameters();
		String[] keys=(String[])paramterMap.get("key");  
        String[] keyValues=(String[])paramterMap.get("value");
        if(conditions==null){
        	conditions=CriterionList.CreateCriterion();
        }
        if(DataUtil.notEmptyString(keyValues[0])){
        	conditions.put(Restrictions.like(keys[0], encodeString(keyValues[0]),MatchMode.ANYWHERE));
        }
		for(Map.Entry<String, Object> entry:paramterMap.entrySet()){
			String[] keywords={"start","limit","key","value","notBreakPage","searialRand"};
			boolean skipFlag=false;
			for(String keyword:keywords){
				if(keyword.equals(entry.getKey())){
					skipFlag=true;
					break;
				}
			}
			if(skipFlag){
				continue;
			}
			String[] values=(String[])entry.getValue();
			if(DataUtil.notEmptyString(values[0])){
				if("startDate".equals(entry.getKey())){
					conditions.put(Restrictions.ge("createDate", DateUtil.formatString(values[0])));
					continue;
				}
				if("endDate".equals(entry.getKey())){
					conditions.put(Restrictions.le("createDate", DateUtil.formateAddOneDate(values[0])));
					continue;
				}
				conditions.put(Restrictions.like(entry.getKey(), values[0],MatchMode.ANYWHERE));
			}
		}
	}
	
	public String getKeywordCombolList()throws Exception{
		return response(this.getSearchComboList());
	}
	
	protected void addData(JsonList jsonList,T o) throws Exception{
		JsonItem item=this.getJsonItem(o,true);
		if(item==null){
			jsonList.add(o.toJson());
		}else{
			jsonList.add(item.toString());
		}
	}
	
	/**
	 * @throws ErrorException 
	 * 
	 * 函数功能说明:获取登入用户Id
	 * 修改者名字Janlu 修改日期  Jan 14, 2013
	 * 修改内容
	 * @参数： @return    
	 * @return long   
	 * @throws
	 */
	protected long getCurrentUserId() throws ErrorException{
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user!=null){
			return user.getId();
		}else{
			throw new ErrorException("error.user.notLogin");
		}
	}
	
	protected User getCurrentUser() throws ErrorException{
		return (User)ServletActionContext.getRequest().getSession().getAttribute("user");
	}
	
	/**
	 * 
	 * 函数功能说明:判断是否是系统管理员
	 * 修改者名字Janlu 修改日期  Jan 14, 2013
	 * 修改内容
	 * @参数： @return    
	 * @return boolean   
	 * @throws
	 */
	protected boolean isSystemUser(){
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user!=null){
			return user.isSysUser();
		}else{
			return true;
		}
	}
	
	/**
	 * @throws ErrorException 
	 * 
	 * 函数功能说明：获取当前用户的查询条件
	 * 修改者名字Janlu 修改日期  Jan 14, 2013
	 * 修改内容
	 * @参数： @return    
	 * @return CriterionList   
	 * @throws
	 */
	protected CriterionList getUserCriterionList() throws ErrorException{
		if(this.conditions==null){
			this.conditions=CriterionList.CreateCriterion();
		}
		if(!this.isSystemUser()){
			conditions.put(Restrictions.eq("userId", this.getCurrentUserId()));
		}
		return conditions;
	}

	/**
	 * 
	 * 函数功能说明：
	 * 修改者名字Janlu 修改日期  Jan 14, 2013
	 * 修改内容
	 * @参数：     
	 * @return String   
	 * @throws Exception
	 */
	public String downLoad() throws Exception {
		if (DataUtil.notEmptyString(resultPath)) {
			return resultPath;
		}
		return AppConstants.SUCCESS_DOWNLOAD_RESULT;
	}

	public InputStream getDownLoadInputStream() throws Exception {
		InputStream is;
		this.downLoadFileName=java.net.URLEncoder.encode(downLoadFileName, "UTF-8");
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
		return response(success, AppConstants.EMPTY);
	}

	public String response(boolean success, String msg) throws IOException {
        return response(ResponseType.JSON,success,msg);
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
	 * 函数功能说明: 
	 * 修改者名字Janlu 修改日期 2012-11-18 修改内容
	 * @参数： @param path
	 * @return String
	 * @throws
	 */
	protected String getRealPath(String path) {
		return ServletActionContext.getRequest().getSession().getServletContext().getRealPath(path);
	}

	protected String encodeString(String value) {
		try {
			return new String(value.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return AppConstants.EMPTY;
		}
	}
	
	protected String encodeExtString(String value) {
		try {
			value = new String(value.trim().getBytes("ISO-8859-1"),"UTF-8");
			value=value.substring(1,value.length()-1);
		} catch (UnsupportedEncodingException e) {
			return AppConstants.EMPTY;
		}
		return value;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		try {
			this.fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getDownLoadFileName() {
		return downLoadFileName;
	}

	public void setDownLoadFileName(String downLoadFileName) {
		try {
			this.downLoadFileName = new String(downLoadFileName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getDownLoadPath() {
		return downLoadPath;
	}
	public void setDownLoadPath(String downLoadPath) {
		this.downLoadPath = downLoadPath;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public boolean isFold() {
		return fold;
	}

	public void setFold(boolean fold) {
		this.fold = fold;
	}

	public boolean isFont() {
		return font;
	}

	public void setFont(boolean font) {
		this.font = font;
	}

	public boolean isNotBreakPage() {
		return notBreakPage;
	}

	public void setNotBreakPage(boolean notBreakPage) {
		this.notBreakPage = notBreakPage;
	}
	
}
