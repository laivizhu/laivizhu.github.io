var ioc={
	dataSource:{
		type:"com.alibaba.druid.pool.DruidDataSource",
		fields:{
			driverClassName:'com.mysql.jdbc.Driver',
			url:'jdbc:mysql://localhost:3306/sicnutz',
			username:'root',
			password:'123456'
		},
		events:{
			depose:'close'
		}
	},
	dao:{
		type:"org.nutz.dao.impl.NutDao",
		args:[{refer:"dataSource"}]
	},
	basicService:{
		type:'com.laivi.sic.service.basic.BasicService',
		args:[{refer:"dao"}]
	}
};