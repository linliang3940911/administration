<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/tool/index.css">
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap3/js/bootstrap.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap3/css/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap-treeview/bootstrap-treeview.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootStrap-addTabs/bootstrap.addtabs.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap-table/dist/bootstrap-table.css">

    <script src="<%=request.getContextPath()%>/js/bootstrap-table/dist/bootstrap-table.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap-table/dist/locale/bootstrap-table-zh-CN.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap-treeview/bootstrap-treeview.min.js"></script>
    <!-- dialog -->
    <link rel="stylesheet" href=<%=request.getContextPath()%>/js/bootstrap-dialog/dist/css/bootstrap-dialog.css" >
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-dialog/dist/js/bootstrap-dialog.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootbox.min.js"></script>
</head>
<body background="<%=request.getContextPath()%>/login/images/bg.jpg">
<center>
    <h1 style="color: #03b6fd">办公管理系统登录</h1>
    <br>
    <br>
    <br>
    <form id="login_form_id">
        <input type="text" id="name" style="width: 200px"   class="form-control" name="username" placeholder="请输入账号">
        <br>
        <input type="password" id="pp" style="width: 200px"    class="form-control" name="pwd" placeholder="请输入密码">
        <br>
        <body>



        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <span id="span-id2"></span>
                    </div>

                    <div class="table" id="Coupon"></div>
                    <div class="box">
                        <div class="imgBox">
                            <div class="verify"></div>
                            <div class="verified"></div>
                        </div>
                        <div class="handle">
                            <span class="swiper"></span>
                            <span class="text">拖动滑块</span>
                        </div>
                        <div class="refreshBox">
                            <span class="refresh">点击切换图片</span>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"  onclick="addshenqingliycheng(0)">保存</button>
                        <button type="button" class="btn btn-default" onclick="addshenqingliycheng(1)">提交</button>

                    </div>
                </div>
            </div>
        </div>
        <script src='<%=request.getContextPath()%>/tool/index.js'></script>
        </body>


        <button type="button"     class="btn btn-default" onclick="login()">登录</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button"     class="btn btn-default" onclick="addUser()">注册</button>
    </form>
</center>

<script type="text/javascript">
    function login(){

        $.ajax({
            url:"<%=request.getContextPath()%>/caoxin/queryUser",
            type:"post",
            data:$("#login_form_id").serialize(),
            dataType:"json",
            success:function(msg){
                if(msg == '0'){
                    $.messager.show({
                        title:'提示',
                        msg:'用户名不存在',
                        timeout:2000,
                        showType:'slide'
                    });
                } else if( msg == '1'){
                    $.messager.show({
                        title:'提示',
                        msg:'密码错误',
                        timeout:2000,
                        showType:'slide'
                    });
                }else if(msg == '2'){//登录成功 直接跳转到首页
                    $("#span-id2").text()
                    $("#myModal").modal('show');  //手动开启
                }
            },
            error:function(){
                alert("请求失败");

            }
        });
    }
    function  addUser(){
        location.href="<%=request.getContextPath()%>/caoxin/adduser"
    }
</script>
