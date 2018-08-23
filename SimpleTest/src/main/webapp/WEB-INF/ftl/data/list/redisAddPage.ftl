<#include "../../common/globalDef.ftl">
<@simpleAdd "新增用户" "${siteUrl}/data/userAdd">

<@formText "总充值金额" "infullAmount" />
<@formText "总在线时长" "onlineTime" />
<@formText "登录次数" "loginCount" />
<@formText "活跃天数" "activeDay" />
<@formText "活跃周数" "activeWeek" />
<@formText "日志编号" "lastLoginLogId" />

</@simpleAdd>