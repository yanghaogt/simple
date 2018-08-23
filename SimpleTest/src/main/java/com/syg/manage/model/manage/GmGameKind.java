package com.syg.manage.model.manage;

import java.io.Serializable;

public class GmGameKind implements Serializable {
    /**
     * gm_game_kind.kind_id (游戏类别ID)
     * @ibatorgenerated 2015-09-29 16:04:40
     */
    private Integer kindId;

    /**
     * gm_game_kind.game_name (游戏名称)
     * @ibatorgenerated 2015-09-29 16:04:40
     */
    private String gameName;
    
    private String priKey;

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

	public String getPriKey() {
		return priKey;
	}

	public void setPriKey(String priKey) {
		this.priKey = priKey;
	}
}