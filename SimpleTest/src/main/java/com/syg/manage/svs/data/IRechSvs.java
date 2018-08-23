package com.syg.manage.svs.data;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import com.syg.manage.model.manage.Cdkey;
import com.syg.manage.model.manage.Holiday;
import com.syg.manage.model.manage.Mail;
import com.syg.manage.model.manage.Point;
import com.syg.manage.model.manage.PointMap;
import com.syg.manage.model.manage.RedisUser;
import com.syg.manage.pagination.Pagination;

public interface IRechSvs {
	
	public List<Cdkey> searchCdkey();
	
	public void searchCdkey(Pagination page, Cdkey example);
	
	public void searchPoint(Pagination page, Point example);
	
	public void searchPointMap(Pagination page, PointMap example);
	
	public void createCdkeyExcel(Cdkey example,HttpServletResponse resp);
	
	public void searchHoliday(Pagination page, Holiday example);
	
	public void addUser(RedisUser example);
	
	public void searchUser(String Id,ModelMap mm);
	
	public void addMail(Mail mail);
	
	public void searchMail(Pagination page,Mail example);
}
