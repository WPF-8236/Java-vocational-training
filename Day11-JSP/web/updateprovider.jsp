<%@ page import="com.wpf.jsp.domain.Provider" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    Provider provider = (Provider) request.getAttribute("provider");
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>修改供应商</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <form action="doProviderServlet.jsp" method="post">
            <input type="hidden" name="action" id="action" value="updateProvider">
            <input type="hidden" name="p_id" id="p_id" value="<%=provider.getP_id()%>">
            <table border="1" width="500" align="center">
                <tr>
                    <td colspan="2" bgcolor="#e7e7e7">修改</td>
                </tr>
                <tr>
                    <td>供应商编号</td>
                    <td><input type="text" value="<%=provider.getP_id()%>" disabled/></td>
                </tr>
                <tr>
                    <td>供应商姓名</td>
                    <td><input type="text" name="p_name" id="p_name" value="<%=provider.getP_name()%>"/></td>
                </tr>
                <tr>
                    <td>供应商电话</td>
                    <td><input type="text" name="p_tele" id="p_tele" value="<%=provider.getP_tele()%>"/></td>
                </tr>
                <tr>
                    <td>供应商邮箱</td>
                    <td><input type="text" name="p_email" id="p_email" value="<%=provider.getP_email()%>"/></td>
                </tr>
                <tr>
                    <td>供应商地址</td>
                    <td><input type="text" name="p_address" id="p_address" value="<%=provider.getP_address()%>"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="确定"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>