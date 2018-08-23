package com.syg.manage.util.dataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.syg.manage.dao.manage.ServerMapper;
import com.syg.manage.model.manage.Server;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

@Service
public class DataSourceSvs {
	
	private final static Logger log = LoggerFactory.getLogger(DataSourceSvs.class);

	@Value("${druid.initialSize}")
	private String initialSize;
	@Value("${druid.minIdle}")
	private String minIdle;
	@Value("${druid.maxActive}")
	private String maxActive;
	@Value("${druid.maxWait}")
	private String maxWait;
	@Value("${druid.timeBetweenEvictionRunsMillis}")
	private String timeBetweenEvictionRunsMillis;
	@Value("${druid.minEvictableIdleTimeMillis}")
	private String minEvictableIdleTimeMillis;
	@Value("${druid.testWhileIdle}")
	private String testWhileIdle;
	@Value("${druid.testOnBorrow}")
	private String testOnBorrow;
	@Value("${druid.testOnReturn}")
	private String testOnReturn;
	@Value("${druid.poolPreparedStatements}")
	private String poolPreparedStatements;
	@Value("${druid.maxPoolPreparedStatementPerConnectionSize}")
	private String maxPoolPreparedStatementPerConnectionSize;
	
	private String driverClassName = "com.mysql.jdbc.Driver";
	
	private Map<String,String> dsConfigMap = new HashMap<String,String>(12);
	@Resource
	private ServerMapper serverMapper;
	@Resource
	private DataSourceGroup dataSourceGroup;
	
	private final String prefix="jdbc:mysql://";
	private final String postfix="?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
	
	@PostConstruct
	private void init(){
		log.info("===============init dataSource===============");
		dsConfigMap.put("maxPoolPreparedStatementPerConnectionSize", maxPoolPreparedStatementPerConnectionSize);
		dsConfigMap.put("poolPreparedStatements", poolPreparedStatements);
		dsConfigMap.put("testOnReturn", testOnReturn);
		dsConfigMap.put("testOnBorrow", testOnBorrow);
		dsConfigMap.put("testWhileIdle", testWhileIdle);
		dsConfigMap.put("minEvictableIdleTimeMillis", minEvictableIdleTimeMillis);		
		dsConfigMap.put("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis);
		dsConfigMap.put("maxWait", maxWait);
		dsConfigMap.put("maxActive", maxActive);
		dsConfigMap.put("minIdle", minIdle);
		dsConfigMap.put("initialSize", initialSize);
		dsConfigMap.put("driverClassName", driverClassName);
		List<Server> list = serverMapper.getList();
		for(Server s:list){
			DruidDataSource ds = createDataSource(s);
			if(ds!=null){
				dataSourceGroup.addDataSource(s.getsId(), ds);				
			}
		}
		log.error("{}",dataSourceGroup);
	}
	
	public DruidDataSource createDataSource(Server server){
		try {
			StringBuilder s = new StringBuilder();
			s.append(prefix).append(server.getsIp()).append(":3306/").append(server.getDataname()).append(postfix);
			log.info("url={}",s);
			Map<String,String> temp = new HashMap<String,String>(15);
			temp.put("username", server.getUser());
			temp.put("password", server.getPwd());
			temp.put("url", s.toString());			
			DruidDataSource dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(temp);
			return dds;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("{}",e);
		}	
		return null;
	}

}
