<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018-08-10
  Time: 22:24
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
</head>
<body>

    <form id="fromAdd">
            <input type="text"  style="width: 200px"   class="form-control" name="bianhao" placeholder="请输入编号">
            <input type="text" style="width: 200px"    class="form-control" name="biaoti" placeholder="请输入标题">
            <input type="text"  style="width: 200px"    class="form-control" name="fenlei" placeholder="请输入分类">
            <input type="text" style="width: 200px"     class="form-control" name="liuchang" placeholder="请输入所属流场">
        <button type="submit"     class="btn btn-default" onclick="addohih()">提交</button>
    </form>

<script type="text/javascript">
    function addohih(){
        $.ajax({
            url:"<%=request.getContextPath()%>/caoxin/insertorig",
            data:$("#fromAdd").serialize(),
            type:"post",
            success:function(){
            },
            error:function(){
                location.href="<%=request.getContextPath()%>/caoxin/show"
            }
        });
    }
</script>
</body>
</html>