package com.syg.manage.util.redis;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.syg.manage.exception.BaseException;
import com.syg.manage.model.manage.RedisUser;

@Repository
public class RedisUserMapper extends AbstractRedisMapper {
	
	public final static Logger logger = LoggerFactory.getLogger(RedisUserMapper.class);

	public static final String table_prefix = "dcvt_log_ru:";

	public static final UserBeanMapper beanMapper = new UserBeanMapper();

	public static final UserBeanSetter beanSetter = new UserBeanSetter();

	private static class UserBeanMapper implements BeanMapper<RedisUser> {
		@Override
		public RedisUser map(Map<String, String> source, RedisUser bean) {
			bean.setRegTime(			StringUtils.isEmpty(source.get("regTime"))?new Date():new Date(Long.valueOf(source.get("regTime"))));
			bean.setInfullAmount(		StringUtils.isEmpty(source.get("infullAmount"))?0:Integer.valueOf(source.get("infullAmount")));
			bean.setActiveDay(			StringUtils.isEmpty(source.get("activeDay"))?1:Integer.valueOf(source.get("activeDay")));
			bean.setActiveWeek(			StringUtils.isEmpty(source.get("activeWeek"))?1:Integer.valueOf(source.get("activeWeek")));
			bean.setLastLoginTime(		StringUtils.isEmpty(source.get("lastLoginTime"))?new Date():new Date(Long.valueOf(source.get("lastLoginTime"))));
			bean.setLoginCount(			StringUtils.isEmpty(source.get("loginCount"))?1:Integer.valueOf(source.get("loginCount")));
			bean.setOnlineTime(			StringUtils.isEmpty(source.get("onlineTime"))?0:Integer.valueOf(source.get("onlineTime")));
			bean.setLastLoginLogId(		StringUtils.isEmpty(source.get("lastLoginLogId"))?"":source.get("lastLoginLogId"));
			bean.setLastLoginUpdateTime(StringUtils.isEmpty(source.get("lastLoginUpdateTime"))?new Date():new Date(Long.valueOf(source.get("lastLoginUpdateTime"))));
			return bean;
		}
	}

	private static class UserBeanSetter implements BeanSetter<RedisUser> {
		@Override
		public Map<String, String> setter(Map<String, String> targetMap, RedisUser bean) {
			targetMap.put("infullAmount", String.valueOf(bean.getInfullAmount()));
			targetMap.put("regTime", String.valueOf(bean.getRegTime().getTime()));
			targetMap.put("lastLoginTime", String.valueOf(bean.getLastLoginTime().getTime()));
			targetMap.put("activeDay", String.valueOf(bean.getActiveDay()));
			targetMap.put("activeWeek", String.valueOf(bean.getActiveWeek()));
			targetMap.put("loginCount", String.valueOf(bean.getLoginCount()));
			targetMap.put("onlineTime", String.valueOf(bean.getOnlineTime()));
			targetMap.put("lastLoginLogId", bean.getLastLoginLogId());
			targetMap.put("lastLoginUpdateTime", String.valueOf(bean.getLastLoginUpdateTime().getTime()));
			return targetMap;
		}
	}
	
	public RedisUser findUser(String Id){
		return getBean(getKey(Id), RedisUser.class, beanMapper);
	}
	
	public void saveUser(String Id,RedisUser ru){
		saveBean(getKey(Id), ru, beanSetter);
	}
	
	public void updateUser(String Id,RedisUser ru){
		saveBean(getKey(Id), ru, beanSetter);
	}
	
	private String getKey(String Id){
		if (!StringUtils.isEmpty(Id)) {
			return table_prefix+Id;
		}else{
			throw new BaseException("userId或者deviceNum必须一个不为空");
		}
	}

}
