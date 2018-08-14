<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/11 0011
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
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
<body>
<div class="container-fluid">
        <input type="hidden"  id="workType">

    <div class="row">
        <!-- 左边功能区 -->
        <div class="col-md-2">
            <div  style="background-color: #EBEBEB;height:40px"><h4>流程分类列表</h4>
            </div>
            <div id="myTree"  class="panel-body"></div>


        </div>

        <!-- 右边功能区 -->

        <div class="col-md-10">
            <ul class="nav nav-tabs" id="tablist">
                <li role="presentation" class="active">

                </li>
            </ul>

            <!-- 选项卡下内容 -->
            <div class="tab-content">

                <div role="tabpanel"class="tab-pane active"id="home">
                    <div  style="background-color: #EBEBEB;height:40px">
                        <button type="button" class="btn btn-success"  onclick="tiaozhuan('我定义的模板','modle/addwork')">我定义的模板</button>

                        <%--<div class="input-group">--%>
                            <%--<div  class="input-group-addon" style="width:100px">流程名称 </div>--%>
                            <%--<input type="text"  name="uname" id="orsearch"   style="width:150px" class="form-control" placeholder="请输入手机型号" >--%>
                        <%--</div>--%>


                        <%--<button id="btn_add" onclick="search_list()" type="button" class="btn btn-default list-group-item-success"></button>--%>
                        <%--<span class="glyphicon glyphicon-search" ></span>搜索--%>
                    </div>

                    <div id="dividss"></div>




                </div>
            </div>
        </div>

    </div>

</div>
    <script  type="text/javascript">
        $.ajax({
            url:"<%=request.getContextPath()%>/modle/queryList",
            type:"post",
            success:function(date){
                $("#myTree").treeview({
                    data:date,
                    onNodeSelected:function(event, node) {
                        $("#workType").val(node.url)
                        $("#dividss").bootstrapTable("refresh",{offset:1})
                    }

                })
            }
        })
        $(function(){
            querylist()
        })

        function querylist(){
            $('#dividss').bootstrapTable({
                toolbar:'#toolbar',
                url:'<%=request.getContextPath()%>/modle/queryWork',
                method: "post",
                pagination:true, //是否展示分页
                pageList:[5, 10, 20, 50],//分页组件
                pageNumber:1,
                pageSize:20,//默认每页条数
                //search:true,//是否显示搜索框
                //searchText:'试试',//初始化搜索文字
                showColumns:false,//是否显示 内容列下拉框
                showToggle:false,//是否显示 切换试图（table/card）按钮
                showPaginationSwitch:false,//是否显示 数据条数选择框
                showRefresh:false,//是否显示刷新按钮
                singleSelect : true,//单选

                detailView:false,//设置为 true 可以显示详细页面模式。
                showFooter:false,//是否显示列脚
                clickToSelect: true, //是否启用点击选中行
                contentType:"application/x-www-form-urlencoded;charset=UTF-8",
                sidePagination:'server',//分页方式：client客户端分页，server服务端分页（*
                striped:true,
                queryParams:function(params) {
                   var url= $("#workType").val()
                    params.url=url;
                    return params;
                },
                columns:[
                    {field:'checkse',checkbox:true},
                    {field:'woid',title:'id',width:200},
                    {field:'woname',title:'流程名称',width:200},
                    {field:'workType',title:'所属分类',width:200,
                         formatter: function(value,row,index){
                             if(value==2){
                                 return "人事类";
                             } if(value==3){
                                 return "项目类";
                             }if(value==4){
                                 return "行政类";
                             }
                             if(value==5){
                                 return "库存类";
                             }
                             if(value==6){
                                 return "绩效类";
                             }
                             if(value==7){
                                 return "公文列";
                             }
                             if(value==8){
                                 return "采购类";
                             }
                             if(value==9){
                                 return "合同类";
                             }
                             if(value==10){
                                 return "费用类";
                             }
                             if(value==11){
                                 return "后勤类";
                             }
                         }},
                    {field:'sdhj',title:'操作',width:200,
                        formatter: function(value,row,index){
                            return "<button type=button onclick=\"tiaozhuan('添加属性','modle/attribute')\" class='btn btn-warning'>设置属性</button>";
                        }
                    },
                ]
            });
        }
        function tiaozhuan(text,url){
            var str = $('#dividss').bootstrapTable('getSelections'); //获取表选择的行
            var id="";
            for (var int = 0; int < str.length; int++) {
                id=str[int].woid
            }
            $.addtabs({iframeHeight: 900});
            $.addtabs.add({
                title:text,
                url:"<%=request.getContextPath()%>/"+url+"?woid="+id
            });

        }




    </script>













</body>
</html>
