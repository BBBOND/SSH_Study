<%--
  Created by IntelliJ IDEA.
  User: 伟阳
  Date: 2016/1/25
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
            $('#user_register_registerForm').form({
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
            $('#user_register_registerForm input').bind('keyup',function(event){
                    if (event.keyCode == '13'){
                            $('#user_register_registerForm').submit();
                            }
                    });
            });

</script>
<div id="user_register_registerDialog" class="easyui-dialog" title="注册" style="width:240px;height:180px;padding:10px"
     data-options="
                modal:true,
                closed:true,
                buttons: [{
                    text:'注册',
                    handler:function(){
                        $('#user_register_registerForm').submit();
                    }
                },{
                    text:'取消',
                    handler:function(){
                        $('#user_register_registerDialog').dialog('close');
                    }
                }]
            ">
    <form id="user_register_registerForm" method="post">
        <table>
            <tr>
                <th>登陆名</th>
                <td><input name="name" autofocus class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名必填'"/></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input name="pwd" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'密码必填'"/></td>
            </tr>
            <tr>
                <th>重复密码</th>
                <td><input type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'重复密码必填',validType:'eqPassword[\'#user_register_registerForm input[name=pwd]\']'"/></td>
            </tr>
        </table>
    </form>
</div>