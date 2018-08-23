package com.syg.manage.svs.manage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.syg.manage.cfg.Per;
import com.syg.manage.model.entity.SesUser;
import com.syg.manage.model.manage.ManageLoginLog;
import com.syg.manage.model.manage.ManageOperateLog;
import com.syg.manage.model.manage.ManagePer;
import com.syg.manage.model.manage.ManageRole;
import com.syg.manage.model.manage.ManageUser;
import com.syg.manage.pagination.Pagination;

public interface IManageSvs {
	public SesUser userLogin(String userName,String password,HttpSession ses,HttpServletRequest req);
	public void userLogout(HttpSession ses);
	public void setting(String oldPwd,String newPwd,String reNewPwd,HttpSession ses);
	
	public void searchUser(Pagination page,ManageUser example);
	public void addUser(ManageUser example);
	public void editUser(ManageUser example);
	public void editUserImg(ManageUser example);
	
	public List<Per> checkPerNoDb();
	
	public void searchRole(Pagination page,ManageRole example);
	public void addRole(ManageRole example);
	public void editRole(ManageRole example,int[] mpIds);
	
	public void searchPer(Pagination page,ManagePer example);
	public void addPer(ManagePer example);
	public void editPer(ManagePer example);
	public void editPer(int mpId ,int fatherId);
	public ManagePer searchPerByMpId(int mpId);
	public List<ManagePer> searchsubPer(int fatherId);
	
	public void searchLoginLog(Pagination page, ManageLoginLog example);
	public void searchOperateLog(Pagination page, ManageOperateLog example);
	public void addOperateLog(ManageOperateLog example);
}
