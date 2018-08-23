package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.Attachment;

public interface AttachmentMapper {
	
    int insert(Attachment record);

    int insertSelective(Attachment record);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);
    
    int updateAfId(@Param("afId")Integer afId, @Param("attachId")Integer attachId);
    
	int updateAfIdByAttachIds(@Param("afId")int afId, @Param("list")List<Integer> list);
	
	int deleteByPrimaryKey(@Param("empId")Integer empId, @Param("attachId")Integer attachId, @Param("attachType")Integer attachType);
	
	Attachment selectByRefId(@Param("refId")Integer refId, @Param("attachType")Integer attachType);
	
	void deleteAttachMent(@Param("refId")Integer refId, @Param("path")String path);
	
	int updateByRefId(@Param("refId")Integer refId, @Param("attachType")Integer attachType,@Param("name")String name);
}