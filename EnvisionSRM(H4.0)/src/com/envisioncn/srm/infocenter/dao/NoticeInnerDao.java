package com.envisioncn.srm.infocenter.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.infocenter.bean.NoticeInnerBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-17
 * 
 */

@Service("NoticeInnerDao")
public class NoticeInnerDao extends ABasicDao<NoticeInnerBean> implements INoticeInnerDao {

	public Criteria getCriteria() {
		return null;
	}
}
