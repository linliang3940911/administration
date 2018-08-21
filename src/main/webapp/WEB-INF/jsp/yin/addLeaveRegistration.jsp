<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加登记</title>
</head>
<body>
<center>
    <strong>员工请假单</strong>
    <form id="addLeaveRegistration">
        <table border="1" bgcolor="blue">
            <tr>
                <td>
                    <label>姓名：</label>
                </td>
                <td>
                    <input type="text" value="${loginUser.username}" readonly style="width:200px" class="form-control" >
                </td>
            </tr>
            <tr>
                <td>
                    <label>部门：</label>
                </td>
                <td>
                    <input type="text" value="协众OA协同管理系统-试用" readonly style="width:200px" class="form-control" >
                </td>
            </tr>
            <tr>
                <td>
                    <label>请假天数：</label>
                </td>
                <td>
                    <input type="text" name="qingjiatianshu" style="width:200px" class="form-control" >
                </td>
            </tr>
            <tr>
                <td>
                    <label>请假类别：</label>
                </td>
                <td>
                    <select name="qingjiatype">
                        <option value="1">病假</option>
                        <option value="2">事假</option>
                        <option value="3">年假</option>
                        <option value="4">路途假</option>
                        <option value="5">婚假</option>
                        <option value="6">陪产假</option>
                        <option value="7">产假</option>
                        <option value="8">丧假</option>
                        <option value="9">调休</option>
                        <option value="10">其他</option>
                    </select>
                    <br>
                    使用年假： <input type="text" name="nianjiatianshu" style="width:200px">
                    <br>
                    使用调休： <input type="text" name="tiaoxiutianshu" style="width:200px">
                </td>
            </tr>
            <tr>
                <td>
                    <label>请假时间：</label>
                </td>
                <td>
                    <input type="datetime-local" name="kaishi" required ="required" style="width:200px">
                    &nbsp; 至 &nbsp;
                    <input type="datetime-local" name="jieshu" required ="required" style="width:200px">
                </td>
            </tr>
            <tr>
                <td>
                    <label>事由：</label>
                </td>
                <td>
                    <textarea name="qingjiayuanyin" cols="30" rows="10"></textarea>
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
