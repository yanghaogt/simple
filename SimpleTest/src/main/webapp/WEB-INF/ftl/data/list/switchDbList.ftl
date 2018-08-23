<#include "../../common/globalDef.ftl">
<#assign spring=JspTaglibs["http://www.springframework.org/tags"]/>
<@simpleList 1450>
<form name="defaultForm" id="defaultForm" action="${siteUrl}/data/switchDB" method="post" >
<div class="widget-head">
	<div class="pull-left">
	</div>
	<div class="pull-right">
		<input  type="submit" class="btn btn-success" value="搜索">
	</div>
	<div class="clearfix"></div>
</div>

<div class="widget-content autoHeader">
	<table class="table table-striped table-bordered table-hover" style="min-width:1400px;">
		<thead>
		<tr>
			<th style="width:13%;">
				<select id="serverListSelect" class="form-control" name="serverId" style="width:100%">
					<#if serverList??>
					    <#list serverList as item>
					     	<option value="${item.sId!}" <#if example.serverId?? && example.serverId == item.sId>selected="selected"</#if>>${item.sName!}</option>
					    </#list>
				    </#if>
				</select>
			</th>
			<th style="width:10%;"></th>
			<th style="width:10%;"></th>
			<th style="width:14%;"></th>
			<th style="width:11%;"></th>
			<th style="width:13%;"></th>
			<th style="width:15%;"></th>
			<th style="width:15%;"></th>	
		</tr>
		</thead>
		<thead>
			<tr>
				<th>活动ID</th>
				<th>活动类型</th>
				<th>活动名字</th>
				<th>活动时间</th>
				<th>时间编辑</th>
				<th>活动状态</th>
				<th>发布状态</th>
				<th>奖励编辑</th>
			</tr>
		</thead>
	</table>
</div>
<div class="widget-content autoTbody" >
	<table class="table table-striped table-bordered table-hover" style="min-width:1400px;">
		<tbody>
			<#if page??>
				<#list page.items as item>
					<tr>
						<td>${item.id!}</td>
						<td>${item.typeDesc!}</td>
						<td>${item.des!}</td>
						<td>${item.times!}</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>				
					</tr>
				</#list>
			</#if>
		</tbody>
	</table>
</div>
<div class="widget-foot">
	<@pagination page "defaultForm"/>
</div>
</form>
</@simpleList>
