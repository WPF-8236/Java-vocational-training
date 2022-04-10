<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>添加类别</title>
    </head>
    <body>
        <form action="user.html" method="post">
            <table border="1" width="500" align="center">
                <tr>
                    <td colspan="2" bgcolor="#e7e7e7">添加</td>
                </tr>
                <tr>
                    <td>类别id</td>
                    <td><input type="text" name="c_id" id="c_id" /></td>
                </tr>
                <tr>
                    <td>类别名名</td>
                    <td><input type="text" name="c_name" id="c_name" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="确定" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>