<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018-08-15
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="hidden" id="roleid" value="${shen.roletext}"/>
        <span id="span-id"></span>
    <script type="text/javascript">
            $(function(){
            querycharge();
            });
            function  querycharge(){
               var  asd= $("#roleid").val();
                str=asd.split(",")
                for(var i=0;i<str.length;i++){
                    $("#span-id").append(str[i]).append("<br>").append('<font color=\"red\">未通过</font>').append("<br>");
                }
            }
    </script>
</body>
</html>