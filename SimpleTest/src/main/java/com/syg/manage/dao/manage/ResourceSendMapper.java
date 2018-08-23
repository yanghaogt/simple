package com.syg.manage.dao.manage;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.entity.RoleItem;
import com.syg.manage.model.manage.ResourceSend;
import com.syg.manage.pagination.Pagination;

public interface ResourceSendMapper {

	ResourceSend selectByPrimaryKey(@Param("id")Integer id);
	
    int insert(ResourceSend record);
    
	List<ResourceSend> queryListPageSearch(Pagination page, @Param("example")ResourceSend example);
	
	int updateStatusById(@Param("id")Integer id, @Param("status")Integer status, @Param("updateTs")Date updateTs,@Param("approvalName")String approvalName);//approvalName
	
	int updateStatus(@Param("id")Integer id, @Param("status")Integer status, @Param("updateTs")Date updateTs,@Param("approvalName")String approvalName,@Param("operationDesc")String operationDesc);
	
	int updateResourceSend(@Param("id")Integer id, @Param("status")Integer status, @Param("updateTs")Date updateTs,@Param("approvalName")String approvalName,@Param("sendLog")String sendLog);
	
	public ResourceSend selectByIds(@Param("ids")String ids);
	
	public ResourceSend selectByIdsSendType(@Param("ids")String ids);
	
	public ResourceSend selectByIdsIsPass(@Param("ids")String ids);
	
	public List<ResourceSend> queryListSearch(@Param("example")ResourceSend example);
	
	public void insertBatch(@Param("example")ResourceSend example,@Param("roleList")List<RoleItem> roleList);
	
	public void updateBatch(@Param("example")ResourceSend example,@Param("idList")List<Integer> idList);
	
}