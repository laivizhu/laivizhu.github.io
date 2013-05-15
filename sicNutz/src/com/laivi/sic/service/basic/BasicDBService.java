package com.laivi.sic.service.basic;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;

import com.laivi.sic.model.po.basic.IBasicDBEntity;

public abstract class BasicDBService extends BasicService implements IBasicDBService {
	@Inject
	protected Dao dao;

	@Override
	public <T extends IBasicDBEntity> long add(T object) {
		dao.insert(object);
		return object.getId();
	}

	@Override
	public <T> void delete(Class<T> klass, long id) {
		dao.delete(klass, id);
	}

	@Override
	public <T> void update(T obj) {
		dao.update(obj);
	}

	@Override
	public <T> T get(Class<T> klass, long id) {
		return dao.fetch(klass, id);
	}

	@Override
	public <T> T get(Class<T> klass, Condition cnd) {
		return dao.fetch(klass, cnd);
	}

	@Override
	public <T> List<T> list(Class<T> klass, Condition cnd, int start, int limit) {
		Pager page=dao.createPager(start, limit);
		return dao.query(klass, cnd, page);
	}

	@Override
	public <T> List<T> list(Class<T> klass, Condition cnd) {
		return dao.query(klass, cnd);
	}

	@Override
	public <T> List<T> list(Class<T> klass) {
		return dao.query(klass, null);
	}

	@Override
	public <T> int getCount(Class<T> klass, Condition cnd) {
		return dao.count(klass, cnd);
	}

	@Override
	public <T> int getCount(Class<T> klass) {
		return dao.count(klass,null);
	}

	@Override
	public <T> List<T> list(Class<T> klass, Condition cnd, Pager page) {
		return dao.query(klass, cnd, page);
	}
}
