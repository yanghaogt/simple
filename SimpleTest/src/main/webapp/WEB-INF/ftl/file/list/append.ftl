<#include "../../common/globalDef.ftl">
<@simpleList 850>
<style>
.zy_account_point{position:relative;border:1px solid #999;height:40px;padding-left:5px;width:445px;margin-bottom:15px;}
.zy_account_point .none{display:none;}
.zy_account_point input,.zy_account_point select{height:30px;border:0 none;vertical-align:baseline;border-bottom:1px solid #666;}
.box{border:1px solid #999;width:470px;height:490px;max-height:490px;overflow:auto;border-radius:5px;padding:20px;margin:20px;}
.btn_simple{border:0 none;font-size:16px;background:0 none;cursor:pointer;color:#0096db;font:16px microsoft yahei,Sans-serif;}
.mb20{margin-bottom:20px;}
.wt60{width:60px;}
</style>
<div class="widget-content"  id="tableContainer" style="overflow:auto;min-height:830px;">
<div class="box">
	<p class="zy_account_point none fixPayInfoList" style="display:none;">
      <label for="">金额（元）</label>
      <input type="text" class="wt60" id="price" placeholder="" value="">
      <label for="">计费码</label>
      <input type="text" class="wt60" id="diyId" placeholder="" value="">
      <label for="">自定义编码</label>
      <input type="text" class="wt60" id="productCode" placeholder="" value="">
      <i class="zy_delete_x">╳</i>
    </p>
    <p class="zy_account_point fixPayInfoList">
      <label for="">金额（元）</label>
      <input type="text" class="wt60" id="price" placeholder="" value="">
      <label for="">计费码</label>
      <input type="text" class="wt60" id="diyId" placeholder="" value="">
      <label for="">自定义编码</label>
      <input type="text" class="wt60" id="productCode" placeholder="" value="">
      <i class="zy_delete_x">╳</i>
    </p>
    <p class="form_group clearfix">
      <button type="button" class="btn_simple zy_add_account">新增</button>
   	</p>
   	<p class="form_group clearfix">
      <button type="button" class="btn_simple" onclick="editSdkParam();">提交</button>
   	</p>
</div>
</@simpleList>
<script type="text/javascript">
$('.zy_add_account').click(function(event) {
	var _this=$(this);
	var _thisParent=_this.parent();
	var _newElementAccount=_this.parent('.form_group').siblings('.zy_account_point:first').clone(true).show();
	_newElementAccount.insertBefore(_thisParent);
});
$('.zy_delete_x').click(function(event) {
	$(this).parent('.zy_account_point').remove();
});
function getSplashList(){
	var $fixPayInfoList = $('.fixPayInfoList');//list对象(html)
	var fixPayInfoList = [];//拼JSON数组
	for ( var i = 1; i < $fixPayInfoList.length; i++) {
		var $$fixPayInfo = $($fixPayInfoList[i]);//html的jquery对象
		var fixPayInfo = {};//拼JSON
		fixPayInfo.price = $$fixPayInfo.find('#price').val();
		fixPayInfo.diyId = $$fixPayInfo.find('#diyId').val();
		fixPayInfo.productCode = $$fixPayInfo.find('#productCode').val();
		fixPayInfoList.push(fixPayInfo);//放到数组里去
	}
	return fixPayInfoList;
}
function editSdkParam(){
	var fixPayInfoList = getSplashList();
	console.log(JSON.stringify(fixPayInfoList));
}
</script>

