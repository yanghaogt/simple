<#--排序小方法-->
<#macro seqTh pageObj formName field>
	<th onclick="javascript:sortField('${formName}','${field}',${pageObj.seqType})" class="sorting<#if pageObj?? && pageObj.seqName==field>${(pageObj.seqType==0)?string('_asc','_desc')}</#if>"><#nested/></th>
</#macro>

<#--版本-渠道-时间段选择

v:版本  c:渠道   d:时间段  参数=1 显示

-->
<#macro headerSelect v=0 c=0 d=0 ajaxMethod="">
  <#if d=1>
  <!--时间段选择-->
  <div class="time_ganged fr">
    <div class="ta_date" id="div_selectDate">
        <span class="date_title data_time_sel" id="selectDate"></span>
        <a class="opt_sel" id="input_trigger1" href="#">
            <i class="i_orderd"></i>
        </a>
    </div>
    <div id="datePicker1"></div>
    <div class="chart_menu_alert none">
      <ul class="option_item">
        <li id="aRecent60Days">过去60天</li>
        <li id="aRecent30Days">过去30天</li>
        <li id="aRecent7Days">过去7天</li>
        <li id="aToday">今日</li>
      </ul>
      <a href="javascript:;"  class="chart_alert_confirm optionalTimeBtn btn2" data-method="2">自选</a>
    </div>
    <input type="hidden" id="logTimeSh_begin" name="logTimeSh.begin" value="<#if example.logTimeSh?exists>${example.logTimeSh.begin?string("yyyy-MM-dd")!}</#if>"/>
    <input type="hidden" id="logTimeSh_end" name="logTimeSh.end" value="<#if example.logTimeSh?exists>${example.logTimeSh.end?string("yyyy-MM-dd")!}</#if>"/>
  </div>
  </#if>
  <#if d=2>
  <!--时间段选择-->
  <div class="time_ganged fr">
    <div class="ta_date" id="div_selectDate2">
        <input  id="selectDate2" class="date_title" type="text" value="<#if example.logTimeShDay?exists>${example.logTimeShDay.begin?string('yyyy-MM-dd')!}<#else>${.now}</#if>"/>
    </div>
    <input type="hidden" id="logTimeShDay_begin2" name="logTimeShDay.begin" value="<#if example.logTimeShDay?exists>${example.logTimeShDay.begin?string("yyyy-MM-dd")!}<#else>${.now}</#if>"/>
    <input type="hidden" id="logTimeShDay_end2" name="logTimeShDay.end" value="<#if example.logTimeShDay?exists>${example.logTimeShDay.end?string("yyyy-MM-dd")!}<#else>${.now}</#if>"/>
  </div>
  </#if>
  <script>
  $(function(){
  		<#if d==1>
	  		var dateRange1 = new pickerDateRange('selectDate', {
	  			  aToday : 'aToday',// 今天
		          aRecent7Days : 'aRecent7Days',// 最近七天
		          aRecent30Days : 'aRecent30Days',//最近30天
		          aRecent60Days : 'aRecent60Days',//最近60天
		          isTodayValid : true,
		          startDate : '<#if example.logTimeSh?exists>${example.logTimeSh.begin?string("yyyy-MM-dd")!}</#if>',
		          endDate : '<#if example.logTimeSh?exists>${example.logTimeSh.end?string("yyyy-MM-dd")!}</#if>',
		          needCompare : false,
		          defaultText : ' 至 ',
		          autoSubmit : false,
		          inputTrigger : 'input_trigger1',
		          theme : 'ta',
		          success : function(obj) {
		          	$("#logTimeSh_begin").val(obj.startDate);
		          	$("#logTimeSh_end").val(obj.endDate);
		          	<#if ajaxMethod !="">
		          	${ajaxMethod}();
		          	<#else>
		          	$("form[name='defaultForm']").submit();
		          	</#if>
	          	}	
	        });
        <#elseif d==2>
	        $('#selectDate2').datetimepickerNew({
				showHour: false,
				showMinute: false,
				showSecond: false,
				timeText: '',
				timeFormat: '',
				onClose:function(e){
					$("#logTimeShDay_begin2").val(e);
					$("#logTimeShDay_end2").val(e);
					<#if ajaxMethod !="">
		          		${ajaxMethod}();
		          	<#else>
		          		$("form[name='defaultForm']").submit();
		          	</#if>
				}
			});
      </#if>  
  });
