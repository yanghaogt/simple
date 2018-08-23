package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.GmChannel;
import com.syg.manage.pagination.Pagination;

public interface GmChannelMapper {
	
	public List<GmChannel> queryByParent(String parentId);
	public List<GmChannel> queryAll();
	public List<GmChannel> queryListPageSearch(Pagination page, @Param("example") GmChannel example);
    GmChannel selectByPlatformId(GmChannel record);
    int deleteByPrimaryKey(int chId);
    int insert(GmChannel record);
    int insertSelective(GmChannel record);
    GmChannel selectByPrimaryKey(int chId);
    int updateByPrimaryKeySelective(GmChannel record);
    int updateByPrimaryKey(GmChannel record);
    
}