package com.syg.manage.util.dataSource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

@Service
public class DataSourceGroup {
	
	private DataSource defaultDataSource;
	
	private static Map<String, DataSource> dataSourceMap = new HashMap<>();
	
	public void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
		this.dataSourceMap = dataSourceMap;
	}

	public void addDataSource(Integer id, DataSource dataSource){
		dataSourceMap.put(Integer.valueOf(id).toString(), dataSource);						
	}
	
	public static DataSource getDataSource(String name){
		return dataSourceMap.get(name);
	}	
	
	public DataSource getDefaultDataSource() {
		return defaultDataSource;
	}

	public void setDefaultDataSource(DataSource defaultDataSource) {
		this.defaultDataSource = defaultDataSource;
	}

	public static String getLastNumFromString(String s){
		int size = s.length();
		StringBuilder out = new StringBuilder();
		for(int i=size-1;i>=0;i--){
			char c = s.charAt(i);
			if(c>=48&&c<=57){//char 0-9
				out.append(c);
			}else{
				break;
			}
		}
		return out.reverse().toString();
	}
	
	public static void main(String[] args) {
		char min = '0';
		char max = '9';
		System.out.println((int)min);
		System.out.println((int)max);
		System.out.println(getLastNumFromString("test0e0000"));
		System.out.println(getLastNumFromString("test0e"));
		System.out.println(getLastNumFromString("test0e6001"));
	}

}
