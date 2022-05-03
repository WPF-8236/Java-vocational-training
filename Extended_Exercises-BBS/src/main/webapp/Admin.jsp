<%@ page import="com.WPF.domain.UserGrade" %>
<%@ page import="com.WPF.domain.UserBasic" %>
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
        <link rel="stylesheet" type="text/css" href="u_css/Admin.css"/>
        <link rel="stylesheet" type="text/css" href="lib-master/theme-chalk/index.css"/>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="lib-master/index.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            function getUserList() {
                $.ajax({
                    url: "admin/getUserList",
                    contentType: 'application/json;charset=UTF-8',
                    success: function (reps) {
                        console.log(reps)
                        app.userList = reps;
                        app.userListPage.total = app.userList.length;
                    },
                    error: function () {
                        alert('用户列表获取失败');
                    }
                })
            }

            function getPlateList() {
                $.ajax({
                    url: "admin/getPlateList",
                    contentType: 'application/json;charset=UTF-8',
                    success: function (reps) {
                        console.log(reps)
                        app.plateList = reps;
                        app.plateListPage.total = app.plateList.length;
                    },
                    error: function () {
                        alert('板块列表获取失败');
                    }
                })
            }

            function getModerator() {
                $.ajax({
                    url: "admin/getModerator",
                    contentType: 'application/json;charset=UTF-8',
                    success: function (reps) {
                        console.log(reps)
                        app.moderator = reps;
                    },
                    error: function () {
                        alert('版主列表获取失败');
                    }
                })
            }

            function changeUGrade(u_id, tag) {
                $.ajax({
                    url: "admin/changeUGrade",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "u_id": JSON.stringify(u_id),
                        "tag": JSON.stringify(tag)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = './Admin.jsp'
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function changeUStatus(u_id, tag) {
                $.ajax({
                    url: "admin/changeUStatus",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "u_id": JSON.stringify(u_id),
                        "tag": JSON.stringify(tag)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = './Admin.jsp'
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function changePStatus(p_id, tag) {
                $.ajax({
                    url: "admin/changePStatus",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "p_id": JSON.stringify(p_id),
                        "tag": JSON.stringify(tag)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPlateList();
                        app.itemKey = Math.random();
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function updateAUser() {
                console.log(app.updateUser)
                $.ajax({
                    url: "admin/updateAUser",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "u_id": JSON.stringify(app.updateUser.u_id),
                        "u_name": JSON.stringify(app.updateUser.u_name),
                        "u_password": JSON.stringify(app.updateUser.u_password),
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = './Admin.jsp'
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function updateAPlate() {
                console.log(app.changePlate)
                $.ajax({
                    url: "admin/updateAPlate",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "changePlate": JSON.stringify(app.changePlate)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPlateList();
                        app.itemKey = Math.random();
                        app.changePlateDrawer = false
                        app.changePlate = ''
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function searchUser() {
                console.log(app.input)
                console.log(app.select)
                $.ajax({
                    url: "admin/searchUser",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "input": JSON.stringify(app.input),
                        "select": JSON.stringify(app.select),
                    },
                    success: function (reps) {
                        app.userList = reps;
                        app.userListPage.total = app.userList.length;
                        app.itemKey = Math.random();
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function addAPlate() {
                console.log(app.addPlate)
                $.ajax({
                    url: "admin/addAPlate",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "addPlate": JSON.stringify(app.addPlate),
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPlateList();
                        app.itemKey = Math.random();
                        app.addPlateDrawer = false
                        app.addPlate = ''
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function removePlate(p_id) {
                console.log(p_id)
                $.ajax({
                    url: "admin/removePlate",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "p_id": JSON.stringify(p_id),
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPlateList();
                        app.itemKey = Math.random();
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

        </script>
    </head>
    <body>
        <div id="app">
            <el-container>
                <el-header>
                    <div id="header-title">
                        <span onclick="window.location.href = './index.jsp'">王潘锋BBS</span>
                    </div>
                    <div id="header-logout">
                        <span onclick="window.location.href = './logout.jsp'">登出</span>
                    </div>
                </el-header>
                <el-container>
                    <el-aside style="width: 250px">
                        <el-row class="tac">
                            <el-col>
                                <el-menu
                                        default-active="1"
                                        class="el-menu-vertical-demo"
                                        @open="handleOpen"
                                        @close="handleClose"
                                        @select="selectIndex">
                                    <el-menu-item index="1">
                                        <span slot="title">用户管理</span>
                                    </el-menu-item>
                                    <el-menu-item index="2">
                                        <span slot="title">帖子管理</span>
                                    </el-menu-item>
                                    <el-menu-item index="3">
                                        <span slot="title">板块管理</span>
                                    </el-menu-item>
                                    <el-menu-item index="4">
                                        <span slot="title">浏览历史</span>
                                    </el-menu-item>
                                    <el-menu-item index="5">
                                        <span slot="title">内容管理</span>
                                    </el-menu-item>

                                </el-menu>
                            </el-col>
                        </el-row>
                    </el-aside>
                    <el-container>
                        <el-main>
                            <div v-show="index==1">
                                <div id="user_controller">
                                    <div id="search">
                                        <el-input placeholder="请输入内容" v-model="input" class="input-with-select">
                                            <el-select v-model="select" slot="prepend" placeholder="请选择">
                                                <el-option label="用户编号" value="1"></el-option>
                                                <el-option label="用户昵称" value="2"></el-option>
                                            </el-select>
                                            <el-button slot="append" icon="el-icon-search"
                                                       @click="searchUser"></el-button>
                                        </el-input>
                                    </div>
                                    <div id="user_controller_userList">
                                        <el-table
                                                ref="userList"
                                                :data="userList.slice((userListPage.currentPage-1)*userListPage.pageSize,userListPage.currentPage*userListPage.pageSize)"
                                                :key="itemKey">
                                            <el-table-column
                                                    type="index"
                                                    width="50">
                                            </el-table-column>
                                            <el-table-column
                                                    prop="u_id"
                                                    label="用户编号"
                                                    width="180"
                                            >
                                            </el-table-column>
                                            <el-table-column
                                                    prop="u_name"
                                                    label="用户昵称"
                                                    width="180">
                                            </el-table-column>
                                            <el-table-column
                                                    prop="u_password"
                                                    label="用户密码"
                                                    width="180">
                                            </el-table-column>
                                            <el-table-column
                                                    prop="u_grade"
                                                    label="用户级别"
                                                    width="100"
                                                    :filters="[{ text: '普通用户', value: '0' }, { text: '版主', value: '1' }]"
                                                    :filter-method="userListFilterUGrade"
                                                    filter-placement="bottom-end">
                                                <template slot-scope="scope">
                                                    <el-tag
                                                            :type="scope.row.u_grade == '0' ? 'primary' : 'success'"
                                                            disable-transitions>{{scope.row.u_grade|u_gradeFormatter}}
                                                    </el-tag>
                                                </template>
                                            </el-table-column>
                                            <el-table-column label="级别操作"
                                                             width="100">
                                                <template slot-scope="scope">
                                                    <el-button
                                                            v-if="scope.row.u_grade==0"
                                                            size="mini"
                                                            @click="u_gradeUp(scope.$index, scope.row)">升级
                                                    </el-button>
                                                    <el-button
                                                            v-else
                                                            size="mini"
                                                            type="danger"
                                                            @click="u_gradeDown(scope.$index, scope.row)">降级
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                            <el-table-column
                                                    prop="u_status"
                                                    label="用户状态"
                                                    width="100"
                                                    :filters="[{ text: '正常', value: '0' }, { text: '封禁', value: '1' }]"
                                                    :filter-method="userListFilterUStatus"
                                                    filter-placement="bottom-end">
                                                <template slot-scope="scope">
                                                    <el-tag
                                                            :type="scope.row.u_status == '0' ? 'success' : 'danger'"
                                                            disable-transitions>{{scope.row.u_status|statusFormatter}}
                                                    </el-tag>
                                                </template>
                                            </el-table-column>
                                            <el-table-column label="状态操作">
                                                <template slot-scope="scope" width="100">
                                                    <el-button
                                                            v-if="scope.row.u_status==1"
                                                            size="mini"
                                                            @click="u_statusUnlock(scope.$index, scope.row)">解禁
                                                    </el-button>
                                                    <el-button
                                                            v-else
                                                            size="mini"
                                                            type="danger"
                                                            @click="u_statusClock(scope.$index, scope.row)">封禁
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                            <el-table-column label="信息编辑操作">
                                                <template slot-scope="scope" width="100">
                                                    <el-button
                                                            size="mini"
                                                            @click="handleClick1(scope.row)">修改
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                        <div class="block" style="margin-top:15px;">
                                            <el-pagination
                                                    @size-change="handleSizeChange1"
                                                    @current-change="handleCurrentChange1"
                                                    :current-page.sync="userListPage.currentPage"
                                                    :page-sizes="[5, 10, 15, 20, 25]"
                                                    :page-size="userListPage.pageSize"
                                                    layout="total, sizes, prev, pager, next, jumper"
                                                    :total="userListPage.total">
                                            </el-pagination>
                                        </div>
                                        <el-drawer
                                                title="编辑信息"
                                                :visible.sync="drawer"
                                                :direction="direction">
                                            <div id="updateUser">
                                                <el-form :label-position="labelPosition" label-width="100px"
                                                         :model="updateUser">
                                                    <el-form-item label="用户昵称">
                                                        <el-input v-model="updateUser.u_name"></el-input>
                                                    </el-form-item>
                                                    <el-form-item label="用户密码">
                                                        <el-input v-model="updateUser.u_password"></el-input>
                                                    </el-form-item>
                                                    <el-button type="primary" @click="updateAUser">修改信息
                                                    </el-button>
                                                </el-form>
                                            </div>
                                        </el-drawer>
                                    </div>
                                </div>
                            </div>
                            <div v-show="index==2">

                            </div>
                            <div v-show="index==3">
                                <div id="plate_manage">
                                    <div id="addPlate">
                                        <div id="addPlate_addButton">
                                            <el-button type="primary" onclick="app.addPlateDrawer=true">添加板块</el-button>
                                        </div>
                                        <div id="addPlate_addPanel">
                                            <el-drawer
                                                    title="添加板块"
                                                    :visible.sync="addPlateDrawer"
                                                    :direction="direction">
                                                <div id="addPlate_addPanel_drawer">
                                                    <el-form :label-position="labelPosition" label-width="100px"
                                                             :model="addPlate">
                                                        <el-form-item label="板块名称">
                                                            <el-input v-model="addPlate.p_name"
                                                                      placeholder="请输入内容"></el-input>
                                                        </el-form-item>
                                                        <el-form-item label="版主昵称">
                                                            <el-select v-model="addPlate.p_u_id" placeholder="请选择">
                                                                <el-option
                                                                        v-for="item in moderator"
                                                                        :key="item.u_id"
                                                                        :label="item.u_name"
                                                                        :value="item.u_id"
                                                                        :disabled="item.u_status==1 ? true : false">
                                                                </el-option>
                                                            </el-select>
                                                        </el-form-item>
                                                        <el-form-item label="板块描述">
                                                            <el-input type="textarea"
                                                                      placeholder="请输入内容"
                                                                      maxlength="30"
                                                                      show-word-limit
                                                                      v-model="addPlate.p_description"></el-input>
                                                        </el-form-item>
                                                        <el-button type="primary" @click="addAPlate">添加板块
                                                        </el-button>
                                                    </el-form>
                                                </div>
                                            </el-drawer>
                                        </div>
                                    </div>
                                    <div id="plate_list">
                                        <el-table
                                                ref="plateList"
                                                :data="plateList.slice((plateListPage.currentPage-1)*plateListPage.pageSize,plateListPage.currentPage*plateListPage.pageSize)"
                                                :key="itemKey">
                                            <el-table-column
                                                    type="index"
                                                    width="50">
                                            </el-table-column>
                                            </el-table-column>
                                            <el-table-column
                                                    prop="p_name"
                                                    label="板块名称"
                                                    width="120">
                                            </el-table-column>
                                            <el-table-column
                                                    prop="p_u_id"
                                                    label="版主昵称"
                                                    width="120"
                                                    :formatter="p_u_idFormatter">
                                            </el-table-column>
                                            <el-table-column
                                                    prop="p_p_count"
                                                    label="板块帖子数目"
                                                    width="120">
                                            </el-table-column>
                                            <el-table-column
                                                    prop="p_comment_count"
                                                    label="板块评论数目"
                                                    width="120">
                                            </el-table-column>
                                            <el-table-column
                                                    prop="p_description"
                                                    label="板块描述"
                                                    width="300">
                                            </el-table-column>
                                            <el-table-column
                                                    prop="p_status"
                                                    label="板块状态"
                                                    width="100"
                                                    :filters="[{ text: '正常', value: '0' }, { text: '封禁', value: '1' },{ text: '审核', value: '2' }]"
                                                    :filter-method="plateListFilterPStatus"
                                                    filter-placement="bottom-end">
                                                <template slot-scope="scope">
                                                    <el-tag
                                                            :type="scope.row.p_status == '0' ? 'success' : 'danger'"
                                                            disable-transitions>{{scope.row.p_status|statusFormatter}}
                                                    </el-tag>
                                                </template>
                                            </el-table-column>
                                            <el-table-column label="状态操作" width="100">
                                                <template slot-scope="scope">
                                                    <el-button
                                                            v-if="scope.row.p_status==1"
                                                            size="mini"
                                                            @click="p_statusUnlock(scope.$index, scope.row)">解禁
                                                    </el-button>
                                                    <el-button
                                                            v-else-if="scope.row.p_status==0"
                                                            size="mini"
                                                            type="danger"
                                                            @click="p_statusClock(scope.$index, scope.row)">封禁
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                            <el-table-column label="操作">
                                                <template slot-scope="scope" width="100">
                                                    <div v-if="scope.row.p_status==2">
                                                        <el-button
                                                                size="mini"
                                                                @click="p_statusUnlock(scope.$index, scope.row)">通过
                                                        </el-button>
                                                        <el-button
                                                                size="mini"
                                                                type="danger"
                                                                @click="p_statusClock(scope.$index, scope.row)">不通过
                                                        </el-button>
                                                    </div>
                                                    <div v-else>
                                                        <el-button
                                                                size="mini"
                                                                @click="app.changePlateDrawer=true;app.changePlate=scope.row">
                                                            编辑
                                                        </el-button>
                                                        <el-button
                                                                size="mini"
                                                                type="danger"
                                                                @click="removePlate(scope.row.p_id)">删除
                                                        </el-button>
                                                    </div>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                        <el-drawer
                                                title="修改板块"
                                                :visible.sync="changePlateDrawer"
                                                :direction="direction">
                                            <div id="plate_list_drawer">
                                                <el-form :label-position="labelPosition" label-width="100px"
                                                         :model="changePlate">
                                                    <el-form-item label="板块名称">
                                                        <el-input v-model="changePlate.p_name"
                                                                  placeholder="请输入内容"></el-input>
                                                    </el-form-item>
                                                    <el-form-item label="版主昵称">
                                                        <el-select v-model="changePlate.p_u_id" placeholder="请选择">
                                                            <el-option
                                                                    v-for="item in moderator"
                                                                    :key="item.u_id"
                                                                    :label="item.u_name"
                                                                    :value="item.u_id"
                                                                    :disabled="item.u_status==1 ? true : false">
                                                            </el-option>
                                                        </el-select>
                                                    </el-form-item>
                                                    <el-form-item label="板块描述">
                                                        <el-input type="textarea"
                                                                  placeholder="请输入内容"
                                                                  maxlength="30"
                                                                  show-word-limit
                                                                  v-model="changePlate.p_description"></el-input>
                                                    </el-form-item>
                                                    <el-button type="primary" @click="updateAPlate">修改板块
                                                    </el-button>
                                                </el-form>
                                            </div>
                                        </el-drawer>
                                        <div class="block" style="margin-top:15px;">
                                            <el-pagination
                                                    @size-change="handleSizeChange2"
                                                    @current-change="handleCurrentChange2"
                                                    :current-page.sync="plateListPage.currentPage"
                                                    :page-sizes="[5, 10, 15, 20, 25]"
                                                    :page-size="plateListPage.pageSize"
                                                    layout="total, sizes, prev, pager, next, jumper"
                                                    :total="plateListPage.total">
                                            </el-pagination>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div v-show="index==4">4</div>
                            <div v-show="index==5">5</div>
                        </el-main>
                        <el-footer>
                            <div id="el-footer-detial">&copy; 2022 培训设计 | Design by 王潘锋</div>
                        </el-footer>
                    </el-container>
                </el-container>
            </el-container>
        </div>
    </body>
    <script type="text/javascript">
        var app = new Vue({
            el: '#app',
            data() {
                return {
                    userList: [{
                        u_id: '',
                        u_name: '',
                        u_password: '',
                        u_grade: '',
                        u_status: '',
                    },],
                    updateUser: '',
                    userListPage: {
                        currentPage: 1,
                        total: '',
                        pageSize: 10,
                    },
                    index: '1',
                    input: '',
                    select: '',
                    direction: 'rtl',
                    drawer: false,
                    labelPosition: 'left',
                    itemKey: 1,
                    addPlate: {
                        p_id: '',
                        p_name: '',
                        p_p_count: '',
                        p_comment_count: '',
                        p_description: '',
                        p_u_id: '',
                    },
                    addPlateDrawer: false,
                    changePlateDrawer: false,
                    plateList: [{
                        p_id: '',
                        p_name: '',
                        p_p_count: '',
                        p_comment_count: '',
                        p_description: '',
                        p_u_id: '',
                        p_status: '',
                    },],
                    changePlate: {
                        p_id: '',
                        p_name: '',
                        p_p_count: '',
                        p_comment_count: '',
                        p_description: '',
                        p_u_id: '',
                        p_status: '',
                    },
                    plateListPage: {
                        currentPage: 1,
                        total: '',
                        pageSize: 10,
                    },
                    moderator: [{
                        u_id: '',
                        u_name: '',
                        u_password: '',
                        u_grade: '',
                        u_status: '',
                    },],
                }
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
                u_gradeFormatter(value) {
                    if (value == 0)
                        return '普通用户'
                    else
                        return '版主'
                },
                statusFormatter(value) {
                    if (value == 0)
                        return '正常'
                    else if (value == 1)
                        return '封禁'
                    else
                        return '审核'
                },
            },
            methods: {
                selectIndex(index, indexPath) {
                    app.index = index;
                },
                handleOpen(key, keyPath) {
                    console.log(key, keyPath);
                },
                handleClose(key, keyPath) {
                    console.log(key, keyPath);
                },
                userListFilterUGrade(value, row) {
                    return row.u_grade == value;
                },
                userListFilterUStatus(value, row) {
                    return row.u_status == value;
                },
                plateListFilterPStatus(value, row) {
                    return row.p_status == value;
                },
                u_gradeUp(index, row) {
                    changeUGrade(row.u_id, 1);
                },
                u_gradeDown(index, row) {
                    changeUGrade(row.u_id, 0);
                },
                u_statusUnlock(index, row) {
                    changeUStatus(row.u_id, 0);
                },
                u_statusClock(index, row) {
                    changeUStatus(row.u_id, 1);
                },
                p_statusUnlock(index, row) {
                    changePStatus(row.p_id, 0);
                },
                p_statusClock(index, row) {
                    changePStatus(row.p_id, 1);
                },
                handleSizeChange1(val) {
                    console.log(`每页 ${val} 条`);
                    this.userListPage.currentPage = 1;
                    this.userListPage.pageSize = val;
                },
                handleCurrentChange1(val) {
                    console.log(`当前页: ${val}`);
                    this.userListPage.currentPage = val;
                },
                handleSizeChange2(val) {
                    console.log(`每页 ${val} 条`);
                    this.plateListPage.currentPage = 1;
                    this.plateListPage.pageSize = val;
                },
                handleCurrentChange2(val) {
                    console.log(`当前页: ${val}`);
                    this.plateListPage.currentPage = val;
                },
                handleClick1(row) {
                    this.drawer = 'true';
                    this.updateUser = row
                },
                p_u_idFormatter(row, column) {
                    for (let item of app.moderator) {
                        if (row.p_u_id == item.u_id) {
                            console.log(item)
                            return item.u_name
                        }
                    }
                },

            },
            created: function () {
                getUserList();
                getPlateList();
                getModerator();
            }
        })
    </script>
</html>

