package com.laivi.knowledge.user.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.user.model.po.Role;


/**
 * 角色管理
 * @author Administrator
 */
@Service("RoleDao")
public class RoleDao extends ABasicDao<Role> implements IRoleDao {


    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Role.class);
    }
}
