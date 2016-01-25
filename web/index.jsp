<%--
  Created by IntelliJ IDEA.
  User: 伟阳
  Date: 2016/1/21
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>SSHE DEMO</title>
    <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/util.js"></script>
    <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/metro/easyui.css" type="text/css">
    <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/icon.css" type="text/css">
    <script type="text/javascript">
        //使用form表单方式提交
                /*function register(){
                        $('#register_register_form').form('submit',{
                                url:'${pageContext.request.contextPath}/userAction!register.action',
                                success:function(data){
                                        var obj = jQuery.parseJSON(data);
                                        if(obj.success) {
                                                $('#register_register_dialog').dialog('close');
                                                }
                                        $.messager.show({
                                                title:'提示',
                                                msg:obj.msg,
                                                showType:'show'
                                                });
                                        }
                                });
                        }*/
                //使用ajax方式提交
                /*function register(){
                        if ($('#register_register_form').form('validate')){
                                $.ajax({
                                        url:'${pageContext.request.contextPath}/userAction!register.action',
                                        data:$('#register_register_form').serialize(),
                                        dataType:'json',
                                        success:function(obj){
                                                //var obj = $.parseJSON(data);
                                                if(obj.success) {
                                                        $('#register_register_dialog').dialog('close');
                                                        }
                                                $.messager.show({
                                                        title:'提示',
                                                        msg:obj.msg,
                                                        showType:'show'
                                                        });
                                                }
                                        });
                                }
                        }*/
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'west',split:false" title="导航栏" style="width:100px;">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <div title="Title1" data-options="selected:true" style="padding:10px;">
            content1
        </div>
        <div title="Title2" style="padding:10px;">
            content2
        </div>
        <div title="Title3" style="padding:10px">
            content3
        </div>
    </div>
</div>
<div data-options="region:'center',title:'Center'">
    <div title="DataGrid" style="padding:5px">
        <table class="easyui-datagrid" data-options="url:'...',method:'get',singleSelect:true,fit:true,fitColumns:true">
            <thead>
            <tr>
                <th data-options="field:'itemid'" width="80">Item ID</th>
                <th data-options="field:'productid'" width="100">Product ID</th>
                <th data-options="field:'listprice',align:'right'" width="80">List Price</th>
                <th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
                <th data-options="field:'attr1'" width="150">Attribute</th>
                <th data-options="field:'status',align:'center'" width="50">Status</th>
            </tr>
            </thead>
        </table>
    </div>
</div>

<jsp:include page="user/login.jsp"/>
<jsp:include page="user/register.jsp"/>


</body>
</html>
