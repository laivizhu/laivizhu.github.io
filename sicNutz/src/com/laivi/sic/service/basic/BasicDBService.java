package com.laivi.sic.service.basic;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.laivi.sic.model.exception.ErrorException;
import com.laivi.sic.model.po.basic.IBasicDBEntity;

@IocBean
public class BasicDBService extends BasicService implements IBasicDBService {
	@Inject
	protected Dao dao;

	@Override
	public <T extends IBasicDBEntity> long add(T object)throws Exception {
		try{
			dao.insert(object);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
		return object.getId();
	}

	@Override
	public <T> void delete(Class<T> klass, long id)throws Exception {
		try{
			dao.delete(klass, id);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
	}

	@Override
	public <T> void update(T obj)throws Exception {
		try{
			dao.update(obj);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
		
	}

	@Override
	public <T> T get(Class<T> klass, long id)throws Exception {
		try{
			return dao.fetch(klass, id);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
		
	}

	@Override
	public <T> T get(Class<T> klass, Condition cnd)throws Exception {
		try{
			return dao.fetch(klass, cnd);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
		
	}

	@Override
	public <T> List<T> list(Class<T> klass, Condition cnd, int start, int limit)throws Exception {
		try{
			Pager page=dao.createPager(start, limit);
			return dao.query(klass, cnd, page);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
	}

	@Override
	public <T> List<T> list(Class<T> klass, Condition cnd)throws Exception {
		try{
			return dao.query(klass, cnd);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
	}

	@Override
	public <T> List<T> list(Class<T> klass)throws Exception {
		try{
			return dao.query(klass, null);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
	}

	@Override
	public <T> int getCount(Class<T> klass, Condition cnd)throws Exception {
		try{
			return dao.count(klass, cnd);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
	}

	@Override
	public <T> int getCount(Class<T> klass) throws Exception{
		try{
			return dao.count(klass,null);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
	}

	@Override
	public <T> List<T> list(Class<T> klass, Condition cnd, Pager page)throws Exception {
		try{
			return dao.query(klass, cnd, page);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
	}
	
	@Override
	public <T> List<T> list(Class<T> klass,String sql,Pager page)throws Exception{
		try{
			Sql sqlObj=Sqls.create(sql);
			sqlObj.setCallback(Sqls.callback.entities());
			sqlObj.setEntity(dao.getEntity(klass));
			sqlObj.setPager(page);
			dao.execute(sqlObj);
			return sqlObj.getList(klass);
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
	}
	
	@Override
	public <T> int getCount(Class<T> klass,String sql)throws Exception {
		try{
			Sql count=Sqls.fetchInt(sql);
			dao.execute(count);
			return count.getInt();
		}catch(Exception e){
			throw new ErrorException("数据添加失败");
		}
		
	}
}
