package com.envisioncn.srm.infocenter.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.infocenter.bean.NoticeTypeBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-19
 * 
 */

@Service("NoticeTypeService")
public class NoticeTypeService extends BasicService<NoticeTypeBean> implements
		INoticeTypeService {
	
	@Resource(name="NoticeTypeDao")
	public void setBasicDao(IBasicDao<NoticeTypeBean> basicDao) {
		this.basicDao = basicDao;
	}

}
