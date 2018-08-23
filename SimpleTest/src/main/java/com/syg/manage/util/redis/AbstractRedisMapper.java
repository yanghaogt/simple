package com.syg.manage.util.redis;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * spring 封装了 RedisTemplate 对象来进行对redis的各种操作，它支持所有的 redis 原生的 api。
    redisTemplate.opsForValue();//操作字符串
	redisTemplate.opsForHash();//操作hash
	redisTemplate.opsForList();//操作list
	redisTemplate.opsForSet();//操作set
	redisTemplate.opsForZSet();//操作有序set
 */
public class AbstractRedisMapper {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public <T> T getBean(String key, Class<T> beanClass, BeanMapper<T> mapper) {
		Map<String, String> map = redisTemplate.<String, String> opsForHash().entries(key);//返回map集合
		if (map == null || map.isEmpty()) {
			return null;
		}
		T bean;
		try {
			bean = beanClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return mapper.map(map, bean);
	}

	public <T> void saveBean(String key, T bean, BeanSetter<T> setter) {
		Map<String, String> result = new HashMap<String, String>();
		setter.setter(result, bean);
		redisTemplate.<String, String> opsForHash().putAll(key, result);
	}

	public <T> T getHashValue(String key, String hashKey, Class<T> valueType) {
		String value = redisTemplate.<String, String> opsForHash().get(key, hashKey);
		return convert(value, valueType);
	}

	public <T> T getHashValue(String key, String hashKey, Class<T> valueType, T defaultValue) {
		String value = redisTemplate.<String, String> opsForHash().get(key, hashKey);
		T result = convert(value, valueType);
		return result == null ? defaultValue : result;
	}

	public void setHashValue(String key, String hashKey, Object value) {
		redisTemplate.<String, String> opsForHash().put(key, hashKey, convertString(value));
	}

	public <T> T getValue(String key, Class<T> valueType, T defaultValue) {
		String value = redisTemplate.opsForValue().get(key);
		T result = convert(value, valueType);
		return result == null ? defaultValue : result;
	}

	public <T> T getValue(String key, Class<T> valueType) {
		String value = redisTemplate.opsForValue().get(key);
		return convert(value, valueType);
	}

	public <T> void setValue(String key, T value) throws Exception {
		redisTemplate.opsForValue().set(key, convertString(value));
	}

	public <T> Set<T> getSet(String key, Class<T> valueType) {
		Set<String> values = redisTemplate.opsForSet().members(key);
		Set<T> resultSet = new HashSet<T>();
		for (String value : values) {
			resultSet.add(convert(value, valueType));
		}
		return resultSet;
	}

	public <T> void addSetMember(String key, T value) {
		redisTemplate.opsForSet().add(key, convertString(value));
	}

	public <T> void removeSetMember(String key, T value) throws Exception {
		redisTemplate.opsForSet().remove(key, convertString(value));
	}

	public <T> Set<T> getZSetMembers(String key, long start, long end, Class<T> valueType) {
		Set<String> values = redisTemplate.opsForZSet().range(key, start, end);
		Set<T> resultSet = new LinkedHashSet<T>();
		for (String value : values) {
			resultSet.add(convert(value, valueType));
		}
		return resultSet;
	}

	public <T> Set<T> getZSetMembersByScore(String key, double min, double max, Class<T> valueType) {
		Set<String> values = redisTemplate.opsForZSet().rangeByScore(key, min, max);
		Set<T> resultSet = new LinkedHashSet<T>();
		for (String value : values) {
			resultSet.add(convert(value, valueType));
		}
		return resultSet;
	}

	public <T> void addZSetMember(String key, T value, double score) {
		redisTemplate.opsForZSet().add(key, convertString(value), score);
	}

	public <T> void removeZSetMember(String key, T value) {
		redisTemplate.opsForZSet().remove(key, convertString(value));
	}
	
	/**
	 * 将对象转换成为String类型
	 */
	public String convertString(Object object) {
		if (object == null) {
			return "null";
		}
		if (object instanceof Date) {
			return String.valueOf(((Date) object).getTime());
		}
		return String.valueOf(object);
	}

	/**
	 * 将字符串转换成为指定类型，如果找不到转换类型，抛出异常
	 */
	@SuppressWarnings("unchecked")
	public <T> T convert(String value, Class<T> valueType) throws RuntimeException {
		if (value == null) {
			return null;
		}
		if (valueType == String.class) {
			return (T) value;
		}
		if (valueType == Long.class || valueType == long.class) {
			return (T) Long.valueOf(value);
		}
		if (valueType == Integer.class || valueType == int.class) {
			return (T) Integer.valueOf(value);
		}
		if (valueType == Byte.class || valueType == byte.class) {
			return (T) Byte.valueOf(value);
		}
		if (valueType == Short.class || valueType == short.class) {
			return (T) Short.valueOf(value);
		}
		if (valueType == Double.class || valueType == double.class) {
			return (T) Double.valueOf(value);
		}
		if (valueType == Float.class || valueType == float.class) {
			return (T) Float.valueOf(value);
		}
		if (valueType == Date.class) {
			return (T) new Date(Long.valueOf(value));
		}
		throw new RuntimeException(String.format("不支持将'%s'转换成%s类型.", value, valueType.getName()));
	}
	
}
