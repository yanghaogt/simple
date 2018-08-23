<#macro pagination obj formName>
<script>
function goPage_${formName}(pageNumber) {
	document.${formName}.currentPage.value = pageNumber;
	document.${formName}.submit();
}
</script>

<input type="hidden" name="currentPage" value="${obj.currentPage}"/>
<input type="hidden" name="seqName" value="${obj.seqName}"/>
<input type="hidden" name="seqType" value="${obj.seqType}"/>
<#nested>


<ul class="pagination pull-right">
	<li <#if obj.currentPage==0>class="disabled"</#if>><a href="javascript:goPage_${formName}(0)" >首页</a></li>
	<li <#if obj.currentPage==0>class="disabled"</#if>><a href="javascript:goPage_${formName}(${obj.currentPage-1})">上一页</a></li>
	<#if obj.totalPage gt 0>
		<#if obj.currentPage -5 lt 0>
			<#assign startNum = 0>
		<#else>
			<#assign startNum = obj.currentPage -5>
		</#if>
		
		<#if obj.currentPage + 5 gt obj.totalPage-1>
			<#assign endNum = obj.totalPage-1>
		<#else>
			<#assign endNum = obj.currentPage +5>
		</#if>
		
		
		<#list startNum..endNum as pageNum>
			<li class="<#if pageNum==obj.currentPage>active<#else>duration</#if>"><a href="javascript:goPage_${formName}(${pageNum})">${pageNum+1} </a></li>
		</#list>
	</#if>
	<li <#if obj.currentPage gte obj.totalPage-1>class="disabled"</#if>><a href="javascript:goPage_${formName}(${obj.currentPage+1})">下一页</a></li>
	<li <#if obj.currentPage gte obj.totalPage-1>class="disabled"</#if>><a href="javascript:goPage_${formName}(${obj.totalPage-1})">末页(${obj.totalPage})</a></li>
</ul>
<div class="clearfix"></div>
</#macro>


