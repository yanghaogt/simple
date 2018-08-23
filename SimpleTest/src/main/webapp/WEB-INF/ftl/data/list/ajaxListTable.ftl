<#include "../../common/globalDef.ftl">

<div class="widget-content autoTbody">
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
	<@paginationAjax page "ajaxListForm" "data/ajaxListTable" "ajaxListForm" "ajaxListTable"/>
</div>

<script>
$(function(){
	funToReset();
});
</script>