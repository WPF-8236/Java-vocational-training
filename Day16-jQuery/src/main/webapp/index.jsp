<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>Ajax</title>
        <script type="text/javascript">
            var xmlHttp = null;

            function createXMLHttpRequest() {
                if (window.ActiveXObject)
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                else
                    xmlHttp = new XMLHttpRequest();
            }

            function sendGet() {
                createXMLHttpRequest();
                var userName = document.getElementById("userName").value;
                var url = "login?userName=" + userName;
                xmlHttp.open("get", url, true);
                xmlHttp.onreadystatechange = f;
                xmlHttp.send(null);
            }

            function f() {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    document.getElementById("info").innerHTML = xmlHttp.responseText;
                }
            }

            window.onload = function () {
                getUsers();
            }

            function getUsers() {
                createXMLHttpRequest();
                var url = "user";
                //建立连接
                xmlHttp.open("GET", url, true);
                //只要核心对象的readystate状态发生改变，1，2，3，4.就会调用f函数
                xmlHttp.onreadystatechange = ff;// 指定回调函数，
                xmlHttp.send(null);
            }

            function ff() {
                if (xmlHttp.readyState == 4) {  //4如果响应成功
                    if (xmlHttp.status == 200) { //http状态码为200
                        //拿到响应来的字符串
                        var userList = xmlHttp.responseText;
                        //字符串转对象
                        var users = JSON.parse(userList);
                        var tab = '<table border="1" width="500">'
                        for (var i = 0; i < users.length; i++) {
                            tab += '<tr><td>' + users[i].id + '</td><td>' + users[i].userName + '</td><td>' + users[i].password + '</td><td><a href="#" onclick="发送删除请求">删除</a></td></tr>'
                        }
                        tab += '</table>';
                        document.getElementById("d").innerHTML = tab;
                        /*
                        alert(typeof(userList));
                        //转js对象
                        var users=JSON.parse(userList);
                        alert(typeof(users))
                        //转字符串
                        var vv=JSON.stringify(users);
                        alert(typeof(vv));
                        */
                    }
                }
            }
        </script>
    </head>
    <body>
        userName:<input type="text" id="userName" name="userName" onblur="sendGet()"/><span id="info"></span>
        <div id="d"></div>
    </body>
</html>