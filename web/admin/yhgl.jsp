<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
            $('#admin_yhgl_datagrid').datagrid({
                    url:'${pageContext.request.contextPath}/userAction!datagrid.action',
                    fit:true,
                    fitColumns:true,
                    border:false,
                    pagination:true,
                    idField:'id',
                    pagePosition:'bottom',
                    rownumbers:false,
                    pageSize:10,
                    pageList:[5,10,20,30,50,100],
                    sortName:"name",
                    sortOrder:"asc",
                    //也可使用这种方法
                    //toolbar:'#admin_yhgl_toolbar',
                    toolbar:[{
                            text:'添加',
                            iconCls:'icon-add',
                            handler:function(){

                                    }
                            },'-',{
                            text:'删除',
                            iconCls:'icon-remove',
                            handler:function(){

                                    }
                            },'-',{
                            text:'修改',
                            iconCls:'icon-edit',
                            handler:function(){

                                    }
                            }],
                    columns:[[
                            {field:'id',title:'编号',width:150,hidden:true,sortable:true},
                            {field:'name',title:'用户名',width:70,sortable:true,formatter:function(value,row,index){
                                    return '<span title="'+value+'">'+value+'</span>';
                                    }},
                            {field:'pwd',title:'密码',width:100,sortable:true,formatter:function(value,row,index){
                                    return '<span title="'+value+'">'+value+'</span>';
                                    }},
                            {field:'createdatatime',title:'创建时间',width:80,sortable:true,formatter:function(value,row,index){
                                    return '<span title="'+value+'">'+value+'</span>';
                                    }},
                            {field:'modifydatatime',title:'最后修改时间',width:80,sortable:true,formatter:function(value,row,index){
                                    return '<span title="'+value+'">'+value+'</span>';
                                    }}
                            ]]
                    });
            });
            function searchFun(){
                    //$('#admin_yhgl_datagrid').datagrid('load',{
                    //      name:$('#admin_yhgl_layout input[name=name]').val()
                    //});
                    $('#admin_yhgl_datagrid').datagrid('load',serializeObject($('#admin_yhgl_searchForm')));
                    }
            function clearFun(){
                    $('#admin_yhgl_datagrid').datagrid('load',{});
                    $('#admin_yhgl_layout input').val('');
                    }
</script>
<div id="admin_yhgl_layout" class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" title="查询条件" style="height: 80px">
        <form id="admin_yhgl_searchForm">
            <table>
                <tr>
                    <td>用户名(支持模糊查询):</td>
                    <td>
                        <input name="name"/>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun()">查询</a>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="clearFun()">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:false">
        <table id="admin_yhgl_datagrid" class="easyui-datagrid"></table>
    </div>
</div>
<%--
<div id="admin_yhgl_toolbar">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="float: left">添加</a>
    <div class="datagrid-btn-separator"></div>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" style="float: left">删除</a>
    <div class="datagrid-btn-separator"></div>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="float: left">修改</a>
</div>--%>
