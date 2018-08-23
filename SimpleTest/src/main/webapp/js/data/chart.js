/*
* @Author: zhangyu
* @Date:   2016-05-16 13:27:12
* @Last Modified by:   zhangyu
* @Last Modified time: 2016-05-18 17:27:39
*/

'use strict';
//$(function () {
//    chart1();
//    chart2();
//    chart3();
//    chart4();
//    chart5();
//    chart6();
//    chart7();
//    chart8();
//    chart9();
//});
function chart1(){
	$('#container1').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: null
        },
        exporting:'null',
        xAxis: {
            categories: ["00:00", "03:15", "06:30", "09:45", "13:00", "16:15", "19:30", "22:45"]        
        },
        yAxis: {
            title:{
               text:null
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        credits:{
             enabled:false // 禁用版权信息
        },
        series: [{
            name: '今日',
            data: [0, 100, 200, 300, 350,200, 320, 300]
        }, {
            name: '昨日',
            data: [300.9, 304.2, 125.7, 138.5, 211.9, 315.2, 217.0, 216.6]
        }, {
            name: '7天前',
            data: [200.9, 300.2, 324.7, 136.5, 239.9, 210.2, 212.0, 315.6]
        }
         ]
    });
};
function chart2(){
	$('#container2').highcharts({ 
        chart: {
            type: 'line'
        }, 
        title: {
            text: null
        },
        exporting:'null',
        xAxis: {
            categories: ["00:00", "03:15", "06:30", "09:45", "13:00", "16:15", "19:30", "22:45"]
        },
        yAxis: {
            title:{
               text:null
            },
            labels: {
                 formatter:function(){                     
                        return +this.value+"k";              
                    }
              }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        credits:{
             enabled:false // 禁用版权信息
        },
        series: [{
            name: '活跃用户',
            data: [0, 100, 200, 300, 350,200, 320, 300]
        }]
    });
};
function chart3(){
$('#container3').highcharts({       
        chart: {
            type: 'column'
        },
        title: {
            text: null
        },
        exporting:'null',
        xAxis: {
            type: 'category',
            labels: {
                rotation: 0,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title:{
               text:null
            },
            labels: {
                 formatter:function(){                     
                        return +this.value+"k";              
                    }
              }
        },
        tooltip: {
            pointFormat: '<b>{point.y:.1f}</b>'
        },
        credits:{
             enabled:false // 禁用版权信息
        },
        series: [{
            name: '2016-04-12至2016-04-18',
            data: [
            ['首日',355],
            ['2日',355],
            ['3日',355],
            ['4-7日',355],
            ['2周',355],
            ['3周',355],
            ['4周',355],
            ['5周',355]
            ]
        }]
    });
};
function chart4(){
$('#container4').highcharts({
        title: {
            text: null
        },
        exporting:'null',
        xAxis: {
            min: 0,
            categories: ['11-21', '11-41', '11-51', '11-61', '11-71','11-71']
        },
        yAxis: {
            min: 0,
            title:{
               text:null
            },
            labels: {
                 formatter:function(){                     
                        return +this.value+"点";              
                    }
              }
        },
        tooltip: {
            pointFormat: '<b>0000-00-00 {point.key} 星期几 {point.y}点</b>'
        },
        credits:{
             enabled:false // 禁用版权信息
        },
        series: [{
            type: 'scatter',
            name: '01-14至04-21活动峰值',
            data: [2.0,3.0, 2.8, 3.5, 3.9, 4.2],
            marker: {
                radius: 4
            }
        }]
    });
};
function chart5(){
$('#container5').highcharts({
        chart: {
            type: 'bar'
        },
        title: {
            text: null
        },
        exporting:'null',
        xAxis: {
            categories: ['Africa', 'America', 'Asia', 'Europe', 'Oceania'],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: null
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' millions'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        },        
        credits: {
            enabled: false
        },       
        series: [{
            name: '2016-04-12至2016-04-18',
            data: [107, 31, 635, 203, 2]
        }]
    });

};
function chart6(){
	$('#container6').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: null
	        },
	        exporting:'null',
	        xAxis: {
	            categories: ['Apples', 'Oranges', 'Pears', 'Grapes', 'Bananas']
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: null
	            }
	        },
	        legend: {
	            reversed: true
	        },
	        plotOptions: {
	            series: {
	                stacking: 'normal'
	            }
	        },
	        credits:{
	             enabled:false // 禁用版权信息
	        },
	        series: [{
	            name: 'John',
	            data: [5, 3, 4, 7, 2],
	            color:'#fdd267'
	        }, {
	            name: 'Jane',
	            data: [2, 2, 3, 2, 1],
	            color:'#f8b15a'
	        }, {
	            name: 'Joe',
	            data: [3, 4, 4, 2, 5],
	            color:'#f59043'
	        }, {
	            name: 'nn',
	            data: [3, 4, 4, 2, 5],
	            color:'#ef6f36'
	        }, {
	            name: 'mmm',
	            data: [3, 4, 4, 2, 5],
	            color:'#de4427'
	        }, {
	            name: 'jjj',
	            data: [3, 4, 4, 2, 5],
	            color:'#cf3737'
	        }]
	    });
	};
