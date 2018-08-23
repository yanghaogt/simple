package com.syg.manage.model.manage;

import java.io.Serializable;
import java.util.Date;

public class Attachment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8267061271735110784L;

    private Integer attachId;
    private Integer attachType;
    private Integer refId;
    private Integer createUserId;
    private String path;
    private String name;
    private Integer status;
    private String title;
    private Date createTime;
    
    private int isImg;//0:附件1:图片

    public Integer getAttachId() {
        return attachId;
    }

    public void setAttachId(Integer attachId) {
        this.attachId = attachId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAttachType() {
		return attachType;
	}

	public void setAttachType(Integer attachType) {
		this.attachType = attachType;
	}
	
	public int getIsImg() {
		return isImg;
	}

	public void setIsImg(int isImg) {
		this.isImg = isImg;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}