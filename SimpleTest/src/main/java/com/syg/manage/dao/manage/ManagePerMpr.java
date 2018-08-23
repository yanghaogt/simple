package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.ManagePer;
import com.syg.manage.pagination.Pagination;


public interface ManagePerMpr {
	public void saveItem(ManagePer item);
	public ManagePer queryByMpId(Integer mpId);
	public List<ManagePer> queryAll();
	public List<ManagePer> queryListPageSearch(Pagination page,@Param("example")ManagePer example);
	public int updateItem(ManagePer example);
	public int updateFatherId(@Param("mpId")int mpId,@Param("fatherId")int fatherId);
	public List<ManagePer> queryByfatherId(@Param("fatherId")int fatherId);
}
