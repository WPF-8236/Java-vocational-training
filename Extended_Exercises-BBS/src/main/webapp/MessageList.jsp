<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    String p_id = request.getParameter("p_id");
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
        <link rel="stylesheet" type="text/css" href="u_css/MessageList.css"/>
        <link rel="stylesheet" type="text/css" href="lib-master/theme-chalk/index.css"/>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="lib-master/index.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            function getPostListPPId() {
                $.ajax({
                    url: "message/getPostListPPId",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"p_id": JSON.stringify('<%=p_id%>')},
                    success: function (reps) {
                        console.log(reps)
                        app.postList = reps;
                        app.postListPage.total = app.postList.length;
                    },
                    error: function () {
                        alert("文章列表获取失败")
                    }
                })
            }

        </script>
    </head>
    <body>
        <div class="param"></div>
        <div id="app">
            <el-table
                    ref="postList"
                    :data="postList.slice((postListPage.currentPage-1)*postListPage.pageSize,postListPage.currentPage*postListPage.pageSize)"
                    :key="itemKey"
                    :row-class-name="tableRowClassName">
                <el-table-column
                        type="index"
                        width="40">
                </el-table-column>
                </el-table-column>
                <el-table-column
                        prop="p_title"
                        label="帖子名称"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="p_comment_count"
                        label="帖子评论数目"
                        width="110">
                </el-table-column>
                <el-table-column
                        prop="p_browse_count"
                        label="帖子浏览数目"
                        width="110">
                </el-table-column>
                <el-table-column
                        prop="p_thumbs_count"
                        label="帖子点赞数目"
                        width="110">
                </el-table-column>
                <el-table-column
                        prop="p_time"
                        label="帖子创建时间"
                        width="140">
                </el-table-column>
                <el-table-column
                        prop="p_tag"
                        label="帖子标签"
                        width="80">
                    <template slot-scope="scope">
                        <el-tag>
                            {{scope.row.p_tag|tagFormatter}}
                        </el-tag>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="p_nice"
                        label="帖子价值"
                        width="80">
                    <template slot-scope="scope">
                        <el-tag>
                            {{scope.row.p_nice|niceFormatter}}
                        </el-tag>
                    </template>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope" width="100">
                        <el-button
                                size="mini"
                                @click="window.location.href='Message.jsp?p_id='+scope.row.p_id">
                            阅览
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </body>
    <script type="text/javascript">
        var app = new Vue({
            el: '#app',
            data() {
                return {
                    postList: [{
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
                    },],
                    postListPage: {
                        currentPage: 1,
                        total: '',
                        pageSize: 10,
                    },
                    itemKey: 1,

                }
            },
            filters: {
                tagFormatter(value) {
                    if (value == 0)
                        return '原创'
                    else if (value == 1)
                        return '转载'
                    else
                        return '翻译'
                },
                niceFormatter(value) {
                    if (value == 0)
                        return '普通'
                    else
                        return '精华'
                },
            },
            methods: {
                tableRowClassName({row, rowIndex}) {
                    if (row.p_status === 0) {
                        return '';
                    } else {
                        return 'hidden-row';
                    }
                },
            },
            created: function () {
                getPostListPPId();
            }
        })
    </script>
</html>

