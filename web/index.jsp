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
                        $('#register_register_registerForm').form('submit',{
                                url:'${pageContext.request.contextPath}/userAction!register.action',
                                success:function(data){
                                        var obj = jQuery.parseJSON(data);
                                        if(obj.success) {
                                                $('#user_register_registerDialog').dialog('close');
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
                        if ($('#register_register_registerForm').form('validate')){
                                $.ajax({
                                        url:'${pageContext.request.contextPath}/userAction!register.action',
                                        data:$('#register_register_registerForm').serialize(),
                                        dataType:'json',
                                        success:function(obj){
                                                //var obj = $.parseJSON(data);
                                                if(obj.success) {
                                                        $('#user_register_registerDialog').dialog('close');
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
    <script type="text/javascript">
        function addTab(opts){
                var t = $('#index_centerTabs');
                if (t.tabs('exists',opts.title)){
                    t.tabs('select',opts.title);
                }else{
                    t.tabs('add',opts);
                }
        }
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'west'" style="width:150px;">
    <div class="easyui-panel" data-options="title:'功能导航',fit:true,border:false">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="系统菜单（异步）" data-options="selected:true">
                <ul class="easyui-tree" data-options="
                url:'${pageContext.request.contextPath}/menuAction!getTreeNode.action'
                ,onClick:function(node){
                    addTab({title:node.text})
                }"></ul>
            </div>
            <div title="系统菜单（同步）">
                <ul class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/menuAction!getAllTreeNode.action',
                parentField:'pid',lines:true,
                onLoadSuccess:function(){$(this).tree('collapseAll')}"></ul>
            </div>
        </div>
    </div>
</div>
<div data-options="region:'center',title:'SSH例子'">
    <div id="index_centerTabs" class="easyui-tabs" data-options="border:false,fit:true">
        <div title="首页"></div>
    </div>
</div>

<jsp:include page="user/login.jsp"/>
<jsp:include page="user/register.jsp"/>


</body>
</html>
