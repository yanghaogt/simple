package com.syg.manage.dao.game;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.annotation.DataSourceParam;
import com.syg.manage.model.game.Activity;
import com.syg.manage.pagination.Pagination;

public interface ActivityMapper {
	
	public List<Activity> select(Pagination page, @Param("example") Activity example,@DataSourceParam(dataSourceName="cqgamedataDataSource") @Param("dataSourceIndex")Integer dataSourceIndex);
	public List<Activity> select(@Param("example") Activity example,@DataSourceParam(dataSourceName="cqgamedataDataSource") @Param("dataSourceIndex")Integer dataSourceIndex);
	public int insert(@Param("example") Activity example,@DataSourceParam(dataSourceName="cqgamedataDataSource") @Param("dataSourceIndex")Integer dataSourceIndex);

}