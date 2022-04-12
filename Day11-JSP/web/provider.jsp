<%@ page import="java.util.List" %>
<%@ page import="com.wpf.jsp.domain.Provider" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Provider> providers = (List<Provider>) request.getAttribute("providers");
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>供应商界面</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <fieldset id="progressnote">
            <legend>公告信息</legend>
            <div id="note">
                hello，天气炎热注意避暑
                Warren，疫情危险请带好口罩
            </div>
        </fieldset>
        <a href="addprovider.jsp">添加</a>
        <table border="1" width="100%">
            <tr align="center" bgcolor="#e7e7e7">
                <td height="40">供应商编号</td>
                <td>供应商姓名</td>
                <td>供应商电话</td>
                <td>供应商邮箱</td>
                <td>供应商地址</td>
                <td>操作</td>
            </tr>
            <%
                for (Provider provider : providers) {
            %>
            <tr align="center">
                <td><%=provider.getP_id()%>
                </td>
                <td><%=provider.getP_name()%>
                </td>
                <td><%=provider.getP_tele()%>
                </td>
                <td><%=provider.getP_email()%>
                </td>
                <td><%=provider.getP_address()%>
                </td>
                <td>
                    <a href="doProviderServlet.jsp?action=getOneProvider&p_id=<%=provider.getP_id()%>">修改</a>/
                    <a href="doProviderServlet.jsp?action=deleteProvider&p_id=<%=provider.getP_id()%>"
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
                    <a href="doProviderServlet.jsp?action=getProvidersLimitFirst">首页</a>
                    <a href="doProviderServlet.jsp?action=getProvidersLimitUpPage">上一页</a>
                    <a href="doProviderServlet.jsp?action=getProvidersLimitDownPage">下一页</a>
                    <a href="doProviderServlet.jsp?action=getProvidersLimitEnd">尾页</a>
                </td>
            </tr>
        </table>
    </body>
</html>