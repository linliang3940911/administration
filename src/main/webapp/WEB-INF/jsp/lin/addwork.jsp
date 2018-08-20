<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13 0013
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jstl/core" prefix="c"  %>
<html>
<head>
    <title>Title</title>
</head>
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
<body>

    <center><h2>新增流程页面</h2></center>
    <form  class="form-inline"  id="form-id">
        <input type="radio" name="dengji" value="1"/>紧急流程
        <input type="radio" name="dengji" value="2"/>重要流程
        <input type="radio" name="dengji" value="3"/>普通流程
        <input type="radio" name="dengji" value="4"/>其他代办流程
        <div class="input-group"  >
            <div  class="input-group-addon" style="width:100px">流程分类</div>
            <select name="workType"  class="form-control"  onmousedown="querytree()"  id="workid">
                <option >-请选择-</option>
            </select><br>
        </div>


        <div class="input-group">
            <div  class="input-group-addon" style="width:150px">名称 </div>
            <input type="text"  name="woname" id="orsearch"   style="width:300px" class="form-control" placeholder="请输入流程名称  " >
        </div>
        <div class="input-group"  >
      <div  class="input-group-addon" style="width:100px">设置审核人员</div>
            <select name="conditio"  class="form-control"  onmousedown="querylist()"  id="select-id">
                <option >-请选择-</option>
            </select><br>
        </div>


    <span id="span-id"></span>



    <input type="hidden" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"></input>
    </form>
    <button type="button" onclick="tianjia()" class="btn btn-warning"><h4>设置审核人</h4></button>
    <button type="button" onclick="yanchukuang()" class="btn btn-warning"><h4>提交流程</h4></button>
    <script type="text/javascript">
        var shuzi=1

        function  tianjia(){
            shuzi++
            var str="<div class=\"input-group\"><div  class=\"input-group-addon\" style=\"width:200px\">设置审核人员</div><select name=\"conditio\"  onmousedown='querylist("+shuzi+")' id='select-id"+shuzi+"'  class=\"form-control\"> </select><br><div>"
            var st1=":"
            $("#span-id").append(str)
        }

        function querytree() {
            $.ajax({
                url:"<%=request.getContextPath()%>/caoxin/queryListTree",
                type:"post",
                success:function(listTree){
                    var str="<option >-请选择-</option>"
                    for(var i=0;i<listTree.length;i++){
                        str+="<option value="+listTree[i].id+">"+listTree[i].text+"</option>"
                    }
                    $("#workid").html(str);
                }
            })

        }
        function querylist(){
            $.ajax({
              url:"<%=request.getContextPath()%>/modle/queryProcedurelist",
              type:"post",
              success:function(result){
                  var str="<option >-请选择-</option>"
                 for(var i=0;i<result.length;i++){
                 str+="<option value="+result[i].roleid+">"+result[i].roletext+"</option>"
                 }
                 if(shuzi==1){
                     $("#select-id").html(str)
                 }else {
                     $("#select-id"+shuzi).html(str)
                 }

              }
            })
        }
        function yanchukuang(){
        $.ajax({
         url:"<%=request.getContextPath()%>/modle/addWorkName",
         type:"post",
         data:$("#form-id").serialize(),
         success:function(result){
            if(result==1){
            alert("添加成功")
           history.go(-1)
            }

         }

        })
        }
    </script>
</body>
</html>
