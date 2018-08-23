<#include "../../common/globalDef.ftl">
<@simpleEdit "修改角色信息" "${siteUrl}/manage/roleEdit">
<input type="hidden" name="mrId" value="${example.mrId}">
<input type="hidden" name="mpIds" id="mpIds">
<@formText "角色名" "roleName" "${example.roleName!}"/>

<div class="form-group">
	<label class="control-label col-lg-2">选择权限</label>
	<div class="col-lg-6">
	<input type="text" id="searchRolePer"  class="form-control"  placeholder="快速查询">
	</div>
</div>
	<div style="margin-left:100px;width:470px;max-height:500px;overflow:auto;">
		<div id="rolePerTree">
		
		</div>
	</div>

<script>
	//$.ajaxSetup({cache:false});
	//查询方法
	var to=false;
	$('#searchRolePer').keyup(function () {
	    if(to) { clearTimeout(to); }
	    to = setTimeout(function () {
	      var v = $('#searchRolePer').val();
	      $('#rolePerTree').jstree(true).search(v);
	    }, 200);
	});
	$("#rolePerTree").jstree({
		  "core" : {
		  	"three-state":false,
			"multiple":true,
		    "worker":false,
		    "data":<#include "../per/json_tree.ftl">
		  },
		  "checkbox":{
		  	"three_state":false,
		  	"cascade":""
		  },
		  "plugins" : [ "search","checkbox"]
	});
	
	function updateMenuIds(){
      var nodeIds=$("#rolePerTree").jstree(true).get_checked();
      $("#mpIds").val(nodeIds);
	}
	
	commonModalSubmitCheck=function(){
		updateMenuIds();
		return true;
	}
</script>

</@simpleEdit>