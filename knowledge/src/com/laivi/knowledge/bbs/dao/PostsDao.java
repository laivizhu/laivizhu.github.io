package com.laivi.knowledge.bbs.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.ABasicDao;
import com.laivi.knowledge.bbs.model.po.Posts;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午1:37
 */
@Service("PostsDao")
public class PostsDao extends ABasicDao<Posts> implements IPostsDao {
    public DetachedCriteria getCriteria() {
        return DetachedCriteria.forClass(Posts.class);
    }
}