function chart7(){
$('#container7').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: null
        },
        exporting:'null',
        xAxis: {
            categories: ['Apples', 'Oranges', 'Pears', 'Grapes', 'Bananas']
        },
        yAxis: {
            min: 0,
            title: {
                text: null
            }
        },
        legend: {
            reversed: true
        },
        plotOptions: {
            series: {
                stacking: 'normal'
            }
        },
        credits:{
             enabled:false // 禁用版权信息
        },
        series: [{
            name: 'John',
            data: [5, 3, 4, 7, 2],
            color:'#7ec8e6'
        }, {
            name: 'Jane',
            data: [2, 2, 3, 2, 1],
            color:'#72d2df'
        }, {
            name: 'vvv',
            data: [3, 4, 4, 2, 5],
            color:'#5ed9d9'
        }, {
            name: 'bbb',
            data: [3, 4, 4, 2, 5],
            color:'#52d2c2'
        }, {
            name: 'nnn',
            data: [3, 4, 4, 2, 5],
            color:'#50c6a5'
        }, {
            name: 'mmm',
            data: [3, 4, 4, 2, 5],
            color:'#4eb789'
        }]
    });
};

function chart8(){
 $('#container8').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 0,
            plotShadow: false,
        },
        title: {
            text: null
        },
        exporting:'null',
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        legend: {
            reversed: true
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                },
                showInLegend: true
            }
        },
        credits:{
             enabled:false // 禁用版权信息
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            innerSize: '50%',
            colorByPoint: true,
            data: [{
                name: 'Microsoft Internet Explorer',
                y: 56.33
            }, {
                name: 'Chrome',
                y: 24.03,
            }, {
                name: 'Firefox',
                y: 10.38
            }, {
                name: 'Safari',
                y: 4.77
            }, {
                name: 'Opera',
                y: 0.91
            }, {
                name: 'Proprietary or Undetectable',
                y: 0.2
            }]
        }]
    });
};
function chart9(){
$('#container9').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 0,
            plotShadow: false,
        },
        title: {
            text: null
        },
        exporting:'null',
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                },
                showInLegend: true
            }
        },
        credits:{
             enabled:false // 禁用版权信息
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            innerSize: '50%',
            colorByPoint: true,
            data: [{
                name: 'Microsoft Internet Explorer',
                y: 4
            }, {
                name: 'Chrome',
                y: 2,
            }, {
                name: 'Firefox',
                y: 1
            }, {
                name: 'Safari',
                y: 1
            }, {
                name: 'Opera',
                y: 1
            }, {
                name: 'Proprietary or Undetectable',
                y: 1
            }]
        }]
    });
};
function chart10(formId){
    $('#'+formId).highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: null
        },
        exporting:'null',
        xAxis: [{
            categories: ['05-01', '05-02', '05-03', '05-04', '05-05', '05-06','05-07', '05-08', '05-09', '05-10', '05-11', '05-12']
        }],
        yAxis: [{ // 新增用户 yAxis
        	title:null,
            labels: {
                format: '{value}',
            }
            
        }, { // 次日留存率 yAxis
        	title:null,
            labels: {
                format: '{value}%',
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        series: [{
            name: '新增用户',
            color: Highcharts.getOptions().colors[0],
            type: 'column',
            data: [49, 71, 106, 129, 144, 176, 135, 148, 216, 194, 95, 54],
            

        }, {
            name: '次日留存率',
            color: Highcharts.getOptions().colors[3],
            type: 'spline',
            yAxis: 1,
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
            tooltip: {
                valueSuffix: '%'
            }
        }]
    });
};

