<#include "../../common/globalDef.ftl">
<@simpleList 1250>
<style>
.control-label{width:100px;padding-top:5px;}
</style>

<div class="widget-content"  id="tableContainer" style="overflow:auto;">
	<form id="importForm" name="importForm" action="${siteUrl}/datacenter/importExcel" method="post">
		<div class="modal-content">
			<div class="modal-body">
				<form id="uploadForm" class="form-horizontal" role="form" enctype="multipart/form-data">
				<div class="padd">
				<div class="form quick-post">
					<div class="form-group">
						<@formDate "选择日期" "logtime" "" 2/>
						<label class="control-label col-lg-2" style="width:100px;padding-top:5px;">选择文件</label>
						<div class="col-lg-2" style="width:auto;">
							<input id="excel" type="file" size="30" height="20px" name="excel">
						</div>
						<div class="col-lg-2">
							<input type="button" name="button" value="导入excel" class="btn btn-success" onclick="importExcelPrep()" />
						</div>
					</div>
				</div>
				<p style="height:25px;"><p/>
				<div class="form quick-post">
					<div class="form-group">
						<label class="control-label col-lg-2" style="width:100px;padding-top:5px;">文件名规则</label>
						<br/><br/>ps：平台放在用中文括号内，不带平台的文件名中不要带中文括号，excel文件中单元格内数字为空的都要用0填充,目前文件大小限制为不超过2m
						<br/>（联通_省）20151207_20151208.xls
						<br/>（基地_省）20151208_20151208.xls
						<br/>（电信）20151028_20151029_cp_out_report.csv
						<br/>（联通）20151028_20151029_1446369007473.xls
						<br/>（移动MM捕鱼1）20151028_应用街机千炮捕鱼（高清版）-渠道分析-渠道列表日数据_172547.csv
						<br/>（移动MM捕鱼1）20151028_应用街机千炮捕鱼（魔灵版）-渠道分析-渠道列表日数据_823240.csv
						<br/>（移动MM捕鱼1）20151028_应用街机千炮捕鱼（移动版）-渠道分析-渠道列表日数据_120191.csv
						<br/>（移动MM捕鱼1）20151028_应用街机千炮捕鱼-渠道分析-渠道列表日数据_582449.csv
						<br/>（移动MM捕鱼2）20151028_应用千炮捕鱼2赢话费-渠道分析-渠道列表日数据_378443.csv
						<br/>（移动基地）20151028_20151029_1446208908711.xls
						<br/>（易接）20151028_20151029_PayReport.csv
						<br/>（友盟）20151028_20151029千炮捕鱼_渠道数据明细.csv
						<br/>（友盟）20151028_20151029千炮捕鱼2赢话费_渠道数据明细.csv
						<br/>（友盟）20151028_千炮捕鱼_2015-10-28_1天内_渠道效果跟踪_新增帐号.csv
						<br/>（友盟）20151028_千炮捕鱼2赢话费_2015-10-28_1天内_渠道效果跟踪_新增帐号.csv
						<br/>360SDK_20151028_20151028.xlsx
						<br/>ios_20151028.xlsx
						<br/>xy_20151028_20151030.xlsx
						<br/>电信爱游戏平台_20151028_20151030.xlsx
						<br/>积分墙_20151028_20151030.xlsx
						<br/>联想_20151028_20151030.xlsx
						<br/>易接短代_20151028_20151030.xlsx
						<br/>易接第三方_20151028_20151030.xlsx
						<br/>安智微信_20151028_20151030.xlsx
						<br/>资源位_20151028_20151030.xlsx
						<br/>总表杂项_20151028_20151030.xlsx
						<br/>管控信息表_20151207_20151208.xlsx
						<br/>对应关系.xlsx
					</div>
				</div>
				</div>
				</form>
				<p style="height:15px;"><p/>
			</div>
		</div>
	</form>
	
</div>

</@simpleList>
<script>	
	function importExcelPrep(){
		$('#importForm').ajaxSubmit({
	        type: "POST",
	        url: "${siteUrl}/import/checkDate",
	        async: false,
	        dataType : 'json',
	        error:function(dataOrg){
	        	alertErr('未知异常');
	        },
	        success : function(dataOrg){
	        	if (dataOrg.code!="S") {
	        		if(dataOrg.msg=="数据已存在") {
	        			alertConfirm("已经存在数据，是否要覆盖？",function(){
			        		deleteAndImportExcel();
			        	},null);
	        		}else{
	        			alertErr(dataOrg.msg);
	        		}
				} else {
					alertConfirm("数据即将导入，请点击确定！",function(){
			        		importExcel();
			        	},null);
	        	}
	        }
	    });
	}
	
	function deleteAndImportExcel(){
		$('#importForm').ajaxSubmit({
	        type: "POST",
	        url: "${siteUrl}/import/deleteAndImportExcel",
	        async: false,
	        dataType : 'json',
	        error:function(dataOrg){
	        	alertErr('未知异常');
	        },
	        success : function(dataOrg){
	        	var res=comMsg(dataOrg);
				if(res!=null){
					alertSuc("导入成功");
				}
	        }
	    });
	}
	
	function importExcel(){
		$('#importForm').ajaxSubmit({
	        type: "POST",
	        url: "${siteUrl}/import/importExcel",
	        async: false,
	        dataType : 'json',
	        error:function(dataOrg){
	        	alertErr('未知异常');
	        },
	        success : function(dataOrg){
	        	var res=comMsg(dataOrg);
				if(res!=null){
					alertSuc("导入成功");
				}
	        }
	    });
	}
</script>