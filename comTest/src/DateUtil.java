

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 比较是否同一�?
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
	
	
	public static int daySub(Date dateA,Date dateB){
		Calendar caA = Calendar.getInstance();
		caA.setTime(dateA);
		caA.set(Calendar.HOUR, -12);
		caA.set(Calendar.MINUTE, 0);
		caA.set(Calendar.SECOND, 0);
		caA.set(Calendar.MILLISECOND, 0);
		
		
		Calendar caB = Calendar.getInstance();
		caB.setTime(dateB);
		caB.set(Calendar.HOUR, -12);
		caB.set(Calendar.MINUTE, 0);
		caB.set(Calendar.SECOND, 0);
		caB.set(Calendar.MILLISECOND, 0);
		
		int day = Long.valueOf((caA.getTimeInMillis()-caB.getTimeInMillis())/86400000L).intValue(); 
		return day;
	}
	
	/**
	 * 获取周开始结�?
	 * @param week
	 * @param day
	 * @param date
	 * @return 周几的日�?
	 */
	public static Date getWeek(int week,int day,Date date){
		 Calendar cal = Calendar.getInstance();
		 if(date != null){
			 cal.setTime(date);
		 }
		  //n为推迟的周数�?本周�?1向前推迟�?���?下周，依次类�?
		 cal.add(Calendar.DATE, week*7-1);
		  //想周几，这里就传几Calendar.MONDAY（TUESDAY...�?
		 cal.set(Calendar.DAY_OF_WEEK,day);
		 cal.set(Calendar.HOUR, 0);
		 cal.set(Calendar.MINUTE, 0);
		 cal.set(Calendar.SECOND, 0);
		 cal.set(Calendar.MILLISECOND, 0);
		 return cal.getTime();		
	}
	
	/**
	 * 获取几天前或几天�?
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
	
	
}
