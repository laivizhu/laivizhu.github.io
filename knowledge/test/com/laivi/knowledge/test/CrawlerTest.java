package com.laivi.knowledge.test;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.LBasicService;
import com.laivi.knowledge.knowledge.model.po.Article;
import com.laivi.knowledge.tool.crawler.Crawler;
import com.laivi.knowledge.tool.crawler.LinkFilter;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-5-3
 */
public class CrawlerTest {
	
	private static ClassPathXmlApplicationContext ctx;
    private LBasicService<Article> basicService;

	static{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp(){
		basicService=(LBasicService<Article>)ctx.getBean("LBasicService");
	}

	@Test
	public void crawlerArticle(){
		Crawler crawler = new Crawler();
        List<Article> articles=crawler.crawlingArticle(new String[]{"http://www.timetimetime.net/yulu/","http://www.timetimetime.net/yuedu/"},new LinkFilter(){
        	public  boolean accept(String url) {
        		if (url.matches("http://www.timetimetime.net/yuedu/[\\d]+.html")
        			|| url.matches("http://www.timetimetime.net/yulu/[\\d]+.html")) {
        			return true;
        		} else {
        			return false;
        		}
        	}
        });
        
        for(Article article:articles){
        	CriterionList conditions=CriterionList.CreateCriterion().put(Restrictions.like("title", article.getTitle(), MatchMode.ANYWHERE));
        	if(basicService.getCount(Article.class, conditions)>0){
        		continue;
        	}else{
        		boolean isFound=false;
        		String[] loveKey=new String[]{"爱情","情感","你","喜欢","心","眼泪"};
        		String[] lifeKey=new String[]{"生活","职场","人生"};
        		String[] thinkKey=new String[]{};
        		for(String key:loveKey){
        			if(article.getTitle().indexOf(key)!=-1){
        				article.setTagIds("3");
        				isFound=true;
        				break;
        			}
        		}
        		if(!isFound){
	        		for(String key:lifeKey){
	        			if(article.getTitle().indexOf(key)!=-1){
	        				article.setTagIds("6");
	        				isFound=true;
	        				break;
	        			}
	        		}
        		}
        		if(!isFound){
        			for(String key:thinkKey){
            			if(article.getTitle().indexOf(key)!=-1){
            				article.setTagIds("7");
            				isFound=true;
            				break;
            			}
            		}
        		}
        		if(!isFound){
        			article.setTagIds("7");
        		}
        		basicService.add(article);
        	}
        }
	}

}
