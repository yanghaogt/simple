package com.syg.manage.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 母包处理
 * @author hulinyun
 */
public class PackOrgHandle implements Runnable{
	private final static Logger logger = LoggerFactory.getLogger(PackOrgHandle.class);
	
	private int appId;
	private String orgPackRoot;
	private int pkgHistoryId;
	
	public PackOrgHandle(int appId,String orgPackRoot, int pkgHistoryId) {
		this.appId = appId;
		this.orgPackRoot = orgPackRoot;
		this.pkgHistoryId = pkgHistoryId;
	}
	
	@Override
	public void run(){
		try {
			logger.info("母包处理线程开始");
			logger.info("母包解压开始");
			logger.info("母包解压结束");
			logger.info("母包反编译开始");
			logger.info("母包反编译结束");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}finally{
			PackPool.removeDoingOrg(appId);
			logger.info("母包处理线程结束");
		}
	}

	public String getOrgPackRoot() {
		return orgPackRoot;
	}

	public void setOrgPackRoot(String orgPackRoot) {
		this.orgPackRoot = orgPackRoot;
	}

	public int getPkgHistoryId() {
		return pkgHistoryId;
	}

	public void setPkgHistoryId(int pkgHistoryId) {
		this.pkgHistoryId = pkgHistoryId;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	
	
}
