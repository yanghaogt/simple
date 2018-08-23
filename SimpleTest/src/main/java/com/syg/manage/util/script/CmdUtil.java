package com.syg.manage.util.script;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CmdUtil extends Thread {
	
	private final static Logger logger = LoggerFactory.getLogger(CmdUtil.class);
	
	public static List<String> cmd(String cmd){
		List<String> list = new ArrayList<>();
		try {
			logger.info("RUN CMD:"+cmd);
			List<String> list1 = xx(cmd);
			if(list1!=null)list.addAll(list1);
		} catch (Exception e) {
			logger.warn("RUN CMD ERROR: "+e.getMessage(),e);
		}
		return list;
	}
	
	private  static List<String> xx(String cmd) throws IOException, InterruptedException{
		Process proc = Runtime.getRuntime().exec(cmd);
		List<String> list = new ArrayList<>();
		CmdUtil errorGobbler = new CmdUtil(proc.getErrorStream(),"Error", list);
		CmdUtil outputGobbler = new CmdUtil(proc.getInputStream(),"Output", list);
		errorGobbler.start();
		outputGobbler.start();
		proc.getOutputStream().close();
		proc.waitFor();
		int state = proc.exitValue();
		logger.info("exitValue:"+state);
		return list;
	}
	
	InputStream is;
	String type;
	List<String> list;
	CmdUtil(InputStream is, String type, List<String> list) {
		this.is = is;
		this.type = type;
		this.list = list;
	}
	
	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is,"gbk");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (type.equals("Error")){
					System.out.println(line);
					list.add(line);
				}else{
					//System.out.println(line);//LogManager.logDebug(line);
					list.add(line);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			logger.warn("CMD RUN ERROR: "+ioe.getMessage(),ioe);
		}
	}
	
}