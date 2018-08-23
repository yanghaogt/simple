<#macro header title="数据中心">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" >
        <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1,user-scalable=no" />    
        <link rel="stylesheet" href="${cssUrl}/oa_style.css"/>
        <link rel="stylesheet" href="${cssUrl}/oa_main.css"/>
        <link rel="stylesheet" href="${cssUrl}/dateRange.css"/>
        <link rel="stylesheet" href="${cssUrl}/jquery-ui-1.9.2.custom.min.css"/>
        <link rel="stylesheet" href="${cssUrl}/jquery-ui-timepicker-addon.css"/>
        <script src="${jsUrl}/jquery-1.8.3.min.js" type="text/javascript"></script>
        <script src="${jsUrl}/jquery.form.js" type="text/javascript"></script>
        <script src="${jsUrl}/exporting.js"></script>
        <script src="${jsUrl}/highcharts.js"></script>
        <script src="${jsUrl}/chart.js"></script>
        <script src="${jsUrl}/dateRange.js"></script>
        <script src="${jsUrl}/noty/jquery.noty.packaged.min.js"></script>
        <script src="${jsUrl}/layer/layer.js"></script>
        <script src="${jsUrl}/common.js"></script>
        <script src="${jsUrl}/dataCommon.js"></script>
        <script src="${jsUrl}/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="${jsUrl}/jquery-ui-timepicker-addon.js"></script>
        <script>
		var GLBConfig={
				homeUrl:"${siteUrl}/",
				jsUrl:"${jsUrl}"
		};
		</script>
        <title>${title}</title>
        <#nested>
    </head>
</#macro>