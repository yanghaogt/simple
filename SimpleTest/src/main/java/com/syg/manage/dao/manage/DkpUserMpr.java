package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.DkpUser;
import com.syg.manage.pagination.Pagination;

public interface DkpUserMpr {
	
	public List<DkpUser> queryAll();
	public DkpUser queryByDuId(Integer duId);
	public DkpUser queryByUserName(String userName);
	public List<DkpUser> queryListPageSearch(Pagination page,@Param("example")DkpUser example);
	public void saveItem(DkpUser item);
	public int updateItem(DkpUser item);
	public int updateDkp(DkpUser item);
}
