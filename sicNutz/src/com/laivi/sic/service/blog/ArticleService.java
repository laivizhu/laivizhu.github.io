package com.laivi.sic.service.blog;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.laivi.sic.model.po.blog.Article;
import com.laivi.sic.model.po.blog.SimpleDegree;
import com.laivi.sic.model.po.common.FromOther;
import com.laivi.sic.model.type.CategoryType;
import com.laivi.sic.service.basic.BasicDBService;
import com.laivi.sic.service.task.CalSimpleDegree;

@IocBean
public class ArticleService extends BasicDBService{

	public void add(final Article article){
		final SimpleDegree simple=new SimpleDegree();
		Trans.exec(new Atom(){
			@Override
			public void run() {
				FromOther fromOther=new FromOther();
				dao.insert(article);
				fromOther.setObjId(article.getId());
				fromOther.setUserId(article.getUserId());
				fromOther.setType(CategoryType.ARTICLE);
				fromOther.setSelfIs(true);
				simple.setObjId(article.getId());
				simple.setType(CategoryType.ARTICLE);
				dao.insert(fromOther);
			}
		});
		Thread calSimpleDegreeThread=new Thread(new CalSimpleDegree(dao,simple));
		calSimpleDegreeThread.start();
	}
	
}
