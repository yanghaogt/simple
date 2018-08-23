package com.syg.manage.svs.data;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import com.syg.manage.model.manage.SummaryNewAddUser;
import com.syg.manage.pagination.Pagination;

public interface ICharSvs {
	
	/**
	 * 新增用户
	 * @param example
	 */
	public List<SummaryNewAddUser> searchSummaryNewAddUserList(SummaryNewAddUser example,String dateType,ModelMap mm);
	public Map<String, Object> searchSummaryNewAddUser(SummaryNewAddUser example,Integer type,String dateType,ModelMap mm);
	public void searchSummaryNewAddUserPageList(SummaryNewAddUser example,String dateType,ModelMap mm,Pagination page);
	public void addUserExportExcel(SummaryNewAddUser example,String dateType,Pagination pagination,String fileName,HttpServletResponse response);
}
