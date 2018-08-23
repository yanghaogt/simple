package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.Cdkey;
import com.syg.manage.model.manage.Holiday;
import com.syg.manage.pagination.Pagination;

public interface HolidayMpr {
	
	public List<Holiday> queryAll();
	public int insertItem(Holiday example);
	public void deleteAll();
	public List<Cdkey> queryListPageSearch(Pagination page,@Param("example")Holiday example);
	
}
