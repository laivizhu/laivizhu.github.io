package com.laivi.nutz;


import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

import com.laivi.nutz.model.po.User;

public class NutzSetUp implements Setup{
	
	private static final Log log=Logs.get();

	@Override
	public void init(NutConfig config) {
		log.debug("config Ioc=="+config.getIoc());
		Dao dao=config.getIoc().get(Dao.class);
		for (Class<?> klass : Scans.me().scanPackage("com.laivi.nutz.model.po")) {
			if(null!=klass.getAnnotation(Table.class)){
				dao.create(klass, false);
			}
		}
		
		if(dao.count(User.class)==0){
			User user=new User();
			user.setAge(26);
			user.setName("laivi");
			user.setPassword("laivi");
			dao.insert(user);
		}
	}

	@Override
	public void destroy(NutConfig config) {
		
	}

}
