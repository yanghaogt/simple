<#macro top category>
<body style="background: #efefef;">
      <div class="wrapper">
<!-- 头部菜单 -->
	<header class="oa_head clearfix">
        <a href="${siteUrl}" class="logo"><img src="${imgUrl}/data/data_logo.png" alt=""></a>
        <nav class="menu_all none">
            <a href="javascript:void(0);" class="exit">
                <i class="icon iconfont">&#xe608;</i>
            </a>
        </nav>
       <nav class="menu_con clearfix">
       				<#if !dingtalk_user_id?exists>
                    <a href="javascript:void(0);" id="login-out-btn" class="exit login-out-btn">
                        <i class="icon iconfont">&#xe603;</i>
                        <span class="name">退出</span>
                    </a>
                    </#if>
		            <#if session_oa_emp.pers.get(PER_MANAGE)??>
		                <#if category==1>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/management" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe600;</i>
		                    <span class="name">管理</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_ME)??>
		                <#if category==2>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/me" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe604;</i>
		                    <span class="name">个人</span>
		                </a>
		        	</#if>
		        	<#if session_oa_emp.pers.get(PER_ACCOUNT)??>
		                <#if category==14>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/account" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe60b;</i>
		                    <span class="name">账号</span>
		                </a>
		        	</#if>
		        	<#if session_oa_emp.pers.get(PER_FINANCIAL)??>
		                <#if category==3>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/financial" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe605;</i>
		                    <span class="name">财务</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_REPORT)??>
		                <#if category==4>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/daily" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe602;</i>
		                    <span class="name">报表</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_ASSET)??>
		                <#if category==5>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/asset" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe608;</i>
		                    <span class="name">资产</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_WEIHU)??>
		                <#if category==13>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/weihu" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe602;</i>
		                    <span class="name">维护</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_KEFU)??>
		                <#if category==10>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/kefu" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe622;</i>
		                    <span class="name">客服</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_BBS)??>
		                <#if category==7>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/sygsite" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe60d;</i>
		                    <span class="name">官网</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_APPROVAL)??>
		                <#if category==6>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/approval" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe606;</i>
		                    <span class="name">审批</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_VERSION)??>
		                <#if category==8>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/version" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe609;</i>
		                    <span class="name">版本管理</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_RULES)??>
		            	<#if category==9>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/rule" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe60c;</i>
		                    <span class="name">规章制度</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_DATA)??>
		                <#if category==11>
		                <a href="javascript:void(0);" class="exit on">
		                <#else>
		                <a href="${siteUrl}/datacenter/" class="exit">
		                </#if>
		                    <i class="icon iconfont">&#xe607;</i>
		                    <span class="name">数据中心</span>
		                </a>
		            </#if>
		            <#if session_oa_emp.pers.get(PER_NDATA)??>
			            <#if category==16>
			            <a href="javascript:void(0);" class="exit on">
			            <#else>
			            <a href="${siteUrl}/data" class="exit">
			            </#if>
			                <i class="icon iconfont">&#xe607;</i>
			                <span class="name">新数据中心</span>
			            </a>
			        </#if>
                     <#if session_oa_emp.pers.get(PER_RESUME_SEARCH)??>
	                    <#if category==17>
	                    <a href="javascript:void(0);" class="exit on">
	                    <#else>
	                    <a href="${siteUrl}/resume/resumeSearch" class="exit">
	                    </#if>
	                        <i class="icon iconfont">&#xe628;</i>
	                        <span class="name">简历</span>
	                    </a>
                    </#if>
                    <#if session_oa_emp.pers.get(PER_BULLETIN)??>
                    	<#if category==18>
	                    <a href="javascript:void(0);" class="exit on">
	                    <#else>
	                    <a href="${siteUrl}/bulletin" class="exit">
	                    </#if>
	                        <i class="icon iconfont">&#xe60c;</i>
	                        <span class="name">公告</span>
	                    </a>
                    </#if>
                    <#if session_oa_emp.pers.get(PER_DKPSITE)??>
                    	<#if category==19>
	                    <a href="javascript:void(0);" class="exit on">
	                    <#else>
	                    <a href="${siteUrl}/dkpsite" class="exit">
	                    </#if>
	                        <i class="icon iconfont">&#xe60d;</i>
	                        <span class="name">DKP官网</span>
	                    </a>
                    </#if>
                    <#if session_oa_emp.pers.get(PER_DKPS)??>
	                    <#if category==20>
	                    <a href="javascript:void(0);" class="exit on">
	                    <#else>
	                    <a href="${siteUrl}/dkp" class="exit">
	                    </#if>
	                        <i class="icon iconfont">&#xe60d;</i>
	                        <span class="name">DKP</span>
	                    </a>
                    </#if>
                    
                  <#if session_oa_emp.pers.get(PER_GRAND)??>
                <#if category==21>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/grand" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe641;</i>
                    <span class="name">商标管理</span>
                </a>
            </#if>
                    <#--
                    <#if session_oa_emp.pers.get(PER_PRC)??>
	                    <#if category==15>
	                    <a href="javascript:void(0);" class="exit on">
	                    <#else>
	                    <a href="${siteUrl}/product" class="exit">
	                    </#if>
	                        <i class="icon iconfont">&#xe649;</i>
	                        <span class="name">产品库</span>
	                    </a>
                    </#if>
                    -->
                </nav>
               
                
          <nav class="menu_cons clearfix none">
          	<#if !dingtalk_user_id?exists>
            <a href="javascript:void(0);" id="login-out-btn" class="exit">
                <i class="icon iconfont">&#xe603;</i>
                <span class="name">退出</span>
            </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_MANAGE)??>
                <#if category==1>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/management" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe600;</i>
                    <span class="name">管理</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_ME)??>
                <#if category==2>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/me" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe604;</i>
                    <span class="name">个人</span>
                </a>
        	</#if>
        	<#if session_oa_emp.pers.get(PER_ACCOUNT)??>
                <#if category==14>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/account" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe60b;</i>
                    <span class="name">账号</span>
                </a>
        	</#if>
        	<#if session_oa_emp.pers.get(PER_FINANCIAL)??>
                <#if category==3>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/financial" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe605;</i>
                    <span class="name">财务</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_REPORT)??>
                <#if category==4>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/daily" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe602;</i>
                    <span class="name">报表</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_ASSET)??>
                <#if category==5>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/asset" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe608;</i>
                    <span class="name">资产</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_WEIHU)??>
                <#if category==13>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/weihu" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe601;</i>
                    <span class="name">维护</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_KEFU)??>
                <#if category==10>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/kefu" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe622;</i>
                    <span class="name">客服</span>
                </a>
            </#if>
             <#if session_oa_emp.pers.get(PER_BBS)??>
                <#if category==7>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/sygsite" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe60d;</i>
                    <span class="name">官网</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_APPROVAL)??>
                <#if category==6>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/approval" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe606;</i>
                    <span class="name">审批</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_VERSION)??>
                <#if category==8>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/version" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe609;</i>
                    <span class="name">版本管理</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_RULES)??>
            	<#if category==9>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/rule" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe60c;</i>
                    <span class="name">规章制度</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_DATA)??>
                <#if category==11>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/datacenter/" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe607;</i>
                    <span class="name">数据中心</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_NDATA)??>
	            <#if category==16>
	            <a href="javascript:void(0);" class="exit on">
	            <#else>
	            <a href="${siteUrl}/data" class="exit">
	            </#if>
	                <i class="icon iconfont">&#xe607;</i>
	                <span class="name">新数据中心</span>
	            </a>
	        </#if>
	        
	        <#if session_oa_emp.pers.get(PER_RESUME_SEARCH)??>
                <#if category==17>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/resume/resumeSearch" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe628;</i>
                    <span class="name">简历</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_BULLETIN)??>
            	<#if category==18>
	            	<a href="javascript:void(0);" class="exit on">
	            <#else>
	            	<a href="${siteUrl}/bulletin" class="exit">
	            </#if>
	            <i class="icon iconfont">&#xe63e;</i>
	            <span class="name">公告</span>
	             </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_DKPSITE)??>
                <#if category==19>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/dkpsite" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe641;</i>
                    <span class="name">DKP官网</span>
                </a>
            </#if>
            <#if session_oa_emp.pers.get(PER_DKPS)??>
                <#if category==20>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/dkp" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe641;</i>
                    <span class="name">DKP</span>
                </a>
            </#if>
            
            <#if session_oa_emp.pers.get(PER_GRAND)??>
                <#if category==21>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/grand" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe641;</i>
                    <span class="name">商标管理</span>
                </a>
            </#if>
	        <#--
            <#if session_oa_emp.pers.get(PER_PRC)??>
                <#if category==15>
                <a href="javascript:void(0);" class="exit on">
                <#else>
                <a href="${siteUrl}/product" class="exit">
                </#if>
                    <i class="icon iconfont">&#xe623;</i>
                    <span class="name">产品库</span>
                </a>
            </#if>
            -->
        </nav>
    </header>     
<!-- 主内容区 -->
<div class="content clearfix">                  
</#macro>
	