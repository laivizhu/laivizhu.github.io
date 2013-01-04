package com.laivi.knowledge.knowledge.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.knowledge.model.po.Article;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:37
 */
@Service("ArticleDao")
public class ArticleDao extends ABasicDao<Article> implements IArticleDao {
    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Article.class);
    }
}
