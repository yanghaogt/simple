package com.syg.manage.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.syg.common.HttpHelper;
import com.syg.manage.cfg.GlobalConfig;
import com.syg.manage.exception.BaseException;

public class Interface {

	public void post(){
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("groupId", "1");
		paramMap.put("gameName", "你好");
		String res = HttpHelper.post(GlobalConfig.getDef().getValue("slot_server_add_game"), paramMap);
		//AppInfoRes resApp = JSON.parseObject(res, AppInfoRes.class);
	}
	
	@RequestMapping(value = "addGame", method = { RequestMethod.GET, RequestMethod.POST },produces={"text/html;charset=UTF-8"})
	@ResponseBody
	public String addGame(HttpServletRequest request,HttpServletResponse response) {
		Map<String, String> resMap = new HashMap<String, String>();
		try {
			//String groupId = reqStr("groupId",request);
			//String gameName = reqStr("gameName",request);
			//json = slotSvs.addGame(groupId,gameName);
			resMap.put("ret", "S");
			resMap.put("msg", "记录成功");
		} catch (Exception e) {
			resMap.put("ret", "E");
			resMap.put("msg", e.getMessage());
		}
		return JSON.toJSONString(resMap);
	}
	
	public void collect(){
//		String getUrl = "";
//		String retJson = "";
//		String status = "";
//		JSONArray datas = new JSONArray();
//		Long ps = System.currentTimeMillis();
//		try {
//			getUrl = GlobalConfig.getDef().getValue("slot_login_url");
//			OrgLogTask task = orgLogTaskMpr.queryTask(org_login_log);
//			String content = "?logTime="+task.getLogId()+"&status="+next;
//			getUrl += content;
//			retJson = RemoteHttpUtil.urlGet(getUrl);
//			JSONObject jmap = JSONObject.parseObject(retJson);
//			status = jmap.getString("status");
//			datas = JSONArray.parseArray(jmap.getString("datas"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if(datas != null && datas.size() > 0){
//			for(int i=0;i<datas.size();i++){
//				JSONObject jobj =  (JSONObject) datas.get(i);
//				String serverId			= jobj.getString("serverId");
//				String serverName		= jobj.getString("serverName");
//				String guildId			= jobj.getString("guildId");
//				String guildLevel		= jobj.getString("guildLevel");
//				String guildName		= jobj.getString("guildName");
//				String guildLeader		= jobj.getString("guildLeader");
//				String extraData		= jobj.getString("extraData");
//				try {
//					logBaseSvs.saveLoginLog(logIp, logTime, gameId, gameVer, gameCh, deviceNum);
//					OrgLogTask task = new OrgLogTask();
//					task.setLogKind(org_login_log);
//					task.setLogId(jobj.getString("logTime"));
//					task.setUpdateTime(new Date());
//					orgLogTaskMpr.updateTask(task);
//				} catch (BaseException e) {
//					e.printStackTrace();
//					logger.error("error msg:{}",e.getMessage());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
	
	public void post(String result,JSONObject json,List<Integer> errorServerIds,StringBuffer errorMsg,String serverUrl,Integer key,String sign){
		Long l1 = System.currentTimeMillis();
		try {
			result =  HttpHelper.post(serverUrl,sign+"&"+json.toJSONString());
			if(result != null && !"".equals(result)){
				JSONObject jo = JSONObject.parseObject(result);
				int jsonRult = jo.getIntValue("rep");//成功返回1，失败返回0
				if(jsonRult==1){
//					logger.info("serverId:"+key+"suc"+(System.currentTimeMillis() - l1)+"ms");
				}else {
					throw new BaseException(jo.getString("msg"));//返回信息
				}
			}else{
				throw new BaseException("服务器返回信息为空!");
			}
		} catch (Exception e) {
			errorServerIds.add(key);
			errorMsg.append("serverId:"+key+","+e.getMessage()).append(";");
//			logger.warn("serverId:"+key+"fail"+e.getMessage()+(System.currentTimeMillis() - l1)+"ms");
		}
	}
	
	
	public static String getSign(Map<String, String> params, String privateKey){
		try {
			ArrayList<String> strList = new ArrayList<>();
	        for (String key : params.keySet()) {
	        	if (params.get(key) != null && !params.get(key).equals("")) {
	        		if(!"sign".equalsIgnoreCase(key)){
		        		strList.add(key + "=" + params.get(key));
		            }
				}
	        }
	        Collections.sort(strList);
	        String[] a = new String[strList.size()];
//	        String signStr = StringUtils.join(strList.toArray(a),"&");
//	        String md5Str = signStr+"&key="+privateKey;
//	        logger.info("coco签名原串："+md5Str);
//	        return Md5Util.getMD5(md5Str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String signMethod(JSONObject json, String key) {
		StringBuffer buffer = new StringBuffer();
		for (String str : json.keySet()) {
			if(!str.equals("sign")) {
				try {
					buffer.append(json.getJSONObject(str).toJSONString());		
				} catch (Exception e) {
					buffer.append(json.get(str).toString());
				}
			}
		}
		System.out.println("明文为 ： "+buffer.toString());
//		String decrpte=Md5Util.getMD5( Md5Util.getmd5(buffer.toString()).toUpperCase() + key.toUpperCase() ).toLowerCase();
//		System.out.println("密文为 ： "+decrpte);
//		return decrpte;
		return key;
	}
	
}
