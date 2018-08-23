package com.syg.manage.model.manage;

import java.text.ParseException;
import java.util.Date;

import com.syg.manage.model.entity.ShDate;
import com.syg.manage.util.DateUtil;

/**
 * 通用参数类
 * @author zhangdi
 */
public class DataParameters {
	
	private String gameKind;//游戏
	private String channelId;//渠道
	private String gameVersion;//版本
	private Date logTime;//记录时间
	private ShDate logTimeSh;//时间段
	private String channelName;//渠道名称
	private ShDate logTimeShDay;//记录一天的时间
	
	public String getGameKind() {
		return gameKind;
	}
	public void setGameKind(String gameKind) {
		this.gameKind = gameKind;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getGameVersion() {
		return gameVersion;
	}
	public void setGameVersion(String gameVersion) {
		this.gameVersion = gameVersion;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public ShDate getLogTimeSh() {
		if(logTimeSh == null){
			logTimeSh = new ShDate();
			Date nowDate = null;
			try {
				nowDate = DateUtil.getTheDayOfStartTime(new Date());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			logTimeSh.setBegin(DateUtil.AddDay(nowDate, -6));
			logTimeSh.setEnd(new Date());
		}
		return logTimeSh;
	}
	public void setLogTimeSh(ShDate logTimeSh) {
		this.logTimeSh = logTimeSh;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public ShDate getLogTimeShDay() {
		if(logTimeShDay == null){
			logTimeShDay = new ShDate();
			logTimeShDay.setBegin(new Date());
			logTimeShDay.setEnd(new Date());
		}
		return logTimeShDay;
	}
	public void setLogTimeShDay(ShDate logTimeShDay) {
		this.logTimeShDay = logTimeShDay;
	}
	
}
