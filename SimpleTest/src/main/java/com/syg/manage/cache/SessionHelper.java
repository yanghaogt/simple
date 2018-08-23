package com.syg.manage.cache;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.syg.manage.model.manage.GmChannel;
import com.syg.manage.model.manage.GmGameKind;
import com.syg.manage.model.manage.GmPlatform;


public class SessionHelper {
	
	
	public static String SESSION_USER="session_user";
	public static String CURR_GAME="curr_game";
	public static String GAME_LIST="game_list";
	public static String PLAT_LIST="plat_list";
	public static String CHAN_LIST="chan_list";
	
	public static Integer getCurrGame(HttpSession ses){
		Integer currGame = (Integer)ses.getAttribute(CURR_GAME);		
		return currGame;
	}
	
	public static void setCurrGame(HttpSession ses,Integer currGame){
		ses.setAttribute(CURR_GAME, currGame);
	}
	
	public static List<GmGameKind> getGameList(HttpSession ses){
		List<GmGameKind> list = (List<GmGameKind>)ses.getAttribute(GAME_LIST);		
		return list;
	}
	
	public static void setGameList(HttpSession ses,List<GmGameKind> list){
		ses.setAttribute(GAME_LIST, list);
	}
	
	public static List<GmPlatform> getPlatList(HttpSession ses){
		List<GmPlatform> list = (List<GmPlatform>)ses.getAttribute(PLAT_LIST);		
		return list;
	}
	
	public static void setPlatList(HttpSession ses,List<GmPlatform> list){
		ses.setAttribute(PLAT_LIST, list);
	}
	
	public static List<GmChannel> getChanList(HttpSession ses){
		List<GmChannel> list = (List<GmChannel>)ses.getAttribute(CHAN_LIST);		
		return list;
	}
	
	public static void setChanList(HttpSession ses,List<GmChannel> list){
		ses.setAttribute(CHAN_LIST, list);
	}
	
}
