<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018-08-14
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap-dialog/dist/css/bootstrap-dialog.css" >
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-dialog/dist/js/bootstrap-dialog.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootbox.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/tool/My97/WdatePicker.js"></script>
    <link rel="stylesheet"
          href="<%=request.getContextPath() %>/tool/EasyUI/themes/default/easyui.css" type="text/css"/>
    <link rel="stylesheet"
          href="<%=request.getContextPath() %>/tool/EasyUI/themes/icon.css" type="text/css"/>
    <link rel="stylesheet"
          href="<%=request.getContextPath() %>/tool/uploadify/uploadify.css" type="text/css"/>

</head>
<body>
<center>
<form id="adduserid">
    <input type="text"  style="width: 200px"   class="form-control" name="username" placeholder="请输入姓名">
    <input type="text" style="width: 200px"     class="form-control" name="pwd" placeholder="请输入密码">
    <input type="radio" name="usersex" value="1"> 男
    <input type="radio" name="usersex" value="2"> 女<br>
    <input type="text"  style="width: 200px"    class="form-control" name="userbirth" onClick="WdatePicker()" placeholder="请输入生日">
    <input type="text" style="width: 200px"     class="form-control" name="userphone" placeholder="请输入手机号">
    <input type="text" style="width: 200px"     class="form-control" name="userofficephone" placeholder="请输入办公电话">
    <input type="text" style="width: 200px"     class="form-control" name="userqq" placeholder="请输入QQ">
    <input type="text" style="width: 200px"     class="form-control" name="usermailbox" placeholder="请输入电子邮箱">
    <input type="text" style="width: 200px"     class="form-control" name="useraddress" placeholder="请输入现住址">
    <input type="text" style="width: 200px"     class="form-control" name="qiyeweixinhao" placeholder="请输入企业微信账号">

    <input type="file" id="imgFileBTN" >
    <input type="text" id="hidden-photo" name="userimg">
    <div id="showImgDiv" style="width: 100px;height: 100px;border-style:solid;border-width:1px; border-color:black;">
        <img src="" id="showImg" style="width: 100px;height: 100px;">
    </div>
    <div id="showBars"></div>


    <button type="button"     class="btn btn-default" onclick="addohih()">提交</button>
</form>
</center>
<script type="text/javascript">
    function addohih(){
        $.ajax({
            url:"<%=request.getContextPath()%>/caoxin/insertUser",
            data:$("#adduserid").serialize(),
            type:"post",
            success:function(){
                location.href="<%=request.getContextPath()%>/caoxin/denglu"
            },
            error:function(){
                location.href="<%=request.getContextPath()%>/caoxin/denglu"
            }
        });
    }

</script>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/tool/EasyUI/jquery.min.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/tool/EasyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
        src="<%=request.getContextPath() %>/tool/EasyUI/util-js.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/tool/uploadify/jquery.uploadify.min.js"></script>


<script type="text/javascript">

    //图片上传
    $(function(){
        $("#imgFileBTN").uploadify({
            //前台请求后台的url 不可忽略的参数
            'uploader' :"<%=request.getContextPath()%>/caoxin/uploadImg",
            //插件自带 不可忽略的参数
            'swf' : '<%=request.getContextPath()%>/tool/uploadify/uploadify.swf',
            //撤销按钮的图片路径
            'cancelImg' : '<%=request.getContextPath() %>/tool/uploadify/jquery.uploadify.min.js',
            //如果为true 为自动上传 在文件后 为false 那么它就要我们自己手动点上传按钮
            'auto' : true,
            //可以同时选择多个文件 默认为true 不可忽略
            'multi' : false,
            //给上传按钮设置文字
            'buttonText' : '上传图片',
            //上传后队列是否消失
            'removeCompleted' : true,
            'removeTimeout' : 1,
            //上传文件的个数
            'uploadLimit' : 2,
            'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png',
            'fileSizeLimit' : '2MB',
            //给div的进度条加背景 不可忽略
            'queueID' : 'showBars',
            //controller层方法中接收文件的参数名
            'fileObjName' : 'imgs',
            //上传成功后的回调函数   data 是上传方法返回的数据
            'onUploadSuccess' : function(file, data, response) {
                $("#showImg").attr('src',data); //oss需要把根目录删了（返回一个网址），只保留data
                $("#hidden-photo").val(data);  //同上
            }
        });
    })

</script>
</body>
</html>
