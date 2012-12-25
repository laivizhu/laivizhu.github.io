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
import com.envisioncn.srm.supplier_development.bean.SecuritTemplateBean;

/**
 * Copyright Envision
 *
 * @author Mars
 * @version
 * @data 2012-11-13
 */

@Service("SecuritTemplateService")
public class SecuritTemplateService extends BasicService<SecuritTemplateBean> implements ISecuritTemplateService{

	@Resource(name="SecuritTemplateDao")
	public void setBasicDao(IBasicDao<SecuritTemplateBean> basicDao) {
		this.basicDao = basicDao;
	}
}
