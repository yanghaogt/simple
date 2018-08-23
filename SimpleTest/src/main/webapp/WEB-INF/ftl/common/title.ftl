
<#macro createTitle per curId>
	<#if per.fatherPer?? && per.fatherPer.mpId!=1>
		<@createTitle per.fatherPer 2/>
	</#if>
	<span class="divider">/</span> 
	<span href="" <#if curId==1>style="color:gray"</#if>>${per.perName}</span>
</#macro>

<#macro title titleName="">
<div class="page-head">
<!--h2 class="pull-left"><#if titleName?? & titleName != "">${titleName}<#else>${currentPer.perName}</#if></h2-->
<div class="clearfix"></div>
<!-- Breadcrumb -->
<div class="bread-crumb" style="text-align:left;">
  <a href="${siteUrl}/index"><i class="fa fa-home"></i> 首页</a> 
  <!-- Divider -->
  
  <@createTitle currentPer 1/>
  
</div>

<div class="clearfix"></div>
    
  </div>
</#macro>

