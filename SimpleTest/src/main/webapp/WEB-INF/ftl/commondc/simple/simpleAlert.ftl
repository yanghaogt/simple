<#macro simpleAlert titleShow actionUrl>

	<div class="data_edit_alert">
		<form id="alertModalForm" class="form-horizontal" name="defaultForm" role="form" enctype="multipart/form-data">
        <#nested/>
     	<footer class="data_alert_footer clearfix">
     		<a href="javascript:;" class="edit_alert_btn type2" onclick="javascript:commonModalSubmit('${actionUrl}','alertModalForm')">确定</a>
     	</footer>
     	</form>
     </div>

</#macro>