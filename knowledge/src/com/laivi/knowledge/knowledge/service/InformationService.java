package com.laivi.knowledge.knowledge.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.knowledge.model.po.Information;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午2:08
 */
@Service("InformationService")
public class InformationService extends BasicService<Information> implements IInformationService {
	@Resource(name="InformationDao")
    public void setBasicDao(IBasicDao<Information> basicDao){
        this.basicDao=basicDao;
    }
	
}
