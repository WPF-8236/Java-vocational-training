package com.wpf.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String msg = "已经注册，请换个名称再注册";
		if ("admin".equals(userName)) {
			msg = "可以注册";
		}
		PrintWriter writer = response.getWriter();
		writer.write(msg);
		writer.flush();
		writer.close();
	}
}
