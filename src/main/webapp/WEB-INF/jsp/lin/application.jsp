<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/14 0014
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>

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

<body>
<form  class="form-inline"  id="form-id">

    <c:forEach items="${list}" var="arr">

        <c:if test="${arr.attributeType=='date'}">
            <div class="input-group">
                <div  class="input-group-addon" style="width:300px">${arr.attributename}</div>
                <input type="date"  id="largestfactoryprice" name="datetimeEnd"  style="width:300px" class="form-control" placeholder="请输入"+${arr.attributename} >
            </div>
        </c:if>
      <c:if test="${arr.attributeType=='textarea'}">
           <div class="input-group">
                <div  class="input-group-addon" style="width:300px">${arr.attributename}</div>
                <textarea   name="woname" id="orsearch"   style="width:300px" class="form-control" >
            </textarea>
            </div>
        </c:if>
        <c:if test="${arr.attributeType=='text'}">
            <div class="input-group">
               <div  class="input-group-addon" style="width:300px">${arr.attributename}</div>
               <input type="text"  id="largestfactoryp" name="datetimeEnd"  style="width:300px" class="form-control" placeholder="请输入"+${arr.attributename} >
            </div>
      </c:if>
    </c:forEach>
</form>

</body>
</html>
