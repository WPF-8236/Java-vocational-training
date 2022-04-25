package com.wpf.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

public class MySessionListener implements HttpSessionListener {
	public static Map<String, HttpSession> sessionMap = new HashMap<>();

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		sessionMap.put(se.getSession().getId(), se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		sessionMap.remove(se.getSession().getId());
	}

	public static final HttpSession getSessionId(String sessionId) {
		return sessionMap.get(sessionId);
	}

	public static final void removeSession(String sessionId) {
		sessionMap.remove(sessionId);
	}
}
