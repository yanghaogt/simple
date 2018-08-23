
<#function inCurrentPer per mpId>
	<#if per.mpId==mpId>
		<#return true>
	</#if>
	<#if per.fatherPer??>
		<#return inCurrentPer(per.fatherPer,mpId)>
	</#if>
	<#return false>
</#function>

<#macro leftMenuChild childs depIn>
	<#list childs as item>
		<#assign per=session_user_yjlc.pers.get(item.mpId?int)??>
		<#if per?string=="true">
			<#local dep = depIn + 1>
		</#if>
		<#local isCrt=inCurrentPer(currentPer,item.mpId)/>
		
		
		<#if per?string=="true" &&  (item.subList.size()==0 || dep gt 1)>
			<li>
				<a href="${siteUrl}/${item.pageUrl!}"  <#if isCrt==true>class="active"<#else></#if>>
				<span>${item.perName}</span></a>
			</li>
		<#elseif per?string=="true">
			<li class="has_sub">
				<a <#if isCrt==true>class="subdrop open"</#if> href="#">
					<i class="fa fa-connectdevelop"></i>
					<span>${item.perName}</span>
					<span class="pull-right">
					<#if isCrt==true>
					<i class="fa fa-chevron-down"></i>
					<#else>
					<i class="fa fa-chevron-left"></i>
					</#if>
					</span>
				</a>
				<ul>
					<@leftMenuChild item.subList dep/>
				</ul>
			</li>
		</#if>
	</#list>
</#macro>