package com.laivi.sic.service.system;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.laivi.sic.model.po.common.SimpleDegree;
import com.laivi.sic.model.po.system.News;
import com.laivi.sic.model.type.CategoryType;
import com.laivi.sic.service.basic.BasicDBService;
import com.laivi.sic.util.basic.DataUtil;

@IocBean
public class NewsService extends BasicDBService {

	public void add(final News news){
		final SimpleDegree simple=new SimpleDegree();
		Trans.exec(new Atom(){
			public void run() {
				dao.insert(news);
				simple.setObjId(news.getId());
				simple.setType(CategoryType.NEWS);
			}
		});
		Thread calSimpleDegreeThread=new Thread(new CalSimpleDegree(simple));
		calSimpleDegreeThread.start();
	}
	
	private class CalSimpleDegree implements Runnable{
		private SimpleDegree simple;
		
		public CalSimpleDegree(SimpleDegree simple) {
			this.simple = simple;
		}

		@Override
		public void run() {
			List<News> newsList=dao.query(News.class, null);
			for(int i=0;i<newsList.size();i++){
				SimpleDegree tempSimple=dao.fetch(SimpleDegree.class, Cnd.where("objId", "=", newsList.get(i).getId()).and("type", "=", CategoryType.NEWS));
				if(tempSimple==null){
					continue;
				}
				String degree=DataUtil.getSimilarDegree(newsList.get(i).getTitle(), newsList.get(newsList.size()-1).getTitle());
				if(Double.parseDouble(degree)==0){
					continue;
				}
				DataUtil.setSampleDegree(tempSimple,degree, newsList.get(newsList.size()-1).getId());
				dao.update(tempSimple);
				DataUtil.setSampleDegree(simple,degree,newsList.get(i).getId());
			}
			dao.insert(simple);
		}
		
	}
}
