<#include "../../common/globalDef.ftl">
<@simpleList 1500>
<form name="defaultForm" id="defaultForm" action="${siteUrl}/data/batchList" method="post" >
<div class="widget-head">
	<div class="pull-left">
		<input  type="submit" class="btn btn-success" value="搜索" onclick="query()">
		<input  type="button" class="btn btn-success" value="导入" onclick="showSimplePop('${siteUrl}/data/batchAddPage','添加')">
		<#-- <input  type="button" class="btn btn-success" value="导出" id="export"> -->
	</div>
	<div class="pull-right">
		<button type="button" class="btn btn-default" onclick="comfirmRes('defaultForm','${siteUrl}/data/sendBatch','确定发放?')">批量发放</button>
		<button type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>
<div class="widget-content autoHeader">
	<table class="table table-striped table-bordered table-hover" style="min-width:1450px;">
		<thead>
			<tr>
				<th style="width:2%;"></th>
				<th style="width:6%;"></th>
				<th style="width:7%;">
					<select class="form-control" name="sendType" id="isAll">
						<option value="-1">请选择</option>
						<option value="1" <#if example.sendType?? && example.sendType == 1>selected="selected"</#if>>所有玩家</option>
						<option value="0" <#if example.sendType?? && example.sendType == 0>selected="selected"</#if>>指定角色名</option>
						<option value="2" <#if example.sendType?? && example.sendType == 2>selected="selected"</#if>>导入角色名</option>
						<option value="3" <#if example.sendType?? && example.sendType == 3>selected="selected"</#if>>指定角色ID</option>
						<option value="4" <#if example.sendType?? && example.sendType == 4>selected="selected"</#if>>导入角色ID</option>
					</select>
				</th>
				<th style="width:10%;"><input type="text" name="serverId" id="serverId" list="serverList" style="width:100%;"/></th>
				<th style="width:8%;"><input type="text" name="channelId" id="channelId" list="channelList" style="width:100%;"/></th>
				<th style="width:16%;"><input type="text" name="acceptRoleList" value="${example.acceptRoleList!}" class="form-control" style="width:100%;"/></th>
				<th style="width:10%;"></th>
				<th style="width:11%;"></th>
				<th style="width:6%;"></th>
				<th style="width:7%;">
					<select class="form-control" name="status">
						<option value="">请选择</option>
						<#if applyMap??>
							<#list applyMap.keySet() as status>
								<option value="${status!}" <#if example.status?? && example.status == status>selected="selected"</#if>>${applyMap.get(status)!}</option>	
						    </#list>
				    	</#if>
					</select>					
				</th>
				<th style="width:8%;"></th>
				<th style="width:10%;"></th>
			</tr>
		</thead>
		<thead>	
			<tr>
				<th><input type="checkbox" id="chkAll" onclick="checkAll(defaultForm, this.checked);" title="全选"></th>
				<th>ID</td>
				<th>发送范围</th>
				<th>服务器</th>
				<th>渠道</th>
				<th>角色名称</th>
				<th>标题</th>
				<th>申请日期</th>
				<th>审批人</th>
				<th>状态</th>
				<th>日志</th>	
				<th>操作</th>
			</tr>
		</thead>	
	</table>
</div>
<div class="widget-content autoTbody" >
	<table class="table table-striped table-bordered table-hover" style="min-width:1450px;">
		<tbody>
		<#list page.items as item>
			<tr>
				<td><input type="checkbox" name="ids" value="${item.id}"></td>
				<td>${item.id!}</td>
				<td>
				  <#if item.sendType == 0 >指定角色名
	              <#elseif item.sendType == 1>所有玩家
	              <#elseif item.sendType == 2>导入角色名
				  <#elseif item.sendType == 3>指定角色ID
				  <#elseif item.sendType == 4>导入角色ID
	              </#if>
				</td>
				<td>${item.serverId!}</td>
				<td>${item.channelId!}</td>
				<td><@txtLimit '${item.acceptRoleList!}' 50/></td>
				<td>${item.mailTitle!}</td>
				<#--<td>${item.applyName!}</td>-->
				<td>${item.createTs?datetime!}</td>
				<#--<td>${(item.updateTs?datetime!)!}</td>-->
				<td>${item.approvalName!}</td>
				<td>
					<#if item.status == 0 >审核中
		            <#elseif item.status == 1>审核通过
		            <#elseif item.status == 2>审核未通过
					<#elseif item.status == 3>已经发送
		            </#if>
				</td>
				<td><@txtLimit '${item.sendLog!}' 2/></td>
				<td>
					<#if item.status == 1><input type="button" class="btn btn-xs btn-warning" value="发放" onclick="commonConfirm('${item.id!}','${siteUrl}/zcq/resourceSend?id=${item.id!}','确定发送吗？')"></#if>
					<#if item.status == 0><input  type="button" class="btn btn-xs btn-warning" value="取消" onclick="showSimplePop('${siteUrl}/zcq/applyCancelPage?id=${item.id!}','取消')"/></#if>
					<#if item.status == 0 || item.status == 2><input  type="button" class="btn btn-xs btn-warning" value="修改" onclick="showSimplePop('${siteUrl}/zcq/applyUpdatePage?id=${item.id!}','取消')"/></#if>
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
<script>
    var actionUrl=$("#defaultForm").attr("action");
    function query(){
         $("#defaultForm").attr("action",actionUrl);
    }
    $("#export").click(function(){
		document.defaultForm.action="${siteUrl}/zcq/applyListExport"; 
		defaultForm.submit();
		document.defaultForm.action="${siteUrl}/zcq/applyList";
	})
</script>
