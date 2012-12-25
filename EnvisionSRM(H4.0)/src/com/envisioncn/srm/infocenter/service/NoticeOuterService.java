package com.envisioncn.srm.infocenter.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.infocenter.bean.NoticeOuterBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-22
 * 
 */
@Service("NoticeOuterService")
public class NoticeOuterService extends BasicService<NoticeOuterBean> implements INoticeOuterService {

	@Resource(name="NoticeOuterDao")
	public void setBasicDao(IBasicDao<NoticeOuterBean> basicDao) {
		super.basicDao = basicDao;
	}
	
}
