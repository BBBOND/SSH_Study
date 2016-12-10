<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    function addTab(opts){
            var t = $('#admin_center_centerTabs');
            if (t.tabs('exists',opts.title)){
                    t.tabs('select',opts.title);
                    }else{
                    t.tabs('add',opts);
                    }
            }
</script>
<div class="easyui-panel" data-options="title:'功能导航',fit:true,border:false">
    <div class="easyui-accordion" data-options="fit:true,border:false">
        <div title="系统菜单（异步）" data-options="selected:true">
            <ul class="easyui-tree" data-options="
                url:'${pageContext.request.contextPath}/menuAction!getTreeNode.action'
                ,onClick:function(node){
                    if(node.attributes.url){
                        var url = '${pageContext.request.contextPath}' + node.attributes.url;
                        addTab({title:node.text,href:url,closable:true});
                    }
                }"></ul>
            <%--href缺点：1. 代码片段页script只能写在body内部
                         2. id必须不同--%>
            <%--上面href可用content:'<iframe src="'${pageContext.request.contextPath}' + node.attributes.url+" frameborder="0" style="border:0;width:100%;height:99%;"></iframe'--%>
            <%--缺点：1. 高度本能是100%
                     2. 外层和内层交互比较麻烦(访问父层parent.xxx)
                     3. 模式化窗口只能覆盖当前的iframe
                     4. IE浏览器中在关闭tab时不销毁(使用util.js中的方法可解决，适用于1.2.6以上)--%>
        </div>
        <div title="系统菜单（同步）">
            <ul class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/menuAction!getAllTreeNode.action',
                parentField:'pid',
                lines:true,
                onLoadSuccess:function(){$(this).tree('collapseAll')},
                onClick:function(node){
                    console.info(node.attributes.url);
                    if(node.attributes.url){
                        var url = '${pageContext.request.contextPath}' + node.attributes.url;
                        addTab({title:node.text,href:url,closable:true});
                    }
                }"></ul>
        </div>
    </div>
</div>
