package com.laivi.maptable;

import java.lang.reflect.Field;

import org.nutz.dao.entity.annotation.Table;
import org.nutz.lang.Mirror;

public class GenerateMysqlTable implements GenerateTable {

	@Override
	public String generateCreate(Class<?> klass) {
		Table table=klass.getAnnotation(Table.class);
		if(null!=table){
			String sql="create table "+table.value()+"{";
			Mirror<?> mirror=Mirror.me(klass);
			for(Field field:mirror.getFields()){
				
			}
		}
		
		return null;
	}

	@Override
	public String gengrateUpdate(Class<?> klass) {
		return null;
	}
	
	
	public String gengerateField(Field field){
		String fields=null;
		if("class java.lang.String".equals(field.getType())){
			fields=field.getName()+" varchar(255) default NULL";
		}else if("long".equals(field.getType())){
			fields=field.getName()+" bigint(64) default NULL";
		}else if("boolean".equals(field.getType())){
			fields=field.getName()+" tinyint(1) DEFAULT NULL";
		}
		return fields;
	}

}
