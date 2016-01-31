/**
* @author Kim
*
* @requires jQuery,EasyUI
*
* 验证两次密码是否重复
*/
$.extend($.fn.validatebox.defaults.rules, {
    eqPassword : {
        validator : function(value,param) {
            return value == $(param[0]).val();
        },
        message:'密码不一致!'
    }
});

/**
* @requires jQuery,EasyUI
*
* tree的简单数据类型的解析
*/
$.fn.tree.defaults.loadFilter = function (data, parent) {
	var opt = $(this).data().tree.options;
	var idFiled,
	textFiled,
	parentField;
	if (opt.parentField) {
		idFiled = opt.idFiled || 'id';
		textFiled = opt.textFiled || 'text';
		parentField = opt.parentField;
		var i,l,treeData = [],tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idFiled]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['text'] = data[i][textFiled];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['text'] = data[i][textFiled];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};

/**
* @author Kim
*
* panel关闭时回收内存
*/
$.fn.panel.defaults.onBeforeDestroy = function(){
    var frame = $('iframe',this);
    try{
        if (frame.length > 0){
            for (var i = 0;i < frame.length;i++){
                frame[i].contentWindow.document.write('');
                frame[i].contentWindow.close();
            }
            frame.remove();
            if ($.browser.msie){
                CollectGarbage();
            }
        }
    }catch (e){

    }
};