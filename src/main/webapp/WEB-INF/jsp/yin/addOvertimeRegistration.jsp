<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加登记</title>
</head>
<body>
<center>
<strong>员工加班单</strong>
    <form id="addOvertimeRegistration">
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
                            <label>开始添加时间：</label>
                      </td>
                      <td>
                          <input type="datetime-local" name="kaishi" required ="required" style="width:200px" id="date1">
                          &nbsp; 至 &nbsp;
                          <input type="datetime-local" name="jieshu" required ="required" style="width:200px" id="date2" onmouseout="day()">
                          合计加班时间<input type="text"  readonly style="width:100px" class="form-control"  id="vv">
                              小时
                      </td>
                </tr>
                <tr>
                      <td>
                            <label>类别:(是否计入调休)</label>
                      </td>
                      <td>
                            <input type="radio" name="breakdown" value="1">是
                            <input  checked type="radio" name="breakdown" value="2">否
                      </td>
                </tr>
                <tr>
                      <td>
                            <label>事由：</label>
                      </td>
                      <td>
                            <textarea name="jiabanyuanyin" cols="30" rows="10"></textarea>
                      </td>
                </tr>
          </table>
    </form>
</center>
<script type="text/javascript">
      function  day() {
          var s1=$("#date1").val();
          var s2= $("#date2").val();
          var date=new Date(s1);
          var xx =new Date(s2);
          var aa= date.getTime();
          var cc=xx.getTime();
          var ff=(cc-aa)/(1000 * 60 * 60);
          $("#vv").val(ff);
      }
</script>
</body>
</html>
