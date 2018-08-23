/* JS */

var debounce = function(func, wait, immediate) {
  var timeout, result;
  return function() {
    var context = this, args = arguments;
    var later = function() {
      timeout = null;
      if (!immediate) result = func.apply(context, args);
    };
    var callNow = immediate && !timeout;
    clearTimeout(timeout);
    timeout = setTimeout(later, wait);
    if (callNow) result = func.apply(context, args);
    return result;
  };
}
/* Navigation */
function pagesize(){
    if($(window).width() >= 765){
      $("body").removeClass("mobilescreen").addClass("bigscreen");
      //$(".sidebar #nav").slideDown(350);
    }
    else{
      $("body").addClass("mobilescreen").removeClass("bigscreen");
      //$(".sidebar #nav").slideUp(350); 
    }
}

function showTooltip(x, y, contents) {
    $('<div id="tooltip">' + contents + '</div>').css( {
        position: 'absolute',
        display: 'none',
        top: y + 5,
        left: x + 5,
        border: '1px solid #ccc',
        padding: '2px 8px',
        color: '#ccc',
        'background-color': '#000',
        opacity: 0.9
    }).appendTo("body").fadeIn(200);
}
    
var TO = false;

var funToReset = null;

$(document).ready(function(){
  pagesize();
  $(window).resize(debounce(pagesize,100));

  $(".content #nav a").on('click',function(e){
//      if($(this).parents(".content:first").hasClass("enlarged")){
//        e.preventDefault();
//        return false;
//      }
      if($(this).parent().hasClass("has_sub")) {
        e.preventDefault();
      }   

      if(!$(this).hasClass("subdrop")) {
        // hide any open menus and remove all other classes
        $("ul",$(this).parents("ul:first")).slideUp(350);
        $("a",$(this).parents("ul:first")).removeClass("subdrop");
        $("#nav .pull-right i").removeClass("fa-chevron-down").addClass("fa-chevron-left");
        
        // open our new menu and add the open class
        $(this).next("ul").slideDown(350);
        $(this).addClass("subdrop");
        $(".pull-right i",$(this).parents(".has_sub:last")).removeClass("fa-chevron-left").addClass("fa-chevron-down");
        $(".pull-right i",$(this).siblings("ul")).removeClass("fa-chevron-down").addClass("fa-chevron-left");
      }else if($(this).hasClass("subdrop")) {
        $(this).removeClass("subdrop");
        $(this).next("ul").slideUp(350);
        $(".pull-right i",$(this).parent()).removeClass("fa-chevron-down").addClass("fa-chevron-left");
        //$(".pull-right i",$(this).parents("ul:eq(1)")).removeClass("fa-chevron-down").addClass("fa-chevron-left");
      } 
  });
  $("#nav > li.has_sub > a.open").addClass("subdrop").next("ul").show();
  

  
  $(".menubutton").click(function(){
      if(!$(".content").hasClass("enlarged")){
          $("#nav .has_sub ul").removeAttr("style");
          $("#nav .has_sub .pull-right i").removeClass("fa-chevron-left").addClass("fa-chevron-down");
          $("#nav ul .has_sub .pull-right i").removeClass("fa-chevron-down").addClass("fa-chevron-right");
          $(".content").addClass("enlarged");
      }else{
          $("#nav .has_sub .pull-right i").addClass("fa-chevron-left").removeClass("fa-chevron-down").removeClass("fa-chevron-right");
          $(".content").removeClass("enlarged");
      }
      
      funToReset();
  });
  
  $(".sidebar-dropdown a").on('click',function(e){
      e.preventDefault();

      if(!$(this).hasClass("open")) {
        // hide any open menus and remove all other classes
        $(".sidebar #nav").slideUp(350);
        $(".sidebar-dropdown a").removeClass("open");
        
        // open our new menu and add the open class
        $(".sidebar #nav").slideDown(350);
        $(this).addClass("open");
      }
      
      else if($(this).hasClass("open")) {
        $(this).removeClass("open");
        $(".sidebar #nav").slideUp(350);
      }
  });
  $('.sscroll').slimScroll({wheelStep: 1,opacity:0.3});
//  $(".slimScrollBar").hide();

  //BY zhangyu
  //setTimeout(autoTable,1000);
  autoScroll()
  autoTable();
});

/* Widget close */

$('.wclose').click(function(e){
  e.preventDefault();
  var $wbox = $(this).parent().parent().parent();
  $wbox.hide(100);
});

/* Widget minimize */

  $('.wminimize').click(function(e){
    e.preventDefault();
    var $wcontent = $(this).parent().parent().next('.widget-content');
    if($wcontent.is(':visible')) 
    {
      $(this).children('i').removeClass('icon-chevron-up');
      $(this).children('i').addClass('icon-chevron-down');
    }
    else 
    {
      $(this).children('i').removeClass('icon-chevron-down');
      $(this).children('i').addClass('icon-chevron-up');
    }            
    $wcontent.slideToggle(300);
  }); 

