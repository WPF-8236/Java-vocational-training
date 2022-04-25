<%@ page import="com.wpf.domain.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Book> bookList = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
        Book book = new Book(i + 1 + "", "name" + i, 100.00 + i + "", "王潘锋", "王潘锋", (i + 1) + ".jpg");
        bookList.add(book);
    }
    request.setAttribute("bookList", bookList);
    List<Book> bookCarList = (List<Book>) request.getSession().getAttribute("bookCarList");
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>图书列表</title>
        <style type="text/css">
            #car {
                width: 300px;
                height: 600px;
                position: absolute;
                right: 30px;
                top: 10px;
            }

            .book {
                width: 300px;
                height: 71px;
                margin-bottom: 10px;
            }

            #book-img {
                width: 50px;
            }
        </style>
        <script type="text/javascript">

        </script>
    </head>
    <body>
        <table align="center">
            <tr>
                <%
                    for (int i = 0; i < bookList.size(); i++) {
                        Book book = bookList.get(i);
                        if (i % 4 == 0) {
                %>
            </tr>
            <tr>
                <%
                    }
                %>
                <td align="center">
                    <table border="1" width="190">
                        <tr>
                            <td><img src="img/<%=book.getB_image()%>" alt=""></td>
                        </tr>
                        <tr>
                            <td><%=book.getB_name()%>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <%=book.getB_price()%>
                                <a href="buyCar?action=addBook&b_id=<%=book.getB_id()%>&b_name=<%=book.getB_name()%>&b_price=<%=book.getB_price()%>&b_author=<%=book.getB_author()%>&b_publishing=<%=book.getB_publishing()%>&b_image=<%=book.getB_image()%>">加入购物车</a>
                            </td>
                        </tr>
                    </table>
                </td>
                <%
                    }
                %>
            </tr>
        </table>
        <div id="bookCarButton">
            <a href="buyCar?action=getBook">购物车</a>
        </div>
        <div id="car">
            <%
                if (bookCarList != null) {
                    for (int i = 0; i < bookCarList.size(); i++) {
                        Book book = bookCarList.get(i);
            %>
            <div class="book">
                <img id="book-img" src="img/<%=book.getB_image()%>">
                <span><%=book.getB_name()%></span>
                <span><%=book.getB_author()%></span>
                <span><%=book.getB_price()%></span>
            </div>
            <%
                    }
                }
            %>
        </div>
    </body>
</html>