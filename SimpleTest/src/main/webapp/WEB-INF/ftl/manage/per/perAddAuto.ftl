<#include "../../common/globalDef.ftl">
<@simpleAdd "新增权限信息" "${siteUrl}/manage/perAdd">

<input type="hidden" name="fatherMpId" value="${fatherMpId}">
<@formText "权限名" "perName" "${example.perName!}" />
<@formText "权限值" "mpId" "${example.mpId}"/>
<@formText "对应路径" "pageUrl" "${example.pageUrl!}" />
<@formText "简述" "simDesc" "${example.simDesc!}"/>
</@simpleAdd>