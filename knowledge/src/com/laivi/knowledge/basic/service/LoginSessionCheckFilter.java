package com.laivi.knowledge.basic.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laivi.knowledge.user.model.po.User;

/**
 * Copyright Envision
 *
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-12-9
 */
public class LoginSessionCheckFilter implements Filter {

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;  
		String currentUrl = req.getRequestURI();
		String path=req.getContextPath();
		if(currentUrl.indexOf(".jsp")!=-1){
			HttpSession session = req.getSession();
			if(currentUrl.indexOf("admin/")!=-1){
				if(currentUrl.indexOf("login.jsp")==-1){
					if(session==null || session.getAttribute("user")==null){
						session.setAttribute("beforeLoginUrl", currentUrl);
						res.sendRedirect(path+"/admin/login.jsp");
					}else{
						User user=(User)session.getAttribute("user");
						if(!user.isSysUser()){
							session.setAttribute("beforeLoginUrl", currentUrl);
							res.sendRedirect(path+"/admin/login.jsp");
						}
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
