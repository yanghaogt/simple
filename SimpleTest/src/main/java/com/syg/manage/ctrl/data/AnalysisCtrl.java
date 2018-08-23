package com.syg.manage.ctrl.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.syg.manage.annotation.TagPer;
import com.syg.manage.base.BaseCtrl;
import com.syg.manage.cfg.Per;

@Controller
@RequestMapping("analysis")
public class AnalysisCtrl extends BaseCtrl{

	@TagPer(Per.PER_DATA_ANALYSIS_DATA)
	@RequestMapping(value="analysisListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String analysisListPage(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/analysis/analysisListPage";
	}
	
	@RequestMapping(value="analysisJson",method ={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String analysisJson(ModelMap mm, HttpSession ses, HttpServletRequest req){
		Map<String, String> resMap = new HashMap<String, String>();
		try {
			resMap.put("url", "http://192.168.120.84:8080/file");
			resMap.put("serverName", "11251");
			resMap.put("localName", "1.jpg");
			resMap.put("packageSize", "128");
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON.toJSONString(resMap);
	}
	
	@RequestMapping(value="analysisHtml",method ={RequestMethod.GET,RequestMethod.POST})
	public String analysisHtml(ModelMap mm, HttpSession ses, HttpServletRequest req){
		Map<String, String> resMap = new HashMap<String, String>();
		try {
			resMap.put("url", "http://192.168.120.84:8080/file");
			resMap.put("serverName", "11251");
			resMap.put("localName", "1.jpg");
			resMap.put("packageSize", "128");
			mm.put("data", JSON.toJSONString(resMap));
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "json/uploadRes";
	}
}
