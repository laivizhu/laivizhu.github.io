package com.laivi.maptable;

import org.nutz.dao.entity.annotation.Table;
import org.nutz.lang.Mirror;

public class GenerateMysqlTable implements GenerateTable {

	@Override
	public String generateCreate(Class<?> klass) {
		if(null!=klass.getAnnotation(Table.class)){
			Mirror<?> mirror=Mirror.me(klass);
			
		}
		
		return null;
	}

	@Override
	public String gengrateUpdate(Class<?> klass) {
		return null;
	}

}
