package com.syg.manage.ctrl.manage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.syg.manage.annotation.TagPer;
import com.syg.manage.base.BaseCtrl;
import com.syg.manage.cfg.ManageConfig;
import com.syg.manage.cfg.Per;
import com.syg.manage.dao.manage.ManageLoginLogMpr;
import com.syg.manage.dao.manage.ManageOperateLogMpr;
import com.syg.manage.dao.manage.ManagePerMpr;
import com.syg.manage.dao.manage.ManageRoleMpr;
import com.syg.manage.dao.manage.ManageRolePerMpr;
import com.syg.manage.dao.manage.ManageUserMpr;
import com.syg.manage.model.manage.ManageLoginLog;
import com.syg.manage.model.manage.ManageOperateLog;
import com.syg.manage.svs.manage.IManageSvs;

@Controller
@RequestMapping("manage")
public class ManageLogCtrl extends BaseCtrl {
	@Resource
	private IManageSvs manageSvs;
	@Resource
	private ManageRoleMpr manageRoleMpr;
	@Resource
	private ManageUserMpr manageUserMpr;
	@Resource
	private ManagePerMpr managePerMpr;
	@Resource
	private ManageRolePerMpr manageRolePerMpr;
	@Resource
	private ManageConfig manageConfig;
	@Resource
	private ManageLoginLogMpr manageLoginLogMpr;
	@Resource
	private ManageOperateLogMpr manageOperateLogMpr;

	@TagPer(Per.PER_SYS_LOGINLOG_PAGE)
	@RequestMapping(value = "loginLogListPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginLogListPage(@ModelAttribute("example") ManageLoginLog example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			mm.put("example", example);
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/log/loginLogList";
	}

	@TagPer(Per.PER_SYS_LOGINLOG_PAGE)
	@RequestMapping(value = "loginLogList", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginLogList(@ModelAttribute("example") ManageLoginLog example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.searchLoginLog(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/log/loginLogList";
	}

	@TagPer(Per.PER_SYS_OPERATELOG_PAGE)
	@RequestMapping(value = "operateLogListPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String operateLogListPage(@ModelAttribute("example") ManageOperateLog example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			mm.put("example", example);
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/log/operateLogList";
	}

	@TagPer(Per.PER_SYS_OPERATELOG_PAGE)
	@RequestMapping(value = "operateLogList", method = { RequestMethod.GET, RequestMethod.POST })
	public String operateLogList(@ModelAttribute("example") ManageOperateLog example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.searchOperateLog(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/log/operateLogList";
	}
}
