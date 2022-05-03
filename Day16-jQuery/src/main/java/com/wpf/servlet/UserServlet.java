package com.wpf.servlet;

import com.alibaba.fastjson.JSON;
import com.wpf.domain.User;
import com.wpf.service.UserService;
import com.wpf.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = UserServiceImpl.getUserService();
		List<User> userList = userService.get();
		String userListStr = JSON.toJSONString(userList);
		PrintWriter writer = response.getWriter();
		writer.write(userListStr);
		writer.flush();
		writer.close();
	}
}
