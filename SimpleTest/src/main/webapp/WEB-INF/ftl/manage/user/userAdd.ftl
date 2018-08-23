<#include "../../common/globalDef.ftl">
<@simpleAdd "新增用户" "${siteUrl}/manage/userAdd">

<@formText "用户名" "userName" />
<@formText "真实姓名" "realName" />
<@formSelect "用户角色" >
	<select class="form-control" name="mrId">
		<option value="0" selected="selected">-请选择-</option> 
		<#list roleList as item>
			<option value="${item.mrId}">${item.roleName}</option>
		</#list>
	</select>
</@formSelect>
<@formText "密码" "password" />

</@simpleAdd>