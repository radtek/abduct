<%@page import="org.sky.sys.utils.CommonUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/zlgl/zlxf/edittbstzlxf.js'></script>
<script type="text/javascript">
var datetime = '<%=CommonUtils.getCurrentDate() %>';
var orgCode = '<%=BspUtils.getLoginUser().getOrganCode() %>';
var orgName = '<%=BspUtils.getLoginUser().getOrganName() %>'
var zlbh = '${zlbh}'
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#editPageButtonsFt'">
		<form id="addedittbstzlxfform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<input type='hidden' name='jsdw' id='jsdw'/>
			<input type='hidden' name='txr' id='txr'/>
			<input type='hidden' name='xfdw' id='xfdw'/>
			<table style="width:100%">
				  <tr>
					<th><label>指令编号:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="zlbh" id="zlbh" style="width:200px"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
				  	<th><label>下发单位:</label></th>
					<td><input class="easyui-textbox" name="xfdwName" id="xfdwName"
						data-options="required:true"></input></td>
					<th><label>下发时间:</label></th>
					<td><input class="easyui-datetimebox" name="xfsj" id="xfsj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>指令名称:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="zlmc" style='width:400;height:50'
						data-options="multiline:true,required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>指令内容:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="zlnr" style='width:400;height:50'
						data-options="multiline:true,required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>接收单位:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="jsdwName" id="jsdwName" style='width:400;height:50'
						data-options="multiline:true,required:true"></input>
						<a href="javascript:openOrganHelp()"class="easyui-linkbutton" plain="true" iconCls="icon-search">选择</a>
						</td>
				  </tr>
				  <tr>
					<th><label>提醒人:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="txrName" id="txrName" style='width:400;height:50'
						data-options="multiline:true,required:true"></input>
						<a href="javascript:openUserHelp()"class="easyui-linkbutton" plain="true" iconCls="icon-search">选择</a>
						</td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="bz" style='width:400;height:50'
						data-options="multiline:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='editPageButtonsFt' style="text-align:center; padding:0px; top:0px">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-save'
		onclick="submitAddEditTbStZlxfForm()">保存</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>