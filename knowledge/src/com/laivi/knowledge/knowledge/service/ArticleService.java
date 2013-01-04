package com.laivi.knowledge.knowledge.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.knowledge.model.po.Article;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午2:08
 */
@Service("ArticleService")
public class ArticleService extends BasicService<Article> implements IArticleService {
	@Resource(name="ArticleDao")
    public void setBasicDao(IBasicDao<Article> basicDao){
        this.basicDao=basicDao;
    }
	
}
