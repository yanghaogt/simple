<#include "../../common/globalDef.ftl">
<@simpleEdit "修改权限信息" "${siteUrl}/manage/perEdit">
<input type="hidden" name="mpId" value="${example.mpId}">
<input type="hidden" name="fatherMpId" value="${example.fatherMpId}">

<@formText "权限名" "perName" "${example.perName!}"/>
<@formText "对应路径" "pageUrl" "${example.pageUrl!}"/>
<@formText "简述" "simDesc" "${example.simDesc!}"/>

</@simpleEdit>