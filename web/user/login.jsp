<%--
  Created by IntelliJ IDEA.
  User: 伟阳
  Date: 2016/1/25
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
            $('#user_login_loginForm').form({
                    url:'${pageContext.request.contextPath}/userAction!login.action',
                    success:function(data){
                            var obj = jQuery.parseJSON(data);
                            if(obj.success) {
                                    $('#user_login_loginDialog').dialog('close');
                                    }
                            $.messager.show({
                                    title:'提示',
                                    msg:obj.msg,
                                    showType:'show'
                                    });
                            }
                    });
            $('#user_login_loginForm input').bind('keyup',function(event){
                    if (event.keyCode == '13'){
                            $('#user_login_loginForm').submit();
                            }
                    });
            });

</script>
<div id="user_login_loginDialog" class="easyui-dialog" title="登陆" style="width:280px;height:150px;padding:10px" align="center"
     data-options="
                modal:true,
                closable:false,
                buttons: [{
                    text:'注册',
                    handler:function(){
                        $('#user_register_registerForm input').val('');
                        $('#user_register_registerForm').form('load',{name:'',pwd:'',rePwd:''});
                        $('#user_register_registerDialog').dialog('open');
                    }
                },{
                    text:'登陆',
                    handler:function(){
                       $('#user_login_loginForm').submit();
                    }
                }]
            ">
    <form id="user_login_loginForm" method="post">
        <table>
            <tr>
                <th>登陆名</th>
                <td><input name="name" autofocus class="easyui-validatebox" data-options="required:true,missingMessage:'登陆名必填'"/></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input name="pwd" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'密码必填'"/></td>
            </tr>
        </table>
    </form>
</div>