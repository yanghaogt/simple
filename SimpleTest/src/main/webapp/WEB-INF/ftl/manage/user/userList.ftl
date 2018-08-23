<#include "../../common/globalDef.ftl">
<@simpleList 1150>
<form name="defaultForm" action="${siteUrl}/manage/userList" method="post" >

<div class="widget-head">
	<div class="pull-left">
		<input type="submit" class="btn btn-success" value="搜索">
		<input type="button" class="btn btn-success" onclick="showSimplePop('${siteUrl}/manage/userAddPage','添加用户')" value="添加">
	</div>
	<div class="pull-right">
		<button  type="button" class="btn btn-default" onclick="ClearForm('defaultForm')">重置</button>
	</div>
	<div class="clearfix"></div>
</div>

<div class="widget-content autoHeader" >
	<table class="table table-striped table-bordered table-hover" style="min-width:1100px;">
		<thead>
		<tr>
			<th><input type="text" name="userName" value="${example.userName!}" class="form-control" style="width:120px;"/></th>
			<th><input type="text" name="realName" value="${example.realName!}" class="form-control" style="width:120px;"/></th>
			<th style="width:160px;">
				<@shDateBeginEnd "regTimeSh" example.regTimeSh! />
			</th>
			<th style="width:160px;">
				<@shDateBeginEnd "lastLoginTimeSh" example.lastLoginTimeSh! />
			</th>
			<th>
				<select class="form-control" name="mrId" style="width:120px;">
		        	<option value="0" <#if example.mrId==0>selected="selected"</#if>>-选择角色-</option>
			        <#list roleList as item>
			        <option <#if example.mrId==item.mrId>selected="selected"</#if> value="${item.mrId}">${item.roleName}</option>
			        </#list>
		        </select>
	        </th>
			<th style="width:120px;"></th>
		</tr>
		</thead>
		<thead>
			<tr>
				<@seqTh page "defaultForm" "user_name" >用户账号</@seqTh>
				<@seqTh page "defaultForm" "real_name" >真实名称</@seqTh>
				<@seqTh page "defaultForm" "reg_time" >注册时间</@seqTh>
				<@seqTh page "defaultForm" "last_login_time" >最后登录</@seqTh>
				<@seqTh page "defaultForm" "mr_id" >角色</@seqTh>
				<th>操作</th>
			</tr>
		</thead>
	</table>
	
	
</div>
<div class="widget-content autoTbody" >
	<table class="table table-striped table-bordered table-hover" style="min-width:1100px;">
		<tbody>
	<#list page.items as item>
		<tr>
			<td>${item.userName!}</td>
			<td>${item.realName!}</td>
			<td>${item.regTime?datetime!}</td>
			<td>${item.lastLoginTime?datetime!}</td>
			<td>
				<#list roleList as roleItem>
			    	<#if roleItem.mrId==item.mrId>
			    		${roleItem.roleName}<#break/>
			    	</#if>
			    </#list>
			</td>
			<td>
				<input type="button" class="btn btn-xs btn-warning" onclick="showSimplePop('${siteUrl}/manage/userEditPage?muId=${item.muId}','修改用户')" value="修改">
				<#--input type="button" class="btn btn-xs btn-warning" onclick="showSimplePop('${siteUrl}/manage/userImgPage?muId=${item.muId}','更换头像')" value="更换头像"-->
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