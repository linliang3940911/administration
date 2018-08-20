<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018-08-16
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="hidden"  id="pro" name="proceid" value="${shen.proceid}"  />
        <select id="city" class="select">
            <c:forEach items="${list}" var="s">
            <option value="${s.roleid}">${s.roletext}</option>
            </c:forEach>
        </select>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="fromrelo()">提交</button>
<script type="text/javascript">
function fromrelo() {
    var zxc=$("#city").val();
    var proceid=$("#pro").val();
    $.ajax({
        url : "<%=request.getContextPath()%>/caoxin/zhipairen",
        type: "post",
        data:{"zxc":zxc,"proceid":proceid},
        success:function () {
            location.href="<%=request.getContextPath()%>/caoxin/shenhe"
        }
    })
}
</script>
</body>
</html>
