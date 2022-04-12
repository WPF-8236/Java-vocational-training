<%@ page import="com.wpf.jsp.domain.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    User user = (User) request.getAttribute("user");
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>修改用户</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <form action="doUserServlet.jsp" method="post">
            <table border="1" width="500" align="center">
                <tr>
                    <td colspan="2" bgcolor="#e7e7e7">修改</td>
                    <input type="hidden" name="action" id="action" value="updateUser">
                    <td><input type="hidden" name="userId" id="userId" value="<%=user.getId()%>"/></td>
                </tr>
                <tr>
                    <td>userId</td>
                    <td><input type="text" value="<%=user.getId()%>" disabled/></td>
                </tr>
                <tr>
                    <td>userName</td>
                    <td><input type="text" name="userName" id="userName" value="<%=user.getUserName()%>"/></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="text" name="password" id="password" value="<%=user.getPassword()%>"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="确定"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>