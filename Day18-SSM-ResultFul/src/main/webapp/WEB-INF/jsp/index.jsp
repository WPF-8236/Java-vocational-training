<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="resources/js/test.js"></script>
</head>
<body>

<table border="1" align="center" width="600" style="border-collapse: collapse">
    <caption><a href="${pageContext.servletContext.contextPath}/toadd">添加用户</a></caption>
    <tr align="center" bgcolor="#f0ffff">
        <td height="40">编号</td>
        <td>名称</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr align="center">
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/delete?userId=${user.userId}">删除</a>
                <a href="#">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
