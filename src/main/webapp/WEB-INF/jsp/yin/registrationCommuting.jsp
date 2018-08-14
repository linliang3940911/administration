<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询上下班登记时间</title>
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

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <strong>请填写说明情况:</strong>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>

            <div class="table" id="Coupon"></div>
            <span id="span-id"></span>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                <span id="span-id2"></span>
            </div>
        </div>
    </div>
</div>

<table id="registration"></table>
    <script type="text/javascript">

        $(function(){
            queryRegistrationForCommuting();
        });
        function queryyinronger(){
            queryRegistrationForCommuting();
            $('#registration').bootstrapTable('refresh');
        }

        function search_list(){
            $("#registration").bootstrapTable("refresh",{offset:1})
        }

        function queryRegistrationForCommuting(){

            $('#registration').bootstrapTable({
                url:'<%=request.getContextPath()%>/yreController/queryRegistration',
                method: "post",
                pagination: true,		   //开启分页
                pageNumber:1,              //初始化加载第几页,默认第1页
                pageSize: 5,               //每页几条数据,超过总条数右下角将没分页
                pageList: [2, 3, 5, 10],    //每页条数,设置为All将展示全部记录,超过总条数底部将不显示条数下拉框
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
                    {field:'userchek',checkbox:true},
                    {field:'banci',title:'班次',width:200},
                    {field:'dengjitype',title:'登记类型',width:200},
                    {field:'settime',title:'规定时间',width:200},
                    {field:'starttime',title:'开始登记时间',width:200},
                    {field:'endtime',title:'结束登记时间',width:200},
                    {field:'registrationtime',title:'登记时间',width:200,
                        formatter:function (value,row,index) {
                            if (row.registrationtime == 1) {
                                return "未登记";
                            }else if(row.registrationtime == 2){
                                return "已登记";
                            }
                        }
                    },
                    {field:'cause',title:'操作',width:200,
                        formatter:function (value,row,index) {
                            if (value == "") {
                                return "<button class='btn btn-primary ' onclick='addReasonById()'  data-toggle='modal' data-target='#myModal'>说明情况</button>";
                            }else if(value != ""){
                                return "已说明情况";
                            }
                        }
                    },
                ]
            });
        }

        function addReasonById() {
            var commuteids = $("#registration").bootstrapTable('getSelections');
            var commuteid="";
            for (var i = 0; i < commuteids.length; i++) {
                commuteid=commuteids[i].commuteid;
            }
                $.ajax({
                    url:"<%=request.getContextPath()%>/yreController/addReasonById?commuteid="+commuteid,
                    type:"post",
                    success:function(result){
                        $("#span-id").html(result) ;
                        $("#span-id2").html('<button type="button" class="btn btn-primary" onclick="addReason2()">提交</button>')
                    }
                });
        }

        function addReason2() {
            $.ajax({
                url:"<%=request.getContextPath()%>/yreController/addReason2",
                data:$("#addReason").serialize(),
                type:"post",
                datatype:'json',
                success:function(result){
                    if(result ==1 ){
                        $('#myModal').modal('hide')
                        $('#registration').bootstrapTable('refresh');

                    }
                }
            });
        }
    </script>


</body>
</html>
