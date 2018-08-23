<#include "../../common/globalDef.ftl">
<@simpleList 850>
<form name="defaultForm" action="${siteUrl}/data/mapList" method="post" >
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
				<th style="width:50%;"><input type="text" name="id" value="" class="form-control" style="width:100%;"/></th>
				<th style="width:50%;"><input type="text" name="nameId" value="" class="form-control" style="width:100%;"/></th>
			</tr>
		</thead>
		<thead>
			<tr>
				<@seqTh page "defaultForm" "id" >ID</@seqTh>
				<@seqTh page "defaultForm" "nameId" >渠道</@seqTh>
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
						<#if mapPayType.get(item.nameId)??>
							${mapPayType.get(item.nameId)}
						</#if>
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
	function commitTable(){
		document.defaultForm.action="${siteUrl}/data/mapList"; 
		defaultForm.submit();
	}
</script>