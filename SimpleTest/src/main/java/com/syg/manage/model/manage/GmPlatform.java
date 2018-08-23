package com.syg.manage.model.manage;

import java.io.Serializable;

public class GmPlatform implements Serializable {
	private Integer platformId;
    /**
     * gm_platform.platform (平台编号（父渠道）)
     * @ibatorgenerated 2015-09-29 16:04:42
     */
    private String platform;

    /**
     * gm_platform.platform_name (平台名称 )
     * @ibatorgenerated 2015-09-29 16:04:42
     */
    private String platformName;

    /**
     * gm_platform.kind_id (游戏类别ID 关联到gm_game_kind)
     * @ibatorgenerated 2015-09-29 16:04:42
     */
    private Integer kindId;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}
}