/* Calendar */

  $(document).ready(function() {
  
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    
    $('#calendar').fullCalendar({
      header: {
        left: 'prev',
        center: 'title',
        right: 'month,agendaWeek,agendaDay,next'
      },
      editable: true,
      events: [
        {
          title: 'All Day Event',
          start: new Date(y, m, 1)
        },
        {
          title: 'Long Event',
          start: new Date(y, m, d-5),
          end: new Date(y, m, d-2)
        },
        {
          id: 999,
          title: 'Repeating Event',
          start: new Date(y, m, d-3, 16, 0),
          allDay: false
        },
        {
          id: 999,
          title: 'Repeating Event',
          start: new Date(y, m, d+4, 16, 0),
          allDay: false
        },
        {
          title: 'Meeting',
          start: new Date(y, m, d, 10, 30),
          allDay: false
        },
        {
          title: 'Lunch',
          start: new Date(y, m, d, 12, 0),
          end: new Date(y, m, d, 14, 0),
          allDay: false
        },
        {
          title: 'Birthday Party',
          start: new Date(y, m, d+1, 19, 0),
          end: new Date(y, m, d+1, 22, 30),
          allDay: false
        },
        {
          title: 'Click for Google',
          start: new Date(y, m, 28),
          end: new Date(y, m, 29),
          url: 'http://google.com/'
        }
      ]
    });
    
  });

/* Progressbar animation */

    setTimeout(function(){

        $('.progress-animated .progress-bar').each(function() {
            var me = $(this);
            var perc = me.attr("data-percentage");

            //TODO: left and right text handling

            var current_perc = 0;

            var progress = setInterval(function() {
                if (current_perc>=perc) {
                    clearInterval(progress);
                } else {
                    current_perc +=1;
                    me.css('width', (current_perc)+'%');
                }

                me.text((current_perc)+'%');

            }, 600);

        });

    },600);

/* Slider */

    $(function() {
        // Horizontal slider
        $( "#master1, #master2" ).slider({
            value: 60,
            orientation: "horizontal",
            range: "min",
            animate: true
        });

        $( "#master4, #master3" ).slider({
            value: 80,
            orientation: "horizontal",
            range: "min",
            animate: true
        });        

        $("#master5, #master6").slider({
            range: true,
            min: 0,
            max: 400,
            values: [ 75, 200 ],
            slide: function( event, ui ) {
                $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
            }
        });


        // Vertical slider 
        $( "#eq > span" ).each(function() {
            // read initial values from markup and remove that
            var value = parseInt( $( this ).text(), 10 );
            $( this ).empty().slider({
                value: value,
                range: "min",
                animate: true,
                orientation: "vertical"
            });
        });
    });

/* Support */

$(document).ready(function(){
  $("#slist a").click(function(e){
     e.preventDefault();
     $(this).next('p').toggle(200);
  });

  $( ".portlets" ).sortable({
      connectWith: ".portlets",
      handle: ".widget-head",
      opacity: 0.5,
      dropOnEmpty: true,
      forcePlaceholderSize: true
  });
});

/* Scroll to Top */


  $(".totop").hide();

  $(function(){
    $(window).scroll(function(){
      if ($(this).scrollTop()>300)
      {
        $('.totop').slideDown();
      } 
      else
      {
        $('.totop').slideUp();
      }
    });

    $('.totop a').click(function (e) {
      e.preventDefault();
      $('body,html').animate({scrollTop: 0}, 500);
    });

  });

/* jQuery Notification */

$(document).ready(function(){

  //setTimeout(function() {noty({text: '<strong>Howdy! Hope you are doing good...</strong>',layout:'topRight',type:'information',timeout:15000});}, 7000);

  //setTimeout(function() {noty({text: 'This is an error message! It took your attention, right?',layout:'topRight',type:'error',timeout:13000});}, 9000);

  $('.noty-alert').click(function (e) {
      e.preventDefault();
      noty({text: 'Some notifications goes here...',layout:'topRight',type:'alert',timeout:2000});
  });

  $('.noty-success').click(function (e) {
      e.preventDefault();
      noty({text: 'Some notifications goes here...',layout:'topRight',type:'success',timeout:2000});
  });

  $('.noty-error').click(function (e) {
      e.preventDefault();
      noty({text: 'Some notifications goes here...',layout:'topRight',type:'error',timeout:2000});
  });

  $('.noty-warning').click(function (e) {
      e.preventDefault();
      noty({text: 'Some notifications goes here...',layout:'bottom',type:'warning',timeout:2000});
  });

  $('.noty-information').click(function (e) {
      e.preventDefault();
      noty({text: 'Some notifications goes here...',layout:'topRight',type:'information',timeout:2000});
  });

});


