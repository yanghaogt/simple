package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.ManageOperateLog;
import com.syg.manage.pagination.Pagination;

public interface ManageOperateLogMpr {
	public void saveItem(ManageOperateLog item);
	public List<ManageOperateLog> queryListPageSearch(Pagination page,@Param("example")ManageOperateLog example);
}
