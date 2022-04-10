<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>供应商界面</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <fieldset id="note">
            <legend>公告信息</legend>
            <div id="note">
                hello，天气炎热注意避暑
                Warren，疫情危险请带好口罩
            </div>
        </fieldset>
        <a href="addprogress.jsp">添加</a>
        <table border="1" width="100%">
            <tr align="center" bgcolor="#e7e7e7">
                <td height="40">供应商id</td>
                <td>供应商姓名</td>
                <td>供应商电话</td>
                <td>供应商邮箱</td>
                <td>供应商地址</td>
                <td>操作</td>
            </tr>
            <tr align="center">
                <td>1</td>
                <td>王潘锋</td>
                <td>123456789</td>
                <td>123456789@qq.com</td>
                <td>天眼</td>
                <td>
                    <a href="updateprogress.jsp">修改</a>/
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