/* Date picker */

  $(function() {
    $('.datepicker').datetimepicker({
      pickTime: false
    });
  });

   $(function() {
    $('.timepicker').datetimepicker({
      pickDate: false
    });
  });
   $(function() {
    $('.datetimepicker1').datetimepicker({
       pickTime: false
     });
   });
   $(function() {
     $('.datetimepicker2').datetimepicker({
         pickDate: false
     });
   });
   
   $(".hideit").click(function() {
		$(this).fadeTo(200, 0.00, function(){ //fade
			$(this).slideUp(300, function() { //slide up
				$(this).remove(); //then remove from the DOM
			});
		});
	});	




/* CL Editor */

$(".cleditor").cleditor({
    width: "auto",
    height: "auto"
});

/* Modal fix */

$('.modal').appendTo($('body'));

/* Pretty Photo for Gallery*/

jQuery("a[class^='prettyPhoto']").prettyPhoto({
overlay_gallery: false, social_tools: false
});
//移动端重置滚动条
function autoScroll(){
	if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){ 
	     $(".autoTbody").addClass('autoTbodyMobile');
		};
	};
function autoTable() {
	//添加滚动条
	$(".autoTbody").addClass('autoTbodyExtra');
	// 表格固定表头和高度设置
	// 变量初始化
	var headerDivWidth = 0, _tableHeight = 0, _th = null;
	// 计算表头的高度
	var _headerHeight = $(".autoHeader").outerHeight();
	//竖直滚动条的宽度
	var _scrollWidth=0;
	//对齐每个TD与TH
	function thWidth() {
		_th = $(".autoHeader").find('table thead:first th');
		$('.autoTbody table tbody tr:first td').each(function(index) {
			$(this).outerWidth(_th.eq(index).outerWidth());
		});
	};
	// 设置mainbar的高度  
	function conHeight() {
		var _docHeight = $(document.body).outerHeight();
		var _winHeight = $(window).outerHeight();
		var _navHeight = $('.navbar').outerHeight();
		var _mainHeight= _winHeight - _navHeight - 0;
		if ($(".autoHeader").length == 0) {
			if (_docHeight < _winHeight) {
				$('.mainbar').outerHeight(_mainHeight);
			}
			return;
		}
		
		//补齐空白
		$('.autoTbody').css({
			marginTop : -_headerHeight + 1,
			paddingTop: _headerHeight
		});
		//超过屏幕限制高度
		if (_docHeight >= _winHeight) {
			_tableHeight = _winHeight - $(".autoHeader").offset().top - $(".autoHeader").outerHeight();
			$('.autoTbody').css('maxHeight', _tableHeight);
		} else {
			//内容再扩容
			if (($('.autoTbody')[0].scrollHeight - _headerHeight) > $('.autoTbody').outerHeight()) {
				_tableHeight = _winHeight - $(".autoHeader").offset().top - $(".autoHeader").outerHeight();
				$('.autoTbody').css('maxHeight', _tableHeight);
			}
		}
		//主高度
		$('.mainbar').outerHeight(_mainHeight);
	};
	// 移动端滚动条自定义样式
    function setActiveStyleSheet(){
	    if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){ 
			 _scrollWidth=8;	
		}else{
            _scrollWidth=17;
		};
	};
	// 滚动条处理
	function autoBar() {
		if ($(".autoHeader").length == 0) {
			return;
		}
		var _maxHeight = $(".autoTbody")[0].scrollHeight - _headerHeight;
		var _heiTables = $(".autoTbody").outerHeight();
		if (_maxHeight > _heiTables) {
			setActiveStyleSheet();
			headerDivWidth = $(".autoTbody").width() - _scrollWidth;
			$(".autoHeader").css("width", headerDivWidth);
		} else {
			headerDivWidth = $(".autoTbody").width();
			$(".autoHeader").css("width", headerDivWidth);
		}
		console.log(headerDivWidth);
		console.log($(".autoHeader").width());
		
	}
	//重置菜单高度
	function menuResize() {
		var _height = $('.navbar').height();
		$('body').css('padding-top', _height - 2);
	}
	
	funToReset = function(){
		menuResize();
		autoBar();
		thWidth();
		conHeight();
		autoBar();
		thWidth();
	};

	// 重置操作
	$(window).resize(function() {
		funToReset();
	});
	
	funToReset();
	
	// 左右滚动同步表格thead和tbody
	$(".autoTbody").scroll(function() {
		$(".autoHeader").scrollLeft(this.scrollLeft);
	});
}



function fullTxtTip(msg){
	layer.msg(
			msg,
			{
			    time: 0,
			    shift:0,
			    closeBtn : 2,
			    title:"详细信息"
			    
			}
	);
}
