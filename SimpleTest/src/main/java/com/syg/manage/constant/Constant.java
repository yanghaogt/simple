package com.syg.manage.constant;

public class Constant {
	
	/**日志的操作类型*/
	public static class OperationType{
		public static final int NOTICE=1;//公告；
		public static final int MAIL  =2;//邮件；
		public static final int GS_REWAED_CONFIG=6;//GS账号奖励配置
		public static final int FORBID  =3;//3封禁,4禁言,5踢下线
		public static final int FORBID_TALK  =4;//禁言
		public static final int FORBID_KICK_OFFLINE  =5;//踢下线
		public static final int FORBID_DEVICE  =7;//封设备 封这个玩家记录的设备号
		public static final int FORBID_IP  =8;//封IP 封这个玩家记录的IP
		public static final int FORBID_DEVICEID  =9;//封设备号
		public static final int FORBID_YOUMI  = 901;//游密禁言
		public static final int FORBID_NO  =100;//已忽略
		public static final int FORBID_DEFAULT  =0;//未处理
		public static final int FORBID_CANCEL  =101;//已经解除
	}
	
	/**资源发送的状态*/
	public static class ApplyStatus{
		public static final int APPROVEING=0;//审核中
		public static final int PASS  =1;//审核通过
		public static final int NOPASS  =2;//审核未通过
		public static final int SENDED  =3;//已经发送
		public static final int CANCEL  =4;//申请人取消
		public static final int GAME_SERVER_HANDLE_FAILURE  =5;//游戏服务器处理失败
		public static final int NETERR  =6;//网络异常
		public static final int SINGLE = 11;//个别失败
		public static final int HALF = 12;//一半失败
		public static final int ALL = 13;//全部失败
	}
	
	/**资源发送的状态*/
	public static class SimulatePayType{
		public static final int ALL =0;//所有
		public static final int BD  =1;//补单
		public static final int GS  =2;//GS福利
		public static final int TB  =3;//淘宝

	}
	
	public static class PostCallName{
		public static final String PREFIX="zuichuanqi/gm/";
		public static final String GIFT_CARD_CREATE=PREFIX+"giftCardCreate";
		public static final String GIFT_CARD_STOP=PREFIX+"giftCardStop";
		public static final String FORBID=PREFIX+"forbid";							//封禁
		public static final String MAILE_SEND=PREFIX+"mailSend";
		public static final String NOTICE_SEND=PREFIX+"noticeSend";
		public static final String RESOURCE_SEND=PREFIX+"resourceSend";
		public static final String GET_ROLE_BASE_INFO=PREFIX+"getRoleBaseInfo";
		public static final String GET_ROLE_PACK_INFO=PREFIX+"getRoleBag";
		public static final String GS_ACCOUNT_SET=PREFIX+"gsAccountSet";
		public static final String GET_ROLE_BY_NAME=PREFIX+"getRoleIdByName";
		public static final String SIMULATE_PAY=PREFIX+"simulatePay";				//模拟充值
	}
	
}
