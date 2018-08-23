<#macro checkInput length regex>maxlength="${length}" autocomplete="off" onkeyup="value=value.replace(${regex},'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(${regex},''))"</#macro>

<#--排序小方法-->
<#macro seqTh pageObj formName field>
	<th onclick="javascript:sortField('${formName}','${field}',${pageObj.seqType})" class="sorting<#if pageObj?? && pageObj.seqName==field>${(pageObj.seqType==0)?string('_asc','_desc')}</#if>"><#nested/></th>
</#macro>

<#--表单提交中的input=text-->
<#macro formText showName fieldName defVal=""  width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<input type="text" class="form-control" name="${fieldName}" id="${fieldName}" value="${defVal}" >
		<#nested/>
	</div>
</div>
</#macro>

<#--表单提交中的input=text-->
<#macro formTextHidden fieldName defVal="" width=6>
		<input type="hidden" class="form-control" name="${fieldName}" id="${fieldName}" value="${defVal}" >
		<#nested/>
</#macro>

<#--表单提交中的input=checkbox-->
<#macro formCheckBox showName fieldName status defVal="" width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<input type="checkbox"   class="form-control" name="${fieldName}"  id="${fieldName}" value="${defVal}" />
		<#nested/>
	</div>
</div>
</#macro>

<#--表单提交中的input=text-->
<#macro formTextCheck showName fieldName defVal=""  width=6 length=400 regex="">
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<input type="text" class="form-control" name="${fieldName}" value="${defVal}" <@checkInput length="${length}" regex="${regex}"/> >
		<#nested/>
	</div>
</div>
</#macro>


<#--表单提交中的input=text readonly-->
<#macro formTextReadOnly showName fieldName defVal=""  width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<input type="text" class="form-control" name="${fieldName}" id="${fieldName}" value="${defVal}" readonly="readonly" >
		<#nested/>
	</div>
</div>
</#macro>
<#-- 用于时间控件下的表头不移动 -->
<#macro shDateBeginEndSub >
	
    <div class="col-lg-6" style="min-width:128px" >	</div>
	<#nested/>
	<div class="col-lg-6" style="min-width:128px" >	</div>
	
</#macro>

<#--搜索日期  开始-结束-->
<#macro shDateBeginEnd fieldName shDate=null >
    	<input type="text" class="form-control timectrl twinHasDatepicker" name="${fieldName}.begin" 
    		style="width:120px;" value="<#if shDate??>${(shDate.begin?date)!}</#if>" id="begin_${fieldName?replace(".","_")}" />
	<#nested/>
		<input type="text" class="form-control timectrl twinHasDatepicker" name="${fieldName}.end" 
			style="width:120px;" value="<#if shDate??>${(shDate.end?date)!}</#if>" id="end_${fieldName?replace(".","_")}" />	
</#macro>

<#--表单提交中的日期选择和显示-->
<#macro formDate showName fieldName defVal="" width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
    <div class="col-lg-${width}">
		<input type="text" class="form-control" name="${fieldName}" value="${defVal}" id="datepicker_${fieldName?replace(".","_")}" >
		<#nested/>
	</div>
</div>

<script type="text/javascript">
	$('#datepicker_${fieldName?replace(".","_")}').datetimepickerNew({
		showHour: false,
		showMinute: false,
		showSecond: false,
		timeText: '',
		timeFormat: ''
	});
</script>

</#macro>

<#--表单提交中的日期时间选择和显示   精确到秒-->
<#macro formDateTime showName fieldName defVal="" width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
    <div class="col-lg-${width}">
		<input type="text" class="form-control" name="${fieldName}" value="${defVal}" id="timepicker_${fieldName?replace(".","_")}" >
		<#nested/>
	</div>
</div>

<script type="text/javascript">
	$('#timepicker_${fieldName?replace(".","_")}').datetimepickerNew({
		showHour: true,
		showMinute: true,
		showSecond: true,
		timeText: '时间',
		timeFormat: 'hh:mm:ss'
	});
</script>

</#macro>


<#--表单提交中的input=select-->
<#macro formSelect showName width=3>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<#nested/>
	</div>
</div>
</#macro>

<#--表单提交中的多选  

	showName:显示的名字
	inputName:input标签的名字
	allList:循环用的列表
	valueParam:值对应的字段
	nameParam:名字对应的字段
	
	checkedList:默认选中的列表(可不填)
	checkedParam:默认选中列表中的值字段(可不填)
	width:宽度
	
 -->
<#macro formMulti showName inputName allList valueParam nameParam checkedList="" checkedParam="" width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<#list allList as item>
		<label class="checkbox-inline">
			<#local checked=false/>
			<#if checkedList!="" && checkedParam!="">
			<#list checkedList as checkedItem>
				<#if item[valueParam] == checkedItem[checkedParam]>
					<#local checked=true/>
				</#if>
			</#list>
			</#if>
          	<input type="checkbox" <#if checked==true>checked="checked"</#if> name="${inputName}" id="multi_${inputName}" value="${item[valueParam]}"> ${item[nameParam]}
        </label>
        </#list>
        <#nested/>
	</div>
