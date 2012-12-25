/**
 * 
 */
package com.envisioncn.srm.contract.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.contract.bean.AttachmentBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("AttachmentService")
public class AttachmentService extends BasicService<AttachmentBean> implements
		IAttachmentService {
	

	@Resource(name="AttachmentDao")
	public void setBasicDao(IBasicDao<AttachmentBean> basicDao){
		this.basicDao=basicDao;
	}
	
	

	
}
