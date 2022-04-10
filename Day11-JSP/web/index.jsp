<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>主页</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <table border="1" width="100%" height="100%">
            <tr>
                <td colspan="2" bgcolor="#99cc66" height="90"></td>
            </tr>
            <tr>
                <td width="190" align="center" valign="top">
                    <br>
                    <a href="user.jsp" target="page">用户管理</a>
                    <br><br>
                    <a href="category.jsp">类别管理</a>
                    <br><br>
                    <a href="">产品管理</a>
                    <br><br>
                    <a href="progress.jsp" target="page">供应商管理</a>
                    <br><br>
                </td>
                <td>
                    <iframe src="welcome.jsp" width="100%" height="100%" name="page"></iframe>
                </td>
            </tr>
        </table>
    </body>
</html>