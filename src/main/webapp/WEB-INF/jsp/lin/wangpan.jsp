<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/15 0015
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap3/js/bootstrap.js"></script>
<link href="<%=request.getContextPath()%>/js/fileinput.css" media="all" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap3/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap-treeview/bootstrap-treeview.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootStrap-addTabs/bootstrap.addtabs.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap-table/dist/bootstrap-table.css">
<script src="<%=request.getContextPath()%>/js/bootstrap-table/dist/bootstrap-table.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-table/dist/locale/bootstrap-table-zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/js/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-treeview/bootstrap-treeview.min.js"></script>
<script src="<%=request.getContextPath()%>/js/fileinput.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/fileinput_locale_de.js" type="text/javascript"></script>
<!-- dialog -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/bootstrap-dialog/dist/css/bootstrap-dialog.css" >
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-dialog/dist/js/bootstrap-dialog.js"></script>
<script src="<%=request.getContextPath()%>/js/bootbox.min.js"></script>

<script src="<%=request.getContextPath()%>/js/jquery.contextmenu.r2.js"></script>
<body>
<input type="hidden"  id="textid" value="0">
<input type="hidden"  id="pid" >
<div >

    <button type="button" class="btn btn-primary"  onclick="xiangshang()">向上</button>
    <button type="button" class="btn btn-success"   onclick="deleteByid()   ">删除</button>
    <button type="button" class="btn btn-info"  onclick="shangChuan()">上传文件</button>
    <button type="button" class="btn btn-danger"   onclick="addpackage()">新建文件夹</button>双击文件夹进入, 点击右键可显示更多选项
</div>
<div id="wangpan"   class="demo1" style="color:green;"></div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <span id="span-id2"></span>
            </div>

            <div class="table" id="Coupon"></div>
            <form  id="form-id">
            <span id="span-id"></span>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <span id="span-id3"></span>
            </div>
        </div>
    </div>
</div>










<div class="contextMenu" id="myMenu1">
    <ul>
        <li id="open" >重命名</li>
        <li id="email">删除</li>

    </ul>
</div>
<script type="text/javascript">
    $(function () {
        querylist()
    })
    function querylist(){
        $('#wangpan').bootstrapTable({
            toolbar:'#toolbar',
            url:'<%=request.getContextPath()%>/modle/querylistWangPan',
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
            singleSelect : false,//单选
            detailView:false,//设置为 true 可以显示详细页面模式。
            showFooter:false,//是否显示列脚
            clickToSelect: true, //是否启用点击选中行
            contentType:"application/x-www-form-urlencoded;charset=UTF-8",
            sidePagination:'server',//分页方式：client客户端分页，server服务端分页（*
            striped:true,
            onDblClickRow: function (row) {

                if(row.allname=='文件夹'){
                    $("#textid").val(row.id)
                    search_list()
                    $("#pid").val(row.pid);
                }
            },
            queryParams:function(params) {
                var id =$("#textid").val();
                var pid =$("#pid").val();
                params.id=id;
                params.pid=pid;
                return params;
            },
            columns:[
                {field:'checkse',checkbox:true},
                {field:'id',title:'id',width:200},
                {field:'text',title:'流程名称',width:200,
                    formatter: function(value,row,index){

                        return "<img src="+row.url+" width=30px  height=30px>"+value;
                    }
                },
                {field:'upddate',title:'流程名称',width:200

                },
                {field:'allname',title:'流程名称',width:200},
                {field:'sdhj',title:'操作',width:200,
                    formatter: function(value,row,index){
                        return " ";
                    }
                },
            ]
        });
    }

    $('div.demo1').contextMenu('myMenu1',
        {
            bindings:
                {
                    'open': function(t) {

                    },
                    'email': function(t) {
                        deleteByid()
                        $("#wangpan").bootstrapTable("refresh",{offset:1})
                    },

                }
        });

    function search_list(){
        $("#wangpan").bootstrapTable("refresh",{offset:1})
    }
    function addpackage(){
        $("#myModal").modal('show');  //手动开启
        $("#span-id").html(' <input type="text"  name="uname" id="orsearch"    class="form-control" placeholder="请输入文件夹名称" >  ')
        $("#span-id2").html("<h3>新建文件夹</h3>")
        $("#span-id3").html('<button type="button" class="btn btn-default" onclick="addpackages()" data-dismiss="modal">提交</button>')
    }
    function addpackages(){
        var str=$("#textid").val()
        var text=$("#orsearch").val()
      $.ajax({
      url:"<%=request.getContextPath()%>/modle/addpackages",
      type:"post",
      data:{text:text,id:str},
      success:function(result){
        if(result==1){
            alert("添加成功")
            search_list()
        }
     }
       })
    }
    function shangChuan(){
        $("#myModal").modal('show');  //手动开启
        var str='<input type="file" name="myfile" data-ref="url2" class="col-sm-10 myfile" value="" /> <input type="hidden" name="url2" value="">'
        $("#span-id").html(str)
        $("#span-id2").html('上传文件')
        $("#span-id3").html('<button type="button" class="btn btn-default" id="input" data-dismiss="modal">提交</button>')
        var strss=$("#textid").val()
        $(".myfile").fileinput({
            //上传的地址
            uploadUrl:"<%=request.getContextPath()%>/modle/uploadFile?pid="+strss,
            uploadAsync : true, //默认异步上传
            showUpload : false, //是否显示上传按钮,跟随文本框的那个
            showRemove : false, //显示移除按钮,跟随文本框的那个
            showCaption : true,//是否显示标题,就是那个文本框
            showPreview : true, //是否显示预览,不写默认为true
            dropZoneEnabled : false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
            //minFileCount: 0,
            maxFileCount : 1, //表示允许同时上传的最大文件个数
            enctype : 'multipart/form-data',
            language : 'zh'
        })
    }

    function xiangshang(){
        $("#wangpan").bootstrapTable("refresh",{offset:1})
    }
    function deleteByid(){
        var str = $("#wangpan").bootstrapTable("getSelections"); //获取表选择的行
        var id = "";
        for (var int = 0; int < str.length; int++) {
            id = str[int].id
        }
        $.ajax({
            url: "<%=request.getContextPath()%>/modle/deleteByIdWangPan",
            type: "post",
            data: {id: id},
            success: function (result) {
                if(result==1){
                    alert("成功")
                    $("#wangpan").bootstrapTable("refresh",{offset:1})
                }
            }
        })
    }
    function updateByid(){
        var str = $("#wangpan").bootstrapTable("getSelections"); //获取表选择的行
        var id="";
        for (var int = 0; int < str.length; int++) {
            id=str[int].id
        }
        $.ajax({
         url:"",
         type:"post",
         data:{},
         success:function(){


        }
        })


    }




</script>
</body>
</html>
