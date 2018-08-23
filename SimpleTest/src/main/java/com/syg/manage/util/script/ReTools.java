package com.syg.manage.util.script;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReTools {
	
	private final static Logger logger = LoggerFactory.getLogger(ReTools.class);
	public static final String USER_DIR=System.getProperty("user.dir")+"/";
	/**
	 * 刷新服务器、渠道
	 */
	public static List<String> reGameServers(String toolName){
		String cmdStr = SlotPath.cmdScriptOpt(toolName);
		List<String> cmdList = cmd(cmdStr);
		logger.info("result："+cmdList);
		return cmdList;
	}
	
	public static List<String> test(){
		//String cmd = "cmd /c start 'D:\\Xshell 5\\Xshell.exe'";
//		String cmd = GlobalConfig.getDef().getValue("retool_url")+File.separator+GlobalConfig.getDef().getValue("retool_bat");
		String cmd = "D:/apache-tomcat-7.0.72/webapps/tool_work/update_test.bat";
		cmd = SlotPath.cmdScriptOpt(cmd);
		List<String> cmdList = cmd(cmd);
		logger.info("result："+cmdList);
		logger.info("USER_DIR："+USER_DIR);
		return cmdList;
	}
	
	/**
	 * 执行cmd
	 * @param cmd
	 * @return
	 */
	public static List<String> cmd(String cmd){
        return CmdUtil.cmd(cmd);
	}
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				test();
			}
		}).start();
	}
	
}
