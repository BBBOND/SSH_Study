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
<div id="admin_center_centerTabs" class="easyui-tabs" data-options="border:false,fit:true" style="overflow: hidden">
    <div title="首页"></div>
</div>