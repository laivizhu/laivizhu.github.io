package com.laivi.sic.action.interceptor;

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


/**
 * Copyright Envision
 *
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-12-9
 */
public class LoginCheckFilter implements Filter {

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;  
		String currentUrl = req.getRequestURI();
		String path=req.getContextPath();
		if(currentUrl.indexOf(".jsp")!=-1 ||currentUrl.indexOf(".html")!=-1){
			HttpSession session = req.getSession();
			if(currentUrl.indexOf("login.html")==-1){
				if(session==null || session.getAttribute("user")==null){
					session.setAttribute("beforeLoginUrl", currentUrl);
					res.sendRedirect(path+"/login.html");
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
