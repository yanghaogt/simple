<#include "../../common/globalDef.ftl">
<@simpleList 1000>
<script>
	defaultModalClose =function(){
		setTimeout(function(){$('#perTree').jstree(true).refresh();}, 500);
	}
</script>
<div class="widget-head">
	<div class="pull-left">
		<input type="text" class="form-control" id="searchPer"  placeholder="快速查询">
	</div>
	<div class="pull-right">
		<input type="button" class="btn btn-danger" onclick="window.location.href='perCheck';" value="检查新权限">
		<label class="control-label">(点击<font color="red">右键</font>出现操作菜单,<font color="red">拖放</font>可改变目录结构)</label>
	</div>
	<div class="clearfix"></div>
</div>
<div class="widget-head">
	<#if perNoDbList?exists && perNoDbList?size gt 0>
		<span style="color:red">发现尚未添加的权限:</span></br>
		<#list perNoDbList as nPer>
		<span>
		<input type="button" class="btn btn-success" onclick="showSimplePop('${siteUrl}/manage/perAddAutoPage?mpId=${nPer.code}','添加权限')" value="添加到网站">
		权限值:${nPer.code}    权限名:${nPer.getName()}  权限路径:${nPer.pageUrl!}  父级权限:<#if nPer.father?exists>${nPer.father.getName()}<#else>未知</#if>
		</span></br>
		</#list>
	</#if>
</div>
<div class="widget-content" style="max-height:614px; overflow-y:auto;">
	<div id="perTree">
		
	</div>
</div>
<div class="widget-foot">
</div>
<script src="${jsUrl}/manage.js"></script>
<script src="${jsUrl}/jstree/jstree.min.js"></script><!--jstree-->
</@simpleList>
