<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="resources/js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function () {
            alert('f');
        });
    </script>
</head>
<body>


<div id="d" style="display: none">
    <form action="${pageContext.servletContext.contextPath}/deleteUser/1" method="get">
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
</div>

</body>
</html>
<script type="text/javascript">
    $(function () {

    });
</script>
