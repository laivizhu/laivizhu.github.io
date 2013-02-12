package com.laivi.knowledge.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.user.model.po.AutoGraph;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 10, 2013
 */
@Service("AutoGraphService")
public class AutoGraphService extends BasicService<AutoGraph> implements IAutoGraphService {

	@Resource(name="AutoGraphDao")
    public void setBasicDao(IBasicDao<AutoGraph> basicDao){
        this.basicDao=basicDao;
    }
	
}
