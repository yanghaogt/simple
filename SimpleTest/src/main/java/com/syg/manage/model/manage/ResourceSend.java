package com.syg.manage.model.manage;

import java.util.Date;

import com.syg.manage.model.entity.ShDate;

public class ResourceSend {
	
	private int id;
	private Integer sendType;
	private String acceptRoleList;
	private String serverId;
	private String content;
	private String itemList;
	private String comment;
	private String applyName;
	private String approvalName;
	private Date updateTs;
	private Date createTs;
	private Integer status;
	private ShDate createTsShDate;
	private String channelId;
	private String operationDesc;
	private String mailTitle;
	private String mailContent;
	private Integer price=0;
	private String serverIds;
	private String channelIds;
	private String sendLog;
	
	public ResourceSend() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcceptRoleList() {
		return acceptRoleList;
	}
	public void setAcceptRoleList(String acceptRoleList) {
		this.acceptRoleList = acceptRoleList;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getItemList() {
		return itemList;
	}
	public void setItemList(String itemList) {
		this.itemList = itemList;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getApprovalName() {
		return approvalName;
	}
	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}
	public Date getUpdateTs() {
		return updateTs;
	}
	public void setUpdateTs(Date updateTs) {
		this.updateTs = updateTs;
	}
	public Date getCreateTs() {
		return createTs;
	}
	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}
	public ShDate getCreateTsShDate() {
		return createTsShDate;
	}
	public void setCreateTsShDate(ShDate createTsShDate) {
		this.createTsShDate = createTsShDate;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getOperationDesc() {
		return operationDesc;
	}
	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc;
	}
	public String getMailTitle() {
		return mailTitle;
	}
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	public String getMailContent() {
		return mailContent;
	}
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getServerIds() {
		return serverIds;
	}
	public void setServerIds(String serverIds) {
		this.serverIds = serverIds;
	}
	public String getChannelIds() {
		return channelIds;
	}
	public void setChannelIds(String channelIds) {
		this.channelIds = channelIds;
	}
	public String getSendLog() {
		return sendLog;
	}
	public void setSendLog(String sendLog) {
		this.sendLog = sendLog;
	}
	public Integer getSendType() {
		return sendType;
	}
	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
