package com.syg.manage.job;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.syg.manage.util.table.TableSvs;

@Service
public class CreateTableJob{
	
	private static final Logger logger=LoggerFactory.getLogger(CreateTableJob.class);
	@Resource
	private TableSvs tableSvs;
	
	public void createTable() {
		try {
			tableSvs.createTable();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
}
