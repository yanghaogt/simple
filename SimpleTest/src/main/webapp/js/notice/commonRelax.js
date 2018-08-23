$('#login-out-btn').live('click', function(){
	logout();
});

function logout(){
	ajaxComAsyncFalse(GLBConfig.homeUrl+"/logout",{},function(d){
		window.location.href = GLBConfig.homeUrl;
	},function(e){});
}

//关闭layer弹窗
function closeWin(){
	layer.closeAll();
}

//退出  或者返回
function backProcessConfirm(msg){
	var winId = 0;
	winId = alertConfirm(msg, function(){
		process(0);
	}, function(){
		layer.close(winId);
	});
}

function generate(layout,msg,type) {
    var n = noty({
        text        : msg,
        type        : type,
        dismissQueue: true,
        layout      : layout,
        theme       : 'relax',//有一个默认风格：defaultTheme
        maxVisible: 5,
        timeout: 500
    });
}

/**
 * layer弹出层
 * @param pageUrl
 * @param strTitle
 */
function showSimplePop(pageUrl,strTitle,height,width){
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
		generate("topCenter",msg,type);
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
	var indexConfirm = 0;
	indexConfirm =layer.confirm(msg, {
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

/**排序方法*/
function sortField(formName,fieldName,sortType){
	$("form[name='"+formName+"']").find("input[name='seqName']").val(fieldName);
	$("form[name='"+formName+"']").find("input[name='seqType']").val(sortType==0?1:0);
	$("form[name='"+formName+"']").submit();
}

/**清空FORM表单内容 id：表单ID*/
function ClearForm(id) {
	var objId = $('#'+id)[0];
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

function comMsg(dataOrg){
	if (dataOrg.code!="S") {
		alertErr(dataOrg.msg);
		return null;
	}
	return dataOrg.msg;
}

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

function ajaxCom(targetUrl,data,funSuc,funErr){
	$.ajax({
        url: targetUrl,
        type: 'post',
        dataType:'json',
        data:data,
        async:false,
        error:function(data){
        	funErr("网络异常");
        },
        success:function(dataOrg){
        	var res =comMsg(dataOrg);
        	if(res!=null){
        		funSuc(res);
        		return;
        	}
        	funErr("网络异常");
        	
        }
	});
}

function commonModalSubmit(url,formId){
	$('#'+formId).ajaxSubmit({
        type: "POST",
        url:url,
        async: false,
        dataType : 'json',
        error:function(dataOrg){
        	alertErr('未知异常');
        },
        success : function(dataOrg){
        	var res=comMsg(dataOrg);
			if(res!=null){
				layer.closeAll();
				alertSuc(res);
			}
        }
    });
}

