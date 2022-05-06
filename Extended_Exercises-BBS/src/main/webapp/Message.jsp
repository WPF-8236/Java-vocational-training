<%@ page import="com.WPF.domain.UserBasic" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    String p_id = request.getParameter("p_id");
    UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
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
        <link rel="stylesheet" type="text/css" href="u_css/Message.css"/>
        <link rel="stylesheet" type="text/css" href="lib-master/theme-chalk/index.css"/>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="lib-master/index.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            function getPostByPId() {
                $.ajax({
                    url: "message/getPostByPId",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"p_id": JSON.stringify('<%=p_id%>')},
                    success: function (reps) {
                        console.log(reps)
                        app.post = reps;
                    },
                    error: function () {
                        alert("文章获取失败")
                    }
                })
            }

            function changePostPBrowseCount() {
                $.ajax({
                    url: "message/changePostPBrowseCount",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"p_id": JSON.stringify('<%=p_id%>')},
                    success: function (reps) {
                        console.log(reps)
                    },
                    error: function () {
                    }
                })
            }

            function getUserList() {
                $.ajax({
                    url: "admin/getUserList",
                    contentType: 'application/json;charset=UTF-8',
                    success: function (reps) {
                        console.log(reps)
                        app.userList = reps;
                        console.log(app.userList)
                    },
                    error: function () {
                        alert('用户列表获取失败');
                    }
                })
            }

            function putThumbs() {
                console.log(app.post.p_id)
                $.ajax({
                    url: "message/putThumbs",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"p_id": JSON.stringify('<%=p_id%>')},
                    success: function (reps) {
                        console.log(reps)
                    },
                    error: function () {
                    }
                })
            }

            function putAComment() {
                app.addComment.c_comment_u_id = '<%=userBasic.getU_id()%>';
                app.addComment.c_comment_p_id = '<%=p_id%>';
                app.addComment.c_floor = app.commentList.length + 1;
                console.log(app.addComment)
                $.ajax({
                    url: "message/putAComment",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"comment": JSON.stringify(app.addComment)},
                    success: function (reps) {
                        console.log(reps)
                        getCommentList();
                        app.itemKey = Math.random();
                        app.addComment = ''
                    },
                    error: function () {
                    }
                })
            }

            function getCommentList() {
                $.ajax({
                    url: "message/getCommentList",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"p_id": JSON.stringify('<%=p_id%>')},
                    success: function (reps) {
                        console.log(reps)
                        app.commentList = reps;
                        console.log(app.commentList)
                    },
                    error: function () {
                        alert('用户列表获取失败');
                    }
                })
            }
        </script>
    </head>
    <body>
        <div class="param"></div>
        <div id="app">
            <div id="index">
                <el-descriptions :title="post.p_title" direction="vertical" :column="4" border>
                    <el-descriptions-item label="作者">{{p_u_idFormatter(post.p_u_id)}}</el-descriptions-item>
                    <el-descriptions-item label="评论数">{{post.p_comment_count}}</el-descriptions-item>
                    <el-descriptions-item label="点赞数">{{post.p_thumbs_count}}</el-descriptions-item>
                </el-descriptions>
                <div>
                    {{post.p_content}}
                </div>
            </div>
            <div id="foort">
                <el-row :gutter="20">
                    <el-col :span="12">
                        <div>
                            <el-input v-model="addComment.c_content" style="width: 200px"></el-input>
                            <el-button type="primary" @click="putAComment">评论</el-button>
                        </div>
                    </el-col>
                    <el-col :span="12">
                        <div>
                            <el-button type="primary" @click="putThumbs">点赞</el-button>
                        </div>
                    </el-col>
                </el-row>
                <el-table
                        ref="commentList"
                        :data="commentList"
                        :key="itemKey">
                    <el-table-column
                            type="index"
                            width="40">
                    </el-table-column>
                    </el-table-column>
                    <el-table-column
                            prop="c_comment_u_id"
                            label="评论者"
                            width="120"
                            :formatter="c_comment_u_idFormatter">
                    </el-table-column>
                    <el-table-column
                            prop="c_content"
                            label="评论内容"
                            width="110">
                    </el-table-column>
                    <el-table-column
                            prop="c_comment_time"
                            label="评论时间"
                            width="110">
                    </el-table-column>
                </el-table>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        var app = new Vue({
            el: '#app',
            data() {
                return {
                    post: {
                        p_id: '',
                        p_title: '',
                        p_content: '',
                        p_comment_count: '',
                        p_status: '',
                        p_time: '',
                        p_u_id: '',
                        p_p_id: '',
                        p_tag: '',
                        p_nice: '',
                        p_browse_count: '',
                        p_thumbs_count: '',
                    },
                    userList: [],
                    commentList: [{
                        c_id: '',
                        c_content: '',
                        c_comment_u_id: '',
                        c_comment_p_id: '',
                        c_comment_time: '',
                        c_floor: '',
                    },],
                    addComment: {
                        c_id: '',
                        c_content: '',
                        c_comment_u_id: '',
                        c_comment_p_id: '',
                        c_comment_time: '',
                        c_floor: '',
                    },
                    drawer: false,
                    labelPosition: 'left',
                    itemKey: 1,


                }
            },
            filters: {},
            methods: {
                c_comment_u_idFormatter(row, index) {
                    for (let item of app.userList) {
                        if (row.c_comment_u_id == item.u_id) {
                            console.log(item)
                            return item.u_name
                        }
                    }
                },
                p_u_idFormatter(value) {
                    console.log(app.userList)
                    for (let item of app.userList) {
                        if (value == item.u_id) {
                            console.log(item)
                            return item.u_name
                        }
                    }
                },
            },
            created: function () {
                getUserList();
                getPostByPId();
                changePostPBrowseCount();
                getCommentList();
            }
        })
    </script>
</html>

