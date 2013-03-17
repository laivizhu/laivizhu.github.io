package com.laivi.knowledge.test;

import com.laivi.knowledge.common.model.po.Tag;
import com.laivi.knowledge.knowledge.model.type.TagType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.laivi.knowledge.user.model.po.Role;
import com.laivi.knowledge.user.model.po.User;
import com.laivi.knowledge.user.model.type.RoleType;

import java.util.ArrayList;
import java.util.List;

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
    
    @Test
    public void testAddTagData(){
        List<Tag> tagList= new ArrayList <Tag>();
    	tagList.add(new Tag("言情",1, TagType.BOOK));
        tagList.add(new Tag("都市",1, TagType.BOOK));
        tagList.add(new Tag("哲理",1, TagType.BOOK));
        tagList.add(new Tag("散文",1, TagType.BOOK));
        tagList.add(new Tag("侦探",1, TagType.BOOK));
        tagList.add(new Tag("情感",1, TagType.ARTICLE));
        tagList.add(new Tag("生活",1, TagType.ARTICLE));
        tagList.add(new Tag("感悟",1, TagType.ARTICLE));

        for(Tag tag:tagList){
            hibernatetemplate.save(tag);
        }

    }
}
