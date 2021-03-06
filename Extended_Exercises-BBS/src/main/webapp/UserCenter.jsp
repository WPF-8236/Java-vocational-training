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

            function getPlateListByUId() {
                $.ajax({
                    url: "user/getPlateListByUId",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"u_id": JSON.stringify(document.getElementById("u_id").textContent)},
                    success: function (reps) {
                        console.log(reps)
                        app.plateList = reps;
                        app.plateListPage.total = app.plateList.length;
                    },
                    error: function () {
                        alert('????????????????????????');
                    }
                })
            }

            function getPostListByUId() {
                $.ajax({
                    url: "user/getPostListByUId",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"u_id": JSON.stringify(document.getElementById("u_id").textContent)},
                    success: function (reps) {
                        console.log(reps)
                        app.postList = reps;
                        app.postListPage.total = app.postList.length;
                    },
                    error: function () {
                        alert('????????????????????????');
                    }
                })
            }

            function getPlateListAll() {
                $.ajax({
                    url: "admin/getPlateList",
                    contentType: 'application/json;charset=UTF-8',
                    success: function (reps) {
                        console.log(reps)
                        app.plateListAll = reps;
                    },
                    error: function () {
                        alert('????????????????????????');
                    }
                })
            }

            function getPostListByPPId(p_id) {
                $.ajax({
                    url: "user/getPostListByPPId",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"p_id": JSON.stringify(p_id)},
                    success: function (reps) {
                        console.log(reps)
                        app.postListByPPId = reps;
                        app.postListByPPIdPage.total = app.postListByPPId.length;
                    },
                    error: function () {
                        alert('????????????????????????');
                    }
                })
            }

            function addAPlate() {
                app.addPlate.p_u_id = document.getElementById("u_id").textContent;
                console.log(app.addPlate);
                $.ajax({
                    url: "user/addAPlate",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "addPlate": JSON.stringify(app.addPlate),
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPlateListByUId();
                        app.itemKey = Math.random();
                        app.addPlateDrawer = false
                        app.addPlate = ''
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function addAPost() {
                app.addPost.p_u_id = document.getElementById("u_id").textContent;
                console.log(app.addPost);
                $.ajax({
                    url: "user/addAPost",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "addPost": JSON.stringify(app.addPost),
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPostListByUId();
                        app.itemKey = Math.random();
                        app.addPostDrawer = false
                        app.addPost = ''
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

            function putChangeUPassword() {
                console.log(app.u_password.checkPass)
                $.ajax({
                    url: "user/putChangeUPassword",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "u_password": JSON.stringify(app.u_password.checkPass),
                        "u_id": JSON.stringify(document.getElementById("u_id").textContent)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = './logout.jsp'
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function updateAPlate() {
                console.log(app.changePlate)
                $.ajax({
                    url: "user/updateAPlate",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "changePlate": JSON.stringify(app.changePlate)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPlateListByUId();
                        app.itemKey = Math.random();
                        app.changePlateDrawer = false
                        app.changePlate = ''
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function updateAPost() {
                console.log(app.changePost)
                $.ajax({
                    url: "user/updateAPost",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "changePost": JSON.stringify(app.changePost)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPostListByUId();
                        app.itemKey = Math.random();
                        app.changePostDrawer = false
                        app.changePost = ''
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function putUserPhone() {
                console.log(app.changeUserBasic.u_phone)
                $.ajax({
                    url: "user/putUserPhone",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "u_phone": JSON.stringify(app.changeUserBasic.u_phone),
                        "u_id": JSON.stringify(document.getElementById("u_id").textContent)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = './UserCenter.jsp'
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function putUserEmail() {
                console.log(app.changeUserBasic.u_email)
                $.ajax({
                    url: "user/putUserEmail",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "u_email": JSON.stringify(app.changeUserBasic.u_email),
                        "u_id": JSON.stringify(document.getElementById("u_id").textContent)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = './UserCenter.jsp'
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function deleteUser() {
                console.log(document.getElementById("u_id").textContent)
                $.ajax({
                    url: "user/deleteUser",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {"u_id": JSON.stringify(document.getElementById("u_id").textContent)},
                    success: function (reps) {
                        alert(reps.valueOf());
                        window.location.href = './logout.jsp'
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
                        getPlateListByUId();
                        app.itemKey = Math.random();
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function removePost(p_id) {
                console.log(p_id)
                $.ajax({
                    url: "admin/removePost",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "p_id": JSON.stringify(p_id),
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPostListByUId();
                        app.itemKey = Math.random();
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
                        getPlateListByUId();
                        app.itemKey = Math.random();
                    },
                    error: function () {
                        alert('error');
                    }
                })
            }

            function changePostStatus(p_id, tag, p_p_id) {
                $.ajax({
                    url: "admin/changePostStatus",
                    contentType: 'application/json;charset=UTF-8',
                    dataType: "json",
                    data: {
                        "p_id": JSON.stringify(p_id),
                        "tag": JSON.stringify(tag)
                    },
                    success: function (reps) {
                        alert(reps.valueOf());
                        getPostListByPPId(p_p_id);
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
        <div class="param" id="u_id">${userGrade.u_id}</div>
        <div id="app">
            <el-container>
                <el-header>
                    <div id="header-title">
                        <span onclick="window.location.href = './index.jsp'">?????????BBS</span>
                    </div>
                    <div id="nav-left">
                        <ul class="nav-ul">
                            <li><a href="#news">??????</a></li>
                            <li><a href="#contact">??????</a></li>
                            <li><a href="#about">??????</a></li>
                            <li><a href="#about">??????</a></li>
                            <li><a href="#about">??????</a></li>
                            <li><a href="#about">??????</a></li>
                        </ul>
                    </div>
                    <div id="search">
                        <div style="margin-top: 10px;">
                            <el-input placeholder="???????????????" v-model="input" class="input-with-select">
                                <el-select v-model="select" slot="prepend" placeholder="?????????">
                                    <el-option label="??????" value="1"></el-option>
                                    <el-option label="??????" value="2"></el-option>
                                    <el-option label="??????" value="3"></el-option>
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
                                        <%
                                            if (userBasic != null) {
                                        %>
                                        <el-avatar :size="50" src="<%=userBasic.getU_img()%>"></el-avatar>
                                        <%
                                        } else {
                                        %>
                                        <el-avatar :size="50" src=""></el-avatar>
                                        <%
                                            }
                                        %>
                                        <el-dropdown-menu slot="dropdown" style="width: 300px">
                                            <span>?</span>
                                            <el-dropdown-item icon="el-icon-plus" command="a">?????????</el-dropdown-item>
                                            <el-dropdown-item icon="el-icon-circle-plus">?????????</el-dropdown-item>
                                            <el-dropdown-item icon="el-icon-circle-plus-outline">?????????</el-dropdown-item>
                                            <el-dropdown-item icon="el-icon-check">?????????</el-dropdown-item>
                                            <el-dropdown-item icon="el-icon-circle-check">?????????</el-dropdown-item>
                                            <el-divider></el-divider>
                                            <el-dropdown-item icon="el-icon-circle-check"
                                                              onclick="window.location.href='logout.jsp'">??????
                                            </el-dropdown-item>
                                        </el-dropdown-menu>
                                    </el-dropdown>
                                </a>
                            </div>
                            <li><a href="#contact">??????</a></li>
                            <li><a href="#about">??????</a></li>
                            <li><a href="#about">??????</a></li>
                            <li><a href="#about">??????</a></li>
                            <li><a href="#about">??????</a></li>
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
                                        <span slot="title">????????????</span>
                                    </el-menu-item>
                                    <el-menu-item index="2">
                                        <span slot="title">????????????</span>
                                    </el-menu-item>
                                    <el-menu-item index="3">
                                        <span slot="title">????????????</span>
                                    </el-menu-item>
                                    <el-menu-item index="4">
                                        <span slot="title">????????????</span>
                                    </el-menu-item>
                                    <el-menu-item index="5">
                                        <span slot="title">????????????</span>
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
                                                <%
                                                    if (userBasic != null) {
                                                %>
                                                <el-avatar :size="92" src="<%=userBasic.getU_img()%>"></el-avatar>
                                                <%
                                                } else {
                                                %>
                                                <el-avatar :size="92" src=""></el-avatar>
                                                <%
                                                    }
                                                %>
                                            </el-button>
                                            <el-dialog title="????????????" :visible.sync="dialogFormVisible">
                                                <form action="user/fileupload" method="post"
                                                      enctype="multipart/form-data">
                                                    ???????????????<input type="file" name="upload"><br>
                                                    <input type="submit" value="??????">
                                                </form>
                                            </el-dialog>
                                        </div>
                                        <div id="personal_information_div1_uName">${sessionScope.userBasic.u_name}</div>
                                    </div>
                                    <span style="display: block;height: 3px;width: 98%;margin: 24px auto;"><el-divider></el-divider></span>
                                    <div id="personal_information_div2">
                                        <div v-if="personal_information_div2_el_escription==0">
                                            <el-descriptions direction="vertical" class="margin-top" title="????????????"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div2_el_escription=1">??????
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        ????????????
                                                    </template>
                                                    {{userBasic.u_name}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user-solid"></i>
                                                        ??????ID
                                                    </template>
                                                    {{userBasic.u_id}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-male"></i>
                                                        ????????????
                                                    </template>
                                                    {{userBasic.u_gender}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-date"></i>
                                                        ??????????????????
                                                    </template>
                                                    {{userBasic.u_age|dateFilter}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        ?????????
                                                    </template>
                                                    {{userBasic.u_address}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        ????????????
                                                    </template>
                                                    {{userGrade.u_grade|uGradeFilter}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-tickets"></i>
                                                        ????????????
                                                    </template>
                                                    {{userBasic.u_introduction}}
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>
                                        <div v-else>
                                            <el-descriptions direction="vertical" class="margin-top" title="??????????????????"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="putChangeUserBasic()">??????
                                                    </el-button>
                                                </template>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div2_el_escription=0">??????
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        ????????????
                                                    </template>
                                                    <el-input
                                                            placeholder="???????????????"
                                                            v-model="changeUserBasic.u_name"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-male"></i>
                                                        ????????????
                                                    </template>
                                                    <el-select v-model="changeUserBasic.u_gender" clearable
                                                               placeholder="?????????">
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
                                                        ??????????????????
                                                    </template>
                                                    <el-date-picker
                                                            v-model="changeUserBasic.u_age"
                                                            type="date"
                                                            value-format="yyyy-MM-dd"
                                                            placeholder="????????????">
                                                    </el-date-picker>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        ?????????
                                                    </template>
                                                    <el-input
                                                            placeholder="???????????????"
                                                            v-model="changeUserBasic.u_address"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-tickets"></i>
                                                        ????????????
                                                    </template>
                                                    <el-input
                                                            type="textarea"
                                                            placeholder="???????????????"
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
                                            <el-descriptions direction="vertical" class="margin-top" title="????????????"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div3_el_escription=1">??????
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        ????????????
                                                    </template>
                                                    {{userSchool.u_school_name}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user-solid"></i>
                                                        ??????
                                                    </template>
                                                    {{userSchool.u_school_profession}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-male"></i>
                                                        ????????????
                                                    </template>
                                                    {{userSchool.u_school_start}}???{{userSchool.u_school_end}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-date"></i>
                                                        ??????
                                                    </template>
                                                    {{userSchool.u_school_education}}
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>
                                        <div v-else>
                                            <el-descriptions direction="vertical" class="margin-top" title="??????????????????"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="putChangeUserSchool()">??????
                                                    </el-button>
                                                </template>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div3_el_escription=0">??????
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        ????????????
                                                    </template>
                                                    <el-input
                                                            placeholder="???????????????"
                                                            v-model="changeUserSchool.u_school_name"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        ??????
                                                    </template>
                                                    <el-input
                                                            placeholder="???????????????"
                                                            v-model="changeUserSchool.u_school_profession"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-date"></i>
                                                        ????????????
                                                    </template>
                                                    <el-date-picker
                                                            v-model="changeUserSchool.u_school_start"
                                                            type="date"
                                                            value-format="yyyy-MM-dd"
                                                            placeholder="????????????">
                                                    </el-date-picker>
                                                    ???
                                                    <el-date-picker
                                                            v-model="changeUserSchool.u_school_end"
                                                            type="date"
                                                            value-format="yyyy-MM-dd"
                                                            placeholder="????????????">
                                                    </el-date-picker>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-tickets"></i>
                                                        ??????
                                                    </template>
                                                    <el-input
                                                            placeholder="???????????????"
                                                            v-model="changeUserSchool.u_school_education"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>

                                    </div>
                                    <div id="personal_information_div4">
                                        <div v-if="personal_information_div4_el_escription==0">
                                            <el-descriptions direction="vertical" class="margin-top" title="????????????"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div4_el_escription=1">??????
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        ????????????
                                                    </template>
                                                    {{userCompany.u_company_name}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user-solid"></i>
                                                        ????????????
                                                    </template>
                                                    {{userCompany.u_company_posts}}
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-male"></i>
                                                        ????????????
                                                    </template>
                                                    {{userCompany.u_company_industry}}
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>
                                        <div v-else>
                                            <el-descriptions direction="vertical" class="margin-top" title="??????????????????"
                                                             :column="3" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="putChangeUserCompany()">??????
                                                    </el-button>
                                                </template>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small"
                                                               @click="personal_information_div4_el_escription=0">??????
                                                    </el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-user"></i>
                                                        ????????????
                                                    </template>
                                                    <el-input
                                                            placeholder="???????????????"
                                                            v-model="changeUserCompany.u_company_name"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        ????????????
                                                    </template>
                                                    <el-input
                                                            placeholder="???????????????"
                                                            v-model="changeUserCompany.u_company_posts"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        <i class="el-icon-location-outline"></i>
                                                        ????????????
                                                    </template>
                                                    <el-input
                                                            placeholder="???????????????"
                                                            v-model="changeUserCompany.u_company_industry"
                                                            clearable>
                                                    </el-input>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </div>

                                    </div>
                                    <div id="personal_information_div5">
                                        <el-descriptions class="margin-top" title="????????????"
                                                         :column="1" border>
                                            <el-descriptions-item>
                                                <template slot="label">
                                                    <i class="el-icon-user"></i>
                                                    ?????????
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
                                                    ????????????
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
                                    <div id="account_settings_div">
                                        <span style="font-size: 16px;font-weight: 700">????????????</span>
                                        <div style="margin-bottom: 20px"></div>
                                        <div id="account_settings_div1">
                                            <el-row>
                                                <el-col :span="12">
                                                    <div class="grid-content bg-purple">??????</div>
                                                </el-col>
                                                <el-col :span="12">
                                                    <div class="grid-content bg-purple-light">
                                                        <span style="margin-right: 20px">??????????????????????????????</span>
                                                        <el-popover
                                                                placement="right"
                                                                width="400"
                                                                trigger="click">
                                                            <el-form :model="u_password" status-icon
                                                                     :rules="u_password_rules"
                                                                     ref="u_password" label-width="100px"
                                                                     class="demo-ruleForm">
                                                                <el-form-item label="??????" prop="pass">
                                                                    <el-input type="password" v-model="u_password.pass"
                                                                              autocomplete="off"></el-input>
                                                                </el-form-item>
                                                                <el-form-item label="????????????" prop="checkPass">
                                                                    <el-input type="password"
                                                                              v-model="u_password.checkPass"
                                                                              autocomplete="off"></el-input>
                                                                </el-form-item>
                                                                <el-form-item>
                                                                    <el-button type="primary"
                                                                               @click="u_password_submitForm('u_password')">
                                                                        ??????
                                                                    </el-button>
                                                                    <el-button
                                                                            @click="resetForm('u_password')">
                                                                        ??????
                                                                    </el-button>
                                                                </el-form-item>
                                                            </el-form>
                                                            <el-button slot="reference">????????????</el-button>
                                                        </el-popover>
                                                    </div>
                                                </el-col>
                                            </el-row>
                                        </div>
                                        <div id="account_settings_div2">
                                            <el-row>
                                                <el-col :span="12">
                                                    <div class="grid-content bg-purple">??????</div>
                                                </el-col>
                                                <el-col :span="12">
                                                    <div class="grid-content bg-purple-light">
                                                        <span style="margin-right: 20px">{{userBasic.u_phone}}</span>
                                                        <el-popover
                                                                placement="right"
                                                                width="400"
                                                                trigger="click">
                                                            <el-form :model="changeUserBasic" status-icon
                                                                     ref="changeUserBasic" label-width="100px"
                                                                     class="demo-ruleForm">
                                                                <el-form-item label="??????">
                                                                    <el-input
                                                                            v-model="changeUserBasic.u_phone"></el-input>
                                                                </el-form-item>
                                                                <el-form-item>
                                                                    <el-button type="primary"
                                                                               @click="putUserPhone()">
                                                                        ??????
                                                                    </el-button>
                                                                </el-form-item>
                                                            </el-form>
                                                            <el-button slot="reference">????????????</el-button>
                                                        </el-popover>
                                                    </div>
                                                </el-col>
                                            </el-row>
                                        </div>
                                        <div id="account_settings_div3">
                                            <el-row>
                                                <el-col :span="12">
                                                    <div class="grid-content bg-purple">??????</div>
                                                </el-col>
                                                <el-col :span="12">
                                                    <div class="grid-content bg-purple-light">
                                                        <span style="margin-right: 20px">{{userBasic.u_email}}</span>
                                                        <el-popover
                                                                placement="right"
                                                                width="400"
                                                                trigger="click">
                                                            <el-form :model="changeUserBasic" status-icon
                                                                     ref="changeUserBasic" label-width="100px"
                                                                     class="demo-ruleForm">
                                                                <el-form-item label="??????">
                                                                    <el-input
                                                                            v-model="changeUserBasic.u_email"></el-input>
                                                                </el-form-item>
                                                                <el-form-item>
                                                                    <el-button type="primary"
                                                                               @click="putUserEmail()">
                                                                        ??????
                                                                    </el-button>
                                                                </el-form-item>
                                                            </el-form>
                                                            <el-button slot="reference">????????????</el-button>
                                                        </el-popover>
                                                    </div>
                                                </el-col>
                                            </el-row>
                                        </div>
                                        <div id="account_settings_div4">
                                            <el-row>
                                                <el-col :span="12">
                                                    <div class="grid-content bg-purple">????????????</div>
                                                </el-col>
                                                <el-col :span="12">
                                                    <div class="grid-content bg-purple-light">
                                                        <el-popconfirm
                                                                confirm-button-text='??????'
                                                                cancel-button-text='?????????'
                                                                icon="el-icon-info"
                                                                icon-color="red"
                                                                @confirm="deleteUser()"
                                                                title="???????????????????????????"
                                                        >
                                                            <el-button slot="reference">????????????</el-button>
                                                        </el-popconfirm>
                                                    </div>
                                                </el-col>
                                            </el-row>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div v-show="index==3">3</div>
                            <div v-show="index==4">4</div>
                            <div v-show="index==5">
                                <div id="content_management">
                                    <el-tabs type="border-card">
                                        <el-tab-pane label="??????">
                                            <div id="post_manage">
                                                <div id="addPost_addButton">
                                                    <el-button type="primary" onclick="app.addPostDrawer=true">????????????
                                                    </el-button>
                                                </div>
                                                <div id="addPost_addPanel">
                                                    <el-drawer
                                                            title="????????????"
                                                            :visible.sync="addPostDrawer"
                                                            :direction="direction">
                                                        <div id="addPost_addPanel_drawer">
                                                            <el-form :label-position="labelPosition"
                                                                     label-width="100px"
                                                                     :model="addPost">
                                                                <el-form-item label="????????????">
                                                                    <el-input v-model="addPost.p_title"
                                                                              placeholder="???????????????"></el-input>
                                                                </el-form-item>
                                                                <el-form-item label="??????????????????">
                                                                    <el-select v-model="addPost.p_p_id"
                                                                               placeholder="?????????">
                                                                        <el-option
                                                                                v-for="item in plateListAll"
                                                                                :key="item.p_id"
                                                                                :label="item.p_name"
                                                                                :value="item.p_id"
                                                                                :disabled="item.p_status==1 ? true : false">
                                                                        </el-option>
                                                                    </el-select>
                                                                </el-form-item>
                                                                <el-form-item label="??????????????????">
                                                                    <el-radio-group v-model="addPost.p_tag">
                                                                        <el-radio :label="0">??????</el-radio>
                                                                        <el-radio :label="1">??????</el-radio>
                                                                        <el-radio :label="2">??????</el-radio>
                                                                    </el-radio-group>
                                                                </el-form-item>
                                                                <el-form-item label="????????????">
                                                                    <el-input type="textarea"
                                                                              placeholder="???????????????"
                                                                              maxlength="1000"
                                                                              show-word-limit
                                                                              v-model="addPost.p_content"></el-input>
                                                                </el-form-item>
                                                                <el-button type="primary" @click="addAPost">????????????
                                                                </el-button>
                                                            </el-form>
                                                        </div>
                                                    </el-drawer>
                                                </div>
                                                <div id="post_list">
                                                    <el-table
                                                            ref="postList"
                                                            :data="postList.slice((postListPage.currentPage-1)*postListPage.pageSize,postListPage.currentPage*postListPage.pageSize)"
                                                            :key="itemKey">
                                                        <el-table-column
                                                                type="index"
                                                                width="40">
                                                        </el-table-column>
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_title"
                                                                label="????????????"
                                                                width="120">
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_p_id"
                                                                label="????????????"
                                                                width="100"
                                                                :formatter="p_p_idFormatter">
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_comment_count"
                                                                label="??????????????????"
                                                                width="110">
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_browse_count"
                                                                label="??????????????????"
                                                                width="110">
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_thumbs_count"
                                                                label="??????????????????"
                                                                width="110">
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_time"
                                                                label="??????????????????"
                                                                width="140">
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_tag"
                                                                label="????????????"
                                                                width="80">
                                                            <template slot-scope="scope">
                                                                <el-tag>
                                                                    {{scope.row.p_tag|tagFormatter}}
                                                                </el-tag>
                                                            </template>
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_nice"
                                                                label="????????????"
                                                                width="80">
                                                            <template slot-scope="scope">
                                                                <el-tag>
                                                                    {{scope.row.p_nice|niceFormatter}}
                                                                </el-tag>
                                                            </template>
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_status"
                                                                label="????????????"
                                                                width="90"
                                                                :filters="[{ text: '??????', value: '0' }, { text: '??????', value: '1' },{ text: '??????', value: '2' }]"
                                                                :filter-method="plateListFilterPStatus"
                                                                filter-placement="bottom-end">
                                                            <template slot-scope="scope">
                                                                <el-tag
                                                                        :type="scope.row.p_status == '0' ? 'success' : 'danger'"
                                                                        disable-transitions>
                                                                    {{scope.row.p_status|statusFormatter}}
                                                                </el-tag>
                                                            </template>
                                                        </el-table-column>
                                                        <el-table-column label="??????">
                                                            <template slot-scope="scope" width="100">
                                                                <el-button
                                                                        size="mini"
                                                                        @click="app.changePostDrawer=true;app.changePost=scope.row">
                                                                    ??????
                                                                </el-button>
                                                                <el-button
                                                                        size="mini"
                                                                        type="danger"
                                                                        @click="removePost(scope.row.p_id)">??????
                                                                </el-button>
                                                                <el-button
                                                                        size="mini"
                                                                        @click="window.location.href='Message.jsp?p_id='+scope.row.p_id">
                                                                    ??????
                                                                </el-button>
                                                            </template>
                                                        </el-table-column>
                                                    </el-table>
                                                    <el-drawer
                                                            title="????????????"
                                                            :visible.sync="changePostDrawer"
                                                            :direction="direction">
                                                        <div id="post_list_drawer">
                                                            <el-form :label-position="labelPosition"
                                                                     label-width="100px"
                                                                     :model="changePost">
                                                                <el-form-item label="????????????">
                                                                    <el-input v-model="changePost.p_title"
                                                                              placeholder="???????????????"></el-input>
                                                                </el-form-item>
                                                                <el-form-item label="??????????????????">
                                                                    <el-select v-model="changePost.p_p_id"
                                                                               placeholder="?????????">
                                                                        <el-option
                                                                                v-for="item in plateListAll"
                                                                                :key="item.p_id"
                                                                                :label="item.p_name"
                                                                                :value="item.p_id"
                                                                                :disabled="item.p_status==1 ? true : false">
                                                                        </el-option>
                                                                    </el-select>
                                                                </el-form-item>
                                                                <el-form-item label="??????????????????">
                                                                    <el-radio-group v-model="changePost.p_tag">
                                                                        <el-radio :label="0">??????</el-radio>
                                                                        <el-radio :label="1">??????</el-radio>
                                                                        <el-radio :label="2">??????</el-radio>
                                                                    </el-radio-group>
                                                                </el-form-item>
                                                                <el-form-item label="????????????">
                                                                    <el-input type="textarea"
                                                                              placeholder="???????????????"
                                                                              maxlength="1000"
                                                                              show-word-limit
                                                                              v-model="changePost.p_content"></el-input>
                                                                </el-form-item>
                                                                <el-button type="primary" @click="updateAPost">????????????
                                                                </el-button>
                                                            </el-form>
                                                        </div>
                                                    </el-drawer>
                                                    <div class="block" style="margin-top:15px;">
                                                        <el-pagination
                                                                @size-change="handleSizeChange3"
                                                                @current-change="handleCurrentChange3"
                                                                :current-page.sync="postListPage.currentPage"
                                                                :page-sizes="[5, 10, 15, 20, 25]"
                                                                :page-size="postListPage.pageSize"
                                                                layout="total, sizes, prev, pager, next, jumper"
                                                                :total="postListPage.total">
                                                        </el-pagination>
                                                    </div>
                                                </div>
                                            </div>
                                        </el-tab-pane>
                                        <el-tab-pane label="??????" <%if (userGrade.getU_grade() == 0){%>disabled<%}%>>
                                            <div id="plate_manage">
                                                <div id="addPlate">
                                                    <div id="addPlate_addButton">
                                                        <el-button type="primary" onclick="app.addPlateDrawer=true">
                                                            ????????????
                                                        </el-button>
                                                    </div>
                                                    <div id="addPlate_addPanel">
                                                        <el-drawer
                                                                title="????????????"
                                                                :visible.sync="addPlateDrawer"
                                                                :direction="direction">
                                                            <div id="addPlate_addPanel_drawer">
                                                                <el-form :label-position="labelPosition"
                                                                         label-width="100px"
                                                                         :model="addPlate">
                                                                    <el-form-item label="????????????">
                                                                        <el-input v-model="addPlate.p_name"
                                                                                  placeholder="???????????????"></el-input>
                                                                    </el-form-item>
                                                                    <el-form-item label="????????????">
                                                                        <el-input type="textarea"
                                                                                  placeholder="???????????????"
                                                                                  maxlength="30"
                                                                                  show-word-limit
                                                                                  v-model="addPlate.p_description"></el-input>
                                                                    </el-form-item>
                                                                    <el-button type="primary" @click="addAPlate">????????????
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
                                                                label="????????????"
                                                                width="120">
                                                        </el-table-column>
                                                        <el-table-column
                                                                label="????????????"
                                                                width="120">
                                                            {{userBasic.u_name}}
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_p_count"
                                                                label="??????????????????"
                                                                width="120">
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_comment_count"
                                                                label="??????????????????"
                                                                width="120">
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_description"
                                                                label="????????????"
                                                                width="300">
                                                        </el-table-column>
                                                        <el-table-column
                                                                prop="p_status"
                                                                label="????????????"
                                                                width="100"
                                                                :filters="[{ text: '??????', value: '0' }, { text: '??????', value: '1' },{ text: '??????', value: '2' }]"
                                                                :filter-method="plateListFilterPStatus"
                                                                filter-placement="bottom-end">
                                                            <template slot-scope="scope">
                                                                <el-tag
                                                                        :type="scope.row.p_status == '0' ? 'success' : 'danger'"
                                                                        disable-transitions>
                                                                    {{scope.row.p_status|statusFormatter}}
                                                                </el-tag>
                                                            </template>
                                                        </el-table-column>
                                                        <el-table-column label="????????????" width="100">
                                                            <template slot-scope="scope">
                                                                <el-button
                                                                        v-if="scope.row.p_status==1"
                                                                        size="mini"
                                                                        @click="p_statusUnlock(scope.$index, scope.row)">
                                                                    ??????
                                                                </el-button>
                                                                <el-button
                                                                        v-else-if="scope.row.p_status==0"
                                                                        size="mini"
                                                                        type="danger"
                                                                        @click="p_statusClock(scope.$index, scope.row)">
                                                                    ??????
                                                                </el-button>
                                                            </template>
                                                        </el-table-column>
                                                        <el-table-column label="??????">
                                                            <template slot-scope="scope" width="100">
                                                                <el-button
                                                                        size="mini"
                                                                        @click="app.changePlateDrawer=true;app.changePlate=scope.row">
                                                                    ??????
                                                                </el-button>
                                                                <el-button
                                                                        size="mini"
                                                                        type="danger"
                                                                        @click="removePlate(scope.row.p_id)">??????
                                                                </el-button>
                                                                <el-button
                                                                        size="mini"
                                                                        @click="app.checkPostDrawer=true;getPostListByPPId(scope.row.p_id)">
                                                                    ??????
                                                                </el-button>
                                                            </template>
                                                        </el-table-column>
                                                    </el-table>
                                                    <el-drawer
                                                            title="????????????"
                                                            :visible.sync="changePlateDrawer"
                                                            :direction="direction">
                                                        <div id="plate_list_drawer">
                                                            <el-form :label-position="labelPosition" label-width="100px"
                                                                     :model="changePlate">
                                                                <el-form-item label="????????????">
                                                                    <el-input v-model="changePlate.p_name"
                                                                              placeholder="???????????????"></el-input>
                                                                </el-form-item>
                                                                <el-form-item label="????????????">
                                                                    <el-input type="textarea"
                                                                              placeholder="???????????????"
                                                                              maxlength="30"
                                                                              show-word-limit
                                                                              v-model="changePlate.p_description"></el-input>
                                                                </el-form-item>
                                                                <el-button type="primary" @click="updateAPlate">????????????
                                                                </el-button>
                                                            </el-form>
                                                        </div>
                                                    </el-drawer>
                                                    <el-drawer
                                                            title="????????????"
                                                            :visible.sync="checkPostDrawer"
                                                            :direction="direction"
                                                            :size="1400">
                                                        <div id="checkPost_list_drawer">
                                                            <el-table
                                                                    ref="postListByPPId"
                                                                    :data="postListByPPId.slice((postListByPPIdPage.currentPage-1)*postListByPPIdPage.pageSize,postListByPPIdPage.currentPage*postListByPPIdPage.pageSize)"
                                                                    :key="itemKey">
                                                                <el-table-column
                                                                        type="index"
                                                                        width="40">
                                                                </el-table-column>
                                                                </el-table-column>
                                                                <el-table-column
                                                                        prop="p_title"
                                                                        label="????????????"
                                                                        width="120">
                                                                </el-table-column>
                                                                <el-table-column
                                                                        prop="p_p_id"
                                                                        label="????????????"
                                                                        width="100"
                                                                        :formatter="p_p_idFormatter">
                                                                </el-table-column>
                                                                <el-table-column
                                                                        prop="p_comment_count"
                                                                        label="??????????????????"
                                                                        width="110">
                                                                </el-table-column>
                                                                <el-table-column
                                                                        prop="p_browse_count"
                                                                        label="??????????????????"
                                                                        width="110">
                                                                </el-table-column>
                                                                <el-table-column
                                                                        prop="p_thumbs_count"
                                                                        label="??????????????????"
                                                                        width="110">
                                                                </el-table-column>
                                                                <el-table-column
                                                                        prop="p_time"
                                                                        label="??????????????????"
                                                                        width="140">
                                                                </el-table-column>
                                                                <el-table-column
                                                                        prop="p_tag"
                                                                        label="????????????"
                                                                        width="80">
                                                                    <template slot-scope="scope">
                                                                        <el-tag>
                                                                            {{scope.row.p_tag|tagFormatter}}
                                                                        </el-tag>
                                                                    </template>
                                                                </el-table-column>
                                                                <el-table-column
                                                                        prop="p_nice"
                                                                        label="????????????"
                                                                        width="80">
                                                                    <template slot-scope="scope">
                                                                        <el-tag>
                                                                            {{scope.row.p_nice|niceFormatter}}
                                                                        </el-tag>
                                                                    </template>
                                                                </el-table-column>
                                                                <el-table-column
                                                                        prop="p_status"
                                                                        label="????????????"
                                                                        width="90"
                                                                        :filters="[{ text: '??????', value: '0' }, { text: '??????', value: '1' },{ text: '??????', value: '2' }]"
                                                                        :filter-method="plateListFilterPStatus"
                                                                        filter-placement="bottom-end">
                                                                    <template slot-scope="scope">
                                                                        <el-tag
                                                                                :type="scope.row.p_status == '0' ? 'success' : 'danger'"
                                                                                disable-transitions>
                                                                            {{scope.row.p_status|statusFormatter}}
                                                                        </el-tag>
                                                                    </template>
                                                                </el-table-column>
                                                                <el-table-column label="??????" width="200">
                                                                    <template slot-scope="scope">
                                                                        <div v-if="scope.row.p_status==2">
                                                                            <el-button
                                                                                    size="mini"
                                                                                    @click="post_statusUnlock(scope.$index, scope.row)">
                                                                                ??????
                                                                            </el-button>
                                                                            <el-button
                                                                                    size="mini"
                                                                                    type="danger"
                                                                                    @click="post_statusClock(scope.$index, scope.row)">
                                                                                ?????????
                                                                            </el-button>
                                                                        </div>
                                                                        <div v-else>
                                                                            <el-button
                                                                                    v-if="scope.row.p_status==1"
                                                                                    size="mini"
                                                                                    @click="post_statusUnlock(scope.$index, scope.row)">
                                                                                ??????
                                                                            </el-button>
                                                                            <el-button
                                                                                    v-else-if="scope.row.p_status==0"
                                                                                    size="mini"
                                                                                    type="danger"
                                                                                    @click="post_statusClock(scope.$index, scope.row)">
                                                                                ??????
                                                                            </el-button>
                                                                        </div>
                                                                    </template>
                                                                </el-table-column>
                                                                <el-table-column label="??????" width="200">
                                                                    <template slot-scope="scope">
                                                                        <el-button
                                                                                size="mini"
                                                                                type="danger"
                                                                                @click="removePost(scope.row.p_id)">
                                                                            ??????
                                                                        </el-button>
                                                                        <el-button
                                                                                size="mini"
                                                                                @click="window.location.href='Message.jsp?p_id='+scope.row.p_id">
                                                                            ??????
                                                                        </el-button>
                                                                    </template>
                                                                </el-table-column>
                                                            </el-table>
                                                            <div class="block" style="margin-top:15px;">
                                                                <el-pagination
                                                                        @size-change="handleSizeChange4"
                                                                        @current-change="handleCurrentChange4"
                                                                        :current-page.sync="postListByPPIdPage.currentPage"
                                                                        :page-sizes="[5, 10, 15, 20, 25]"
                                                                        :page-size="postListByPPIdPage.pageSize"
                                                                        layout="total, sizes, prev, pager, next, jumper"
                                                                        :total="postListByPPIdPage.total">
                                                                </el-pagination>
                                                            </div>
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
                                        </el-tab-pane>
                                    </el-tabs>
                                </div>
                            </div>
                        </el-main>
                        <el-footer>
                            <div id="el-footer-detial">&copy; 2022 ???????????? | Design by ?????????</div>
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
                var u_passwordPass = (rule, value, callback) => {
                    if (value === '') {
                        callback(new Error('???????????????'));
                    } else {
                        if (this.u_password.checkPass !== '') {
                            this.$refs.u_password.validateField('checkPass');
                        }
                        callback();
                    }
                };
                var u_passwordPass2 = (rule, value, callback) => {
                    if (value === '') {
                        callback(new Error('?????????????????????'));
                    } else if (value !== this.u_password.pass) {
                        callback(new Error('???????????????????????????!'));
                    } else {
                        callback();
                    }
                };
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
                    userGrade: {
                        u_id: <%=userGrade.getU_id()%>,
                        u_password: <%=userGrade.getU_password()%>,
                        u_grade: <%=userGrade.getU_grade()%>,
                        u_status: <%=userGrade.getU_status()%>,
                    },
                    u_password: {
                        pass: '',
                        checkPass: '',
                    },
                    u_password_rules: {
                        pass: [
                            {validator: u_passwordPass, trigger: 'blur'}
                        ],
                        checkPass: [
                            {validator: u_passwordPass2, trigger: 'blur'}
                        ],
                    },
                    userBasic: {
                        u_id: '',
                        u_name: '',
                        u_gender: '',
                        u_age: '',
                        u_introduction: '',
                        u_address: '',
                        u_phone: '',
                        u_email: '',
                    },
                    changeUserBasic: {
                        u_id: '',
                        u_name: '',
                        u_gender: '',
                        u_age: '',
                        u_introduction: '',
                        u_address: '',
                        u_phone: '',
                        u_email: '',
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
                        value: '???',
                        label: '???'
                    }, {
                        value: '???',
                        label: '???'
                    }, {
                        value: '??????',
                        label: '??????'
                    },],
                    addPost: {
                        p_title: '',
                        p_content: '',
                        p_u_id: '',
                        p_p_id: '',
                        p_tag: '',
                    },
                    changePost: {
                        p_title: '',
                        p_content: '',
                        p_u_id: '',
                        p_p_id: '',
                        p_tag: '',
                    },
                    addPlate: {
                        p_id: '',
                        p_name: '',
                        p_p_count: '',
                        p_comment_count: '',
                        p_description: '',
                        p_u_id: '',
                    },
                    plateList: [{
                        p_id: '',
                        p_name: '',
                        p_p_count: '',
                        p_comment_count: '',
                        p_description: '',
                        p_u_id: '',
                        p_status: '',
                    },],
                    plateListAll: [{
                        p_id: '',
                        p_name: '',
                        p_p_count: '',
                        p_comment_count: '',
                        p_description: '',
                        p_u_id: '',
                        p_status: '',
                    },],
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
                    postListByPPId: [{
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
                    postListPage: {
                        currentPage: 1,
                        total: '',
                        pageSize: 10,
                    },
                    postListByPPIdPage: {
                        currentPage: 1,
                        total: '',
                        pageSize: 10,
                    },
                    direction: 'rtl',
                    drawer: false,
                    labelPosition: 'left',
                    itemKey: 1,
                    addPlateDrawer: false,
                    addPostDrawer: false,
                    changePlateDrawer: false,
                    changePostDrawer: false,
                    checkPostDrawer: false,

                }
            },
            filters: {
                dateFilter(value) {
                    var date = new Date(value);//????????????10??????*1000???????????????13??????????????????1000
                    Y = date.getFullYear() + '-';
                    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
                    D = date.getDate() + ' ';
                    return Y + M + D;
                },
                uGradeFilter(value) {
                    if (value === 0)
                        return '????????????'
                    else
                        return '????????????'
                },
                statusFormatter(value) {
                    if (value == 0)
                        return '??????'
                    else if (value == 1)
                        return '??????'
                    else
                        return '??????'
                },
                tagFormatter(value) {
                    if (value == 0)
                        return '??????'
                    else if (value == 1)
                        return '??????'
                    else
                        return '??????'
                },
                niceFormatter(value) {
                    if (value == 0)
                        return '??????'
                    else
                        return '??????'
                },
            },
            methods: {
                handleCommand(command) {
//????????????????????????
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
                },
                u_password_submitForm(formName) {
                    this.$refs[formName].validate((valid) => {
                        if (valid) {
                            putChangeUPassword();
                        } else {
                            console.log('error submit!!');
                            return false;
                        }
                    });
                },
                resetForm(formName) {
                    this.$refs[formName].resetFields();
                },
                handleSizeChange2(val) {
                    console.log(`?????? ${val} ???`);
                    this.plateListPage.currentPage = 1;
                    this.plateListPage.pageSize = val;
                },
                handleCurrentChange2(val) {
                    console.log(`?????????: ${val}`);
                    this.plateListPage.currentPage = val;
                },
                handleSizeChange3(val) {
                    console.log(`?????? ${val} ???`);
                    this.postListPage.currentPage = 1;
                    this.postListPage.pageSize = val;
                },
                handleCurrentChange3(val) {
                    console.log(`?????????: ${val}`);
                    this.postListPage.currentPage = val;
                },
                handleSizeChange4(val) {
                    console.log(`?????? ${val} ???`);
                    this.postListByPPIdPage.currentPage = 1;
                    this.postListByPPIdPage.pageSize = val;
                },
                handleCurrentChange4(val) {
                    console.log(`?????????: ${val}`);
                    this.postListByPPIdPage.currentPage = val;
                },
                plateListFilterPStatus(value, row) {
                    return row.p_status == value;
                },
                p_statusUnlock(index, row) {
                    changePStatus(row.p_id, 0);
                },
                p_statusClock(index, row) {
                    changePStatus(row.p_id, 1);
                },
                post_statusUnlock(index, row) {
                    changePostStatus(row.p_id, 0, row.p_p_id);
                },
                post_statusClock(index, row) {
                    changePostStatus(row.p_id, 1, row.p_p_id);
                },
                p_p_idFormatter(row, column) {
                    for (let item of app.plateListAll) {
                        if (row.p_p_id == item.p_id) {
                            console.log(item)
                            return item.p_name
                        }
                    }
                },
            },
            created: function () {
                getUserBasic();
                getUserSchool();
                getUserCompany();
                getUserInterestLike();
                getUserInterestDislike();
                getPlateListByUId();
                getPlateListAll();
                getPostListByUId();
            }
        })
    </script>
</html>

