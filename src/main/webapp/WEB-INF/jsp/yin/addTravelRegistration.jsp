<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增出差登记</title>
</head>
<body>
<center>
<strong>员工出差单</strong>
    <form id="addTravelRegistrationssss">
          <table border="1" bgcolor="blue">
                <tr>
                      <td>
                            <label>出差人：</label>
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
                      <label>出差地点：</label>
                  </td>
                  <td>
                          <textarea class="form-control" name="placeoftravel" rows="3"></textarea>
                  </td>
              </tr>
              <tr>
                  <td>
                      <label>事由：</label>
                  </td>

                  <td>
                          <textarea class="form-control" name="travelyuanyin" rows="3"></textarea>
                  </td>
              </tr>
                <tr>
                      <td>
                            <label>开始时间：</label>
                      </td>
                      <td>
                          <input type="datetime-local" required ="required" name="kaishi" style="width:200px" id="date1">
                          至结束时间
                          <input type="datetime-local" required ="required" name="jieshu" style="width:200px" id="date2" onmouseout="day()">
                          <br>
                          共天数<input type="text" id="vv" readonly style="width:50px" class="form-control" >天
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
        var ff=(cc-aa)/(1000 * 60 * 60 *24);
        $("#vv").val(ff);
    }

</script>

</body>
</html>
