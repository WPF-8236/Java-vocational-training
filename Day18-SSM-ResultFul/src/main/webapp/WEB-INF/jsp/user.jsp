<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="resources/js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function () {
           $.ajax({
               url:'displayUser',
               type:'get',
               dataType:'json',
               success:function (result) {
                   createTableData(result);

               }
           });
           //给添加按钮加事件，并实现添加
           $('#add').click(function () {
               $.ajax({
                   url:'addUser1',
                   type:'post',
                   data:$('#frm').serialize(),
                   success:function (result) {
                       createTableData(result);
                   }
               });
           });
        });
        //向表中填写数据的方法
        function createTableData(result) {
            var row_='';
            for (var i = 0; i < result.length; i++) {
                row_+='<tr><td>'+result[i].userId+'</td><td>'+result[i].userName+'</td><td>'+result[i].password+'</td><td>删除/修改</td></tr>';
            }
            //拼接内容加入表中
            $('#content').html(row_);
        }
        //添加

        //修改

        //删除
    </script>
</head>
<body>

<table border="1" align="center" style="width: 600px;border: 1px solid silver; border-collapse: collapse;text-align: center">
    <thead>
        <tr bgcolor="#e6e6fa">
            <td height="40">编号</td>
            <td>名</td>
            <td>密</td>
            <td>action</td>
        </tr>
    </thead>
    <tbody id="content">
    </tbody>
</table>
<form action="${pageContext.servletContext.contextPath}/" id="frm" method="post">
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
            <td><input type="button" value="确定" id="add"></td>
        </tr>
    </table>
</form>
</body>
</html>

