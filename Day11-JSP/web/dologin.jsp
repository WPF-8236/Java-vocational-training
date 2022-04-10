<%@ page import="com.wpf.jsp.domain.User" %>
<%@ page import="com.wpf.jsp.service.UserService" %>
<%@ page import="com.wpf.jsp.service.impl.UserServiceImpl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";


    String action = "login.jsp";
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    User user = new User(userName, password);
    UserService userService = new UserServiceImpl();
    User user1 = userService.getUserByUser(user);
    if (user1.getUserName() != null)
        action = "hello.jsp";

    response.sendRedirect(action);
%>