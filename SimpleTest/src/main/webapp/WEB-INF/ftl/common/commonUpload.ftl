<#include "globalDef.ftl">
<link rel="stylesheet" href="${cssUrl}/amazeui.min.css">
<link rel="stylesheet" href="${cssUrl}/progress.css">
<form id="uploadForm" method="post" role="form" enctype="multipart/form-data">
	<div class="add_file_alert">
	  <div id="dvBtnUpload" class="am-form-group mt_tb tc">
	  	  <div class="am-form-group am-form-file m_width76 display_il va_top">
		  	  <button type="button" class="am-btn am-btn-primary am-form-file  am-btn-sm wt100">
	          <i class="am-icon-cloud-upload"></i>选择文件
	          </button>
	          <input type="file" name="uploadFile" id="_upload_tool" onchange="startUpload()">
          </div>
          <button type="button" class="am-btn am-btn-danger am-btn-sm va_top" onclick="layer.closeAll();">取消</button>
	  </div>
	  <div id="dvBtnIsCmp" class="tc mt1">
	      <div id="isCmpBtn" class="left_box open_left">
	      	<div class="right_box open_right"></div>
	      </div>
          <p class="am-text-danger fz10 mb10 mt10">允许压缩jpg、bmp</p>
       </div>
       <div id="dvProgress" class="tc mt1 none" style="margin:10px;display:none;">
          <div class="progress">
          	<span class="red" id="progressBar" style="width: 0%;"><span id="progressBarNum">0%</span></span>
          </div>
       </div>
	</div>
</form>
<script>
function startUpload(){
	showProcess();
	$("#uploadForm").ajaxSubmit({
		url:'${siteUrl}/fileUpload/uploadAny',
		type:'post',
		dataType: 'json',
		success:function(data){
		   process();
		   var mm = data.data;
		   uploadSuc(mm.url,mm.localName,mm.serverName);
		},
		error:function(e){
			alertErr("未知异常，稍后再试");
			hideProgress();
		}
	});
}
//进度条
function showProcess(){
	if($('#file').val() != ""){
		$('#dvBtnUpload').hide();
		$('#dvBtnIsCmp').hide();
		$('#dvProgress').show();
		uData.startTime=new Date().getTime();
		uData.realOver=false;
		uData.timeoutId = setTimeout(updateProgress,1000);
	}
}
function process(){
	if($('#file').val() != ""){
		try{
    		uData.realOver=true;
    		uData.percent = 100;
    		updateProgress();
    		setTimeout(function(){hideProgress();},500);
    	}catch(e){
    		alertErr(e);
    		hideProgress();
    	}
	}else{
		layer.closeAll();
	}
} 
//上传数据
var uData ={pBytesRead:0,pContentLength:1,percent:0,startTime:0,realTime:0,realOver:false,timeoutId:0};
function updateProgress(){
	$.post("/fileUpload/uploadPct",function(data){ 
		if(data){
			uData.pBytesRead = data.pBytesRead;
            uData.pContentLength = data.pContentLength;
		}else{
			uData.pBytesRead=1;
        	uData.pContentLength=1;
		}
		if(!uData.realOver){//真实上传进度
			uData.percent=(uData.pBytesRead/uData.pContentLength)*100/2;
			if(uData.pBytesRead==uData.pContentLength){
				uData.realOver=true;
				uData.realTime=new Date().getTime() - uData.startTime;
				uData.realTime= uData.realTime*2;
			}
			uData.percent=uData.percent.toFixed(2);
			changeShowPct(uData.percent);
			uData.timeoutId = setTimeout(updateProgress,1000);
			console.log("real pct:"+uData.percent+"timeoutId:"+uData.timeoutId);
		}else{//模拟剩余的40%
			if(uData.percent<90){
				var onePct = 40/(uData.realTime/1000);
				onePct = onePct>0?onePct:0.1;
				uData.percent = parseFloat(parseFloat(uData.percent).toFixed(2))+parseFloat(parseFloat(onePct).toFixed(2));
				if(uData.percent>90){
					uData.percent=90;
				}
				uData.timeoutId = setTimeout(updateProgress,1000);
			}
			changeShowPct(uData.percent);
			console.log("no real pct:"+uData.percent+"timeoutId:"+uData.timeoutId);
			if(uData.percent>=90 && uData.timeoutId!=0){
				uData.timeoutId=0;
				clearTimeout(uData.timeoutId);
			}
		}
    });
}
function hideProgress(){
	if(uData.timeoutId!=0){
		clearTimeout(uData.timeoutId);
	}
	layer.closeAll();
}
function changeShowPct(pct){
	$("#progressBar").css("width",pct+"%");
    $("#progressBarNum").html(pct+"%");
}
function uploadSuc(url,localName,serverName){
	console.log(url+",name:"+localName+",serverName:"+serverName);
	var html='';
	html+='<li style="margin:10px;width:120px;float:left;">';
	html+='<img src="'+url+'" alt="'+localName+'" style="width:100px;height:100px;"/>';
	html+='</li>';
	$(html).insertBefore(".add");
}
</script>