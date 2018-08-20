<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/9 0009
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>办公管理系统</title>

</head>

<script src="<%=request.getContextPath()%>/js/js/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/js/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/js/fonts/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/js/css/animate.min.css" rel="stylesheet">
<!-- Custom styling plus plugins -->
<link href="<%=request.getContextPath()%>/js/css/custom.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/css/maps/jquery-jvectormap-2.0.1.css" />
<link href="<%=request.getContextPath()%>/js/css/icheck/flat/green.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/js/css/floatexamples.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootStrap-addTabs/bootstrap.addtabs.css">
<script src="<%=request.getContextPath()%>/js/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap-treeview/bootstrap-treeview.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap-table/dist/bootstrap-table.css">
<script src="<%=request.getContextPath()%>/js/bootstrap-table/dist/bootstrap-table.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-table/dist/locale/bootstrap-table-zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-treeview/bootstrap-treeview.min.js"></script>

<body  class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">

                <div class="navbar nav_title" style="border: 0;">
                    <a href="index.html" class="site_title"><i class="fa fa-paw"></i><span>办公管理软件</span></a>
                </div>
                <div class="clearfix"></div>
                <!-- menu prile quick info -->
                <div class="profile">
                    <div class="profile_pic">
                        <img src=${loginUser.userimg} width="80px" height="60px" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>${loginUser.username}</span>
                    </div>
                </div>
                <!-- /menu prile quick info -->
                <br />

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                    <div class="menu_section">
                        <h2>超级管理员</h2>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> 代办事务 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a  href="javascript:tiaozhuan('代办事务','caoxin/show')">代办事务</a>
                                    </li>
                                    <li><a href="index2.html">所有提醒</a>
                                    </li>
                                    <li><a href="index3.html">我的日程</a>
                                    </li>
                                </ul>
                            </li>

                            <li><a><i class="fa fa-edit"></i>个人考勤<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="form.html">上下班登录</a></li>
                                    <li><a href="form_validation.html">我的考勤管理</a>
                                    </li>
                                    <li><a href="form_wizards.html">加班登记</a>
                                    </li>
                                    <li><a href="form_upload.html">出差登记</a>
                                    </li>
                                    <li><a href="javascript:tiaozhuan('发起申请','modle/queryListWorkName')">发起申请</a>
                                    </li>
                                    <li><a href="form_buttons.html">外出登记</a>
                                    </li>
                                    <li><a href="form_buttons.html">补卡登记</a>
                                    </li>
                                </ul>
                            </li>

                            <li><a><i class="fa fa-desktop"></i>考勤管理<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="general_elements.html">考勤机记录查看</a>
                                    </li>
                                    <li><a href="media_gallery.html">考勤记录</a>
                                    </li>
                                    <li><a href="typography.html">在岗状态</a>
                                    </li>
                                    <li><a href="icons.html">考勤统计</a>
                                    </li>
                                    <li><a href="glyphicons.html">考勤设置</a>
                                    </li>
                                    <li><a href="widgets.html">排班设置</a>
                                    </li>
                                    <li><a href="invoice.html">假期设置</a>
                                    </li>
                                    <li><a href="inbox.html">设置考勤人员</a>
                                    </li>
                                    <li><a href="calender.html">考勤地点设置</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-table"></i> 工作报表 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a href="javascript:tiaozhuan('查看工作流报表','modle/buzhi')">查看工作流报表</a></li>
                                    <li><a href="tables.html">工作报表</a></li>
                                    <li><a href="tables.html">报表管理</a></li>
                                    <li><a href="javascript:login()">登录注册</a></li>
                                </ul>
                            </li>

                            <li><a><i class="fa fa-bar-chart-o"></i> 工作流程<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu" style="display: none">
                                    <li><a> 流程办理 <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu" style="display: none">
                                            <li><a href="tables.html">流程发起</a></li>
                                            <li><a href="javascript:tiaozhuan('草稿箱','caoxin/show')">草稿箱</a></li>
                                            <li><a href="tables.html">代办流程</a></li>
                                            <li><a href="javascript:tiaozhuan('审核流程','caoxin/shenhe')">审核流程</a></li>
                                            <li><a href="tables.html">工作委托</a></li>
                                            <li><a href="javascript:tiaozhuan('我的申请','caoxin/shenqing')">我的申请</a></li>
                                            <li><a href="javascript:tiaozhuan('召回记录','caoxin/bohui')">召回记录</a></li>
                                        </ul>
                                    </li>
                                    <li><a> 流程管理 <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu" style="display: none">
                                            <li><a href="tables.html">流程管理</a></li>
                                            <li><a href="tables.html">办理时限管理</a></li>
                                            <li><a href="tables.html">委托管理</a></li>

                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
            </div>
        </div>
    </div>
        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav class="" role="navigation">
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <img src=${loginUser.userimg} alt="">个人中心
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                <li><a href="javascript:geren();">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>个人信息
                                </a>
                                </li>
                                <li><a href="javascript:dengchu()"><i class="fa fa-sign-out pull-right"></i>登出</a>
                                </li>
                            </ul>
                        </li>

                        <li role="presentation" class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">❗</span>
                            </a>
                            <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                <li>
                                    <a>
                                            <span class="image">
                                        <img src=${loginUser.userimg}>
                                    </span>
                                        <span>
                                        <span>${loginUser.username}</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                        <span class="message">
                                    </span>
                                    </a>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </nav>
            </div>

        </div>

        <div class="right_col" role="main">
            <div class="row">
                <!-- 右边功能区 -->
                <div class="tab-pane active"   >
                    <!-- 新选项卡 -->
                    <ul class="nav nav-tabs" id="tablist">
                        <li role="presentation" class="active">
                            <a href="#home" role="tab" data-toggle="tab">我的首页</a>

                        </li>
                    </ul>
                    <!-- 选项卡下内容 -->
                    <div class="tab-content">
                        <div role="tabpanel"class="tab-pane active"id="home">
                            <br />
                            <div class="">

                                <div class="row top_tiles"  >
                                    <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12" onclick="jinji()" >
                                        <div class="tile-stats" >
                                            <div class="icon"><i class="fa fa-caret-square-o-right"></i>
                                            </div>
                                            <div class="count">179</div>
                                            <h3>紧急流程</h3>
                                            <p>紧急事务请快速解决</p>
                                        </div>
                                    </div>
                                    <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12" onclick="zhongyao()">
                                        <div class="tile-stats">
                                            <div class="icon"><i class="fa fa-comments-o"></i>
                                            </div>
                                            <div class="count">179</div>

                                            <h3>重要流程</h3>
                                            <p>Lorem ipsum psdea itgum rixt.</p>
                                        </div>
                                    </div>
                                    <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12" onclick="putong()">
                                        <div class="tile-stats">
                                            <div class="icon"><i class="fa fa-sort-amount-desc"></i>
                                            </div>
                                            <div class="count">179</div>

                                            <h3>普通流程</h3>
                                            <p>Lorem ipsum psdea itgum rixt.</p>
                                        </div>
                                    </div>
                                    <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12" onclick="qita()">
                                        <div class="tile-stats"  >
                                            <div class="icon"><i class="fa fa-check-square-o"></i>
                                            </div>
                                            <div class="count">179</div>

                                            <h3>其他代办页面</h3>
                                            <p>Lorem ipsum psdea itgum rixt.</p>
                                        </div>
                                    </div>
                                    <div  id="divzxc1"></div>
                                    <div  id="divzxc2"></div>
                                    <div  id="divzxc3"></div>
                                    <div  id="divzxc4"></div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--  弹框 -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <strong>个人中心:</strong>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="table" id="Coupon"></div>
                    <span id="span-id"></span>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="guanbi()" >关闭</button>
                        <span id="span-id2"></span>
                    </div>
                </div>
            </div>
        </div>
    </div>


















