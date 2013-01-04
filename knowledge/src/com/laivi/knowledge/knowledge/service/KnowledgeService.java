package com.laivi.knowledge.knowledge.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.knowledge.model.po.Knowledge;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午2:08
 */
@Service("KnowledgeService")
public class KnowledgeService extends BasicService<Knowledge> implements IKnowledgeService {
	@Resource(name="KnowledgeDao")
    public void setBasicDao(IBasicDao<Knowledge> basicDao){
        this.basicDao=basicDao;
    }
	
}
