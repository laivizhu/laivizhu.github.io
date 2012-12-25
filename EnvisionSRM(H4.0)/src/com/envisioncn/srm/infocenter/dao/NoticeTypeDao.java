package com.envisioncn.srm.infocenter.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.infocenter.bean.NoticeTypeBean;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date  2012-11-19
 * 
 */

@Service("NoticeTypeDao")
public class NoticeTypeDao extends ABasicDao<NoticeTypeBean> implements INoticeTypeDao {

	public Criteria getCriteria() {
		return null;
	}

}
