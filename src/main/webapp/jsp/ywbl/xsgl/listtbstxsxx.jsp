<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/xsgl/listtbstxsxx.js'></script>
<script type="text/javascript">
$(function() {
	init();
});
</script> 
</head>
<body class="easyui-layout" style="width: 100%; height: 100%; padding: 0; border: 0"
	  data-options='border:false,fit:true'>
<div data-options="region:'north',split:false,collapsible:false,iconCls:'icon-search'" class="easyui-panel" title="查询条件"
	   style="width:100%; height:63px; padding:0px;" cellpadding="0">
<table class='noborder'>
	<tr style="height: 34px">
		<th><label>线索编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入线索编号'" name="q_xsbh"  id="q_xsbh" ></input></td>				
		<th><label>举报人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入举报人'" name="q_jbr"  id="q_jbr" ></input></td>				
		<th><label>登记时间:</label></th>
		<td><input  class="easyui-datebox" data-options="prompt:'输入登记时间'" name="q_djsj"  id="q_djsj" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="线索信息管理">
<table  id="listtbstxsxxdg" class="easyui-datagrid" style="width: 100%; height: 100%"
	data-options="
			region:'center',
			fit:true,
			border:false,
			remoteSort : false,
			toolbar: '#tb',
			pagination:true,
			rownumbers: true,
			checkbox:true,
			singleSelect:true,
			selectOnCheck:false,
			checkOnSelect:false,
			onDblClickRow:function(rowIndex, rowData){
								//SKY_EASYUI.beginEdit('listtbstxsxxdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'ajbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">线索编号</th>
				<th data-options="field:'jbr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">举报人</th>
				<th data-options="field:'zjlx',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">举报人证件类型</th>
				<th data-options="field:'zjhm',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">举报人证件号码</th>
				<th data-options="field:'dh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">电话</th>
				<th data-options="field:'sfd',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">事发地</th>
				<th data-options="field:'sjxq',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">事件详情</th>
				<th data-options="field:'xsly',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">线索来源</th>
				<th data-options="field:'djr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">登记人</th>
				<th data-options="field:'djdw',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">登记单位</th>
				<th data-options="field:'djsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">登记时间</th>
				<th data-options="field:'zt',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">状态</th>
				<th data-options="field:'bz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">备注</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStXsxx()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStXsxx()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStXsxx()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStXsxx()">查看明细</a>
</div>
</body>
</html>