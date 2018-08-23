/**
 * 网站业务相关
 */


layer.config({
	extend: 'extend/layer.ext.js',
	skin: 'layui-layer-rim', //加上边框
	shift: 4 ,//默认动画风格
	closeBtn : 2 //圆的关闭按钮
});



/**统一的json处理*/
function comMsg (dataOrg){
	if (dataOrg.code!="S") {
		alertErr(dataOrg.msg);
		return null;
	}
	return dataOrg.msg;
}

/**统一的提示 和 确认框*/
function alertNor(msg){
	alertBase(msg,"alert");
}
function alertErr(msg){
	alertBase(msg,"error");
}
function alertSuc(msg){
	alertBase(msg,"success");
}
function alertWarn(msg){
	alertBase(msg,"warning");
}
function alertInfo(msg){
	alertBase(msg,"infomation");
}
function alertBase(msg,type){
	try {
		//TODO 多层layer的情况下  这里会抛出异常  有待改善
		noty({text: msg,layout:'topCenter',type:type,timeout:2000});
	} catch (e) {
		console.log("noty error:"+e.message);
		if (type == "error") {
			layer.msg(msg, {icon: 2});
		}else if (type == "success") {
			layer.msg(msg, {icon: 1});
		}
	}
	
}
function alertConfirm(msg,funOk,funCancel) {
	var indexConfirm =layer.confirm(msg, {
		shadeClose :true,
		title:'操作确认',
	    btn: ['确定','取消'], //按钮
	}, function(){
	    layer.close(indexConfirm);
	    if(funOk)funOk();
	}, function(){
		//layer.close(indexConfirm);
		//if(funCancel)funCancel();
	});
}

function alertConfirm2(msg,funOk,funCancel) {
	var indexConfirm =layer.confirm(msg, {
		shadeClose :true,
		title:'操作确认',
	    btn: ['确定','取消'], //按钮
	}, function(){
	    layer.close(indexConfirm);
	    if(funOk)funOk();
	}, function(){
		layer.close(indexConfirm);
		if(funCancel)funCancel();
	});
}

var commonModalSubmitCheck=function(){
	var checkOk=true;
	/*
	$("input.noNull").each(function () {
       	var val = $(this).val();
	       	if(val==""){
				$(this).css("border","1px solid #FF0000");
				$(this).parent().children("div").addClass("error");
				$(this).parent().children("div").html("不能为空！！");
				checkOk = false;
			}else{
				$(this).removeAttr("style");
				$(this).parent().children("div").hide();
			}
			
    });
	
	$("input.num").each(function () {
       	var val = $(this).val();
	       	if(!(/^-?\d+(\.\d{1,6})?$/.test(val)) ){
				$(this).css("border","1px solid #FF0000");
				checkOk = false;
			}else{
				$(this).removeAttr("style");
			}
			
    });*/
	
	return checkOk;
};
var defaultModalClose =function(){
	setTimeout(function(){document.defaultForm.submit();}, 800);
};


function commonModalSubmit(url,formId){
	if(!commonModalSubmitCheck()){
		return checkOk;
	}
	var aa=layer;
	$('#'+formId).ajaxSubmit({
        type: "POST",
        url:url,
        async: false,
        dataType : 'json',
        error:function(dataOrg){
        	console.log(dataOrg);
        	alertErr('未知异常');
        },
        success : function(dataOrg){
        	var res=comMsg(dataOrg);
			if(res!=null){
				layer.closeAll();
				alertSuc(res);
				defaultModalClose();
			}
        }
    });
}

/*清空FORM表单内容 id：表单ID*/
function ClearForm(name) {
	var objId = document.getElementsByName(name)[0];
	if (objId == undefined) {
		return;
	}
	for (var i = 0; i < objId.elements.length; i++) {
		if (objId.elements[i].type == "text") {
			objId.elements[i].value = "";
		} else if (objId.elements[i].type == "password") {
			objId.elements[i].value = "";
		} else if (objId.elements[i].type == "radio") {
			objId.elements[i].checked = false;
		} else if (objId.elements[i].type == "checkbox") {
			objId.elements[i].checked = false;
		} else if (objId.elements[i].type == "select-one") {
			objId.elements[i].options[0].selected = true;
		} else if (objId.elements[i].type == "select-multiple") {
			for (var j = 0; j < objId.elements[i].options.length; j++) {
				objId.elements[i].options[j].selected = false;
			}
		} else if (objId.elements[i].type == "textarea") {
			objId.elements[i].value = "";
		}
	}
}

/**排序方法*/
function sortField(formName,fieldName,sortType){
	$("form[name='"+formName+"']").find("input[name='seqName']").val(fieldName);
	$("form[name='"+formName+"']").find("input[name='seqType']").val(sortType==0?1:0);
	$("form[name='"+formName+"']").submit();
}

