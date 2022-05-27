<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
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
        <link rel="stylesheet" type="text/css" href="u_css/index.css"/>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="lib-master/index.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            function getBookList() {
                $.ajax({
                    url: "book/getBookList",
                    contentType: 'application/json;charset=UTF-8',
                    type: 'get',
                    success: function (reps) {
                        console.log(reps)
                        app.bookList = reps;
                    },
                    error: function () {
                        alert('图书列表获取失败');
                    }
                })
            }

            function removeBookByBookNo(book_no) {
                console.log(book_no)
                $.ajax({
                    url: "book/removeBookByBookNo/" + book_no,
                    contentType: 'application/json;charset=UTF-8',
                    type: 'delete',
                    dataType: 'text',
                    success: function (reps) {
                        alert(reps.valueOf());
                        getBookList();
                        app.itemKey = Math.random();
                    },
                    error: function () {
                        alert("失败");
                    }

                })
            }

            function addBook() {
                console.log(app.book)
                $.ajax({
                    url: "book/addBook",
                    contentType: 'application/json;charset=UTF-8',
                    type: 'post',
                    dataType: 'text',
                    data: JSON.stringify(app.book),
                    success: function (reps) {
                        app.drawer = false;
                        app.book = '';
                        alert(reps.valueOf());
                        getBookList();
                        app.itemKey = Math.random();
                    },
                    error: function () {
                        alert("失败");
                    }

                })
            }

            function changeBook() {
                console.log(app.book)
                $.ajax({
                    url: "book/changeBook",
                    contentType: 'application/json;charset=UTF-8',
                    type: 'put',
                    dataType: 'text',
                    data: JSON.stringify(app.book),
                    success: function (reps) {
                        app.drawer1 = false;
                        app.book = '';
                        alert(reps.valueOf());
                        getBookList();
                        app.itemKey = Math.random();
                    },
                    error: function () {
                        alert("失败");
                    }

                })
            }
        </script>
        <title></title>
    </head>
    <body>
        <div id="app">
            <div id="booklist">
                <div style="text-align: center">
                    <el-button type="primary" @click="app.drawer=true">添加图书</el-button>
                </div>
                <el-drawer
                        title="添加图书"
                        :visible.sync="drawer"
                        :direction="direction">
                    <div style="padding: 16px">
                        <el-form ref="book" :model="book" label-width="100px">
                            <el-form-item label="书号">
                                <el-input v-model="book.book_no"></el-input>
                            </el-form-item>
                            <el-form-item label="分类">
                                <el-select v-model="book.sort_no" placeholder="请选择分类">
                                    <el-option label="TP298" value="TP298"></el-option>
                                    <el-option label="TP315" value="TP315"></el-option>
                                    <el-option label="TP341" value="TP341"></el-option>
                                    <el-option label="TP321" value="TP321"></el-option>
                                    <el-option label="H31" value="H31"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="书名">
                                <el-input v-model="book.title"></el-input>
                            </el-form-item>
                            <el-form-item label="作者">
                                <el-input v-model="book.author"></el-input>
                            </el-form-item>
                            <el-form-item label="价格">
                                <el-input v-model="book.price"></el-input>
                            </el-form-item>
                            <el-form-item label="书架位置">
                                <el-input v-model="book.lo_no"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="addBook">立即创建</el-button>
                            </el-form-item>
                        </el-form>
                    </div>
                </el-drawer>
                <el-table
                        :data="bookList"
                        style="width: 100%"
                        :key="itemKey">
                    <el-table-column
                            prop="book_no"
                            label="书号"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="sort_no"
                            label="分类"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="title"
                            label="书名"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="author"
                            label="作者"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="price"
                            label="价格"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="lo_no"
                            label="书架位置"
                            width="180">
                    </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button
                                    size="mini"
                                    @click="app.drawer1=true;app.book=scope.row">编辑
                            </el-button>
                            <el-button
                                    size="mini"
                                    type="danger"
                                    @click="removeBookByBookNo(scope.row.book_no)">删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-drawer
                        title="修改图书"
                        :visible.sync="drawer1"
                        :direction="direction">
                    <div style="padding: 16px">
                        <el-form ref="book" :model="book" label-width="100px">
                            <el-form-item label="书号">
                                <el-input v-model="book.book_no" disabled></el-input>
                            </el-form-item>
                            <el-form-item label="分类">
                                <el-select v-model="book.sort_no" placeholder="请选择分类">
                                    <el-option label="TP298" value="TP298"></el-option>
                                    <el-option label="TP315" value="TP315"></el-option>
                                    <el-option label="TP341" value="TP341"></el-option>
                                    <el-option label="TP321" value="TP321"></el-option>
                                    <el-option label="H31" value="H31"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="书名">
                                <el-input v-model="book.title"></el-input>
                            </el-form-item>
                            <el-form-item label="作者">
                                <el-input v-model="book.author"></el-input>
                            </el-form-item>
                            <el-form-item label="价格">
                                <el-input v-model="book.price"></el-input>
                            </el-form-item>
                            <el-form-item label="书架位置">
                                <el-input v-model="book.lo_no"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="changeBook">修改</el-button>
                            </el-form-item>
                        </el-form>
                    </div>
                </el-drawer>
            </div>
        </div>

        <script type="text/javascript">
            var app = new Vue({
                el: '#app',
                data() {
                    return {
                        bookList: [{
                            book_no: '',
                            sort_no: '',
                            title: '',
                            author: '',
                            price: '',
                            lo_no: '',
                        },],
                        book: {
                            book_no: '',
                            sort_no: '',
                            title: '',
                            author: '',
                            price: '',
                            lo_no: '',
                        },
                        itemKey: 1,
                        drawer: false,
                        drawer1: false,
                        direction: 'rtl',
                    };
                },
                filters: {
                    dateFilter(value) {
                        var date = new Date(value);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
                        Y = date.getFullYear() + '-';
                        M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
                        D = date.getDate() + ' ';
                        return Y + M + D;
                    },

                },
                methods: {},
                created: function () {
                    getBookList();
                }
            })
        </script>
    </body>
</html>