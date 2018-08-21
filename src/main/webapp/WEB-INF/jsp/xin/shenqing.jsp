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
<button class="btn btn-primary "  data-dismiss="modal" aria-hidden="true" onclick="querydc()">导出</button>
<div id="divshen"></div>
<!--  弹框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <strong>详情:</strong>
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
<script type="text/javascript">
    function querydc(){
        $.ajax({
            url : "<%=request.getContextPath()%>/caoxin/querydaochulist",
            type: "post",
            success:function(){
                alert("导出成功")
            },
            error:function(){
                alert("导出失败")
            },

        })
    }








    $(function(){
        querycharge();
    });
    function junquerycharge(){
        querycharge();
        $('#divshen').bootstrapTable('refresh');
    }
    function xinzeng() {
        location.href="<%=request.getContextPath()%>/caoxin/addor"
    }
    function search_list(){
        $("#divshen").bootstrapTable("refresh",{offset:1})
    }
    function querycharge(){
        $('#divshen').bootstrapTable({
            url:'<%=request.getContextPath()%>/caoxin/queryshen',
            method: "post",
            pagination: true,
            pageList:[10,15,20,30],//分页组件
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
                {field:'userchek',checkbox:true},
                {field:'proceid',title:'id',width:350},
                {field:'procedate',title:'时间',width:300},
//                {field:'roletext',title:'审核人',width:300,
//                    formatter: function(value,row,index){
//                    var zxc=row.roletext;
//                        if(zxc !=null){
//                            str=zxc.split(",")
//                            for(var i=0;i<str.length;i++){
//                                return str[i];
//                            }
//                        }
//                        return "已审核完";
//                    }
//                },
                {field:'proceuser',title:'申请人',width:300},
                {field:'act',title:'操作',width:300,
                    formatter: function(value,row,index){
                        return '<button class="btn btn-primary "  data-dismiss="modal" aria-hidden="true" onclick="chaKanXiangQing(\''+row.proceid+'\')">查看</button>';
                    }
                },
            ]
        });
    }
    function   chaKanXiangQing(proceid){
        $.ajax({
            url: '<%=request.getContextPath()%>/caoxin/xiangqing?proceid='+proceid,
            type:"post",
            success:function(result){
                $("#span-id").html(result);
                $("#myModal").modal("show");
            }
        });
    }
</script>
</body>
</html>