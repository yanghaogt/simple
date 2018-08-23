<#include "../../common/globalDef.ftl">
<@simpleList 550>
<form name="defaultForm" action="${siteUrl}/data/cdkeyList" method="post" >
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
	<table class="table table-striped table-bordered table-hover" style="min-width:500px;">
		<thead>
			<tr>
				<th style="width:100px;">
					<select class="form-control" name="game">
			        	<option value="">全部</option>
					    <#list game_list as item>
					    	<option value="${item.kindId}">${item.gameName}</option>
					    </#list>
			        </select>
				</th>
				<th style="width:100px;">
					<select class="form-control" name="platform">
			        	<option value="">全部</option>
				        <#list plat_list as item>
				        	<option value="${item.platform}">${item.platformName}</option>
				        </#list>
			        </select>
				</th>
				<th style="width:100px;">
					<select class="form-control" name="channel">
			        	<option value="">全部</option>
			        	<#list chan_list as item>
					        <option value="${item.channelId}">${item.channelName}</option>
					    </#list>
			        </select>
				</th>
			</tr>
		</thead>
		<thead>
			<tr>
				<@seqTh page "defaultForm" "kindId" >游戏</@seqTh>
				<@seqTh page "defaultForm" "platform" >平台</@seqTh>
				<@seqTh page "defaultForm" "channelId" >渠道</@seqTh>
			</tr>
		</thead>
	</table>
</div>
<div class="widget-content autoTbody">
	<table class="table table-striped table-bordered table-hover" style="min-width:500px;">
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
		document.defaultForm.action="${siteUrl}/data/cdkeyList"; 
		defaultForm.submit();
	}
</script>