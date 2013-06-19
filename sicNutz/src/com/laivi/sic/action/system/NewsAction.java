package com.laivi.sic.action.system;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.annotation.CheckValue;
import com.laivi.sic.model.po.system.News;
import com.laivi.sic.model.to.Response;


@IocBean
@At("/system/news")
public class NewsAction extends ABasicDBAction<News> {
	
	@CheckLogin
	@CheckValue
	@At
	public Response add(@Param("::news.")News news) throws Exception{
		news.setUserId(this.getUserId());
		this.basicService.add(news);
		return success();
	}
	
	

	@Override
	public Class<News> getEntityClass() {
		return News.class;
	}

}
