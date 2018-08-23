package com.syg.manage.ctrl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.mchange.v1.util.ArrayUtils;
import com.syg.manage.annotation.TagJson;
import com.syg.manage.base.BaseCtrl;
import com.syg.manage.cfg.GlobalConfig;
import com.syg.manage.model.entity.Progress;
import com.syg.manage.model.entity.SesUser;
import com.syg.manage.svs.data.IAttachmentSvs;
import com.syg.manage.util.SesHelper;

@Controller
@RequestMapping("fileUpload")
public class UploadCtrl extends BaseCtrl{
	/** 部分视频拓展名（缺少请自行补充） **/
	public static final String[] MOV_EXTS = new String[]{"mpg", "mlv", "mpe", "mpeg", "dat", "m2v", "vob", "tp", "ts", "avi", "rm", "ra", "ram", "swf", "flv", "asf", "3gp", "wmv", "wmp", "rmvb", "rpm", "rt", "rp"};
	/** 部分图片拓展名（缺少请自行补充） **/
	public static final String[] IMG_EXTS = new String[]{"tiff", "psd", "eps", "raw", "pdf", "png", "pxr", "mac", "jpg", "bmp", "tga", "vst", "pcd", "pct", "gif", "ai", "fpx", "img", "cal", "wi", "png", "eps", "ai", "sct", "pdf", "pdp", "dxf","jpeg"};
	/** 可压缩的图片类型*/
	public static final String[] IMG_COMP_EXTS = new String[]{"bmp", "jpeg","jpg"};
	@Resource
	private IAttachmentSvs attachmentSvs;
	
	@RequestMapping(value="uploadAny",method={RequestMethod.GET,RequestMethod.POST})
	public String uploadAny(ModelMap mm,HttpSession ses,HttpServletRequest req) throws Exception {
		try {
			String url=GlobalConfig.getDef().getValue("slot_web_apps");
			// 获得文件：
	        MultipartFile upload = ((MultipartHttpServletRequest) req).getFile("uploadFile");
			String newFileName = new Date().getTime() + getExtention(upload.getOriginalFilename());
			CommonsMultipartFile cf= (CommonsMultipartFile)upload;
	        String fileName = cf.getOriginalFilename();
			File targetFile = new File(url, newFileName);
	        if(!targetFile.exists()){
	            targetFile.mkdirs();
	        }
	        cf.transferTo(targetFile);
	        attachmentSvs.insert(1, 168, newFileName, fileName, 1, "", 1, new Date());
	        Map<String, String> resMap = new HashMap<String, String>();
			resMap.put("url", "http://192.168.120.84:8080/file/"+newFileName);
			resMap.put("serverName", newFileName);
			resMap.put("localName", upload.getOriginalFilename());
			resMap.put("packageSize", upload.getSize()+"");
			mm.put("data", JSON.toJSONString(resMap));
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm , e);
		}
		return "json/uploadRes";
	}
	
	@RequestMapping(value="commonUploadPage",method={RequestMethod.GET,RequestMethod.POST})
	public String commonUploadPage(ModelMap mm,HttpSession ses,HttpServletRequest req){
		String resUrl = null;
		try{
			resUrl = reqStr("resUrl",  req);
			String serverType= reqStr("serverType", req);
			int maxSize = reqIntDef("maxSize", req);
			String jsCallBackFun = reqStr("jsCallBackFun", req);
			mm.put("serverType", serverType);
			mm.put("maxSize", maxSize);
			mm.put("jsCallBackFun", jsCallBackFun);
			handleSuc(mm);
		} catch (Exception e) {  
	    	handleErr(mm , e);
	    } 
		if(resUrl != null && !"".equals(resUrl.trim())) return resUrl;
		return "common/commonUpload";
	}
	
	@RequestMapping(value="uploadPct",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Progress uploadPct(HttpSession session){
		SesUser sesUser = SesHelper.getSimUser(session);
		Progress status =null;
		if(sesUser!=null){
			status = sesUser.getProgress();
			if(status!=null&&(status.getpBytesRead()==status.getpContentLength())){
				sesUser.setProgress(null);
			}
		}
        return status;
	}
	
	@RequestMapping(value="commonManyUpload",method={RequestMethod.GET,RequestMethod.POST})
	public String commonManyUpload(ModelMap mm,HttpSession ses,HttpServletRequest req){
		String resUrl = null;
		try{
			resUrl = reqStr("resUrl",  req);
			String serverType= reqStr("serverType", req);
			int maxSize = reqIntDef("maxSize", req);
			String jsCallBackFun = reqStr("jsCallBackFun", req);
			mm.put("serverType", serverType);
			mm.put("maxSize", maxSize);
			mm.put("jsCallBackFun", jsCallBackFun);
			handleSuc(mm);
		} catch (Exception e) {  
	    	handleErr(mm , e);
	    } 
		if(resUrl != null && !"".equals(resUrl.trim())) return resUrl;
		return "msite/common/commonManyUpload";
	}
	
	/** 得到文件的扩展名*/
	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	private static boolean checkIsType(String fileName,String[] types){
		return ArrayUtils.indexOf(types, getExtention(fileName).substring(1))!=-1;
	}
}
