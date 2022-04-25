<%@ page import="com.WPF.domain.UserGrade" %>
<%@ page import="com.WPF.domain.UserBasic" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    UserGrade userGrade = (UserGrade) session.getAttribute("userGrade");
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
        <link rel="stylesheet" type="text/css" href="u_css/UserCenter.css"/>
        <link rel="stylesheet" type="text/css" href="lib-master/theme-chalk/index.css"/>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="lib-master/index.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            function getUserBasic() {
                $.ajax({
                    url: "user/getUserBasic",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"u_id": JSON.stringify(document.getElementById("u_id").textContent)},
                    success: function (reps) {
                        console.log(reps)
                        app.userBasic = reps;
                        app.changeUserBasic = reps;
                    },
                    error: function () {
                        app.personal_information_div2_el_escription = '1';
                    }
                })
            }

            function getUserSchool() {
                $.ajax({
                    url: "user/getUserSchool",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"u_id": JSON.stringify(document.getElementById("u_id").textContent)},
                    success: function (reps) {
                        console.log(reps)
                        app.userSchool = reps;
                        app.changeUserSchool = reps;
                    },
                    error: function () {
                        app.personal_information_div3_el_escription = '1';
                    }
                })
            }

            function getUserCompany() {
                $.ajax({
                    url: "user/getUserCompany",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"u_id": JSON.stringify(document.getElementById("u_id").textContent)},
                    success: function (reps) {
                        console.log(reps)
                        app.userCompany = reps;
                        app.changeUserCompany = reps;
                    },
                    error: function () {
                        app.personal_information_div4_el_escription = '1';
                    }
                })
            }

            function getUserInterestLike() {
                $.ajax({
                    url: "user/getUserInterestLike",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"u_id": JSON.stringify(document.getElementById("u_id").textContent)},
                    success: function (reps) {
                        console.log(reps)
                        app.likeTags = reps;
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function getUserInterestDislike() {
                $.ajax({
                    url: "user/getUserInterestDislike",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"u_id": JSON.stringify(document.getElementById("u_id").textContent)},
                    success: function (reps) {
                        console.log(reps)
                        app.dislikeTags = reps;
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function putChangeUserBasic() {
                app.changeUserBasic.u_id = document.getElementById("u_id").textContent;
                console.log(app.changeUserBasic);
                $.ajax({
                    url: "user/putChangeUserBasic",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"userBasic": JSON.stringify(app.changeUserBasic)},
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = "./UserCenter.jsp";
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function putChangeUserSchool() {
                app.changeUserSchool.u_id = document.getElementById("u_id").textContent;
                console.log(app.changeUserSchool);
                $.ajax({
                    url: "user/putChangeUserSchool",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"userSchool": JSON.stringify(app.changeUserSchool)},
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = "./UserCenter.jsp";
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function putChangeUserCompany() {
                app.changeUserCompany.u_id = document.getElementById("u_id").textContent;
                console.log(app.changeUserCompany);
                $.ajax({
                    url: "user/putChangeUserCompany",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"userCompany": JSON.stringify(app.changeUserCompany)},
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = "./UserCenter.jsp";
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function removeUserInterest(tag) {
                $.ajax({
                    url: "user/removeUserInterest",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"u_interest_id": JSON.stringify(tag.u_interest_id)},
                    success: function (reps) {
                        alert(reps.valueOf());
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function putLikeTag() {
                app.likeTag.u_id = document.getElementById("u_id").textContent;
                console.log(app.likeTag);
                $.ajax({
                    url: "user/putLikeTag",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"likeTag": JSON.stringify(app.likeTag)},
                    success: function (reps) {
                        alert(reps.valueOf());
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function putDislikeTag() {
                app.dislikeTag.u_id = document.getElementById("u_id").textContent;
                console.log(app.likeTag);
                $.ajax({
                    url: "user/putDislikeTag",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"dislikeTag": JSON.stringify(app.dislikeTag)},
                    success: function (reps) {
                        alert(reps.valueOf());
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

        </script>
    </head>
    <body>
        <div class="param" id="u_id">${userGrade.u_id}</div>
        <div id="app">
            <el-container>
                <el-header>
                    <div id="header-title">
                        <span onclick="window.location.href = './index.jsp'">王潘锋BBS</span>
                    </div>
                    <div id="nav-left">
                        <ul class="nav-ul">
                            <li><a href="#news">入门</a></li>
                            <li><a href="#contact">编程</a></li>
                            <li><a href="#about">编程</a></li>
                            <li><a href="#about">编程</a></li>
                            <li><a href="#about">编程</a></li>
                            <li><a href="#about">编程</a></li>
                        </ul>
                    </div>
                    <div id="search">
                        <div style="margin-top: 10px;">
                            <el-input placeholder="请输入内容" v-model="input" class="input-with-select">
                                <el-select v-model="select" slot="prepend" placeholder="请选择">
                                    <el-option label="用户" value="1"></el-option>
                                    <el-option label="板块" value="2"></el-option>
                                    <el-option label="帖子" value="3"></el-option>
                                </el-select>
                                <el-button slot="append" icon="el-icon-search"></el-button>
                            </el-input>
                        </div>
                    </div>
                    <div id="nav-right">
                        <ul class="nav-ul">
                            <div id="nav-ul-img">
                                <a href="#news">
                                    <el-dropdown @command="handleCommand">
                                        <el-avatar :size="50" src="<%=userBasic.getU_img()%>"></el-avatar>
                                        <el-dropdown-menu slot="dropdown" style="width: 300px">
                                            <span>?</span>
                                            <el-dropdown-item icon="el-icon-plus" command="a">黄金糕</el-dropdown-item>
                                            <el-dropdown-item icon="el-icon-circle-plus">狮子头</el-dropdown-item>
                                            <el-dropdown-item icon="el-icon-circle-plus-outline">螺蛳粉</el-dropdown-item>
                                            <el-dropdown-item icon="el-icon-check">双皮奶</el-dropdown-item>
                                            <el-dropdown-item icon="el-icon-circle-check">蚵仔煎</el-dropdown-item>
                                        </el-dropdown-menu>
                                    </el-dropdown>
                                </a>
                            </div>
                            <li><a href="#contact">编程</a></li>
                            <li><a href="#about">编程</a></li>
                            <li><a href="#about">编程</a></li>
                            <li><a href="#about">编程</a></li>
                            <li><a href="#about">编程</a></li>
                        </ul>
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
                                        <span slot="title">个人资料</span>
                                    </el-menu-item>
                                    <el-menu-item index="2">
                                        <span slot="title">账号设置</span>
                                    </el-menu-item>
                                    <el-menu-item index="3">
                                        <span slot="title">隐私设置</span>
                                    </el-menu-item>
                                    <el-menu-item index="4">
                                        <span slot="title">我的收藏</span>
                                    </el-menu-item>
                                    <el-menu-item index="5">
                                        <span slot="title">浏览历史</span>
                                    </el-menu-item>
                                    <el-menu-item index="6">
                                        <span slot="title">内容管理</span>
                                    </el-menu-item>

                                </el-menu>
                            </el-col>
                        </el-row>
                    </el-aside>
                    <el-container>
                        <el-main>
                            <div v-show="index==1">
                                <div id="personal_information">
                                    <div id="personal_information_div1">
                                        <div id="personal_information_div1_img">
                                            <el-button type="text" @click="dialogFormVisible = true">
                                                <el-avatar :size="92" src="<%=userBasic.getU_img()%>"></el-avatar>
                                            </el-button>
                                            <el-dialog title="上传头像" :visible.sync="dialogFormVisible">
                                                <form action="user/fileupload" method="post"
                                                      enctype="multipart/form-data">
                                                    选择文件：<input type="file" name="upload"><br>
                                                    <input type="submit" value="上传">
                                                </form>
                                            </el-dialog>
                                        </div>
                                        <div id="personal_information_div1_uName">${sessionScope.userBasic.u_name}</div>
                                    </div>
                                    <span style="display: block;height: 3px;width: 98%;margin: 24px auto;"><el-divider></el-divider></span>
                                    <div id="personal_information_div2">
                                        <div v-if="personal_information_div2_el_escription==0">
                                            <el-descriptions direction="vertical" class="margin-top" title="基本信息"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div2_el_escription=1">操作
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        用户昵称
                                                    </template>
                                                    {{userBasic.u_name}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user-solid"></i>
                                                        用户ID
                                                    </template>
                                                    {{userBasic.u_id}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-male"></i>
                                                        用户性别
                                                    </template>
                                                    {{userBasic.u_gender}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-date"></i>
                                                        用户出生日期
                                                    </template>
                                                    {{userBasic.u_age|dateFilter}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        居住地
                                                    </template>
                                                    {{userBasic.u_address}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-tickets"></i>
                                                        用户简介
                                                    </template>
                                                    {{userBasic.u_introduction}}
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>
                                        <div v-else>
                                            <el-descriptions direction="vertical" class="margin-top" title="修改基本信息"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="putChangeUserBasic()">修改
                                                    </el-button>
                                                </template>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div2_el_escription=0">返回
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        用户昵称
                                                    </template>
                                                    <el-input
                                                            placeholder="请输入内容"
                                                            v-model="changeUserBasic.u_name"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-male"></i>
                                                        用户性别
                                                    </template>
                                                    <el-select v-model="changeUserBasic.u_gender" clearable
                                                               placeholder="请选择">
                                                        <el-option
                                                                v-for="item in genderOptions"
                                                                :key="item.value"
                                                                :label="item.label"
                                                                :value="item.value">
                                                        </el-option>
                                                    </el-select>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-date"></i>
                                                        用户出生日期
                                                    </template>
                                                    <el-date-picker
                                                            v-model="changeUserBasic.u_age"
                                                            type="date"
                                                            value-format="yyyy-MM-dd"
                                                            placeholder="选择日期">
                                                    </el-date-picker>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        居住地
                                                    </template>
                                                    <el-input
                                                            placeholder="请输入内容"
                                                            v-model="changeUserBasic.u_address"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-tickets"></i>
                                                        用户简介
                                                    </template>
                                                    <el-input
                                                            type="textarea"
                                                            placeholder="请输入内容"
                                                            v-model="changeUserBasic.u_introduction"
                                                            maxlength="255"
                                                            :rows="5"
                                                            show-word-limit>
                                                    </el-input>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>

                                    </div>
                                    <div id="personal_information_div3">
                                        <div v-if="personal_information_div3_el_escription==0">
                                            <el-descriptions direction="vertical" class="margin-top" title="教育信息"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div3_el_escription=1">操作
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        学校名称
                                                    </template>
                                                    {{userSchool.u_school_name}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user-solid"></i>
                                                        专业
                                                    </template>
                                                    {{userSchool.u_school_profession}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-male"></i>
                                                        入学时间
                                                    </template>
                                                    {{userSchool.u_school_start}}至{{userSchool.u_school_end}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-date"></i>
                                                        学历
                                                    </template>
                                                    {{userSchool.u_school_education}}
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>
                                        <div v-else>
                                            <el-descriptions direction="vertical" class="margin-top" title="修改学校信息"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="putChangeUserSchool()">修改
                                                    </el-button>
                                                </template>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div3_el_escription=0">返回
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        学校名称
                                                    </template>
                                                    <el-input
                                                            placeholder="请输入内容"
                                                            v-model="changeUserSchool.u_school_name"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        专业
                                                    </template>
                                                    <el-input
                                                            placeholder="请输入内容"
                                                            v-model="changeUserSchool.u_school_profession"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-date"></i>
                                                        入学时间
                                                    </template>
                                                    <el-date-picker
                                                            v-model="changeUserSchool.u_school_start"
                                                            type="date"
                                                            value-format="yyyy-MM-dd"
                                                            placeholder="选择日期">
                                                    </el-date-picker>
                                                    至
                                                    <el-date-picker
                                                            v-model="changeUserSchool.u_school_end"
                                                            type="date"
                                                            value-format="yyyy-MM-dd"
                                                            placeholder="选择日期">
                                                    </el-date-picker>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-tickets"></i>
                                                        学历
                                                    </template>
                                                    <el-input
                                                            placeholder="请输入内容"
                                                            v-model="changeUserSchool.u_school_education"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>

                                    </div>
                                    <div id="personal_information_div4">
                                        <div v-if="personal_information_div4_el_escription==0">
                                            <el-descriptions direction="vertical" class="margin-top" title="工作信息"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div4_el_escription=1">操作
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        公司名称
                                                    </template>
                                                    {{userCompany.u_company_name}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user-solid"></i>
                                                        职位名称
                                                    </template>
                                                    {{userCompany.u_company_posts}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-male"></i>
                                                        所属行业
                                                    </template>
                                                    {{userCompany.u_company_industry}}
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>
                                        <div v-else>
                                            <el-descriptions direction="vertical" class="margin-top" title="修改工作信息"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="putChangeUserCompany()">修改
                                                    </el-button>
                                                </template>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div4_el_escription=0">返回
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        公司名称
                                                    </template>
                                                    <el-input
                                                            placeholder="请输入内容"
                                                            v-model="changeUserCompany.u_company_name"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        职位名称
                                                    </template>
                                                    <el-input
                                                            placeholder="请输入内容"
                                                            v-model="changeUserCompany.u_company_posts"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        所属行业
                                                    </template>
                                                    <el-input
                                                            placeholder="请输入内容"
                                                            v-model="changeUserCompany.u_company_industry"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>

                                    </div>
                                    <div id="personal_information_div5">
                                        <el-descriptions class="margin-top" title="兴趣标签"
                                                         :column="1" border>
                                            <el-descriptions-item>
                                                <template slot="label">
                                                    <i class="el-icon-user"></i>
                                                    感兴趣
                                                </template>
                                                <el-tag
                                                        :key="tag"
                                                        v-for="tag in likeTags"
                                                        closable
                                                        :disable-transitions="false"
                                                        @close="likeTagHandleClose(tag)">
                                                    {{tag.u_interest}}
                                                </el-tag>
                                                <spna style="margin-left: 10px">
                                                    <el-input
                                                            class="input-new-tag"
                                                            v-if="likeInputVisible"
                                                            v-model="likeInputValue"
                                                            ref="likeSaveTagInput"
                                                            size="small"
                                                            @keyup.enter.native="likeTagHandleInputConfirm"
                                                            @blur="likeTagHandleInputConfirm"
                                                    >
                                                    </el-input>
                                                    <el-button v-else class="button-new-tag" size="small"
                                                               @click="likeTagShowInput">+ New Tag
                                                    </el-button>
                                                </spna>
                                            </el-descriptions-item>
                                            <el-descriptions-item>
                                                <template slot="label">
                                                    <i class="el-icon-user"></i>
                                                    不感兴趣
                                                </template>
                                                <el-tag
                                                        :key="tag"
                                                        v-for="tag in dislikeTags"
                                                        closable
                                                        :disable-transitions="false"
                                                        @close="dislikeTagHandleClose(tag)">
                                                    {{tag.u_interest}}
                                                </el-tag>
                                                <spna style="margin-left: 10px">
                                                    <el-input
                                                            class="input-new-tag"
                                                            v-if="dislikeInputVisible"
                                                            v-model="dislikeInputValue"
                                                            ref="dislikeSaveTagInput"
                                                            size="small"
                                                            @keyup.enter.native="dislikeTagHandleInputConfirm"
                                                            @blur="dislikeTagHandleInputConfirm"
                                                    >
                                                    </el-input>
                                                    <el-button v-else class="button-new-tag" size="small"
                                                               @click="dislikeTagShowInput">+ New Tag
                                                    </el-button>
                                                </spna>
                                            </el-descriptions-item>
                                        </el-descriptions>
                                    </div>
                                </div>
                            </div>
                            <div v-show="index==2">
                                <div id="account_settings">
                                    <div id="account_settings_div1">
                                        <el-descriptions class="margin-top" title="账号设置"
                                                         :column="1" border>
                                            <el-descriptions-item>
                                                <template slot="label">
                                                    <i class="el-icon-user"></i>
                                                    感兴趣
                                                </template>
                                                <el-tag
                                                        :key="tag"
                                                        v-for="tag in likeTags"
                                                        closable
                                                        :disable-transitions="false"
                                                        @close="likeTagHandleClose(tag)">
                                                    {{tag.u_interest}}
                                                </el-tag>
                                                <spna style="margin-left: 10px">
                                                    <el-input
                                                            class="input-new-tag"
                                                            v-if="likeInputVisible"
                                                            v-model="likeInputValue"
                                                            ref="likeSaveTagInput"
                                                            size="small"
                                                            @keyup.enter.native="likeTagHandleInputConfirm"
                                                            @blur="likeTagHandleInputConfirm"
                                                    >
                                                    </el-input>
                                                    <el-button v-else class="button-new-tag" size="small"
                                                               @click="likeTagShowInput">+ New Tag
                                                    </el-button>
                                                </spna>
                                            </el-descriptions-item>
                                            <el-descriptions-item>
                                                <template slot="label">
                                                    <i class="el-icon-user"></i>
                                                    不感兴趣
                                                </template>
                                                <el-tag
                                                        :key="tag"
                                                        v-for="tag in dislikeTags"
                                                        closable
                                                        :disable-transitions="false"
                                                        @close="dislikeTagHandleClose(tag)">
                                                    {{tag.u_interest}}
                                                </el-tag>
                                                <spna style="margin-left: 10px">
                                                    <el-input
                                                            class="input-new-tag"
                                                            v-if="dislikeInputVisible"
                                                            v-model="dislikeInputValue"
                                                            ref="dislikeSaveTagInput"
                                                            size="small"
                                                            @keyup.enter.native="dislikeTagHandleInputConfirm"
                                                            @blur="dislikeTagHandleInputConfirm"
                                                    >
                                                    </el-input>
                                                    <el-button v-else class="button-new-tag" size="small"
                                                               @click="dislikeTagShowInput">+ New Tag
                                                    </el-button>
                                                </spna>
                                            </el-descriptions-item>
                                        </el-descriptions>
                                    </div>

                                </div>
                            </div>
                            <div v-show="index==3">3</div>
                            <div v-show="index==4">4</div>
                            <div v-show="index==5">5</div>
                            <div v-show="index==6">6</div>
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
                    personal_information_div2_el_escription: '0',
                    personal_information_div3_el_escription: '0',
                    personal_information_div4_el_escription: '0',
                    likeTags: [],
                    likeTag: {
                        u_id: '',
                        u_interest_id: '',
                        u_interest: '',
                        u_interest_dislike: 0,
                    },
                    dislikeTags: [{
                        u_id: '',
                        u_interest_id: '',
                        u_interest: '',
                        u_interest_dislike: '',
                    },],
                    dislikeTag: {
                        u_id: '',
                        u_interest_id: '',
                        u_interest: '',
                        u_interest_dislike: 1,
                    },
                    likeInputVisible: false,
                    dislikeInputVisible: false,
                    likeInputValue: '',
                    dislikeInputValue: '',
                    index: '1',
                    input: '',
                    select: '',
                    userBasic: {
                        u_id: '',
                        u_name: '',
                        u_gender: '',
                        u_age: '',
                        u_introduction: '',
                        u_address: '',
                    },
                    changeUserBasic: {
                        u_id: '',
                        u_name: '',
                        u_gender: '',
                        u_age: '',
                        u_introduction: '',
                        u_address: '',
                    },
                    userSchool: {
                        u_id: '',
                        u_school_name: '',
                        u_school_profession: '',
                        u_school_start: '',
                        u_school_end: '',
                        u_school_education: '',
                    },
                    changeUserSchool: {
                        u_id: '',
                        u_school_name: '',
                        u_school_profession: '',
                        u_school_start: '',
                        u_school_end: '',
                        u_school_education: '',
                    },
                    userCompany: {
                        u_id: '',
                        u_company_name: '',
                        u_company_posts: '',
                        u_company_industry: '',
                    },
                    changeUserCompany: {
                        u_id: '',
                        u_company_name: '',
                        u_company_posts: '',
                        u_company_industry: '',
                    },
                    dialogFormVisible: false,
                    genderOptions: [{
                        value: '男',
                        label: '男'
                    }, {
                        value: '女',
                        label: '女'
                    }, {
                        value: '秘密',
                        label: '秘密'
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
            },
            methods: {
                handleCommand(command) {
//头像下拉菜单事件
                },
                selectIndex(index, indexPath) {
                    app.index = index;
                },
                handleOpen(key, keyPath) {
                    console.log(key, keyPath);
                },
                handleClose(key, keyPath) {
                    console.log(key, keyPath);
                },
                likeTagHandleClose(tag) {
                    this.likeTags.splice(this.likeTags.indexOf(tag), 1);
                    removeUserInterest(tag);
                },

                likeTagShowInput() {
                    this.likeInputVisible = true;
                    this.$nextTick(_ => {
                        this.$refs.likeSaveTagInput.$refs.input.focus();
                    });
                },

                likeTagHandleInputConfirm() {
                    this.likeTag.u_interest = this.likeInputValue;
                    if (this.likeTag) {
                        this.likeTags.push(this.likeTag);
                    }
                    this.likeInputVisible = false;
                    this.likeInputValue = '';
                    putLikeTag();
                },

                dislikeTagHandleClose(tag) {
                    this.dislikeTags.splice(this.dislikeTags.indexOf(tag), 1);
                    removeUserInterest(tag);
                },

                dislikeTagShowInput() {
                    this.dislikeInputVisible = true;
                    this.$nextTick(_ => {
                        this.$refs.dislikeSaveTagInput.$refs.input.focus();
                    });
                },

                dislikeTagHandleInputConfirm() {
                    this.dislikeTag.u_interest = this.dislikeInputValue;
                    if (this.dislikeTag) {
                        this.dislikeTags.push(this.dislikeTag);
                    }
                    this.dislikeInputVisible = false;
                    this.dislikeInputValue = '';
                    putDislikeTag();
                }
            },
            created: function () {
                getUserBasic();
                getUserSchool();
                getUserCompany();
                getUserInterestLike();
                getUserInterestDislike();
            }
        })
    </script>
</html>

