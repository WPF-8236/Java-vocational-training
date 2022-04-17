<%@ page import="com.wpf.jsp.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: jiou_
  Date: 22/4/14
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = "index.jsp";
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    if ("admin".equals(userName) && "admin".equals(password)) {
        path = "admin.jsp";
        session.setAttribute("user", new User("admin", "admin"));
    }
    response.sendRedirect(path);
%>
