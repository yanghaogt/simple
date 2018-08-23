package com.syg.manage.svs.manage.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.syg.manage.cache.SessionHelper;
import com.syg.manage.cfg.ManageConfig;
import com.syg.manage.cfg.Per;
import com.syg.manage.dao.manage.GmChannelMapper;
import com.syg.manage.dao.manage.GmGameKindMapper;
import com.syg.manage.dao.manage.GmPlatformMapper;
import com.syg.manage.dao.manage.ManageLoginLogMpr;
import com.syg.manage.dao.manage.ManageOperateLogMpr;
import com.syg.manage.dao.manage.ManagePerMpr;
import com.syg.manage.dao.manage.ManageRoleMpr;
import com.syg.manage.dao.manage.ManageRolePerMpr;
import com.syg.manage.dao.manage.ManageUserMpr;
import com.syg.manage.exception.BaseException;
import com.syg.manage.exception.ParamException;
import com.syg.manage.model.entity.SesUser;
import com.syg.manage.model.manage.ManageLoginLog;
import com.syg.manage.model.manage.ManageOperateLog;
import com.syg.manage.model.manage.ManagePer;
import com.syg.manage.model.manage.ManageRole;
import com.syg.manage.model.manage.ManageRolePer;
import com.syg.manage.model.manage.ManageUser;
import com.syg.manage.pagination.Pagination;
import com.syg.manage.svs.manage.IManageSvs;
import com.syg.manage.util.Des;
import com.syg.manage.util.IPSeeker;
import com.syg.manage.util.IPSeekerBase;
import com.syg.manage.util.IPUtil;
import com.syg.manage.util.SesHelper;

@Service
public class ManageSvs implements IManageSvs {

	private static final Logger logger = LoggerFactory.getLogger(ManageSvs.class);
	@Resource
	private ManageUserMpr manageUserMpr;
	@Resource
	private ManageRolePerMpr manageRolePerMpr;
	@Resource
	private ManageRoleMpr manageRoleMpr;
	@Resource
	private ManagePerMpr managePerMpr;
	@Resource
	private ManageConfig manageConfig;
	@Resource
	private ManageLoginLogMpr manageLoginLogMpr;
	@Resource
	private ManageOperateLogMpr manageOperateLogMpr;
	@Resource
	private GmGameKindMapper gmGameKindMapper;
	@Resource
	private GmPlatformMapper gmPlatformMapper;
	@Resource
	private GmChannelMapper gmChannelMapper;

	@Override
	public SesUser userLogin(String userName, String password, HttpSession ses, HttpServletRequest req) {
		ManageUser user = manageUserMpr.queryByUserName(userName);
		String ecodePassword = password;
		// 将明文密码加密
		try {
			ecodePassword = Des.encrypt(password);
		} catch (Exception e) {
			logger.warn("密码加密错误",e);
		}
		ManageLoginLog example = new ManageLoginLog();
		// 比较加密后的密码
		if (user == null || !user.getPassword().equals(ecodePassword)) { 
			if (user == null) {
				example.setUserId(-1);
			}else {
				example.setUserId(user.getMuId());
			}
			example.setUserName(userName);
			example.setLoginResult(9999);
			example.setLogTime(new Date());
			String ip = IPUtil.getIpAddr(req);
			example.setLoginIp(ip);
			IPSeekerBase seeker = IPSeeker.getInstance();
			example.setLoginArea(seeker.getCountry(ip) + " " + seeker.getArea(ip));
			manageLoginLogMpr.saveItem(example);
			throw new ParamException("账号或者密码错误");
		}
		// 更新最后登录时间
		user.setLastLoginTime(new Date());
		manageUserMpr.updateLastLogin(user);
		ManageRole mr = manageRoleMpr.queryByMrId(user.getMrId());
		List<ManageRolePer> mrpList = manageRolePerMpr.queryByMrId(user
				.getMrId());
		Map<Integer, ManagePer> mapPer = new HashMap<>();
		for (int i = 0; i < mrpList.size(); i++) {
			ManageRolePer userPer = mrpList.get(i);
			ManagePer mp = manageConfig.getPerMap().get(userPer.getMpId());
			if(mp != null){
				mapPer.put(mp.getMpId(), mp);
			}
		}
		// 默认系统管理项
		ManagePer subPer = searchPerByMpId(101);
		List<ManagePer> subList = searchsubPer(101);
		subPer.setSubList(subList);
		
		SesUser sesUser = new SesUser();
		sesUser.setManageUser(user);
		sesUser.setManageRole(mr);
		sesUser.setPers(mapPer);
		sesUser.setRootPer(manageConfig.getRootPer());
		sesUser.setSubPer(subPer);
		SesHelper.setSimUser(ses, sesUser);
		SesHelper.setCurrGame(ses, 1);
		ses.setMaxInactiveInterval(60 * 60);
		
		example.setUserId(user.getMuId());
		example.setUserName(userName);
		example.setLoginResult(1000);
		example.setLogTime(new Date());
		String ip = IPUtil.getIpAddr(req);
		example.setLoginIp(ip);
		IPSeekerBase seeker = IPSeeker.getInstance();
		example.setLoginArea(seeker.getCountry(ip) + " " + seeker.getArea(ip));
		manageLoginLogMpr.saveItem(example);
		
		//缓存数据
		SessionHelper.setCurrGame(ses, 1);
		SessionHelper.setGameList(ses, gmGameKindMapper.queryAll());
		SessionHelper.setPlatList(ses, gmPlatformMapper.queryAll());
		SessionHelper.setChanList(ses, gmChannelMapper.queryAll());
		
		return sesUser;
	}

