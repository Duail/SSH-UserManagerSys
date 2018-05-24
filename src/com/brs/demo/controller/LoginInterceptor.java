package com.brs.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("after!!");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("post!!");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("pre!!");
		StringBuffer url = request.getRequestURL();
		System.out.println(url.indexOf("login"));
		System.out.println(url.indexOf("managerLogin"));
		if (url.indexOf("login") >= 0) {
			return true;
		}
		if (url.indexOf("managerLogin") >= 0) {
			return true;
		}
		if (url.indexOf("checkManager") >= 0) {
			return true;
		}
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("manager");
		if (username != null){
			return true;
		}
		response.sendRedirect("login");
		return false;
	}
	
	

}
