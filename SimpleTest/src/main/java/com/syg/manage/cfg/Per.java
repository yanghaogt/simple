package com.syg.manage.cfg;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Per {
	NULL("无权限","0","",null),  
	ROOT("时光后台",PerStr.ROOT_MP_VALUE,"",null),
	//================================系统管理==============================
	PER_SYS					("系统管理",		PerStr.PER_SYS,	"",		ROOT),
	
	/**用户管理*/
	PER_SYS_USER			("用户管理",		PerStr.PER_SYS+"01",		"",	PER_SYS),
	// 用户信息
	PER_SYS_USER_PAGE		("用户列表",		PerStr.PER_SYS+"01"+"01",	"manage/userListPage",	PER_SYS_USER),
	PER_SYS_USER_ADD		("添加用户",		PerStr.PER_SYS+"01"+"02",	"",	PER_SYS_USER_PAGE),
	PER_SYS_USER_EDIT		("修改用户信息",	PerStr.PER_SYS+"01"+"03",	"",	PER_SYS_USER_PAGE),
	// 角色信息
	PER_SYS_ROLE_PAGE		("角色列表",		PerStr.PER_SYS+"02"+"01",	"manage/roleListPage",	PER_SYS_USER),
	PER_SYS_ROLE_ADD		("添加角色",		PerStr.PER_SYS+"02"+"02",	"",	PER_SYS_ROLE_PAGE),
	PER_SYS_ROLE_EDIT		("修改角色",		PerStr.PER_SYS+"02"+"03",	"",	PER_SYS_ROLE_PAGE),
	// 权限管理
	PER_SYS_PER_PAGE		("权限列表",		PerStr.PER_SYS+"03"+"01",	"manage/perListPage",	PER_SYS_USER),
	PER_SYS_PER_ADD			("添加权限",		PerStr.PER_SYS+"03"+"02",	"",	PER_SYS_PER_PAGE),
	PER_SYS_PER_EDIT		("修改权限",		PerStr.PER_SYS+"03"+"03",	"",	PER_SYS_PER_PAGE),
	/**日志记录*/
	PER_SYS_LOG				("日志记录",		PerStr.PER_SYS+"02",		"",	PER_SYS),
	// 登录日志
	PER_SYS_LOGINLOG_PAGE	("登录日志",		PerStr.PER_SYS+"04"+"01",	"manage/loginLogListPage",	PER_SYS_LOG),
	// 操作日志
	PER_SYS_OPERATELOG_PAGE	("操作记录",		PerStr.PER_SYS+"05"+"01",	"manage/operateLogListPage",	PER_SYS_LOG),
	//================================数据操作==============================
	PER_DATA				("数据操作",		PerStr.PER_DATA,	"",		ROOT),
	
	PER_DATA_LIST			("列表操作",		PerStr.PER_DATA+"01",		"",	PER_DATA),
	PER_DATA_LIST_PAGE		("数据列表",		PerStr.PER_DATA+"01"+"01",	"data/cdkeyListPage",	PER_DATA_LIST),
	PER_DATA_FIX_PAGE		("JSON列表",		PerStr.PER_DATA+"01"+"02",	"data/pointListPage",	PER_DATA_LIST),
	PER_DATA_MAP_PAGE		("MAP-列表",		PerStr.PER_DATA+"01"+"03",	"data/mapListPage",		PER_DATA_LIST),
	PER_DATA_EXPORT_PAGE	("导出列表",		PerStr.PER_DATA+"01"+"04",	"data/exportListPage",	PER_DATA_LIST),
	PER_DATA_IMPRORT_PAGE	("导入数据",		PerStr.PER_DATA+"01"+"05",	"data/importPage",		PER_DATA_LIST),
	PER_DATA_HOLIDAY_PAGE	("节假日",		PerStr.PER_DATA+"01"+"06",	"data/holidayListPage",	PER_DATA_LIST),
	PER_DATA_AJAX_PAGE		("AJAX分页",		PerStr.PER_DATA+"01"+"07",	"data/ajaxListPage",	PER_DATA_LIST),
	PER_DATA_LIST_CACHE		("缓存机制",		PerStr.PER_DATA+"01"+"08",	"data/cacheListPage",	PER_DATA_LIST),
	PER_DATA_LIST_REDIS		("REDIS缓存",	PerStr.PER_DATA+"01"+"09",	"data/redisListPage",	PER_DATA_LIST),
	PER_DATA_LIST_SWDB		("切换-DB",		PerStr.PER_DATA+"01"+"10",	"data/switchDBPage",	PER_DATA_LIST),
	PER_DATA_LIST_BATCH		("批量操作",		PerStr.PER_DATA+"01"+"11",	"data/batchListPage",	PER_DATA_LIST),
	
	PER_DATA_ANALYSIS		("数据解析",		PerStr.PER_DATA+"02",		"",	PER_DATA),
	PER_DATA_ANALYSIS_DATA	("数据解析",		PerStr.PER_DATA+"02"+"01",	"analysis/analysisListPage",	PER_DATA_ANALYSIS),
	
	PER_DATA_MAIL			("邮件发送",		PerStr.PER_DATA+"03",		"",	PER_DATA),
	PER_DATA_MAIL_SEND		("邮件发送",		PerStr.PER_DATA+"03"+"01",	"mail/mailListPage",	PER_DATA_MAIL),
	
	//================================功能列表==============================
	PER_FUNC				("功能列表",		PerStr.PER_FUNC,	"",		ROOT),
	
	PER_FUNC_LIST			("功能列表",		PerStr.PER_FUNC+"01",		"",	PER_FUNC),
	PER_FUNC_FILEVIEW_PAGE	("文件预览",		PerStr.PER_FUNC+"01"+"01",	"file/viewPage",	PER_FUNC_LIST),
	PER_FUNC_FILEAPPEND_PAGE("文件追加",		PerStr.PER_FUNC+"01"+"02",	"file/appendPage",	PER_FUNC_LIST),
	PER_FUNC_FILEUPLOAD_PAGE("文件上传",		PerStr.PER_FUNC+"01"+"03",	"file/uploadPage",	PER_FUNC_LIST),
	
	;
    private String code;
    private String name;
    private String pageUrl;
    private Per father;

    /**
     * 构造函数
     * @param name	权限名称
     * @param code	权限值
     * @param pageUrl 页面地址
     * @param father 父节点
     */
    private Per(String name,String code,String pageUrl,Per father) {
        this.name = name;
        this.code = code;
        this.pageUrl = pageUrl;
        this.father= father;
    }
    
    public String getCode() {
		return code;
	}
    public String getName() {
		return name;
	}
    public String getPageUrl() {
		return pageUrl;
	}
    public Per getFather() {
		return father;
	}
    
    public static void main(String[] args) {
    	//设置角色编号
    	int roleId=1;
    	
    	System.out.println("DELETE FROM manage_per;");
    	System.out.println("DELETE FROM manage_role_per;");
		
        Class<?> class1 = Per.class;
        Field[] fields = class1.getFields();
        for (int i = 0; i < fields.length; i++) {
        	if (Per.values()[i].getCode().equals("0")) {
				continue;
			}
        	System.out.println("INSERT INTO `manage_per` VALUES ('"+Per.values()[i].getName()+"', '"
        			+Per.values()[i].getCode()+"', '"
        			+(Per.values()[i].getFather()==null?"1":Per.values()[i].getFather().getCode())+"', '"
        			+Per.values()[i].getPageUrl()+"', '');");
		}
        
        for (int i = 0; i < fields.length; i++) {
        	if (Per.values()[i].getCode().equals("0")) {
				continue;
			}
			System.out.println("INSERT INTO `manage_role_per` VALUES ('"+i+"', '"+roleId+"', '"+Per.values()[i].getCode()+"');");
		}
	}
    
    public static List<Per> getAllPer(){
    	Class<?> class1 = Per.class;
        Field[] fields = class1.getFields();
        List<Per> perList = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
        	if (Per.values()[i].getCode().equals("0")) {
				continue;
			}
        	perList.add(Per.values()[i]);
        }
        return perList;
    }
    
    private static Map<Integer, Per> perMap = new HashMap<Integer, Per>();
	static {
		Class<?> pidClass = Per.class;
		Field[] fields = pidClass.getFields();
		for (int i = 0; i < fields.length; i++) {
			Integer key = Integer.valueOf(Per.values()[i].getCode());
			if (perMap.containsKey(key)) {
				throw new RuntimeException("Exist Enum Per!!!!!");
			}
			perMap.put(key, Per.values()[i]);
		}
		
	}

	public static Per find(Integer code) {
		return perMap.get(code);
	}
    public static Map<Integer, Per> getPerMap(){
    	return perMap;
    }
}





