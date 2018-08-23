<#include "../common/globalDef.ftl">
<@simpleEdit "设置" "${siteUrl}/setting">

<div class="form-group">
	<label class="control-label col-lg-3">原密码</label>
	<div class="col-lg-6">
		<input type="password" class="form-control" name="oldPwd">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-lg-3">新密码</label>
	<div class="col-lg-6">
		<input type="password" class="form-control" name="newPwd">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-lg-3">重复新密码</label>
	<div class="col-lg-6">
		<input type="password" class="form-control" name="reNewPwd">
	</div>
</div>

</@simpleEdit>