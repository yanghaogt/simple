<#macro simplePage category=0 maxWidth=1300>
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
<@top category/>
<@left/>
<!-- menu_content S-->
    <div class="menu_content" style="max-width:${maxWidth}px;"> 
        <#nested>
    </div>
   
<!-- menu_content E-->

<@footer/>
</#macro>