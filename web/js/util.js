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
/**
* @author Kim
*
* 防止panel/window/dialog超出浏览器边界
*
* @param left
* @param top
*/
var easyuiPanelOnMove = function(left,top){
    var l = left;
    var t = top;
    if (l <1){
        l= 1;
    }
    if (t < 1){
        t = 1;
    }
    var width = parseInt($(this).parent().css('width')) + 14;
    var height = parseInt($(this).parent().css('height')) + 14;
    var right = l + width;
    var buttom = t + height;
    var browserWidth = $(window).width();
    var browserHeight = $(window).height();
    if (right > browserWidth){
        l = browserWidth - width;
    }
    if (buttom > browserHeight){
        t = browserHeight - height;
    }
    $(this).parent().css({
        left:l,
        top:t
    });
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;

/**
* 将form表单元素的值序列化为对象
* @param form
* @returns {{}}
*/
serializeObject = function(form){
    var o = {};
    $.each(form.serializeArray(),function(index){
        if (o[this['name']]) {
            o[this['name']] = o[this['name']] + "," + this['value'];
        } else {
            o[this['name']] = this['value'];
        }
    });
    return o;
};