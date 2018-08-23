package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.GmPlatform;
import com.syg.manage.pagination.Pagination;

public interface GmPlatformMapper {
	
	public List<GmPlatform> queryAll();
	public List<GmPlatform> queryListPageSearch(Pagination page, @Param("example") GmPlatform example);
	public List<GmPlatform> queryAllByPlatform(@Param("example") GmPlatform example);
	public GmPlatform queryByPlatformName(String platformName);
    int deleteByPrimaryKey(int platformId);
    int insert(GmPlatform record);
    int insertSelective(GmPlatform record);
    GmPlatform selectByPrimaryKey(int platformId);
    int updateByPrimaryKeySelective(GmPlatform record);
    int updateByPrimaryKey(GmPlatform record);
	public GmPlatform selectByKindIdAndPlatform(@Param("kindId")Integer kindId, @Param("platform")String platform);
	public GmPlatform queryByKindIdAndPlatformName(@Param("kindId")Integer kindId, @Param("platformName")String platformName);
	
}