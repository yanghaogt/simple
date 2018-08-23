package com.syg.manage.ctrl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.syg.manage.annotation.TagPer;
import com.syg.manage.base.BaseCtrl;
import com.syg.manage.cfg.Per;
import com.syg.manage.model.entity.SesUser;
import com.syg.manage.model.manage.ManagePer;
import com.syg.manage.svs.manage.impl.ManageSvs;
import com.syg.manage.util.SesHelper;

@Controller
public class LoginCtrl extends BaseCtrl {
	@Resource
	private ManageSvs manageSvs;

	@RequestMapping(value = "/")
	public String index(ModelMap mm, HttpServletRequest req, HttpServletResponse resp) {
		return "redirect:index";
	}
	
	@RequestMapping(value = "index", method = { RequestMethod.GET, RequestMethod.POST })
	@TagPer(Per.ROOT)
	public String indexTrue(HttpSession ses, ModelMap mm, HttpServletRequest req) {
		pageList(req, mm);
		return "index";
	}
	
	@RequestMapping(value = "loginPage", method = { RequestMethod.GET, RequestMethod.POST })
	@TagPer(needLogin = false)
	public String loginPage(ModelMap mm, HttpSession ses, HttpServletRequest req) {
		return "login/login";
	}

	@RequestMapping(value = "login", method = { RequestMethod.GET, RequestMethod.POST })
	@TagPer(needLogin = false)
	public String login(ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.userLogin(reqStrDef("userName", req), reqStrDef("password", req), ses, req);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
 		return JSON_COM;
	}

	@RequestMapping(value = "logout.do", method = { RequestMethod.GET, RequestMethod.POST })
	@TagPer(needLogin = false)
	public String logout(HttpSession ses, ModelMap mm) {
		try {
			manageSvs.userLogout(ses);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}

	@RequestMapping(value = "settingPage", method = { RequestMethod.GET, RequestMethod.POST })
	@TagPer(Per.ROOT)
	public String settingPage(HttpSession ses, ModelMap mm, HttpServletRequest req) {
		return "/login/setting";
	}

	@RequestMapping(value = "setting", method = { RequestMethod.GET, RequestMethod.POST })
	@TagPer(Per.ROOT)
	public String setting(String oldPwd, String newPwd, String reNewPwd, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.setting(oldPwd, newPwd, reNewPwd, ses);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
	
	@RequestMapping(value = "noPer", method = { RequestMethod.GET, RequestMethod.POST })
	public String noPer(HttpSession ses, ModelMap mm, HttpServletRequest req) {
		return "/login/noPer";
	}
	
	@RequestMapping(value = "menu.do", method = { RequestMethod.GET, RequestMethod.POST })
	@TagPer(Per.ROOT)
	public String menu(int mpId, HttpSession ses, ModelMap mm, HttpServletRequest req){
		try{
			ManagePer subPer = manageSvs.searchPerByMpId(mpId);
			List<ManagePer> subList = manageSvs.searchsubPer(mpId);
			subPer.setSubList(subList);
			SesUser sesUser = SesHelper.getSimUser(ses);
			if(sesUser != null){
				sesUser.setSubPer(subPer);
			}
			req.getSession().setAttribute("currentPer", subPer);
			pageList(req, mm);
			handleSuc(mm);
		}catch(Exception e){
			handleErr(mm ,e);
		}
		return "index";
	}

}
