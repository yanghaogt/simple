package com.syg.manage.ctrl.data;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.syg.manage.annotation.TagPer;
import com.syg.manage.base.BaseCtrl;
import com.syg.manage.cfg.Per;
import com.syg.manage.constant.Constant;
import com.syg.manage.dao.manage.ResourceSendMapper;
import com.syg.manage.dao.manage.ServerMapper;
import com.syg.manage.exception.BaseException;
import com.syg.manage.job.CreateTableJob;
import com.syg.manage.model.game.Activity;
import com.syg.manage.model.manage.Cdkey;
import com.syg.manage.model.manage.Holiday;
import com.syg.manage.model.manage.Point;
import com.syg.manage.model.manage.PointMap;
import com.syg.manage.model.manage.RedisUser;
import com.syg.manage.model.manage.ResourceSend;
import com.syg.manage.pagination.Pagination;
import com.syg.manage.svs.data.IRechSvs;
import com.syg.manage.svs.data.impl.ResourceSendSvs;
import com.syg.manage.util.ExcelTools;
import com.syg.manage.util.dataSource.ActivitySvs;

@Controller
@RequestMapping("data")
public class RechCtrl extends BaseCtrl {
	
	private final static Logger logger = LoggerFactory.getLogger(RechCtrl.class);
	@Resource
	private IRechSvs rechSvs;
	@Resource
	private ServerMapper serverMapper;
	@Resource
	ActivitySvs activitySvs;
	@Resource
	ResourceSendSvs resourceSendSvs;
	@Resource
	private ResourceSendMapper resourceSendMapper;
	@Resource
	private CreateTableJob createTableJob;
	
	@TagPer(Per.PER_DATA_LIST_PAGE)
	@RequestMapping(value="cdkeyListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String cdkeyListPage(@ModelAttribute("example") Cdkey example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/dataList";
	}
	
