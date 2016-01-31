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
                    rownumbers:false,
                    pageSize:5,
                    pageList:[5,10,20,30,50,100],
                    sortName:"name",
                    sortOrder:"asc",
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
</script>
<table id="admin_yhgl_datagrid" class="easyui-datagrid">

</table>