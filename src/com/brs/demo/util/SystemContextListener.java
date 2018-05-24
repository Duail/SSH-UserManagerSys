package com.brs.demo.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class SystemContextListener implements ServletContextListener {

	private static ServletContext servletContext;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		SystemContextListener.servletContext = null;
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		SystemContextListener.servletContext = event.getServletContext();
		servletContext.setAttribute("rootPath", servletContext.getContextPath());
	}

	public static ServletContext getContext() {
		return servletContext;
	}
}
