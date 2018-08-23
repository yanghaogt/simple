<#global siteUrl= "${ftlConf().get('ftl_siteUrl')}" >
<#global imgUrl= "${ftlConf().get('ftl_imgUrl')}" > 
<#global cssUrl= "${ftlConf().get('ftl_cssUrl')}" >
<#global jsUrl= "${ftlConf().get('ftl_jsUrl')}" >

<#include "header.ftl">
<#include "footer.ftl">
<#include "footerBase.ftl">
<#include "left.ftl">
<#include "top.ftl">
<#include "title.ftl">
<#include "pagination.ftl">
<#include "paginationAjax.ftl">
<#include "paginationDc.ftl">
<#include "others.ftl">
<#include "othersDc.ftl">
<#include "simple/simpleList.ftl">
<#include "simple/simpleAdd.ftl">
<#include "simple/simpleEdit.ftl">
<#include "simple/simpleDetail.ftl">
