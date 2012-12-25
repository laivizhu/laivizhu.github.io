/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.AttachmentBean;
/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-19
 */
@Service("AttachmentDao")
public class AttachmentDao extends ABasicDao<AttachmentBean> implements IAttachmentDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(AttachmentBean.class);
	}
}
