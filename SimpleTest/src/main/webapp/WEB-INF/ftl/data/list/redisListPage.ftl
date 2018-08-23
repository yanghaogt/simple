<#include "../../common/globalDef.ftl">
<@simpleList 750>
<form name="defaultForm" action="${siteUrl}/data/redisList" method="post" >
<div class="widget-head">
	<div class="pull-left">
		<button type="button" class="btn btn-success" onclick="commitTable()">搜索</button>
		<button type="button" class="btn btn-success" onclick="showSimplePop('${siteUrl}/data/redisAddPage','添加用户')">添加</button>
		<span style="margin:5px 5px 5px 10px;font-family:Microsoft YaHei;">ID：</span>
		<input type="text" name="Id" style="width:120px;" value="${Id!}" onblur="if(this.value>2147483647){alert('数值过大！');this.focus();}" onkeyup="value=value.replace(/[^(\d)]/g,'')"onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^(\d)]/g,''))"/>
	</div>
	<div class="pull-right">
		<button  type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>

<div class="widget-content autoHeader" >
	<table class="table table-striped table-bordered table-hover" style="min-width:700px;">
		<thead>
			<#if example??>
			<tr class="a">
	                <th colspan="6"><h3 style="font-family:Microsoft YaHei;"><center><strong>注册基本数据</strong></center></h3></th>
	        </tr>
			<tr class="b" style="background:#fff;">
				    <th width="13%">充值金额</th>
	                <td width="20%">${example.infullAmount!}</td>
	                <th width="13%">注册时间</th>
	                <td width="20%">${example.regTime?datetime}</td>
	                <th width="14%">在线时间</th>
	                <td width="20%">${example.onlineTime!}</td>
			</tr>
			<tr class="b" style="background:#fff;">
	                <th width="13%">登陆次数</th>
	                <td width="20%">${example.loginCount!}</td>
	                <th width="13%">活跃天数</th>
	                <td width="20%">${example.activeDay!}</td>
	                <th width="14%">活跃周数</th>
	                <td width="20%">${example.activeWeek!}</td>
	         </tr>
	         <tr class="b" style="background:#fff;">
	                <th width="13%">登陆时间</th>
	                <td width="20%">${example.lastLoginTime?datetime}</td>
	                <th width="13%">日志编号</th>
	                <td width="20%">${example.lastLoginLogId!}</td>
	                <th width="14%">更新时间</th>
	                <td width="20%">${example.lastLoginUpdateTime?datetime}</td>
	         </tr>
	         </#if>
		</thead>
	</table>
</div>
<div class="widget-content autoTbody">
	<table class="table table-striped table-bordered table-hover" style="min-width:700px;">
	</table>
</div>
</form>
</@simpleList>
<script type="text/javascript">
	function commitTable(){
		document.defaultForm.action="${siteUrl}/data/redisList"; 
		defaultForm.submit();
	}
</script>