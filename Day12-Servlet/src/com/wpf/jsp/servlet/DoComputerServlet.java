package com.wpf.jsp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DoComputerServlet extends HttpServlet {
	//服务方法
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	//服务方法
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPostInit");
		Double num1 = Double.parseDouble(request.getParameter("num1"));
		Double num2 = Double.parseDouble(request.getParameter("num2"));
		String op = request.getParameter("op");
		Double num3 = null;
		if ("+".equals(op)) {
			num3 = num1 + num2;
		} else if ("-".equals(op)) {
			num3 = num1 - num2;

		} else if ("*".equals(op)) {
			num3 = num1 * num2;

		} else {
			if (num2 != 0)
				num3 = num1 / num2;
		}
		request.setAttribute("num3", num3);
		request.getSession().setAttribute("num", num3);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	//摧毁方法
	@Override
	public void destroy() {
		System.out.println("DoComputerServletDestroy");
	}

	//初始方法
	@Override
	public void init() throws ServletException {
		String encoding = this.getInitParameter("encoding");
		System.out.println("DoComputerServletInit————encoding" + encoding);

		String comm = this.getServletContext().getInitParameter("comm");
		System.out.println("DoComputerServletInit————comm" + comm);
	}

	//构造方法
	public DoComputerServlet() {
		System.out.println("DoComputerServletConstructor");
	}
}
