package com.syg.manage.dao.manage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syg.manage.model.manage.Mail;
import com.syg.manage.model.manage.ManageRole;
import com.syg.manage.pagination.Pagination;

public interface MailMpr {
	
	public void saveItem(Mail item);
	public List<ManageRole> queryListPageSearch(Pagination page,@Param("example")Mail example);
	
}