</script>
</#macro>

<#macro dataTips title idName="default" isTip=0 width=400 height=300>
	  <h2 class="dp_inline_bl">${title}
		  <#if isTip==1>
		  	<i class="icon iconfont ml10 color1 cursor ${idName}">&#xe60f;</i>
		  </#if>
	  </h2>
	<script>
		$(function(){
			$('.${idName}').hover(function() {
				var that = this;
				    $('.data_tips .highlight').css('color', '#4BD8DF');
				    layer.tips($('#${idName}').html(), that,{
				          tips: [4, '#666'],
				          area: ['${width}px'],
				          shift :5,
				          time:0            
				        }); //在元素的事件回调体中，follow直接赋予this即可
				}, function() {
				    layer.close(layer.tips()); 
			});
		});
	</script>
</#macro>

<#macro headerSelect2 ajaxMethod="">
  <!--时间段选择-->
  <div class="time_ganged fr">
    <div class="ta_date" >
        <span class="date_title data_time_sel" id="selectDate2"></span>
        <a class="opt_sel" id="input_trigger2" href="#">
            <i class="i_orderd"></i>
        </a>
    </div>
    <div id="datePicker2"></div>
    <div class="chart_menu_alert none">
      <ul class="option_item">
        <li id="aRecent60Days2">过去60天</li>
        <li id="aRecent30Days2">过去30天</li>
        <li id="aRecent7Days2">过去7天</li>
        <li id="aToday2">今日</li>
      </ul>
      <a href="javascript:;"  class="chart_alert_confirm optionalTimeBtn btn2" data-method="2">自选</a>
    </div>
    <input type="hidden" id="logTimeSh_begin2" name="logTimeSh.begin" value="<#if example.logTimeSh?exists>${example.logTimeSh.begin?string("yyyy-MM-dd")!}</#if>"/>
    <input type="hidden" id="logTimeSh_end2" name="logTimeSh.end" value="<#if example.logTimeSh?exists>${example.logTimeSh.end?string("yyyy-MM-dd")!}</#if>"/>
  </div>
  
  <script>
  $(function(){
	  		var dateRange2 = new pickerDateRange('selectDate2', {
	  			  aToday : 'aToday2',// 今天
		          aRecent7Days : 'aRecent7Days2',// 最近七天
		          aRecent30Days : 'aRecent30Days2',//最近30天
		          aRecent60Days : 'aRecent60Days2',//最近60天
		          isTodayValid : true,
		          startDate : '<#if example.logTimeSh?exists>${example.logTimeSh.begin?string("yyyy-MM-dd")!}</#if>',
		          endDate : '<#if example.logTimeSh?exists>${example.logTimeSh.end?string("yyyy-MM-dd")!}</#if>',
		          needCompare : false,
		          defaultText : ' 至 ',
		          autoSubmit : false,
		          inputTrigger : 'input_trigger2',
		          theme : 'ta',
		          success : function(obj) {
		          	$("#logTimeSh_begin2").val(obj.startDate);
		          	$("#logTimeSh_end2").val(obj.endDate);
		          	<#if ajaxMethod !="">
		          	${ajaxMethod}();
		          	<#else>
		          	$("form[name='defaultForm']").submit();
		          	</#if>
	          	}	
	        });
  });
  
</script>
      
</#macro>