/**
 * 渠道时段分析
 * @param obj
 */
function channelAnalysis(obj){
	$.ajax({
		url:"ajaxtimeDetail",
		type:"post",
		dataType:"json",
		async:false,
		success:function(jsonData){
			var timeArray=jsonData.queryDate[0].setDate;
			channelAnalysis_timeDetail(jsonData.data,timeArray);
		}
		
	})
}


function channelAnalysis_timeDetail(data,timeArray){
	$('#channelTimeAnalysisContainer').highcharts({ 
		chart: {
            type: 'line'
        },
        title: {
            text: '时段详情'
        },
        subtitle: {
            text: '渠道用户新增'
        },
        xAxis: {
            categories: timeArray
        },
        yAxis: {
            title: {
                text:null
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
	    plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        credits:{
            enabled:false // 禁用版权信息
       },
	    series: data
    });
};
/**
 * 用户分析
 * @param formId
 * @param url
 * @param chartsId
 */
function userAnalysis_ajax(formId,url,chartsId){
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		data:$("#"+formId).serialize(),
		async:false,
		success:function(dataOrg){
			console.log(dataOrg);
			if(dataOrg.data.length>0){
				var xAxis = new Array();
				var categore = {
					categories: dataOrg.time
				}
				xAxis.push(categore);
				if(chartsId=="addUserContainer"){
					userAnalysis_addUser(xAxis,dataOrg.data,chartsId);
				}else if(chartsId=="userPayContainer"){
					userAnalysis_userPay(xAxis,dataOrg.data,dataOrg.type,chartsId);
				}else if(chartsId=="userActivContainer"){
					userAnalysis_userActiv(xAxis,dataOrg.data,dataOrg.type,chartsId);
				}else if(chartsId=="userActivMaxContainer"){
					userAnalysis_userMaxActiv(dataOrg.data,dataOrg.maxTime,dataOrg.maxLimit,chartsId);
				}else if(chartsId=="userLossContainer"){
					userAnalysis_userLoss(xAxis,dataOrg.data,dataOrg.type,chartsId);
				}else if(chartsId=="userStartContainer"){
					userAnalysis_userStart(xAxis,dataOrg.data,chartsId);
				}
			}else{
				$('#'+chartsId).html("<span style='text-align:center;'>没有数据</span>");
			}
		}
	})
}
/**
 * 新增用户报表
 * @param time
 * @param data
 * @param chartsId
 */
function userAnalysis_addUser(xAxis, data ,chartsId){
	$('#'+chartsId).highcharts({
	    chart: {
	        type: 'line'
	    }, 
	    title: {
	        text: null
	    },
	    exporting:'null',
	    xAxis:xAxis,
//	    xAxis: {
//	        categories: time
//	    },
	    yAxis: {
	        title:{
	           text:null
	        },
	        labels: {
	             formatter:function(){                     
	                    return this.value;              
	                }
	          }
	    },
	    tooltip: {
        	enabled: true,
            formatter: function () {
            	return '<b>'+this.x+" : "+this.y+'</b>';
            }
        },
	    credits:{
	         enabled:false // 禁用版权信息
	    },
	    series: data
	});
}
/**
 * 付费用户报表
 * @param time
 * @param data
 * @param type
 */