var treeMenuItems = function (node) {
	var items = {
		addItem: {
			label: "新增信息",
			action: function (data) {
				var inst = $.jstree.reference(data.reference),
				obj = inst.get_node(data.reference);
				handelPer(obj.id,0);
			}
		},
		editItem: {
			label: "修改信息",
			action: function (data) {
				var inst = $.jstree.reference(data.reference),
				obj = inst.get_node(data.reference);
				handelPer(obj.id,1);
			}
		}
//		delItem: {
//			label: "删除",
//			action: function (data) {
//				var inst = $.jstree.reference(data.reference),
//				obj = inst.get_node(data.reference);
//				handelPer(obj.id,2);
//			}
//		}
	};
	return items;
}

/**权限操作弹框*/
function handelPer(mpId,type){
	var strUrl=GLBConfig.homeUrl;
	var title="";
	if (type==0) {//增加
		strUrl+="manage/perAddPage?fatherMpId="+mpId;
		title="添加权限";
	}else if (type==1) {//修改
		strUrl+="manage/perEditPage?mpId="+mpId;
		title="修改权限";
	}else if (type==2) {//删除
		strUrl+="";
		title="删除权限";
	}
	showSimplePop(strUrl,title);
	return;
}

/**显示设置框*/
function showSetting(){
	var strUrl=GLBConfig.homeUrl+"settingPage";
	showSimplePop(strUrl,"设置密码");
}


if ($('#perTree').length>0) {
	//查询方法
	var to=false;
	$('#searchPer').keyup(function () {
	    if(to) { clearTimeout(to); }
	    to = setTimeout(function () {
	      var v = $('#searchPer').val();
	      $('#perTree').jstree(true).search(v);
	    }, 200);
	  });
	//拖放事件
	$('#perTree').bind('move_node.jstree', function (e, data) {
		$.ajax({
			"url":GLBConfig.homeUrl+"manage/perFatherIdEdit",
			"type":"post",
			"dataType":"json",
			"async":false,
			"data":{
				"mpId":data.node.id,"fatherId":data.parent
			},
			success:function(e){
				var res=comMsg(e);
				if(res!=null){
					alertSuc(e.msg);
				}else{
					$('#perTree').jstree(true).refresh();
				}
			},
			error:function(e){
				alertErr('操作失败,未知异常');
				$('#perTree').jstree(true).refresh();
			}
		});
		
		
	});
	
	//主方法
	$("#perTree").jstree({
		  "core" : {
		    "check_callback" : true,
		    "data":{
				  "dataType":"json",
				  "url":GLBConfig.homeUrl+"manage/perTree",
				  "method":"post"
			  }
		  },
		  "plugins" : [ "dnd","search","state", "wholerow","contextmenu"],
		  "contextmenu": {"items":treeMenuItems}
	});
}


function showSC(){
		$("#sc").append('<input type="file" class="btn btn-info" name="picName" />');
}


function showSC2(){
	var fileFlag = true; 
	$("input[name='picName']").each(function(){ 
		if($(this).val()=="") { 
			fileFlag = false;
			return false; 
		} 
	}); 
	if(fileFlag) { 
		$("#sc").append('<input type="file" class="btn btn-info" name="picName" />');
	} 
}

/**
 * 全选
 * @param form
 * @param checked
 */
function checkAll(form, checked) {
    for (var i=0; i<form.elements.length; i++) {
        var e = form.elements[i];
        if (e.type=="checkbox"&&!e.disabled) {
        	e.checked = checked;}
    }
}
/**
 * 删除
 * @param formId
 * @param siteUrl
 */
function deleteConfirm(formId,siteUrl) {
	var msg = "确定要删除吗";
	alertConfirm(msg,function(){
		$.ajax({
			"url":siteUrl,
			"type":"post",
			"data":$("#"+formId).serialize(),
			"dataType":"json",
			"async":false,
			success:function(e){
				var res=comMsg(e);
				if(res!=null){
					alertSuc(e.msg);
				}
				defaultModalClose();
			},
			error:function(e){
				alertErr('操作失败,未知异常');
			}
		});
		
	},null);
}

function commonConfirm(formId,siteUrl,msg) {
	alertConfirm(msg,function(){
		$.ajax({
			"url":siteUrl,
			"type":"post",
			"data":$("#"+formId).serialize(),
			"dataType":"json",
			"async":false,
			success:function(e){
				var res=comMsg(e);
				if(res!=null){
					alertSuc(e.msg);
				}
				defaultModalClose();
			},
			error:function(e){
				alertErr('操作失败,未知异常');
			}
		});
		
	},null);
}

/**
 * 弹出层
 * @param pageUrl
 * @param strTitle
 */
