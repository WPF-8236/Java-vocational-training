<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>登录</title>
    </head>
    <body>
        <form action="doUserServlet.jsp">
            <input type="hidden" name="action" id="action" value="login">
            <table border="1" width="500" align="center">
                <tr>
                    <td>userName</td>
                    <td><input type="text" name="userName" id="userName"/></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="password" name="password" id="password"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="确定"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>