<#include "../../common/globalDef.ftl">
<@simpleList 1150>
<form name="defaultForm" action="${siteUrl}/manage/loginLogList" method="post" >

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
	<table class="table table-striped table-bordered table-hover" style="min-width:1100px;">
		<thead>
		<tr>
			<th><input type="text" name="userId" value="<#if example.userId?? && example.userId gt 0 >${example.userId!}</#if>" class="form-control" style="width:120px;"/></th>
			<th><input type="text" name="userName" value="${example.userName!}" class="form-control" style="width:120px;"/></th>
			<th><input type="text" name="loginIp" value="${example.loginIp!}" class="form-control" style="width:120px;"/></th>
			<th><input type="text" name="loginArea" value="${example.loginArea!}" class="form-control" style="width:200px;"/></th>
			<th>
				<select class="form-control" name="loginResult" style="width:120px;">
		        	<option value=0 <#if example.loginResult==0>selected="selected"</#if> >-请选择-</option>
			        <option value=1000 <#if example.loginResult==1000>selected="selected"</#if> >登录成功</option>
			        <option value=9999 <#if example.loginResult==9999>selected="selected"</#if> >登录失败</option>
		        </select>
			</th>
			<th style="width:160px;">
				<@shDateBeginEnd "logTimeSh" example.logTimeSh! />
			</th>
		</tr>
		</thead>
		<thead>
			<tr>
				<@seqTh page "defaultForm" "user_id" >用户ID</@seqTh>
				<@seqTh page "defaultForm" "user_name" >用户名</@seqTh>
				<@seqTh page "defaultForm" "login_ip" >登录IP</@seqTh>
				<@seqTh page "defaultForm" "login_area" >登录地</@seqTh>
				<@seqTh page "defaultForm" "login_result" >登录结果</@seqTh>
				<@seqTh page "defaultForm" "log_time" >登录时间</@seqTh>
			</tr>
		</thead>
	</table>
</div>
<div class="widget-content autoTbody" >
	<table class="table table-striped table-bordered table-hover" style="min-width:1100px;">
		<tbody>
	<#list page.items as item>
		<tr>
			<td>${item.userId!}</td>
			<td>${item.userName!}</td>
			<td>${item.loginIp!}</td>
			<td>${item.loginArea!}</td>
			<td>
			    <#if 1000==item.loginResult>登录成功</#if>
			   	<#if 9999==item.loginResult>登录失败</#if>
			</td>
			<td>${item.logTime?datetime!}</td>
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