<#include "../../common/globalDef.ftl">
<@simpleAdd "新增权限" "${siteUrl}/manage/perAdd">
<input type="hidden" name="fatherMpId" value="${fatherMpId}">
<@formText "权限名" "perName" />
<@formText "权限值" "mpId" />
<@formText "对应路径" "pageUrl" />
<@formText "简述" "simDesc" />

</@simpleAdd>