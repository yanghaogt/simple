/**
 * 
 */
package com.syg.manage.model.game;
/**  
*  
* @author chenshanbao  
* @date 2017年8月22日  
*/
public class Activity {
	private String id;
	private String des;
	private String name;
	private String icon;
	private String type;
	private String detailType;
	private String order;
	private String activityType;
	private String extendShowTime;
	private String alwaysShow;
	private String content;
	private String level;
	private String days;
	private String time;
	private String times;
	private String reward;
	private String details;
	private String mapId;
	private String args;
	
	private Integer status;//显示状态；
	
	private Integer state;//0-未开启状态，1表示已经开启
	private Integer typeDesc;//描述类型
	
	
	private Integer serverId;
	
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Activity(String id, String times) {
		super();
		this.id = id;
		this.times = times;
	}
	public String getId() {
		return id;
	}
	public Integer getId2Integer(){
		return Integer.valueOf(id);
	}
	public void setId(String id) {
		this.id = id;
	}	
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDetailType() {
		return detailType;
	}
	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getExtendShowTime() {
		return extendShowTime;
	}
	public void setExtendShowTime(String extendShowTime) {
		this.extendShowTime = extendShowTime;
	}
	public String getAlwaysShow() {
		return alwaysShow;
	}
	public void setAlwaysShow(String alwaysShow) {
		this.alwaysShow = alwaysShow;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getMapId() {
		return mapId;
	}
	public void setMapId(String mapId) {
		this.mapId = mapId;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(Integer typeDesc) {
		this.typeDesc = typeDesc;
	}
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	@Override
	public String toString() {
		return "Activity [id=" + id + ", des=" + des + ", name=" + name + ", icon=" + icon + ", type=" + type
				+ ", detailType=" + detailType + ", order=" + order + ", activityType=" + activityType
				+ ", extendShowTime=" + extendShowTime + ", alwaysShow=" + alwaysShow + ", content=" + content
				+ ", level=" + level + ", days=" + days + ", time=" + time + ", times=" + times + ", reward=" + reward
				+ ", details=" + details + ", mapId=" + mapId + ", args=" + args + ", status=" + status + ", state="
				+ state + ", typeDesc=" + typeDesc + ", serverId=" + serverId + "]";
	}
	
	
	
	

}
