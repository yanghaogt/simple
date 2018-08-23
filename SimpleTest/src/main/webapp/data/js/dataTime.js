
/*
* @Author: zhangyu
* @Date:   2016-05-30 13:35:43
* @Last Modified by:   zhangyu
* @Last Modified time: 2016-06-22 14:16:46
*/
'use strict';
$(function(){
       // 时间选择组件初始化 自选时间
//        var dateRange1 = new pickerDateRange('date1', {
//          aToday : 'aToday',// 今天
//          aRecent7Days : 'aRecent7Days',// 最近七天
//          aRecent30Days : 'aRecent30Days',//最近30天
//          aRecent60Days : 'aRecent60Days',//最近60天
//          isTodayValid : true,
//          startDate : '2016-03-14',
//          endDate : '2016-05-10',
//          needCompare : false,
//          defaultText : ' 至 ',
//          inputTrigger : 'input_trigger1',
//          theme : 'ta',
//          success : function(obj) {
//            $("#dCon2").html('开始时间 : ' + obj.startDate + '<br/>结束时间 : ' + obj.endDate);
//            $('#date1').focus();//日历生成
//            $('.ta_calendar').hide();//日历生成后默认隐藏
//          }
//        }); 
        $('.data_time_sel').on('click',function(e){//选择时间弹窗显示隐藏，宽度设定，定位
          $('.ta_calendar').hide();
          $('.chart_menu_alert').hide();
          var _left=$(this).offset().left;
          var _top=$(this).offset().top;
          var _width=$(this).parents('.time_ganged').outerWidth();
          $(this).parents('.time_ganged').find('.chart_menu_alert').outerWidth(_width).slideToggle().offset({left:_left,top:_top+40});
           optionalTimeAlert();
        });

      });
      function optionalTimeAlert(){//显示日历
        $('.optionalTimeBtn').on('click',function(){
           $('.ta_calendar').show();
        });
      }