<#macro top>
	<header>
<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">
  	
    <div class="container">
      <!-- Menu button for smallar screens -->
      <div class="navbar-header">
		  <button class="navbar-toggle btn-navbar" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse"><span>菜单</span></button>
      <a href="#" class="pull-left menubutton hidden-xs"><i class="fa fa-circle-o"></i></a>
		  <!-- Site name for smallar screens -->
		  <a href="${siteUrl}/index" class="navbar-brand">时光<span style="font-size:">管理中心</span></a>
		  <!-- change by zhangyu in 2015-08-25 -->
		  <div class="menu">
			  <ul>
			  	<#if session_user_yjlc.rootPer?exists>
				  	<#assign rootPer = session_user_yjlc.rootPer>
				  	<#list rootPer.subList as item>
				  		<#assign subPer = session_user_yjlc.subPer>
				  		<#assign perMap = session_user_yjlc.pers>
			  				<#if perMap.get(item.mpId) ??>
					  			<#if subPer.mpId = item.mpId>
					  			<li><a class="checked" href="${siteUrl}/menu.do?mpId=${item.mpId}">${item.perName}</a></li>
					  			<#else>
					  			<li><a href="${siteUrl}/menu.do?mpId=${item.mpId}" >${item.perName}</a></li>
					  			</#if>
				  			</#if>
				  	</#list>
			  	</#if>
			  	
			  </ul>
		  </div>
		  <!-- change by zhangyu in 2015-08-25 -->
		</div>

      <!-- Navigation starts -->
      <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">         
        <!-- change by zhangyu in 2015-08-25 -->
		  <div class="menus">
			  <ul>
			  	<#if session_user_yjlc.rootPer?exists>
				  	<#assign rootPer = session_user_yjlc.rootPer>
				  	<#list rootPer.subList as item>
				  		<#assign perMap = session_user_yjlc.pers>
			  				<#if perMap.get(item.mpId) ??>
					  			<#if subPer.mpId = item.mpId>
					  			<li><a class="checked" href="${siteUrl}/menu.do?mpId=${item.mpId}" >${item.perName}</a></li>
					  			<#else>
					  			<li><a href="${siteUrl}/menu.do?mpId=${item.mpId}" >${item.perName}</a></li>
					  			</#if>
				  			</#if>
				  	</#list>
			  	</#if>
			  </ul>
		  </div>
		  <!-- change by zhangyu in 2015-08-25 -->
        <!-- Links -->
        <ul class="nav navbar-nav pull-right">
          <li class="dropdown pull-right user-data">            
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
              	<img src="${imgUrl}/user1.png" style="width:25px;height:25px;">  ${session_user_yjlc.manageUser.realName} <b class="caret"></b>              
            </a>
            
            <!-- Dropdown menu -->
            <ul class="dropdown-menu">
              <#--
              <li><a href="#"><i class="fa fa-user"></i> 个人信息</a></li>
              <li><a href="#"><i class="fa fa-cogs"></i> 设置</a></li>
              -->
              <li><a href="javascript:showSetting()"><i class="fa fa-key"></i> 设置密码</a></li>
              <li><a href="javascript:logoutConfirm()"><i class="fa fa-key"></i> 登出</a></li>
            </ul>
          </li>
          
        </ul>
      </nav>

    </div>
  </div>
</header>







    
</#macro>