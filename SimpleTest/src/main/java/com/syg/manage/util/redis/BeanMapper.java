package com.syg.manage.util.redis;

import java.util.Map;

public interface BeanMapper<T> {

	public T map(Map<String, String> source, T bean);
}
