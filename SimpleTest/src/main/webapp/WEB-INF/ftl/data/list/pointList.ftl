<#include "../../common/globalDef.ftl">
<@simpleList 850>
<form name="defaultForm" action="${siteUrl}/data/pointList" method="post" >
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
				<th style="width:50%;"><input type="text" name="id" value="${example.id!}" class="form-control" style="width:100%;"/></th>
				<th style="width:50%;"><input type="text" name="" value="" class="form-control" style="width:100%;"/></th>
			</tr>
		</thead>
		<thead>
			<tr>
				<@seqTh page "defaultForm" "id" >ID</@seqTh>
				<@seqTh page "defaultForm" "state" >计费列表</@seqTh>
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
					<td>
						<#list item.fixPayInfo as fix>
							金额:${fix.price}&nbsp;计费码:${fix.productCode}&nbsp;自定义编码:${fix.diyId}<br/>
						</#list>
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
<script type="text/javascript">
	function exportExcel(){
		document.defaultForm.action="${siteUrl}/data/makeCdkeyExcel"; 
		defaultForm.submit();
	}
	function commitTable(){
		document.defaultForm.action="${siteUrl}/data/pointList"; 
		defaultForm.submit();
	}
</script>