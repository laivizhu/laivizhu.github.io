package com.envisioncn.srm.infocenter.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.infocenter.bean.NoticeInnerBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-17
 * 
 */

@Service("NoticeInnerService")
public class NoticeInnerService extends BasicService<NoticeInnerBean> implements
		INoticeInnerService {
	
	@Resource(name = "NoticeInnerDao")
	public void setBasicDao(IBasicDao<NoticeInnerBean> basicDao) {
		this.basicDao = basicDao;
	}

}
