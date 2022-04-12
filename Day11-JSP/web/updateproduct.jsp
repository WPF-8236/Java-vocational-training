<%@ page import="com.wpf.jsp.domain.Product" %>
<%@ page import="com.wpf.jsp.domain.Category" %>
<%@ page import="com.wpf.jsp.domain.Provider" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    Product product = (Product) request.getAttribute("product");
    List<Provider> providers = (List<Provider>) request.getAttribute("providers");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>修改产品</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <form action="doProductServlet.jsp" method="post">
            <input type="hidden" name="action" id="action" value="updateProduct">
            <input type="hidden" name="pt_id" id="pt_id" value="<%=product.getPt_id()%>">
            <table border="1" width="500" align="center">
                <tr>
                    <td colspan="2" bgcolor="#e7e7e7">修改</td>
                </tr>
                <tr>
                    <td>产品编号</td>
                    <td><input type="text" value="<%=product.getPt_id()%>" disabled/></td>
                </tr>
                <tr>
                    <td>产品名</td>
                    <td><input type="text" name="pt_name" id="pt_name" value="<%=product.getPt_name()%>"/></td>
                </tr>
                <tr>
                    <td>产品价格</td>
                    <td><input type="text" name="pt_price" id="pt_price" value="<%=product.getPt_price()%>"/></td>
                </tr>
                <tr>
                    <td>类别名称</td>
                    <td><select id="pt_c_id" name="pt_c_id">
                        <%
                            for (Category category : categories) {
                                if (category.getC_id() == product.getPt_c_id())
                                    out.print("<option value='" + category.getC_id() + "'" + " selected" + ">" + category.getC_name() + "</option>");
                                else
                                    out.print("<option value=" + category.getC_id() + ">" + category.getC_name() + "</option>");
                            }
                        %>
                    </select></td>
                </tr>
                <tr>
                    <td>供应商名称</td>
                    <td><select id="pt_p_id" name="pt_p_id">
                        <%
                            for (Provider provider : providers) {
                                if (provider.getP_id() == product.getPt_p_id())
                                    out.print("<option value='" + provider.getP_id() + "'" + " selected" + ">" + provider.getP_name() + "</option>");
                                else
                                    out.print("<option value=" + provider.getP_id() + ">" + provider.getP_name() + "</option>");
                            }
                        %>
                    </select></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="确定"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>