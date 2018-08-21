<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018-08-20
  Time: 16:02
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
<div  id="divzxc" ></div>
<script type="text/javascript">
    $(function(){
        zxc();
    });
    function zxc(){
        $('#divzxc').bootstrapTable({
            url:'<%=request.getContextPath()%>/caoxin/queryLiuChang2',
            method: "post",
            columns:[
                {field:'procedate',title:'时间',width:300},
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
                    }},
                {field:'proceuser',title:'申请人',width:300},
                {field:'woname',title:'流程名字',width:300},
                {field:'act',title:'操作',width:300,
                    formatter: function(value,row,index){

                        if(row.roletext!=null){
                            var  zxc=  '<button class="btn btn-primary " id="butt1"  data-dismiss="modal" aria-hidden="true" onclick="tongguo(\''+row.proceid+'\')">通过</button>'
                                +'<button class="btn btn-primary "  id="butt2" data-dismiss="modal" aria-hidden="true" onclick="bohui(\''+row.proceid+'\')">驳回</button>'
                            return zxc;
                        }
                        if(row.roletext==null){
                            var  zxc=  '<button class="btn btn-default " id="butt1"  data-dismiss="modal" aria-hidden="true" style="color: #4c4c4c">通过</button>'
                                +'<button class="btn btn-default "  id="butt2" data-dismiss="modal" aria-hidden="true" style="color: #4c4c4c">驳回</button>'
                            return zxc;
                        }
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
</script>
</body>
</html>
