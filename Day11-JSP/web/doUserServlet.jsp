<%@ page import="com.wpf.jsp.service.UserService" %>
<%@ page import="com.wpf.jsp.service.impl.UserServiceImpl" %>
<%@ page import="com.wpf.jsp.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String action = request.getParameter("action");
    String path = "index.jsp";
    UserService userService = UserServiceImpl.getUserService();
    if ("login".equals(action)) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if ("admin".equals(userName) && "admin".equals(password))
            path = "admin.jsp";
        response.sendRedirect(path);
    }
    if ("getUserList".equals(action)) {
        List<User> userList = userService.getUsersLimit(5, 1);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
    if ("addUser".equals(action)) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        userService.save(new User(userName, password));
        response.sendRedirect("doUserServlet.jsp?action=getUserList");
    }
    if ("getOneUser".equals(action)) {
        String id = request.getParameter("id");
        User user = userService.getOne(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("updateuser.jsp").forward(request, response);
    }
    if ("updateUser".equals(action)) {
        Integer id = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        userService.change(new User(id, userName, password));
        response.sendRedirect("doUserServlet.jsp?action=getUserList");
    }
    if ("deleteUser".equals(action)) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        userService.delete(new User(id));
        response.sendRedirect("doUserServlet.jsp?action=getUserList");
    }
    if ("getUsersLimitUpPage".equals(action)) {
        List<User> userList = userService.getUsersLimitUpPage();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
    if ("getUsersLimitDownPage".equals(action)) {
        List<User> userList = userService.getUsersLimitDownPage();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
    if ("getUsersLimitFirst".equals(action)) {
        List<User> userList = userService.getUsersLimitFirst();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
    if ("getUsersLimitEnd".equals(action)) {
        List<User> userList = userService.getUsersLimitEnd();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
%>