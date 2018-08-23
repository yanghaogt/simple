<#include "../common/globalDef.ftl">
<@header>
<style >
.container .login_icon{width:40%; margin:30px auto;}
.container .login_icon img{width:100%;}
</style>
<script>
  	function login(){
	  	$("#loginForm").ajaxSubmit({
			type: "POST",
			async: true,
			url:GLBConfig.homeUrl+"login",
			dataType: "json",
		    error:function(dataOrg){
		    	console.log('err');
		    	alertErr('未知异常');
	            //confirm('未知异常',function(){alert(1)},function(){alert(2)});
	        },
	        success : function(dataOrg){
	        	console.log('suc');
	        	var res=comMsg(dataOrg);
				if(res!=null){
					window.location.href=GLBConfig.homeUrl+"index";
				}
	        }
		});
  	}
  	function enterDown(event){
  		if(event.keyCode == 13){
  			login();
  		}
  	}
  	$(function(){
	  if(!(navigator.userAgent.indexOf("Firefox")>0||navigator.userAgent.indexOf("Chrome")>0||$.support.leadingWhitespace)) { 
	         layer.alert('为了您能有更好的浏览体验，<br/>请下载以下浏览器:<br/><a href="http://dlsw.baidu.com/sw-search-sp/soft/9d/14744/ChromeStandalone_47.0.2526.106_Setup.1450323126.exe">谷歌浏览器</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://dlsw.baidu.com/sw-search-sp/soft/51/11843/Firefox_43.0.3.5835_setup.1451465170.exe">火狐浏览器</a>',{title: '友情提示'});
	      }  
	});
  </script>
</@header>
<body onkeydown="enterDown(event)">

<!-- Form area -->
<div class="admin-form">
  <div class="container">
	<div class="login_icon">
      <img src="${imgUrl}/loginicon.png" alt="" >
    </div>
    <div class="row">
      <div class="col-md-12">
        <!-- Widget starts -->
            <div class="widget">
              <!-- Widget head -->
              <div class="widget-head">
                <i class="icon-lock"></i> 登录
              </div>

              <div class="widget-content">
                <div class="padd">
                  <!-- Login form -->
                  <form id="loginForm" class="form-horizontal" method="post">
                    <!-- Email -->
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputEmail">账号</label>
                      <div class="col-lg-9">
                        <input type="text" name="userName" class="form-control" id="inputEmail" value="" placeholder="登录账号">
                      </div>
                    </div>
                    <!-- Password -->
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputPassword">密码</label>
                      <div class="col-lg-9">
                        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="密码" value="">
                      </div>
                    </div>
                    <div class="col-lg-9 col-lg-offset-3">
						<button type="button" onclick="javascript:login()" class="btn btn-danger">登录</button>
						<button type="reset" class="btn btn-default">重置</button>
					</div>
                    <br />
                  </form>
				  
				</div>
                </div>
              
                <div class="widget-foot">
                	时与光
                </div>
            </div>  
      </div>
    </div>
  </div> 
</div>
	
<@footerBase/>

</body>
</html>