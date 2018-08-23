<#macro simpleAdd titleShow actionUrl>
<div class="">
	<div class="modal-content">
		<div class="modal-body">
			<form id="addModalForm" class="form-horizontal validate" role="form" enctype="multipart/form-data">
				<div class="padd">
					<div class="form quick-post">
						<#nested/>
					</div>
				</div>
			</form>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" onclick="layer.closeAll()">关闭</button>
			<button type="button" class="btn btn-danger" onclick="javascript:commonModalSubmit('${actionUrl}','addModalForm')">确定并保存信息</button>
		</div>
		
	</div>
</div>


<script src="${jsUrl}/languages/jquery.validationEngine-en.js"></script>
<script src="${jsUrl}/jquery.validationEngine.js"></script>
<link rel="stylesheet" href="${cssUrl}/validationEngine.jquery.css" />

<script>

	$(document).ready(function(){   
	  $(".validate").validationEngine({
	  	promptPosition:"bottomRight",
	  	success:false,
	  	failure:function(){},
	  });
	  
	});
	
</script>


</#macro>