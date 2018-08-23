<#include "../../common/globalDef.ftl">
<@simpleList 1250>
<form name="defaultForm" action="${siteUrl}/data/exportList" method="post" >
<div class="widget-head">
	<div class="pull-left">
		<button type="button" class="btn btn-success" onclick="commitTable()">搜索</button>
	</div>
	<div class="pull-right">
		<button type="button" class="btn btn-success" onclick="exportExcel()">导出</button>&nbsp;
		<button  type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>

<div class="widget-content autoHeader" >
	<table class="table table-striped table-bordered table-hover" style="min-width:1200px;">
		<thead>
			<tr>
				<th style="width:16%;"><input type="text" name="key" value="${example.key!}" class="form-control" style="width:100%;"/></th>
				<th style="width:16%;"><input type="text" name="classId" value="${example.classId!}" class="form-control" style="width:100%;"/></th>
				<th style="width:16%;"><input type="text" name="uid" value="${example.uid!}" class="form-control" style= "width:100%;"/></th>
				<th style="width:16%;"><input type="text" name="state" value="${example.state!}" class="form-control" style="width:100%;"/></th>
				<th style="width:16%;"><@shDateBeginEnd "createDateSh" example.createDateSh! /></th>
				<th style="width:16%;"><@shDateBeginEnd "useDateSh" example.useDateSh! /></th>
			</tr>
		</thead>
		<thead>
			<tr>
				<@seqTh page "defaultForm" "key" >礼包码</@seqTh>
				<@seqTh page "defaultForm" "class_id" >类ID</@seqTh>
				<@seqTh page "defaultForm" "uid" >最后使用者id</@seqTh>
				<@seqTh page "defaultForm" "state" >使用次数</@seqTh>
				<@seqTh page "defaultForm" "create_time" >生成时间</@seqTh>
				<@seqTh page "defaultForm" "use_time" >最后使用时间</@seqTh>
			</tr>
		</thead>
	</table>
</div>
<div class="widget-content autoTbody" >
	<table class="table table-striped table-bordered table-hover" style="min-width:1200px;">
		<tbody>
			<#list page.items as item>
				<tr>
					<td>${item.key!}</td>
					<td>${item.classId!}</td>
					<td>${item.uid!}</td>
					<td>${item.state!}</td>
					<td>${item.createDate?datetime}</td>
					<td><#if item.useDate??>${item.useDate?datetime}</#if></td>
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
<script type="text/javascript">
	function exportExcel(){
		document.defaultForm.action="${siteUrl}/data/makeCdkeyExcel"; 
		defaultForm.submit();
	}
	function commitTable(){
		document.defaultForm.action="${siteUrl}/data/exportList"; 
		defaultForm.submit();
	}
</script>