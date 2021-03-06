var ioc = {
	txNONE : {
            type : 'org.nutz.aop.interceptor.TransactionInterceptor',
            args : [0]
    },
    txREAD_UNCOMMITTED : {
            type : 'org.nutz.aop.interceptor.TransactionInterceptor',
            args : [1]
    },
    txREAD_COMMITTED : {
            type : 'org.nutz.aop.interceptor.TransactionInterceptor',
            args : [2]
    },
    txREPEATABLE_READ : {
            type : 'org.nutz.aop.interceptor.TransactionInterceptor',
            args : [4]
    },
    txSERIALIZABLE : {
            type : 'org.nutz.aop.interceptor.TransactionInterceptor',
            args : [8]
    },
    //声明一个log进行日志记录
    log : {
        type :'org.nutz.aop.interceptor.LoggingMethodInterceptor'
    },
    /*缓存管理器,这里使用的是Ehcache*/
	cacheManager : {
		type : 'net.sf.ehcache.CacheManager',
		events : {
        	depose : 'shutdown'
    	}
	},
    myInterceptor:{
    	type:'com.laivi.sic.action.interceptor.MyInterceptor',
    	fields : {
			cacheManager : {refer : "cacheManager"}
		}
    },
    $aop : {
        type : 'org.nutz.ioc.aop.config.impl.ComboAopConfigration',
        fields : {
                aopConfigrations  : [
                        {       type : 'org.nutz.ioc.aop.config.impl.JsonAopConfigration',
                                fields : {
                                itemList : [
                                            ['com\\.laivi\\.sic\\..+','.+','ioc:log'],
                                            ['com\\.laivi\\.sic\\.action\\..+','.+','ioc:myInterceptor'],
                                            ['com\\.laivi\\.sic\\.service\\..+','.+','ioc:txSERIALIZABLE']
                                ]
                                }
                        },
                        {       type : 'org.nutz.ioc.aop.config.impl.AnnotationAopConfigration'}
                ]
        }
    }
};