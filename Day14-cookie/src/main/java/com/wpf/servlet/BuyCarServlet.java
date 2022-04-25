package com.wpf.servlet;

import com.wpf.domain.Book;
import com.wpf.listener.MySessionListener;
import com.wpf.util.WebUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuyCarServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("addBook".equals(action)) {
			addBook(request, response);
		}
		if ("getBook".equals(action)) {
			getBook(request, response);
		}
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1,当前session中取buycart
		List<Book> bookCarList = (List<Book>) request.getSession().getAttribute("bookCarList");
		//2,如果当前session中没有，怎么办？
		if (bookCarList == null) {
			//去过去的session中取，要注意,购物车的cookie中的name为buycart
			//根据name，去cookie中去取sessionid
			String sessionId = WebUtil.getCookieValueByName(request, "bookCarListId");
			if (sessionId != null) {
				HttpSession session = MySessionListener.getSessionId(sessionId);
				if (session != null) {
					bookCarList = (List<Book>) session.getAttribute("bookCarList");
					if (bookCarList != null) {
						//这里可以把过去的session从map中删除掉
						MySessionListener.removeSession(sessionId);
					}
				}
			}
		}
		//3,过去有，或没有，程序到达到这里。
		if (bookCarList == null) {  //如果是这个条件，表示你真的是第一次来
			bookCarList = new ArrayList<Book>();
		}

		//4,将加入购物车的书，加入到集合中
		//拿到加入购物车的书
		String b_id = request.getParameter("b_id");
		String b_name = request.getParameter("b_name");
		String b_price = request.getParameter("b_price");
		String b_author = request.getParameter("b_author");
		String b_publishing = request.getParameter("b_publishing");
		String b_image = request.getParameter("b_image");

		Book book = new Book(b_id, b_name, b_price, b_author, b_publishing, b_image);
		//将书加入到集合中
		bookCarList.add(book);
		//
		request.getSession().setAttribute("bookCarList", bookCarList);
		WebUtil.addCookie(response, "bookCarListId", request.getSession().getId(), request.getSession().getMaxInactiveInterval());
		response.sendRedirect("index.jsp");
	}

	private void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> bookCarList = (List<Book>) request.getSession().getAttribute("bookCarList");
		if (bookCarList == null) {
			//去过去的session中取，要注意,购物车的cookie中的name为buycart
			//根据name，去cookie中去取sessionid
			String sessionId = WebUtil.getCookieValueByName(request, "bookCarListId");
			if (sessionId != null) {
				HttpSession session = MySessionListener.getSessionId(sessionId);
				if (session != null) {
					bookCarList = (List<Book>) session.getAttribute("bookCarList");
					request.getSession().setAttribute("bookCarList", bookCarList);
					response.sendRedirect("index.jsp");
				}
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}