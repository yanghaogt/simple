<#include "../../common/globalDef.ftl">
<@simpleEdit "修改用户信息" "${siteUrl}/manage/userImg">
<input type="hidden" name="muId" value="${example.muId}">

<@formUpdateImg "头像" "headImg" "${example.headImg!}" />

</@simpleEdit>
<!--返回json会导致点击确定浮动页面不关闭-->
<!--
<#include "../../common/globalDef.ftl">
<div class="modal-content">
	<div class="modal-body">
		<form id="editModalForm" name="userImgForm" action="${siteUrl}/manage/userImg" method="post" class="form-horizontal" role="form">
		<div class="padd">
		<div class="form quick-post">
			<input type="hidden" name="muId" value="${example.muId}">
			<@formUpdateImg "头像" "headImg" "${example.headImg!}" />
		</div>
		</div>
		</form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" onclick="layer.closeAll()">关闭</button>
		<button type="button" class="btn btn-danger" onclick="document.userImgForm.submit()">确定并保存信息</button>
	</div>
</div>
-->