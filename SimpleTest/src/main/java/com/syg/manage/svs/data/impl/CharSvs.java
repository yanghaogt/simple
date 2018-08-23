package com.syg.manage.svs.data.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.syg.manage.dao.manage.SummaryNewAddUserMpr;
import com.syg.manage.model.manage.DataParameters;
import com.syg.manage.model.manage.SummaryNewAddUser;
import com.syg.manage.pagination.Pagination;
import com.syg.manage.svs.data.ICharSvs;
import com.syg.manage.util.DateUtil;

@Service
public class CharSvs implements ICharSvs{
	
	private final static Logger logger = LoggerFactory.getLogger(CharSvs.class);
	
	@Resource
	private SummaryNewAddUserMpr summaryNewAddUserMpr;
	
	@Override
	public Map<String, Object> searchSummaryNewAddUser(SummaryNewAddUser example, Integer type, String dateType,ModelMap mm) {
		if(dateType==null||"".equals(dateType)){
			dateType="day";
		}
		Map<String,Object> data = new HashMap<>();
		List<String> date = new ArrayList<>();
		List<Integer> number = new ArrayList<>();
		List<Map<String,Object>> dataList = new ArrayList<>();
		List<SummaryNewAddUser> items =searchSummaryNewAddUserList(example, dateType, mm);
		String timeStr = getCategory(example);
		if(items != null && items.size() > 0){
			switch (type) {
			case 0://新增用户
				for (SummaryNewAddUser addUser : items) {
					number.add(addUser.getNewAddUser());
					if(dateType.equals("day")){
						date.add(addUser.getDateStr());
					}else {
						String dateStr = addUser.getDate();
						int index = getStrIndex(dateStr, "~");
						String myDate = dateStr.substring(0, index);
						date.add(myDate);
					}
				}
				break;
			case 1://新增账号
				for (SummaryNewAddUser addUser : items) {
					number.add(addUser.getNewAddAccount());
					if(dateType.equals("day")){
						date.add(addUser.getDateStr());
					}else {
						String dateStr = addUser.getDate();
						int index = getStrIndex(dateStr, "~");
						String myDate = dateStr.substring(0, index);
						date.add(myDate);
					}
				}
				break;
			default:
				break;
			}
		}
		putData(dataList, timeStr, number);
		data.put("type", type);
		data.put("time", date);
		data.put("data", dataList);
		return data;
	}

	@Override
	public List<SummaryNewAddUser> searchSummaryNewAddUserList(SummaryNewAddUser example, String dateType, ModelMap mm) {
		if(example.getGameVersion() == null){
			example.setGameVersion("--");
		}
		if(example.getChannelId() == null){
			example.setChannelId("--");
		}
		if(example!=null&&example.getLogTimeSh()!=null){
			Date beginDate = example.getLogTimeSh().getBegin();
			Date endDate = example.getLogTimeSh().getEnd();
			int daySub = DateUtil.daySub(endDate, beginDate);
			if(daySub>=7&&daySub<30){
				if(mm!=null){
					mm.addAttribute("dateType", "week");
				}
			}else if(daySub>=30){
				if(mm!=null){
					mm.addAttribute("dateType", "month");
				}
			}else {
				if(mm!=null){
					mm.addAttribute("dateType", "day");
				}
			}
		}
		List<SummaryNewAddUser> list=summaryNewAddUserMpr.querySumSearch(example);
		List<SummaryNewAddUser> addUsers = new ArrayList<>();
		if(dateType!=null&&"week".equals(dateType)){
			//周处理
			//getData_week(list, example, addUsers);
		}else if(dateType!=null&&"month".equals(dateType)){
			//月处理
			//getData_month(list, example, addUsers);
		}else {
			return list;
		}
		return addUsers;
	}
	
	@Override
	public void searchSummaryNewAddUserPageList(SummaryNewAddUser example,String dateType, ModelMap mm, Pagination page) {
		if(example.getGameVersion() == null){
			example.setGameVersion("--");
		}
		if(example.getChannelId() == null){
			example.setChannelId("--");
		}
		if(example!=null&&example.getLogTimeSh()!=null){
			Date beginDate = example.getLogTimeSh().getBegin();
			Date endDate = example.getLogTimeSh().getEnd();
			int daySub = DateUtil.daySub(endDate, beginDate);
			String dateTypeStr="";
			if(daySub>=7&&daySub<30){
				if("month".equals(dateType)){
					dateType="week";
				}
				dateTypeStr="week";
			}else if(daySub>=30){
				dateTypeStr="month";
			}else {
				dateTypeStr="day";
				if("week".equals(dateType)||"month".equals(dateType)){
					dateType="day";
				}
			}
			if(mm!=null){
				mm.addAttribute("dateType", dateTypeStr);
			}
		}
		List<SummaryNewAddUser> list=summaryNewAddUserMpr.querySumSearch(example);
		int size = list.size();
		int currentPage = page.getCurrentPage();
		int showCount = page.getShowCount();
		int fromIndex = currentPage*showCount;
		int toIndex = (currentPage+1)*showCount;
		if(size>0){
			if(fromIndex>=0&&toIndex<=size&&fromIndex<=toIndex){
				page.getItems().addAll(list.subList(currentPage*showCount, (currentPage+1)*showCount));
			}else {
				page.getItems().addAll(list.subList(fromIndex, size));
			}
		}
	}

	@Override
	public void addUserExportExcel(SummaryNewAddUser example, String dateType,Pagination pagination, String fileName, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	/**
	 * 存放map数据
	 * @param list
	 * @param name
	 * @param data
	 */
	public void putData(List<Map<String, Object>> list,String name,List<?> data){
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("data", data);
		list.add(map);
	}
	
	/**
	 * 截取时间
	 * @param str
	 * @param searchStr
	 * @return
	 */
	public int getStrIndex(String str,String searchStr){
	      int intIndex = str.indexOf(searchStr);
	      if(intIndex == - 1){
	    	  logger.info("not found");
	      }
	      return intIndex;
	}
	
	/**
	 * 获取时间段
	 * @param example
	 * @param map
	 */
	public String getCategory(DataParameters example){
		String timeBegin = DateUtil.dateFormatString(example.getLogTimeSh().getBegin());
		String timeEnd = DateUtil.dateFormatString(example.getLogTimeSh().getEnd());
		if(timeBegin.equals(timeEnd)){
			return timeBegin;
		}else{
			return timeBegin+" 至"+timeEnd;
		}
	}
	
}
