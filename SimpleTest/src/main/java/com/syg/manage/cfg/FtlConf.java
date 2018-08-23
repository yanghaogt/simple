package com.syg.manage.cfg;

import java.util.HashMap;
import java.util.List;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;


public class FtlConf implements TemplateMethodModelEx {
	private static String ftl_siteUrl="";
	private static String ftl_cssUrl="";
	private static String ftl_jsUrl="";
	private static String ftl_imgUrl="";
	
	static {
		ftl_siteUrl = GlobalConfig.getDef().getValue("ftl_siteUrl");
		ftl_cssUrl = GlobalConfig.getDef().getValue("ftl_cssUrl");
		ftl_jsUrl = GlobalConfig.getDef().getValue("ftl_jsUrl");
		ftl_imgUrl = GlobalConfig.getDef().getValue("ftl_imgUrl");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })  
	@Override
	public Object exec(List arguments) throws TemplateModelException {
        HashMap result = new HashMap();  
        result.put("ftl_siteUrl", ftl_siteUrl);
        result.put("ftl_cssUrl", ftl_cssUrl);
        result.put("ftl_jsUrl", ftl_jsUrl);
        result.put("ftl_imgUrl", ftl_imgUrl);
        return result;
	}
}
