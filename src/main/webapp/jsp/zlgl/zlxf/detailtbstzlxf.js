/**
 * 初始化指令下发详细页面
 */
function initDetailTbStZlxfPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"zlgl/TbStZlxf/getTbStZlxfByZlbh?zlbh="+paramOpts.data.zlbh;
	$('#detailtbstzlxfform').form('load',SKY.urlCSRF(url));
}
