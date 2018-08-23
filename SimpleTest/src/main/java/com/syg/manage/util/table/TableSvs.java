package com.syg.manage.util.table;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TableSvs {
	
	private final static Logger logger = LoggerFactory.getLogger(TableSvs.class);
	
	@Resource(name="testhaoDataSource")
	private DataSource ds;
	
	public void createTable(){
		logger.info("=================createTable===================");
		String databaseName = "test_hao";
		String oldDatabaseName = "test_hao";
		String gm_channel = "gm_channel";
		String gm_game_kind = "gm_game_kind";
		String gm_platform = "gm_platform";
		String[] array = new String[]{gm_channel, gm_game_kind, gm_platform};
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		String dateDay = fmt.format(new Date());
		for(String s:array){			
			try {
				createTable(databaseName, s +"_"+ dateDay, oldDatabaseName, s);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("{}",e);
			}

		}
		logger.info("===================================={}",ds);
	}
	
	private int getTableCount(String databaseName, String tableName) throws Exception{
		TableService ts = TableService.getInstance();
		ts.setConnection(ds.getConnection());
		return ts.getTableCount(databaseName, tableName);
	}
	
	public int createTable(String databaseName, String tableName, String oldDatabaseName,String oldTableName) throws Exception{
		int count = getTableCount(databaseName, tableName);
		logger.info("table:{},count:{}",tableName,count);
		if(count<=0){
			TableService ts = TableService.getInstance();
			ts.setConnection(ds.getConnection());
			return ts.createTable(databaseName, tableName, oldDatabaseName, oldTableName);
		}
		return 0;
	}
	

}
