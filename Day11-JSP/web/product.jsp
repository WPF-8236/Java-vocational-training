<%@ page import="java.util.List" %>
<%@ page import="com.wpf.jsp.domain.Product" %>
<%@ page import="com.wpf.jsp.domain.Provider" %>
<%@ page import="com.wpf.jsp.domain.Category" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Product> products = (List<Product>) request.getAttribute("products");
    List<Provider> providers = (List<Provider>) request.getAttribute("providers");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
<html>
    <head>
        <meta charset="utf-8">
        <title>产品界面</title>
        <base href="<%=basePath%>">
    </head>
    <body>
        <fieldset id="productnote">
            <legend>公告信息</legend>
            <div id="note">
                hello，天气炎热注意避暑
                Warren，疫情危险请带好口罩
                error，疫情危险请带好口罩
            </div>
        </fieldset>
        <a href="doProductServlet.jsp?action=getPCId">添加</a>
        <table border="1" width="100%">
            <tr align="center" bgcolor="#e7e7e7">
                <td height="40">产品编号</td>
                <td>产品名</td>
                <td>产品价格</td>
                <td>类别编号</td>
                <td>供应商编号</td>
                <td>操作</td>
            </tr>
            <%
                for (Product product : products) {
            %>
            <tr align="center">
                <td><%=product.getPt_id()%>
                </td>
                <td><%=product.getPt_name()%>
                </td>
                <td><%=product.getPt_price()%>
                </td>
                <td>
                    <%
                        for (Category category : categories) {
                            if (product.getPt_c_id() == category.getC_id()) {
                    %>
                    <%=category.getC_name()%>
                    <%
                                break;
                            }
                        }
                    %>
                </td>
                <td>
                    <%
                        for (Provider provider : providers) {
                            if (product.getPt_p_id() == provider.getP_id()) {
                    %>
                    <%=provider.getP_name()%>
                    <%
                                break;
                            }
                        }
                    %>
                </td>
                <td>
                    <a href="doProductServlet.jsp?action=getOneProduct&pt_id=<%=product.getPt_id()%>">修改</a>/
                    <a href="doProductServlet.jsp?action=deleteProduct&pt_id=<%=product.getPt_id()%>"
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
                    <a href="doProductServlet.jsp?action=getProductsLimitFirst">首页</a>
                    <a href="doProductServlet.jsp?action=getProductsLimitUpPage">上一页</a>
                    <a href="doProductServlet.jsp?action=getProductsLimitDownPage">下一页</a>
                    <a href="doProductServlet.jsp?action=getProductsLimitEnd">尾页</a>
                </td>
            </tr>
        </table>
    </body>
</html>