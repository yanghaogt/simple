package com.syg.manage.util.dataSource;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.syg.manage.dao.game.ActivityMapper;
import com.syg.manage.model.game.Activity;
import com.syg.manage.pagination.Pagination;
import com.syg.manage.util.ReflectHelper;

@Service
public class ActivitySvs{
	
	private final static Logger log = LoggerFactory.getLogger(ActivitySvs.class);
	@Resource
	ActivityMapper activityMapper;
	@Resource
	DefaultSqlSessionFactory gameSessionFactory;
	
	private DataSource getDataSource(Integer dsIndex){
		DataSource ds = DataSourceGroup.getDataSource(String.valueOf(dsIndex));
		return ds;
	}
	
	private void setDataSourceByDsIndex(Integer dsIndex){
		log.info("dataSource-index:{}",dsIndex);
		DataSource ds = getDataSource(dsIndex);
		log.info("dataSource:{}",ds);
		if(ds!=null){
			Environment ev = gameSessionFactory.getConfiguration().getEnvironment();
			try {
				ReflectHelper.setValueByFieldNameLoopUp(ev, "dataSource", ds);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Activity> select(Pagination page, Activity example, Integer dataSourceIndex) {
		setDataSourceByDsIndex(dataSourceIndex);
		return activityMapper.select(page, example, dataSourceIndex);
	}
	
	public List<Activity> select(Activity example, Integer dataSourceIndex) {
		setDataSourceByDsIndex(dataSourceIndex);
		return activityMapper.select(example, dataSourceIndex);
	}
	
}
