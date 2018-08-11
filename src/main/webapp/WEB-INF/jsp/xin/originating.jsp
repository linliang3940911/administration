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
<form  class="form-inline">
    <div class="input-group">
        <div  class="input-group-addon" style="width:100px">编号 </div>
        <input type="text"  name="bianhao" id="bianhao"   style="width:150px" class="form-control" placeholder="请输入编号" >
    </div>
    <div class="input-group">
        <div  class="input-group-addon" style="width:50px">标题</div>
        <input type="text"  id="biaoti" name="biaoti"  style="width:150px" class="form-control" placeholder="请输入标题" >
    </div>
    <div class="input-group">
        <div  class="input-group-addon" style="width:50px">分类</div>
        <input type="text"  id="fenlei" name="fenlei"  style="width:150px" class="form-control" placeholder="分类" >
    </div><br/><br/>
    <div class="input-group">
        <div  class="input-group-addon" style="width:50px">所属流程</div>
        <input type="text"  id="liuchang" name="liuchang"  style="width:150px" class="form-control" placeholder="所属流程" >
    </div>
</form>	<br/>
<button id="btn_add" onclick="search_list()" type="button" class="btn btn-default list-group-item-success">
    <span class="glyphicon glyphicon-search" ></span>搜索
</button>
<button class="btn btn-primary " onclick="xinzeng()" data-target="#myModal">新增数据</button>
<button class="btn btn-primary " onclick="tiaozhuan()" data-target="#myModal">批量删除</button>
<div id="dividss"></div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="table" id="Coupon"></div>
            <span id="span-id"></span>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
            url:'<%=request.getContextPath()%>/caoxin/queryCaogao',
            method: "post",
            pagination: true,
            pageList:[1, 10, 20, 50],//分页组件
            pageNumber:1,
            pageSize:5,//默认每页条数
            //search:true,//是否显示搜索框
            //searchText:'试试',//初始化搜索文字
            height: 700,
            showColumns:false,//是否显示 内容列下拉框
            showToggle:false,//是否显示 切换试图（table/card）按钮
            showPaginationSwitch:false,//是否显示 数据条数选择框
            showRefresh:true,//是否显示刷新按钮
            singleSelect : true,//单选
            detailView:false,//设置为 true 可以显示详细页面模式。
            showFooter:false,//是否显示列脚
            clickToSelect: true, //是否启用点击选中行
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            sidePagination:'server',//分页方式：client客户端分页，server服务端分页（*
            striped:true,

            queryParams:function(params) {
                var bianhao =$("#bianhao").val();
                var biaoti =$("#biaoti").val();
                var fenlei =$("#fenlei").val();
                var liuchang =$("#liuchang").val();
                params.bianhao=bianhao;
                params.biaoti=biaoti;
                params.fenlei=fenlei;
                params.liuchang=liuchang;
                return params;
            },
            columns:[
                {field:'userchek',checkbox:true},
                {field:'xiangid',title:'id',width:350},
                {field:'bianhao',title:'编号/自定义标题',width:300,
                    formatter: function(value,row,index){
                        var zxc=row.bianhao;
                        var asd=row.biaoti;
                        return  zxc+"<br>"+asd;
                    }

                },
                {field:'fenlei',title:'所属分类/所属流程',width:300,
                    formatter: function(value,row,index){
                       var zxc=row.fenlei;
                        var asd=row.liuchang;
                        return  zxc+"<br>"+asd;
                    }
                },
                {field:'bainjishiqi',title:'最后编辑日期',width:300},
                {field:'act',title:'操作',width:300,
                    formatter: function(value,row,index){
                        return '<button class="btn btn-primary " onclick="queryPhoneListById()"  data-toggle="modal" data-target="#myModal">修改</button>';
                    }
                },
            ]
        });

    }
    function querysjyg(params) {
        var p = formDataCache || {};//全局变量formDataCache保存表单数据
        p.limit = params.limit;
        p.sort = params.sort;
        p.order = params.order;
        p.offset = params.offset;
        return p;
    }







    function tiaozhuan(){
        var arr=$('#dividss').bootstrapTable('getSelections');
            var ids="";
            var count=0;
            for(var i=0;i<arr.length;i++){
                ids+=",'"+arr[i]['xiangid']+"'";
                count++;
            }

            ids=ids.substring(1);
            if(confirm("你确定删除"+count+"条信息吗")){
                alert(ids);
                $.ajax({
                    url:"<%=request.getContextPath()%>/caoxin/deleteCaogao",
                    data:{"ids":ids},
                    type:"post",
                    datatype:'json',
                    success:function(result){
                        if(result ==1 ){
                            alert("成功")
                            $('#dividss').bootstrapTable("refresh");
                        }
                    }
                });

        }


    }


    function addohih(){
        $.ajax({
            url:"<%=request.getContextPath()%>/phonelist/insertPhoneList.do",
            data:$("#char_forms").serialize(),
            type:"post",
            datatype:'json',
            success:function(result){
                if(result ==1 ){
                    alert("成功")
                    $('#dividss').bootstrapTable('refresh');
                }
            }
        });
    }


    function queryPhoneListById(){
        var arrselections = $("#dividss").bootstrapTable('getSelections');
        var id=""
        for (var int = 0; int < arrselections.length; int++) {
            id=arrselections[int].id
        }
        $.ajax({
            url: '<%=request.getContextPath()%>/phonelist/queryPhoneListById.do?id='+id,
            type:"post",
            success:function(result){
                $("#span-id").html(result) ;
                $("#span-id2").html('<button type="button" class="btn btn-primary" onclick="updatecharge()">提交</button>')
            }
        });
    }

    function updatecharge(){
        $.ajax({
            url:"<%=request.getContextPath()%>/phonelist/UpdatePhone.do",
            data:$("#char_forms").serialize(),
            type:"post",
            datatype:'json',
            success:function(result){
                if(result ==1 ){
                    $('#dividss').bootstrapTable('refresh');
                }
            }
        });
    }

    function deletePhoneList(){
        var arrselections = $("#dividss").bootstrapTable('getSelections');
        var ids=""
        for (var int = 0; int < arrselections.length; int++) {
            ids=","+arrselections[int].id
        }
        ids=ids.substring(1);
        alert(ids)
        bootbox.confirm("确认删除", function (e) {
            if (!e) {
                return;
            }
            $.ajax({
                url:"<%=request.getContextPath()%>/caoxin/deleteCaogao",
                type:"post",
                data:{ids:ids},
                success:function(result){
                    $('#dividss').bootstrapTable('refresh');
                }
            })
        });
    }

</script>
</body>
</html>
