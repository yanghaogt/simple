package com.syg.manage.model.manage;

import java.io.Serializable;

public class Player implements Serializable {
    /**
     * player.uid
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    private Integer uid;

    /**
     * player.uin
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    private Integer uin;

    /**
     * player.server_id
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    private Integer serverId;

    /**
     * player.is_ai (是否为机器人)
     * @ibatorgenerated 2015-12-16 18:38:43
     */
    private Integer isAi;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUin() {
        return uin;
    }

    public void setUin(Integer uin) {
        this.uin = uin;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Integer getIsAi() {
        return isAi;
    }

    public void setIsAi(Integer isAi) {
        this.isAi = isAi;
    }
}