<#include "../common/globalDef.ftl">
<@header>

</@header>
<body>

<!-- Form area -->
<div class="error-page">
  <div class="container">

    <div class="row">
      <div class="col-md-12">
        <!-- Widget starts -->
            <div class="widget headless footless white">
              <!-- Widget head -->
              <div class="widget-head">
                <i class="icon-question-sign"></i> 操作异常 
              </div>

              <div class="widget-content">
                <div class="padd error">
                  
                  <h1>${tm_common_error_msg!}</h1>
                  <p>${tm_common_error_desc!}</p>
                  <br />
                 <div class="horizontal-links">
                  <a href="${siteUrl}/loginPage">登录界面</a> | <a href="javascript:history.go(-1)">返回上一步</a>
                 </div>

                </div>
              </div>
            </div>  
      </div>
    </div>
  </div> 
</div>

<@footerBase/>

</body>
</html>