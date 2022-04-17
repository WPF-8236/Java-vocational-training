package com.wpf.jsp.listener;

import com.wpf.jsp.domain.User;
import com.wpf.jsp.service.UserService;
import com.wpf.jsp.service.impl.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class UserListListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		UserService userService = UserServiceImpl.getUserService();
		List<User> users = userService.get();
		sce.getServletContext().setAttribute("users", users);
	}
}