<script src="<%=request.getContextPath()%>/js/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/js/nicescroll/jquery.nicescroll.min.js"></script>

<!-- chart js -->
<script src="<%=request.getContextPath()%>/js/js/chartjs/chart.min.js"></script>
<!-- bootstrap progress js -->
<script src="<%=request.getContextPath()%>/js/js/progressbar/bootstrap-progressbar.min.js"></script>
<!-- icheck -->
<script src="<%=request.getContextPath()%>/js/js/icheck/icheck.min.js"></script>
<!-- daterangepicker -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/moment.min2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/datepicker/daterangepicker.js"></script>
<!-- sparkline -->
<script src="<%=request.getContextPath()%>/js/js/sparkline/jquery.sparkline.min.js"></script>
<script src="<%=request.getContextPath()%>/js/js/custom.js"></script>
<script type="text/javascript" src="js/excanvas.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/flot/jquery.flot.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/flot/jquery.flot.pie.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/flot/jquery.flot.orderBars.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/flot/jquery.flot.time.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/flot/date.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/flot/jquery.flot.spline.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/flot/jquery.flot.stack.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/flot/curvedLines.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/flot/jquery.flot.resize.js"></script>
        <script type="text/javascript">
function zxc() {
    $('#divzxc1').bootstrapTable({
        url:'<%=request.getContextPath()%>/caoxin/queryLiuChang1',
        method: "post",
        columns:[
            {field:'userchek',checkbox:true},
            {field:'procedate',title:'时间',width:300},
            {field:'roletext',title:'审核人',width:300},
            {field:'proceuser',title:'申请人',width:300},
            {field:'woname',title:'流程名字',width:300},
        ]
    });
}
            function jinji(){
                zxc();
            }
            function zhongyao(){
                zxc();
            }
            function putong(){

                zxc();
            }
            function qita(){
                zxc();
            }
        </script>
</body>

<script type="text/javascript">


      function tiaozhuan(text,url){

          $.addtabs({iframeHeight: 900});
          $.addtabs.add({
              title:text,
              url:"<%=request.getContextPath()%>/"+url
          });
      }
      function  guanbi() {
          location.href="<%=request.getContextPath()%>/modle/queryHomePage";
      }
      function  dengchu() {
          location.href="<%=request.getContextPath()%>/caoxin/dengchu";

      }
      function  login(){
          location.href="<%=request.getContextPath()%>/caoxin/denglu";
      }
      function   geren(){
          $.ajax({
              url: '<%=request.getContextPath()%>/caoxin/gerenxinxi',
              type:"post",
              success:function(result){
                  alert(result);
                  $("#span-id").html(result) ;
                  $("#myModal").modal("show") ;
              }
          });
      }
    </script>
</html>
