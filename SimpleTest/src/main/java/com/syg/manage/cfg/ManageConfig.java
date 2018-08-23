package com.syg.manage.cfg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.syg.manage.dao.manage.ManagePerMpr;
import com.syg.manage.model.manage.ManagePer;

@Component
public class ManageConfig {
	private static long BEFORE_TIME = 0;
	private static Map<Integer, ManagePer> perMap = new HashMap<Integer, ManagePer>();
	private static ManagePer rootPer;
	@Resource
	private ManagePerMpr managePerMpr;
	
	public void updateCache(){
		updateCache(false);
	}
	public void updateCache(boolean force) {
		//1分钟更新
		if (force || System.currentTimeMillis() - BEFORE_TIME   > 1*1000) {
			BEFORE_TIME = System.currentTimeMillis();
			
			Map<Integer, ManagePer> tmpMap=new HashMap<>();
			List<ManagePer> tmpList = managePerMpr.queryAll();
			for (int i = 0; i < tmpList.size(); i++) {
				ManagePer per = tmpList.get(i);
				tmpMap.put(per.getMpId(), per);
			}
			ManagePer rootTemp=null;
			for (int i = 0; i < tmpList.size(); i++) {
				ManagePer per = tmpList.get(i);
				if (per.getMpId()==Integer.valueOf(PerStr.ROOT_MP_VALUE)) {
					rootTemp=per;
					continue;
				}
				ManagePer fatherPer = tmpMap.get(per.getFatherMpId());
				fatherPer.getSubList().add(per);
				per.setFatherPer(fatherPer);
			}
			
			perMap = tmpMap;
			rootPer = rootTemp;
		}
	}
	
	public ManagePer getRootPer(){
		updateCache();
		return rootPer;
	}
	
	public Map<Integer, ManagePer> getPerMap() {
		updateCache();
		return perMap;
	}
	
	public ManagePer getRootPerByForce(){
		updateCache(true);
		return rootPer;
	}
	
}
