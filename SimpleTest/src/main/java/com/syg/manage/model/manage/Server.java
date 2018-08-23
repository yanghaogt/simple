package com.syg.manage.model.manage;

import java.util.Date;

public class Server {
	
	private Integer sId;
	private String  sName;
	private Integer sIsNew;//0-老服，1-新服
	private Integer sStatus;//10000-测试（默认），0-开放
	private String sIp;
	private String  channelList;
	private String dataname;
	private String user;
	private String pwd;	
	private Integer state;
	private Integer sendMail;//'是否推送邮件，1-推送，0不推送'
	private String  logname;
	private String  path;
	private String  sUser;
	private String  sPwd;
	private String  sRegionName;
	private Integer allowRechage;//DEFAULT '1' COMMENT '是否允许充值'
	private Integer orders;
	private String  sDesc;
	private String  sSign;
	private String  sPort;
	private String  prefixSname;//服务器名字前缀
	private String 	serverIds;
	private Date openTime;
	private Date oldTime;
	private Integer popSwitch;//弹窗开关
	private String popContent;//弹窗内容
	private String rechargeUrl;
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getsIsNew() {
		return sIsNew;
	}
	public void setsIsNew(Integer sIsNew) {
		this.sIsNew = sIsNew;
	}
	public Integer getsStatus() {
		return sStatus;
	}
	public void setsStatus(Integer sStatus) {
		this.sStatus = sStatus;
	}
	public String getsIp() {
		return sIp;
	}
	public void setsIp(String sIp) {
		this.sIp = sIp;
	}
	public String getChannelList() {
		return channelList;
	}
	public void setChannelList(String channelList) {
		this.channelList = channelList;
	}
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getSendMail() {
		return sendMail;
	}
	public void setSendMail(Integer sendMail) {
		this.sendMail = sendMail;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getsUser() {
		return sUser;
	}
	public void setsUser(String sUser) {
		this.sUser = sUser;
	}
	public String getsPwd() {
		return sPwd;
	}
	public void setsPwd(String sPwd) {
		this.sPwd = sPwd;
	}
	public String getsRegionName() {
		return sRegionName;
	}
	public void setsRegionName(String sRegionName) {
		this.sRegionName = sRegionName;
	}
	public Integer getAllowRechage() {
		return allowRechage;
	}
	public void setAllowRechage(Integer allowRechage) {
		this.allowRechage = allowRechage;
	}
	public Integer getOrders() {
		return orders;
	}
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	public String getsDesc() {
		return sDesc;
	}
	public void setsDesc(String sDesc) {
		this.sDesc = sDesc;
	}
	public String getsSign() {
		return sSign;
	}
	public void setsSign(String sSign) {
		this.sSign = sSign;
	}
	public String getsPort() {
		return sPort;
	}
	public void setsPort(String sPort) {
		this.sPort = sPort;
	}
	public String getPrefixSname() {
		return prefixSname;
	}
	public void setPrefixSname(String prefixSname) {
		this.prefixSname = prefixSname;
	}
	public String getServerIds() {
		return serverIds;
	}
	public void setServerIds(String serverIds) {
		this.serverIds = serverIds;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public Date getOldTime() {
		return oldTime;
	}
	public void setOldTime(Date oldTime) {
		this.oldTime = oldTime;
	}
	public Integer getPopSwitch() {
		return popSwitch;
	}
	public void setPopSwitch(Integer popSwitch) {
		this.popSwitch = popSwitch;
	}
	public String getPopContent() {
		return popContent;
	}
	public void setPopContent(String popContent) {
		this.popContent = popContent;
	}
	public String getRechargeUrl() {
		return rechargeUrl;
	}
	public void setRechargeUrl(String rechargeUrl) {
		this.rechargeUrl = rechargeUrl;
	}
	

	
}
