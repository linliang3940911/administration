<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>加班登记</title>
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
                <strong>加班登记详情:</strong>
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

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <strong>员工加班单:</strong>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>

            <div class="table" id="Coupon2"></div>
            <span id="span-id3"></span>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                <span id="span-id4"></span>
            </div>
        </div>
    </div>
</div>

<br>

<button type="button" class="btn btn-primary" data-toggle='modal' data-target='#myModal2' onclick="toAddOvertimeRegistration()">
    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加登记
</button>

<table id="overtimeRegistrationbg"></table>

<script type="text/javascript">

    $(function(){
        queryOvertimeRegistration();
    });
    function queryyinronger6(){
        queryOvertimeRegistration();
        $('#overtimeRegistrationbg').bootstrapTable('refresh');
    }

    function search_list(){
        $("#overtimeRegistrationbg").bootstrapTable("refresh",{offset:1})
    }

    function queryOvertimeRegistration(){

        $('#overtimeRegistrationbg').bootstrapTable({
            url:'<%=request.getContextPath()%>/yreController/queryOvertimeRegistration',
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
                {field:'shenqingtime',title:'申请时间',width:200},
                {field:'kaishitime',title:'开始时间',width:200},
                {field:'jieshutime',title:'结束时间',width:200},
                {field:'jiabantime',title:'加班时长(小时)',width:200,
                    formatter:function (value,row,index) {
                        return "5小时";
                    }
                },
                {field:'jiabanyuanyinaa',title:'加班原因(点击查看详细)',width:200,
                    formatter:function (value,row,index) {
                            return "<button  class=\'btn btn-primary \' onclick='queryXiangQing()'  data-toggle=\'modal\' data-target=\'#myModal\'>"+row.jiabanyuanyin+"</button>";
                    }
                }
            ]
        });
    }

   function queryXiangQing() {
        var jiabanids = $("#overtimeRegistrationbg").bootstrapTable('getSelections');
        var jiabanid="";
        for (var i = 0; i < jiabanids.length; i++) {
            jiabanid=jiabanids[i].jiabanid;
        }
        $.ajax({
            url:"<%=request.getContextPath()%>/yreController/queryxiangqing?jiabanid="+jiabanid,
            type:"post",
            success:function(result){
                $("#span-id").html(result);
            }
        });
    }
    
    function toAddOvertimeRegistration(){
        $.ajax({
            url: '<%=request.getContextPath()%>/jumpController/toAddOvertimeRegistration',
            type:"post",
            success:function(result){
                $("#span-id3").html(result) ;
                $("#span-id4").html('<button type="button" class="btn btn-primary" onclick="addOvertimeRegistration()">提交</button>')
            }
        });
    }

    function addOvertimeRegistration(){
        $.ajax({
            url:"<%=request.getContextPath()%>/yreController/addOvertimeRegistration",
            data:$("#addTravelRegistrationssss").serialize(),
            type:"post",
            success:function(result){
                if(result ==1 ){
                    $('#myModal2').close();
                    $('#overtimeRegistrationbg').bootstrapTable('refresh');
                }
            }
        });
    }

</script>


</body>
</html>
