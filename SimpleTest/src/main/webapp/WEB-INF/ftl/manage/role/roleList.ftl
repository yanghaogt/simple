<#include "../../common/globalDef.ftl">
<@simpleList 500>
<form name="defaultForm" action="${siteUrl}/manage/roleList" method="post" >

<div class="widget-head">
	<div class="pull-left">
		<input type="submit" class="btn btn-success" value="搜索">
		<input type="button" class="btn btn-success" onclick="showSimplePop('${siteUrl}/manage/roleAddPage','添加角色')" value="添加">
	</div>
	<div class="pull-right">
		<button  type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>
<div class="widget-content autoHeader" >
	<table class="table table-striped table-bordered table-hover" style="min-width:450px;">
		<thead>
		<tr>
			<th><input type="text" name="mrId" value="<#if example.mrId?? && example.mrId gt 0 >${example.mrId}</#if>" class="form-control" style="width:120px;"/></th>
			<th><input type="text" name="roleName" value="${example.roleName!}" class="form-control" style="width:120px;"/></th>
			<th></th>
		</tr>
		</thead>
		<thead>
			<tr>
				<@seqTh page "defaultForm" "mr_Id" >角色编号</@seqTh>
				<@seqTh page "defaultForm" "role_Name" >角色名</@seqTh>
				<th>操作</th>
			</tr>
		</thead>
	</table>
	
	
</div>

<div class="widget-content autoTbody" >
	<table class="table table-striped table-bordered table-hover" style="min-width:450px;">
		<tbody>
	<#list page.items as item>
		<tr>
			<td>${item.mrId!}</td>
			<td>${item.roleName!}</td>
			<td>
				<input type="button" class="btn btn-xs btn-warning" onclick="showSimplePop('${siteUrl}/manage/roleEditPage?mrId=${item.mrId}','修改角色')" value="修改">
            </td>
		</tr>
	</#list>
		</tbody>
	</table>
	
	
</div>
<div class="widget-foot">
	<@pagination page "defaultForm"/>
</div>
</form>
</@simpleList>