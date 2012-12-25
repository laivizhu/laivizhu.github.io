/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-13
 */
package com.envisioncn.srm.supplier_development.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.supplier_development.bean.SecuritBean;

/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-13
 */

@Service("SecuritService")
public class SecuritService extends BasicService<SecuritBean> implements ISecuritService{
	@Resource(name="SecuritDao")
	public void setBasicDao(IBasicDao<SecuritBean> basicDao) {
		this.basicDao = basicDao;
	}
	
}
