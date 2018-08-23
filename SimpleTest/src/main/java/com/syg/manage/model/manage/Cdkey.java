package com.syg.manage.model.manage;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.syg.manage.model.entity.ShDate;

public class Cdkey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * cdkey.key (类id+6位数字,key不可重复)
     * @ibatorgenerated 2016-01-07 18:15:23
     */
    private Integer key;

    /**
     * cdkey.class_id (类id)
     * @ibatorgenerated 2016-01-07 18:15:23
     */
    private Integer classId;

    /**
     * cdkey.create_time (生成时间)
     * @ibatorgenerated 2016-01-07 18:15:23
     */
    private Long createTime;
	private Date createDate;
	private ShDate createDateSh;
	private String createStr;
    /**
     * cdkey.state (当前状态:0未使用,1已使用)
     * @ibatorgenerated 2016-01-07 18:15:23
     */
    private Integer state;
    private String stateStr;
    
	public ShDate getCreateDateSh() {
		return createDateSh;
	}

	public void setCreateDateSh(ShDate createDateSh) {
		this.createDateSh = createDateSh;
	}

	public ShDate getUseDateSh() {
		return useDateSh;
	}

	public void setUseDateSh(ShDate useDateSh) {
		this.useDateSh = useDateSh;
	}

	/**
     * cdkey.use_time (使用时间)
     * @ibatorgenerated 2016-01-07 18:15:23
     */
    private Long useTime;
    private Date useDate;
    private ShDate useDateSh;
    private String useStr;
    /**
     * cdkey.uid (使用者id)
     * @ibatorgenerated 2016-01-07 18:15:23
     */
    private Integer uid;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getState() {
        return state;
    }

    public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUseTime() {
		return useTime;
	}

	public void setUseTime(Long useTime) {
		this.useTime = useTime;
	}

	public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Date parseDate(Long time){
		if (time==0) {
			return null;
		}
		return new Date(time*1000);
	}
    public Date getCreateDate() {
		return parseDate(createTime);
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUseDate() {
		return parseDate(useTime);
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	
	public String getStateStr() {
		if (state==0) {
			stateStr = "未使用";
		}else if (state==1) {
			stateStr = "已使用";
		}
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}

	public String getCreateStr() {
		String str="";
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (createTime != 0) {
			str=df.format(createTime*1000);
		}else {
			str="0";
		}
		return str;
	}

	public void setCreateStr(String createStr) {
		this.createStr = createStr;
	}

	public String getUseStr() {
		String str="";
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (useTime != 0) {
			str=df.format(useTime*1000);
		}else {
			str="0";
		}
		return str;
	}

	public void setUseStr(String useStr) {
		this.useStr = useStr;
	}
}