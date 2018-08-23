package com.syg.manage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.syg.manage.cfg.Per;


/**
 * 权限设置
 * @author hulinyun
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TagPer {
	/**
	 * 权限值
	 * @return
	 */
	Per value() default Per.ROOT;
	/**
	 * 是否需要登陆
	 * @return
	 */
	boolean needLogin() default true;
}
