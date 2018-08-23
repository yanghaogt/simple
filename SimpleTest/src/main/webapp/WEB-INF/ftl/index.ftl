<#include "common/globalDef.ftl">
<@header>
<script>
window.onload = function(){
	$('.timectrl').datetimepickerNew({
		showHour: false,
		showMinute: false,
		showSecond: false,
		timeText: '',
		timeFormat: ''
	});
} 
</script>
</@header>
<body>
<@top/>
<!-- Main content starts -->

<div class="content">
  	<@left/>
  	<!-- Main bar -->
	<div class="mainbar" style="text-align:center; background:#fff url(img/time_bg.png) center center no-repeat; ">
      <@title/>
	  
		<div class="matter">
		<div class="container">
		<div class="col-md-12" style="max-width:1300px;">
		<#if code?? && code!="S">
		<div class="alert alert-danger hideit">
          ${msg!}
        </div>
        </#if>
		</div>
		</div>
		</div>
	</div>
   <!-- Mainbar ends -->
	<div class="clearfix"></div>
</div>
<!-- Content ends -->

<@footer/>
