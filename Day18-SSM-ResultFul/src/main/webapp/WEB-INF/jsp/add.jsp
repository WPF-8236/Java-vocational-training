<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/add" method="post">
    <table border="1" align="center" width="500">
        <tr bgcolor="#f0ffff">
            <td height="30">编号</td>
            <td><input type="text" name="userId"></td>
        </tr>
        <tr>
            <td>userName</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="确定"></td>
        </tr>
    </table>

</form>
</body>
</html>
