<#include "leftMenuChild.ftl">
<#macro left all=0>
<!-- 侧边菜单-->
<aside class="aside_menu">
	<div class="state">
       <div class="select mt11">
	        <select id="changeGame" name="changeGame">
	        	<option <#if curr_game?exists & curr_game==0>selected="selected"</#if> value="">全部应用</option>
			    <#list game_list as item>
			    	<option <#if curr_game?exists & curr_game==item.kindId>selected="selected"</#if> value="${item.kindId}">${item.gameName}</option>
			    </#list>
	        </select>
   	   </div>
   </div>
        <div class="oa_menu_list">
          <ul class="one_menu_list mb20">
          	<#if session_oa_emp.oasubPer?exists>
				<#assign rootPer = session_oa_emp.oasubPer>
				<@leftMenuChild rootPer.subList 0/>
			</#if>
		  </ul>
	  	</div>
</aside>
<script>
$('#changeGame').on('change',function(e){
		var gameKind = $(this).val();
		var all = ${all!};
		$.ajax({
			"url": "${siteUrl}/data/changeGame",
			"type":"post",
			"dataType":"json",
			"data" : {'gameKind': gameKind},
			"async":false,
			success:function(dataOrg){
				var res=comMsg(dataOrg);
				if(res!=null){
					$("#gameKindSelect").val(gameKind);
					if(gameKind == "" && all == 0){//全部应用
						location.href = GLBConfig.homeUrl+"data/summary/game";
					}
					if(gameKind > 0){
						location.href = GLBConfig.homeUrl+"data/overview/realtime?gameKind="+gameKind;
					}
				}
			},
			error:function(e){
				alertErr('操作失败,未知异常');
			}
		});
});	
</script>
</#macro>