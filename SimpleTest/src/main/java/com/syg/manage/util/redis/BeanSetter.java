package com.syg.manage.util.redis;

import java.util.Map;

public interface BeanSetter<T> {

	public Map<String, String> setter(Map<String, String> targetMap, T bean);
}