<#macro contrastPeriod url chartsId jsMethod type=0 typeId="queryType">
	<a href="javascript:;" id="contrastTime" class="btn1 btn_location">对比时段</a>
    <div class="time_locate_box none">
        <p class="dynamic_time mb10">
          <span class="section_days fr"><input type="text" class="days_segment" value="0" readonly>天</span>
          <span class="time_segment">
            <input type="text" class="start_time" size="30" value="2016-05-05" readonly> 至 <input type="text" id="alternate" class="end_time" size="30" value="2016-06-06" readonly>
          </span>
       </p>
       <div id="datepicker"></div>
       <p class="time_segment_tip">
          <a href="javascript:;" class="btn3 segment_close_btn fr">确定</a>
          <span>选择对比时段的终点</span>            
       </p>
    </div>
	
	<input type="hidden" id="contrastStartTime" name="contrastStartTime">
	<input type="hidden" id="contrastEndTime" name="contrastEndTime">
	<script>
		$(function(){
		   closeTimeSectionBox();
			function closeTimeSectionBox(){
		    	$('.segment_close_btn').click(function(event) {
		    		$(this).parents('.time_locate_box').hide();
		    			var contrastEndTime = $("#alternate").val();
						if(check(contrastEndTime)){
							$.ajax({
								url:"${url}",
								type:"post",
								dataType:"json",
								data:
								{
									contrastEndTime:contrastEndTime,
									gameVersion:$("input[name='gameVersion']").val(),
									channelId:$("input[name='channelId']").val(),
									type:$("#${typeId}").val(),
									isContrast:1,
									logTimeSh_begin:$("#logTimeSh_begin").val(),
									logTimeSh_end:$("#logTimeSh_end").val()
								},
								async:false,
								success:function(dataOrg){
									var charts=$("#${chartsId}").highcharts();
									if(charts){
										if(dataOrg.data.length>0){
											var endData=new Array();
											var series = charts.series;
											var seriesLength=series.length;
											var time = dataOrg.time;
											for(i=0;i<seriesLength;i++){
												var data = charts.series[i].yData;
												var name=charts.series[i].name;
												var newData={
													data:data,
													name:name,
													xAxis:i
												}
												endData.push(newData);
											}
											
											var xAxisData = new Array();
											var xAxis = charts.xAxis;
											var oldXAxis;
											$.each(xAxis,function(i,v){
												if(i==0){
													oldXAxis= {
														categories:v.categories
													}
												}else{
													oldXAxis= {
														categories:v.categories,
														labels: {
											                enabled: false
											            },
											            lineWidth:0,
											            tickLength:0
													}
												}
												xAxisData.push(oldXAxis);
											});
											
											var contrastData=dataOrg.data[0].data;
											var contrastName= dataOrg.data[0].name;
											var compareData = {
												data:contrastData,
												name:contrastName,
												xAxis:xAxis.length
											}
											endData.push(compareData);
											var categories2 = {
												categories:time,
												labels: {
									                enabled: false
									            },
									            lineWidth:0,
									            tickLength:0
											}
											xAxisData.push(categories2);
											<#if type==0>
												${jsMethod}(xAxisData,endData,"${chartsId}");
											<#else>
												${jsMethod}(xAxisData,endData,$("#${typeId}").val(),"${chartsId}");
											</#if>
										}
									}
								}
							});
						}else{
							alertWarn('请选择正确的日期！');
						}
		    	});
		    	
    	    	$(document).click(function(){
					if(!$('.time_locate_box').css("display",'none')){
						$(".time_locate_box").slideUp("fast");
					}
				});
				$(window).scroll(function() {
					if(!$('.time_locate_box').css("display",'none')){
						$(".time_locate_box").slideUp("fast");
					}
				});
		    }
		});
		
		function check(date){
		    return (new Date(date).getDate()==date.substring(date.length-2));
		}
	</script>
</#macro>

<#macro exportFile id title gameName chartsId>
	<i id="${id}" title="导出" style="cursor:pointer" class="icon iconfont mr35 color2 fr">&#xe612;</i>
	<script>
		$(function(){
			$("#${id}").on("click",function(){
				exportDataCSV('${chartsId}','${gameName!}','${title}');
			 });
		});
	</script>
</#macro>

<#macro exportFileTable id formId url>
	<i id="${id}" title="导出" style="cursor:pointer" class="icon iconfont mr35 color2 fr">&#xe612;</i>
	<script>
		$(function(){
			$("#${id}").on("click",function(){
				var form=$("#${formId}");
				var action = form.attr("action");
	    		form.attr("action","${url}");
	    		form.submit();
	    		if(action){
					form.attr("action",action);
				}
			 });
		});
	</script>
</#macro>

<#--搜索日期  开始-结束-->
<#macro shDateBeginEnd fieldName shDate=null >
    	<input type="text" class="form-control timectrl twinHasDatepicker" name="${fieldName}.begin" 
    		style="width:120px;" value="<#if shDate??>${(shDate.begin?date)!}</#if>" id="begin_${fieldName?replace(".","_")}" />
	<#nested/>
		<input type="text" class="form-control timectrl twinHasDatepicker" name="${fieldName}.end" 
			style="width:120px;" value="<#if shDate??>${(shDate.end?date)!}</#if>" id="end_${fieldName?replace(".","_")}" />	
</#macro>

