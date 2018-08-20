<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询操作日志</title>
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

<table id="operationLog"></table>
<script type="text/javascript">

    $(function(){
        queryOperationLog();
    });
    function queryyinronger7(){
        queryOperationLog();
        $('#operationLog').bootstrapTable('refresh');
    }

    function search_list(){
        $("#operationLog").bootstrapTable("refresh",{offset:1})
    }

    function queryOperationLog(){

        $('#operationLog').bootstrapTable({
            url:'<%=request.getContextPath()%>/yreController/queryMongodbOperation',
            method: "post",
            pagination: true,		   //开启分页
            pageNumber:1,              //初始化加载第几页,默认第1页
            pageSize: 10,               //每页几条数据,超过总条数右下角将没分页
            pageList: [2, 5, 10, 20],    //每页条数,设置为All将展示全部记录,超过总条数底部将不显示条数下拉框
            showColumns:false,//是否显示 内容列下拉框
            showToggle:false,//是否显示 切换试图（table/card）按钮
            showPaginationSwitch:false,//是否显示 数据条数选择框
            showRefresh:true,//是否显示刷新按钮
            singleSelect : true,//单选
            detailView:false,//设置为 true 可以显示详细页面模式。
            showFooter:false,//是否显示列脚
            clickToSelect: true, //是否启用点击选中行
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",	//必须的否则条件查询时会乱码
            sidePagination: "server",  //分页方式:client客户端分页,server服务端分页
            striped:true,
            columns:[
                /*{field:'userchek',checkbox:true},*/
                {field:'operationid',title:'操作id',width:200},
                {field:'operationdate',title:'操作时间',width:200},
                {field:'operationmothedname',title:'操作方法',width:200}
            ]
        });
    }

</script>


</body>
</html>
