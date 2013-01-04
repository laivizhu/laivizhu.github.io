package com.laivi.knowledge.basic.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

}