function userAnalysis_userPay(xAxis, data, type, chartsId){
	if(type!=2){
		$("#"+chartsId).highcharts({
		    chart: {
		        type: 'line'
		    }, 
		    title: {
		        text: null
		    },
		    exporting:'null',
		    xAxis:xAxis,
//		    xAxis: {
//		    	title:{
//	                text:null
//	             },
//		        categories: time
//		    },
		    yAxis: {
		        title:{
		           text:null
		        },
		        labels: {
		             formatter:function(){    
		            	 if(type==3){
		                    return this.value+"%"; 
		            	 }else{
		            		return this.value;
		            	 }
		              }
		          }
		    },
		    tooltip: {
	        	enabled: true,
	            formatter: function () {
	            	if(type==3){
	            		return '<b>'+this.x+" : "+this.y+"%"+'</b>';
	            	}else{
	            		return '<b>'+this.x+" : "+this.y+'</b>';
	            	}
	            	
	            }
	        },
		    credits:{
		         enabled:false // 禁用版权信息
		    },
		    series: data
		});
	}else{
		$("#"+chartsId).highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: null
	        },
	        exporting:'null',
	        xAxis:xAxis,
//	        xAxis: {
//	            categories: time
//	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: null
	            }
	        },
	        tooltip: {
	            pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b><br/>',
	            shared: true
	        },
	        legend: {
	            reversed: true
	        },
	        plotOptions: {
	            series: {
	                stacking: 'normal'
	            }
	        },
	        credits:{
	             enabled:false // 禁用版权信息
	        },
	        series: data
	    });
	}
}
/**
 * 活跃用户报表
 * @param time
 * @param data
 * @param type
 */
function userAnalysis_userActiv(xAxis, data,type,chartsId){
	if(type!=1){
		$("#"+chartsId).highcharts({ 
		    chart: {
		        type: 'line'
		    }, 
		    title: {
		        text: null
		    },
		    exporting:'null',
		    xAxis:xAxis,
//		    xAxis: {
//		        categories: time
//		    },
		    yAxis: {
		        title:{
		           text:null
		        },
		        labels: {
		             formatter:function(){
		                    return this.value;      
		                }
		          }
		    },
		    tooltip: {
	        	enabled: true,
	            formatter: function () {
	            	return '<b>'+this.x+" : "+this.y+'</b>';
	            }
	        },
		    credits:{
		         enabled:false // 禁用版权信息
		    },
		    series: data
		});
	}else{
		$("#"+chartsId).highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: null 
	        },
	        exporting:'null',
	        xAxis:xAxis,
//	        xAxis: {
//	            categories: time
//	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: null
	            }
	        },
	        tooltip: {
	            pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b><br/>',
	            shared: true
	        },
	        legend: {
	            reversed: true
	        },
	        plotOptions: {
	            series: {
	                stacking: 'normal'
	            }
	        },
	        credits:{
	             enabled:false // 禁用版权信息
	        },
	        series: data
	    });
	}
}
function userAnalysis_userMaxActiv(data,maxTime,maxLimit,chartsId){
	$('#'+chartsId).highcharts({
		 title: {
	            text: null
	        },
	        exporting:'null',
	        xAxis: {
	            min: 0,
	            categories: maxTime
	        },
	        yAxis: {
	            min: 0,
	            title:{
	               text:null
	            },
	            labels: {
	                 formatter:function(){                     
	                        return +this.value+"点";              
	                    }
	              }
	        },
	        tooltip: {
	            pointFormat: '<b>活跃峰值:{point.y}点</b>'
	        },
	        credits:{
	             enabled:false // 禁用版权信息
	        },
	        series: [{
	            type: 'scatter',
	            name: maxLimit,
	            data: data,
	            marker: {
	                radius: 4
	            }
	        }]
	 });
}
/**
 * 流失用户报表
 * @param time
 * @param data
 * @param type
 * @param chartsId
 */
