package com.syg.manage.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	
//	private static SimpleDateFormat sdfDate = new SimpleDateFormat();
	
	/**
	 * 比较是否同一天
	 * @param dateA
	 * @param dateB
	 * @return
	 */
	public static boolean areSameDay(Date dateA,Date dateB) {
	    Calendar calDateA = Calendar.getInstance();
	    calDateA.setTime(dateA);

	    Calendar calDateB = Calendar.getInstance();
	    calDateB.setTime(dateB);

	    return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
	            && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
	            &&  calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);
	}
	
	public static Date todayTimeZero(){
		return timeZeroDate(0);
	}
	public static Date yestodayTimeZero(){
		return timeZeroDate(-1);
	}
	public static Date tomorrowTimeZero(){
		return timeZeroDate(1);
	}
	
	private static Date timeZeroDate(int day){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.HOUR, -12);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		ca.set(Calendar.MILLISECOND, 0);
		ca.add(Calendar.DATE, day);
		return ca.getTime();
	}
	
	public static Date AddDay(Date date , int day){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.DAY_OF_MONTH, day);
		return ca.getTime();
	}
	
	/**
	 * 计算两个日期相差的天数精确到日，dateA-dateB
	 * @param dateA
	 * @param dateB
	 * @return
	 */
	public static int daySub(Date dateA,Date dateB){
		Calendar caA = Calendar.getInstance();
		caA.setTime(dateA);
		caA.set(Calendar.HOUR_OF_DAY, 0);
		caA.set(Calendar.MINUTE, 0);
		caA.set(Calendar.SECOND, 0);
		caA.set(Calendar.MILLISECOND, 0);
		
		Calendar caB = Calendar.getInstance();
		caB.setTime(dateB);
		caB.set(Calendar.HOUR_OF_DAY, 0);
		caB.set(Calendar.MINUTE, 0);
		caB.set(Calendar.SECOND, 0);
		caB.set(Calendar.MILLISECOND, 0);
		
		int day = Long.valueOf((caA.getTimeInMillis()-caB.getTimeInMillis())/86400000L).intValue(); 
		return day;
	}
	/**
	 * 字符串转为日期格式
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date stringFormatDate(String dateString){
		try {
			SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = bartDateFormat.parse(dateString);
			return date;
		} catch (Exception e) {
			throw new RuntimeException("日期类型转换错误");
		}
	}

	/**
	 * 字符串转为日期格式
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date stringFormatDateTime(String dateString){
		try{
			SimpleDateFormat bartDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date date = bartDateFormat.parse(dateString);
			return date;
		} catch (Exception e) {
			throw new RuntimeException("日期类型转换错误");
		}
	}
	
	public static Date stringFormatYMDHMDateTime(String dateString){
		try{
			SimpleDateFormat bartDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm");
			Date date = bartDateFormat.parse(dateString);
			return date;
		} catch (Exception e) {
			throw new RuntimeException("日期类型转换错误");
		}
	}

	/**
	 * 将时间格式化为含时分秒的字符串
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String dateTimeFormatString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String dateFormatString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	
	public static String dateMMDDFormatString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
		return dateFormat.format(date);
	}
	
	public static String dateHMFormatString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		return dateFormat.format(date);
	}
	
	public static String dateYMDHMFormatString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		return dateFormat.format(date);
	}

	/**
	 * 将时间格式化为含时分秒的字符串 24小时进制
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String date24HourFormatString(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String greenwichMeanTime(Date date) {
		String strExpriseDate = date.toString();
		String[] strExpriseDates = strExpriseDate.split(" ");
		String stringDate = strExpriseDates[0] + ", " + strExpriseDates[2]
				+ " " + strExpriseDates[1] + " " + strExpriseDates[5] + " "
				+ strExpriseDates[3] + " GMT";
		return stringDate;
	}

	public static Date getTheDayOfEndTime(String dateString ) throws ParseException {
		Date date = null;
		if(dateString.contains(" ")){
			date = stringFormatDateTime(dateString);
		}else{
			date = stringFormatDate(dateString);
		}
		return getTheDayOfEndTime(date);
	}
	
	public static Date getTheDayOfEndTime(Date date) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	
	public static Date getTheDayOfStartTime(String dateString ) throws ParseException {
		Date date = null;
		if(dateString.contains(" ")){
			date = stringFormatDateTime(dateString);
		}else{
			date = stringFormatDate(dateString);
		}
		return getTheDayOfStartTime(date);
	}
	
	/**
	 * 获取一天的开始时间
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getTheDayOfStartTime(Date date) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	public static String getStringHour(String date){
		return date.substring(date.indexOf(" ")+1);
	}
	
	/**
	 * 获取周开始结束
	 * @param week
	 * @param day
	 * @param date
	 * @return 周几的日期
	 */
	public static Date getWeek(int week,int day,Date date){
		 Calendar cal = Calendar.getInstance();
		 if(date != null){
			 cal.setTime(date);
		 }
		  //n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
		 cal.add(Calendar.DATE, week*7-1);
		  //想周几，这里就传几Calendar.MONDAY（TUESDAY...）
		 cal.set(Calendar.DAY_OF_WEEK,day);
		 cal.set(Calendar.HOUR, 0);
		 cal.set(Calendar.MINUTE, 0);
		 cal.set(Calendar.SECOND, 0);
		 cal.set(Calendar.MILLISECOND, 0);
		 return cal.getTime();		
	}
	
	/**
	 * 获取几天前或几天后
	 * @param day
	 * @param date
	 * @return 日期
	 */
	public static Date getDay(int day, Date date){
		Calendar cal = Calendar.getInstance();
		if(date != null){
			 cal.setTime(date);
		 }
		 cal.add(Calendar.DATE, day);
		 cal.set(Calendar.HOUR, 0);
		 cal.set(Calendar.MINUTE, 0);
		 cal.set(Calendar.SECOND, 0);
		 cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
		w = 0;
		return weekDays[w];
	}
	
	public static int getWeekIndexOfDate(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
		w = 0;
		return w;
	}
	
	/**
	 * 获取日期的天
	 * @param date
	 * @return
	 */
	public static int getDateDay(Date date){
		Calendar cal = Calendar.getInstance();
		if(date != null){
			 cal.setTime(date);
		 }
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 增加月份，亦可减少
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date AddMonth(Date date , int month){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.MONTH, month);
		return ca.getTime();
	} 
	
	/**
	 * 获取某个日期的当月第一天
	 * @return
	 */
	public static Date getDateMonthFirstDate(Date date){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DAY_OF_MONTH,1);
		return ca.getTime();
	}
	/**
	 * 判断给定日期是否为月末的一天
	 * @param date
	 * @return
	 */
	public static boolean isLastDayOfMonth(Date date) { 
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date); 
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1)); 
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) { 
            return true; 
        } 
        return false; 
    } 
	
	/**
	 * 获取给定日期的的月末
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
	}
	
	public static Date AddMinute(Date date , int minute){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.MINUTE, minute);
		return ca.getTime();
	}
	
	/**
	 * 打印时间段日期（年-月-日） 
	 */
	 public static List<Date> findDates(Date dBegin, Date dEnd)
	 {
	  List<Date> lDate = new ArrayList<Date>();
	  lDate.add(dBegin);
	  Calendar calBegin = Calendar.getInstance();
	  // 使用给定的 Date 设置此 Calendar 的时间
	  calBegin.setTime(dBegin);
	  Calendar calEnd = Calendar.getInstance();
	  // 使用给定的 Date 设置此 Calendar 的时间
	  calEnd.setTime(dEnd);
	  // 测试此日期是否在指定日期之后
	  while (dEnd.after(calBegin.getTime()))
	  {
	   // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
	   calBegin.add(Calendar.DAY_OF_MONTH, 1);
	   lDate.add(calBegin.getTime());
	  }
	  return lDate;
	 } 
	 
	 /**
	  * 
	  * @param year
	  * @param month 0-11 如：一月传0
	  * @return
	  */
	 public static Date getDateByYearAndMonth(int year, int month){
		 Calendar calendar = Calendar.getInstance();  
	     calendar.set(Calendar.YEAR, year);
	     calendar.set(Calendar.MONTH, month);
	     calendar.set(Calendar.DAY_OF_MONTH, 1);
	     calendar.set(Calendar.HOUR, 0);
	     calendar.set(Calendar.MINUTE, 0);
	     calendar.set(Calendar.SECOND, 0);
	     calendar.set(Calendar.MILLISECOND, 0);
		 return calendar.getTime();
	 }
	 
	public static void main(String[] args) {
//		System.out.println(daySub(stringFormatDateTime("2015-06-29 00:00:00"), stringFormatDateTime("2015-06-30 23:59:59")));
	//	String s = "2017-02-14";
	//	String e = "2017-02-07";
		//System.out.println();
		//System.out.println();
	//	System.out.println(daySub(stringFormatDate(s),new Date()));
		Date a = new Date();
	/*	Calendar ca = Calendar.getInstance();
		ca.setTime(a);
		System.out.println(Calendar.MONTH);*/
		Date b = DateUtil.AddDay(a, 1);
		System.out.println(DateUtil.daySub(b, b));

		
	}
}
