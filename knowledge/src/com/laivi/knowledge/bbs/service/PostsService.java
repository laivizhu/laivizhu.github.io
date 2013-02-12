package com.laivi.knowledge.bbs.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.bbs.model.po.Posts;

/**
 * User: janlu.sword@gmail.com
 * Time: 12-11-11 下午2:08
 */
@Service("PostsService")
public class PostsService extends BasicService<Posts> implements IPostsService {
	@Resource(name="PostsDao")
    public void setBasicDao(IBasicDao<Posts> basicDao){
        this.basicDao=basicDao;
    }
	
}
