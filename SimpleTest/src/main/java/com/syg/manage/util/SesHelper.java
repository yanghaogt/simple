package com.syg.manage.util;

import javax.servlet.http.HttpSession;

import com.syg.manage.model.entity.SesUser;

public class SesHelper {
	public static String SESSION_USER="session_user_yjlc";
	public static String CURR_GAME="curr_game";
	public static String GAME_LIST="game_list";
	public static String PLAT_LIST="plat_list";
	public static String CHAN_LIST="chan_list";
	public static String INDEX_SETTING ="index_setting";
	
	public static SesUser getSimUser(HttpSession ses){
		SesUser userInfo = (SesUser)ses.getAttribute(SESSION_USER);		
		return userInfo;
	}
	
	public static void setSimUser(HttpSession ses,SesUser userInfo){
		ses.setAttribute(SESSION_USER, userInfo);
	}
	
	public static Integer getCurrGame(HttpSession ses){
		Integer currGame = (Integer)ses.getAttribute(CURR_GAME);		
		return currGame;
	}
	
	public static void setCurrGame(HttpSession ses,Integer currGame){
		ses.setAttribute(CURR_GAME, currGame);
	}
	
	public static String getIndexSetting(HttpSession ses){
		String str = (String)ses.getAttribute(INDEX_SETTING);		
		return str;
	}
	
	public static void setIndexSetting(HttpSession ses,String str){
		ses.setAttribute(INDEX_SETTING, str);
	}
}
