/*
* @Author: zhangyu
* @Date:   2016-05-24 18:53:24
* @Last Modified by:   zhangyu
* @Last Modified time: 2016-06-20 16:59:07
*/
'use strict';
$(function(){
  btnSelect();//按钮模拟下拉列表
  //tipAlert();//提示说明
  compareTime();
});
function btnSelect(){//按钮模拟下拉列表
	function hideAlert(){//隐藏弹窗
		if($('.chart_menu_alert').is(':visible')){
		  $('.chart_menu_alert').hide();
	    }
	}
	$(document).click(function() {//页面内容点击，隐藏弹窗
		hideAlert();
	});
	$(window).scroll(function() {//页面滚动，隐藏弹窗
		hideAlert();
	});		
	$('.btn_set>ul>li').click(function(event) {//弹窗弹出，宽度设定，定位
	    event.stopPropagation();
		    $('.chart_menu_alert').slideUp('fast');
		    var _txt=$(this).children('.default_sel').text();
		    var _left=$(this).offset().left;
		    var _top=$(this).offset().top;
		    var _width=$(this).parents('.btn_set').outerWidth();
		    $(this).addClass('on').siblings().removeClass('on');
		    $(this).find('.chart_menu_alert').outerWidth(_width).slideDown('fast').offset({left:_left,top:_top+40});
			$('.chart_menu_alert>ul>li').click(function(event) {//弹窗列表选项点击传值事件
				event.stopPropagation();
				var _val=$(this).text();
				$(this).addClass('on').siblings().removeClass('on');		
				if($(this).hasClass('all')){
					$(this).parents('.chart_menu_alert').siblings('.btn_set>ul>li>a').text(_txt).parent('.btn_set>ul>li').removeClass('on');//默认选项
				    $(this).parents('.chart_menu_alert').siblings('.btn_set>ul>li>input').val("--");
				}else{
					 $(this).parents('.chart_menu_alert').siblings('.btn_set>ul>li>a').text(_val).parent('.btn_set>ul>li').removeClass('on');//其他传值选项
				    $(this).parents('.chart_menu_alert').siblings('.btn_set>ul>li>input').val(_val);
			    }
			    resizeWidth($(this));
			});	    		
	 });
	function resizeWidth(obj){//点击选项弹窗宽度设定，定位
		    var _left=obj.parents('.btn_set>ul>li').offset().left;
	        var _top=obj.parents('.btn_set>ul>li').offset().top;
	        var _width=obj.parents('.btn_set').outerWidth();			
			obj.parents('.chart_menu_alert').outerWidth(_width).offset({left:_left,top:_top+40});
		};
	$('.chart_alert_confirm').click(function(event) {//弹窗按钮收起
		event.stopPropagation();
		var _this=$(this);
		_this.parents('.chart_menu_alert').slideUp('fast');
		var _txt=_this.parents('.chart_menu_alert').siblings('.btn_set>ul>li>a').text();
		var _val=_this.parents('.chart_menu_alert').siblings('.default_sel').text();
		if (_txt!=_val) {
			_this.parents('.btn_set>ul>li').addClass('on');
		}
		var method=$(this).data("method");
		if(method==1){
			$("form[name='defaultForm']").submit();
		}else if(method==2){
		}else{
			eval(method)();
		}
	});

}
function tipAlert(){//提示说明
	$('.tips_icon').hover(function() {
        var that = this;
            $('.data_tips .highlight').css('color', '#4BD8DF');
            layer.tips($('#tip_1').html(), that,{
              tips: [4, '#666'],
              area: ['500px'],
               shift :5            
            }); //在元素的事件回调体中，follow直接赋予this即可
    }, function() {
        //layer.close(layer.tips()); 
    });
}


function compareTime(){
	$('.btn_location').click(function(event) {
		event.stopPropagation();
        var _this=$(this);     
        var startTime=$('#startDate').val();//获取开始时间段的结束日期
        var endTime=$('#endDate').val();//获取对比时间段的结束日期
        var sectionDays= _this.next('.time_locate_box').find('.days_segment');
            _this.next('.time_locate_box').show('fast');//显示对比时段的弹窗
            _this.next('.time_locate_box').find('.start_time').val(startTime);//对比日期的初始日期
            _this.next('.time_locate_box').find('.end_time').val(endTime);//对比日期的结束日期
            $('#datepicker').datepicker({ 
            	dateFormat:'yy-mm-dd',
	           altField: '#alternate',
	           altFormat: 'yy-mm-dd',
	           maxDate :'0',
	           defaultDate:endTime,
            	onSelect: function(dateText, inst) { timeValChange($('.end_time'))} 
            });
            daysSection(startTime,endTime,sectionDays);//计算日期差 
        });
	    function daysSection(startTime,endTime,sectionDays){//计算日期差
            if (startTime == "" || endTime == "") {
                 sectionDays.val(0);
	        }
	        else {
	            var startNum = parseInt(startTime.replace(/-/g, ''), 10);
	            var endNum = parseInt(endTime.replace(/-/g, ''), 10);
	            if (startNum > endNum) {
	                alert("结束时间不能在开始时间之前！");
	            }
	            else {
	                sectionDays.val(dateDiff(startTime, endTime)+1);  //调用/计算两个日期天数差的函数，通用
	            }
	        }
        }
                
        function dateDiff(sDate1, sDate2) {  //sDate1和sDate2是yyyy-MM-dd格式
		    var aDate, oDate1, oDate2, iDays;
		    aDate = sDate1.split("-");
		    oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);  //转换为yyyy-MM-dd格式
		    aDate = sDate2.split("-");
		    oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
		    iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数
		    return iDays;  //返回相差天数
		}
			
	function timeValChange(_this){//根据结束时间和相差天数计算开始时间
    	var inputNum=_this.parents('.dynamic_time').find('.days_segment').val();
    	var strStartTime=_this.val();
    	if (strStartTime != "") {
        }
        _this.siblings('.start_time').val(addByTransDate(strStartTime, inputNum-1));  //根据指定的一个日期和相差的天数，获取另外一个日期
	}
	function addByTransDate(dateParameter, num) {
	    var translateDate = "", dateString = "", monthString = "", dayString = "";
	    translateDate = dateParameter.replace("-", "/");
	 
	    var newDate = new Date(translateDate);
	    newDate = newDate.valueOf();
	    newDate = newDate - num * 24 * 60 * 60 * 1000;  //备注 如果是往前计算日期则为减号 否则为加号
	    newDate = new Date(newDate);
	 
	    //如果月份长度少于2，则前加 0 补位   
	    if ((newDate.getMonth() + 1).toString().length == 1) {
	        monthString = 0 + "" + (newDate.getMonth() + 1).toString();
	    } else {
	        monthString = (newDate.getMonth() + 1).toString();
	    }
	 
	    //如果天数长度少于2，则前加 0 补位   
	    if (newDate.getDate().toString().length == 1) {
	 
	        dayString = 0 + "" + newDate.getDate().toString();
	    } else {
	 
	        dayString = newDate.getDate().toString();
	    }
	    dateString = newDate.getFullYear() + "-" + monthString + "-" + dayString;
	    return dateString;
    }
}