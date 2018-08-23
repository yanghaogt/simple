/**       
		 * 对Date的扩展，将 Date 转化为指定格式的String       
		 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符       
		 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)       
		 * eg:       
		 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423       
		 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04       
		 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04       
		 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04       
		 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18       
		 */          
		Date.prototype.pattern=function(fmt) {           
		    var o = {           
		    "M+" : this.getMonth()+1, //月份           
		    "d+" : this.getDate(), //日           
		    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时           
		    "H+" : this.getHours(), //小时           
		    "m+" : this.getMinutes(), //分           
		    "s+" : this.getSeconds(), //秒           
		    "q+" : Math.floor((this.getMonth()+3)/3), //季度           
		    "S" : this.getMilliseconds() //毫秒           
		    };           
		    var week = {           
		    "0" : "/u65e5",           
		    "1" : "/u4e00",           
		    "2" : "/u4e8c",           
		    "3" : "/u4e09",           
		    "4" : "/u56db",           
		    "5" : "/u4e94",           
		    "6" : "/u516d"          
		    };           
		    if(/(y+)/.test(fmt)){           
		        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));           
		    }           
		    if(/(E+)/.test(fmt)){           
		        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);           
		    }           
		    for(var k in o){           
		        if(new RegExp("("+ k +")").test(fmt)){           
		            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));           
		        }           
		    }           
		    return fmt;           
		}    
		
		 //dayNumber需要添加的天数，date日期，没传则用当前日期
        function addDay(dayNumber, date) {
	        date = date ? date : new Date();
	        var ms = dayNumber * (1000 * 60 * 60 * 24)
	        var newDate = new Date(date.getTime() + ms);
	        return newDate;
	    }
        
        function queryType_common(type,obj,func,formId){
        	var o = $(obj);
    		o.parent().siblings("li").removeClass("on");
    		o.parent().addClass("on");
			var date= addDay(type).pattern("yyyy-MM-dd");
			if(formId){
				$("#"+formId+" input[name='logTimeSh.begin']").val(date);
				$("#"+formId+" input[name='logTimeSh.end']").val(new Date().pattern("yyyy-MM-dd"));
			}else{
				$("input[name='logTimeSh.begin']").val(date);
				$("input[name='logTimeSh.end']").val(new Date().pattern("yyyy-MM-dd"));
			}
				
			if(func){
				eval(func)();
			}else{
				$("#dateType").val(type);
				$("form[name='defaultForm']").submit();
			}
        }
        
        function queryType_common_One(day,obj,func,formId){
        	var o = $(obj);
    		o.parent().siblings("li").removeClass("on");
    		o.parent().addClass("on");
			var date= addDay(day).pattern("yyyy-MM-dd");
			if(formId){
				$("#"+formId+" input[name='logTimeSh.begin']").val(date);
				$("#"+formId+" input[name='logTimeSh.end']").val(date);
			}else{
				$("input[name='logTimeSh.begin']").val(date);
				$("input[name='logTimeSh.end']").val(date);
			}
				
			if(func){
				eval(func)();
			}else{
				$("#dateType").val(day);
				$("form[name='defaultForm']").submit();
			}
        }
        
        /**
         * 获取两个日期相差多少天
         */
        function diffDateDay(beginDate,endDate){
        	var diffTime = new Date(endDate.getTime()-beginDate.getTime());
        	var day = parseInt(diffTime/(1000*60*60*24));
        	return day;
        }
        
        /**
         * 改变日期时重新设置日月周
         */
        function changeDateSetDateType(dateTypeId){
        	var logtimeBegin=$("#logTimeSh_begin").val();
        	var logtimeEnd=$("#logTimeSh_end").val();
        	var dateType=$("#"+dateTypeId).val();
        	if(logtimeBegin||logtimeEnd){
        		logTimeBegin_time=new Date(logtimeBegin);
            	logTimeEnd_time=new Date(logtimeEnd);
            	var diffDay = diffDateDay(logTimeBegin_time,logTimeEnd_time);
            	if(diffDay>=7&&diffDay<30){
            		if(dateType=="month"){
    					$("#"+dateTypeId).val("week");
    				}
    			}else if(diffDay>=30){
    				
    			}else {
    				if(dateType=="week"||dateType=="month"){
    					$("#"+dateTypeId).val("day");
    				}
    			}
            	
        	}
        }
        
        function dayWeekMonthSearch(dateType,func,dateTypeId){
        	$("#"+dateTypeId).val(dateType);
			if(func){
				eval(func)();
			}else{
				$("form[name='defaultForm']").submit();
			}
		}
		
		 /**
         * 通用数据导出
         * @param chartId
         * @param game 游戏名称
         * @param title	图表标题
         */
        function exportDataCSV(chartId,game,title){
        	var name = game+ "_" +title;
    		var chart = $('#'+chartId).highcharts();
        	var csvStr=getSearch();//获取搜索条件
        	csvStr+= chart.getCSV();
        	csvStr=csvStr.replace(/\r\n/g,";")  
            csvStr=csvStr.replace(/\n/g,";");  
        	csvStr = csvStr.replace(/\"/g, "");
    		location.href=GLBConfig.homeUrl+"/data/exportcsv?name="+name+"&csv="+csvStr;
        }
        
        function getSearch(){
        	var gameKindSelect=$("#changeGame").find("option:selected").text();
        	var gameVersion=$("input[name='gameVersion']").val()||"--";
        	var channelId=$("input[name='channelId']").val()||"--";
        	var beginDate=$("#logTimeSh_begin").val();
        	var endDate=$("#logTimeSh_end").val();
        	if(!beginDate){
        		beginDate=$("#logTimeSh_begin2").val();
        		endDate=$("#logTimeSh_end2").val();
        		if(!beginDate){
        			beginDate=$("#logTimeShDay_begin2").val();
        			endDate=beginDate;
        		}
        		if(!beginDate){
        			beginDate=new Date().pattern("yyyy-MM-dd");
        			endDate=beginDate;
        		}
        	}
        	var searchValue="游戏:"+gameKindSelect+",版本："+gameVersion+",渠道："+channelId+",开始时间："+beginDate+",结束时间："+endDate+";";
        	return searchValue;
        }
        
        /**
         * 日月周搜索
         * @param dwm_dateType 隐藏域id
         * @param dwm_dateType2 table页面的隐藏域id
         * @param ulId ul的id
         * @param jsMethod 自定义的js方法名称
         */
        function dwmSearch(dwm_dateType,dwm_dateType2,ulId,jsMethod){
			var dateType =$("#"+dwm_dateType2).val();
		    var click_status=$("#"+dwm_dateType).val();
		    console.log("click_status:"+click_status);
		    if(click_status==""){
		    	isSelected_day="selected";
		    }
		    var html='';
		    
		    var isSelected_day, isSelected_week,isSelected_month;
		    if(click_status=="day"){
		    	isSelected_day="selected";
		    }
		    html+='<li class="up '+isSelected_day+'" ><a href="javascript:;" onclick="javascript:dayWeekMonthSearch('+"'day'"+','+"'"+jsMethod+"'"+','+"'"+dwm_dateType+"'"+')">日</a></li>';
		    if(dateType=="week"){
		    	if(click_status=="week"){
		    		isSelected_week="selected";
		    	}
		    	html+='<li class="up '+isSelected_week+'"><a href="javascript:;" onclick="javascript:dayWeekMonthSearch('+"'week'"+','+"'"+jsMethod+"'"+','+"'"+dwm_dateType+"'"+')">周</a></li>';
		    	html+='<li><a>月</a></li>';
		    }else if(dateType=="month"){
		    	if(click_status=="week"){
		    		isSelected_week="selected";
		    	}
		    	html+='<li class="up '+isSelected_week+'"><a href="javascript:;" onclick="javascript:dayWeekMonthSearch('+"'week'"+','+"'"+jsMethod+"'"+','+"'"+dwm_dateType+"'"+')">周</a></li>';
		    	if(click_status=="month"){
		    		 isSelected_month="selected";
		    	}
		    	html+='<li class="up '+isSelected_month+'"><a href="javascript:;" onclick="javascript:dayWeekMonthSearch('+"'month'"+','+"'"+jsMethod+"'"+','+"'"+dwm_dateType+"'"+')">月</a></li>';
		    }else{
		    	html+='<li><a>周</a></li>';
		    	html+='<li><a>月</a></li>';
		    }
		    $("#"+ulId).html(html);
		}
        
