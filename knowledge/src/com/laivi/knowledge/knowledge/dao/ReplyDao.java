package com.laivi.knowledge.knowledge.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.knowledge.model.po.Reply;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:37
 */
@Service("ReplyDao")
public class ReplyDao extends ABasicDao<Reply> implements IReplyDao {
    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Reply.class);
    }
}
