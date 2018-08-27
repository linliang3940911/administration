<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
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
<div id="dividss"></div>

<!--  弹框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <strong>个人中心:</strong>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="table" id="Coupon"></div>
            <span id="span-id"></span>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="guanbi()" >关闭</button>
                <span id="span-id2"></span>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        querycharge();
    });
    function junquerycharge(){
        querycharge();
        $('#dividss').bootstrapTable('refresh');
    }
    function xinzeng() {
        location.href="<%=request.getContextPath()%>/caoxin/addor"
    }

    function search_list(){
        $("#dividss").bootstrapTable("refresh",{offset:1})
    }
    function querycharge(){
        $('#dividss').bootstrapTable({
            url:'<%=request.getContextPath()%>/caoxin/queryshen',
            method: "post",
            pagination: true,
            pageList:[ 10,15,20,30],//分页组件
            pageNumber:1,
            pageSize:10,//默认每页条数
            height: 700,
            showColumns:false,//是否显示 内容列下拉框
            showToggle:false,//是否显示 切换试图（table/card）按钮
            showPaginationSwitch:false,//是否显示 数据条数选择框
            singleSelect : true,//单选
            detailView:false,//设置为 true 可以显示详细页面模式。
            showFooter:false,//是否显示列脚
            clickToSelect: true, //是否启用点击选中行
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            sidePagination:'server',//分页方式：client客户端分页，server服务端分页（*
            striped:true,
            columns:[
                {field:'roletext',title:'审核人',width:300,
                    formatter: function(value,row,index){
                        var zxc=row.roletext;
                        if(zxc !=null){
                            var  str=zxc.split(",")
                            for(var i=0;i<str.length;i++){
                                return str[i];
                            }
                        }
                        return '已审核完';
                    }
                },
                {field:'proceuser',title:'申请人',width:300},
                {field:'woname',title:'流程名字',width:300},
                {field:'act',title:'操作',width:300,
                    formatter: function(value,row,index){
                        var  zxc=  '<button class="btn btn-primary " id="butt1"  data-dismiss="modal" aria-hidden="true" onclick="tongguo(\''+row.proceid+'\')">通过</button>'
                            +'<button class="btn btn-primary "  id="butt2" data-dismiss="modal" aria-hidden="true" onclick="bohui(\''+row.proceid+'\')">驳回</button>'
                            +'<button class="btn btn-primary "  id="butt3" data-dismiss="modal" aria-hidden="true" onclick="zhipai(\''+row.proceid+'\')">指派</button>'
                        return zxc;
                    }
                },
            ]
        });
    }
    function  tongguo(proceid){
        $.ajax({
            url: '<%=request.getContextPath()%>/caoxin/tongguo?proceid='+proceid,
            type:"post",
            success:function(){
                location.href="<%=request.getContextPath()%>/caoxin/shenhe"
            }
        });
    }
    function  bohui(proceid){
        $.ajax({
            url: '<%=request.getContextPath()%>/caoxin/bohui?proceid='+proceid,
            type:"post",
            success:function(){
                location.href="<%=request.getContextPath()%>/caoxin/shenhe"
            }
        });
    }
    function  zhipai(proceid){
        $.ajax({
            url: '<%=request.getContextPath()%>/caoxin/zhipai',
            type:"post",
            data:{"proceid":proceid},
            success:function(result){
                $("#span-id").html(result) ;
                $("#myModal").modal("show") ;
            }
        });
    }
    function   tongzhi(proceid) {
        $.ajax({
            url: '<%=request.getContextPath()%>/caoxin/multiThreadSMSverification',
            type:"post",
            data:{"proceid":proceid},
            success:function(){
                location.href="<%=request.getContextPath()%>/caoxin/shenhe"
            }
        });
    }
</script>
</body>
</html>