<#include "../../common/globalDef.ftl">
<@simpleList 1400>
<form name="defaultForm" action="${siteUrl}/manage/operateLogList" method="post" >

<div class="widget-head">
	<div class="pull-left">
		<input type="submit" class="btn btn-success" value="搜索">
	</div>
	<div class="pull-right">
		<button  type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>

<div class="widget-content autoHeader" >
	<table class="table table-striped table-bordered table-hover" style="min-width:1200px;">
		<thead >
			<tr>
				<th style="width:120px;"><input type="text" name="molId" value="<#if example.molId?? && example.molId gt 0 >${example.molId!}</#if>" class="form-control" style="width:120px;"/></th>
				<th style="width:120px;"><input type="text" name="userId" value="<#if example.userId?? && example.userId gt 0 >${example.userId!}</#if>" class="form-control" style="width:120px;"/></th>
				<th style="width:120px;"><input type="text" name="userName" value="${example.userName!}" class="form-control" style="width:120px;"/></th>
				<th style="width:160px;">
					<@shDateBeginEnd "logTimeSh" example.logTimeSh! />
				</th>
				<th style="width:120px;"><input type="text" name="operateName" value="${example.operateName!}" class="form-control" style="width:120px;"/></th>
				<th style="width:300px;"><input type="text" name="methodName" value="${example.methodName!}" class="form-control" style="width:300px;"/></th>
			</tr>
			<tr>
				<@seqTh page "defaultForm" "mol_id" >日志ID</@seqTh>
				<@seqTh page "defaultForm" "user_id" >用户ID</@seqTh>
				<@seqTh page "defaultForm" "user_name" >用户名</@seqTh>
				<@seqTh page "defaultForm" "log_time" >操作时间</@seqTh>
				<@seqTh page "defaultForm" "operate_name" >操作名</@seqTh>
				<@seqTh page "defaultForm" "method_name" >方法名</@seqTh>
			</tr>
		</thead>
	</table>
</div>

<div class="widget-content autoTbody" >
	<table class="table table-striped table-bordered table-hover" style="min-width:1200px;">
		<tbody class="scrollContent">
		<#list page.items as item>
			<tr>
				<td>${item.molId!}</td>
				<td>${item.userId!}</td>
				<td>${item.userName!}</td>
				<td>${item.logTime?datetime!}</td>
				<td>${item.operateName!}</td>
				<td>${item.methodName!}</td>
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