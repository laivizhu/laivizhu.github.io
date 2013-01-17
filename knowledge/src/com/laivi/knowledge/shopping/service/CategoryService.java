package com.laivi.knowledge.shopping.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laivi.knowledge.basic.dao.IBasicDao;
import com.laivi.knowledge.basic.service.BasicService;
import com.laivi.knowledge.shopping.model.po.Category;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date Jan 15, 2013
 */
@Service("CategoryService")
public class CategoryService extends BasicService<Category> implements ICategoryService {

	@Resource(name="CategoryDao")
	public void setBasicDao(IBasicDao<Category> basicDao){
		this.basicDao=basicDao;
	}

}
