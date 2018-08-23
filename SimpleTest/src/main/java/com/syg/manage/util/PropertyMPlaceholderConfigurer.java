package com.syg.manage.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

public class PropertyMPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	/**
	 * 父类中的同名属性overloaded
	 */
	private Resource[] locations;
	/**
	 * 指定优先初始信息
	 */
	private Resource initLocation;
	private String fileEncoding;
	CaesarUtil commonUtil;
	BufferedReader reader;
	InputStream ins;
	String initNeed;
	
	public void loadProperties(Properties props) throws IOException {
		try {
			ins = initLocation.getInputStream();
			reader = new BufferedReader(new InputStreamReader(ins));
			initNeed = reader.readLine();
			commonUtil = new CaesarUtil(Integer.parseInt(initNeed.split("#")[0]));
			String initNextName = initNeed.split("#")[1];
			if (this.locations != null) {
				PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
				for (int i = 0; i < this.locations.length; i++) {
					Resource location = this.locations[i];
					if (initNextName.equals(location.getFilename())) {
						if (logger.isInfoEnabled()) {
							logger.info("Loading properties file from " + location);
						}
						InputStream ins = null;
						try {
							ins = location.getInputStream();
							BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
							StringBuilder content = new StringBuilder();
							String reading;
							while ((reading = reader.readLine()) != null) {
								content.append(commonUtil.decrypt(reading));
								content.append("\r\n");
							}
							ins = new ByteArrayInputStream(content.toString().getBytes());
							if (fileEncoding != null) {
								propertiesPersister.load(props, new InputStreamReader(ins, fileEncoding));
							} else {
								propertiesPersister.load(props, ins);
							}
						} finally {
							if (ins != null) {
								ins.close();
							}
						}
					} else {
						InputStream ins = null;
						try {
							ins = location.getInputStream();
							if (fileEncoding != null) {
								propertiesPersister.load(props, new InputStreamReader(ins, fileEncoding));
							} else {
								propertiesPersister.load(props, ins);
							}
						} finally {
							if (ins != null) {
								ins.close();
							}
						}
					}
					
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		
		
	}
	
	public Resource[] getLocations() {
		return locations;
	}
	public void setLocations(Resource[] locations) {
		this.locations = locations;
	}
	public Resource getInitLocation() {
		return initLocation;
	}
	public void setInitLocation(Resource initLocation) {
		this.initLocation = initLocation;
	}

	public String getFileEncoding() {
		return fileEncoding;
	}

	public void setFileEncoding(String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}
}