	@Override
	public void userLogout(HttpSession ses) {
		SesHelper.setSimUser(ses, null);
	}

	@Override
	public void setting(String oldPwd, String newPwd, String reNewPwd,
			HttpSession ses) {
		ManageUser mu = manageUserMpr.queryByMuId(SesHelper.getSimUser(ses)
				.getManageUser().getMuId());

		String ecodeOldPwd = oldPwd;
		// 将明文密码加密
		try {
			ecodeOldPwd = Des.encrypt(oldPwd);
		} catch (Exception e) {
			logger.warn("密码加密错误",e);
		}

		if (oldPwd == null || oldPwd.trim().length() < 6
				|| !mu.getPassword().equals(ecodeOldPwd)) {
			throw new ParamException("密码错误");
		}
		if (newPwd == null || newPwd.trim().length() < 6
				|| !newPwd.equals(reNewPwd)) {
			throw new ParamException("新密码错误");
		}
		try {
			mu.setPassword(Des.encrypt(newPwd));
		} catch (Exception e) {
			logger.warn("密码加密错误",e);
		}
		manageUserMpr.updateItem(mu);
	}

	@Override
	public void searchUser(Pagination page, ManageUser example) {
		page.getItems().addAll(manageUserMpr.queryListPageSearch(page, example));
	}

	@Override
	public void addUser(ManageUser example) {
		// 验证用户名
		if (manageUserMpr.queryByUserName(example.getUserName()) != null) {
			throw new ParamException("用户名已经存在");
		}
		example.setRegTime(new Date());
		example.setLastLoginTime(new Date());
		try {
			example.setPassword(Des.encrypt(example.getPassword()));
		} catch (Exception e) {
			logger.warn("加密密码出错");
		}
		manageUserMpr.saveItem(example);
	}

	@Override
	public void editUser(ManageUser example) {
		if (manageUserMpr.updateItem(example) != 1) {
			throw new BaseException("更新失败");
		}
	}
	
	@Override
	public void editUserImg(ManageUser example) {
		if (manageUserMpr.updateImg(example) != 1) {
			throw new BaseException("更新失败");
		}
	}

	@Override
	public void searchRole(Pagination page, ManageRole example) {
		page.getItems().addAll(manageRoleMpr.queryListPageSearch(page, example));
	}

	@Override
	public void addRole(ManageRole example) {
		if (manageRoleMpr.queryByRoleName(example.getRoleName()) != null) {
			throw new ParamException("角色名已经存在");
		}
		manageRoleMpr.saveItem(example);
	}

