<#include "leftMenuChild.ftl">
<#macro left>

<!-- Sidebar -->
    <div class="sidebar">
        <div class="sidebar-dropdown"><a href="#">导航</a></div>
        <!-- Search form -->
        <#--form class="navbar-form" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
        		<button class="btn search-button" type="submit"><i class="fa fa-search"></i></button>
			</div>
    	</form-->
        <!--- Sidebar navigation -->
		<ul id="nav">
			<#if session_user_yjlc.subPer?exists>
				<#assign rootPer = session_user_yjlc.subPer>
				<@leftMenuChild rootPer.subList 0/>
			</#if>
        </ul>
    </div>
<!-- Sidebar ends -->

</#macro>