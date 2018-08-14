<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的考勤管理</title>
</head>
    <body>
    <a href="<%=request.getContextPath()%>/jumpController/toMySchedule" target="rights">我的排班表</a>
    <br>
    <a href="<%=request.getContextPath()%>/jumpController/toMyHoliday" target="rights">我的假期</a>
    <br>
    <a href="<%=request.getContextPath()%>/jumpController/toMyAttendance" target="rights">我的考勤</a>
    </body>
</html>
