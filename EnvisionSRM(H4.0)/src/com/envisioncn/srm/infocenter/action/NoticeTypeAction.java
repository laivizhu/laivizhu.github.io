package com.envisioncn.srm.infocenter.action;

import java.util.List;

import javax.annotation.Resource;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.util.GsonUtil;
import com.envisioncn.srm.infocenter.bean.NoticeTypeBean;
import com.envisioncn.srm.infocenter.service.NoticeTypeService;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-19
 * 
 */
@SuppressWarnings("serial")
public class NoticeTypeAction extends ABasicAction<NoticeTypeBean> {
	
	private NoticeTypeService service;

	public String add() throws Exception {
		return null;
	}

	public String delete() throws Exception {
		return null;
	}

	public String update() throws Exception {
		return null;
	}

	public String list() throws Exception {
		String hql = "from NoticeTypeBean";
		String hql2 = "select count(*)" + hql;
		List<NoticeTypeBean> list = service.getObjectList(hql, null);
		int recordsCount = service.getPageCount(hql2, null);
		return response(GsonUtil.toJson(list, recordsCount));
	}

	public String get() throws Exception {
		return null;
	}

	@Resource(name="NoticeTypeService")
	public void setService(NoticeTypeService service) {
		this.service = service;
	}

	public JsonItem getJsonItem(NoticeTypeBean object) throws Exception {
		return null;
	}
}
