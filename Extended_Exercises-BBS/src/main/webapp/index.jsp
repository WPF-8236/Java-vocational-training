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
            function getPlateList() {
                $.ajax({
                    url: "admin/getPlateList",
                    contentType: 'application/json;charset=UTF-8',
                    success: function (reps) {
                        console.log(reps)
                        app.plateList = reps;
                        app.plateListPage.total = app.plateList.length;
                        app.splitItems = app.itemSegmentation(app.plateList);
                    },
                    error: function () {
                        alert('板块列表获取失败');
                    }
                })
            }
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
                <%
                    if (userBasic != null) {
                %>
                <div id="index">
                    <el-container>
                        <el-main>
                            <ul v-for="splitItem in splitItems">
                                <li v-for="item in splitItem">
                                    <el-button style="width: 380px; height: 110px;"
                                               :disabled="item.p_status==0 ? false : true"
                                               @click="window.location.href='MessageList.jsp?p_id='+item.p_id">
                                        <el-tooltip class="item" effect="dark" :content="item.p_description"
                                                    placement="right-start">
                                            <el-card shadow="hover" body-style="{width: 380px; height: 100px;}">
                                                <div id="el_card_title">
                                                    {{item.p_name}}
                                                </div>
                                                <div id="el_card_ul">
                                                    <ul>
                                                        <el-tooltip class="item" effect="dark"
                                                                    content="贴子数"
                                                                    placement="right-start">
                                                            <li style="text-align: left">
                                                                <i class="el-icon-s-order"></i>
                                                                <span>{{item.p_p_count}}</span>
                                                            </li>
                                                        </el-tooltip>
                                                        <el-tooltip class="item" effect="dark"
                                                                    content="评论数"
                                                                    placement="right-start">
                                                            <li style="text-align: left">
                                                                <i class="el-icon-s-comment"></i>
                                                                <span>{{item.p_comment_count}}</span>
                                                            </li>
                                                        </el-tooltip>
                                                        <li>
                                                            <el-tag
                                                                    :type="item.p_status == '0' ? 'success' : 'danger'"
                                                                    disable-transitions>
                                                                {{item.p_status|statusFormatter}}
                                                            </el-tag>
                                                        </li>
                                                    </ul>
                                                </div>

                                            </el-card>
                                        </el-tooltip>
                                    </el-button>
                                </li>
                            </ul>
                        </el-main>
                    </el-container>
                </div>
                <%
                    }
                %>
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
                    return {
                        plateList: [{
                            p_id: '',
                            p_name: '',
                            p_p_count: '',
                            p_comment_count: '',
                            p_description: '',
                            p_u_id: '',
                            p_status: '',
                        },],
                        plateListPage: {
                            currentPage: 1,
                            total: '',
                            pageSize: 10,
                        },
                        splitItems: [],
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
                    uGradeFilter(value) {
                        if (value === 0)
                            return '普通用户'
                        else
                            return '版主用户'
                    },
                    statusFormatter(value) {
                        if (value == 0)
                            return '正常'
                        else if (value == 1)
                            return '封禁'
                        else
                            return '审核'
                    },
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
                    itemSegmentation(item) {
                        let splitItems = [];
                        item.forEach((item, index) => {
                            let idx = Math.floor(index / 3);
                            if (!splitItems[idx]) splitItems[idx] = [];
                            splitItems[idx].push(item);
                        });
                        return splitItems;
                    },
                },
                created: function () {
                    getPlateList();
                }
            })
        </script>
    </body>
</html>