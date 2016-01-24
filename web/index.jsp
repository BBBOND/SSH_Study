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
        $(function(){

                });
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
<div id="index_login_Dialog" class="easyui-dialog" title="登陆" style="width:230px;height:150px;padding:10px"
     data-options="
                modal:true,
                closable:false,
                buttons: [{
                    text:'注册',
                    handler:function(){
                        $('#index_register_dialog').dialog('open');
                    }
                },{
                    text:'登陆',
                    handler:function(){

                    }
                }]
            ">
    <table>
        <tr>
            <th>登陆名</th>
            <td><input class="easyui-validatebox" data-options="required:true"/></td>
        </tr>
        <tr>
            <th>密码</th>
            <td><input class="easyui-validatebox" data-options="required:true"/></td>
        </tr>
    </table>
</div>

<div id="index_register_dialog" class="easyui-dialog" title="注册" style="width:240px;height:180px;padding:10px"
     data-options="
                modal:true,
                closed:true,
                buttons: [{
                    text:'注册',
                    handler:function(){
                        $('#index_register_form').form({
                            url:'${pageContext.request.contextPath}/userAction!register.action',
                            success:function(data){
                                var obj = jQuery.parseJSON(data);
                                if(obj.success) {
                                    $('#index_register_dialog').dialog('close');
                                }
                                $.messager.show({
                                    title:'提示',
                                    msg:obj.msg,
                                    showType:'show'
                                });
                            }
                        });
                        $('#index_register_form').submit();
                    }
                },{
                    text:'取消',
                    handler:function(){
                        $('#index_register_dialog').dialog('close');
                    }
                }]
            ">
    <form id="index_register_form" method="post">
        <table>
            <tr>
                <th>登陆名</th>
                <td><input name="name" class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名必填'"/></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input name="pwd" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'密码必填'"/></td>
            </tr>
            <tr>
                <th>重复密码</th>
                <td><input name="rePwd" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'重复密码必填',validType:'eqPassword[\'#index_register_form input[name=pwd]\']'"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
