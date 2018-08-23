package com.syg.manage.dao.manage;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.SummaryNewAddUser;
import com.syg.manage.pagination.Pagination;

public interface SummaryNewAddUserMpr {
	
	public List<SummaryNewAddUser> queryAll();
	public List<SummaryNewAddUser> querySearch(@Param("example")SummaryNewAddUser example);
	
	public List<SummaryNewAddUser> queryChannelAndDate(@Param("channelId")String channelId,@Param("date")Set<String> date);
	
	public List<SummaryNewAddUser> queryBySearchTypeAndLeDate(@Param("example")SummaryNewAddUser example,@Param("searchType")Integer searchType,@Param("date")String date);
	
	public List<SummaryNewAddUser> querySumSearch(@Param("example")SummaryNewAddUser example);
	
	public List<SummaryNewAddUser> querySumSearchs(@Param("example")SummaryNewAddUser example);
	public List<SummaryNewAddUser> queryListPage(Pagination page,@Param("example")SummaryNewAddUser example);
}
