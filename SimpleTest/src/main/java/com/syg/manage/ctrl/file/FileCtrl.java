package com.syg.manage.ctrl.file;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.syg.manage.annotation.TagPer;
import com.syg.manage.base.BaseCtrl;
import com.syg.manage.cfg.Per;
import com.syg.manage.svs.data.IRechSvs;

@Controller
@RequestMapping("fileOperate")
public class FileCtrl extends BaseCtrl{

	@Resource
	private IRechSvs rechSvs;

	@TagPer(Per.PER_FUNC_FILEVIEW_PAGE)
	@RequestMapping(value="viewPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String viewPage(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			System.out.println(mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "file/list/view";
	}
	
	@TagPer(Per.PER_FUNC_FILEAPPEND_PAGE)
	@RequestMapping(value="appendPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String appendPage(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "file/list/append";
	}
	
	@TagPer(Per.PER_FUNC_FILEUPLOAD_PAGE)
	@RequestMapping(value="uploadPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String uploadPage(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "file/list/upload";
	}
	
	@RequestMapping(value="filePage",method={RequestMethod.GET,RequestMethod.POST})
	public String ajaxPerpareUpload(ModelMap mm,HttpSession ses,HttpServletRequest req) {
		try{	
			handleSuc(mm);
		} catch (Exception e) {
	    	handleErr(mm , e);
	    } 
		return "file/list/uploadPage";
	}
	
}
