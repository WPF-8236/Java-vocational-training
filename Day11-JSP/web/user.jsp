<%@ page import="java.util.List" %>
<%@ page import="com.wpf.jsp.domain.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>用户界面</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <fieldset id="note">
            <legend>公告信息</legend>
            <div id="detail">
                hello，天气炎热注意避暑
            </div>
        </fieldset>
        <a href="adduser.jsp">添加</a>
        <table border="1" width="100%">
            <tr align="center" bgcolor="#e7e7e7">
                <td height="40">id</td>
                <td>userName</td>
                <td>password</td>
                <td>操作</td>
            </tr>
            <%
                List<User> userList = (List<User>) request.getAttribute("userList");
                for (User user : userList) {
            %>
            <tr align="center">
                <td><%=user.getId()%>
                </td>
                <td><%=user.getUserName()%>
                </td>
                <td><%=user.getPassword()%>
                </td>
                <td>
                    <a href="doUserServlet.jsp?action=getOneUser&id=<%=user.getId()%>">修改</a>/
                    <a href="doUserServlet.jsp?action=deleteUser&id=<%=user.getId()%>"
                       onclick="return confirm('真的要删除吗?');">删除</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <table border="1" width="100%">
            <tr align="center">
                <td>
                    <a href="doUserServlet.jsp?action=getUsersLimitFirst">首页</a>
                    <a href="doUserServlet.jsp?action=getUsersLimitUpPage">上一页</a>
                    <a href="doUserServlet.jsp?action=getUsersLimitDownPage">下一页</a>
                    <a href="doUserServlet.jsp?action=getUsersLimitEnd">尾页</a>
                </td>
            </tr>
        </table>
    </body>
</html>