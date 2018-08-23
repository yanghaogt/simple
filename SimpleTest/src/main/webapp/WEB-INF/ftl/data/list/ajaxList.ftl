<#include "../../common/globalDef.ftl">
<@simpleList 1250>
<form name="ajaxListForm" id="ajaxListForm" action="${siteUrl}/data/ajaxListTable" method="post" >
<div class="widget-head">
	<div class="pull-left">
		<button type="button" class="btn btn-success" onclick="goPage_ajaxListForm(<#if page??>${page.currentPage!}</#if>)">搜索</button>
	</div>
	<div class="pull-right">
		<button  type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>

<div class="widget-content autoHeader">
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
				<@seqTh page "defaultForm" "uid" >最后使用者ID</@seqTh>
				<@seqTh page "defaultForm" "state" >使用次数</@seqTh>
				<@seqTh page "defaultForm" "create_time" >生成时间</@seqTh>
				<@seqTh page "defaultForm" "use_time" >最后使用时间</@seqTh>
			</tr>
		</thead>
	</table>
</div>
<div id="ajaxListTable">
	<#include "ajaxListTable.ftl">
</div>

</form>
</@simpleList>
<script type="text/javascript">
	function commitTable(){
		document.defaultForm.action="${siteUrl}/data/ajaxListTable"; 
		defaultForm.submit();
	}
</script>