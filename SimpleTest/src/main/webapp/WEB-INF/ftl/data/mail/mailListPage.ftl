<#include "../../common/globalDef.ftl">
<@simpleList 750>
<form name="defaultForm" action="${siteUrl}/mail/mailList" method="post" >
<div class="widget-head">
	<div class="pull-left">
		<button type="button" class="btn btn-success" onclick="commitTable()">搜索</button>
		<button type="button" class="btn btn-success" onclick="showSimplePop('${siteUrl}/mail/mailAddPage','发送邮件')">发送</button>
	</div>
	<div class="pull-right">
		<button  type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>

<div class="widget-content autoHeader" >
	<table class="table table-striped table-bordered table-hover" style="min-width:700px;">
		<thead>
			<tr>
				<th style="width:40px;"></th>
				<th style="width:120px;"><input type="text" name="email" value="${example.email!}" class="form-control" style="width:100%;"/></th>
				<th style="width:100px;"><input type="text" name="title" value="${example.title!}" class="form-control" style="width:100%;"/></th>
				<th style="width:100px;"><input type="text" name="content" value="${example.content!}" class="form-control" style="width:100%;"/></th>
				<th style="width:130px;"><@shDateBeginEnd "sendTimeSh" example.sendTimeSh! /></th>
			</tr>
		</thead>
		<thead>
			<tr>
				<th></th>
				<@seqTh page "defaultForm" "email" >标题</@seqTh>
				<@seqTh page "defaultForm" "title" >标题</@seqTh>
				<@seqTh page "defaultForm" "content" >内容</@seqTh>
				<th></th>
			</tr>
		</thead>
	</table>
</div>
<div class="widget-content autoTbody" >
	<table class="table table-striped table-bordered table-hover" style="min-width:700px;">
		<tbody>
			<#list page.items as item>
				<tr>
					<td>${item.id!}</td>
					<td>${item.email!}</td>
					<td>${item.title!}</td>
					<td>${item.content!}</td>
					<td>${item.sendTime?datetime}</td>
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
		document.defaultForm.action="${siteUrl}/mail/mailList";
		defaultForm.submit();
	}
</script>