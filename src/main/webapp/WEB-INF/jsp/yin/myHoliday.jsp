<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的假期</title>
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap-dialog/dist/css/bootstrap-dialog.css">
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/js/bootstrap-dialog/dist/js/bootstrap-dialog.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootbox.min.js"></script>
</head>
<body>

<table id="myHoliday"></table>

<script type="text/javascript">

    $(function () {
        queryMyHoliday();
    });

    function queryyinronger3() {
        queryMyHoliday();
        $('#myHoliday').bootstrapTable('refresh');
    }

    function search_list() {
        $('#myHoliday').bootstrapTable("refresh", {offset: 1})
    }

    function queryMyHoliday() {
//        var date = $('.datepicker').datepicker('setDate', new Date());
//        alert(date);
        $('#myHoliday').bootstrapTable({
            url: '<%=request.getContextPath()%>/yreController/queryMyHoliday',
            method: "post",
            pagination: true,		   //开启分页
            pageNumber: 1,              //初始化加载第几页,默认第1页
            pageSize: 5,               //每页几条数据,超过总条数右下角将没分页
            pageList: [2, 3, 5, 10],    //每页条数,设置为All将展示全部记录,超过总条数底部将不显示条数下拉框
            showColumns: false,//是否显示 内容列下拉框
            showToggle: false,//是否显示 切换试图（table/card）按钮
            showPaginationSwitch: false,//是否显示 数据条数选择框
            showRefresh: true,//是否显示刷新按钮
            singleSelect: true,//单选
            detailView: false,//设置为 true 可以显示详细页面模式。
            showFooter: false,//是否显示列脚
            clickToSelect: true, //是否启用点击选中行
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",	//必须的否则条件查询时会乱码
            sidePagination: "server",  //分页方式:client客户端分页,server服务端分页
            striped: true,
            columns: [
                {field: 'username', title: '姓名', width: 200},
                {field: 'nianjia', title: '年假', width: 200,
                    formatter:function (value,row,index) {
                        return "w";
                    }
                },
                {field: 'yixiunianjia', title: '已休年假', width: 200,
                    formatter:function (value,row,index) {
                        return "w";
                    }
                },
                {field: 'weixiunianjia', title: '未休年假', width: 200,
                    formatter:function (value,row,index) {
                        return "w";
                    }
                },
                {field: 'shengyutiaoxiushijian', title: '剩余调休小时', width: 200,
                    formatter:function (value,row,index) {
                        return "w";
                    }
                },
            ]
        });
    }

</script>


</body>
</html>
