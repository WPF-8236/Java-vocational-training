package com.wpf.jsp.filter;

import com.wpf.jsp.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String path = request.getRequestURI();
		if ("/".equals(path) || "/index.jsp".equals(path) || "/doLoginServlet.jsp".equals(path)) {
			filterChain.doFilter(request, response);
		} else {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				filterChain.doFilter(request, response);
			} else {
				response.sendRedirect("/");
			}
		}

	}
}
