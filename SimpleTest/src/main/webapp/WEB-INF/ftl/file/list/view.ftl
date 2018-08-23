<#include "../../common/globalDef.ftl">
<@simpleList 850>
<style>
.file-content{margin:20px;}
</style>

<div class="widget-content"  id="tableContainer" style="overflow:auto;min-height:830px;">
	<div class="file-content">
		<input id="file" type="file" />
		<div class="image_container">
			<img id="preview" width="200" height="200">
		</div>
	</div>
</div>

</@simpleList>
<script type="text/javascript">
$(function() {
	$("#file").change(function() {
		var $file = $(this);
		var file = $file[0];
		var windowURL = window.URL || window.webkitURL;
		if(file && file.files && file.files[0]){
			url = windowURL.createObjectURL(file.files[0]);
			$("#preview").attr('src',url);
		}else{};
	});
});
</script>