package com.laivi.knowledge.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.laivi.knowledge.user.model.po.Role;
import com.laivi.knowledge.user.model.po.User;
import com.laivi.knowledge.user.model.type.RoleType;

public class ExportData {
    private static ClassPathXmlApplicationContext ctx;
    private HibernateTemplate hibernatetemplate;

	static{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Before
	public void setUp(){
		hibernatetemplate=(HibernateTemplate)ctx.getBean("hibernateTemplate");
	}
    @Test
    public void testAddRoleData(){
        for(RoleType roleType:RoleType.values()){
            Role role=new Role(roleType.toString(),roleType.getDescription());
            hibernatetemplate.save(role);
        }
    }
    @Test
    public void testAddUserData(){
        User user=new User("laivi","laivi", "laivi",true,true);
        hibernatetemplate.save(user);
    }
}
