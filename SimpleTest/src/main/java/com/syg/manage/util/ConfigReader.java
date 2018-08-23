package com.syg.manage.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 通用的配置文件读取器
 * @author hulinyun
 *
 */
public abstract class ConfigReader {
	protected Properties confiProperties;
	protected static Logger logger = LoggerFactory.getLogger(ConfigReader.class);
	protected String fileName;
	
	
	public ConfigReader(String fileName){
		this.fileName = fileName;
		init();
	}
	/**
	 * 读取某条数据
	 * @param property
	 * @return
	 */
    public String getValue(String property)  {
        if (confiProperties == null) {
            init();
        }
        return confiProperties.getProperty(property);
    }
    public Map<String, String> getLikeParamMap(String partParam){
    	if (confiProperties == null) {
            init();
        }
    	Map<String, String> resMap=new HashMap<>();
    	for (Object key : confiProperties.keySet()) {
			if (key.toString().contains(partParam)) {
				resMap.put(key.toString(), confiProperties.getProperty(key.toString()));
			}
		}
    	return resMap;
    }
    
    
    /**
     * 读取配置文件
     */
    public synchronized void init(){
    	Properties confiPropertiesNew = new Properties();
        Resource res = new ClassPathResource(fileName);
        try {
        	confiPropertiesNew.load(res.getInputStream());
        } catch (IOException e) {
            logger.info("读取"+fileName+"文件错误",e);
            return;
        }
        confiProperties = confiPropertiesNew;
    }
}
