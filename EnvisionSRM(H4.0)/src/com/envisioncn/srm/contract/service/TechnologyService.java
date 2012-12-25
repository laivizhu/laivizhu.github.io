/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.TechnologyBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("TechnologyService")
public class TechnologyService extends BasicService<TechnologyBean> implements
		ITechnologyService {
	

	@Resource(name="TechnologyDao")
	public void setBasicDao(IBasicDao<TechnologyBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
