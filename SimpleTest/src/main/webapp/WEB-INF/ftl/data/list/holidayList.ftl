<#include "../../common/globalDef.ftl">
<@simpleList 850>
<form name="defaultForm" action="${siteUrl}/data/holidayList" method="post" >
<div class="widget-head">
	<div class="pull-left">
		<button type="button" class="btn btn-success" onclick="commitTable()">搜索</button>
	</div>
	<div class="pull-right">
		<button  type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>

<div class="widget-content autoHeader" >
	<table class="table table-striped table-bordered table-hover" style="min-width:800px;">
		<thead>
			<tr>
				<th style="width:33%;"><input type="text" name="id" value="${example.id!}" class="form-control" style="width:100%;"/></th>
				<th style="width:33%;"><input type="text" name="name" value="${example.name!}" class="form-control" style="width:100%;"/></th>
				<th style="width:33%;"><@shDateBeginEnd "logDateSh" example.logDateSh! /></th>
			</tr>
		</thead>
		<thead>
			<tr>
				<@seqTh page "defaultForm" "id" >编号</@seqTh>
				<@seqTh page "defaultForm" "name" >节假日</@seqTh>
				<@seqTh page "defaultForm" "logDate" >时间</@seqTh>
			</tr>
		</thead>
	</table>
</div>
<div class="widget-content autoTbody" >
	<table class="table table-striped table-bordered table-hover" style="min-width:800px;">
		<tbody>
			<#list page.items as item>
				<tr>
					<td>${item.id!}</td>
					<td>${item.name!}</td>
					<td>${item.logDate?datetime}</td>
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
		document.defaultForm.action="${siteUrl}/data/holidayList"; 
		defaultForm.submit();
	}
</script>