function userAnalysis_userLoss(xAxis, data, type,chartsId){
	$('#'+chartsId).highcharts({ 
	    chart: {
	        type: 'line'
	    }, 
	    title: {
	        text: null
	    },
	    exporting:'null',
	    xAxis:xAxis,
//	    xAxis: {
//	        categories: time
//	    },
	    yAxis: {
	    	allowDecimals:false, //是否允许刻度有小数
	        title:{
	           text:null
	        },
	        labels: {
	             formatter:function(){    
	            	 if(type==1){
	                    return this.value+"%"; 
	            	 }else{
	            		return this.value;
	            	 }
	              }
	          }
	    },
	    tooltip: {
        	enabled: true,
            formatter: function () {
            	if(type==1){
            		return '<b>'+this.x+" : "+this.y+"%"+'</b>';
            	 }else{
            		 return '<b>'+this.x+" : "+this.y+'</b>';
            	 }
            	
            }
        },
	    credits:{
	         enabled:false // 禁用版权信息
	    },
	    series: data
	});
}
/**
 * 启动次数报表
 * @param time
 * @param data
 */
function userAnalysis_userStart(xAxis, data, chartsId){
	$('#'+chartsId).highcharts({ 
	    chart: {
	        type: 'line'
	    }, 
	    title: {
	        text: null
	    },
	    exporting:'null',
	    xAxis:xAxis,
//	    xAxis: {
//	        categories: time
//	    },
	    yAxis: {
	        title:{
	           text:null
	        },
	        labels: {
	             formatter:function(){    
	            		return this.value;
	                }
	          }
	    },
	    tooltip: {
        	enabled: true,
            formatter: function () {
            	return '<b>'+this.x+" : "+this.y+'</b>';
            }
        },
	    credits:{
	         enabled:false // 禁用版权信息
	    },
	    series: data
	});
}

/**
 * 终端属性
 * @param formId
 * @param url
 * @param chartsId
 */
function terminalProperty_ajax(formId,url,chartsId){
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		data:$("#"+formId).serialize(),
		async:false,
		success:function(dataOrg){
			if(dataOrg.data.length>0){
				terminalProperty_device(dataOrg.device,dataOrg.data,chartsId);
			}else{
				$('#'+chartsId).html("<span style='text-align:center;'>没有数据</span>");
			}
		}
	})
}
/**
 * 终端属性报表
 * @param device
 * @param data
 * @param chartsId
 */
function terminalProperty_device(device,data,chartsId){
	$('#'+chartsId).highcharts({
	        chart: {
	            type: 'bar'
	        },
	        title: {
	            text: null
	        },
	        exporting:'null',
	        xAxis: {
	            categories: device,
	            title: {
	                text: null
	            }
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: null
	            },
	            labels: {
	                overflow: 'justify'
	            }
	        },
	        tooltip: {
	        	enabled: true,
	            formatter: function () {
	            	return '<b>'+this.x+" : "+this.y+'</b>';
	            }
	        },
	        credits: {
	            enabled: false
	        },       
	        series: data
	    });
	};
	
/**
 * 周用户构成
 * @param time
 * @param data
 * @param type
 */
