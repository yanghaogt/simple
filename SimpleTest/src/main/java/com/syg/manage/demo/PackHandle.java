package com.syg.manage.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PackHandle implements Runnable{
	
	private final static Logger logger = LoggerFactory.getLogger(PackHandle.class);
	private boolean cancel;
	private int appId;
	private String orgPackRoot;
	private int pkgHistoryId;
	
	public PackHandle(int appId, String orgPackRoot, int pkgHistoryId) {
		this.appId = appId;
		this.orgPackRoot = orgPackRoot;
		this.pkgHistoryId = pkgHistoryId;
	}

	@Override
	public void run(){
		try{
			logger.info("打包处理开始"+appId);
			logger.info("拷贝原始项目开始");
			logger.info("拷贝原始项目结束");
			logger.info("拷贝并初步处理所有SDK开始");
			logger.info("拷贝并初步处理所有SDK结束");
			logger.info("manifest等文件处理开始");
			logger.info("manifest等文件处理结束");
			logger.info("备份class开始");
			logger.info("备份class结束");
			logger.info("合并资源开始");
			logger.info("合并资源结束");
			logger.info("更新lib开始");
			logger.info("更新lib结束");
			logger.info("处理名字和icon和新的R.class开始");
			logger.info("处理名字和icon和新的R.class结束");
			logger.info("生成slot.json开始");
			logger.info("生成slot.json结束");
			logger.info("编译classes开始");
			logger.info("编译classes结束");
			logger.info("替换资源文件开始");
			logger.info("替换资源文件结束");
			logger.info("渠道特殊处理开始");
			logger.info("渠道特殊处理结束");
			logger.info("编译打包开始");
			logger.info("准备apkZipAlign");
			logger.info("zipalign优化开始");
			logger.info("apkZipAlign 结束");
			logger.info("zipalign优化结束");
			logger.info("开始签名...");
			logger.info("签名完成");
		} catch (Exception e) {
			logger.info("失败！"+e.getMessage());
		} finally{
			try{
				PackPool.removeDoingPack(appId);
				logger.info("打包结束");
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	public boolean isCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
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
}
