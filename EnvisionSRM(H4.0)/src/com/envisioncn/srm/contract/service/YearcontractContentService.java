/**
 * 
 */
package com.envisioncn.srm.contract.service;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.YearcontractContentBean;
import com.envisioncn.srm.contract.dao.YearcontractContentDao;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("YearcontractContentService")
public class YearcontractContentService extends BasicService<YearcontractContentBean> implements
		IYearcontractContentService {
	
	private YearcontractContentDao yearContractContentDao;
	
	@Resource(name="YearcontractContentDao")
	public void setYearContractContentDao(
			YearcontractContentDao yearContractContentDao) {
		this.yearContractContentDao = yearContractContentDao;
	}

	@Resource(name="YearcontractContentDao")
	public void setBasicDao(IBasicDao<YearcontractContentBean> basicDao){
		this.basicDao=basicDao;
	}
	
	public List<YearcontractContentBean> getListObjects(long id){
		return yearContractContentDao.getListObject(id);
	}


}
