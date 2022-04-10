<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>类别管理</title>
    </head>
    <body>
        <fieldset id="categoryNote">
            <legend>公告信息</legend>
            <div id="note">
                hello，天气炎热注意避暑
            </div>
        </fieldset>
        <a href="addcategory.jsp">添加</a>
        <table border="1" width="100%">
            <tr align="center" bgcolor="#e7e7e7">
                <td height="40">c_id</td>
                <td>c_name</td>
                <td>操作</td>
            </tr>
            <tr align="center">
                <td>1</td>
                <td>王潘锋</td>
                <td>
                    <a href="updatecategory.jsp">修改</a>/
                    <a href="#" onclick="return confirm('真的要删除吗?');">删除</a>
                </td>
            </tr>
        </table>
        <table border="1" width="100%">
            <tr align="center">
                <td>
                    <a href="#">首页</a>
                    <a href="#">上一页</a>
                    <a href="#">下一页</a>
                    <a href="#">尾页</a>
                </td>
            </tr>
        </table>
    </body>
</html>