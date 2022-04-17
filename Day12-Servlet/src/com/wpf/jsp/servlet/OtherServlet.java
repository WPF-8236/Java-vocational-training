package com.wpf.jsp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OtherServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

	public OtherServlet() {
		System.out.println("OtherServletConstructor");
	}

	@Override
	public void destroy() {
		System.out.println("OtherServletDestroy");
	}

	@Override
	public void init() throws ServletException {
		String encoding = this.getInitParameter("encoding");
		System.out.println("OtherServletInit————encoding" + encoding);
		String comm = this.getServletContext().getInitParameter("comm");
		System.out.println("OtherServletInit————comm" + comm);
	}
}
