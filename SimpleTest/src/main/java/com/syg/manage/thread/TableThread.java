package com.syg.manage.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.syg.manage.util.table.TableSvs;

@Service
public class TableThread {

	private static final Logger logger=LoggerFactory.getLogger(TableThread.class);
	@Resource
	private TableSvs tableSvs;
	//轮询线程休眠时间
	private final static long interval = 1000*60*1L;
	
	@PostConstruct
	private void init(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						logger.info("=================createTable check===================");
						String databaseName = "test_hao";
						String oldDatabaseName = "test_hao";
						String gm_channel = "gm_channel";
						String gm_game_kind = "gm_game_kind";
						String gm_platform = "gm_platform";
						String[] array = new String[]{gm_channel, gm_game_kind, gm_platform};
						SimpleDateFormat fmt = new SimpleDateFormat("yyyyMM");
						String dateDay = fmt.format(new Date());
						for(String table:array){			
							try {
								tableSvs.createTable(databaseName, table +"_"+ dateDay, oldDatabaseName, table);
							} catch (Exception e) {
								e.printStackTrace();
								logger.error("{}",e);
							}
						}
						Thread.sleep(interval);
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("{}",e);
					}
				}
			}
		}).start();
	}
	
}
