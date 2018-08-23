package com.syg.manage.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.syg.manage.base.BaseCtrl;
import com.syg.manage.dao.manage.HolidayMpr;
import com.syg.manage.exception.BaseException;
import com.syg.manage.model.manage.Holiday;
import com.syg.manage.util.ExcelUtil;

@Controller
@RequestMapping("import")
public class ImportCtrl extends BaseCtrl {
	
	@Resource
	private HolidayMpr holidayMpr;
	
	private final static Logger logger = LoggerFactory.getLogger(ImportCtrl.class);
	
	@RequestMapping(value = "checkDate", method = { RequestMethod.GET, RequestMethod.POST })
	public String checkDate(ModelMap mm, HttpSession ses, HttpServletRequest req, HttpServletResponse resp) {
		try {
			String logtimeStr = req.getParameter("logtime");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr2 = null;
			Date logtime = null;
			if (logtimeStr == null || logtimeStr.length() != 0) {
				logtime = sdf.parse(logtimeStr);
				sdf = new SimpleDateFormat("yyyyMMdd");
			    dateStr2 = sdf.format(logtime);
			}
			MultipartHttpServletRequest multipartRequest = null;
			try{
				multipartRequest = (MultipartHttpServletRequest) req;
			}catch(Exception e){
				throw new BaseException("请选择文件后导入");
			}
		    MultipartFile file = multipartRequest.getFile("excel");
		    String fileName = file.getOriginalFilename();
		    if(!fileName.contains(".xls") && !fileName.contains(".csv") ){
		    	throw new BaseException("请选择正确的文件格式");
		    }
		    Map<String, Object> map = checkFileName(fileName);
			Integer jjr = (Integer) map.get("jjr");
			if(jjr == 1){
				List<Holiday> list = holidayMpr.queryAll();
                if (list != null && list.size() > 0) {
                	throw new BaseException("数据已存在", ERR);
				}
			}
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
	@RequestMapping(value = "deleteAndImportExcel", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteAndImportExcel(ModelMap mm, HttpSession ses, HttpServletRequest req, HttpServletResponse resp) {
		Date logtime = null;
		try {
			String logtimeStr = req.getParameter("logtime");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (logtimeStr == null || logtimeStr.length() != 0) {
				logtime = sdf.parse(logtimeStr);
				sdf = new SimpleDateFormat("yyyyMMdd");
			}
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req; 
		    MultipartFile file = multipartRequest.getFile("excel");
		    String fileName = file.getOriginalFilename();
			Map<String, Object> map = checkFileName(fileName);
			Integer jjr = (Integer) map.get("jjr");
			if (jjr==1){
				holidayMpr.deleteAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return importExcel(mm, ses, req, resp);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "importExcel", method = { RequestMethod.GET, RequestMethod.POST })
	public String importExcel(ModelMap mm, HttpSession ses, HttpServletRequest req, HttpServletResponse resp) {
		try {
			String logtimeStr = req.getParameter("logtime");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date logtime = null;
			if (logtimeStr == null || logtimeStr.length() != 0) {
				logtime = sdf.parse(logtimeStr);
				sdf = new SimpleDateFormat("yyyyMMdd");
			}
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req; 
		    MultipartFile file = multipartRequest.getFile("excel");
		    String fileName = file.getOriginalFilename();
		    Map<String, Object> map = checkFileName(fileName);
			Integer jjr = (Integer)map.get("jjr");
			if(jjr==1){
				List<Holiday> ots = ExcelUtil.read("/importexcel/jjrImport.xml", Holiday.class, file);
				for (Holiday holiday : ots) {
					holidayMpr.insertItem(holiday);
				}
			}else {
				throw new BaseException("请检查文件名是否符合规则");
			}
			handleSuc(mm);
		} catch (Exception e) {
			e.printStackTrace();
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
	private Map<String, Object> checkFileName(String fileName) throws ParseException{
		Integer jjr = 0;
		String dateStr = null;
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		boolean multiDate = false;
		int start = fileName.indexOf("（");
		if (start == -1) {
			start = fileName.indexOf("(");
		}
	    int end = fileName.indexOf("）");
	    if (end == -1) {
	    	end = fileName.indexOf(")");
		}
	    if (start == -1 || end == -1) {
	    	int index = fileName.indexOf("_");
	    	if (fileName.indexOf("节假日") != -1){
				jjr = 1;
			}
		} else {
		    String platform = fileName.substring(start+1, end);
		    fileName = fileName.substring(end+1);
		    if (fileName.indexOf("千炮捕鱼") != -1) {
		    	
			}
		}
	    dateStr = fileName.substring(0, 8);
	    map.put("jjr", jjr);
	    if (multiDate) {
	    	dateStr = fileName.substring(0, 8);
			Date dateStart = sdf.parse(dateStr);
			dateStr = fileName.substring(9, 17);
			Date dateEnd = sdf.parse(dateStr);
			map.put("dateStart", dateStart);
			map.put("dateEnd", dateEnd);
		}
	    return map;
	}

}
