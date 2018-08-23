<#include "../../common/globalDef.ftl">
<div id="alertBoxAnim">
<@simpleAdd "申请资源添加" "${siteUrl}/data/batchAdd">	
<@formSelect "发送范围" 4>
	<select class="form-control" name="sendType" id="isTotal">
		<option value="1">所有玩家</option>
		<option value="0">指定角色名</option>
		<option value="2">导入角色名</option>
		<option value="3">指定角色ID</option>
		<option value="4">导入角色ID</option>
	</select>
</@formSelect>
<div id="inputRoleNames">
	<label class="control-label" style="float:left;padding:0 20px 0 20px;widht:100px;">角色名</label>
	<div style="border:1px solid #CDC5BF;height:180px;width:450px;overflow-y:auto;overflow-x:hidden;padding:0 20px 20px 20px;margin-left:100px;">
		<span id="spanRoleNames"></span>
	</div>
	<button class="btn btn-default" type="button" id="addRoleNames" style="margin-left:30px;margin-button:25px;margin-top:10px;">新增</button>
</div>
<div id ="importRoles">
	<@formFile2 "角色名" "roleNames" "Excel,第一列为服务器ID,第二列为角色名字" />
</div>
<div id ="importRoleNames">
	<@formFile2 "角色ID" "roleIds" "Excel,第一列为服务器ID,第二列为角色ID" />
</div>
<div id="inputRoleIds">
	<label class="control-label" style="float:left;padding:0 20px 0 20px;widht:100px;">角色ID</label>
	<div style="border:1px solid #CDC5BF;height:180px;width:450px;overflow-y:auto;overflow-x:hidden;padding:0 20px 20px 20px;margin-left:100px;">
		<span id = "spanRoleIds"></span>
	</div>
	<button class="btn btn-default" type="button" id="addRoleIds" style="margin-left:30px;margin-button:25px;margin-top:10px;">新增</button>
</div>
<@formText "标题" "mailTitle" />
<@formTextArea "内容" "mailContent" />
<@formTextArea "申请原因" "comment" />
<button class="btn btn-default" type="button" id="addfixPay1" style="margin-left:50px">继续添加</button>
<script>
$(function(){
  var t = "<span class='oa_lwy_form'>" +
      "<input type='text' id='roleName' name='roleName' style='width:90px;margin-top:10px'>&nbsp;<a href='javascript:;' class='oa_lwy_del'>删除</a>&nbsp;</span>";
      $("#addRoleNames").click(function(){
  		$("#spanRoleNames").after(t);//添加栅格
  		removeFormGroup();//删除栅格
  	});
});
$(function(){
	$(".layui-layer-content").css("max-height","620px");
	var t ="<div class='oa_lwy_form' style='padding-bottom:10px;'>"+$('#configIOS1').prop("outerHTML")
	+"<button class='btn btn-danger oa_lwy_del' type='button' style='margin-left:200px;'>删除</button></div>";
	$("#addfixPay1").click(function(){
		//$("#configIOS1").after(t);//添加栅格
		$(t).insertBefore($(this));
		removeFormGroup();//删除栅格
	});
});
$(function(){
  var t = "<span class='oa_lwy_form'>" +
      "<input type='text' id='roleId' name='roleId' style='width:90px;margin-top:10px'>&nbsp;<a href='javascript:;' class='oa_lwy_del'>删除</a>&nbsp;</span>";
  	$("#addRoleIds").click(function(){
  		$("#spanRoleIds").after(t);//添加栅格
  		removeFormGroup();//删除栅格
  	});
});
function removeFormGroup(){//统一删除操作 
   $('.oa_lwy_del').on('click',function(){
      $(this).parents('.oa_lwy_form').remove();
   });
}
//发送方式
$(function() {
		$("#inputRoleNames").hide();
		$("#inputRoleIds").hide();
		$("#importRoles").hide();
		$("#importRoleNames").hide();
	    $("#isTotal").change(function(){
	     var choose=$("#isTotal").val();
			if(choose=="0"){
				$("#serverListAndChannelList").show();	
				$("#inputRoleNames").show();
				$("#inputRoleIds").hide();
				$("#importRoles").hide();
				$("#importRoleNames").hide();
			}else if(choose=="1"){
				$("#serverListAndChannelList").show();	
				$("#inputRoleNames").hide();
				$("#inputRoleIds").hide();
				$("#importRoles").hide();
				$("#importRoleNames").hide();
			}else if(choose=="2"){
				$("#serverListAndChannelList").hide();
				$("#inputRoleNames").hide();
				$("#inputRoleIds").hide();
				$("#importRoles").show();
				$("#importRoleNames").hide();
			}else if(choose=="3"){
				$("#serverListAndChannelList").show();
				$("#inputRoleNames").hide();
				$("#inputRoleIds").show();
				$("#importRoles").hide();
				$("#importRoleNames").hide();
			}else if(choose=="4"){
				$("#serverListAndChannelList").hide();
				$("#inputRoleNames").hide();
				$("#inputRoleIds").hide();
				$("#importRoles").hide();
				$("#importRoleNames").show();
			}
	    });
  	});
</script>
</@simpleAdd>
</div>
