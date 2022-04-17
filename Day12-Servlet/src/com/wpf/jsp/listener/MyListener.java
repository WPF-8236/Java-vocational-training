package com.wpf.jsp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

public class MyListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<String> strings = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			strings.add("abc" + i);
		}
		System.out.println("context---init---");
		ServletContext application = sce.getServletContext();
		application.setAttribute("strings", strings);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}
}
