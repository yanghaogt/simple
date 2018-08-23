<#global siteUrl= "${ftlConf().get('ftl_siteUrl')}" >
<#global imgUrl= "${ftlConf().get('ftl_siteUrl')}/data/images" > 
<#global cssUrl= "${ftlConf().get('ftl_siteUrl')}/data/css" >
<#global jsUrl= "${ftlConf().get('ftl_siteUrl')}/data/js" >

<#include "header.ftl">
<#include "footer.ftl">
<#include "top.ftl">
<#include "left.ftl">
<#include "pagination.ftl">
<#include "others.ftl">

<#include "simple/simplePage.ftl">
<#include "simple/simpleAlert.ftl">