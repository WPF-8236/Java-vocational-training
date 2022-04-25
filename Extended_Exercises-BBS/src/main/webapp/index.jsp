<%@ page import="com.WPF.domain.UserBasic" %>
<%@ page import="com.WPF.domain.UserGrade" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
    UserGrade userGrade = (UserGrade) session.getAttribute("userGrade");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
        <meta charset="utf-8">
        <script src="js/vue.min.js" type="text/javascript" charset="utf-8"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="lib-master/theme-chalk/index.css"/>
        <link rel="stylesheet" type="text/css" href="u_css/footer.css"/>
        <link rel="stylesheet" type="text/css" href="u_css/index.css"/>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="lib-master/index.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">

        </script>
        <title>王潘锋BBS————Java搅屎棍</title>
    </head>
    <body>
        <div class="param" id="u_id">${userBasic.u_id}</div>
        <div id="app">
            <div id="wallper">
                <%
                    if (userBasic == null) {
                %>
                <div id="btn-8" class="btn-s">
                    <span onclick="window.location.href = './Resign.jsp'">注册</span>
                </div>
                <div id="btn-6" class="btn-s">
                    <span onclick="window.location.href = './Login.jsp'">登录</span>
                </div>
                <%
                } else {
                %>
                <div id="btn-7" class="btn-s">
                    <span onclick="window.location.href='./UserCenter.jsp'">你好，${userBasic.u_name}</span>
                </div>
                <div id="btn-6" class="btn-s">
                    <span onclick="window.location.href = './logout.jsp'">登出</span>
                </div>
                <%
                    }
                %>
                <span id="title">王潘锋BBS平台——Java搅屎棍</span>
                <div id="index">

                </div>
            </div>

            <div class="clear"></div>

            <div id="footer">
                <div class="copy-right">
                    <p>&copy; 2022 培训设计 | Design by 王潘锋</p>
                </div>
            </div>
        </div>
        <script type="text/javascript">
        </script>
        <script type="text/javascript">
            var app = new Vue({
                el: '#app',
                data() {
                    return {};
                },
                methods: {},
                created: function () {

                }
            })
        </script>
    </body>
</html>