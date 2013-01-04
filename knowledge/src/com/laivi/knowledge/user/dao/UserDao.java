package com.laivi.knowledge.user.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.user.model.po.User;


/**
 * 用户管理对象
 * 
 * @author Administrator
 * 
 */

@Service("UserDao")
public class UserDao extends ABasicDao<User> implements IUserDao {

    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(User.class);
    }
}