function guserWeek(time,data,type){
	var pointFormat = '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b><br/>';
	var stacking = 'normal';
	if(type==1){
		pointFormat = '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}%</b><br/>';
		stacking = 'percent';//百分比
	}
	$('#guserWeek').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: null
	        },
	        exporting:'null',
	        xAxis: {
	            categories: time
	        },
	        yAxis: {
	            title: {
	                text: null
	            }
	        },
	        legend: {
	            reversed: false
	        },
	        tooltip: {
	        	pointFormat: pointFormat,
	        	shared: true 
        	},
	        plotOptions: {
	            series: {
	                stacking: stacking
	            }
	        },
	        credits:{
	             enabled:false // 禁用版权信息
	        },
	        series: data
	    });
	};
	
function currencyAnalysis(){
	currencyAnalysis_Get_ajax("ajaxGet");
}

function currencyAnalysis_Get_ajax(url){
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		async:false,
		success:function(jsonData){
			console.log(jsonData);
			var timeArray=jsonData.dateList;
			console.log(timeArray);
			currencyAnalysis_Get(jsonData.data,timeArray);
		}
	})
}

function currencyAnalysis_Get(data,timeArray){
	$('#currencyAnalysisGetContainer').highcharts({ 
		chart: {
            type: 'line'
        },
        xAxis: {
            categories: timeArray
        },
        yAxis: {
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
	    plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
	    series: data
    });
};

/***
 * 获取数据，初始化highcharts
 * @param formId
 * @param url
 * @param chartsId
 * @param type
 */
function common_GetData_ajax(formId,url,chartsId,type,pro,searchType,tickInterval){
	if(!tickInterval){
		tickInterval=null;
	}
	$.ajax({
		url:url,
		type:"post",
		dataType:"json",
		data:$("#"+formId).serialize(),
		async:false,
		success:function(jsonData){
			var categories="";
			if(jsonData.data.length>0){
				type=type?type:"line";
				if(type=="line"){
					categories=jsonData.dateList;
					lineCharts_common(jsonData.data,categories,chartsId,pro,tickInterval);
				}else if(type=="bar"){
					categories=jsonData.categories;
					barCharts_common(jsonData.data,categories,chartsId,pro);
				}else if(type=="pie"){
					pieCharts_common(jsonData.data,chartsId,searchType);
				}else if(type=="splineAndBar"){
					categories=jsonData.time;
					subdivision_common(jsonData.data[0].name,jsonData.data[0].data,categories,chartsId,jsonData.addName,jsonData.addUser,pro);
				}else if(type=="subdivisionline"){
					categories=jsonData.time;
					lineCharts_common(jsonData.data,categories,chartsId,pro,tickInterval);
				}else if(type=="overallline"){
					categories=jsonData.time;
					lineCharts_common(jsonData.data,categories,chartsId,pro,tickInterval);
				}else if(type=="overallline"){
					categories=jsonData.time;
					lineCharts_common(jsonData.data,categories,chartsId,pro,tickInterval);
				}else if(type=="overalllineAndBar"){
					categories=jsonData.time;
					var data = jsonData.data;
					$.each(data,function(i,v){
						v.type='column';
					});
					var proportData=jsonData.proport[0];
					proportData.type='spline';
					proportData.color=Highcharts.getOptions().colors[3];
					proportData.tooltip={
		                valueSuffix: ' %'
		            };
					data.push(proportData);
					overall_common2(data,categories,chartsId,pro);
				}
			}else{
				$('#'+chartsId).html("<span style='text-align:center;'>没有数据</span>");
			}
		}
	})
}
function overall_common2(data,timeArray,chartsId,prop){
	$('#'+chartsId).highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: null
        },
        xAxis: {
            categories:timeArray
        },
        yAxis: [{ // 新增用户 yAxis
        	title:null,
            labels: {
                format: '{value}',
            }
            
        }, { // 次日留存率 yAxis
        	title:null,
            labels: {
                format: '{value}%',
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: false,
                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
                }
            }
        },
        credits:{
	       	 enabled:false                   // 默认值，如果想去掉版权信息，设置为false即可
	    },
        series: data
    });
}
/**
 * 折线图
 * @param data
 * @param timeArray
 * @param chartsId
 */
