package com.laivi.sic.action.interceptor;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.interceptor.AbstractMethodInterceptor;
import org.nutz.lang.Stopwatch;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.laivi.sic.model.to.Response;

public class MyInterceptor extends AbstractMethodInterceptor {
	//private static final String DEFAULT_ERROR_MESSAGE = "系统繁忙，请稍后再试";  
	private static Log LOG = Logs.getLog(MyInterceptor.class);
	
	private Cache cache;
	@Override
	public void filter(InterceptorChain chain) throws Throwable {
		try{
			if (beforeInvoke(chain.getCallingObj(), chain.getCallingMethod(), chain.getArgs())){
				Object obj = cache.get(createKey(chain));
				if (obj != null) {
					chain.setReturnValue(obj);
					return;
				}
				Stopwatch stopwatch = Stopwatch.begin();
				chain.doChain();
				stopwatch.stop();
				LOG.debugf("ExecutionTime %dms in %s",stopwatch.getDuration(),chain.getCallingMethod());
			}
               
            Object obj = afterInvoke(chain.getCallingObj(),chain.getReturn(),chain.getCallingMethod(),chain.getArgs());
            chain.setReturnValue(obj);
		}catch(Exception e){
			Response response=null;
			if (whenError(e, chain.getCallingObj(), chain.getCallingMethod(), chain.getArgs())){
				/*if(e instanceof ErrorException){
					response=new Response(false, e.getMessage());
				}else{
					response=new Response(false, e.getMessage());
				}*/
				throw e;
			}
			chain.setReturnValue(response);
		}catch (Throwable e) {
            if (whenError(e, chain.getCallingObj(), chain.getCallingMethod(), chain.getArgs()))
                throw e;
        }
	}
	
	@SuppressWarnings("deprecation")
	public void setCacheManager(CacheManager cacheManager) {
		cacheManager.addCache(MyInterceptor.class.getName());
		cache = cacheManager.getCache(MyInterceptor.class.getName());
		cache.getCacheConfiguration().setDiskPersistent(false);
	}
	
	private static final String createKey(InterceptorChain chain) {
		StringBuilder sb = new StringBuilder();
		sb.append(chain.getCallingObj().getClass()).append("_").append(chain.getCallingMethod());
		return sb.toString();
	}
}
