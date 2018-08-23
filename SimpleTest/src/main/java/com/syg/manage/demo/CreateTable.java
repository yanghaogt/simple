package com.syg.manage.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期、建表语句
 * @author yanghao
 *
 */
public class CreateTable {

	private final static Logger logger = LoggerFactory.getLogger(CreateTable.class);
	
	public static void main(String[] args) {
		String databaseName = "data_center_base";
		String oldDatabaseName = "data_center_base";
		String org_login_log = "org_login_log";
		String org_pay_log = "org_pay_log";
		String org_startup_log = "org_startup_log";
		String[] array = new String[]{org_login_log, org_pay_log, org_startup_log};
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		String dateDay = fmt.format(new Date());
		for(String s:array){
			try {
				System.out.println("database:"+databaseName+";table:"+s+"_"+ dateDay);
				getCreateTableSql(databaseName, s +"_"+ dateDay, oldDatabaseName, s);
				//createTable(databaseName, s +"_"+ dateDay, oldDatabaseName, s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getCreateTableSql(String databaseName, String tableName ,String targetDatabaseName, String targetTableName){
		StringBuilder s = new StringBuilder("create table `");
		s.append(databaseName).append("`.`")
		 .append(tableName).append("` like `")
		 .append(targetDatabaseName).append("`.`")
		 .append(targetTableName).append("`");
		String out =s.toString();
		System.out.println(out);
		return out;
	}
	
}
