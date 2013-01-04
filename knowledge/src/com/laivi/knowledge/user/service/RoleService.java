package com.laivi.knowledge.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.user.model.po.Role;

/**
 * Created with IntelliJ IDEA.
 * User: Janlu
 * Date: 12-12-29
 * Time: 下午12:37
 * To change this template use File | Settings | File Templates.
 */
@Service("RoleService")
public class RoleService extends BasicService<Role> implements IRoleService {
    @Resource(name="RoleDao")
    public void setBasicDao(IBasicDao<Role> basicDao){
        this.basicDao=basicDao;
    }
}
