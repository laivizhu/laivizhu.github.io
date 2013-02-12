package com.laivi.knowledge.user.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.user.model.po.Message;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:37
 */
@Service("MessageDao")
public class MessageDao extends ABasicDao<Message> implements IMessageDao {
    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Message.class);
    }
}
