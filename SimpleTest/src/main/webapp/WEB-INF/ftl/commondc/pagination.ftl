<#macro pagination obj functionName col>
<input type="hidden" name="seqName" id="seqName" value="${page.seqName}"/>
<input type="hidden" name="seqType" id="seqType" value="${page.seqType}"/>
<#nested>
<#if obj.totalPage gt 1>
							<input type="hidden" name="currentPage" id="currentPage" value="${obj.currentPage}">
							  <tr class="paging">
                                <td colspan="${col}" width="100%">
                                  <#if obj.currentPage gte obj.totalPage-1>
                                  <a href="javascript:void(0)"><i class="icon iconfont">&#xe624;</i></a>
								  <a href="javascript:void(0);"><i class="icon iconfont">&#xe627;</i></a>
								  <#else>
                                  <a href="javascript:${functionName}(${obj.totalPage-1})"><i class="icon iconfont">&#xe624;</i></a>
								  <a href="javascript:${functionName}(${obj.currentPage+1})"><i class="icon iconfont">&#xe627;</i></a>
								  </#if>
								  
								  <#if (obj.totalPage lt 5)>
								    <#list 0..(obj.totalPage-1) as i>
									  <#if obj.currentPage==obj.totalPage-i-1><a href="javascript:void(0);" class="page_on">${obj.totalPage-i}</a><#else><a href="javascript:${functionName}(${obj.totalPage-i-1})">${obj.totalPage-i}</a></#if>
								    </#list>
								  <#else>
								    <#list 0..4 as i>
								      <#assign pi=(obj.currentPage+(4-obj.currentPage%5))-i >
								      <#if pi lt obj.totalPage >
									    <#if pi==obj.currentPage><a href="javascript:void(0);" class="page_on">${pi+1}</a><#else><a href="javascript:${functionName}(${pi})">${pi+1}</a></#if>
								      </#if>
								    </#list>
								  </#if>
                                  
                                  <#if obj.currentPage==0>
							 		<a href="javascript:void(0);"><i class="icon iconfont">&#xe626;</i></a>
							 		<a href="javascript:void(0)"><i class="icon iconfont">&#xe625;</i></a>
							 	  <#else>
							 	    <a href="javascript:${functionName}(${obj.currentPage-1})"><i class="icon iconfont">&#xe626;</i></a>
							 	    <a href="javascript:${functionName}(0)"><i class="icon iconfont">&#xe625;</i></a>
							 	  </#if>
                                  
                                </td>
                              </tr>
</#if>

</#macro>

