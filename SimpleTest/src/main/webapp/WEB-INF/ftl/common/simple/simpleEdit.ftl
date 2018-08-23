<#macro simpleEdit titleShow actionUrl>

<div class="modal-content">
	<div class="modal-body">
		<form id="editModalForm" class="form-horizontal" role="form" enctype="multipart/form-data">
		<div class="padd">
		<div class="form quick-post">
		<#nested/>
		</div>
		</div>
		</form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" onclick="layer.closeAll()">关闭</button>
		<button type="button" class="btn btn-danger" onclick="javascript:commonModalSubmit('${actionUrl}','editModalForm')">确定并保存信息</button>
	</div>
</div>

</#macro>