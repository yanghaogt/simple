package com.syg.manage.util.script;

import java.io.File;

import com.syg.manage.cfg.GlobalConfig;
public class SlotPath {
	/**脚本格式选择*/
	public static String cmdSuffix(){												return OSinfo.isWindows() ? ".bat" : ".sh";}
	/**脚本命令执行处理，并对目录作简单处理*/
	public static String cmdScriptOpt(String cmd){									return OSinfo.isWindows() ? cmd.replaceAll("/", "\\\\") : "sh "+cmd;}
	
	public static String ROOT(){													return GlobalConfig.getDef().getValue("slot_web_apps");}
	/**临时目录*/
	public static String TEMP_ROOT(){												return ROOT()+GlobalConfig.getDef().getValue("slot_temp_root");}
	public static String TEMP_APP(int appId,int ovId){								return TEMP_ROOT()+File.separator+"gm_"+appId+"_ver_"+ovId;}
	public static String TEMP_PKG(int appId,int pcId){								return TEMP_ROOT()+File.separator+"gm_"+appId+"_p_c_"+pcId;}
	
}
