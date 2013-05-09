package com.laivi.sic.action.basic;

import java.lang.reflect.Field;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.laivi.sic.model.exception.ErrorException;
import com.laivi.sic.model.json.JsonItem;
import com.laivi.sic.model.json.JsonList;
import com.laivi.sic.model.po.basic.IBasicDBEntity;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.model.type.IMOType;
import com.laivi.sic.util.basic.DataUtil;


public abstract class ABasicDBAction<T extends IBasicDBEntity> extends ABasicAction implements IBasicDBAction<T> {
	protected static final Log log=Logs.get();
	
	@Inject
	protected Dao dao;
	
	protected Condition cnd=null;

	@Override
	@At
	public Response delete(long id)throws Exception{
		dao.delete(this.getEntityClass(), id);
		return success();
	}

	@Override
	@At
	public Response deletes(String ids) throws Exception {
		dao.clear(this.getEntityClass(), Cnd.wrap("id in ("+ids+")"));
		return success();
	}


	@Override
	@At
	public Object list(@Param("::page.")Pager page) throws Exception {
		if(cnd==null){
			Cnd condition=this.getUserCnd();
			if(condition!=null){
				cnd=condition.desc("createDate");
			}else{
				cnd=Cnd.orderBy().asc("createDate");
			}
		}
		return list(page,cnd);
	}
	
	protected JsonList list(Pager page,Condition cnd){
		JsonList jsonList=new JsonList();
		for(T obj:dao.query(this.getEntityClass(), cnd, page)){
			jsonList.add(this.dataJson(obj,true));
		}
		jsonList.setSize();
		return jsonList;
	}
	
	protected Object dataJson(T obj,boolean fold){
		JsonItem item=this.getJsonItem(obj,fold);
		if(item==null){
			return obj;
		}else{
			return item;
		}
	}

	@Override
	@At
	public Object get(long id,boolean fold) throws Exception {
		return this.getJsonItem(dao.fetch(this.getEntityClass(), id), fold).toJsonForm();
	}
	

	@Override
	public JsonItem getJsonItem(T obj,boolean fold) {
		JsonItem item=new JsonItem();
		Field[] fields=DataUtil.appendArray(this.getEntityClass().getSuperclass().getDeclaredFields(), this.getEntityClass().getSuperclass().getSuperclass().getDeclaredFields());
		for(Field field:DataUtil.appendArray(this.getEntityClass().getDeclaredFields(), fields)){
			boolean accessFlag = field.isAccessible();
			field.setAccessible(true);
			String fieldName=field.getName();
			try {
				if(fieldName.indexOf("Id")!=-1){
					IMOType imo=IMOType.fromId(fieldName);
					item.add(fieldName.replaceAll("Id",""), dao.fetch(imo.getKlass(), (Long)field.get(obj)));
				}else if(fold &&"content".equals(field.getName())){
					item.add(field.getName(),DataUtil.getDefaultChar((String)field.get(obj)));
				}else{
					item.add(field.getName(),field.get(obj));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ErrorException e) {
				e.printStackTrace();
			}finally{
				field.setAccessible(accessFlag);
			}
		}
		return item;
	}
	
	
}
