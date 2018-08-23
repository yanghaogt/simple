package com.syg.manage.model.manage;

import java.io.Serializable;

public class GmChannel implements Serializable {
    /**
     * gm_channel.channel_id (渠道编号(子渠道))
     * @ibatorgenerated 2015-09-29 16:04:37
     */
    private String channelId;

    /**
     * gm_channel.channel_name (渠道名称)
     * @ibatorgenerated 2015-09-29 16:04:37
     */
    private String channelName;

    /**
     * gm_channel.platform (平台名称)
     * @ibatorgenerated 2015-09-29 16:04:37
     */
    private String platform;
    
    private Integer platformId;
    
    private Integer kindId;
    
    private Integer chId;

    /**
     * gm_channel.channel_desc (描述)
     * @ibatorgenerated 2015-09-29 16:04:37
     */
    private String channelDesc;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

	public Integer getKindId() {
		return kindId;
	}

	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}

	public Integer getChId() {
		return chId;
	}

	public void setChId(Integer chId) {
		this.chId = chId;
	}

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}
}