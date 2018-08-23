<#macro showItem per>
	{
		"id":${per.mpId},"text":"${per.perName}(${per.mpId})"
		<#if mrpMap??>
			,"state": {
				<#if mrpMap.get(per.mpId)??>
			    "selected":true,
			    "opened":true
			    <#else>
			    "selected":false,
			    "opened":false
			    </#if>
			  }
		</#if>
		<#if per.subList?? && per.subList.size() gt 0>
			,"children":[
			<#list per.subList as item>
				<@showItem item/><#if item_index lt per.subList?size-1>,</#if>
			</#list>
			]
		</#if>
	}
</#macro>
<@showItem rootPerForce/>