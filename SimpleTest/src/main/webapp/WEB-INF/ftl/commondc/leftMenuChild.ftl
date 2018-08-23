
<#function inCurrentPer per perId>
	<#if per.perId==perId>
		<#return true>
	</#if>
	<#if per.fatherPer??>
		<#return inCurrentPer(per.fatherPer,perId)>
	</#if>
	<#return false>
</#function>
    
<#macro leftMenuChild childs depIn>
	<#list childs as item>
			<#assign per=session_oa_emp.pers.get(item.perId?string)??>
			<#if per?string=="true">
				<#local dep = depIn + 1>
			</#if>
			<#local isCrt=inCurrentPer(currentPer,item.perId)/>
			<#if per?string=="true"&& item.perId=11600>
				
			<#elseif per?string=="true" &&  (item.subList.size()==0 || dep gt 1)>
				<li <#if isCrt==true>class="on"</#if>><a href="${siteUrl}/${item.pageUrl!}">${item.name}</a></li>	
			<#elseif per?string=="true">
				<#if curr_game?exists & curr_game!=0>
					<#if item_index gt 0>
						<li class="one_menu <#if isCrt==true>on</#if>">
				            <a href="javascript:;"">
				                <i class="icon iconfont icon_right">&#xe614;</i>
				                <span>${item.name}</span>
				            </a>
			          	</li>
			        </#if>
			    <#else>
			    	<li class="one_menu <#if isCrt==true>on</#if>">
			            <a href="javascript:;"">
			                <i class="icon iconfont icon_right">&#xe614;</i>
			                <span>${item.name}</span>
			            </a>
	          		</li>
			    </#if>
			    <ul class="inner_menu <#if isCrt==false>none</#if>">
					<@leftMenuChild item.subList dep/>
				</ul>
			</#if>
			<#if curr_game?exists & curr_game!=0>
			
			<#else>
				<#break>
			</#if>
	</#list>
</#macro>