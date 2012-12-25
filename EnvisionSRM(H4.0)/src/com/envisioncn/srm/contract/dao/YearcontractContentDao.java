/**
 * 
 */
package com.envisioncn.srm.contract.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.YearcontractContentBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("YearcontractContentDao")
public class YearcontractContentDao extends ABasicDao<YearcontractContentBean> implements IYearcontractContentDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(YearcontractContentBean.class);
	}
	
	public List<YearcontractContentBean> getListObject(long id){
		Criteria dc=this.getCriteria();
		dc.add(Restrictions.eq("yearcontractid", id));
		dc.addOrder(Order.asc("projectnumber"));
		return this.getList(dc);
	}
	
	
}
