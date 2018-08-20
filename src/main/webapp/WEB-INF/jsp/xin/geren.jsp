<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018-08-14
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<center>
    姓名<input type="text"  name="username" value="${user.username}"  ><br>
    密码<input type="password"  name="pwd" value="${user.pwd}"><br>

    性别<input type="radio" name="usersex" value="1" <c:if test="${user.usersex ==1}">checked</c:if> > 男
    <input type="radio" name="usersex" value="2" <c:if test="${user.usersex ==2}">checked</c:if> > 女<br>

    生日<input type="text"   name="userbirth" onClick="WdatePicker()" value="    <fmt:formatDate value='${user.userbirth}' pattern='yyyy-MM-dd'></fmt:formatDate>"/>
    <br>
    手机号<input type="text" name="userphone" value="${user.userphone}"/><br>
    办公电话<input type="text"  name="userofficephone" value="${user.userofficephone}"/><br>
    QQ<input type="text" name="userqq" value="${user.userqq}"><br>
    电子邮箱<input type="text"  name="usermailbox" value="${user.usermailbox}" />
    <br>
    现住址<input type="text"  name="useraddress" value="${user.useraddress}"/><br>
    企业微信账号<input type="text"name="qiyeweixinhao"  value="${user.qiyeweixinhao}"/><br>
    <img src=${user.userimg} id="showImg" style="width: 100px;height: 100px;">
</center>
</body>
</html>
