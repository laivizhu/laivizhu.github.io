package com.laivi.maptable;

import java.lang.reflect.Field;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.lang.Mirror;

import com.laivi.maptable.annotation.LongText;

public class GenerateMysqlTable implements GenerateTable {

	@Override
	public String generateCreate(Class<?> klass) {
		Table table=klass.getAnnotation(Table.class);
		if(null!=table){
			StringBuffer sql=new StringBuffer("create table "+table.value()+"(");
			Mirror<?> mirror=Mirror.me(klass);
			for(Field field:mirror.getFields()){
				sql.append(gengerateField(field)+",");
			}
			sql=new StringBuffer(sql.substring(0, sql.length()-1));
			sql.append(")");
			return sql.toString();
		}
		
		return null;
	}

	@Override
	public String gengrateUpdate(Class<?> klass) {
		return null;
	}
	
	
	public String gengerateField(Field field){
		String fields=null;
		Id id=field.getAnnotation(Id.class);
		LongText longText=field.getAnnotation(LongText.class);
		if(field.getType().isEnum()){
			fields=field.getName()+" varchar(30) DEFAULT NULL";
		}else if(null!=longText){
			fields=field.getName()+" longtext";
		}else if(null!=id){
			fields=field.getName()+" "+GenerateMySqlColumn.fromType(field.getType().toString()).toColumn()+" NOT NULL AUTO_INCREMENT";
			fields+=",PRIMARY KEY ("+field.getName()+")";
		}else{
			fields=field.getName()+" "+GenerateMySqlColumn.fromType(field.getType().toString()).toColumn()+" default NULL";
		}
		return fields;
	}

}
