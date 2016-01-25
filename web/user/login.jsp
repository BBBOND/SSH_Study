<%--
  Created by IntelliJ IDEA.
  User: 伟阳
  Date: 2016/1/25
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="login_login_dialog" class="easyui-dialog" title="登陆" style="width:230px;height:150px;padding:10px"
     data-options="
                modal:true,
                closable:false,
                buttons: [{
                    text:'注册',
                    handler:function(){
                        $('#register_register_form input').val('');
                        $('#register_register_form').form('load',{name:'',pwd:'',rePwd:''});
                        $('#user_register_dialog').dialog('open');
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