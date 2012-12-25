/**
 * 
 */
package com.envisioncn.srm.contract.service;

import java.io.File;

import com.envisioncn.srm.basic.service.IBasicService;
import com.envisioncn.srm.contract.bean.YearcontractBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
public interface IYearContractService extends IBasicService<YearcontractBean> {

	void addYearContract(YearcontractBean yearcontractBean,File word_path,String path)throws Exception;
}
