
package com.laivi.knowledge.basic.interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Restrictions;

import com.laivi.knowledge.basic.model.annotation.HistoryRecordTag;
import com.laivi.knowledge.basic.model.to.CriterionList;
import com.laivi.knowledge.basic.service.LBasicService;
import com.laivi.knowledge.basic.util.DataUtil;
import com.laivi.knowledge.common.model.po.History;
import com.laivi.knowledge.user.model.po.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Copyright Laivi
 * 
 * @author Laivi.Zhu
 * @version 1.0
 * @Date 2013-1-21
 */
@SuppressWarnings("serial")
public class HistoryRecordInterceptor extends AbstractInterceptor {
	private LBasicService<History> historyService;
	
	@Resource(name="LBasicService")
	public void setHistoryService(LBasicService<History> historyService) {
		this.historyService = historyService;
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String methodName = actionInvocation.getProxy().getMethod();
		Method method = actionInvocation.getAction().getClass().getMethod(methodName);
		HttpServletRequest request=ServletActionContext.getRequest();
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null && !user.isSysUser()){
			if(method!=null){
				if(method.isAnnotationPresent(HistoryRecordTag.class)){
					String currentUrl = request.getRequestURI();
					Map<String,Object> paramterMap=ActionContext.getContext().getParameters();
					String[] ids=(String[])paramterMap.get("id");
					HistoryRecordTag historyTag=method.getAnnotation(HistoryRecordTag.class);
					CriterionList conditions=CriterionList.CreateCriterion()
							.put(Restrictions.eq("userId", user.getId()))
							.put(Restrictions.eq("url", currentUrl)).put(Restrictions.eq("accessId", Long.parseLong(ids[0])));
					History history=this.historyService.getObject(History.class, conditions);
					if(history==null){
						history=new History();
						history.setUserId(user.getId());
						history.setCount(1);
						history.setUrl(currentUrl);
						if(DataUtil.notEmptyString(ids[0])){
							history.setAccessId(Long.parseLong(ids[0]));
						}
						history.setType(historyTag.type());
						this.historyService.add(history);
					}else{
						history.setCount(history.getCount()+1);
						this.historyService.modify(history);
					}
				}
			}
		}
		return actionInvocation.invoke();
	}

}
