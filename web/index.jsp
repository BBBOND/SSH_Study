<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>SSHE DEMO</title>
    <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/util.js"></script>
    <link rel="stylesheet" href="js/jquery-easyui-1.4.4/themes/gray/easyui.css" type="text/css">
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
</head>
<body class="easyui-layout">
<div data-options="region:'west'" style="width:150px;">
    <jsp:include page="layout/west.jsp"/>
</div>
<div data-options="region:'center',title:'SSH例子'" style="overflow: hidden">
    <jsp:include page="layout/center.jsp"/>
</div>

<jsp:include page="user/login.jsp"/>
<jsp:include page="user/register.jsp"/>


</body>
</html>
