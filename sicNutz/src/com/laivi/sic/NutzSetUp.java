package com.laivi.sic;


import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

import com.laivi.sic.model.po.blog.Tag;
import com.laivi.sic.model.po.user.LoginUser;
import com.laivi.sic.model.po.user.Role;
import com.laivi.sic.model.po.user.User;
import com.laivi.sic.model.type.TagType;

public class NutzSetUp implements Setup{
	
	private static final Log log=Logs.get();

	@Override
	public void init(NutConfig config) {
		log.debug("config Ioc=="+config.getIoc());
		Dao dao=config.getIoc().get(Dao.class);
		for (Class<?> klass : Scans.me().scanPackage("com.laivi.sic.model.po")) {
			if(null!=klass.getAnnotation(Table.class)){
				dao.create(klass, false);
			}
		}
		
		if(dao.count(User.class)==0){
			User user=new User();
			user.setName("laivi");
			user.setDescription("laivi");
			user.setRoleIds("1");
			dao.insert(user);
		}
		
		if(dao.count(LoginUser.class)==0){
			LoginUser user=new LoginUser();
			user.setEmail("laivi.zhu@gmail.com");
			user.setPassword("laivi");
			user.setUidendity("laivi.zhu@gmail.com");
			dao.insert(user);
		}
		
		if(dao.count(Role.class)==0){
			Role[] roles=new Role[2];
			roles[0]=new Role();
			roles[0].setName("ROLE_ADMIN");
			roles[0].setDescription("管理员");
			
			roles[1]=new Role();
			roles[1].setName("ROLE_USER");
			roles[1].setDescription("普通用户");
			
			for(Role role:roles){
				dao.insert(role);
			}
		}
		
		if(dao.count(Tag.class)==0){
			Tag tag=new Tag();
			tag.setName("情感");
			tag.setType(TagType.ARTICLE);
			dao.insert(tag);
		}
		
		/*if(dao.count(Message.class)==0){
			Message message=new Message();
			message.setStatus(Status.UNREAD);
			dao.insert(message);
		}*/
	}

	@Override
	public void destroy(NutConfig config) {
		
	}

}
