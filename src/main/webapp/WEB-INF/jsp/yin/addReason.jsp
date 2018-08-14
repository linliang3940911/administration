<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增原因</title>
</head>
<body>
<form  class="form-inline" id="addReason">
    <input type="hidden" name="commuteid" value="${commute.commuteid}">
    <label class="col-md-pull-2">
        <textarea name="cause" cols="30" rows="10">${commute.cause}</textarea>
    </label>
</form>

</body>
</html>
