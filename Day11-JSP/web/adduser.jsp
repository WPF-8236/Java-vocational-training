<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>添加用户</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <form action="user.html" method="post">
            <table border="1" width="500" align="center">
                <tr>
                    <td colspan="2" bgcolor="#e7e7e7">添加</td>
                </tr>
                <tr>
                    <td>userId</td>
                    <td><input type="text" name="userId" id="userId"/></td>
                </tr>
                <tr>
                    <td>userName</td>
                    <td><input type="text" name="userName" id="userName"/></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="text" name="password" id="password"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="确定"/></td>
                </tr>
            </table>

        </form>
    </body>
</html>