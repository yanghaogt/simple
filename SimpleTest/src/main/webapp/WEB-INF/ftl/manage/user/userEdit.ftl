<#include "../../common/globalDef.ftl">
<@simpleEdit "修改用户信息" "${siteUrl}/manage/userEdit">
<input type="hidden" name="muId" value="${example.muId}">


<@formText "真实姓名" "realName" "${example.realName!}"/>
<@formSelect "用户角色" >
	<select class="form-control" name="mrId">
		<option value="0" <#if example.mrId==0>selected="selected"</#if> >-请选择-</option> 
		<#list roleList as item>
			<option <#if item.mrId==example.mrId>selected="selected"</#if> value="${item.mrId}">${item.roleName}</option>
		</#list>
	</select>
</@formSelect>
<@formText "密码" "password" "${example.password!}"/>

</@simpleEdit>