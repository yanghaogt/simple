<#include "../../common/globalDef.ftl">
<@simpleAdd "新增用户" "${siteUrl}/mail/mailAdd">

<@formText "email" "email" />
<@formText "标题" "title" />
<@formTextEditer "内容" "content" />

</@simpleAdd>