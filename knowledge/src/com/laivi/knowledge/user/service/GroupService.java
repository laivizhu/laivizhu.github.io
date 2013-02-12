package com.laivi.knowledge.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.user.model.po.Group;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Feb 10, 2013
 */
@Service("GroupService")
public class GroupService extends BasicService<Group> implements IGroupService {

	@Resource(name="GroupDao")
    public void setBasicDao(IBasicDao<Group> basicDao){
        this.basicDao=basicDao;
    }
}
