/**
 * 
 */
package com.envisioncn.srm.system.action;

import java.util.List;

import javax.annotation.Resource;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.type.ResponseType;
import com.envisioncn.srm.system.bean.DepartmentBean;
import com.envisioncn.srm.system.service.DepartmentService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-29
 * 
 */

@SuppressWarnings("serial")
public class DepartmentAction extends ABasicAction<DepartmentBean>
{
	private DepartmentService departmentService;
	
	@Override
	public String list() throws Exception
	{
		String hql = "from DepartmentBean as bean";
		String hql2 = "select count(*)" + hql;
		Object[] parameters = null;
		int recordCount = departmentService.getPageCount(hql2, parameters);
		List<DepartmentBean> list = departmentService.getObjectListByPage(hql, parameters, start, limit);
		JsonArray ja = new JsonArray();
		for(DepartmentBean bean: list)
		{
			JsonObject jo = new JsonObject();
			jo.addProperty("id", bean.getId());
			jo.addProperty("name", bean.getName());
			ja.add(jo);
		}
		Gson gson = new Gson();
		return response(gson.toJson(ja), recordCount);
	}
	
	public String listAll() throws Exception
	{
		String hql = "from DepartmentBean as bean order by bean.name";
		List<DepartmentBean> list = departmentService.getObjectList(hql, null);
		JsonArray ja = new JsonArray();
		for(DepartmentBean bean: list)
		{
			JsonObject jo = new JsonObject();
			jo.addProperty("id", bean.getId());
			jo.addProperty("name", bean.getName());
			ja.add(jo);
		}
		Gson gson = new Gson();
		return response(ResponseType.JSON, gson.toJson(ja));
	}
	
	@Resource(name="DepartmentService")
	public void setDepartmentService(DepartmentService departmentService)
	{
		this.departmentService = departmentService;
	}
	
	public JsonItem getJsonItem(DepartmentBean object) throws Exception
	{
		return null;
	}

}
