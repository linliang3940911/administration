<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13 0013
  Time: 21:42
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
        <div id="querylistyProceduress"></div>


  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                  <span id="span-id2"></span>
              </div>

              <div class="table" id="Coupon"></div>
              <span id="span-id"></span>

              <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal"  onclick="addshenqingliycheng(0)">保存</button>
                  <button type="button" class="btn btn-default" onclick="addshenqingliycheng(1)">提交</button>

              </div>
          </div>
      </div>
  </div>



    <script type="text/javascript">
        $(function(){
            querylist();
        })

        function querylist(){
            $('#querylistyProceduress').bootstrapTable({
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
                            return "<button type=button onclick=\"tiaozhuan()\" class=\"btn btn-warning\"  >发起申请</button>";
                        }
                    },
                ]
            });
        }
         var id=""
            function tiaozhuan(){
                var str = $("#querylistyProceduress").bootstrapTable("getSelections"); //获取表选择的行

                var name="";
                for (var int = 0; int < str.length; int++) {
                    id=str[int].woid
                    name=str[int].woname
                }
                $.ajax({
                    url:"<%=request.getContextPath()%>/modle/application?woid="+""+id+"",
                    type:"post",
                    success:function(result){
                        $("#myModal").modal('show');  //手动开启
                        $("#span-id").html(result)
                        $("#span-id2").html(" <h4 class=\"modal-title\" id=\"myModalLabel\">"+name+"</h4>")
                    }
                })
            }

            function addshenqingliycheng(value){
               $.ajax({
                url:"<%=request.getContextPath()%>/modle/addshenqingliycheng",
                type:"post",
                data:{woid:id,proceType:value},
                success:function(result){
                    if(result==1){
                    alert("添加成功")
                        $("#myModal").modal('hide');  //手动开启
                    }
                }
                })
            }

    </script>
</body>
</html>
