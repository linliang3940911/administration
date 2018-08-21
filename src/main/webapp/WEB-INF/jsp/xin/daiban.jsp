<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018-08-21
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<div  id="zxc"></div>
<script type="text/javascript">
    $(function(){
        querycharge();
    });
    function querycharge(){
        $('#zxc').bootstrapTable({
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
                        return "已审核完";
                    }
                },
                {field:'proceuser',title:'申请人',width:300},
                {field:'woname',title:'流程名字',width:300},
                {field:'zhipairole',title:'指派人',width:300,
                    formatter: function(value,row,index){
                        if(row.zhipairole=="1"){
                            return "员工";
                        }
                        if(row.zhipairole=="2"){
                            return "主管";
                        }
                        if(row.zhipairole=="3"){
                            return "经理";
                        }
                        if(row.zhipairole=="4"){
                            return "总监";
                        }
                        if(row.zhipairole=="5"){
                            return "副总监";
                        }
                        if(row.zhipairole=="6"){
                            return "主任";
                        }
                        if(row.zhipairole=="7"){
                            return "员工";
                        }
                        if(row.zhipairole=null){
                            return "未指派人";
                        }
                    }
                },
                {field:"dfgyijhg",title:'操作',width:300,
                    formatter: function(value,row,index){
                    var  zxc=  '<button class="btn btn-primary " id="butt1"  data-dismiss="modal" aria-hidden="true" onclick="tongguo(\''+row.proceid+'\')">通过</button>'
                        +'<button class="btn btn-primary "  id="butt2" data-dismiss="modal" aria-hidden="true" onclick="bohui(\''+row.proceid+'\')">驳回</button>'
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
                $("#divzxc").bootstrapTable('refresh');
            }
        });
    }
    function  bohui(proceid){
        $.ajax({
            url: '<%=request.getContextPath()%>/caoxin/bohui?proceid='+proceid,
            type:"post",
            success:function(){
                $("#divzxc").bootstrapTable('refresh');
            }
        });
    }
</script>
</body>
</html>
