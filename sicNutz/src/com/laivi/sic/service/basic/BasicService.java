package com.laivi.sic.service.basic;

import org.nutz.dao.Dao;

import com.laivi.sic.model.po.basic.IBasicDBEntity;

public class BasicService<T extends IBasicDBEntity> extends BasicDBService<T> {

	public BasicService(Dao dao) {
		super(dao);
	}

}
