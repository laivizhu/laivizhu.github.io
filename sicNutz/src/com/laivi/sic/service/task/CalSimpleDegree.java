package com.laivi.sic.service.task;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

import com.laivi.sic.model.po.blog.Article;
import com.laivi.sic.model.po.common.SimpleDegree;
import com.laivi.sic.model.type.CategoryType;
import com.laivi.sic.util.basic.DataUtil;

public class CalSimpleDegree implements Runnable {

	private Dao dao;
	
	private SimpleDegree simple;
	
	public CalSimpleDegree(Dao dao, SimpleDegree simple) {
		this.dao = dao;
		this.simple = simple;
	}

	@Override
	public void run() {
		List<Article> articleList=dao.query(Article.class, null);
		for(int i=0;i<articleList.size();i++){
			SimpleDegree tempSimple=dao.fetch(SimpleDegree.class, Cnd.where("objId", "=", articleList.get(i).getId()).and("type", "=", CategoryType.ARTICLE));
			if(tempSimple==null){
				continue;
			}
			String degree=DataUtil.getSimilarDegree(articleList.get(i).getTitle(), articleList.get(articleList.size()-1).getTitle());
			if(Double.parseDouble(degree)==0){
				continue;
			}
			DataUtil.setSampleDegree(tempSimple,degree, articleList.get(articleList.size()-1).getId());
			dao.update(tempSimple);
			DataUtil.setSampleDegree(simple,degree,articleList.get(i).getId());
		}
		dao.insert(simple);
	}

}
