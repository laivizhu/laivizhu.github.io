package com.envisioncn.srm.infocenter.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.infocenter.bean.NoticeOuterBean;


/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-22
 * 
 */
@Service("NoticeOuterDao")
public class NoticeOuterDao extends ABasicDao<NoticeOuterBean> implements INoticeOuterDao {

	public Criteria getCriteria() {
		return null;
	}
	
}
