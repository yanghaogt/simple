/**
 * 
 */
package com.syg.manage.util.table;
/**  
*  
* @author chen  
* @date 2016年11月1日  
* 数据库自动建表的相关功能
*/
public interface ITableService {
	
	public static final String DATABASE_NAME = "_databaseName_";
	public static final String TABLE_NAME = "_tableName_";
	public static final String TARGET_DATABASE_NAME = "_targetDatabaseName_";
	public static final String TARGET_TABLE_NAME = "_targetTableName_";
	public static final String SELETE_TABLE_COUNT_SQL = "SELECT count(*)  FROM `information_schema`.`TABLES` WHERE `table_schema`='_databaseName_'  AND `table_name`='_tableName_'";
	public static final String CREATE_TABLE_SQL = "create table `_databaseName_`.`_tableName_` like `_targetDatabaseName_`.`_targetTableName_`";
	
	public int getTableCount(String databaseName, String tableName) throws Exception;
	public int createTable(String databaseName, String tableName, String oldDatabaseName,String oldTableName) throws Exception;

}
