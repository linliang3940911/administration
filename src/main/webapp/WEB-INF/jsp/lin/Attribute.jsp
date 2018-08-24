<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13 0013
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


<form  class="form-inline"  id="form-id">
    <input type="hidden"  value="${woi}"  id="woid" name="woid">
    <span id="span-id"></span>
    <%--<div class="input-group">--%>
        <%--<div  class="input-group-addon" style="width:100px">手机型号 </div>--%>
        <%--<input type="text"  name="uname" id="orsearch"   style="width:150px" class="form-control" placeholder="请输入手机型号" >--%>
    <%--</div>--%>

</form>
<button type="button" onclick="tianjia()" class="btn btn-warning"><h3>添加样式</h3></button>
<button type="button" onclick="commseiForm()" class="btn btn-warning"><h3>提交</h3></button>
    <script  type="text/javascript">
        function tianjia(){
            var shuzi=1
            shuzi++
            var str="<div class=\"input-group\"><input type=\"text\"  name=\"attributename\" id=\"orsearch\"+shuzi style=\"width:300px\"  class=\"form-control\" placeholder=\"请输入属性\" ><input type=\"text\"  name=\"attributeType\" id=\"orsearch\"+shuzi  style=\"width:300px\" class=\"form-control\" placeholder=\"请输入属性的类型\" ></div>"
              $("#span-id").append(str)
        }
        function commseiForm(){
            $.ajax({
              url:'<%=request.getContextPath()%>/modle/commseiForm',
              type:"post",
              data:$("#form-id").serialize(),
              success:function(result){
                  if(result==1){
                      alert("新增成功")

                  }

              }
            })
        }
    </script>
</body>
</html>
