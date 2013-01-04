package com.laivi.knowledge.knowledge.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.knowledge.model.po.Knowledge;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:47
 */
@Service("KnowledgeDao")
public class KnowledgeDao extends ABasicDao<Knowledge> implements IKnowledgeDao{
    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Knowledge.class);
    }
}
