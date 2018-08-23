package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.GmGameKind;
import com.syg.manage.pagination.Pagination;

public interface GmGameKindMapper {
	
	public List<GmGameKind> queryAll();
	public List<GmGameKind> queryListPageSearch(Pagination page, @Param("example") GmGameKind example);
	public List<GmGameKind> queryAllByGameKind(@Param("example") GmGameKind example);
	public GmGameKind queryByGameName(String gameName);
    int deleteByPrimaryKey(Integer kindId);
    int insert(GmGameKind record);
    int insertSelective(GmGameKind record);
    GmGameKind selectByPrimaryKey(Integer kindId);
    int updateByPrimaryKeySelective(GmGameKind record);
    int updateByPrimaryKey(GmGameKind record);
}