function showSimplePopForm(pageUrl,strTitle,formId,height,width){
	var myarea;
	if(width == null){
		width = 620;
	} 
	if (height == null) {
		myarea = width +'px';
	} else {
		myarea = [width + 'px', height + 'px'];
	}
	
	$.ajax({
		"url":pageUrl,
		"type":"post",
		"data":$("#"+formId).serialize(),
		"dataType":"html",
		"async":false,
		success:function(e){
			if(e!=null){
				//页面层
				layer.open({
				    type: 1,
				    title:strTitle,
				    shadeClose :false,
				    area: myarea,//宽高
				    content: e
				});
			}
		},
		error:function(e){
			alertErr('操作失败,未知异常');
		}
	});
}

/**
 * 弹出层
 * @param pageUrl
 * @param strTitle
 */
function showSimplePop(pageUrl,strTitle,height,width){
	var myarea;
	if(width == null){
		width = "620";
	}
	if (height == null) {
		height = "";
	}
	
	if ( ((typeof width === 'string') && width.indexOf("%")>0) || ((typeof height === 'string') && height.indexOf("%")>0)) {
		if (height) {
			myarea = [width, height];
		} else {
			myarea = width;
		}
	}else{
		if (height) {
			myarea = [width + 'px', height + 'px'];
		} else {
			myarea = width +'px';
		}
	}
	
	$.ajax({
		"url":pageUrl,
		"type":"post",
		"dataType":"html",
		"async":false,
		success:function(e){
			if(e!=null){
				//页面层
				layer.open({
				    type: 1,
				    title:strTitle,
				    shadeClose :false,
				    area: myarea,//宽高
				    content: e
				});
			}
		},
		error:function(e){
			alertErr('操作失败,未知异常');
		}
	});
}

/**
 * 上传组件的数据传递对象 只针对同一时间的最后一个上传框
 */
function showImgPop(pageUrl,strTitle){
	$.ajax({
		"url":pageUrl,
		"type":"post",
		"dataType":"html",
		"async":false,
		success:function(e){
			if(e!=null){
				//页面层
				layer.open({
				    type: 1,
				    title:strTitle,
				    shadeClose :false,
				    area: '420px', //宽高
				    content: e
				});
			}
		},
		error:function(e){
			alertErr('操作失败,未知异常');
		}
	});
}

/**
 * ajax请求返回模板页面内容
 * @param url 请求地址
 * @param data json格式参数
 * @param funs 成功处理函数 
 * @param fune 失败处理函数
 */
function ajaxHtml(url, data, funs, fune){
	$.ajax({
        url: url,
        type: 'post',
        dataType:'html',
        data:data,
        async:false,
        error:fune,
        success:funs
	});
}

/**
 * 退出登陆
 */
function logoutConfirm(){
	alertConfirm("确定要退出登陆吗?", function(){
		$.ajax({
			"url":GLBConfig.homeUrl+"logout.do",
			"type":"post",
			"dataType":"json",
			"async":false,
			success:function(e){
				var res=comMsg(e);
				if(res!=null){
					window.location.reload();
				}
			},
			error:function(e){
				alertErr('操作失败,未知异常');
			}
		});
		
	},null);
}

/**
 * 生成万能卡号
 * @param selectId
 */
function MathRand(selectId) { 
	var sText = $("#"+selectId).find("option:selected").text();
	if(sText=="-请选择-"){
		alertErr("请先选择卡类型，再生成卡号！");
	}else{
		var num="";
		var $chars = 'abcdefghijklmnopqrstuvwxyz0123456789';
		var maxPos = $chars.length; 
		for(var i=0;i<6;i++) { 
			num += $chars.charAt(Math.floor(Math.random() * maxPos));
		}
		num += sText; 
		$('#addModalForm input[name="cardNum"]').val(num);
	}
}

/**
 * 启用禁用万能卡
 * @param formId
 * @param status
 * @param siteUrl
 */
function universalCardConfirm(formId,status,siteUrl) {
	var msg = "确定禁用万能卡吗";
	if(status == "1"){
		msg = "确定启用万能卡吗";
	}
	alertConfirm(msg,function(){
		$.ajax({
			"url":siteUrl+"&status="+status,
			"type":"post",
			"data":$("#"+formId).serialize(),
			"dataType":"json",
			"async":false,
			success:function(e){
				var res=comMsg(e);
				if(res!=null){
					alertSuc(e.msg);
				}
				defaultModalClose();
			},
			error:function(e){
				alertErr('操作失败,未知异常');
			}
		});
		
	},null);
}
/**
 * 点卡发放激活冻结
 * @param formId
 * @param status
 * @param type 1=点卡发放 0=点卡状态
 * @param siteUrl
 */