</div>
</#macro>

<#--表单提交中的CLEditor编辑器-->
<#macro formTextCLEditer showName inputName defVal="" width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-9">
	<textarea id="input" name="${inputName}">${defVal}</textarea>
	</div>
</div>
<script src="${jsUrl}/jquery.cleditor.min.js"></script>
<link rel="stylesheet" href="${cssUrl}/jquery.cleditor.css" />
<script >
    $(document).ready(function () {$("#input").cleditor()[0].focus();});
</script>
</#macro>

<#--表单提交中的CLEditor编辑器-->
<#macro formTextCLEditerHigher showName inputName defVal="" width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
</div>
<p>&nbsp;</p>
<div class="form-group">
	<div class="col-lg-12">
	<textarea id="input" name="${inputName}">${defVal}</textarea>
	</div>
</div>
<script src="${jsUrl}/jquery.cleditor.min.js"></script>
<link rel="stylesheet" href="${cssUrl}/jquery.cleditor.css" />
<script >
    $(window).load(function () {
    	$("#input").cleditor()[0].focus();
    	$(".cleditorMain").height(660);
    	$(".cleditorMain iframe").height(612);
    });
</script>
</#macro>

<#--表单提交中的大文本编辑器-->
<#macro formTextEditer showName inputName defVal="" width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<textarea style="width:450px;height:156px;outline:none;resize:none;" class="cleditor" name="${inputName}">${defVal}</textarea>
	</div>
</div>
</#macro>

<#--表单提交中的大文本编辑器 readonly-->
<#macro formTextEditerReadOnly showName inputName defVal="" width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<textarea class="cleditor" name="${inputName}" readonly="readonly">${defVal}</textarea>
	</div>
</div>
</#macro>


<#--统一显示小数   -->
<#macro dNum num=null>
<#if num??>
${num?string("0.000000")}
<#else>
0
</#if>
</#macro>


<#--表单提交中的input=file-->
<#macro formFile showName fileName width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}" id="sc">
		<input type="file" class="btn btn-info" name="${fileName}" >
	</div>
	<div>
		<button type="button" class="btn btn-warning" onclick="javascript:showSC2();">添加</button>
	</div>
</div>
</#macro>



<#--表单中的上传图片 -->
<#macro formUpdateImg showName fieldName defVal="" width=6 spHeight=375 spWidth=500>
<style>
#preview_${fieldName}{
	height: ${spHeight}px;
    width: ${spWidth}px;
    position:absolute;
    z-index: 19891050;
    display: none;
    background-image:url(${defVal});
    background-repeat: no-repeat;
}
</style>
<script type="text/javascript">
imagePreview = function(){	
	xOffset = -20;
	yOffset = 0;
	$("#imgUploadShow_${fieldName}").hover(function(e){
		var img = new Image(); 
		img.src =$('#imgUploadShow_${fieldName}').attr("src"); 
		if(img.height>${spHeight} || img.width>${spWidth})
		{
			$("body").append("<div id='preview_${fieldName}' style='background-size:contain;' ></div>");
		} else {
			$("body").append("<div id='preview_${fieldName}' ></div>");
		}
		$("#preview_${fieldName}")
			.css("top",(e.pageY - yOffset) + "px")
			.css("left",(e.pageX - xOffset) + "px")
			.fadeIn("normal");						
	},
	function(){
		$("#preview_${fieldName}").remove();
	});	
	$("#imgUploadShow_${fieldName}").mousemove(function(e){
		$("#preview_${fieldName}")
			.css("top",(e.pageY - yOffset) + "px")
			.css("left",(e.pageX - xOffset) + "px");
	});		
};
$(document).ready(function(){
	imagePreview();
});
</script>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<input type="text" class="form-control" id="imgName_${fieldName}" name="${fieldName}" value="${defVal}" readonly="readonly">
	</div>
	<div>
		<button type="button" class="btn btn-warning" onclick="javascript:showImgPop('${siteUrl}/file/filePage','imgName_${fieldName}','imgUploadShow_${fieldName}','上传图片');">上传图片</button>
	</div>
</div>
<#nested/>
<div class="form-group">
	<label class="control-label col-lg-2"> </label>
	<div class="col-lg-${width}">
	<div class="gallery" >
		<#if defVal?? && defVal!="">
	        <div>
	        <img id="imgUploadShow_${fieldName}" src="${defVal}"  >
	        </div>
        <#else>
	        <div>
	        <img id="imgUploadShow_${fieldName}" src="${imgUrl}/cream.png"  >
	        </div>
        </#if>
    </div>
    </div>
