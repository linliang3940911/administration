<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/17 0017
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/tool/sign2.css">

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/tool/calendar2.js"></script>
<body>

<div  id="calendar"></div>
<input type="button"  value="上下班打卡"  onclick="adka()">




<script type="text/javascript">
    $(function(){
        querylust();

    });
    function querylust(){
        $.ajax({
            url:"<%=request.getContextPath()%>/modle/queryKaoqinji",
            type:"post",
            success:function(result){

                var signList=result;
                calUtil.init(signList);

            }
        })
    }


    function adka(){
        $.ajax({
        url:"<%=request.getContextPath()%>/modle/addTime",
        type:"post",
        success:function(result){
        if(result==1){
        alert("打卡成功")
            querylust();
        }
        }
        })


    }


</script>
</body>
</html>
