<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="admin_yhglEdit_editForm" method="post">
    <table>
        <tr>
            <th>编号</th>
            <td><input name="id" readonly="readonly"></td>
            <th>登录名</th>
            <td><input name="name" autofocus class="easyui-validatebox" data-options="required:true"></td>
        </tr>
        <tr>
            <th>密码</th>
            <td><input name="pwd" class="easyui-validatebox" data-options="required:true"></td>
            <th>创建时间</th>
            <td><input name="createdatetime"></td>
        </tr>
        <tr>
            <th>最后修改时间</th>
            <td><input name="modifydatetime"></td>
            <th></th>
            <td></td>
        </tr>
    </table>
</form>