</div>

</#macro>

<#--表单中的上传图片 -->
<#macro formProductUpdateImg showName fieldName defVal="" width=6 spHeight=375 spWidth=500>
<style>
#preview_${fieldName}{
	height: ${spHeight}px;
    width: ${spWidth}px;
    position:absolute;
    z-index: 19891050;
    display: none;
    background-image:url(${defVal});
    background-repeat: no-repeat;
}
</style>
<script type="text/javascript">
imagePreview = function(){	
	xOffset = -20;
	yOffset = 0;
	$("#imgUploadShow_${fieldName}").hover(function(e){
		var img = new Image(); 
		img.src =$('#imgUploadShow_${fieldName}').attr("src"); 
		if(img.height>${spHeight} || img.width>${spWidth})
		{
			$("body").append("<div id='preview_${fieldName}' style='background-size:contain;' ></div>");
		} else {
			$("body").append("<div id='preview_${fieldName}' ></div>");
		}
		$("#preview_${fieldName}")
			.css("top",(e.pageY - yOffset) + "px")
			.css("left",(e.pageX - xOffset) + "px")
			.fadeIn("normal");						
	},
	function(){
		$("#preview_${fieldName}").remove();
	});	
	$("#imgUploadShow_${fieldName}").mousemove(function(e){
		$("#preview_${fieldName}")
			.css("top",(e.pageY - yOffset) + "px")
			.css("left",(e.pageX - xOffset) + "px");
	});		
};
$(document).ready(function(){
	imagePreview();
});
</script>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<input type="text" class="form-control" id="imgName_${fieldName}" name="${fieldName}" value="${defVal}" readonly="readonly">
	</div>
	<div>
		<button type="button" class="btn btn-warning" onclick="javascript:showImgPop('${siteUrl}/datacenter/filePage','imgName_${fieldName}','imgUploadShow_${fieldName}','上传图片');">上传图片</button>
	</div>
</div>
<#nested/>
<div class="form-group">
	<label class="control-label col-lg-2"> </label>
	<div class="col-lg-${width}">
	<div class="gallery" >
		<#if defVal?? && defVal!="">
	        <div>
	        <img id="imgUploadShow_${fieldName}" src="${defVal}"  >
	        </div>
        <#else>
	        <div>
	        <img id="imgUploadShow_${fieldName}" src="${imgUrl}/cream.png"  >
	        </div>
        </#if>
    </div>
    </div>
</div>

</#macro>

<#--表格长内容处理 -->
<#macro txtLimit text max=64>
	<#if text?? && text?length gt max>
		${text?substring(0,max)}...<a style="cursor:pointer;" onclick="javascript:fullTxtTip(this.title);" title="${text?html}">(more)</a>
	<#else>
		${text!}
	</#if>
</#macro>

<#--数量单位转换-->
<#macro parseMoney value>
	<#if value gt 10000>
		${(value/10000)?string('#.##')}万
		<#elseif value gt 10000*10000>
		${(value/(10000*10000))?string('#.##')}亿
		<#else>
		${value!}
	</#if>
</#macro>

<#--数据显示转换-->
<#macro parseNum value>
     <#if value?exists>
	    <#if value?? && (value gt 0)>
		${(value)?string('0.00')}
		<#else>
		${value!}
	    </#if>
	 </#if>
</#macro>

<#--数据显示转换%-->
<#macro parseNum2 value>
	<#if value?exists>
	    <#if value?? && (value gt 0)>
		${(value)?string('0.00')}%
		<#else>
		${value!}%
		</#if>
	</#if>
</#macro>

<#--数据显示转换-->
<#macro parseKindId value1 value2>
     <#if value1?exists>
	    <#if value1=="4">
		  时光币
		<#elseif value1=="5">
		  <#if value2=="1">金币</#if>
		  <#if value2=="2">积分</#if>
	    </#if>
	 </#if>
</#macro>

<#macro uploadJs jsCallBackFun serverType maxSize=2048 resUrl="common/commonUpload">
	showSimplePop('${siteUrl}/fileUpload/commonUploadPage',null,'','400',{jsCallBackFun:'${jsCallBackFun}'})
</#macro>

<#macro formFile2 showName fileName tipShowName="" width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}" id="sc">
		<input type="file" name="${fileName}">(<font color="#FF0000">${tipShowName}</font>)
	</div>
</div>
</#macro>

<#macro formTextArea showName fieldName defVal="" rows=2 width=6>
<div class="form-group">
	<label class="control-label col-lg-2">${showName}</label>
	<div class="col-lg-${width}">
		<textarea class="form-control" name="${fieldName}" id="${fieldName}" rows="${rows}">${defVal}</textarea>
	</div>
</div>
</#macro>
