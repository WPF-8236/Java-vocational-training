<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>添加产品</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <form action="user.html" method="post">
            <table border="1" width="500" align="center">
                <tr>
                    <td colspan="2" bgcolor="#e7e7e7">添加</td>
                </tr>
                <tr>
                    <td>产品id</td>
                    <td><input type="text" name="pt_id" id="pt_id" /></td>
                </tr>
                <tr>
                    <td>产品名</td>
                    <td><input type="text" name="pt_name" id="pt_name" /></td>
                </tr>
                <tr>
                    <td>产品价格</td>
                    <td><input type="text" name="pt_price" id="pt_price" /></td>
                </tr>
                <tr>
                    <td>类别id</td>
                    <td><input type="text" name="pt_c_id" id="pt_c_id" /></td>
                </tr>
                <tr>
                    <td>供应商id</td>
                    <td><input type="text" name="pt_p_id" id="pt_p_id" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="确定" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>