function lineCharts_common(data,timeArray,chartsId,prop,tickInterval){
	$('#'+chartsId).highcharts({ 
		chart: {
            type: 'line'
        },
        title: {
            text: null
        },
        xAxis: {
            categories: timeArray,
            tickInterval:tickInterval
        },
        yAxis: {
        	title:{
                text:null
             },
             labels: {
                 formatter:function(){  
                	 	if(prop){
                	 		 return +this.value.toFixed(2)+prop;    
                	 	}else{
                	 		 return this.value;
                	 	}
                                
                    }
              },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
        	enabled: true,
            formatter: function(){
            	if(prop){
            		return '<b>'+this.x+" : "+this.y.toFixed(2)+prop+'</b>';
             	}else{
             		return '<b>'+this.x+" : "+this.y+'</b>';
             	}
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: false,
                    formatter:function(){  
                	 	if(prop){
                	 		 return +this.y.toFixed(2)+prop;    
                	 	}else{
                	 		 return this.y;
                	 	}
                                
                    }
                }
            }
        },
        credits:{
        	 enabled:false                   // 默认值，如果想去掉版权信息，设置为false即可
        },
	    series: data
    });
};

/**
 * chart日期提示框日期格式化
 * @param obj
 * @param prop
 * @returns {String}
 */
function chartsTipFormat(obj,prop){
	var flag=false;//是否需要日期格式化
	var x= obj.x;
	var date;
	try {
		date = new Date(Date.parse(x)).pattern("MM-dd");
		flag=true;
	} catch (e) {
		console.log(e);
		flag=false;
	}
	if(!isNaN(x)){
		flag=false;//只要是数字则不需要日期格式化
	}
	if(flag){
		x=date;
	}
	if(prop){
		return '<b>'+x+" : "+obj.y.toFixed(2)+prop+'</b>';
 	}else{
 		return '<b>'+x+" : "+obj.y+'</b>';
 	}
}

/**
 * 柱状图
 * @param data
 * @param categories
 * @param chartsId
 */
function barCharts_common(data,categories,chartsId){
	$('#'+chartsId).highcharts({ 
	        chart: {
	            type: 'bar'
	        },
	        title: {
	            text: null
	        },
	        exporting:'null',
	        xAxis: {
	            categories: categories,
	            title: {
	                text: null
	            }
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: null
	            },
	            labels: {
	                overflow: 'justify'
	            }
	        },
	        plotOptions: {
	            bar: {
	                dataLabels: {
	                    enabled: true
	                }
	            }
	        },        
	        credits: {
	            enabled: false
	        },       
	        series: data
	    });

	};
/**
 * 饼状图
 * @param data
 * @param chartsId
 */
function pieCharts_common(data,chartsId,type){
	 $('#'+chartsId).highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 0,
            plotShadow: false,
        },
        title: {
            text: null
        },
        exporting:'null',
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        legend: {
            reversed: true
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                events: {
                    click: function(e) {
                    	var pointName = e.point.name;
                    	var pointNum = e.point.num;
                    	if(type){
                    		if(type==1){
                    			location.href = GLBConfig.homeUrl+"data/userAnalysis/userVersionDetail/"+pointName; //上面是当前页跳转，如果是要跳出新页面，那就用
                    		}else{
                    			location.href = GLBConfig.homeUrl+"data/channelAnalysis/channelDetail/"+pointNum; //上面是当前页跳转，如果是要跳出新页面，那就用
                    		}
                    	}
                    	//window.open(e.point.url);
                        //这里的url要后面的data里给出
                    }
                },
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                },
                showInLegend: true
            }
        },
        credits:{
             enabled:false // 禁用版权信息
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            innerSize: '50%',
            colorByPoint: true,
            data: data
        }]
    });
};
/**
 * 曲线图
 */
