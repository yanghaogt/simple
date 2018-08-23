package com.syg.manage.ctrl.data;

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
import com.syg.manage.cfg.Per;
import com.syg.manage.model.manage.Mail;
import com.syg.manage.svs.data.IRechSvs;

@Controller
@RequestMapping("mail")
public class MailCtrl extends BaseCtrl{
	
	@Resource
	private IRechSvs rechSvs;

	@TagPer(Per.PER_DATA_MAIL_SEND)
	@RequestMapping(value="mailListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String analysisListPage(@ModelAttribute("example") Mail example,BindingResult br,ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			rechSvs.searchMail(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/mail/mailListPage";
	}
	 
	@TagPer(Per.PER_DATA_MAIL_SEND)
	@RequestMapping(value="mailList",method ={RequestMethod.GET,RequestMethod.POST})
	public String mailList(@ModelAttribute("example") Mail example,BindingResult br,ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			rechSvs.searchMail(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/mail/mailListPage";
	}
	
	
	@TagPer(Per.PER_DATA_MAIL_SEND)
	@RequestMapping(value="mailAddPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String redisAddPage(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/mail/mailAddPage";
	}
	
	@TagPer(Per.PER_DATA_MAIL_SEND)
	@RequestMapping(value = "mailAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String userAdd(@ModelAttribute("example") Mail example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			rechSvs.addMail(example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
}
