<%@ page import="java.util.List" %>
<%@ page import="com.wpf.jsp.domain.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>计算器</title>
    </head>
    <script type="text/javascript">
        function computer(value) {
            var form = document.getElementById("computerForm");
            var op = document.getElementById("op");
            op.value = value;
            form.submit();
        }
    </script>
    <body>
        <form id="computerForm" action="doComputer" method="post">
            <table>
                <tr>
                    <td>数据1：</td>
                    <td><input type="text" id="num1" name="num1"></td>
                </tr>
                <tr>
                    <td>数据2：</td>
                    <td><input type="text" id="num2" name="num2"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="hidden" id="op" name="op" value="">
                        <input type="button" value="+" onclick="computer(value)">
                        <input type="button" value="-" onclick="computer(value)">
                        <input type="button" value="*" onclick="computer(value)">
                        <input type="button" value="/" onclick="computer(value)">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        ${num3}
                        ${sessionScope.num}
                        ${sessionScope.clear()}
                        ${sessionScope.remove("num")}
                    </td>
                </tr>
            </table>
        </form>
        <a href="doOther">doOther</a>
        <%
            List<User> userList = (List<User>) request.getServletContext().getAttribute("users");
            for (User user : userList) {
        %>
        <tr align="center">
            <td><%=user.getId()%>
            </td>
            <td><%=user.getUserName()%>
            </td>
            <td><%=user.getPassword()%>
            </td>
        </tr>
        <%
            }
        %>
    </body>
</html>