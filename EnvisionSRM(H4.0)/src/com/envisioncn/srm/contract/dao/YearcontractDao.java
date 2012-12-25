package com.envisioncn.srm.contract.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.ABasicDao;
import com.envisioncn.srm.contract.bean.YearcontractBean;
import com.envisioncn.srm.contract.common.YearContractConstants;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("YearcontractDao")
public class YearcontractDao extends ABasicDao<YearcontractBean> implements IYearcontractDao {

	public Criteria getCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(YearcontractBean.class);
	}
	
	public YearcontractBean getObject(int id){
		Criteria dc=this.getCriteria();
		dc.add(Restrictions.eq("yearcontractid", id));
		return this.getList(dc).get(0);
	}
	
	public List<YearcontractBean> getListObjects(String type){
		Criteria dc=this.getCriteria();
		dc.add(Restrictions.eq("type", type));
		return this.getList(dc);
	}
	
	public boolean checkIsRepeat(String name){
		Criteria dc=this.getCriteria();
		dc.add(Restrictions.eq("name", name));
		return this.getList(dc).isEmpty();
	}
	
	public boolean checkValidate(Date beginDate,Date endDate,String type){
		Criteria dc=this.getCriteria();
		dc.add(Restrictions.and(Restrictions.eq("type", type),Restrictions.le("enddate", beginDate) ));
		return this.getList(dc).isEmpty();
	}
	
	public List<YearcontractBean> getUnConformedList(int start,int limit){
		Criteria dc = this.getCriteria();
		dc.add(Restrictions.eq("type", YearContractConstants.State.TEMP_PRODUCTIVE.ordinal()));
		return this.getList(dc, start, limit);
	}
	
	public List<YearcontractBean> getConformList(int start,int limit){
		Criteria dc = this.getCriteria();
		dc.add(Restrictions.eq("type", YearContractConstants.State.TEMP_NONPRODUCTIVE.ordinal()));
		return this.getList(dc, start, limit);
	}
}
