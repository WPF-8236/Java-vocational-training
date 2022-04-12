<%@ page import="com.wpf.jsp.domain.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    Category category = (Category) request.getAttribute("category");
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>修改类别</title>
    </head>
    <body>
        <form action="doCategoryServlet.jsp" method="post">
            <input type="hidden" name="action" id="action" value="updateCategory">
            <input type="hidden" name="c_id" id="c_id" value="<%=category.getC_id()%>">
            <table border="1" width="500" align="center">
                <tr>
                    <td colspan="2" bgcolor="#e7e7e7">修改</td>
                </tr>
                <tr>
                    <td>类别编号</td>
                    <td><input type="text" value="<%=category.getC_id()%>" disabled/></td>
                </tr>
                <tr>
                    <td>类别名称</td>
                    <td><input type="text" name="c_name" id="c_name" value="<%=category.getC_name()%>"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="确定"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>