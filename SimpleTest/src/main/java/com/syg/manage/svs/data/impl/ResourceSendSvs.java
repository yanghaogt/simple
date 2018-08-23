package com.syg.manage.svs.data.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.syg.manage.constant.Constant;
import com.syg.manage.dao.manage.ResourceSendMapper;
import com.syg.manage.model.entity.RoleItem;
import com.syg.manage.model.manage.ResourceSend;
import com.syg.manage.pagination.Pagination;
import com.syg.manage.util.Excel;
import com.syg.manage.util.ExcelUtil;

@Service
public class ResourceSendSvs {
	
	private final static Logger log = LoggerFactory.getLogger(ResourceSendSvs.class);
	@Resource
	private ResourceSendMapper resourceSendMapper;
	
	public int save(ResourceSend resourceSend){
		return resourceSendMapper.insert(resourceSend);
	}
	
	public ResourceSend getById(@Param("id")Integer id){
		return resourceSendMapper.selectByPrimaryKey(id);
	}
	 
	public List<ResourceSend> getResourceSendListPage(Pagination page,ResourceSend example){
		return resourceSendMapper.queryListPageSearch(page, example);
	}
	
	public int  updateStatusById(@Param("id")Integer id, @Param("status")Integer status,String approvalName){
		return resourceSendMapper.updateStatusById(id, status, new Date(),approvalName);
	}
	
	public int  updateStatus(@Param("id")Integer id, @Param("status")Integer status,String approvalName,String operationDesc){
		return resourceSendMapper.updateStatus(id, status, new Date(),approvalName,operationDesc);
	}

	public void resourceSend(ResourceSend rs,StringBuffer serMsg,StringBuffer sucMsg,StringBuffer errMsg){
		String sendLog = "成功:"+sucMsg.toString()+"失败:"+serMsg.toString();
		if (errMsg.length() >0) {
			sendLog += "玩家:"+errMsg.toString();
			if (errMsg.toString().equals("个别")) {
				resourceSendMapper.updateResourceSend(rs.getId(), Constant.ApplyStatus.SINGLE, new Date(),null,sendLog);
			}else if(errMsg.toString().equals("一半")){
				resourceSendMapper.updateResourceSend(rs.getId(), Constant.ApplyStatus.HALF, new Date(),null,sendLog);
			}else if(errMsg.toString().equals("全部")){
				resourceSendMapper.updateResourceSend(rs.getId(), Constant.ApplyStatus.ALL, new Date(),null,sendLog);
			}else if(errMsg.toString().equals("异常")){
				resourceSendMapper.updateResourceSend(rs.getId(), Constant.ApplyStatus.GAME_SERVER_HANDLE_FAILURE, new Date(),null,sendLog);
			}else {
				resourceSendMapper.updateResourceSend(rs.getId(), Constant.ApplyStatus.NETERR, new Date(),null,sendLog);
			}
		}else {
			resourceSendMapper.updateResourceSend(rs.getId(), Constant.ApplyStatus.SENDED, new Date(),null,sendLog);
		}
	}

	public int saveGroup(ResourceSend resourceSend,JSONArray roleArray){
		if (roleArray.size()>0) {
			List<RoleItem> users = new ArrayList<>();
			for(int i=0;i<roleArray.size();i++){
				JSONArray j = roleArray.getJSONArray(i);
				if(j !=null && !j.get(0).equals("") && !j.get(1).equals("")){
					String serverId=String.valueOf(j.get(0));
					if (serverId.contains(".")) {
						serverId = serverId.replace(".0", "");
					}
					RoleItem item = new RoleItem();
					item.setServerId(Integer.parseInt(serverId));
					item.setRoleName(String.valueOf(j.get(1)));
					users.add(item);
				}
			}
			Map<Integer, Integer> group = new HashMap<>();
			Map<Integer, List<String>> groupCon = new HashMap<>();
			List<RoleItem> userList = new ArrayList<>();
			List<String> nameList = new ArrayList<>();
			List<Map<Integer, List<String>>> groupRes = new ArrayList<>();
			long st = System.currentTimeMillis();
			for (RoleItem u : users) {
				if (!group.containsKey(u.getServerId())) {
					group.put(u.getServerId(), u.getServerId());
				}
			}
			for (Integer server : group.keySet()) {
				for (RoleItem u : users) {
					if (server.equals(u.getServerId())) {
						userList.add(u);
					}
				}
				for (int i = 0; i < userList.size(); i++) {
					RoleItem u = userList.get(i);
					if(u.getServerId().equals(server) && nameList.size() < 30){
						nameList.add(u.getRoleName());
					}
					if (nameList.size() == 30) {
						groupCon.put(server, nameList);
						groupRes.add(groupCon);
						nameList=new ArrayList<>();
						groupCon=new HashMap<>();
					}else if (i == userList.size()-1) {
						groupCon.put(server, nameList);
						groupRes.add(groupCon);
						nameList=new ArrayList<>();
						groupCon=new HashMap<>();
					}
				}
				userList.clear();;
			}
			for (Map<Integer, List<String>> map : groupRes) {
				for (Integer serverId : map.keySet()) {
					List<String> names = map.get(serverId);
					String roles = StringUtils.join(names.toArray(),",");
					resourceSend.setServerId(String.valueOf(serverId));
				    resourceSend.setAcceptRoleList(roles);
				    resourceSendMapper.insert(resourceSend);
				}
			}
			long sd = System.currentTimeMillis();
			log.info("import database:{}",(sd-st));
		}
		return 1;
	}
	
	public int saveBatch(ResourceSend resourceSend,JSONArray roleArray){
		if (roleArray.size()>0) {
			List<RoleItem> users = new ArrayList<>();
			for(int i=0;i<roleArray.size();i++){
				JSONArray j = roleArray.getJSONArray(i);
				if(j !=null && !j.get(0).equals("") && !j.get(1).equals("")){
					String serverId=String.valueOf(j.get(0));
					if (serverId.contains(".")) {
						serverId = serverId.replace(".0", "");
					}
					RoleItem item = new RoleItem();
					item.setServerId(Integer.parseInt(serverId));
					item.setRoleName(String.valueOf(j.get(1)));
					users.add(item);
				}
			}
			if (users.size() > 0) {
				int dataLimit = 500;//限制条数
				Integer dataSize = users.size();
				int part = dataSize/dataLimit;//分批数
				log.info("list size:{},批次为:{}",dataSize,part);
				for (int i = 0; i <= part; i++) {
					int maxSize=dataLimit*(i+1);
					if (i==part || maxSize == dataSize) {
						maxSize = dataSize;
					}
					if (maxSize > i*dataLimit) {
						List<RoleItem> listpart = users.subList(i*dataLimit, maxSize);
						resourceSendMapper.insertBatch(resourceSend, listpart);
					}
				}
			}
		}
		return 1;
	}
	
	public void exportResourceSendList(HttpServletResponse resp, List<ResourceSend> list){
		Excel[] excel = new Excel[2];
		excel[0] = new Excel(1, 25, "serverId", "serverId");
		excel[1] = new Excel(2, 25, "acceptRoleList", "roleName");
		ExcelUtil.createExcelLarge(excel, list, ResourceSend.class, "玩家列表", resp);
	}
	
}
