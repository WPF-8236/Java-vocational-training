<%@ page import="java.util.List" %>
<%@ page import="com.wpf.jsp.domain.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Category> categories = (List<Category>) request.getAttribute("categories");
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
                <td height="40">类别编号</td>
                <td>类编名称</td>
                <td>操作</td>
            </tr>
            <%
                for (Category category : categories) {
            %>
            <tr align="center">
                <td><%=category.getC_id()%>
                </td>
                <td><%=category.getC_name()%>
                </td>
                <td>
                    <a href="doCategoryServlet.jsp?action=getOneCategory&c_id=<%=category.getC_id()%>">修改</a>/
                    <a href="doCategoryServlet.jsp?action=deleteCategory&c_id=<%=category.getC_id()%>" onclick="return confirm('真的要删除吗?');">删除</a>
                </td>
            </tr>
            <%
                }
            %>

        </table>
        <table border="1" width="100%">
            <tr align="center">
                <td>
                    <a href="doCategoryServlet.jsp?action=getCategoriesLimitFirst">首页</a>
                    <a href="doCategoryServlet.jsp?action=getCategoriesLimitUpPage">上一页</a>
                    <a href="doCategoryServlet.jsp?action=getCategoriesLimitDownPage">下一页</a>
                    <a href="doCategoryServlet.jsp?action=getCategoriesLimitEnd">尾页</a>
                </td>
            </tr>
        </table>
    </body>
</html>