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
</head>
<body>
<center>
<form  id="addfrom">
    <div class="input-group">
        <div  class="input-group-addon" style="width:150px">编号 </div>
        <input type="text"  name="bianhao"    style="width:150px" class="form-control" placeholder="请输入编号" >
    </div>
    <div class="input-group">
        <div  class="input-group-addon" style="width:150px">标题</div>
        <input type="text"  name="biaoti"  style="width:150px" class="form-control" placeholder="请输入标题" >
    </div>
    <div class="input-group">
        <div  class="input-group-addon" style="width:150px">分类</div>
        <input type="text" name="fenlei"  style="width:150px" class="form-control" placeholder="请输入分类" >
    </div>
    <div class="input-group">
        <div  class="input-group-addon" style="width:150px">所属流场</div>
        <input type="text"  name="liuchang"  style="width:150px" class="form-control" placeholder="请输入所属流场" >
    </div>
    <button class="btn btn-primary " onclick="addohih()" data-target="#myModal">提交</button>
</form>	<br/>
</center>
<script type="text/javascript">
    function addohih(){
        $.ajax({
            url:"<%=request.getContextPath()%>/caoxin/insertorig",
            data:$("#addfrom").serialize(),
            type:"post",
            datatype:'json',
            success:function(result){
                if(result ==1 ){
                    alert("成功");
                   location.href="<%=request.getContextPath()%>/caoxin/show"
                }
            }
        });
    }
</script>
</body>
</html>
