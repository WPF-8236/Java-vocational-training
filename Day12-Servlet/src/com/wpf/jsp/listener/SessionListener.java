package com.wpf.jsp.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("attributeAdded");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("attributeRemoved");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("attributeReplaced");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed");
	}
}
