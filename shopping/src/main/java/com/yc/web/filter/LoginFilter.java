package com.yc.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.yc.bean.User;


public class LoginFilter implements Filter {

	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest=(HttpServletRequest)request;
		
		//获取会话对象中的登录的用户对象
		User user=(User) httprequest.getSession().getAttribute("logineduser");
		if(user == null){
			/**
			 * 用户未登录，跳转到登录页面
			 */
			request.setAttribute("msg", "请先登录系统！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
