<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/xxbk/bkcx/detailtbstbkcx.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt'">
		<form id="detailtbstbkcxform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>布控编号:</label></th>
					<td><input class="easyui-textbox" name="bkbh"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>业务类型:</label></th>
					<td><input class="easyui-textbox" name="ywlx"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>业务编号:</label></th>
					<td><input class="easyui-textbox" name="ywbh"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>监控时间:</label></th>
					<td><input class="easyui-textbox" name="jksj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>状态:</label></th>
					<td><input class="easyui-textbox" name="zt"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td><input class="easyui-textbox" name="bz"
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
</html>