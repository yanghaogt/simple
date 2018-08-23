/*
* @Author: zhangyu
* @Date:   2016-04-19 17:11:49
* @Last Modified by:   zhangyu
* @Last Modified time: 2016-06-20 16:17:02
*/

'use strict';
$(function(){
   pageFrame();//页面框架	
});

function pageFrame(){
// header 小视口主菜单
	$('.menu_all').click(function() {
		$(this).siblings('.menu_cons').toggle();	
	});	
	// 20151225 S
	$('.menu_cons a').click(function() {
		$(this).parent('.menu_cons').hide();	
	});	
  // 侧边菜单
	$(".one_menu_list .one_menu").click(function() {
		if (!$(this).hasClass('on')) {
			$('.inner_menu').hide();
			$(this).addClass('on').siblings().removeClass('on')
			$(this).next('.inner_menu').slideToggle();//管理侧边栏二级菜单
		}
		});
	$(".one_menu_list>li.one_menu").click(function() {	
			$(this).siblings('.inner_menu').find('li').removeClass('on');	
		});
	  
	// 三级菜单
	$(".inner_menu li").click(function(){
		var _this = $(this);		
		_this.addClass('on').siblings().removeClass('on');
	  	_this.parents('.inner_menu').siblings(".one_menu_list>li").not('.one_menu_list>li:last').removeClass('on');
	 	_this.parents('.inner_menu').prev('.one_menu_list>li:last').addClass('on');
	});
    // 菜单
	window.onresize = function(){
	var _width = $(window).width(); 
     if(_width > 768){
        $(".examine_head .menu_cons").hide();
     }
    };

}