	@Override
	public void editRole(ManageRole example, int[] mpIds) {
		ManageRole oldRole = manageRoleMpr.queryByRoleName(example.getRoleName());
		if (oldRole != null && oldRole.getMrId() != example.getMrId()) {
			throw new ParamException("角色名已经存在");
		}
		if (manageRoleMpr.updateItem(example) != 1) {
			throw new BaseException("更新失败");
		}
		Map<Integer, ManageRolePer> mrpMap = new HashMap<>();
		Map<Integer, Integer> mpIdMap = new HashMap<>();
		List<ManageRolePer> mrpList = manageRolePerMpr.queryByMrId(example.getMrId());
		for (ManageRolePer mrp : mrpList) {
			mrpMap.put(mrp.getMpId(), mrp);
		}
		for (int itemId : mpIds) {
			mpIdMap.put(itemId, itemId);
		}
		// 先添加进去
		for (int itemId : mpIds) {
			if (!mrpMap.containsKey(itemId)) {
				ManageRolePer mpr = new ManageRolePer();
				mpr.setMpId(itemId);
				mpr.setMrId(example.getMrId());
				manageRolePerMpr.saveItem(mpr);
			}
		}
		// 再删除
		for (ManageRolePer mrp : mrpList) {
			if (!mpIdMap.containsKey(mrp.getMpId())) {
				manageRolePerMpr.deleteByMrpId(mrp.getMrpId());
			}
		}
	}

	@Override
	public void searchPer(Pagination page, ManagePer example) {
		page.getItems().addAll(managePerMpr.queryListPageSearch(page, example));
	}

	@Override
	public void addPer(ManagePer example) {
		if (example.getFatherMpId()==0 || example.getMpId() ==0) {
			throw new BaseException("权限值不能为0");
		}
		managePerMpr.saveItem(example);
		manageConfig.updateCache(true);
	}

	@Override
	public void editPer(ManagePer example) {
		if (example.getFatherMpId()==0 || example.getMpId() ==0) {
			throw new BaseException("权限值不能为0");
		}
		managePerMpr.updateItem(example);
		manageConfig.updateCache(true);
	}

	@Override
	public void editPer(int mpId, int fatherId) {
		if (mpId==0 || fatherId ==0) {
			throw new BaseException("权限值不能为0");
		}
		if (managePerMpr.updateFatherId(mpId, fatherId) != 1) {
			throw new BaseException("更新失败");
		}
		manageConfig.updateCache(true);
	}
	
	@Override
	public ManagePer searchPerByMpId(int mpId) {
		return managePerMpr.queryByMpId(mpId);
	}

	@Override
	public List<ManagePer>searchsubPer(int fatherId) {
		List<ManagePer> menuList = managePerMpr.queryByfatherId(fatherId);
		for(int i=0;i<menuList.size();i++){
			ManagePer per = menuList.get(i);
			List<ManagePer> subList = managePerMpr.queryByfatherId(per.getMpId());
			if(subList!=null && subList.size()>0){
				per.setSubList(subList);
			}
		}
		return menuList;
	}

	@Override
	public void searchLoginLog(Pagination page, ManageLoginLog example) {
		page.getItems().addAll(manageLoginLogMpr.queryListPageSearch(page, example));
	}
	
	@Override
	public void searchOperateLog(Pagination page, ManageOperateLog example) {
		page.getItems().addAll(manageOperateLogMpr.queryListPageSearch(page, example));
	}
	
	@Override
	public void addOperateLog(ManageOperateLog example) {
		try {
			manageOperateLogMpr.saveItem(example);
		} catch (Exception e) {
			throw new BaseException("保存失败");
		}
	}

	@Override
	public List<Per> checkPerNoDb() {
		List<Per> resOrg = Per.getAllPer();
		List<Per> resList = new ArrayList<>();
		List<ManagePer> mpList = managePerMpr.queryAll();
		Map<Integer, ManagePer> mpMap = new HashMap<>();
		for (ManagePer mp : mpList) {
			mpMap.put(mp.getMpId(), mp);
		}
		for (Per p : resOrg) {
			if (!mpMap.containsKey(Integer.valueOf(p.getCode()))) {
				resList.add(p);
			}
		}
		return resList;
	}

}
