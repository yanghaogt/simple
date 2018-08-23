package com.syg.manage.demo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {

	public static void getDay(){
		System.out.println("--------getDay------");
		Date date1 = DateUtil.getDay(-1, null);//一天前
		System.out.println("1天前："+date1);
		Date date7 = DateUtil.getDay(-7, null);//7天前
		System.out.println("7天前："+date7);
		Date date30 = DateUtil.getDay(-30, null);//30天前
		System.out.println("30天前："+date30);
	};
	
	public static void getDateTime() throws ParseException{
        System.out.println("--------getDateTime------");
        long time=DateUtil.getDay(-1, null).getTime();
        System.out.println("Date："+DateUtil.getDay(-1, null));
        System.out.println("long："+time);
	};
	
	public static void getMonthBeginEnd(){
		System.out.println("--------getMonthBeginEnd------");
		int year = Calendar.getInstance().get(Calendar.YEAR);//当前年份
		int month = Calendar.getInstance().get(Calendar.MONTH)+1;//当前月份
		Date begin = DateUtil.getDateByYearAndMonth(year, month-1);	//当前月份的开始
		Date end = DateUtil.AddMonth(begin, 1);//当前月份的结束
		System.out.println("年："+year+"\t月："+month);
		System.out.println("开始："+begin+"\n结束："+end);
	};
	
	public static void strToDate() throws ParseException{
		System.out.println("--------parStrToDate------");
		String dateStr = "2010/05/04 12:34:23";
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//format的格式要与日期String的格式相匹配  
        date = sdf.parse(dateStr);
        System.out.println("String："+dateStr);
        System.out.println("Date："+date.toString());
	};
	
	public static void dateToStr() throws ParseException{
		System.out.println("--------parDateToStr------");
		//format的格式可以任意
        String dateStr = "";
        Date date = new Date();
        System.out.println("Date："+date);
        DateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss");
    	dateStr = sdf1.format(date);
        System.out.println("String："+dateStr);
        dateStr = sdf2.format(date);
        System.out.println("String："+dateStr);
	};
	
	public static void stampToDate() throws ParseException{
		System.out.println("--------parStampToDate------");
        Long st = (long) 1501726361*1000;
        Timestamp tsts = new Timestamp(st);
        Date date = new Date();
        Long now = date.getTime();
    	date = tsts;
    	System.out.println("Long："+now);
    	System.out.println("Timestamp："+tsts);
        System.out.println("Date："+date);
	};
	
	public static void strToStamp() throws ParseException{
		System.out.println("--------parStrToStamp------");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String str = "2011-05-09 11:49:45";
        ts = Timestamp.valueOf(str);
        System.out.println("String："+str);
        System.out.println("Timestamp："+ts);
	};
	
	public static void longToDate() throws ParseException{
		System.out.println("--------parLongToDate------");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Long st = (long) 1501726361*1000;
        Date date= new Date(st);
        System.out.println("Long："+1493796021);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        System.out.println("Date："+sdf.format(date));
	};
	
	public static void dateToStamp(){
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    String time="2017-10-17 00:00:00";
			Date date = format.parse(time);
			System.out.print("dateToStamp:"+date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ParseException {
		getDay();
		getMonthBeginEnd();
		getDateTime();
		strToDate();
		dateToStr();
		stampToDate();
		strToStamp();
		longToDate();
		dateToStamp();
	}
}
