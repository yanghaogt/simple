<#include "../../common/globalDef.ftl">
<@simpleList 1250>
<style>
.control-label{width:100px;padding-top:5px;}
.file-content{margin:20px;}
</style>
<div class="widget-content"  id="tableContainer" style="min-height:830px;">
	<div class="file-content">
		<button type="button" class="btn btn-warning" onclick="<@uploadJs "uploadSuc" "OA" 2560/>">上传图片</button>
	</div>
	<div style="border:1px dashed #808080;overflow:hidden;height:500px;margin:10px;">
		<p class="add"/>
	</div>
</div>
</@simpleList>

