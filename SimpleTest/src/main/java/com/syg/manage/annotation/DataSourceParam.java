package com.syg.manage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceParam {
	
	String value() default "dataSourceIndex";
	
	String dataSourceName() default "dataSourceName";

}
