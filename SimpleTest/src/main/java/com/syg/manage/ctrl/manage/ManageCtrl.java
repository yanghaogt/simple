package com.syg.manage.ctrl.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.syg.manage.dao.manage.ManagePerMpr;
import com.syg.manage.dao.manage.ManageRoleMpr;
import com.syg.manage.dao.manage.ManageRolePerMpr;
import com.syg.manage.dao.manage.ManageUserMpr;
import com.syg.manage.model.manage.ManagePer;
import com.syg.manage.model.manage.ManageRole;
import com.syg.manage.model.manage.ManageRolePer;
import com.syg.manage.model.manage.ManageUser;
import com.syg.manage.svs.manage.IManageSvs;
import com.syg.manage.util.Des;

@Controller
@RequestMapping("manage")
public class ManageCtrl extends BaseCtrl {
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

	@TagPer(Per.PER_SYS_USER_PAGE)
	@RequestMapping(value = "userListPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String userPage(@ModelAttribute("example") ManageUser example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			pageList(req, mm);
			mm.put("roleList", manageRoleMpr.queryAll());
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/user/userList";
	}

	@TagPer(Per.PER_SYS_USER_PAGE)
	@RequestMapping(value = "userList", method = { RequestMethod.GET, RequestMethod.POST })
	public String userList(@ModelAttribute("example") ManageUser example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			mm.put("roleList", manageRoleMpr.queryAll());
			manageSvs.searchUser(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/user/userList";
	}

	@TagPer(Per.PER_SYS_USER_ADD)
	@RequestMapping(value = "userAddPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String userAddPage(ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			mm.put("roleList", manageRoleMpr.queryAll());
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/user/userAdd";
	}

	@TagPer(Per.PER_SYS_USER_ADD)
	@RequestMapping(value = "userAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String userAdd(@ModelAttribute("example") ManageUser example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.addUser(example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}

	@TagPer(Per.PER_SYS_USER_EDIT)
	@RequestMapping(value = "userEditPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String userEditPage(int muId, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		ManageUser manageUser = manageUserMpr.queryByMuId(muId);
		try {
			manageUser.setPassword(Des.decrypt(manageUser.getPassword()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			mm.put("example", manageUser);
			mm.put("roleList", manageRoleMpr.queryAll());
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/user/userEdit";
	}

	@TagPer(Per.PER_SYS_USER_EDIT)
	@RequestMapping(value = "userEdit", method = { RequestMethod.GET, RequestMethod.POST })
	public String userEdit(@ModelAttribute("example") ManageUser example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			example.setPassword(Des.encrypt(example.getPassword()));
			manageSvs.editUser(example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}

	@TagPer(Per.PER_SYS_ROLE_PAGE)
	@RequestMapping(value = "roleListPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String roleListPage(@ModelAttribute("example") ManageRole example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			pageList(req, mm);
			mm.put("roleList", manageRoleMpr.queryAll());
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/role/roleList";
	}

	@TagPer(Per.PER_SYS_ROLE_PAGE)
	@RequestMapping(value = "roleList", method = { RequestMethod.GET, RequestMethod.POST })
	public String roleList(@ModelAttribute("example") ManageRole example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.searchRole(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/role/roleList";
	}

	@TagPer(Per.PER_SYS_ROLE_ADD)
	@RequestMapping(value = "roleAddPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String roleAddPage(ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/role/roleAdd";
	}

	@TagPer(Per.PER_SYS_ROLE_ADD)
	@RequestMapping(value = "roleAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String roleAdd(@ModelAttribute("example") ManageRole example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.addRole(example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}

	@TagPer(Per.PER_SYS_ROLE_EDIT)
	@RequestMapping(value = "roleEditPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String roleEditPage(int mrId, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			mm.put("example", manageRoleMpr.queryByMrId(mrId));
			mm.put("rootPerForce", manageConfig.getRootPer());
			Map<Integer, ManageRolePer> mrpMap = new HashMap<>();
			List<ManageRolePer> mrpList = manageRolePerMpr.queryByMrId(mrId);
			for (int i = 0; i < mrpList.size(); i++) {
				mrpMap.put(mrpList.get(i).getMpId(), mrpList.get(i));
			}
			mm.put("mrpMap", mrpMap);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/role/roleEdit";
	}

	@TagPer(Per.PER_SYS_ROLE_EDIT)
	@RequestMapping(value = "roleEdit", method = { RequestMethod.GET, RequestMethod.POST })
	public String roleEdit(@ModelAttribute("example") ManageRole example, BindingResult br, int[] mpIds, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.editRole(example, mpIds);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}

	@TagPer(Per.PER_SYS_PER_PAGE)
	@RequestMapping(value = "perListPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String perListPage(@ModelAttribute("example") ManagePer example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/per/perList";
	}

	@TagPer(Per.PER_SYS_PER_PAGE)
	@RequestMapping(value = "perList", method = { RequestMethod.GET, RequestMethod.POST })
	public String perList(@ModelAttribute("example") ManagePer example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.searchPer(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/per/perList";
	}

	@TagPer(Per.PER_SYS_PER_PAGE)
	@RequestMapping(value = "perTree", method = { RequestMethod.GET, RequestMethod.POST })
	public String perTree(ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			mm.put("rootPerForce", manageConfig.getRootPer());
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/per/json_tree";
	}

	@TagPer(Per.PER_SYS_PER_ADD)
	@RequestMapping(value = "perAddPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String perAddPage(@ModelAttribute("fatherMpId") int fatherMpId, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/per/perAdd";
	}

	@TagPer(Per.PER_SYS_PER_ADD)
	@RequestMapping(value = "perAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String perAdd(@ModelAttribute("example") ManagePer example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.addPer(example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
	@TagPer(Per.PER_SYS_PER_ADD)
	@RequestMapping(value = "perCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public String perCheck(@ModelAttribute("example") ManagePer example, BindingResult br,ModelMap mm, HttpSession ses, HttpServletRequest req) {
		mm.put("perNoDbList", manageSvs.checkPerNoDb());
		mm.put("rootPerForce", manageConfig.getRootPer());
		return perListPage(example, br, mm, ses, req);
	}
	
	@TagPer(Per.PER_SYS_PER_ADD)
	@RequestMapping(value = "perAddAutoPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String perAddAutoPage(@ModelAttribute("mpId") int  mpId, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			ManagePer mp = new ManagePer();
			Per p = Per.find(mpId);
			int rootId = Integer.valueOf(Per.ROOT.getCode());
			mp.setFatherMpId(rootId);
			mp.setFatherPer(managePerMpr.queryByMpId(rootId));
			mp.setPageUrl(p.getPageUrl());
			mp.setMpId(mpId);
			mp.setPerName(p.getName());
			mp.setSimDesc("");
			mm.put("example", mp);
			mm.put("fatherMpId",rootId);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/per/perAddAuto";
	}

	@TagPer(Per.PER_SYS_PER_EDIT)
	@RequestMapping(value = "perEditPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String perEditPage(int mpId, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			mm.put("example", managePerMpr.queryByMpId(mpId));
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/per/perEdit";
	}

	@TagPer(Per.PER_SYS_PER_EDIT)
	@RequestMapping(value = "perEdit", method = { RequestMethod.GET, RequestMethod.POST })
	public String perEdit(@ModelAttribute("example") ManagePer example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.editPer(example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}

	@TagPer(Per.PER_SYS_PER_EDIT)
	@RequestMapping(value = "perFatherIdEdit", method = { RequestMethod.GET, RequestMethod.POST })
	public String perFatherIdEdit(int mpId, int fatherId, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.editPer(mpId, fatherId);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
	@TagPer(Per.PER_SYS_USER_EDIT)
	@RequestMapping(value = "userImgPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String userImgPage(int muId, String headImg, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		ManageUser manageUser = manageUserMpr.queryByMuId(muId);
		if (headImg != null && headImg != "") {
			manageUser.setHeadImg(headImg);
		}
		try {
			mm.put("example", manageUser);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "manage/user/userImg";
	}
	
	@TagPer(Per.PER_SYS_USER_EDIT)
	@RequestMapping(value = "userImg", method = { RequestMethod.GET, RequestMethod.POST })
	public String userImg(@ModelAttribute("example") ManageUser example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			manageSvs.editUserImg(example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
}
