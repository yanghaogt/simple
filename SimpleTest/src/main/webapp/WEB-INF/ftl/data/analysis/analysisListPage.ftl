<#include "../../common/globalDef.ftl">
<@simpleList 750>
<form name="defaultForm" action="${siteUrl}/data/redisList" method="post" >
<div class="widget-head">
	<div class="pull-left">
		<button type="button" class="btn btn-success" onclick="commitTable()">搜索</button>
		<button type="button" class="btn btn-success" onclick="analysisJson()">Json</button>
		<button type="button" class="btn btn-success" onclick="analysisHtml()">JsonHtml</button>
	</div>
	<div class="pull-right">
		<button  type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>

<div class="widget-content autoHeader" >
	<table class="table table-striped table-bordered table-hover" style="min-width:700px;">
		<thead>
			<tr class="a">
	                <th colspan="6"><h3 style="font-family:Microsoft YaHei;"><center><strong>Json</strong></center></h3></th>
	        </tr>
			<tr class="b" style="background:#fff;">
				    <th width="13%">充值金额</th>
	                <td width="30%" id="url"></td>
	                <th width="13%">注册时间</th>
	                <td width="10%" id="localName"></td>
	                <th width="14%">在线时间</th>
	                <td width="10%" id="serverName"></td>
			</tr>
			<tr class="b" style="background:#fff;">
	                <th width="13%">登陆次数</th>
	                <td width="30%"></td>
	                <th width="13%">活跃天数</th>
	                <td width="10%"></td>
	                <th width="14%">活跃周数</th>
	                <td width="10%"></td>
	         </tr>
	         <tr class="b" style="background:#fff;">
	                <th width="13%">登陆时间</th>
	                <td width="30%"></td>
	                <th width="13%">日志编号</th>
	                <td width="10%"></td>
	                <th width="14%">更新时间</th>
	                <td width="10%"></td>
	         </tr>
	         <tr class="a">
	                <th colspan="6"><h3 style="font-family:Microsoft YaHei;"><center><strong>JsonHtml</strong></center></h3></th>
	        </tr>
			<tr class="b" style="background:#fff;">
				    <th width="13%">充值金额</th>
	                <td width="30%" id="urlh"></td>
	                <th width="13%">注册时间</th>
	                <td width="10%" id="localNameh"></td>
	                <th width="14%">在线时间</th>
	                <td width="10%" id="serverNameh"></td>
			</tr>
			<tr class="b" style="background:#fff;">
	                <th width="13%">登陆次数</th>
	                <td width="30%"></td>
	                <th width="13%">活跃天数</th>
	                <td width="10%"></td>
	                <th width="14%">活跃周数</th>
	                <td width="10%"></td>
	         </tr>
	         <tr class="b" style="background:#fff;">
	                <th width="13%">登陆时间</th>
	                <td width="30%"></td>
	                <th width="13%">日志编号</th>
	                <td width="10%"></td>
	                <th width="14%">更新时间</th>
	                <td width="10%"></td>
	         </tr>
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
	function analysisJson(){
		$.ajax({
			url:'${siteUrl}/analysis/analysisJson',
			type:'post',
			dataType: 'json',
			success:function(data){
			   var mm = data;
			   $("#url").html(mm.url);
			   $("#localName").html(mm.localName);
			   $("#serverName").html(mm.serverName);
			},
			error:function(e){
				alertErr("未知异常，稍后再试");
			}
		});
	}
	function analysisHtml(){
		$.ajax({
			url:'${siteUrl}/analysis/analysisHtml',
			type:'post',
			dataType: 'json',
			success:function(data){
			   console.log(data);
			   var mm = data.data;
			   $("#urlh").html(mm.url);
			   $("#localNameh").html(mm.localName);
			   $("#serverNameh").html(mm.serverName);
			},
			error:function(e){
				alertErr("未知异常，稍后再试");
			}
		});
	}
</script>