	@TagPer(Per.PER_DATA_LIST_PAGE)
	@RequestMapping(value="cdkeyList",method ={RequestMethod.GET,RequestMethod.POST})
	public String cdkeyList(@ModelAttribute("example") Cdkey example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			rechSvs.searchCdkey(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/dataList";
	}
	
	@TagPer(Per.PER_DATA_FIX_PAGE)
	@RequestMapping(value="pointListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String cdkeyListPage(@ModelAttribute("example") Point example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/pointList";
	}
	
	@TagPer(Per.PER_DATA_FIX_PAGE)
	@RequestMapping(value="pointList",method ={RequestMethod.GET,RequestMethod.POST})
	public String cdkeyList(@ModelAttribute("example") Point example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			rechSvs.searchPoint(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/pointList";
	}
	
	@TagPer(Per.PER_DATA_MAP_PAGE)
	@RequestMapping(value="mapListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String mapListPage(@ModelAttribute("example") PointMap example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/mapList";
	}
	
	@TagPer(Per.PER_DATA_MAP_PAGE)
	@RequestMapping(value="mapList",method ={RequestMethod.GET,RequestMethod.POST})
	public String pointListMap(@ModelAttribute("example") PointMap example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			rechSvs.searchPointMap(pageList(req, mm), example);
			mm.put("mapPayType", getPayType());
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/mapList";
	}
	
	@TagPer(Per.PER_DATA_EXPORT_PAGE)
	@RequestMapping(value="exportListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String exportListPage(@ModelAttribute("example") Cdkey example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/exportList";
	}
	
	@TagPer(Per.PER_DATA_EXPORT_PAGE)
	@RequestMapping(value="exportList",method ={RequestMethod.GET,RequestMethod.POST})
	public String exportList(@ModelAttribute("example") Cdkey example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			rechSvs.searchCdkey(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/exportList";
	}
	
	@RequestMapping(value = "makeCdkeyExcel", method = { RequestMethod.GET, RequestMethod.POST })
	public String makeCdkeyExcel(@ModelAttribute("example") Cdkey example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req, HttpServletResponse resp) {
		try {
			rechSvs.createCdkeyExcel(example, resp);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return null;
	}
	
	@TagPer(Per.PER_DATA_IMPRORT_PAGE)
	@RequestMapping(value="importPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String importPage(@ModelAttribute("example") Cdkey example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/importPage";
	}
	
	@TagPer(Per.PER_DATA_HOLIDAY_PAGE)
	@RequestMapping(value="holidayListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String holidayListPage(@ModelAttribute("example") Holiday example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/holidayList";
	}
	
	@TagPer(Per.PER_DATA_HOLIDAY_PAGE)
	@RequestMapping(value="holidayList",method ={RequestMethod.GET,RequestMethod.POST})
	public String holidayList(@ModelAttribute("example") Holiday example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			rechSvs.searchHoliday(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/holidayList";
	}
	
	@TagPer(Per.PER_DATA_AJAX_PAGE)
	@RequestMapping(value="ajaxListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String ajaxListPage(@ModelAttribute("example") Cdkey example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/ajaxList";
	}
	
	@TagPer(Per.PER_DATA_AJAX_PAGE)
	@RequestMapping(value="ajaxListTable",method ={RequestMethod.GET,RequestMethod.POST})
	public String ajaxList(@ModelAttribute("example") Cdkey example,BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			rechSvs.searchCdkey(pageList(req, mm), example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/ajaxListTable";
	}
	
	@TagPer(Per.PER_DATA_LIST_CACHE)
	@RequestMapping(value="cacheListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String cacheListPage(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/cacheList";
	}
	
	@TagPer(Per.PER_DATA_LIST_REDIS)
	@RequestMapping(value="redisListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String redisListPage(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/redisListPage";
	}
	
	@TagPer(Per.PER_DATA_LIST_REDIS)
	@RequestMapping(value="redisList",method ={RequestMethod.GET,RequestMethod.POST})
	public String redisList(String Id,ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			rechSvs.searchUser(Id, mm);
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/redisListPage";
	}
	
	@TagPer(Per.PER_DATA_LIST_REDIS)
	@RequestMapping(value="redisAddPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String redisAddPage(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/redisAddPage";
	}
	
	@TagPer(Per.PER_DATA_LIST_REDIS)
	@RequestMapping(value = "userAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String userAdd(@ModelAttribute("example") RedisUser example, BindingResult br, ModelMap mm, HttpSession ses, HttpServletRequest req) {
		try {
			rechSvs.addUser(example);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
	@TagPer(Per.PER_DATA_LIST_SWDB)
	@RequestMapping(value="switchDBPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String switchDBPage(@ModelAttribute("example") Activity example,BindingResult br,ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			mm.put("serverList",  serverMapper.getList());
			pageList(req, mm);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/switchDbList";
	}
	
	@TagPer(Per.PER_DATA_LIST_SWDB)
	@RequestMapping(value="switchDB",method ={RequestMethod.GET,RequestMethod.POST})
	public String switchDB(@ModelAttribute("example") Activity example,BindingResult br,ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			Pagination page = pageList(req, mm);
			Integer serverId = example.getServerId();
			Activity ac = new Activity();
			List<Activity> list = activitySvs.select(ac, serverId);
			page.getItems().addAll(list);
			mm.put("serverList",  serverMapper.getList());
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/switchDbList";
	}
	
	@TagPer(Per.PER_DATA_LIST_BATCH)
	@RequestMapping(value="batchListPage",method ={RequestMethod.GET,RequestMethod.POST})
	public String batchListPage(@ModelAttribute("example") ResourceSend example,BindingResult br,ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			Pagination page = pageList(req, mm, 100);
			page.getItems().addAll(resourceSendSvs.getResourceSendListPage(page, example));
			mm.put("applyMap", getApplyStatusMap());
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/batchList";
	}
	
	@TagPer(Per.PER_DATA_LIST_BATCH)
	@RequestMapping(value="batchList",method ={RequestMethod.GET,RequestMethod.POST})
	public String batchList(@ModelAttribute("example") ResourceSend example,BindingResult br,ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			Pagination page = pageList(req, mm, 100);
			page.getItems().addAll(resourceSendSvs.getResourceSendListPage(page, example));
			mm.put("applyMap", getApplyStatusMap());
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return "data/list/batchList";
	}
	
	@TagPer(Per.PER_DATA_LIST_BATCH)
	@RequestMapping(value = "batchAddPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String batchAddPage(@ModelAttribute("example") ResourceSend example ,BindingResult br, ModelMap mm, HttpServletRequest req){
		mm.put("example", example);
		return "data/list/batchAdd";
	}
	
	@TagPer(Per.PER_DATA_LIST_BATCH)
	@RequestMapping(value = "batchAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String batchAdd(@ModelAttribute("example")ResourceSend example ,BindingResult br,ModelMap mm, HttpServletRequest req,HttpSession ses){
		try {		
			example.setCreateTs(new Date());
			example.setChannelId("0");
			example.setStatus(1);
			if(req instanceof MultipartHttpServletRequest){
				long st = System.currentTimeMillis();
				MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) req;
				Iterator<String> it = mReq.getFileNames();
				while(it.hasNext()){
					String fileName = it.next();
					logger.info("{}",fileName);
					MultipartFile file = mReq.getFile(fileName);
					InputStream is = file.getInputStream();
					logger.info("{}",file.getOriginalFilename());
					JSONArray roleArray = ExcelTools.readExcel(file.getOriginalFilename(), is);
					logger.info("resSend|import roleName:{}",roleArray);
					resourceSendSvs.saveBatch(example, roleArray);
				}
				long pd = System.currentTimeMillis();
				logger.info("parse use:{}",pd-st);
			}						
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
	@TagPer(Per.PER_DATA_LIST_BATCH)
	@RequestMapping(value = "sendBatch", method = { RequestMethod.GET, RequestMethod.POST })
	public String sendBatch(String[] ids,@ModelAttribute("example")ResourceSend example ,BindingResult br,ModelMap mm, HttpServletRequest req,HttpSession ses){
		try {
			if (ids == null || ids.equals("")) {
				throw new BaseException("请选中批次");
			}
			String idStr = StringUtils.join(ids,",");
			logger.info("approve ids:{}",idStr);
			ResourceSend send = resourceSendMapper.selectByIds(idStr);
			if (send != null) {
				throw new BaseException("请选择已审批的");
			}
			List<Integer> idList = new ArrayList<>();
			for (String aprId : ids) {
				idList.add(Integer.valueOf(aprId));
			}
			example.setStatus(Constant.ApplyStatus.SENDED);
			example.setApprovalName("root");
			example.setUpdateTs(new Date());
			resourceSendMapper.updateBatch(example, idList);
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
	@RequestMapping(value = "createTable", method = { RequestMethod.GET, RequestMethod.POST })
	public String newUser(ModelMap mm, HttpSession ses, HttpServletRequest req){
		try {
			long ps = System.currentTimeMillis();
			createTableJob.createTable();
			long ed = System.currentTimeMillis();
			mm.put("data", "used:"+(ed - ps)+"ms");
			handleSuc(mm);
		} catch (Exception e) {
			handleErr(mm, e);
		}
		return JSON_COM;
	}
	
	
	private Map<Integer, String> getPayType(){
		Map<Integer, String> retMap = new HashMap<>();
		retMap.put(1, "新易联");
		retMap.put(2, "支付宝");
		retMap.put(3, "微信");
		retMap.put(4, "财付通");
		retMap.put(5, "网银");
		return retMap;
	};
	
	private Map<Integer, String> getApplyStatusMap(){
		Map<Integer, String> retMap = new HashMap<>();
		retMap.put(0, "审核中");
		retMap.put(1, "审核通过");
		retMap.put(2, "审核未通过");
		retMap.put(3, "已经发送");
		return retMap;
	};
	
}