function subdivision_common(name,data,timeArray,chartsId,addName,addUser,prop){
    $('#'+chartsId).highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: null
        },
        exporting:'null',
        xAxis: [{
            categories: timeArray
        }],
        yAxis: [{ // 新增用户 yAxis
        	title:null,
            labels: {
                format: '{value}',
            }
            
        }, { // 次日留存率 yAxis
        	title:null,
            labels: {
                format: '{value}%',
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        credits:{
            enabled:false // 禁用版权信息
        },
        series: [{
            name: addName,
            color: Highcharts.getOptions().colors[0],
            type: 'column',
            data: addUser,
        }, {
            name: name,
            color: Highcharts.getOptions().colors[3],
            type: 'spline',
            yAxis: 1,
            data: data,
            tooltip: {
                valueSuffix: '%',
                valueDecimals: 2
            }
        }]
    });
};
/**
 * 用户参与度
 * 使用间隔
 * @param data
 */
function getInterval(data){
	$('#juserInterval').highcharts({       
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: null
	        },
	        exporting:'null',
	        xAxis: {
	        	categories: [ '1天', '2天', '3天', '4天', '5天', '6天', '7天'],
	            type: 'category',
	            labels: {
	                rotation: 0,
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        },
	        yAxis: {
	            min: 0,
	            title:{
	               text:null
	            },
	            labels: {
	                 formatter:function(){                     
	                        return +this.value;              
	                    }
	              }
	        },
	        tooltip: {
	            pointFormat: '<b>{point.y}</b>'
	        },
	        credits:{
	             enabled:false // 禁用版权信息
	        },
	        series: data
	    });
	};
	
/**
 * 用户参与度
 * 使用频率/使用时长
 * @param data
 * @param cate
 * @param divId
 */
function getJUserRate(data, cate, divId){
	$('#'+divId).highcharts({       
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: null
	        },
	        exporting:'null',
	        xAxis: {
	        	categories: cate,
	            type: 'category',
	            labels: {
	                rotation: 0,
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        },
	        yAxis: {
	            min: 0,
	            title:{
	               text:null
	            },
	            labels: {
	                 formatter:function(){                     
	                        return +this.value+"%";              
	                    }
	              }
	        },
	        tooltip: {
	            pointFormat: '<b>{point.y}%</b>'
	        },
	        credits:{
	             enabled:false // 禁用版权信息
	        },
	        series: data
	    });
	};
	
/**
 * 实时统计
 * @param time
 * @param data
 */
function getRealtime(time,data){
	$('#overviewRealtime').highcharts({
        chart: {
            type: 'line'
        },
        title: {
            text: null
        },
        exporting:'null',
        xAxis: {
            categories: time,
            tickInterval:6
        },
        yAxis: {
            title:{
               text:null
            }
        },
        credits:{
             enabled:false // 禁用版权信息
        },
        tooltip: {
        	formatter: function(){
             	return '<b>'+this.x+" : "+this.y+'</b>';
            }
        },
        series: data
    });
};

/**
 * 渠道设置
 */
function gameChannelAjax(){
	ajaxHtml(GLBConfig.homeUrl+'data/setUp/channelTable', $('#channelForm').serialize(), function(d){
		$('#channelTable').html(d);
	}, function(e){alertWarn("网络异常！");});
}

/**
 *SDK_IOS配置 
 */
function sdkIosConfigAjax(){
	ajaxHtml(GLBConfig.homeUrl+'data/generalData/ios/iosInfoSdkTable', $('#iosInfoSdkForm').serialize(), function(d){
		$('#iosInfoSdkTable').html(d);
	}, function(e){alertWarn("网络异常！");});
}
/**
 * 支付类型设置
 */
function payTypeAjax(){
	ajaxHtml(GLBConfig.homeUrl+'data/setUp/payTypeTable', $('#payTypeForm').serialize(), function(d){
		$('#payTypeTable').html(d);
	}, function(e){alertWarn("网络异常！");});
}
