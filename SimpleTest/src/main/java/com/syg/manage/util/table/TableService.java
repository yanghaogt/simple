package com.syg.manage.util.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableService implements ITableService {
	
	private final static Logger logger = LoggerFactory.getLogger(TableService.class);
	private final static TableService instance = new TableService();
	private final static ThreadLocal<Connection> connectionCache = new ThreadLocal<Connection>();
	private final static  ThreadLocal<Statement>  statementCache = new ThreadLocal<Statement>();
	
	public Statement createStatement() throws SQLException{
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		connectionCache.set(conn);
		statementCache.set(stmt);
		return stmt;
	}
	
	public PreparedStatement prepareStatement(String sql) throws SQLException{
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		PreparedStatement stmt = conn.prepareStatement(sql);		
		connectionCache.set(conn);
		statementCache.set(stmt);
		return stmt;
	}
	
	public void closeResource(){
		Connection conn = connectionCache.get();
		Statement stmt = statementCache.get();
		try {
			if(stmt!=null&&(!stmt.isClosed()))
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null&&(!conn.isClosed()))
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static TableService getInstance(){
		return instance;
	}
	
	public void setConnection(Connection conn){
		connectionCache.set(conn);
	}
	
	public Connection getConnection(){
		return connectionCache.get();
	}
	
	public long getUniqueResultLong(String sql, Object... args)throws SQLException{				
		ResultSet rs = null;
		try {
			PreparedStatement  stmt = prepareStatement(sql);
			int index = 0;
			for(Object o:args){
				stmt.setObject(++index, o);
			}
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				Long id= rs.getLong(1);
				return id;
			}		
		}finally{	
			closeResource();		
		}
		return 0;
	}
	
	public long getUniqueResultLong(String sql)throws SQLException{				
		ResultSet rs = null;
		try {
			PreparedStatement  stmt = prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				Long id= rs.getLong(1);
				return id;
			}		
		}finally{	
			closeResource();		
		}
		return 0;
	}
	
	
	public  int executeUpdate(String sql, Object... args) throws SQLException{
		try {
			PreparedStatement  stmt = prepareStatement(sql);
			int index = 0;
			for(Object o:args){
				stmt.setObject(++index, o);
			}
			int out = stmt.executeUpdate(sql);
			stmt.getConnection().commit();
			return out;		
		}finally{
			closeResource();
		}
	}
	
	public  int executeUpdate(String sql) throws SQLException{
		try {
			PreparedStatement  stmt = prepareStatement(sql);
			int out = stmt.executeUpdate(sql);
			stmt.getConnection().commit();
			return out;		
		}finally{
			closeResource();
		}
	}

	public static String getSelectTableCountSql(String databaseName, String tableName){
		return SELETE_TABLE_COUNT_SQL.replace(DATABASE_NAME, databaseName).replace(TABLE_NAME, tableName);
	}
	
	public static String getCreateTableSql(String databaseName, String tableName ,String targetDatabaseName, String targetTableName){
		StringBuilder s = new StringBuilder("create table `");
		s.append(databaseName).append("`.`")
		 .append(tableName).append("` like `")
		 .append(targetDatabaseName).append("`.`")
		 .append(targetTableName).append("`");
		String out =s.toString();
		logger.info(out);
		return out;
	}
	
	public int getTableCount(String databaseName, String tableName) throws Exception {
		return Long.valueOf(getUniqueResultLong(getSelectTableCountSql(databaseName, tableName))).intValue();
	}

	public int createTable(String databaseName, String tableName, String targetDatabaseName, String targetTableName) throws Exception{
		return executeUpdate(getCreateTableSql(databaseName, tableName, targetDatabaseName, targetTableName));
	}
	
	public static void main(String[] args) {
		String databaseName = "time_platform";
		String oldDatabaseName = "time_platform";
		String tableName = "nomarl_account";
		String oldTableName = "nomarl_account2";
		System.out.println(getSelectTableCountSql(databaseName, tableName));
		System.out.println(getCreateTableSql(databaseName, tableName, oldDatabaseName, oldTableName));
	}

}