function savingCardConfirm(formId,status,type,siteUrl){
	var msg = "";
	if(type==1 && status==1){
		msg = "确定发放点卡吗";
	}else if(type==1 && status==0){
		msg = "确定取消发放吗";
	}else if(type==0 && status==1){
		msg = "确定激活点卡吗";
	}else{
		msg = "确定冻结点卡吗";
	}
	alertConfirm(msg,function(){
		$.ajax({
			"url":siteUrl+"&status="+status+"&type="+type,
			"type":"post",
			"data":$("#"+formId).serialize(),
			"dataType":"json",
			"async":false,
			success:function(e){
				var res=comMsg(e);
				if(res!=null){
					alertSuc(e.msg);
				}
				defaultModalClose();
			},
			error:function(e){
				alertErr('操作失败,未知异常');
			}
		});
		
	},null);
}

/**
 * 开启关闭互动栏目
 * @param status
 * @param siteUrl
 */
function surveyTypeConfirm(status,siteUrl) {
	var msg = "确定关闭栏目吗";
	if(status == "1"){
		msg = "确定开启栏目吗";
	}
	alertConfirm(msg,function(){
		$.ajax({
			"url":siteUrl+"&status="+status,
			"type":"post",
			"dataType":"json",
			"async":false,
			success:function(e){
				var res=comMsg(e);
				if(res!=null){
					alertSuc(e.msg);
				}
				defaultModalClose();
			},
			error:function(e){
				alertErr('操作失败,未知异常');
			}
		});
		
	},null);
}

/**
 * a标签预览图片
 * @param 
 * @returns
 */
urlImagePreview = function(){	
	xOffset = -20;
	yOffset = 20;
	$("td a.autoPreview").hover(function(e){
		var img = new Image(); 
		img.src = $(this).attr("href"); 
		if(img.height>375 || img.width>500)
		{
			$(this).parent().append("<div id='url_preview' style='" +
					"background-image: url(" + $(this).attr("href") + ");" +
					"background-size:contain;" +
					"background-repeat: no-repeat;" +
					"position: fixed;" +
					"z-index: 99999;" +
					"display: none;" + 
					"height: 357px; width: 500px;' ></div>");
		} else {
			$(this).parent().append("<div id='url_preview' style='" +
					"background-image: url(" + $(this).attr("href") + ");" +
					"background-repeat: no-repeat;" +
					"position: fixed;" +
					"z-index: 99999;" +
					"display: none;" + 
					"height: 357px; width: 500px;' ></div>");
		}
		$("#url_preview")
			.css("top",(e.clientY - yOffset) + "px")
			.css("left",(e.clientX - xOffset) + "px")
			.fadeIn("normal");						
	},
	function(){
		$("#url_preview").remove();
	});	
	$("td a.autoPreview").mousemove(function(e){
		$("#url_preview")
			.css("top",(e.clientY - yOffset) + "px")
			.css("left",(e.clientX - xOffset) + "px");
	});			
};
$(document).ready(function(){
	urlImagePreview();
});

/**
 * 添加删除
 * 活动选项
 */
function activityItem(ctrlUrl,formId) {
	$.ajax({
        url: ctrlUrl,
        type: 'post',
        dataType:'html',
        data:$("#"+formId).serialize(),
        async:false,
        error:function(data){
        	alertErr('操作失败,未知异常');
        },
        success:function(dataOrg){
        	$('#activityItem').html(dataOrg);
        }
	});
}
/**
 * 修改活动状态
 * @param acId
 * @param acStatus
 * @param sendStatus
 */
function activityStatus(acId){
	var msg = "确定修改状态吗";
	alertConfirm(msg,function(){
		var acStatus = $('#acStatus').val();
		var sendStatus = $('#sendStatus').val();
		$.ajax({
	        url: GLBConfig.homeUrl+'dkp/activityStatusEdit',
	        type: 'post',
	        dataType:'json',
	        data:{'acId':acId, 'acStatus':acStatus, 'sendStatus':sendStatus},
	        async:false,
	        success:function(e){
				var res=comMsg(e);
				if(res!=null){
					alertSuc(e.msg);
				}
			},
			error:function(e){
				alertErr('操作失败,未知异常');
			}
		});
	},null);
}

function comfirmRes(formId,siteUrl,msg) {
	alertConfirm(msg,function(){
		$.ajax({
			"url":siteUrl,
			"type":"post",
			"data":$("#"+formId).serialize(),
			"dataType":"json",
			"async":false,
			success:function(e){
				var res=comMsg(e);
				if(res!=null){
					alertSuc(e.msg);
				}
				defaultModalClose();
			},
			error:function(e){
				if(e.msg != null && e.msg != ''){
					alertErr(e.msg);
				}else{
					alertErr('操作失败,未知异常3');
				}
			}
		});
		
	},null);
}
